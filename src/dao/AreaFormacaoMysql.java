package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.AreaFormacao;

import modelo.*;
public class AreaFormacaoMysql{
ConnectionDao conexao = null;
private Statement comando;

public AreaFormacaoMysql() throws Exception {
conexao = ConnectionDao.getInstance();
try {
this.comando = conexao.getConnection().createStatement();
} catch (SQLException e) {
throw e;
}
}
public long inserir(AreaFormacao areaformacao) throws Exception {
String sql = "INSERT INTO areaformacao "+
"(nome) VALUES('" + areaformacao.getNome() + "')";
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
public void remover(AreaFormacao areaformacao) throws Exception {
String sql = null;
long x = areaformacao.getId();
sql = "DELETE FROM areaformacao WHERE id = '"+x+"'";
try {
comando.executeUpdate(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public void atualizar(AreaFormacao areaformacao) throws Exception {
long x = areaformacao.getId();
String sql = "UPDATE areaformacao SET "
+"nome = '"+areaformacao.getNome()+"'"
+" WHERE id = '"+x +"'";

try {
comando.executeUpdate(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public ArrayList<AreaFormacao> listar(String condicao) throws Exception {
ArrayList<AreaFormacao> lista = new ArrayList<>();
try {
ResultSet rs = comando.executeQuery("SELECT * FROM areaformacao "+condicao);
while (rs.next()) {
AreaFormacao areaformacao = new AreaFormacao();
areaformacao.setId(rs.getLong("id"));
//areaformacao.setId((Long)rs.getObject("id"));
areaformacao.setNome(rs.getString("nome"));
//areaformacao.setNome((String)rs.getObject("nome"));
lista.add(areaformacao);
}
rs.close();
} catch (SQLException e) {
throw e;
}
return lista;
}
}
