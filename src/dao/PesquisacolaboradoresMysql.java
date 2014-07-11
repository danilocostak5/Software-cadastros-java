package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.*;

public class PesquisacolaboradoresMysql{
ConnectionDao conexao = null;
private Statement comando;

public PesquisacolaboradoresMysql() throws Exception {
conexao = ConnectionDao.getInstance();
try {
this.comando = conexao.getConnection().createStatement();
} catch (SQLException e) {
throw e;
}
}
public void inserir(long id, ArrayList<Pesquisador> lista) throws Exception{
for(Pesquisador x:lista){
String sql = "INSERT INTO Pesquisacolaboradores (id1,id2) VALUES("+id+","+x.getId()+")";
try {
comando.execute(sql.toString());
} catch (SQLException e) {
throw e;
}
}}
public void remover(long id) throws Exception{
String sql = "DELETE FROM Pesquisacolaboradores WHERE id1 = "+id;
try {
comando.execute(sql.toString());
} catch (SQLException e) {
throw e;
}
}
public ArrayList<Pesquisador> listar(long id) throws Exception{
ArrayList<Pesquisador> lista = new ArrayList<>();
if(id>0){
String sql = "SELECT * FROM Pesquisacolaboradores WHERE id1 = "+id;
try {
ResultSet rs = comando.executeQuery(sql);
while (rs.next()) {
Pesquisador x = new PesquisadorMysql().listar(" WHERE id="+(rs.getLong("id2"))).get(0);
lista.add(x);
//lista.add(new Pesquisador(rs.getLong("id2")));
}
rs.close();
} catch (SQLException e) {
throw e;
}
}
return lista;
}
}
