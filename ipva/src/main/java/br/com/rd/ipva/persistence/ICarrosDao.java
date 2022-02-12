package br.com.rd.ipva.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.rd.ipva.model.Carros;

public interface ICarrosDao {
	
	public void inserirCarro(Carros carro) throws SQLException;
	public void atualizarCarro(Carros carro) throws SQLException;
	public void deletarCarro(int id) throws SQLException;
	public List<Carros> listarCarro () throws SQLException;

}//end ICarros
