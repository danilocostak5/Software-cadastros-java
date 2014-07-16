package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.FonteFinanciamento;

import modelo.*;

public class FonteFinanciamentoMysql
{
	ConnectionDao conexao = null;
	private Statement comando;

	public FonteFinanciamentoMysql() throws Exception
	{
		conexao = ConnectionDao.getInstance();
		try
		{
			this.comando = conexao.getConnection().createStatement();
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public long inserir(FonteFinanciamento fontefinanciamento) throws Exception
	{
		String sql = "INSERT INTO fontefinanciamento " + "(nome) VALUES('"
				+ fontefinanciamento.getNome() + "')";
		long x = 0;
		try
		{
			java.sql.PreparedStatement inserirReturnId = conexao
					.getConnection().prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);
			inserirReturnId.executeUpdate();
			ResultSet rs = inserirReturnId.getGeneratedKeys();
			if (rs.next())
				x = rs.getLong(1);
		}
		catch (SQLException e)
		{
			throw e;
		}
		return x;
	}

	public void remover(FonteFinanciamento fontefinanciamento) throws Exception
	{
		String sql = null;
		long x = fontefinanciamento.getId();
		sql = "DELETE FROM fontefinanciamento WHERE id = '" + x + "'";
		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public void atualizar(FonteFinanciamento fontefinanciamento)
			throws Exception
	{
		long x = fontefinanciamento.getId();
		String sql = "UPDATE fontefinanciamento SET " + "nome = '"
				+ fontefinanciamento.getNome() + "'" + " WHERE id = '" + x
				+ "'";

		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public ArrayList<FonteFinanciamento> listar(String condicao)
			throws Exception
	{
		ArrayList<FonteFinanciamento> lista = new ArrayList<>();
		try
		{
			ResultSet rs = comando
					.executeQuery("SELECT * FROM fontefinanciamento "
							+ condicao);
			while (rs.next())
			{
				FonteFinanciamento fontefinanciamento = new FonteFinanciamento();
				fontefinanciamento.setId(rs.getLong("id"));
				// fontefinanciamento.setId((Long)rs.getObject("id"));
				fontefinanciamento.setNome(rs.getString("nome"));
				// fontefinanciamento.setNome((String)rs.getObject("nome"));
				lista.add(fontefinanciamento);
			}
			rs.close();
		}
		catch (SQLException e)
		{
			throw e;
		}
		return lista;
	}
}
