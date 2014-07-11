package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.PalavraChave;

import modelo.*;
public class PalavraChaveMysql{
ConnectionDao conexao = null;
private Statement comando;

public PalavraChaveMysql() throws Exception {
conexao = ConnectionDao.getInstance();
try {
this.comando = conexao.getConnection().createStatement();
} catch (SQLException e) {
throw e;
}
}
public long inserir(PalavraChave palavrachave) throws Exception {
String sql = "INSERT INTO palavrachave "+
"(palavra) VALUES('"+ palavrachave.getPalavra() + "')";
long x=0;
try {
java.sql.PreparedStatement inserirReturnId = conexao.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) ;
inserirReturnId.executeUpdate();
ResultSet rs = inserirReturnId.getGeneratedKeys();
if (rs.next())  
x = rs.getLong(1);
} catch (SQLException e) {
throw e;
}
return x;
}
public void remover(PalavraChave palavrachave) throws Exception {
String sql = null;
long x = palavrachave.getId();
sql = "DELETE FROM palavrachave WHERE id = '"+x+"'";
try {
comando.executeUpdate(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public void atualizar(PalavraChave palavrachave) throws Exception {
long x = palavrachave.getId();
String sql = "UPDATE palavrachave SET "
+"palavra = '"+palavrachave.getPalavra()+"'"
+" WHERE id = '"+x +"'";

try {
comando.executeUpdate(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public ArrayList<PalavraChave> listar(String condicao) throws Exception {
ArrayList<PalavraChave> lista = new ArrayList<>();
try {
ResultSet rs = comando.executeQuery("SELECT * FROM palavrachave "+condicao);
while (rs.next()) {
PalavraChave palavrachave = new PalavraChave();
palavrachave.setId(rs.getLong("id"));
//palavrachave.setId((Long)rs.getObject("id"));
palavrachave.setPalavra(rs.getString("palavra"));
//palavrachave.setPalavra((String)rs.getObject("palavra"));
lista.add(palavrachave);
}
rs.close();
} catch (SQLException e) {
throw e;
}
return lista;
}
}
