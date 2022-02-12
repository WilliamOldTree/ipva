package br.com.rd.ipva.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rd.ipva.model.Carros;

public class CarrosDao implements ICarrosDao {

	private Connection cntc;

	public CarrosDao() throws ClassNotFoundException, SQLException {
		IGenericDao genDao = new GenericDao();
		cntc = genDao.getConnection();
	}

	@Override
	public void inserirCarro(Carros carro) throws SQLException {
		String sql = "INSERT INTO carros ( model, ano) VALUES (?, ?)";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ps.setString(1, carro.getModel());
		ps.setString(2, carro.getAno());
		ps.executeUpdate();
		ps.close();

	}// end inserirCarro

	@Override
	public void atualizarCarro(Carros carro) throws SQLException {
		String sql = " UPDATE carros SET model = ?, ano = ? WHERE id = ? ";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ps.setInt(1, carro.getId());
		ps.setString(2, carro.getModel());
		ps.setString(3, carro.getAno());
		ps.executeUpdate();
		ps.close();

	}// end atualizarCarro

	@Override
	public void deletarCarro(int id) throws SQLException {
		String sql = "DELETE carros WHERE id=?";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public List<Carros> listarCarro() throws SQLException {
		List<Carros> listaCarros = new ArrayList<>();
		String sql = "SELECT id, model, ano FROM carros";
		PreparedStatement ps = cntc.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Carros carro = new Carros(rs.getInt("id"), rs.getString("model"), rs.getString("ano"));
			listaCarros.add(carro);
		}
		ps.executeUpdate();
		ps.close();
		rs.close();
		
		return listaCarros;
	}

}// end CarrosDao
