package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.AreaConhecimento;

import modelo.*;

public class AreaConhecimentoMysql
{
	ConnectionDao conexao = null;
	private Statement comando;

	public AreaConhecimentoMysql() throws Exception
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

	public long inserir(AreaConhecimento areaconhecimento) throws Exception
	{
		String sql = "INSERT INTO areaconhecimento "
				+ "(nome, ciencia, areaAvaliacao) VALUES('"
				+ areaconhecimento.getNome() + "','"
				+ areaconhecimento.getCiencia() + "','"
				+ areaconhecimento.getAreaAvaliacao() + "')";
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

	public void remover(AreaConhecimento areaconhecimento) throws Exception
	{
		String sql = null;
		long x = areaconhecimento.getId();
		sql = "DELETE FROM areaconhecimento WHERE id = '" + x + "'";
		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public void atualizar(AreaConhecimento areaconhecimento) throws Exception
	{
		long x = areaconhecimento.getId();
		String sql = "UPDATE areaconhecimento SET " + "nome = '"
				+ areaconhecimento.getNome() + "', ciencia='"
				+ areaconhecimento.getCiencia() + "', areaAvaliacao='"
				+ areaconhecimento.getAreaAvaliacao() + "' WHERE id = " + x;

		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public ArrayList<AreaConhecimento> listar(String condicao) throws Exception
	{
		ArrayList<AreaConhecimento> lista = new ArrayList<>();
		try
		{
			ResultSet rs = comando
					.executeQuery("SELECT * FROM areaconhecimento " + condicao);
			while (rs.next())
			{
				AreaConhecimento areaconhecimento = new AreaConhecimento();
				areaconhecimento.setId(rs.getLong("id"));
				areaconhecimento.setNome(rs.getString("nome"));
				areaconhecimento.setCiencia(rs.getString("ciencia"));
				areaconhecimento
						.setAreaAvaliacao(rs.getString("areaAvaliacao"));
				lista.add(areaconhecimento);
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
