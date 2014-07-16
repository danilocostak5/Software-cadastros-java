package modelo;

public class Local
{
	long id;
	String cidade;
	String estado;
	String descricao;

	public Local()
	{
	}

	public Local(long i)
	{
		id = i;
	}

	public String toString()
	{
		if (cidade != null)
			return cidade.toString();
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

	public String getCidade()
	{
		return cidade;
	}

	public void setCidade(String x)
	{
		this.cidade = x;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String x)
	{
		this.estado = x;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String x)
	{
		this.descricao = x;
	}

}