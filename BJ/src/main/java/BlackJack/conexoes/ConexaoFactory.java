package BlackJack.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static String name = "rm552890";
	private static String senha = "130604";
	
	public Connection conexao() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", name, senha);
	}

}
