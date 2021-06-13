/**Cette classe va permettre de créer le modèle d'une vente qui sera utilisé pour déterminer quel est l'id de la vente, son heure et son contenu
 * Le mot commande est parfois utilisé à la place du mot vente mais il détermine toujours ce qu'un client vient commander/achter comme tickets
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package vente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import acceuil.DBHelper;
import parametrage.Parametrage;


public class Vente {
//Variable d'instance
	private int idCommande; //L'id de la vente
	private String heureCommande; //L'heure de la vente
	private List<Parametrage> contenu; //Le contenu de la vente
	
	private int nbre; //Variable temporaire pour déterminer le nombre encodé sur le pavé numérique
	private boolean moins=false;
	
//Constructeur
	/**
	 * Le constructeur d'un objet Vente
	 * L'objet vente est par défaut initalisé par des valeurs pré-calculées ou nulles
	 */
	public Vente() {
		this.idCommande = DBHelper.nextCommande()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureCommande = dtf.format(now);
		this.contenu = DBHelper.getProduits();
	}

	/**
	 * Le constructeur d'un objet Vente
	 * 
	 * @param id L'id de la vente
	 * @param heure L'heure de la vente
	 * @param contenuCommande Le contenu de la commande
	 */
	public Vente(int id, String heure, List<Parametrage> contenuCommande) {
			this.idCommande = id;
			this.heureCommande = heure;
			this.contenu = contenuCommande;
		}

	//Méthodes
	/**
	 * Permet d'initaliser la vue vente
	 */
	public static void initialise() {
		VenteView window = new VenteView();
		window.vueVente.setVisible(true);
	}
	
	
	/**
	 * Cette fonction va pemettre d'ajouter une demande de ticket dans le contenu de la commande
	 * 
	 * @param nomBouton Le nom du boutton qui a été pressé
	 * @param nbre Le nombre de fois qu'il faut ajouter le ticket
	 */
	public void ajoutUnAchat(String nomBouton, int nbre) {
		for(Parametrage p : contenu) {
			if(p.getNom().equals(nomBouton)){
				p.setVendu(p.getVendu() + nbre);
			}	
		}
	}
	
	/**
	 * Cette fonction va pemettre de retirer une demande de ticket dans le contenu de la commande si le contenu existe déjà
	 * 
	 * @param nomBouton Le nom du boutton qui a été pressé
	 */
	public void retireUnAchat(String nomBouton) {
		for(Parametrage p : contenu) {
			if(p.getNom().equals(nomBouton)){
				p.setVendu(p.getVendu()-1);
			}
		}
	}
	
	
	
	/**
	 * Cette fonction va permettre de finaliser la vente en enregistrant les données dans la base de données au moyen de DBHelper
	 * Puis la fonction va raffraichir la vue
	 */
	public void finaliserCommande() {
		DBHelper.enregistrerCommande(this.idCommande, this.heureCommande, this.contenu);
		DBHelper.setTotal(DBHelper.getTotal()+sommeCommande());
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}

	/**
	 * Cette fonction va permettre d'annuler la vente en cours en raffraichissant la vue
	 */
	public void annulerCommande() {
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}
	
	
	/**
	 * Cette fonction va calculer la somme de la vente sur base du contenu de celle-ci
	 * 
	 * @return La somme de la vente
	 */
	double sommeCommande() {
		double somme=0;
		for(Parametrage p : contenu) {
			somme+= p.getPrix()*p.getVendu();
		}
		return (double)Math.round(somme*100)/100;
	}
	
	
	/**
	 * Cette fonction va permettre de transformer une vente en un tableau d'objets pouvant être affiché dans le résumé de la vente
	 * 
	 * @return Un double tableau représentant le résumé de la vente
	 */
	public Object[][] affichage() {
		int totalLigne = getRow(this.contenu)+5;
		Object[][] retour = new Object[totalLigne][4];
		retour[0][0] = "Commande N°"+this.idCommande;
		retour[0][1] = "";
		retour[0][2] = "Date : "+this.heureCommande.substring(0,10);
		retour[0][3] = "Heure : "+this.heureCommande.substring(11, 19);
		retour[1][0] = "";
		retour[1][1] = "";
		retour[1][2] = "";
		retour[1][3] = "";
		retour[2][0] = "Quantité";
		retour[2][1] = "Produit";
		retour[2][2] = "Prix unitaire";
		retour[2][3] = "Total";
		int i=3;
		for(Parametrage a : this.contenu) {
			if(a.getVendu()>0) {
				retour[i][0]=" "+a.getVendu();
				retour[i][1]=" "+a.getDescription();
				retour[i][2]=" "+a.getPrix();
				retour[i][3]=(double)Math.round((a.getPrix()*a.getVendu())*100)/100;
				i++;
			}
			
		}
		retour[totalLigne-2][0] = "-------------------";
		retour[totalLigne-2][1] = "-------------------";
		retour[totalLigne-2][2] = "-------------------";
		retour[totalLigne-2][3] = "-------------------";
		retour[totalLigne-1][0] = this.getTotalTicket() + " ticket(s)";
		retour[totalLigne-1][1] = "Total : ";
		retour[totalLigne-1][2] = "";
		retour[totalLigne-1][3] = this.sommeCommande()+" €";
		
		return retour;
	}

	
	/**
	 * Cette fonction va calculer la somme des tickets de la vente sur base du contenu de celle-ci
	 * 
	 * @return La somme des tickets de la vente
	 */
	int getTotalTicket() {
		int totalTicket=0;
		for(Parametrage p : contenu) {
			totalTicket+= p.getVendu();
		}
		return totalTicket;
	}

	
	/**
	 * Cette fonction va calculer le nombre de lignes que doit contenir le résumé de la vente sur base du nombres d'objet Parametrage ayant des ventes non nulles
	 * 
	 * @param contenuRow Le contenu de la vente
	 * @return Le nombre d'objet Parametrage dont la valeur vendu est non nulle
	 */
	int getRow(List<Parametrage> contenuRow) {
		int nbreLigne = 0;
		for(Parametrage a : contenuRow) {
			if(a.getVendu()>0) {
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

	/**
	 * @return the idCommande
	 */
	public int getIdCommande() {
		return idCommande;
	}

	/**
	 * @param idCommande the idCommande to set
	 */
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * @return the heureCommande
	 */
	public String getHeureCommande() {
		return heureCommande;
	}

	/**
	 * @param heureCommande the heureCommande to set
	 */
	public void setHeureCommande(String heureCommande) {
		this.heureCommande = heureCommande;
	}

	/**
	 * @return the contenu
	 */
	public List<Parametrage> getContenu() {
		return contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(List<Parametrage> contenu) {
		this.contenu = contenu;
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
