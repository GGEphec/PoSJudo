/**Cette classe va permettre de créer le modèle de mise en sécurité qui sera utilisée pour déterminer quel est la somme et le détail de l'argent qui est mis de côté
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package miseEnSecurite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import acceuil.DBHelper;
import argent.Argent;


public class MiseEnSecurite {
//Variables d'instance
	private int idMiseEnSecurite; //L'id de la mise en sécurité
	private String heureMiseEnSecurite; //L'heure de la mise en sécurité
	private String responsables; //Les responsables de la mise en sécurité
	private List<Argent> contenuMiseEnSecurite; //le contenu de la mise en sécurité

	private int nbre; //Variable temporaire pour déterminer le nombre encodé sur le pavé numérique
	
//Constructeur
	/**
	 * Le constructeur d'un objet miseEnSecurite
	 * L'objet miseEnSecurite est par défaut initialisé par des valeurs pré-calculées ou nulles
	 */
	public MiseEnSecurite() {
		this.idMiseEnSecurite = DBHelper.getnextMiseEnSecurite()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureMiseEnSecurite = dtf.format(now);
		this.responsables = "JCG";
		this.contenuMiseEnSecurite = DBHelper.getArgent();
	}
	
//Méthodes
	/**
	 * Permet d'initialiser la vue miseEnSecurite
	 */
	public static void initialise() {
		MiseEnSecuriteView window = new MiseEnSecuriteView();
		window.vueMiseEnSecurite.setVisible(true);
	}

	/**
	 * Cette fonction va permettre d'ajouter une entrée de billets/pièces dans le contenu de la miseEnSecurite
	 * 
	 * @param idBouton L'id du bouton qui a été pressé, équivaut à l'id de l'Argent
	 * @param nbre Le nombre de billets/pièves a ajouter
	 */
	public void ajoutSortie(String idBouton, int nbre) {
		int idBtn = Integer.parseInt(idBouton.substring(6, idBouton.length()));
		for(Argent c : contenuMiseEnSecurite) {
			if(c.getIdArgent() == idBtn) {
				c.setSorti(c.getSorti()+nbre);
			}
		}
	}
	
	/**
	 * Cette fonction va permettre de finaliser la mise en sécurité en enregistrant les données dans la base de données au moyen de DBHelper
	 * Puis la fonction va raffraichir la vue
	 */
	public void finaliserMiseEnSecurite() {
		DBHelper.enregistrerMiseEnSecurite(this.idMiseEnSecurite, this.heureMiseEnSecurite, this.responsables, this.contenuMiseEnSecurite);
		DBHelper.setTotal(DBHelper.getTotal()-sommeMiseEnSecurite());
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}

	
	/**
	 * Cette fonction va permettre d'annuler la mise en sécurité en cours en raffraichissant la vue
	 */
	public void annulerMiseEnSecurite() {
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}
	
	
	/**
	 * Cette fonction va calculer la somme de la miseEnSecurite sur base du contenu de celle-ci
	 * 
	 * @return La somme de la miseEnSecurite
	 */
	public double sommeMiseEnSecurite() {
		double somme=0;
		for(Argent i : contenuMiseEnSecurite) {
			somme += (i.getValeurArgent()*i.getSorti());
		}
		return somme;
	}
	
	
	/**
	 * Cette fonction va permettre de transformer une miseEnSecurite en un tableau d'objets pouvant être affiché dans le résumé de la miseEnSecurite
	 * 
	 * @return Un double tableau représentant le résumé de la miseEnSecurite
	 */
	public Object[][] affichage() {
		int totalLigne = getRow(this.contenuMiseEnSecurite)+5;
		Object[][] retour = new Object[totalLigne][4];
		retour[0][0] = "Commande N° ";
		retour[0][1] = this.idMiseEnSecurite;
		retour[0][2] = "Heure : ";
		retour[0][3] = this.heureMiseEnSecurite;
		retour[1][0] = "";
		retour[1][1] = "";
		retour[1][2] = "";
		retour[1][3] = "";
		retour[2][0] = "Quantite";
		retour[2][1] = "Produit";
		retour[2][2] = "Prix unitaire";
		retour[2][3] = "Total";
		int i=3;
		for(Argent a : this.contenuMiseEnSecurite) {
			if(a.getSorti()>0) {
				retour[i][0]=a.getSorti();
				retour[i][1]=a.getValeurArgent() + "€";
				retour[i][2]="";
				retour[i][3]=a.getValeurArgent()*a.getSorti();
				i++;
			}
			
		}
		retour[totalLigne-2][0] = "---------------------------------------------";
		retour[totalLigne-2][1] = "---------------------------------------------";
		retour[totalLigne-2][2] = "---------------------------------------------";
		retour[totalLigne-2][3] = "---------------------------------------------";
		retour[totalLigne-1][0] = "";
		retour[totalLigne-1][1] = "Total : ";
		retour[totalLigne-1][2] = "";
		retour[totalLigne-1][3] = this.sommeMiseEnSecurite();
		
		return retour;
	}
	
	
	/**
	 * Cette fonction va calculer le nombre de lignes que doit contenir le résumé de la miseEnSecurite sur base du nombres d'objet Argent ayant des échanges non nul
	 * 
	 * @param contenuRow Le contenu de la miseEnSecurite
	 * @return Le nombre d'objet Argent dont la valeur échange est non nulle
	 */
	//TODO JUnitTests
	private int getRow(List<Argent> contenuRow) {
		int nbreLigne = 0;
		for(Argent a : contenuRow) {
			if(a.getSorti()>0) {
				nbreLigne++;
			}
		}
		return nbreLigne;
	}
	
//Getters&Setters
	/**
	 * @return the nbre
	 */
	public int getNbre() {
		return nbre;
	}

	/**
	 * @param nbre the nbre to set
	 */
	public void setNbre(int nbre) {
		this.nbre = nbre;
	}
	
}
