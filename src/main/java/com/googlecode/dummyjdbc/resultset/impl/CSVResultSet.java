package com.googlecode.dummyjdbc.resultset.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.googlecode.dummyjdbc.resultset.DummyResultSet;
import com.googlecode.dummyjdbc.resultset.DummyResultSetMetaData;

/**
 * The {@link CSVResultSet} which iterates over the CSV file data.
 *
 * @author Kai Winter
 */
public class CSVResultSet extends DummyResultSet {

	/**
	 * The date format for parsing a date from a CSV file.
	 */
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATEFORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat(DATE_FORMAT));

	/** Table schema */
    private final DummyResultSetMetaData metaData;

	/** Column name 2 column value. */
	private final List<Map<String, Object>> dummyData;

	/** The current value of the iterator. */

	private Map<String, Object> currentEntry;
	private Iterator<Map<String, Object>> iterator;

	private final String tableName;
	private final int iterations;

	private int remIterations;

	private Object lastVal;

	private final String[] columns;

	/**
	 * Constructs a new {@link CSVResultSet}.
	 *
	 * @param tableName
	 *            the name of the table this {@link CSVResultSet} stands for.
	 *
     * @param metaData
     *            the table schema.
	 *
	 * @param entries
	 *            Collection of entries from the CSV file. Each {@link LinkedHashMap} maps column name to column value.
	 */
	public CSVResultSet(String tableName, DummyResultSetMetaData metaData, List<Map<String, Object>> entries) {
		this.tableName = tableName;
		this.metaData = metaData;
		this.dummyData = entries;
		this.iterator = entries.listIterator();
		this.columns = metaData.getColumnNames();
		this.iterations = 0;
		this.remIterations = 0;
	}

	public CSVResultSet(String tableName, DummyResultSetMetaData metaData, List<Map<String, Object>> entries, int iterations) {
		this.tableName = tableName;
		this.metaData = metaData;
		this.dummyData = entries;
		this.iterator = entries.listIterator();
		this.columns = metaData.getColumnNames();
		this.iterations = iterations;
		this.remIterations = iterations;
	}

	@Override
	public boolean next() throws SQLException {
		if (iterator.hasNext()) {
			currentEntry = iterator.next();
			return true;
		} else if (remIterations > 0) {
			iterator = dummyData.iterator();
			currentEntry = iterator.next();
			remIterations -= 1;
			return true;
		}

		return false;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return this.metaData;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		Object value = getValueForColumnIndex(columnIndex, String.class);
		lastVal = value;
		return (String) value;
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		Object value = getValueForColumnIndex(columnIndex, Boolean.class);
		lastVal = value;
		if (value == null) {
			return false;
		}
		return (boolean) value;
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
		Object value = getValueForColumnIndex(columnIndex, Integer.class);
		lastVal = value;
		if (value == null) {
			return 0;
		}
		return (int) value;
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		Object value = getValueForColumnIndex(columnIndex, BigDecimal.class);
		lastVal = value;

		if (value == null){
			return BigDecimal.valueOf(0);
		}

		return (BigDecimal) value;
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		Object value = getValueForColumnLabel(columnLabel, BigDecimal.class);
		lastVal = value;

		if (value == null){
			return BigDecimal.valueOf(0);
		}

		return (BigDecimal) value;
	}

	@Override
	public String getString(String columnLabel) throws SQLException {
		Object string = getValueForColumnLabel(columnLabel, String.class);
		lastVal = string;

		return (String) string;
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException {
		Object string = getValueForColumnLabel(columnLabel, Boolean.class);
		lastVal = string;

		return (boolean) string;
	}

	@Override
	public int getInt(String columnLabel) throws SQLException {
		Object string = getValueForColumnLabel(columnLabel, Integer.class);
		lastVal = string;

		return (int) string;
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException {
		Object value = getValueForColumnIndex(columnIndex, Date.class);

		return parseDate(value);
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException {
		Object value = getValueForColumnLabel(columnLabel, Date.class);

		return parseDate(value);
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		return getDate(columnIndex);
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		Object value = getValueForColumnIndex(columnIndex, Integer.class);
		lastVal = value;
		if (value == null) {
			return 0;
		}
		return (double) value;
	}


	@Override
	public void close() throws SQLException {
		this.iterator = dummyData.iterator();
		remIterations = iterations;
	}

	@Override
	public boolean wasNull() throws SQLException {
		return lastVal == null;
	}

	private Date parseDate(Object value) throws SQLException {
		if (value == null) {
			lastVal = null;
			return null;
		}
		DateFormat sdf = THREAD_LOCAL_DATEFORMAT.get();
		Date date;
		try {
			java.util.Date utilDate = sdf.parse(value.toString());
			date = new Date(utilDate.getTime());

		} catch (ParseException e) {
			String message = MessageFormat.format("Could not parse date: ''{0}'' using format ''{1}''", value.toString(),
					DATE_FORMAT);
			throw new SQLException(message, e);
		}
		lastVal = date;
		return date;
	}

	private Object getValueForColumnIndex(int columnIndex, Class<?> clazz) throws SQLException {

		if (columnIndex > columns.length) {
			String message = MessageFormat.format(
					"Column index {0} does not exist in table file ''{1}'' (type ''{2}'')", columnIndex, tableName,
					clazz);
			throw new SQLException(message);
		}

		return currentEntry.get(columns[columnIndex - 1]);
	}

	private Object getValueForColumnLabel(String columnLabel, Class<?> clazz) throws SQLException {
		if (!currentEntry.containsKey(columnLabel.toUpperCase())) {
			String message = MessageFormat.format("Column ''{0}'' does not exist in table file ''{1}'' (type ''{2}'')",
					columnLabel, tableName, clazz);
			throw new SQLException(message);
		}

		return currentEntry.get(columnLabel.toUpperCase());
	}

}
