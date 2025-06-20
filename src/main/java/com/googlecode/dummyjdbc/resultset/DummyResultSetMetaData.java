package com.googlecode.dummyjdbc.resultset;

import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

/**
 * Implementation of {@link ResultSetMetaData} which returns default values.
 *
 * @author WhatAKitty
 **/
public class DummyResultSetMetaData implements ResultSetMetaData {

    private enum DataType {
        VARCHAR(Types.VARCHAR, String.class),
        INTEGER(Types.INTEGER, Integer.class),
        DOUBLE(Types.DOUBLE, Double.class),
        DATE(Types.DATE, Date.class),
        TIME(Types.TIME, Date.class),
        TIMESTAMP(Types.TIMESTAMP, Date.class),
        DECIMAL(Types.DECIMAL, BigDecimal.class);

        private final int sqlType;
        private final Class<?> clazz;

        DataType(int sqlType, Class<?> clazz) {
            this.sqlType = sqlType;
            this.clazz = clazz;
        }

        public static DataType fromString(String spec) {
            return valueOf(spec.toUpperCase());
        }
    }

    private static final int DEFAULT_COLUMN_PRECISION = 60;
    private static final int DEFAULT_COLUMN_SCALE = 0;
    private final String tableName;

    public String[] getColumnNames() {
        return columnNames;
    }

    private final String[] columnNames;
    private final List<Map.Entry<String, DataType>> columnTypes = new ArrayList<>();

    public DummyResultSetMetaData(String tableName, String[] columnSpecs, String[] columnNames) {
        for (String columnSpec : columnSpecs) {
            String[] specElems = Objects.requireNonNull(columnSpec.trim().toUpperCase(), "Header must be specified").split("\\s*\\|\\s*");
            DataType dt = DataType.fromString(specElems[0]);
            columnTypes.add(new AbstractMap.SimpleEntry<>(specElems[0], dt));
        }
        this.columnNames = columnNames;
        this.tableName = tableName;
    }

    @Override
    public int getColumnCount() throws SQLException {
        return columnTypes.size();
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        throw new UnsupportedOperationException("isAutoIncrement");

    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        throw new UnsupportedOperationException("isSearchable");

    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        throw new UnsupportedOperationException("isCurrency");

    }

    @Override
    public int isNullable(int column) throws SQLException {
        return ResultSetMetaData.columnNullable;

    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        int type = getColumnType(column);
        return type == DataType.DOUBLE.sqlType || type == DataType.INTEGER.sqlType || type == DataType.DECIMAL.sqlType;

    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        return 1000;

    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        return getColumnName(column);
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        return columnNames[column - 1];
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return "";
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        int type = getColumnType(column);
        if (type == DataType.DECIMAL.sqlType){
            return 7;
        }
        return DEFAULT_COLUMN_PRECISION;
    }

    @Override
    public int getScale(int column) throws SQLException {
        int type = getColumnType(column);
        if (type == DataType.DECIMAL.sqlType){
            return 2;
        }
        return DEFAULT_COLUMN_SCALE;
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return tableName;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        throw new UnsupportedOperationException("getCatalogName");

    }

    @Override
    public int getColumnType(int column) throws SQLException {
        return columnTypes.get(column - 1).getValue().sqlType;
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        return columnTypes.get(column - 1).getValue().name();
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return true;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        throw new UnsupportedOperationException("isDefinitelyWritable");

    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        return columnTypes.get(column - 1).getValue().clazz.getName();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException("unwrap");

    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException("isWrapperFor");

    }
}
