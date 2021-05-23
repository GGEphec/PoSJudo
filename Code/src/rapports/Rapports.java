/**
 * 
 */
package rapports;

import java.util.List;

import acceuil.DBHelper;

/**
 * @author gaeta_2b6psqs
 *
 * @version 23 mai 2021
 */
public class Rapports {

	/**
	 * Cette fonction va lister l'ensemble des ventes effectuées et les retourner sous forme d'un tableau affichable
	 * 
	 * @return Le tableau contenant les totaux des ventes par produit
	 */
	public static Object[][] affichageVente() {
		int sommeArticles=0;
		double sommeTotale = 0.0;
		
		List<String[]> rapport = DBHelper.getVentes();
		int totalLigne = rapport.size()+3;
		Object[][] vente = new Object[totalLigne][4];
		vente[0][0] = "Produit";
		vente[0][1] = "Prix unitaire";
		vente[0][2] = "Total vendu";
		vente[0][3] = "Somme vendu";
		vente[1][0] = "";
		vente[1][1] = "";
		vente[1][2] = "";
		vente[1][3] = "";
		int j=2;
		for(int i=0; i<totalLigne-3; i++, j++) {
			Object [] a = (Object[]) rapport.get(i);
			vente[j][0] = a[0].toString();
			vente[j][1] = a[1].toString();
			vente[j][2] = a[2].toString();
			sommeArticles+=Integer.parseInt(a[2].toString());
			vente[j][3] = a[3].toString();
			sommeTotale+=Double.parseDouble(a[3].toString());
		}
		vente[totalLigne-1][0] = "Total";
		vente[totalLigne-1][1] = "";
		vente[totalLigne-1][2] = sommeArticles;
		vente[totalLigne-1][3] = sommeTotale;

		return vente;
	}

	/**
	 * Cette fonction va lister les détails d'une mise en sécurité et les retourner sous forme d'un tableau affichable
	 * 
	 * @param idMeS L'id de la mise en sécurité dont on veut le résumé
	 * 
	 * @return Le tableau contenant les totaux d'une mise en sécurité
	 */
	//TODO a modifier
	public static Object[][] affichageMeS(int idMeS) {
		int sommeArticles=0;
		double sommeTotale = 0.0;
		
		List<String[]> rapport = DBHelper.getVentes();
		int totalLigne = rapport.size()+3;
		Object[][] mes = new Object[totalLigne][4];
		mes[0][0] = "Billets / Pièces";
		mes[0][1] = "Valeur";
		mes[0][2] = "Total échangés";
		mes[0][3] = "Somme";
		mes[1][0] = "";
		mes[1][1] = "";
		mes[1][2] = "";
		mes[1][3] = "";
		int j=2;
		for(int i=0; i<totalLigne-3; i++, j++) {
			Object [] a = (Object[]) rapport.get(i);
			mes[j][0] = a[0].toString();
			mes[j][1] = a[1].toString();
			mes[j][2] = a[2].toString();
			sommeArticles+=Integer.parseInt(a[2].toString());
			mes[j][3] = a[3].toString();
			sommeTotale+=Double.parseDouble(a[3].toString());
		}
		mes[totalLigne-1][0] = "Total";
		mes[totalLigne-1][1] = "";
		mes[totalLigne-1][2] = sommeArticles;
		mes[totalLigne-1][3] = sommeTotale;

		return mes;
	}

	
	/**
	 * Cette fonction va lister les détails d'un fond de caisse et les retourner sous forme d'un tableau affichable
	 * 
	 * @param idFdC L'id du fond de caisse dont on veut le résumé
	 * 
	 * @return Le tableau contenant les totaux d'un fond de caisse
	 */
	//TODO a modifier
	public static Object[][] affichageFdC(int idFdC) {
		int sommeArticles=0;
		double sommeTotale = 0.0;
		
		List<String[]> rapport = DBHelper.getVentes();
		int totalLigne = rapport.size()+3;
		Object[][] vente = new Object[totalLigne][4];
		vente[0][0] = "Produit";
		vente[0][1] = "Prix unitaire";
		vente[0][2] = "Total vendu";
		vente[0][3] = "Somme vendu";
		vente[1][0] = "";
		vente[1][1] = "";
		vente[1][2] = "";
		vente[1][3] = "";
		int j=2;
		for(int i=0; i<totalLigne-3; i++, j++) {
			Object [] a = (Object[]) rapport.get(i);
			vente[j][0] = a[0].toString();
			vente[j][1] = a[1].toString();
			vente[j][2] = a[2].toString();
			sommeArticles+=Integer.parseInt(a[2].toString());
			vente[j][3] = a[3].toString();
			sommeTotale+=Double.parseDouble(a[3].toString());
		}
		vente[totalLigne-1][0] = "Total";
		vente[totalLigne-1][1] = "";
		vente[totalLigne-1][2] = sommeArticles;
		vente[totalLigne-1][3] = sommeTotale;

		return vente;
	}
	
	
	/**
	 * Cette fonction va lister les détails d'un ticket et les retourner sous forme d'un tableau affichable
	 * 
	 * @param idTicket Le ticket dont on veut le résumé
	 * 
	 * @return Le tableau contenant les infos d'un ticket
	 */
	//TODO a modifier
	public static Object[][] affichageTicket(int idTicket) {
		int sommeArticles=0;
		double sommeTotale = 0.0;
		
		List<String[]> rapport = DBHelper.getVentes();
		int totalLigne = rapport.size()+3;
		Object[][] vente = new Object[totalLigne][4];
		vente[0][0] = "Produit";
		vente[0][1] = "Prix unitaire";
		vente[0][2] = "Total vendu";
		vente[0][3] = "Somme vendu";
		vente[1][0] = "";
		vente[1][1] = "";
		vente[1][2] = "";
		vente[1][3] = "";
		int j=2;
		for(int i=0; i<totalLigne-3; i++, j++) {
			Object [] a = (Object[]) rapport.get(i);
			vente[j][0] = a[0].toString();
			vente[j][1] = a[1].toString();
			vente[j][2] = a[2].toString();
			sommeArticles+=Integer.parseInt(a[2].toString());
			vente[j][3] = a[3].toString();
			sommeTotale+=Double.parseDouble(a[3].toString());
		}
		vente[totalLigne-1][0] = "Total";
		vente[totalLigne-1][1] = "";
		vente[totalLigne-1][2] = sommeArticles;
		vente[totalLigne-1][3] = sommeTotale;

		return vente;
	}
	

}
