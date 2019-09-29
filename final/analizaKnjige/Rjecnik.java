package analizaKnjige;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

public class Rjecnik {
	private String cs;
	private Connection con;

	public Rjecnik(String cs) {
		super();
		this.cs = cs;
	}

	protected void connection() {
		try {
			con = DriverManager.getConnection(cs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void disconnect() {
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected HashMap<String, Integer> citanjeRjecnika() {
		HashMap<String, Integer> rjecnik = new HashMap<String, Integer>();
		try {
			Statement stm = con.createStatement();
			String upit = "SELECT word " + "FROM entries " + "GROUP BY word";
			ResultSet rs = stm.executeQuery(upit);
			while (rs.next()) {
				String rijec = rs.getString(1);
				rjecnik.put(rijec, 0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rjecnik;

	}

	protected void prosirivanjeRjecnika(HashMap<String, Integer> prosirenje) {
		ArrayList<String> prosirenjeLista = new ArrayList<>(prosirenje.keySet());
		Collections.sort(prosirenjeLista);
		Statement stm = null;
		try {
			stm = con.createStatement();
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "ProsirenjeRjecnika", null);
			if (!tables.next()) { // provjera da li ima tabela pod tim nazivom
				stm.execute("CREATE TABLE ProsirenjeRjecnika (rijec TEXT ); ");
			}

			String upis = "INSERT INTO ProsirenjeRjecnika (rijec) " + "VALUES (?)";
			PreparedStatement ps = con.prepareStatement(upis); // Ubacivanje svih elemenata liste
			for (int i = 0; i < prosirenjeLista.size(); i++) {
				String employeeId = UUID.randomUUID().toString();
				ps.setString(1, employeeId);
			}
			ps.executeBatch();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
