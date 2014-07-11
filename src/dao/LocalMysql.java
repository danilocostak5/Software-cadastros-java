package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Local;

import modelo.*;
public class LocalMysql{
ConnectionDao conexao = null;
private Statement comando;

public LocalMysql() throws Exception {
conexao = ConnectionDao.getInstance();
try {
this.comando = conexao.getConnection().createStatement();
} catch (SQLException e) {
throw e;
}
}
public long inserir(Local local) throws Exception {
String sql = "INSERT INTO local "+
"(cidade,estado,descricao) VALUES('" + local.getCidade() + "','"+ local.getEstado() + "','"+ local.getDescricao() + "')";
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
public void remover(Local local) throws Exception {
String sql = null;
long x = local.getId();
sql = "DELETE FROM local WHERE id = '"+x+"'";
try {
comando.executeUpdate(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public void atualizar(Local local) throws Exception {
long x = local.getId();
String sql = "UPDATE local SET "
+"cidade = '"+local.getCidade()+"',"+"estado = '"+local.getEstado()+"',"+"descricao = '"+local.getDescricao()+"'"
+" WHERE id = '"+x +"'";

try {
comando.executeUpdate(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public ArrayList<Local> listar(String condicao) throws Exception {
ArrayList<Local> lista = new ArrayList<>();
try {
ResultSet rs = comando.executeQuery("SELECT * FROM local "+condicao);
while (rs.next()) {
Local local = new Local();
local.setId(rs.getLong("id"));
//local.setId((Long)rs.getObject("id"));
local.setCidade(rs.getString("cidade"));
//local.setCidade((String)rs.getObject("cidade"));
local.setEstado(rs.getString("estado"));
//local.setEstado((String)rs.getObject("estado"));
local.setDescricao(rs.getString("descricao"));
//local.setDescricao((String)rs.getObject("descricao"));
lista.add(local);
}
rs.close();
} catch (SQLException e) {
throw e;
}
return lista;
}
}
