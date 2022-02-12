package br.com.rd.ipva.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.rd.ipva.model.Ipva;

public interface IIpvaDao {
	
	public void inserirAnoIpva (Ipva imposto) throws ClassNotFoundException, SQLException;
	public void atualizarAnoIpva(Ipva imposto) throws ClassNotFoundException, SQLException;
	public void deletarAnoIpva(Integer id) throws ClassNotFoundException, SQLException;
	public List <Ipva> listarAnoIpva() throws ClassNotFoundException, SQLException;
//	
}
