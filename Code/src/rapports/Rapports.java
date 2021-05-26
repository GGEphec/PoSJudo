/**
 * 
 */
package rapports;

import java.util.List;

import javax.swing.JOptionPane;

import acceuil.DBHelper;

/**
 * @author gaeta_2b6psqs
 *
 * @version 23 mai 2021
 */
public class Rapports {

	/**
	 * Cette fonction va lister l'ensemble des ventes effectuées un jour précis et les retourner sous forme d'un tableau affichable
	 * @param date La date dont on veut récupérer le résumé des ventes
	 * 
	 * @return Le tableau contenant les totaux des ventes par produit
	 */
	public static Object[][] affichageVente(String date) {
		int sommeArticles=0;
		double sommeTotale = 0.0;
		
		List<String[]> rapport = DBHelper.getVentes(date);
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
	public static Object[][] affichageMeS(int idMeS) {
		Object[][] rapport = null;
		if(DBHelper.getIsMeS(idMeS)) {
			rapport = (DBHelper.getMeS(idMeS)).affichage();
		}
		else {
			JOptionPane.showMessageDialog(null, "L'id entré n'est pas une mise en sécurité mais un fonds de caisse");
			rapport = new Object[2][4];
		}
		return rapport;

	}

	
	/**
	 * Cette fonction va lister les détails d'un fond de caisse et les retourner sous forme d'un tableau affichable
	 * 
	 * @param idFdC L'id du fond de caisse dont on veut le résumé
	 * 
	 * @return Le tableau contenant les totaux d'un fond de caisse
	 */
	public static Object[][] affichageFdC(int idFdC) {
		Object[][] rapport = null;
		if(DBHelper.getIsFdC(idFdC)) {
			rapport = (DBHelper.getFdC(idFdC)).affichage();
		}
		else {
			JOptionPane.showMessageDialog(null, "L'id entré n'est pas un fonds de caisse mais une mise en sécurité");
			rapport = new Object[2][4];
		}
		return rapport;
	}
	
	
	/**
	 * Cette fonction va lister les détails d'un ticket et les retourner sous forme d'un tableau affichable
	 * 
	 * @param idTicket Le ticket dont on veut le résumé
	 * 
	 * @return Le tableau contenant les infos d'un ticket
	 */
	public static Object[][] affichageTicket(int idTicket) {
		Object[][] rapport = (DBHelper.getCommande(idTicket)).affichage();
		return rapport;
	}
	

}
