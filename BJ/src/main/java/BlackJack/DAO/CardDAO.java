package BlackJack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BlackJack.conexoes.ConexaoFactory;
import BlackJack.model.Card;

public class CardDAO {
	
	private Connection conexao;
	
	public CardDAO() throws ClassNotFoundException, SQLException {
		this.conexao = new ConexaoFactory().conexao();
	}
	
	public String createTable() throws SQLException{
		PreparedStatement stmt = conexao.prepareStatement("drop table Card cascade constraints;"
				+ "create table Card("
				+ "code varchar(10) primary key,"
				+ "value varchar(10),"
				+ "suit varchar(10),"
				+ "remaining number(3));");
		stmt.execute();
		stmt.close();
		return "Cadastro com sucesso!";
	}
	
	public String insert(Card card) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("insert into "
				+ "Card values (?,?,?,?)");
		stmt.setString(1, card.getCode());
		stmt.setString(2, card.getValue());
		stmt.setString(3, card.getSuit());
		stmt.setInt(4, card.getRemaining());
		stmt.execute();
		stmt.close();
		return "Cadastro com sucesso!";
	}
	
	public String delete(String code) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("delete from "
				+ "Card where code = ?");
		stmt.setString(1, code);
		stmt.execute();
		stmt.close();
		return "Deletado com sucesso!";
	}
	
	public String update(Card card) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("update Card set code = ?, "
				+ "value = ?, remaining = ?, where code = ?");
		stmt.setString(1, card.getCode());
		stmt.setString(2, card.getValue());
		stmt.setString(3, card.getSuit());
		stmt.setInt(4, card.getRemaining());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com sucesso!";
	}
	
	public List<Card> select() throws SQLException {
		List<Card> cards = new ArrayList<>();
		
		PreparedStatement stmt = conexao.prepareStatement("select * from Card");
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Card card = new Card();
			card.setCode(rs.getString(1));
			card.setValue(rs.getString(2));
			card.setSuit(rs.getString(3));
			card.setRemaining(rs.getInt(4));
			cards.add(card);
		}
		
		return cards;
	}

}
