package br.com.rd.ipva.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements IGenericDao {
	
	private Connection cntc;
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		cntc = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipva", "root", "root"); 
		System.out.println("Conexão realizada com sucesso");
		
		return cntc;
	}
	

}//end GenericDao
