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
	private boolean moins=false;
	
//Constructeur
	/**
	 * Le constructeur d'un objet fondDeCaisse
	 * L'objet fondDeCaisse est par défaut initialisé par des valeurs pré-calculées ou nulles
	 */
	public FondDeCaisse() {
		this.idFondDeCaisse = DBHelper.getnextMiseEnSecurite()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureFondDeCaisse = dtf.format(now);
		this.responsables = "FondDeCaisse";
		this.contenuFondDeCaisse = DBHelper.getArgent();
	}

	/**
	 * Le constructeur d'un objet fondDeCaisse
	 * @param id L'id du fonds de caisse
	 * @param date La date et l'heure du fonds de caisse
	 * @param responsables Les responsables du fonds de caisse
	 * @param contenuFdC Le contenu du fonds de caisse
	 */
	public FondDeCaisse(int id, String date, String responsables, List<Argent> contenuFdC) {
			this.idFondDeCaisse = id;
			this.heureFondDeCaisse = date;
			this.responsables = responsables;
			this.contenuFondDeCaisse = contenuFdC;
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
	 * Cette fonction va permettre de retirer une entrée de billets/pièces dans le contenu du fondDeCaisse
	 * 
	 * @param idBouton L'id du bouton qui a été pressé, équivaut à l'id de l'Argent
	 */
	public void retireEntree(String idBouton) {
		int idBtn = Integer.parseInt(idBouton.substring(6,  idBouton.length()));
		for(Argent f : contenuFondDeCaisse) {
			if(f.getIdArgent() == idBtn) {
				f.setSorti(f.getSorti()-1);
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
	double sommeFondDeCaisse() {
		double somme=0;
		for(Argent i : contenuFondDeCaisse) {
			somme += (i.getValeurArgent()*i.getSorti());
		}
		return (double)Math.round(somme*100)/100;
	}
	

	/**
	 * Cette fonction va permettre de transformer un fondDeCaisse en un tableau d'objets pouvant être affiché dans le résumé du fondDeCaisse
	 * 
	 * @return Un double tableau représentant le résumé du fondDeCaisse
	 */
	public Object[][] affichage() {
		int totalLigne = contenuFondDeCaisse.size()+5;
		Object[][] retour = new Object[totalLigne][3];
		retour[0][0] = "Fonds de caisse N°"+this.idFondDeCaisse;
		retour[0][1] = "Heure : " + this.heureFondDeCaisse.substring(11, 19);
		retour[0][2] = this.heureFondDeCaisse.substring(0, 10);
		retour[1][0] = "";
		retour[1][1] = "";
		retour[1][2] = "";
		retour[2][0] = "Quantite";
		retour[2][1] = "Argent";
		retour[2][2] = "Total";
		int i=3;
		for(Argent a : this.contenuFondDeCaisse) {
			retour[i][0]=" " + a.getSorti();
			retour[i][1]=" " + a.getValeurArgent() + "€";
			retour[i][2]=" "+(double)Math.round((a.getValeurArgent()*a.getSorti())*100)/100;
			i++;
			
		}
		retour[totalLigne-2][0] = "-------------------";
		retour[totalLigne-2][1] = "-------------------";
		retour[totalLigne-2][2] = "-------------------";
		retour[totalLigne-1][0] = "";
		retour[totalLigne-1][1] = "Total : ";
		retour[totalLigne-1][2] = this.sommeFondDeCaisse() + " €";
		
		return retour;
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

	/**
	 * @return the idFondDeCaisse
	 */
	public int getIdFondDeCaisse() {
		return idFondDeCaisse;
	}

	/**
	 * @param idFondDeCaisse the idFondDeCaisse to set
	 */
	public void setIdFondDeCaisse(int idFondDeCaisse) {
		this.idFondDeCaisse = idFondDeCaisse;
	}

	/**
	 * @return the heureFondDeCaisse
	 */
	public String getHeureFondDeCaisse() {
		return heureFondDeCaisse;
	}

	/**
	 * @param heureFondDeCaisse the heureFondDeCaisse to set
	 */
	public void setHeureFondDeCaisse(String heureFondDeCaisse) {
		this.heureFondDeCaisse = heureFondDeCaisse;
	}

	/**
	 * @return the responsables
	 */
	public String getResponsables() {
		return responsables;
	}

	/**
	 * @param responsables the responsables to set
	 */
	public void setResponsables(String responsables) {
		this.responsables = responsables;
	}

	/**
	 * @return the contenuFondDeCaisse
	 */
	public List<Argent> getContenuFondDeCaisse() {
		return contenuFondDeCaisse;
	}

	/**
	 * @param contenuFondDeCaisse the contenuFondDeCaisse to set
	 */
	public void setContenuFondDeCaisse(List<Argent> contenuFondDeCaisse) {
		this.contenuFondDeCaisse = contenuFondDeCaisse;
	}

	/**
	 * @return the moins
	 */
	public boolean isMoins() {
		return moins;
	}

	/**
	 * @param moins the moins to set
	 */
	public void setMoins(boolean moins) {
		this.moins = moins;
	}
	
	

}
