/**Cette classe est la première classe qui est appellée quand on lance l'application
 * Elle va lancer la première vue et initialiser l'argent en caisse à 0
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package acceuil;

import java.io.*;

public class Acceuil {

	/**
	 * Lance la première vue
	 * Initialise l'argent en caisse à 0
	 * 
	 * @param args /
	 */
	public static void main(String[] args) {
		while(!creationFichierDB()) {
			System.out.println("chargement");
		}
		//DBHelper.setTotal(0); Mettre l'argent en caisse à zéro
		AcceuilView window = new AcceuilView();
		window.vueAcceuil.setVisible(true);
	}

	/**
	 * Création des fichiers pour la DB si non existant
	 * Vérification que la DB ne soit pas bloquée si déjà existante
	 * @return 
	 */
	private static boolean creationFichierDB() {
		String db = "";
		if(System.getProperty("os.name").toLowerCase().contains("win")) {
			db = "C:\\USers\\Public\\posjudo\\DB.";
		}
		else {
			db = "\\opt\\posjudo\\DB.";
		}
		try {
			File script = new File(db+"script");
			if(script.createNewFile()) { //Nouvelle DB
				FileWriter ecrire = new FileWriter(db+"script");
				ecrire.write("SET DATABASE UNIQUE NAME HSQLDB79956F580B\r\n"
						+ "SET DATABASE GC 0\r\n"
						+ "SET DATABASE DEFAULT RESULT MEMORY ROWS 0\r\n"
						+ "SET DATABASE EVENT LOG LEVEL 0\r\n"
						+ "SET DATABASE TRANSACTION CONTROL LOCKS\r\n"
						+ "SET DATABASE DEFAULT ISOLATION LEVEL READ COMMITTED\r\n"
						+ "SET DATABASE TRANSACTION ROLLBACK ON CONFLICT TRUE\r\n"
						+ "SET DATABASE TEXT TABLE DEFAULTS ''\r\n"
						+ "SET DATABASE SQL NAMES FALSE\r\n"
						+ "SET DATABASE SQL REFERENCES FALSE\r\n"
						+ "SET DATABASE SQL SIZE TRUE\r\n"
						+ "SET DATABASE SQL TYPES FALSE\r\n"
						+ "SET DATABASE SQL TDC DELETE TRUE\r\n"
						+ "SET DATABASE SQL TDC UPDATE TRUE\r\n"
						+ "SET DATABASE SQL CONCAT NULLS TRUE\r\n"
						+ "SET DATABASE SQL UNIQUE NULLS TRUE\r\n"
						+ "SET DATABASE SQL CONVERT TRUNCATE TRUE\r\n"
						+ "SET DATABASE SQL AVG SCALE 0\r\n"
						+ "SET DATABASE SQL DOUBLE NAN TRUE\r\n"
						+ "SET FILES WRITE DELAY 0 MILLIS\r\n"
						+ "SET FILES BACKUP INCREMENT TRUE\r\n"
						+ "SET FILES CACHE SIZE 10000\r\n"
						+ "SET FILES CACHE ROWS 50000\r\n"
						+ "SET FILES SCALE 32\r\n"
						+ "SET FILES LOB SCALE 32\r\n"
						+ "SET FILES DEFRAG 0\r\n"
						+ "SET FILES NIO TRUE\r\n"
						+ "SET FILES NIO SIZE 256\r\n"
						+ "SET FILES LOG TRUE\r\n"
						+ "SET FILES LOG SIZE 50\r\n"
						+ "SET FILES CHECK 819\r\n"
						+ "SET DATABASE COLLATION \"SQL_TEXT\" PAD SPACE\r\n"
						+ "CREATE USER SA PASSWORD DIGEST 'd41d8cd98f00b204e9800998ecf8427e'\r\n"
						+ "ALTER USER SA SET LOCAL TRUE\r\n"
						+ "CREATE SCHEMA PUBLIC AUTHORIZATION DBA\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"argent\"(\"idArgent\" INTEGER NOT NULL PRIMARY KEY,\"valeurArgente\" DOUBLE NOT NULL)\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"commandes\"(\"idCommande\" INTEGER NOT NULL PRIMARY KEY,\"heureCommande\" TIMESTAMP NOT NULL)\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"produits\"(\"idProduit\" INTEGER NOT NULL PRIMARY KEY,\"visibleProduit\" INTEGER NOT NULL,\"prixUnitaireProduit\" DOUBLE NOT NULL,\"couleurRProduit\" INTEGER NOT NULL,\"couleurGProduit\" INTEGER NOT NULL,\"couleurBProduit\" INTEGER NOT NULL,\"descriptionProduit\" VARCHAR(20) NOT NULL)\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"contenucommande\"(\"idCommande\" INTEGER NOT NULL,\"idProduit\" INTEGER NOT NULL,\"nombreProduit\" INTEGER NOT NULL,PRIMARY KEY(\"idCommande\",\"idProduit\"),FOREIGN KEY(\"idCommande\") REFERENCES PUBLIC.\"commandes\"(\"idCommande\"),FOREIGN KEY(\"idProduit\") REFERENCES PUBLIC.\"produits\"(\"idProduit\"))\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"sorties\"(\"idSortie\" INTEGER NOT NULL PRIMARY KEY,\"heureSortie\" TIMESTAMP NOT NULL,\"responsables\" VARCHAR(50) NOT NULL)\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"contenusortie\"(\"idSortie\" INTEGER NOT NULL,\"idArgent\" INTEGER NOT NULL,\"nombreArgent\" INTEGER NOT NULL,PRIMARY KEY(\"idSortie\",\"idArgent\"),FOREIGN KEY(\"idSortie\") REFERENCES PUBLIC.\"sorties\"(\"idSortie\"),FOREIGN KEY(\"idArgent\") REFERENCES PUBLIC.\"argent\"(\"idArgent\"))\r\n"
						+ "CREATE MEMORY TABLE PUBLIC.\"memoire\"(\"argentcaisse\" DOUBLE NOT NULL)\r\n"
						+ "ALTER SEQUENCE SYSTEM_LOBS.LOB_ID RESTART WITH 1\r\n"
						+ "SET DATABASE DEFAULT INITIAL SCHEMA PUBLIC\r\n"
						+ "GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.CARDINAL_NUMBER TO PUBLIC\r\n"
						+ "GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.YES_OR_NO TO PUBLIC\r\n"
						+ "GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.CHARACTER_DATA TO PUBLIC\r\n"
						+ "GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.SQL_IDENTIFIER TO PUBLIC\r\n"
						+ "GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.TIME_STAMP TO PUBLIC\r\n"
						+ "GRANT DBA TO SA\r\n"
						+ "SET SCHEMA SYSTEM_LOBS\r\n"
						+ "INSERT INTO BLOCKS VALUES(0,2147483647,0)\r\n"
						+ "SET SCHEMA PUBLIC\r\n"
						+ "INSERT INTO \"argent\" VALUES(1,0.01E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(2,0.02E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(5,0.05E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(10,0.1E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(20,0.2E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(50,0.5E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(100,1.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(200,2.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(500,5.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(1000,10.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(2000,20.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(5000,50.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(10000,100.0E0)\r\n"
						+ "INSERT INTO \"argent\" VALUES(20000,200.0E0)\r\n"
						+ "INSERT INTO \"produits\" VALUES(11,1,1.5E0,255,0,0,'Ticket rouge')\r\n"
						+ "INSERT INTO \"produits\" VALUES(12,1,1.5E0,255,0,0,'Eau plate')\r\n"
						+ "INSERT INTO \"produits\" VALUES(13,1,1.5E0,255,0,0,'Eau p\\u00e9tillante')\r\n"
						+ "INSERT INTO \"produits\" VALUES(14,1,1.5E0,255,0,0,'Coca cola')\r\n"
						+ "INSERT INTO \"produits\" VALUES(15,1,1.5E0,255,0,0,'Coca light')\r\n"
						+ "INSERT INTO \"produits\" VALUES(16,1,1.5E0,255,0,0,'Limonade')\r\n"
						+ "INSERT INTO \"produits\" VALUES(21,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(22,1,2.0E0,0,0,255,'Ice tea')\r\n"
						+ "INSERT INTO \"produits\" VALUES(23,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(24,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(25,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(26,1,1.5E0,255,0,0,'Jus de fruits')\r\n"
						+ "INSERT INTO \"produits\" VALUES(31,1,2.0E0,0,0,255,'Ticket Bleu')\r\n"
						+ "INSERT INTO \"produits\" VALUES(32,1,2.0E0,0,0,255,'Kriek')\r\n"
						+ "INSERT INTO \"produits\" VALUES(33,1,2.0E0,0,0,255,'Blanche')\r\n"
						+ "INSERT INTO \"produits\" VALUES(34,1,2.0E0,0,0,255,'Vin au verre')\r\n"
						+ "INSERT INTO \"produits\" VALUES(35,1,1.5E0,255,0,0,'Pils')\r\n"
						+ "INSERT INTO \"produits\" VALUES(36,1,2.5E0,0,255,255,'Gouyasse')\r\n"
						+ "INSERT INTO \"produits\" VALUES(41,1,3.0E0,255,165,0,'Ticket orange')\r\n"
						+ "INSERT INTO \"produits\" VALUES(42,1,3.0E0,255,165,0,'Chimay bleue')\r\n"
						+ "INSERT INTO \"produits\" VALUES(43,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(44,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(45,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(46,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(51,1,2.5E0,0,255,255,'Ticket jaune')\r\n"
						+ "INSERT INTO \"produits\" VALUES(52,1,2.5E0,0,255,255,'Petit d\\u00e9jeuner')\r\n"
						+ "INSERT INTO \"produits\" VALUES(53,1,2.5E0,0,255,255,'Sandwich')\r\n"
						+ "INSERT INTO \"produits\" VALUES(54,1,2.5E0,0,255,255,'Hot Dog')\r\n"
						+ "INSERT INTO \"produits\" VALUES(55,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(56,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(61,0,0.0E0,0,0,0,'')\r\n"
						+ "INSERT INTO \"produits\" VALUES(62,1,1.5E0,255,0,0,'Caf\\u00e9')\r\n"
						+ "INSERT INTO \"produits\" VALUES(63,1,1.5E0,255,0,0,'Chocolat chaud')\r\n"
						+ "INSERT INTO \"produits\" VALUES(64,1,1.5E0,255,0,0,'Couque')\r\n"
						+ "INSERT INTO \"produits\" VALUES(65,1,1.5E0,255,0,0,'Chips')\r\n"
						+ "INSERT INTO \"produits\" VALUES(66,1,1.5E0,255,0,0,'Bonbons')\r\n"
						+ "INSERT INTO \"memoire\" VALUES(20.0E0)\r\n");
				ecrire.close();
				
			}
			else { //DB existe déjà
				File temp = new File(db+"lck");
				if(temp.exists()) { //Verifie si il n'y a pas un fichier lck qui bloque la db
					System.out.println("delete lck");
					temp.delete(); //Si oui on supprime
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
	
}
