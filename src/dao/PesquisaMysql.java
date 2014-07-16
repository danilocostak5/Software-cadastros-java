package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Pesquisa;

import modelo.*;

public class PesquisaMysql
{
	ConnectionDao conexao = null;
	private Statement comando;

	public PesquisaMysql() throws Exception
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

	public long inserir(Pesquisa pesquisa) throws Exception
	{
		String sql = "INSERT INTO pesquisa "
				+ "(titulo,orientador,pesquisador_responsavel,ano_submissao,tempo_duracao,tipo,qualificacao,impacto_pesquisa,gerou_patente,status,resultado,instituicao_submissao,fonte_financiamento,area_conhecimento_CNPq, resumo) VALUES('"
				+ pesquisa.getTitulo()
				+ "','"
				+ pesquisa.getOrientador().getId()
				+ "','"
				+ pesquisa.getPesquisador_responsavel().getId()
				+ "','"
				+ pesquisa.getAno_submissao()
				+ "','"
				+ pesquisa.getTempo_duracao()
				+ "','"
				+ pesquisa.getTipo()
				+ "','"
				+ pesquisa.getQualificacao()
				+ "','"
				+ pesquisa.getImpacto_pesquisa()
				+ "','"
				+ (pesquisa.isGerou_patente() == true ? 1 : 0)
				+ "','"
				+ pesquisa.getStatus()
				+ "','"
				+ pesquisa.getResultado()
				+ "','"
				+ pesquisa.getInstituicao_submissao().getId()
				+ "','"
				+ pesquisa.getFonte_financiamento().getId()
				+ "','"
				+ pesquisa.getArea_conhecimento_CNPq().getId()
				+ "','"
				+ pesquisa.getResumo()
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
			new PesquisacolaboradoresMysql().inserir(x,
					pesquisa.getColaboradores());
			new Pesquisapalavras_chaveMysql().inserir(x,
					pesquisa.getPalavras_chave());
			new Pesquisainstituicoes_cooperadorasMysql().inserir(x,
					pesquisa.getInstituicoes_cooperadoras());
            new PesquisaLocaisMysql().inserir(x, pesquisa.getLocais());
		}
		catch (SQLException e)
		{
			throw e;
		}
		return x;
	}

	public void remover(Pesquisa pesquisa) throws Exception
	{
		String sql = null;
		long x = pesquisa.getId();
		new PesquisacolaboradoresMysql().remover(x);
		new Pesquisapalavras_chaveMysql().remover(x);
		new Pesquisainstituicoes_cooperadorasMysql().remover(x);
        new PesquisaLocaisMysql().remover(x);
		sql = "DELETE FROM pesquisa WHERE id = '" + x + "'";
		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public void atualizar(Pesquisa pesquisa) throws Exception
	{
		long x = pesquisa.getId();
		String sql = "UPDATE pesquisa SET " + "titulo = '"
				+ pesquisa.getTitulo() + "'," + "orientador = '"
				+ pesquisa.getOrientador().getId() + "',"
				+ "pesquisador_responsavel = '"
				+ pesquisa.getPesquisador_responsavel().getId() + "',"
				+ "ano_submissao = '" + pesquisa.getAno_submissao() + "',"
				+ "tempo_duracao = '" + pesquisa.getTempo_duracao() + "',"
				+ "tipo = '" + pesquisa.getTipo() + "'," + "qualificacao = '"
				+ pesquisa.getQualificacao() + "'," + "impacto_pesquisa = '"
				+ pesquisa.getImpacto_pesquisa() + "'," + "gerou_patente = '"
				+ (pesquisa.isGerou_patente() == true ? 1 : 0) + "',"
				+ "status = '" + pesquisa.getStatus() + "'," + "resultado = '"
				+ pesquisa.getResultado() + "'," + "instituicao_submissao = '"
				+ pesquisa.getInstituicao_submissao().getId() + "',"
				+ "fonte_financiamento = '"
				+ pesquisa.getFonte_financiamento().getId() + "',"
				+ "area_conhecimento_CNPq = '"
				+ pesquisa.getArea_conhecimento_CNPq().getId() + "',"
				+ "resumo = '" + pesquisa.getResumo() + "'" + " WHERE id = '"
				+ x + "'";
		new PesquisacolaboradoresMysql().remover(x);
		new PesquisacolaboradoresMysql()
				.inserir(x, pesquisa.getColaboradores());
		new Pesquisapalavras_chaveMysql().remover(x);
		new Pesquisapalavras_chaveMysql().inserir(x,
				pesquisa.getPalavras_chave());
		new Pesquisainstituicoes_cooperadorasMysql().remover(x);
		new Pesquisainstituicoes_cooperadorasMysql().inserir(x,
				pesquisa.getInstituicoes_cooperadoras());
        new PesquisaLocaisMysql().remover(x);
        new PesquisaLocaisMysql().inserir(x, pesquisa.getLocais());

		try
		{
			comando.executeUpdate(sql.toString());
		}
		catch (SQLException e)
		{
			throw e;
		}
	}

	public ArrayList<Pesquisa> listar(String condicao) throws Exception
	{
		ArrayList<Pesquisa> lista = new ArrayList<Pesquisa>();
		try
		{
			ResultSet rs = comando.executeQuery("SELECT * FROM pesquisa "
					+ condicao);
			while (rs.next())
			{
				Pesquisa pesquisa = new Pesquisa();
				pesquisa.setId(rs.getLong("id"));
				// pesquisa.setId((Long)rs.getObject("id"));
				pesquisa.setTitulo(rs.getString("titulo"));
				// pesquisa.setTitulo((String)rs.getObject("titulo"));
				// pesquisa.setOrientador(new
				// Pesquisador(rs.getLong("orientador")));
				pesquisa.setOrientador(new PesquisadorMysql().listar(
						" WHERE id =" + (rs.getLong("orientador"))).get(0));
				// pesquisa.setPesquisador_responsavel(new Pesquisador(rs
				// .getLong("pesquisador_responsavel")));
				pesquisa.setPesquisador_responsavel(new PesquisadorMysql()
						.listar(" WHERE id ="
								+ (rs.getLong("pesquisador_responsavel"))).get(
								0));
				pesquisa.setColaboradores(new PesquisacolaboradoresMysql()
						.listar(rs.getLong("id")));
				pesquisa.setAno_submissao(rs.getInt("ano_submissao"));
				// pesquisa.setAno_submissao((Int)rs.getObject("ano_submissao"));
				pesquisa.setTempo_duracao(rs.getInt("tempo_duracao"));
				// pesquisa.setTempo_duracao((Int)rs.getObject("tempo_duracao"));
				pesquisa.setTipo(rs.getString("tipo"));
				// pesquisa.setTipo((String)rs.getObject("tipo"));
				pesquisa.setQualificacao(rs.getString("qualificacao"));
				// pesquisa.setQualificacao((String)rs.getObject("qualificacao"));
				pesquisa.setImpacto_pesquisa(rs.getString("impacto_pesquisa"));
				// pesquisa.setImpacto_pesquisa((String)rs.getObject("impacto_pesquisa"));
				pesquisa.setGerou_patente(rs.getBoolean("gerou_patente"));
				// pesquisa.setGerou_patente((Boolean)rs.getObject("gerou_patente"));
				pesquisa.setStatus(rs.getString("status"));
				// pesquisa.setStatus((String)rs.getObject("status"));
				pesquisa.setResultado(rs.getString("resultado"));
				// pesquisa.setResultado((String)rs.getObject("resultado"));
				// pesquisa.setInstituicao_submissao(new InstituicaoSubmissao(rs
				// .getLong("instituicao_submissao")));
				pesquisa.setInstituicao_submissao(new InstituicaoSubmissaoMysql()
						.listar(" WHERE id ="
								+ (rs.getLong("instituicao_submissao"))).get(0));
				// pesquisa.setFonte_financiamento(new FonteFinanciamento(rs
				// .getLong("fonte_financiamento")));
				pesquisa.setFonte_financiamento(new FonteFinanciamentoMysql()
						.listar(" WHERE id ="
								+ (rs.getLong("fonte_financiamento"))).get(0));
				// pesquisa.setArea_conhecimento_CNPq(new AreaConhecimento(rs
				// .getLong("area_conhecimento_CNPq")));
				pesquisa.setArea_conhecimento_CNPq(new AreaConhecimentoMysql()
						.listar(" WHERE id ="
								+ (rs.getLong("area_conhecimento_CNPq")))
						.get(0));
				pesquisa.setPalavras_chave(new Pesquisapalavras_chaveMysql()
						.listar(rs.getLong("id")));
				pesquisa.setInstituicoes_cooperadoras(new Pesquisainstituicoes_cooperadorasMysql()
						.listar(rs.getLong("id")));
				// pesquisa.setLocal(new Local(rs.getLong("local")));
				pesquisa.setLocais(new PesquisaLocaisMysql().listar(
						rs.getLong("id")));
				// pesquisa.setResumo(rs.getString("resumo"));
				pesquisa.setResumo((String) rs.getObject("resumo"));
				lista.add(pesquisa);
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
