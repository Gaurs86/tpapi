package com.comviva.tpapi.db.sql;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.comviva.tpapi.staticResources.ConfigurationsProvider;

public class DBConnection {
	
	private DataSource ds;
	
	private DataSource getDataSource() {
		
		try {
			InitialContext ic = new InitialContext();
			synchronized (DBConnection.class) {
				if (ds == null) {
                    String dsName = ConfigurationsProvider.getDataSource();
                    ds = (DataSource) ic.lookup(dsName);
                }	
			}
			ic.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	
	public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            if (getDataSource() == null) {
                //LogUtil.getLogger().info("getDataSource():DataSource Creation: Failed.");
                throw new SQLException("Data Source Not Configured Properly");
            } else {
                //LogUtil.getLogger().debug("getDataSource():DataSource Creation: DataSource Search Success");
                con = ds.getConnection();

            }
        } catch (SQLException e) {
            //LogUtil.getLogger().error("getConnection()::********************DB Connection Could not be established");
            //ErrorLoggingUtil.getLogger().error("getConnection():{}", e);
            throw e;
        }
        return con;
    }

}
