package br.com.rd.ipva.persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGenericDao {
	
	Connection getConnection() throws ClassNotFoundException, SQLException;
	
}//end IGenericDao
