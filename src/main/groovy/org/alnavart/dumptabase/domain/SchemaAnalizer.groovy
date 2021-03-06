package org.alnavart.dumptabase.domain

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.ResultSet
import java.sql.SQLException

class SchemaAnalizer
{
    static Connection connection = null;
    static DatabaseMetaData metadata = null;

    // Static block for initialization
    static {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            System.err.println("There was an error getting the connection: "
                + e.getMessage());
        }

        try {
            metadata = connection.getMetaData();
        } catch (SQLException e) {
            System.err.println("There was an error getting the metadata: "
                + e.getMessage());
        }
    }

    /**
     * Prints in the console the general metadata.
     *
     * @throws SQLException
     */
    public static void printGeneralMetadata() throws SQLException {
        System.out.println("Database Product Name: "
            + metadata.getDatabaseProductName());
        System.out.println("Database Product Version: "
            + metadata.getDatabaseProductVersion());
        System.out.println("Logged User: " + metadata.getUserName());
        System.out.println("JDBC Driver: " + metadata.getDriverName());
        System.out.println("Driver Version: " + metadata.getDriverVersion());
        System.out.println("\n");
    }

    /**
     *
     * @return Arraylist with the table's name
     * @throws SQLException
     */
    public static ArrayList getTablesMetadata() throws SQLException {
        String table = { "TABLE" };
        ResultSet rs = null;
        ArrayList tables = null;
        // receive the Type of the object in a String array.
        rs = metadata.getTables(null, null, null, table);
        tables = new ArrayList();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    /**
     * Prints in the console the columns metadata, based in the Arraylist of
     * tables passed as parameter.
     *
     * @param tables
     * @throws SQLException
     */
    public static void getColumnsMetadata(ArrayList tables)
        throws SQLException {
        ResultSet rs = null;
        // Print the columns properties of the actual table
        for (String actualTable : tables) {
            rs = metadata.getColumns(null, null, actualTable, null);
            System.out.println(actualTable.toUpperCase());
            while (rs.next()) {
                System.out.println(rs.getString("COLUMN_NAME") + " "
                    + rs.getString("TYPE_NAME") + " "
                    + rs.getString("COLUMN_SIZE"));
            }
            System.out.println("\n");
        }

    }

}
