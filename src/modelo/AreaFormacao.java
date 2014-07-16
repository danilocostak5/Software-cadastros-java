package modelo;

public class AreaFormacao
{
	long id;
	String nome;

	public AreaFormacao()
	{
	}

	public AreaFormacao(long i)
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

}