package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Curso;

import modelo.*;

public class CursoMysql
{
	ConnectionDao conexao = null;
	private Statement comando;

	public CursoMysql() throws Exception
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

	public long inserir(Curso curso) throws Exception
	{
		String sql = "INSERT INTO curso " + "(nome) VALUES('" + curso.getNome()
				+ "')";
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

	public void remover(Curso curso) throws Exception
	{
		String sql = null;
		long x = curso.getId();
		sql = "DELETE FROM curso WHERE id = '" + x + "'";
		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public void atualizar(Curso curso) throws Exception
	{
		long x = curso.getId();
		String sql = "UPDATE curso SET " + "nome = '" + curso.getNome() + "'"
				+ " WHERE id = '" + x + "'";

		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public ArrayList<Curso> listar(String condicao) throws Exception
	{
		ArrayList<Curso> lista = new ArrayList<Curso>();
		try
		{
			ResultSet rs = comando.executeQuery("SELECT * FROM curso "
					+ condicao);
			while (rs.next())
			{
				Curso curso = new Curso();
				curso.setId(rs.getLong("id"));
				// curso.setId((Long)rs.getObject("id"));
				curso.setNome(rs.getString("nome"));
				// curso.setNome((String)rs.getObject("nome"));
				lista.add(curso);
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
