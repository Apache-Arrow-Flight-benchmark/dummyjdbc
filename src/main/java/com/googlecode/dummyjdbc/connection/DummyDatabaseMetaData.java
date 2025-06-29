package com.googlecode.dummyjdbc.connection;

import com.googlecode.dummyjdbc.resultset.impl.CSVResultSet;
import com.googlecode.dummyjdbc.utils.MemoryStorage;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.util.*;

public class DummyDatabaseMetaData implements DatabaseMetaData {

    @Override public boolean allProceduresAreCallable() throws SQLException {
        return false;
    }

    @Override public boolean allTablesAreSelectable() throws SQLException {
        return false;
    }

    @Override public String getURL() throws SQLException {
        return null;
    }

    @Override public String getUserName() throws SQLException {
        return null;
    }

    @Override public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override public boolean nullsAreSortedHigh() throws SQLException {
        return false;
    }

    @Override public boolean nullsAreSortedLow() throws SQLException {
        return false;
    }

    @Override public boolean nullsAreSortedAtStart() throws SQLException {
        return false;
    }

    @Override public boolean nullsAreSortedAtEnd() throws SQLException {
        return false;
    }

    @Override public String getDatabaseProductName() throws SQLException {
        return null;
    }

    @Override public String getDatabaseProductVersion() throws SQLException {
        return null;
    }

    @Override public String getDriverName() throws SQLException {
        return null;
    }

    @Override public String getDriverVersion() throws SQLException {
        return null;
    }

    @Override public int getDriverMajorVersion() {
        return 0;
    }

    @Override public int getDriverMinorVersion() {
        return 0;
    }

    @Override public boolean usesLocalFiles() throws SQLException {
        return false;
    }

    @Override public boolean usesLocalFilePerTable() throws SQLException {
        return false;
    }

    @Override public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean storesUpperCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean storesLowerCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean storesMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override public String getIdentifierQuoteString() throws SQLException {
        return null;
    }

    @Override public String getSQLKeywords() throws SQLException {
        return null;
    }

    @Override public String getNumericFunctions() throws SQLException {
        return null;
    }

    @Override public String getStringFunctions() throws SQLException {
        return null;
    }

    @Override public String getSystemFunctions() throws SQLException {
        return null;
    }

    @Override public String getTimeDateFunctions() throws SQLException {
        return null;
    }

    @Override public String getSearchStringEscape() throws SQLException {
        return null;
    }

    @Override public String getExtraNameCharacters() throws SQLException {
        return null;
    }

