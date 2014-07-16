package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.InstituicaoCooperadora;

import modelo.*;

public class InstituicaoCooperadoraMysql
{
	ConnectionDao conexao = null;
	private Statement comando;

	public InstituicaoCooperadoraMysql() throws Exception
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

	public long inserir(InstituicaoCooperadora instituicaocooperadora)
			throws Exception
	{
		String sql = "INSERT INTO instituicaocooperadora " + "(nome) VALUES('"
				+ instituicaocooperadora.getNome() + "')";
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

	public void remover(InstituicaoCooperadora instituicaocooperadora)
			throws Exception
	{
		String sql = null;
		long x = instituicaocooperadora.getId();
		sql = "DELETE FROM instituicaocooperadora WHERE id = '" + x + "'";
		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public void atualizar(InstituicaoCooperadora instituicaocooperadora)
			throws Exception
	{
		long x = instituicaocooperadora.getId();
		String sql = "UPDATE instituicaocooperadora SET " + "nome = '"
				+ instituicaocooperadora.getNome() + "'" + " WHERE id = '" + x
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

	public ArrayList<InstituicaoCooperadora> listar(String condicao)
			throws Exception
	{
		ArrayList<InstituicaoCooperadora> lista = new ArrayList<InstituicaoCooperadora>();
		try
		{
			ResultSet rs = comando
					.executeQuery("SELECT * FROM instituicaocooperadora "
							+ condicao);
			while (rs.next())
			{
				InstituicaoCooperadora instituicaocooperadora = new InstituicaoCooperadora();
				instituicaocooperadora.setId(rs.getLong("id"));
				// instituicaocooperadora.setId((Long)rs.getObject("id"));
				instituicaocooperadora.setNome(rs.getString("nome"));
				// instituicaocooperadora.setNome((String)rs.getObject("nome"));
				lista.add(instituicaocooperadora);
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
