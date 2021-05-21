/**Cette classe va permettre de faire la liaison entre la base de données et le programme
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package acceuil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import argent.Argent;
import parametrage.Parametrage;

public class DBHelper {
	/**
	 * Cette fonction va permettre de récupérer le dernier idCommande de la base de données
	 * 
	 * @return le dernier idCommande de la base de données
	 */
	public static int nextCommande() {
		int maxCommande = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT(MAX(idCommande)) AS 'maxIdCommande' FROM commandes;";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				maxCommande = rset.getInt("maxIdCommande");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return maxCommande;
	}
	
	
	/**
	 * Cette fonction va permettre de récupérer tous les produits enregistrés dans la base de données dans une liste
	 * 
	 * @return la liste de tous les produits enregistré en base de données
	 */
	public static List<Parametrage> getProduits() {
		List<Parametrage> produit = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT * FROM produits;";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
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
		return produit;
	}

	
	/**
	 * Cette fonction va permettre d'enregistrer une commande dans la base de données. Elle va excécuter 2 requêtes pour enregistrer la commande et son contenu
	 * 
	 * @param idCommande l'id de la commande à enregistrer
	 * @param heureCommande l'heure de la commande à enregistrer
	 * @param contenu le contenu de la commande à enregistrer
	 */
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
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			stmt.execute(sqlCommande1);
			stmt.execute(sqlCommande2);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	/**
	 * Cette fonction va permettre de récupérer le dernier idSortie de la base de données
	 * 
	 * @return le dernier idSortie de la base de données
	 */
	public static int getnextMiseEnSecurite() {
		int maxMiseEnSecurite = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT(MAX(idSortie)) AS 'maxIdMiseEnSecurite' FROM sorties;";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				maxMiseEnSecurite = rset.getInt("maxIdMiseEnSecurite");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return maxMiseEnSecurite;
	}
	
	/**
	 * Cette fonction va permettre de récupérer tous les types d'argent stockés dans la base de données dans une liste
	 * 
	 * @return la liste de tous les types d'argent de la base de données
	 */
	public static List<Argent> getArgent() {
		List<Argent> argent = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT * FROM argent;";
			ResultSet rset = stmt.executeQuery(strSelect);
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
	

	/**
	 * Cette fonction va permettre d'enregister une sortie d'argent lors d'une mise en sécurité dans la base de données. Elle va excécuter 2 requêtes pour enregistrer la mise en sécurité et son contenu
	 * 
	 * @param idMiseEnSecurite l'id de la mise en sécurité à enregistrer
	 * @param heureMiseEnSecurite l'heure de la mise en sécurité à enregistrer
	 * @param responsables les responsables de la mise en sécurite à enregistrer
	 * @param contenuMiseEnSecurite le contenu de la mise en sécurité à enregistrer
	 */
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

	
	/**
	 * Cette fonction va permettre de récupérer le total en caisse enregistré dans la base de données
	 * 
	 * @return le total en caisse enregistré dans la base de données
	 */
	public static double getTotal() {
		double argentEnregistre = 0;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSelect = "SELECT argentCaisse FROM memoire;";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				argentEnregistre = rset.getDouble("argentCaisse");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return argentEnregistre;
	}

	
	/**
	 * Cette fonction va permettre de mettre à jour le total en caisse enregistré dans la base de données
	 * 
	 * @param d la nouvelle valeur du total en caisse
	 */
	public static void setTotal(double d) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjudo", "posjudo", "87tx3"); 
			Statement stmt = conn.createStatement();) {
			String strSet = "UPDATE memoire SET argentcaisse = (" + d + ");";
			stmt.execute(strSet);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

	
	/**
	 * Cette fonction va permettre d'enregistrer le fond de caisse dans la base de données. Elle va exécuter deux requêtes, une pour enregistrer le fond de caisse et son contenu
	 * 
	 * @param idFondDeCaisse L'id du fond de caisse à enregistrer
	 * @param heureFondDeCaisse L'heure du fond de caisse à enregistrer
	 * @param responsables Les responsables du fond de caisse à enregistrer
	 * @param contenuFondDeCaisse Le contenu du fond de caisse à enregistrer
	 */
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
