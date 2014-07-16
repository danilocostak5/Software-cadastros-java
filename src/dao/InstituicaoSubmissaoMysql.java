package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.InstituicaoSubmissao;

import modelo.*;

public class InstituicaoSubmissaoMysql
{
	ConnectionDao conexao = null;
	private Statement comando;

	public InstituicaoSubmissaoMysql() throws Exception
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

	public long inserir(InstituicaoSubmissao instituicaosubmissao)
			throws Exception
	{
		String sql = "INSERT INTO instituicaosubmissao " + "(nome) VALUES('"
				+ instituicaosubmissao.getNome() + "')";
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

	public void remover(InstituicaoSubmissao instituicaosubmissao)
			throws Exception
	{
		String sql = null;
		long x = instituicaosubmissao.getId();
		sql = "DELETE FROM instituicaosubmissao WHERE id = '" + x + "'";
		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public void atualizar(InstituicaoSubmissao instituicaosubmissao)
			throws Exception
	{
		long x = instituicaosubmissao.getId();
		String sql = "UPDATE instituicaosubmissao SET " + "nome = '"
				+ instituicaosubmissao.getNome() + "'" + " WHERE id = '" + x
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

	public ArrayList<InstituicaoSubmissao> listar(String condicao)
			throws Exception
	{
		ArrayList<InstituicaoSubmissao> lista = new ArrayList<InstituicaoSubmissao>();
		try
		{
			ResultSet rs = comando
					.executeQuery("SELECT * FROM instituicaosubmissao "
							+ condicao);
			while (rs.next())
			{
				InstituicaoSubmissao instituicaosubmissao = new InstituicaoSubmissao();
				instituicaosubmissao.setId(rs.getLong("id"));
				// instituicaosubmissao.setId((Long)rs.getObject("id"));
				instituicaosubmissao.setNome(rs.getString("nome"));
				// instituicaosubmissao.setNome((String)rs.getObject("nome"));
				lista.add(instituicaosubmissao);
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
