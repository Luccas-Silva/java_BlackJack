package BlackJack.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import BlackJack.conexoes.ConexaoFactory;

public class CardDAO {
	
	public Connection conexao;
	
	public CardDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().conexao();
	}
	
	public String createTable(){
		return null;
	}
	
	public String insert(){
		return null;
	}
	
	public String delete(){
		return null;
	}
	
	public String update(){
		return null;
	}
	
	public String select(){
		return null;
	}

}