    @Override public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return false;
    }

    @Override public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return false;
    }

    @Override public boolean supportsColumnAliasing() throws SQLException {
        return false;
    }

    @Override public boolean nullPlusNonNullIsNull() throws SQLException {
        return false;
    }

    @Override public boolean supportsConvert() throws SQLException {
        return false;
    }

    @Override public boolean supportsConvert(int i, int i2) throws SQLException {
        return false;
    }

    @Override public boolean supportsTableCorrelationNames() throws SQLException {
        return false;
    }

    @Override public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return false;
    }

    @Override public boolean supportsExpressionsInOrderBy() throws SQLException {
        return false;
    }

    @Override public boolean supportsOrderByUnrelated() throws SQLException {
        return false;
    }

    @Override public boolean supportsGroupBy() throws SQLException {
        return false;
    }

    @Override public boolean supportsGroupByUnrelated() throws SQLException {
        return false;
    }

    @Override public boolean supportsGroupByBeyondSelect() throws SQLException {
        return false;
    }

    @Override public boolean supportsLikeEscapeClause() throws SQLException {
        return false;
    }

    @Override public boolean supportsMultipleResultSets() throws SQLException {
        return false;
    }

    @Override public boolean supportsMultipleTransactions() throws SQLException {
        return false;
    }

    @Override public boolean supportsNonNullableColumns() throws SQLException {
        return false;
    }

    @Override public boolean supportsMinimumSQLGrammar() throws SQLException {
        return false;
    }

    @Override public boolean supportsCoreSQLGrammar() throws SQLException {
        return false;
    }

    @Override public boolean supportsExtendedSQLGrammar() throws SQLException {
        return false;
    }

    @Override public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return false;
    }

    @Override public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return false;
    }

    @Override public boolean supportsANSI92FullSQL() throws SQLException {
        return false;
    }

    @Override public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return false;
    }

    @Override public boolean supportsOuterJoins() throws SQLException {
        return false;
    }

    @Override public boolean supportsFullOuterJoins() throws SQLException {
        return false;
    }

    @Override public boolean supportsLimitedOuterJoins() throws SQLException {
        return false;
    }

    @Override public String getSchemaTerm() throws SQLException {
        return null;
    }

    @Override public String getProcedureTerm() throws SQLException {
        return null;
    }

    @Override public String getCatalogTerm() throws SQLException {
        return null;
    }

    @Override public boolean isCatalogAtStart() throws SQLException {
        return false;
    }

    @Override public String getCatalogSeparator() throws SQLException {
        return null;
    }

    @Override public boolean supportsSchemasInDataManipulation() throws SQLException {
        return false;
    }

    @Override public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return false;
    }

    @Override public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return true;
    }

    @Override public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return false;
    }

    @Override public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return false;
    }

    @Override public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return false;
    }

    @Override public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return false;
    }

    @Override public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return false;
    }

    @Override public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return false;
    }

    @Override public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return false;
    }

    @Override public boolean supportsPositionedDelete() throws SQLException {
        return false;
    }

    @Override public boolean supportsPositionedUpdate() throws SQLException {
        return false;
    }

    @Override public boolean supportsSelectForUpdate() throws SQLException {
        return false;
    }

    @Override public boolean supportsStoredProcedures() throws SQLException {
        return false;
    }

    @Override public boolean supportsSubqueriesInComparisons() throws SQLException {
        return false;
    }

    @Override public boolean supportsSubqueriesInExists() throws SQLException {
        return false;
    }

    @Override public boolean supportsSubqueriesInIns() throws SQLException {
        return false;
    }

    @Override public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return false;
    }

    @Override public boolean supportsCorrelatedSubqueries() throws SQLException {
        return false;
    }

    @Override public boolean supportsUnion() throws SQLException {
        return false;
    }

    @Override public boolean supportsUnionAll() throws SQLException {
        return false;
    }

    @Override public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return false;
    }

    @Override public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return false;
    }

    @Override public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return false;
    }

    @Override public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return false;
    }

    @Override public int getMaxBinaryLiteralLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxCharLiteralLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxColumnNameLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxColumnsInGroupBy() throws SQLException {
        return 0;
    }

    @Override public int getMaxColumnsInIndex() throws SQLException {
        return 0;
    }

    @Override public int getMaxColumnsInOrderBy() throws SQLException {
        return 0;
    }

    @Override public int getMaxColumnsInSelect() throws SQLException {
        return 0;
    }

    @Override public int getMaxColumnsInTable() throws SQLException {
        return 0;
    }

    @Override public int getMaxConnections() throws SQLException {
        return 0;
    }

    @Override public int getMaxCursorNameLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxIndexLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxSchemaNameLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxProcedureNameLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxCatalogNameLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxRowSize() throws SQLException {
        return 0;
    }

    @Override public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return false;
    }

    @Override public int getMaxStatementLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxStatements() throws SQLException {
        return 0;
    }

    @Override public int getMaxTableNameLength() throws SQLException {
        return 0;
    }

    @Override public int getMaxTablesInSelect() throws SQLException {
        return 0;
    }

    @Override public int getMaxUserNameLength() throws SQLException {
        return 0;
    }

    @Override public int getDefaultTransactionIsolation() throws SQLException {
        return 0;
    }

    @Override public boolean supportsTransactions() throws SQLException {
        return false;
    }

    @Override public boolean supportsTransactionIsolationLevel(int i) throws SQLException {
        return false;
    }

    @Override public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return false;
    }

    @Override public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return false;
    }

    @Override public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return false;
    }

    @Override public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return false;
    }

    @Override public ResultSet getProcedures(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getProcedureColumns(String s, String s2, String s3, String s4) throws SQLException {
        return null;
    }

    @Override public ResultSet getTables(String s, String s2, String s3, String[] strings) throws SQLException {
        return null;
    }

    @Override public ResultSet getSchemas() throws SQLException {
        return null;
    }

    @Override public ResultSet getCatalogs() throws SQLException {
        return null;
    }

    @Override public ResultSet getTableTypes() throws SQLException {
        return null;
    }

    @Override public ResultSet getColumns(String s, String s2, String s3, String s4) throws SQLException {
        List<Map<String, Object>> data = generateColumnMetadata();
        return new CSVResultSet("mock", null, data);
    }

    private List<Map<String, Object>> generateColumnMetadata() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> column;
        List<String> names = MemoryStorage.getInstance().getColumnNames();
        List<String> types = MemoryStorage.getInstance().getColumnTypes();

        for (int i = 0; i < names.size(); i++) {
            column = new HashMap<>();
            column.put("TABLE_SCHEM", "mock");
            column.put("TABLE_NAME", "mock");
            column.put("COLUMN_NAME", names.get(i));
            column.put("TYPE_NAME", types.get(i));
        }
        return data;
    }

    @Override public ResultSet getColumnPrivileges(String s, String s2, String s3, String s4) throws SQLException {
        return null;
    }

    @Override public ResultSet getTablePrivileges(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getBestRowIdentifier(String s, String s2, String s3, int i, boolean b) throws SQLException {
        return null;
    }

    @Override public ResultSet getVersionColumns(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getPrimaryKeys(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getImportedKeys(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getExportedKeys(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getCrossReference(String s, String s2, String s3, String s4, String s5, String s6) throws SQLException {
        return null;
    }

    @Override public ResultSet getTypeInfo() throws SQLException {
        return null;
    }

    @Override public ResultSet getIndexInfo(String s, String s2, String s3, boolean b, boolean b2) throws SQLException {
        return null;
    }

    @Override public boolean supportsResultSetType(int i) throws SQLException {
        if (i == ResultSet.TYPE_SCROLL_INSENSITIVE) {
            return true;
        }
        return false;
    }

    @Override public boolean supportsResultSetConcurrency(int i, int i2) throws SQLException {
        return false;
    }

    @Override public boolean ownUpdatesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override public boolean ownDeletesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override public boolean ownInsertsAreVisible(int i) throws SQLException {
        return false;
    }

    @Override public boolean othersUpdatesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override public boolean othersDeletesAreVisible(int i) throws SQLException {
        return false;
    }

    @Override public boolean othersInsertsAreVisible(int i) throws SQLException {
        return false;
    }

    @Override public boolean updatesAreDetected(int i) throws SQLException {
        return false;
    }

    @Override public boolean deletesAreDetected(int i) throws SQLException {
        return false;
    }

    @Override public boolean insertsAreDetected(int i) throws SQLException {
        return false;
    }

    @Override public boolean supportsBatchUpdates() throws SQLException {
        return false;
    }

    @Override public ResultSet getUDTs(String s, String s2, String s3, int[] ints) throws SQLException {
        return null;
    }

    @Override public Connection getConnection() throws SQLException {
        return null;
    }

    @Override public boolean supportsSavepoints() throws SQLException {
        return false;
    }

    @Override public boolean supportsNamedParameters() throws SQLException {
        return false;
    }

    @Override public boolean supportsMultipleOpenResults() throws SQLException {
        return false;
    }

    @Override public boolean supportsGetGeneratedKeys() throws SQLException {
        return false;
    }

    @Override public ResultSet getSuperTypes(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getSuperTables(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getAttributes(String s, String s2, String s3, String s4) throws SQLException {
        return null;
    }

    @Override public boolean supportsResultSetHoldability(int i) throws SQLException {
        return false;
    }

    @Override public int getResultSetHoldability() throws SQLException {
        return 0;
    }

    @Override public int getDatabaseMajorVersion() throws SQLException {
        return 0;
    }

    @Override public int getDatabaseMinorVersion() throws SQLException {
        return 0;
    }

    @Override public int getJDBCMajorVersion() throws SQLException {
        return 0;
    }

    @Override public int getJDBCMinorVersion() throws SQLException {
        return 0;
    }

    @Override public int getSQLStateType() throws SQLException {
        return 0;
    }

    @Override public boolean locatorsUpdateCopy() throws SQLException {
        return false;
    }

    @Override public boolean supportsStatementPooling() throws SQLException {
        return false;
    }

    @Override public RowIdLifetime getRowIdLifetime() throws SQLException {
        return null;
    }

    @Override public ResultSet getSchemas(String s, String s2) throws SQLException {
        return null;
    }

    @Override public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return false;
    }

    @Override public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return false;
    }

    @Override public ResultSet getClientInfoProperties() throws SQLException {
        return null;
    }

    @Override public ResultSet getFunctions(String s, String s2, String s3) throws SQLException {
        return null;
    }

    @Override public ResultSet getFunctionColumns(String s, String s2, String s3, String s4) throws SQLException {
        return null;
    }

    @Override public <T> T unwrap(Class<T> tClass) throws SQLException {
        return null;
    }

    @Override public boolean isWrapperFor(Class<?> aClass) throws SQLException {
        return false;
    }

	@Override
	public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern)
			throws SQLException {
		return null;
	}

	@Override
	public boolean generatedKeyAlwaysReturned() throws SQLException {
		return false;
	}
}
