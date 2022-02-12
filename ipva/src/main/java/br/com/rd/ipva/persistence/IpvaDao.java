package br.com.rd.ipva.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rd.ipva.model.Ipva;

public class IpvaDao implements IIpvaDao {
	private Connection cntc;
	
	public IpvaDao() throws ClassNotFoundException, SQLException {
		IGenericDao genDao = new GenericDao();
		cntc = genDao.getConnection();
	}
	
	@Override
	public void inserirAnoIpva(Ipva imposto) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO ipva ( ano) VALUES (?)";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ps.setString(1,  imposto.getAno());
		
	}//end inserir

	@Override
	public void atualizarAnoIpva(Ipva imposto) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE ipva SET ano = ? WHERE = ?";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ps.setInt(1,imposto.getId());
		ps.setString(2,imposto.getAno());
		
	}

	@Override
	public void deletarAnoIpva(Integer id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE ipva WHERE id =?";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		ps.close();
		
		
	}

	@Override
	public List<Ipva> listarAnoIpva() throws ClassNotFoundException, SQLException {
		List <Ipva> anoIpva = new ArrayList<>();
		String sql = "SELECT id, ano FROM ipva";
		PreparedStatement ps =	cntc.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); 
		
		while ( rs.next()) {
			Ipva imposto = new Ipva(rs.getInt("id"), rs.getString("ano"));
			anoIpva.add(imposto);
		}
		
		ps.executeUpdate();
		ps.close();
		rs.close();
		
		return anoIpva;
	}

}
