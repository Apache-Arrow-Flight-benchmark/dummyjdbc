package com.googlecode.dummyjdbc.statement.impl;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

import com.googlecode.dummyjdbc.resultset.impl.CSVResultSet;
import com.googlecode.dummyjdbc.utils.MemoryStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.dummyjdbc.statement.StatementAdapter;

/**
 * This class does the actual work of the Generic... classes. It tries to open a CSV file for the table name in the
 * query and parses the contained data.
 *
 * @author Kai Winter
 */
public final class CsvStatement extends StatementAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CsvStatement.class);

	/** Pattern to get table name from an SQL statement. */
	private static final Pattern TABLENAME_PATTERN = Pattern.compile(".*from (\\S*)\\s?.*", Pattern.CASE_INSENSITIVE);

	/** Pattern to get the name of a stored procedure from an SQL statement. */
	private static final Pattern STORED_PROCEDURE_PATTERN = Pattern.compile(".*(EXEC|EXECUTE) (\\S*)\\s?.*",
			Pattern.CASE_INSENSITIVE);

	private static final Pattern PURE_SELECT_PATTERN = Pattern.compile("select .*", Pattern.CASE_INSENSITIVE);

    private final Map<String, File> tableResources;

	/**
	 * Constructs a new {@link CsvStatement}.
	 *
	 * @param tableResources
	 *            {@link Map} of table name to CSV file.
	 */
	public CsvStatement(Map<String, File> tableResources) {
		this.tableResources = tableResources;
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {

		return MemoryStorage.getInstance().getResultSet();
	}
}
