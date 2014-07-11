package modelo;
public class PalavraChave{
	long id;
	String palavra;
	public PalavraChave(){}
	public PalavraChave(long i){id = i;}
	public String toString() { if(palavra!=null)return palavra.toString();
 return id+"";}
	public long getId(){ return id;}
	public void setId(long x){ this.id=x;}
	public String getPalavra(){ return palavra;}
	public void setPalavra(String x){ this.palavra=x;}

}