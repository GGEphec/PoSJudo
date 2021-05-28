/**Cette classe va permettre de faire la liaison entre la base de données et le programme
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package acceuil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import argent.Argent;
import fondDeCaisse.FondDeCaisse;
import miseEnSecurite.MiseEnSecurite;
import parametrage.Parametrage;
import vente.Vente;

public class DBHelper {
//Variables d'instance
	//private static String db_prefix = "D:\\PosJudo\\Code\\mysql2\\posjudo";
	//private static String db_prefix = "mysql2/posjudo";
	private static String db = "";
	//private static String db_prefix = "\\opt\\posjudo\\DB";

	/**
	 * Main pour lancer la fonction runQuery
	 * @param args rien
	 */
//	public static void main(String[] args){
//		runQuery();
//	}

	public static void choixOS() {
		if(System.getProperty("os.name").toLowerCase().contains("win")) {
			db = "C:\\Users\\Public\\posjudo\\DB";
		}
		else {
			db = "\\opt\\posjudo\\DB";
		}
	}
	
	/**
	 * Fonction permettant d'exécuter des requetes sur la DB pour les parametres ou tests manuels
	 */
	public static void runQuery() {
		choixOS();
		Connection con = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", "");
			
			String select = "SHUTDOWN SCRIPT;";
			Statement stmt = con.createStatement();
			boolean a = stmt.execute(select);
			if(a) {
				System.out.println("reussi");
			}
			else {
				System.out.println("rate");
			}

			stmt.close();
		} catch (ClassNotFoundException ex) {
			System.out.println("classnotfound" + ex.getMessage());
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql" + e.getMessage());;
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Cette fonction va permettre de récupérer le dernier idCommande de la base de données
	 * 
	 * @return le dernier idCommande de la base de données
	 */
	public static int nextCommande() {
		choixOS();
		int maxCommande = 0;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSelect = "SELECT(MAX(\"idCommande\")) AS \"maxIdCommande\" FROM \"commandes\";";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				maxCommande = rset.getInt("maxIdCommande");
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return maxCommande;
	}
	
	
	/**
	 * Cette fonction va permettre de récupérer tous les produits enregistrés dans la base de données dans une liste
	 * 
	 * @return la liste de tous les produits enregistré en base de données
	 */
	public static List<Parametrage> getProduits() {
		choixOS();
		List<Parametrage> produit = new ArrayList<>();
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSelect = "SELECT * FROM \"produits\";";
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
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		choixOS();
		String sqlCommande1 = "INSERT INTO \"commandes\"(\"idCommande\", \"heureCommande\") VALUES ( " + idCommande + ", '" + heureCommande + "');";
		String sqlCommande2 = "";
		for(Parametrage p : contenu) {
			if(p.getVendu()>0) {
				sqlCommande2 +=("INSERT INTO \"contenucommande\"(\"idCommande\", \"idProduit\", \"nombreProduit\") VALUES(" + idCommande + ", " + p.getNumeroBoutton() + ", " + p.getVendu() + "); ");
			}
		}
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			stmt.execute(sqlCommande1);
			stmt.execute(sqlCommande2);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Cette fonction va permettre de récupérer le dernier idSortie de la base de données
	 * 
	 * @return le dernier idSortie de la base de données
	 */
	public static int getnextMiseEnSecurite() {
		choixOS();
		int maxMiseEnSecurite = 0;
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSelect = "SELECT(MAX(\"idSortie\")) AS \"maxIdMiseEnSecurite\" FROM \"sorties\";";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				maxMiseEnSecurite = rset.getInt("maxIdMiseEnSecurite");
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return maxMiseEnSecurite;
	}
	
	/**
	 * Cette fonction va permettre de récupérer tous les types d'argent stockés dans la base de données dans une liste
	 * 
	 * @return la liste de tous les types d'argent de la base de données
	 */
	public static List<Argent> getArgent() {
		choixOS();
		List<Argent> argent = new ArrayList<>();
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSelect = "SELECT * FROM \"argent\";";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				int id = rset.getInt("idArgent");
				double valeur = rset.getDouble("valeurArgente");
				Argent a = new Argent(id, valeur);
				argent.add(a);
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		choixOS();
		String sqlCommande1 = "INSERT INTO \"sorties\"(\"idSortie\", \"heureSortie\", \"responsables\") VALUES ( " + idMiseEnSecurite + ", '" + heureMiseEnSecurite + "', '" + responsables + "');";
		String sqlCommande2 = "";
		for(Argent a : contenuMiseEnSecurite) {
			if(a.getSorti()>0) {
				sqlCommande2 +=( "INSERT INTO \"contenusortie\"(\"idSortie\", \"idArgent\", \"nombreArgent\") VALUES (" + idMiseEnSecurite + ", " + a.getIdArgent() + ", " + a.getSorti() + "); ");
			}
		}
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			stmt.execute(sqlCommande1);
			stmt.execute(sqlCommande2);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Cette fonction va permettre de récupérer le total en caisse enregistré dans la base de données
	 * 
	 * @return le total en caisse enregistré dans la base de données
	 */
	public static double getTotal() {
		choixOS();
		double argentEnregistre = 0;
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSelect = "SELECT \"argentcaisse\" FROM \"memoire\";";
			ResultSet rset = stmt.executeQuery(strSelect);
			while (rset.next()) {
				argentEnregistre = rset.getDouble("argentcaisse");
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return argentEnregistre;
	}

	
	/**
	 * Cette fonction va permettre de mettre à jour le total en caisse enregistré dans la base de données
	 * 
	 * @param d la nouvelle valeur du total en caisse
	 */
	public static void setTotal(double d) {
		choixOS();
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSet = "UPDATE \"memoire\" SET \"argentcaisse\" = (" + d + ");";
			stmt.execute(strSet);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		choixOS();
		String sqlCommande1 = "INSERT INTO \"sorties\"(\"idSortie\", \"heureSortie\", \"responsables\") VALUES ( " + idFondDeCaisse + ", '" + heureFondDeCaisse + "', '" + responsables + "');";
		String sqlCommande2 = "";
		for(Argent a : contenuFondDeCaisse) {
			if(a.getSorti()>0) {
				sqlCommande2 +=( "INSERT INTO \"contenusortie\"(\"idSortie\", \"idArgent\", \"nombreArgent\") VALUES (" + idFondDeCaisse + ", " + a.getIdArgent() + ", " + a.getSorti() + "); ");
			}
		}
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
				stmt.execute(sqlCommande1);
				stmt.execute(sqlCommande2);
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Cette fonction permet de récupérer les paramètres d'un boutton stocké dans la base de données
	 * 
	 * @param btn le numéro du bouton dont on veut les données
	 * 
	 * @return les données du bouton dans un tablea
	 */
	public static Parametrage detailBoutton(int btn){
		choixOS();
		Parametrage p = new Parametrage(btn, true, 0, 0, 0, 0, "vide");
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSelect = "SELECT * FROM \"produits\" WHERE \"idProduit\" = " + btn + ";";
			ResultSet rset = stmt.executeQuery(strSelect);
			rset.next();
				p.setNumeroBoutton(rset.getInt("idProduit"));
				p.setVisible((rset.getInt("visibleProduit")==1) ? true : false);
				p.setPrix(rset.getDouble("prixUnitaireProduit"));
				p.setCouleurR(rset.getInt("couleurRProduit"));
				p.setCouleurG(rset.getInt("couleurGProduit"));
				p.setCouleurB(rset.getInt("couleurBProduit"));
				p.setDescription(rset.getString("descriptionProduit"));
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Cette fonction permet d'enregistrer les paramètres d'un boutton dans la base de données
	 * 
	 * @param param Les parametres du bouton
	 */
	public static void majBoutton(Parametrage param) {
		choixOS();
		String update = "UPDATE \"produits\" SET \"prixUnitaireProduit\" = " + param.getPrix() + ", \"visibleProduit\" = " + (param.isVisible()? 1 : 0) + ", \"couleurRProduit\" = " + param.getCouleurR() + ", \"couleurGProduit\" = " + param.getCouleurG() + ", \"couleurBProduit\" = " + param.getCouleurB() + ", \"descriptionProduit\" = '" + param.getDescription() +  "' WHERE \"idProduit\" = " + param.getNumeroBoutton() + ";";
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			stmt.execute(update);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * Cette fonction permet de fermer proprement la base de données
	 */
	public static void shutdown() {
		choixOS();
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			String strSet = "SHUTDOWN;";
			stmt.execute(strSet);
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		Acceuil.quit(db);
	}

	/**
	 * Cette fonction va récupérer le total des produits vendus lors d'une journée précise
	 * @param date La date dont on veut le total des produits vendus
	 * @return Retourne un tableau contenant le total des produits vendus
	 */
	public static List<String[]> getVentes(String date) {
		choixOS();
		List<String[]> rapport = new ArrayList<>();
		String select = "SELECT \"descriptionProduit\", \"prixUnitaireProduit\", (SUM(\"nombreProduit\")) AS \"totalVendu\", (SUM(\"nombreProduit\")*\"prixUnitaireProduit\") AS \"total\" FROM \"contenucommande\" NATURAL JOIN \"produits\" JOIN \"commandes\" ON \"commandes\".\"idCommande\" = \"contenucommande\".\"idCommande\" WHERE \"heureCommande\" LIKE '" + date + "%' GROUP BY \"idProduit\", \"descriptionProduit\", \"prixUnitaireProduit\";";
		try{
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(select);
			while (rset.next()) {
				String[] ligne = new String[4];
				ligne[0]=rset.getString("descriptionProduit");
				ligne[1]=Double.toString(rset.getDouble("prixUnitaireProduit"));
				ligne[2]=Integer.toString(rset.getInt("totalVendu"));
				ligne[3]=Double.toString(rset.getDouble("total"));
				rapport.add(ligne);
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rapport;
	}

	/**
	 * Cette fonction permet de récupérer les informations sur une mise en sécurité
	 * @param idMeS L'id de la mise en sécurité dont on veut les informations
	 * @return La mise en sécurité dont on souhaitait les informations
	 */
	public static MiseEnSecurite getMeS(int idMeS) {
		choixOS();
		MiseEnSecurite mes = null;
		List<Argent> contenuMeS = new ArrayList<Argent>();
		String select1 = "SELECT * FROM \"sorties\" WHERE \"responsables\" <> 'FondDeCaisse' AND \"idSortie\" = " + idMeS + ";";
		String select2 = "SELECT * FROM \"contenusortie\" NATURAL JOIN \"argent\" WHERE \"idSortie\" = " + idMeS + ";";
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();

			ResultSet rset2 = stmt.executeQuery(select2);
			while(rset2.next()) {
				contenuMeS.add(new Argent(rset2.getInt("idArgent"), rset2.getDouble("valeurArgente"), rset2.getInt("nombreArgent")));
			}
			
			ResultSet rset1 = stmt.executeQuery(select1);
			rset1.next();
			mes = new MiseEnSecurite(rset1.getInt("idSortie"), rset1.getString("heureSortie"), rset1.getString("responsables"), contenuMeS);
			
			stmt.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mes;
	}

	/**
	 * Cette fonction va nous donner l'id de la mise en sécurité la plus récente
	 * @return L'id de la mise en sécurité la plus récente
	 */
	public static int getMaxMeS() {
		choixOS();
		int maxMeS = 0;
		String select = "SELECT MAX(\"idSortie\") AS \"maxMeS\" FROM \"sorties\" WHERE \"responsables\" <> 'FondDeCaisse';";
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(select);
			rset.next();
			maxMeS = rset.getInt("maxMeS");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return maxMeS;
	}

	/**
	 * Cette fonction va vérifier que l'ID passé en argument est bien celui d'une mise en sécurité
	 * @param idMeS L'id que l'on veut vérifier
	 * @return true si l'id est bien celui d'une mise en sécurité, false sinon
	 */
	public static boolean getIsMeS(int idMeS) {
		choixOS();
		String select = "SELECT \"idSortie\" FROM \"sorties\" WHERE \"responsables\" <> 'FondDeCaisse';";
		boolean estUneMeS = false;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()) {
				if(rset.getInt("idSortie") == idMeS) {
					estUneMeS = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return estUneMeS;
	}

	/**
	 * Cette fonction va vérifier si l'ID passé en argument est bien celui d'un fonds de caisse
	 * @param idFdC L'id que l'on veut vérifier
	 * @return true si l'id est celui d'un fonds de caisse, false sinon
	 */
	public static boolean getIsFdC(int idFdC) {
		choixOS();
		String select = "SELECT \"idSortie\" FROM \"sorties\" WHERE \"responsables\" = 'FondDeCaisse';";
		boolean estUnFdC = false;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(select);
			while(rset.next()) {
				if(rset.getInt("idSortie") == idFdC) {
					estUnFdC = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		return estUnFdC;
	}

	/**
	 * Cette fonction va récupérer les informations sur un fonds de caisse sur base de son ID
	 * @param idFdC L'id du fonds de caisse dont on souhaite les informations
	 * @return Le fonds de caisse dont on voulait les informations
	 */
	public static FondDeCaisse getFdC(int idFdC) {
		choixOS();
		FondDeCaisse fdc = null;
		List<Argent> contenuFdC = new ArrayList<Argent>();
		String select1 = "SELECT * FROM \"sorties\" WHERE \"responsables\" = 'FondDeCaisse' AND \"idSortie\" = " + idFdC + ";";
		String select2 = "SELECT * FROM \"contenusortie\" NATURAL JOIN \"argent\" WHERE \"idSortie\" = " + idFdC + ";";
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();

			ResultSet rset2 = stmt.executeQuery(select2);
			while(rset2.next()) {
				contenuFdC.add(new Argent(rset2.getInt("idArgent"), rset2.getDouble("valeurArgente"), rset2.getInt("nombreArgent")));
			}
			
			ResultSet rset1 = stmt.executeQuery(select1);
			rset1.next();
			fdc = new FondDeCaisse(rset1.getInt("idSortie"), rset1.getString("heureSortie"), rset1.getString("responsables"), contenuFdC);
			
			stmt.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return fdc;
	}

	/**
	 * Cette fonction va récupérer l'id du fonds de caisse le plus récent
	 * @return L'id du fonds de caisse le plus récent
	 */
	public static int getMaxFdC() {
		choixOS();
		int maxFdC = 0;
		String select = "SELECT MAX(\"idSortie\") AS \"maxFdC\" FROM \"sorties\" WHERE \"responsables\" = 'FondDeCaisse';";
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(select);
			rset.next();
			maxFdC = rset.getInt("maxFdC");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return maxFdC;
	}

	/**
	 * Cette fonction va récupérer les informations sur une commande sur base de son ID
	 * @param idTicket L'id de la commande dont on souhaite récupérer les informations
	 * @return La commande dont on souhaitait récupérer les informations
	 */
	public static Vente getCommande(int idTicket) {
		choixOS();
		Vente commande = null;
		List<Parametrage> contenuCommande = new ArrayList<Parametrage>();
		String select1 = "SELECT * FROM \"commandes\" WHERE \"idCommande\" = " + idTicket + ";";
		String select2 = "SELECT * FROM \"contenucommande\" NATURAL JOIN \"produits\" WHERE \"idCommande\" = " + idTicket + ";";
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:" + db, "SA", ""); 
			Statement stmt = conn.createStatement();

			ResultSet rset2 = stmt.executeQuery(select2);
			while(rset2.next()) {
				contenuCommande.add(new Parametrage(rset2.getInt("idProduit"), (rset2.getInt("visibleProduit")==1 ? true : false), rset2.getDouble("prixUnitaireProduit"), rset2.getInt("couleurRProduit"), rset2.getInt("couleurGProduit"), rset2.getInt("couleurBProduit"), rset2.getString("descriptionProduit"), rset2.getInt("nombreProduit")));
			}
			
			ResultSet rset1 = stmt.executeQuery(select1);
			rset1.next();
			commande = new Vente(rset1.getInt("idCommande"), rset1.getString("heureCommande"), contenuCommande);
			
			stmt.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return commande;
		
	}
}
