package com.comviva.tpapi.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.comviva.tpapi.exceptions.DBOperationException;


public class DBUtility {
	
	private Connection con;
	
	public DBUtility() {
		
	}
	
	protected List<String> getQueryResult(String query, int queryTimeout) throws DBOperationException {
		List<String> retnRecord = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		
		DBConnection dbConnection = new DBConnection();
		
		try {
			con = dbConnection.getConnection();
			
			psmt = con.prepareStatement(query);
			psmt.setQueryTimeout(queryTimeout);
			rs = psmt.executeQuery(query);
			rs.getRow();
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int numberOfColumns = resultSetMetaData.getColumnCount();
            int rowCount = 0;
            while (rs.next()) {
                ++rowCount;
                for (int colIndx = 1; colIndx <= numberOfColumns; colIndx++) {
                    retnRecord.add(rs.getString(colIndx));
                }
            }
		} catch (Exception e) {
			retnRecord = null;
			System.out.println("dbUtility -- getQueryResult");
			throw new DBOperationException("Exception while executing query");
		} finally {
			try {
                if (rs != null ) {
                    rs.close();
                }
                if (psmt != null ) {
                    psmt.close();
                }
                if (con != null ) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("error");
            }
			
		}
		
		return retnRecord;
	}
}
