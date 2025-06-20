package com.googlecode.dummyjdbc.utils;

import com.googlecode.dummyjdbc.resultset.DummyResultSetMetaData;
import com.googlecode.dummyjdbc.resultset.impl.CSVResultSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MemoryStorage {
    private static volatile MemoryStorage instance = null;

    private CSVResultSet resultSet;

    private List<String> columnTypes;

    private List<String> columnNames;

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATEFORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat(DATE_FORMAT));

    private MemoryStorage() {
        if(instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
        loadFromFile();
    }

    public void loadFromFile() {
        String filePath = System.getenv("CSV_FILE_PATH");
        int firstNumber = 0;
        List<Map<String, Object>> entries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read the first line - how many times the data should be repeatedly returned
            String line = br.readLine();
            if (line != null) {
                firstNumber = Integer.parseInt(line.trim());
            }

            // Read the second line - column names and infer their types
            line = br.readLine();
            if (line != null) {
                columnNames = Arrays.asList(line.split("\\|"));
            }

            columnTypes = new ArrayList<>();
            for(String header: columnNames) {
                columnTypes.add(header.split("_")[0]);
            }

            // Read table data
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");
                Map<String, Object> rowMap = new HashMap<>();

                for (int i = 0; i < columnTypes.size(); i++) {
                    String key = columnNames.get(i);
                    String value = i < values.length ? values[i] : "";
                    Object parsedValue = parseValue(value, columnTypes.get(i));
                    rowMap.put(key, parsedValue);
                }

                entries.add(rowMap);
            }


            DummyResultSetMetaData metaData = new DummyResultSetMetaData("mock", columnTypes.toArray(new String[0]), columnNames.toArray(new String[0]));
            resultSet = new CSVResultSet("mock", metaData, entries, firstNumber);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to open file at location: " + filePath);
        }
    }

    private Object parseValue(String value, String type) throws SQLException {
        type = type.trim();
        value = value.replaceAll("\\.0$", "");

        if (value.isEmpty()) return null;

        if (type.equals("varchar")) return value;
        if (type.equals("integer")) return Integer.parseInt(value);
        if (type.equals("double")) return Double.parseDouble(value);
        if (type.equals("date")) return parseDate(value);
        if (type.equals("decimal")) return parseDecimal(value);

        return value;
    }

    public static MemoryStorage getInstance() {

        if(instance == null) {
            synchronized (MemoryStorage.class) {
                if (instance == null) {
                    instance = new MemoryStorage();
                }
            }
        }
        return instance;
    }

    public CSVResultSet getResultSet() {
        return this.resultSet;
    }

    public List<String> getColumnTypes() {
        return columnTypes;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    private java.sql.Date parseDate(String string) throws SQLException {
        DateFormat sdf = THREAD_LOCAL_DATEFORMAT.get();
        java.sql.Date date;
        try {
            java.util.Date utilDate = sdf.parse(string);
            date = new java.sql.Date(utilDate.getTime());

        } catch (ParseException e) {
            String message = MessageFormat.format("Could not parse date: ''{0}'' using format ''{1}''", string,
                    DATE_FORMAT);
            throw new SQLException(message, e);
        }
        return date;
    }

    private BigDecimal parseDecimal(String string)
    {
        BigDecimal value = new BigDecimal(string);
        BigDecimal scaled = value.setScale(2, RoundingMode.FLOOR);
        return scaled;
    }
}
