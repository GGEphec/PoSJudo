/**Cette classe va permettre de créer le modèle du fond de caisse qui sera utilisé pour déterminer quel est la somme et le détail de l'argent au début de la journée
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package fondDeCaisse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import acceuil.DBHelper;
import argent.Argent;


public class FondDeCaisse {
//Variable d'instance
	private int idFondDeCaisse; //L'id du fond de caisse
	private String heureFondDeCaisse; //L'heure du fond de caisse
	private String responsables; //Les responsables du fond de caisse
	private List<Argent> contenuFondDeCaisse; //Le contenu du fond de caisse
	
	private int nbre; //Variable temporaire pour déterminer le nombre encodé sur le pavé numérique
	
//Constructeur
	/**
	 * Le constructeur d'un objet fondDeCaisse
	 * L'objet fondDeCaisse est par défaut initialisé par des valeurs pré-calculées ou nulles
	 */
	public FondDeCaisse() {
		this.idFondDeCaisse = DBHelper.getnextMiseEnSecurite()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureFondDeCaisse = dtf.format(now);
		this.responsables = "FondDeCaisse";
		this.contenuFondDeCaisse = DBHelper.getArgent();
	}

//Méthodes
	/**
	 * Permet d'initialiser la vue fondDeCaisse
	 */
	public static void initialise() {
		FondDeCaisseView window = new FondDeCaisseView();
		window.vueFondDeCaisse.setVisible(true);
	}
	
	
	/**
	 * Cette fonction va permettre d'ajouter une entrée de billets/pièces dans le contenu du fondDeCaisse
	 * 
	 * @param idBouton L'id du bouton qui a été pressé, équivaut à l'id de l'Argent
	 * @param nbre Le nombre de billets/pièves a ajouter
	 */
	public void ajoutEntree(String idBouton, int nbre) {
		int idBtn = Integer.parseInt(idBouton.substring(6,  idBouton.length()));
		for(Argent f : contenuFondDeCaisse) {
			if(f.getIdArgent() == idBtn) {
				f.setSorti(f.getSorti() + nbre);
			}
		}
	}
	
	
	/**
	 * Cette fonction va permettre de finaliser le fond de caisse en enregistrant les données dans la base de données au moyen de DBHelper
	 * Puis la fonction va raffraichir la vue
	 */
	public void finaliserFondDeCaisse() {
		DBHelper.enregistrerFondDeCaisse(this.idFondDeCaisse, this.heureFondDeCaisse, this.responsables, this.contenuFondDeCaisse);
		DBHelper.setTotal(DBHelper.getTotal()+sommeFondDeCaisse());
		java.awt.Window win[] = java.awt.Window.getWindows(); //Nettoyage des fenêtre encore ouvertes
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}
	
	
	/**
	 * Cette fonction va permettre d'annuler le fond de caisse en cours en raffraichissant la vue
	 */
	public void annulerFondDeCaisse() {
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}
	
	
	/**
	 * Cette fonction va calculer la somme du fondDeCaisse sur base du contenu de celui-ci
	 * 
	 * @return La somme du fondDeCaisse
	 */
	//TODO JUnitTests
	private double sommeFondDeCaisse() {
		double somme=0;
		for(Argent i : contenuFondDeCaisse) {
			somme += (i.getValeurArgent()*i.getSorti());
		}
		return somme;
	}
	

	/**
	 * Cette fonction va permettre de transformer un fondDeCaisse en un tableau d'objets pouvant être affiché dans le résumé du fondDeCaisse
	 * 
	 * @return Un double tableau représentant le résumé du fondDeCaisse
	 */
	public Object[][] affichage() {
		int totalLigne = getRow(this.contenuFondDeCaisse)+5;
		Object[][] retour = new Object[totalLigne][4];
		retour[0][0] = "Commande N° ";
		retour[0][1] = this.idFondDeCaisse;
		retour[0][2] = "Heure : ";
		retour[0][3] = this.heureFondDeCaisse;
		retour[1][0] = "";
		retour[1][1] = "";
		retour[1][2] = "";
		retour[1][3] = "";
		retour[2][0] = "Quantite";
		retour[2][1] = "Produit";
		retour[2][2] = "Prix unitaire";
		retour[2][3] = "Total";
		int i=3;
		for(Argent a : this.contenuFondDeCaisse) {
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
		retour[totalLigne-1][3] = this.sommeFondDeCaisse();
		
		return retour;
	}
	
	/**
	 * Cette fonction va calculer le nombre de lignes que doit contenir le résumé du fondDeCaisse sur base du nombres d'objet Argent ayant des échanges non nul
	 * 
	 * @param contenuRow Le contenu du fond de caisse
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
