package BlackJack.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static String name = "rm123";
	private static String senha = "123";
	
	public Connection conexao() throws ClassNotFoundException, SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", name, senha);
	}

}
