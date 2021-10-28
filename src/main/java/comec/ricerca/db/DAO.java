package comec.ricerca.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import comec.ricerca.model.Item;
import comec.ricerca.model.Item.Categoria;
import comec.ricerca.model.Vendita;

public class DAO {
	
	public void loadAllItems(List<Item> items, List<String> materials){
		String sql = "SELECT * from items";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Item i = null;
				if(rs.getString("categoria")==null)
						i = new Item(rs.getString("item"), Categoria.N, rs.getString("materiale"), 
								rs.getDouble("dint"), rs.getDouble("dest"), rs.getDouble("h"), rs.getDouble("sp"));
				else if(rs.getString("categoria").equals("S1"))
						i = new Item(rs.getString("item"), Categoria.S1, rs.getString("materiale"), 
						rs.getDouble("dint"), rs.getDouble("dest"), rs.getDouble("h"), rs.getDouble("sp"));
				else if(rs.getString("categoria").equals("S2"))
						i = new Item(rs.getString("item"), Categoria.S2, rs.getString("materiale"), 
							rs.getDouble("dint"), rs.getDouble("dest"), rs.getDouble("h"), rs.getDouble("sp"));
				items.add(i);
				if(!materials.contains(i.getMateriale()))
					materials.add(i.getMateriale());
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public Item inserisci(Item item) {
		String sql = "INSERT INTO items VALUES (?,?,?,?,?,?,?)";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, item.getCodice());
			if(item.getCategoria()==Categoria.N)
				st.setString(2, null);
			else
				st.setString(2, item.getCategoria().toString());
			st.setString(3, item.getMateriale());
			st.setDouble(4, item.getDint());
			st.setDouble(5, item.getDest());
			st.setDouble(6, item.getSp());
			st.setDouble(7, item.getH());
			st.executeQuery() ;
			conn.close();
			return item;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Errore connessione al database");
		throw new RuntimeException("Error Connection Database");
		}
	}

	public Item elimina(Item item) {
		String sql = "DELETE FROM items WHERE item = ?";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, item.getCodice());
			st.executeQuery() ;
			conn.close();
			return item;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Errore connessione al database");
		throw new RuntimeException("Error Connection Database");
		}
	}

	public void loadVendite(List<Vendita> vendite, List<Item> items) {
		String sql = "SELECT * FROM vendite_2019";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String codice = rs.getString("item");
				for(Item i : items)
					if(i.getCodice().equals(codice)) {
						vendite.add(new Vendita(i, rs.getInt("num_pezzi"), rs.getDouble("importo"), rs.getDouble("costo_primo")));
						break;
					}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
			}	
	}
	
}
