package com.capgemini.lab3.dbservice;

import java.sql.Connection;
import java.sql.SQLException;

public class DbDaoImpl implements DbDao{
	
	static Connection con;
	
	public Connection getConnection()
	{
		try {
			con = DbConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
