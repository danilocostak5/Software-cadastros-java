package modelo;

import java.util.ArrayList;

public class Pesquisa
{
	long id;
	String titulo;
	Pesquisador orientador;
	Pesquisador pesquisador_responsavel;
	ArrayList<Pesquisador> colaboradores;
	int ano_submissao;
	int tempo_duracao;
	String tipo;
	String qualificacao;
	String impacto_pesquisa;
	boolean gerou_patente;
	String status;
	String resultado;
	InstituicaoSubmissao instituicao_submissao;
	FonteFinanciamento fonte_financiamento;
	AreaConhecimento area_conhecimento_CNPq;
	ArrayList<PalavraChave> palavras_chave;
	ArrayList<InstituicaoCooperadora> instituicoes_cooperadoras;
	ArrayList<Local> locais;
	StringBuffer resumo;

	public Pesquisa()
	{
	}

	public Pesquisa(long i)
	{
		id = i;
	}

	public String toString()
	{
		if (titulo != null)
			return titulo.toString();
		return id + "";
	}

	public long getId()
	{
		return id;
	}

	public void setId(long x)
	{
		this.id = x;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String x)
	{
		this.titulo = x;
	}

	public Pesquisador getOrientador()
	{
		return orientador;
	}

	public void setOrientador(Pesquisador x)
	{
		this.orientador = x;
	}

	public Pesquisador getPesquisador_responsavel()
	{
		return pesquisador_responsavel;
	}

	public void setPesquisador_responsavel(Pesquisador x)
	{
		this.pesquisador_responsavel = x;
	}

	public ArrayList<Pesquisador> getColaboradores()
	{
		return colaboradores;
	}

	public void setColaboradores(ArrayList<Pesquisador> x)
	{
		this.colaboradores = x;
	}

	public int getAno_submissao()
	{
		return ano_submissao;
	}

	public void setAno_submissao(int x)
	{
		this.ano_submissao = x;
	}

	public int getTempo_duracao()
	{
		return tempo_duracao;
	}

	public void setTempo_duracao(int x)
	{
		this.tempo_duracao = x;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String x)
	{
		this.tipo = x;
	}

	public String getQualificacao()
	{
		return qualificacao;
	}

	public void setQualificacao(String x)
	{
		this.qualificacao = x;
	}

	public String getImpacto_pesquisa()
	{
		return impacto_pesquisa;
	}

	public void setImpacto_pesquisa(String x)
	{
		this.impacto_pesquisa = x;
	}

	public boolean isGerou_patente()
	{
		return gerou_patente;
	}

	public void setGerou_patente(boolean x)
	{
		this.gerou_patente = x;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String x)
	{
		this.status = x;
	}

	public String getResultado()
	{
		return resultado;
	}

	public void setResultado(String x)
	{
		this.resultado = x;
	}

	public InstituicaoSubmissao getInstituicao_submissao()
	{
		return instituicao_submissao;
	}

	public void setInstituicao_submissao(InstituicaoSubmissao x)
	{
		this.instituicao_submissao = x;
	}

	public FonteFinanciamento getFonte_financiamento()
	{
		return fonte_financiamento;
	}

	public void setFonte_financiamento(FonteFinanciamento x)
	{
		this.fonte_financiamento = x;
	}

	public AreaConhecimento getArea_conhecimento_CNPq()
	{
		return area_conhecimento_CNPq;
	}

	public void setArea_conhecimento_CNPq(AreaConhecimento x)
	{
		this.area_conhecimento_CNPq = x;
	}

	public ArrayList<PalavraChave> getPalavras_chave()
	{
		return palavras_chave;
	}

	public void setPalavras_chave(ArrayList<PalavraChave> x)
	{
		this.palavras_chave = x;
	}

	public ArrayList<InstituicaoCooperadora> getInstituicoes_cooperadoras()
	{
		return instituicoes_cooperadoras;
	}

	public void setInstituicoes_cooperadoras(ArrayList<InstituicaoCooperadora> x)
	{
		this.instituicoes_cooperadoras = x;
	}

	public ArrayList<Local> getLocais()
	{
		return this.locais;
	}

	public void setLocais(ArrayList<Local> x)
	{
		this.locais = x;
	}

	public StringBuffer getResumo()
	{
		return resumo;
	}

	public void setResumo(StringBuffer x)
	{
		this.resumo = x;
	}

	public void setResumo(String x)
	{
		this.resumo = new StringBuffer(x);
	}

}