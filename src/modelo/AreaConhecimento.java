package modelo;

public class AreaConhecimento
{
	long id;
	String nome;
	String ciencia;
	String areaAvaliacao;

	public AreaConhecimento(long i)
	{
		id = i;
	}

	public String toString()
	{
		if (nome != null)
			return nome.toString();
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

	public String getNome()
	{
		return nome;
	}

	public void setNome(String x)
	{
		this.nome = x;
	}

	public String getCiencia()
	{
		return ciencia;
	}

	public void setCiencia(String ciencia)
	{
		this.ciencia = ciencia;
	}

	public String getAreaAvaliacao()
	{
		return areaAvaliacao;
	}

	public void setAreaAvaliacao(String areaAvaliacao)
	{
		this.areaAvaliacao = areaAvaliacao;
	}

	public AreaConhecimento()
	{
	}

}