package acceuil;

/**
 * @author gaeta_2b6psqs
 *
 */
import java.sql.*; // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import argent.Argent;
import parametrage.Parametrage;
import vente.Vente;

public class DBHelper { // Save as "JdbcSelectTest.java"
	public static void main(String[] args) {

	}

	/**
	 * Get last idCommande from Database
	 * 
	 * @return
	 */
	public static int nextCommande() {
		int maxCommande = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT(MAX(idCommande)) AS 'maxIdCommande' FROM commandes;";
			//System.out.println("The SQL statement is: " + strSelect + "\n");

			ResultSet rset = stmt.executeQuery(strSelect);
			//System.out.println("The records selected are:");

			while (rset.next()) { // Repeatedly process each row
				maxCommande = rset.getInt("maxIdCommande");

				//System.out.println(maxCommande);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return maxCommande;
	}

	public static List<Parametrage> getProduits() {
		List<Parametrage> produit = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT * FROM produits;";
			//System.out.println("The SQL statement is: " + strSelect + "\n");

			ResultSet rset = stmt.executeQuery(strSelect);
			//System.out.println("The records selected are:");

			while (rset.next()) { // Repeatedly process each row
				int btn = rset.getInt("idProduit");
				boolean visible = (rset.getInt("visibleProduit")==1) ? true : false;
				double prix = rset.getDouble("prixUnitaireProduit");
				int couleurR = rset.getInt("couleurRProduit");
				int couleurG = rset.getInt("couleurGProduit");
				int couleurB = rset.getInt("couleurBProduit");
				String description = rset.getString("descriptionProduit");
				Parametrage p = new Parametrage(btn, visible, prix, couleurR, couleurG, couleurB, description);
				produit.add(p);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//System.out.println(produit);
		return produit;
	}

	public static void enregistrerCommande(int idCommande, String heureCommande, List<Parametrage> contenu) {
		String sqlCommande1 = "INSERT INTO commandes(idCommande, heureCommande) VALUES ( " + idCommande + ", '" + heureCommande + "');";
		String sqlCommande2 = "INSERT INTO contenuCommande VALUES ";
		for(Parametrage p : contenu) {
			if(p.getVendu()>0) {
				sqlCommande2 +=( "(" + idCommande + ", " + p.getNumeroBoutton() + ", " + p.getVendu() + "),");
			}
		}
		sqlCommande2 = sqlCommande2.substring(0, sqlCommande2.length() -1);
		sqlCommande2 +=";";
		System.out.println(sqlCommande2);

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
				Statement stmt = conn.createStatement();) {
				stmt.execute(sqlCommande1);
				stmt.execute(sqlCommande2);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}

	public static int getnextMiseEnSecurite() {
		int maxMiseEnSecurite = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT(MAX(idSortie)) AS 'maxIdMiseEnSecurite' FROM sorties;";
			//System.out.println("The SQL statement is: " + strSelect + "\n");

			ResultSet rset = stmt.executeQuery(strSelect);
			//System.out.println("The records selected are:");

			while (rset.next()) { // Repeatedly process each row
				maxMiseEnSecurite = rset.getInt("maxIdMiseEnSecurite");

				//System.out.println(maxCommande);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return maxMiseEnSecurite;
	}

	public static List<Argent> getArgent() {
		List<Argent> argent = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT * FROM argent;";
			//System.out.println("The SQL statement is: " + strSelect + "\n");

			ResultSet rset = stmt.executeQuery(strSelect);
			//System.out.println("The records selected are:");

			while (rset.next()) {
				int id = rset.getInt("idArgent");
				double valeur = rset.getDouble("valeurArgente");
				Argent a = new Argent(id, valeur);
				argent.add(a);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return argent;
	}

	public static void enregistrerMiseEnSecurite(int idMiseEnSecurite, String heureMiseEnSecurite, String responsables, List<Argent> contenuMiseEnSecurite) {
		String sqlCommande1 = "INSERT INTO sorties(idSortie, heureSortie, responsables) VALUES ( " + idMiseEnSecurite + ", '" + heureMiseEnSecurite + "', '" + responsables + "');";
		String sqlCommande2 = "INSERT INTO contenuSortie VALUES ";
		for(Argent a : contenuMiseEnSecurite) {
			if(a.getSorti()>0) {
				sqlCommande2 +=( "(" + idMiseEnSecurite + ", " + a.getIdArgent() + ", " + a.getSorti() + "),");
			}
		}
		sqlCommande2 = sqlCommande2.substring(0, sqlCommande2.length() -1);
		sqlCommande2 +=";";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
				Statement stmt = conn.createStatement();) {
				stmt.execute(sqlCommande1);
				stmt.execute(sqlCommande2);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}

	public static double getTotal() {
		double argentEnregistre = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT argentCaisse FROM memoire;";
			//System.out.println("The SQL statement is: " + strSelect + "\n");

			ResultSet rset = stmt.executeQuery(strSelect);
			//System.out.println("The records selected are:");

			while (rset.next()) { // Repeatedly process each row
				argentEnregistre = rset.getDouble("argentCaisse");

				//System.out.println(maxCommande);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return argentEnregistre;
	}

	public static void setTotal(double d) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSet = "UPDATE memoire SET argentcaisse = (" + d + ");";
			stmt.execute(strSet);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

	public static void enregistrerFondDeCaisse(int idFondDeCaisse, String heureFondDeCaisse, String responsables, List<Argent> contenuFondDeCaisse) {
		String sqlCommande1 = "INSERT INTO sorties(idSortie, heureSortie, responsables) VALUES ( " + idFondDeCaisse + ", '" + heureFondDeCaisse + "', '" + responsables + "');";
		String sqlCommande2 = "INSERT INTO contenuSortie VALUES ";
		for(Argent a : contenuFondDeCaisse) {
			if(a.getSorti()>0) {
				sqlCommande2 +=( "(" + idFondDeCaisse + ", " + a.getIdArgent() + ", " + a.getSorti() + "),");
			}
		}
		sqlCommande2 = sqlCommande2.substring(0, sqlCommande2.length() -1);
		sqlCommande2 +=";";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
				Statement stmt = conn.createStatement();) {
				stmt.execute(sqlCommande1);
				stmt.execute(sqlCommande2);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}


}
