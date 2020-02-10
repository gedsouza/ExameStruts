package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import connection.ConnectionFactory;
import model.Exame;


public class ExamesDAO {

	Connection connection = new ConnectionFactory().getConnection();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public void adicionarExame(Exame exame) throws SQLException {

		try {
		String sql = "insert into exames (nome, email, telefone,endereco,"
				+ "cpf, exame, situacao, retorno, data) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = connection.prepareStatement(sql);
		java.sql.Date data = new java.sql.Date(dateFormat.parse(exame.getData()).getTime());

		ps.setString(1, exame.getNome());
		ps.setString(2, exame.getEmail());
		ps.setString(3, exame.getTelefone());
		ps.setString(4, exame.getEndereco());
		ps.setString(5, exame.getCpf());
		ps.setString(6, exame.getTpExame());
		ps.setString(7, exame.getSituacao());
		ps.setString(8, exame.getRetorno());
		ps.setDate(9, data);

		ps.executeUpdate();

		connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}  catch (ParseException e) {
			throw new RuntimeException(e);
		} 
		
	}

	public List<Exame> listarExames() throws SQLException {
		try {
			List<Exame> examesList = new ArrayList<Exame>();

			String sql = "select * from exames";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Exame exame = new Exame();
				exame.setId(Long.parseLong(rs.getString("id")));
				exame.setNome(rs.getString("nome"));
				exame.setEmail(rs.getString("email"));
				exame.setTelefone(rs.getString("telefone"));
				exame.setEndereco(rs.getString("endereco"));
				exame.setCpf(rs.getString("cpf"));
				exame.setTpExame(rs.getString("exame"));
				exame.setData(dateFormat.format(rs.getDate("data")));
				exame.setSituacao(rs.getString("situacao"));
				exame.setRetorno(rs.getString("retorno"));

				examesList.add(exame);
			}

			rs.close();
			connection.close();

			return examesList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Exame buscarExamePorId(Long id) throws SQLException {
		try {
			Exame exame = new Exame();

			String sql = "select * from exames where id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				exame.setId(Long.parseLong(rs.getString("id")));
				exame.setNome(rs.getString("nome"));
				exame.setEmail(rs.getString("email"));
				exame.setTelefone(rs.getString("telefone"));
				exame.setEndereco(rs.getString("endereco"));
				exame.setCpf(rs.getString("cpf"));
				exame.setTpExame(rs.getString("exame"));
				exame.setData(dateFormat.format(rs.getDate("data")));
				exame.setSituacao(rs.getString("situacao"));
				exame.setRetorno(rs.getString("retorno"));
			}

			rs.close();
			connection.close();

			return exame;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterarExame(Exame exame) throws SQLException {

		String sql = "update exames set nome=?, cpf=?, telefone=?, endereco=?, email=?, exame=?," + "data=?, situacao=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			java.sql.Date data;
			if(StringUtils.isNotBlank(exame.getData())) {
				data = new java.sql.Date(dateFormat.parse(exame.getData()).getTime());
			} else {
				data = null;
			}

			stmt.setString(1, exame.getNome());
			stmt.setString(2, exame.getCpf());
			stmt.setString(3, exame.getTelefone());
			stmt.setString(4, exame.getEndereco());
			stmt.setString(5, exame.getEmail());
			stmt.setString(6, exame.getTpExame());
			stmt.setDate(7, data);
			stmt.setString(8, exame.getSituacao());
			stmt.setLong(9, exame.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} 
	}

	public boolean excluirExame(Long id) throws SQLException {
		try {
			String sql = "delete from exames where id = ?" ;
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
			return false;
		}
	}
}
