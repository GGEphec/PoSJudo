package vente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import acceuil.DBHelper;
import parametrage.Parametrage;

/**
 * @author gaeta_2b6psqs
 *
 */
public class Vente {
//Variable d'instance
	private int idCommande;
	private String heureCommande;
	private List<Parametrage> contenu;
	private int nbre;

	
	public Vente() {
		this.idCommande = DBHelper.nextCommande()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureCommande = dtf.format(now);
		this.contenu = DBHelper.getProduits();
	}

	/**
	 * @param args /
	 */
	public static void main(String[] args) {
		initialise();
	}
	
	public static void initialise() {
		VenteView window = new VenteView();
		window.vueVente.setVisible(true);
	}
	
	public void ajoutUnAchat(String nomBouton, int nbre) {
		for(Parametrage p : contenu) {
			//System.out.println(p.getNom().equals(nomBouton));
			if(p.getNom().equals(nomBouton)){
				p.setVendu(p.getVendu() + nbre);
			}	
		}
		//System.out.println(contenu);
	}
	
	public Object[][] affichage() {
		int totalLigne = getRow(this.contenu)+5;
		Object[][] retour = new Object[totalLigne][4];
		retour[0][0] = "Commande N° ";
		retour[0][1] = this.idCommande;
		retour[0][2] = "Heure : ";
		retour[0][3] = this.heureCommande;
		retour[1][0] = "";
		retour[1][1] = "";
		retour[1][2] = "";
		retour[1][3] = "";
		retour[2][0] = "Quantite";
		retour[2][1] = "Produit";
		retour[2][2] = "Prix unitaire";
		retour[2][3] = "Total";
		int i=3;
		for(Parametrage a : this.contenu) {
			if(a.getVendu()>0) {
				retour[i][0]=a.getVendu();
				retour[i][1]=a.getDescription();
				retour[i][2]=a.getPrix();
				retour[i][3]=a.getPrix()*a.getVendu();
				i++;
			}
			
		}
		retour[totalLigne-2][0] = "---------------------------------------------";
		retour[totalLigne-2][1] = "---------------------------------------------";
		retour[totalLigne-2][2] = "---------------------------------------------";
		retour[totalLigne-2][3] = "---------------------------------------------";
		retour[totalLigne-1][0] = this.getTotalTicket();
		retour[totalLigne-1][1] = "Total : ";
		retour[totalLigne-1][2] = "";
		retour[totalLigne-1][3] = this.sommeCommande();
		
		return retour;
	}

	private int getTotalTicket() {
		int totalTicket=0;
		for(Parametrage p : contenu) {
			totalTicket+= p.getVendu();
		}
		return totalTicket;
	}

	private int getRow(List<Parametrage> contenuRow) {
		int nbreLigne = 0;
		for(Parametrage a : contenuRow) {
			if(a.getVendu()>0) {
				nbreLigne++;
			}
		}
		return nbreLigne;
	}

	public void finaliserCommande() {
		DBHelper.enregistrerCommande(this.idCommande, this.heureCommande, this.contenu);
		DBHelper.setTotal(DBHelper.getTotal()+sommeCommande());
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}

	private double sommeCommande() {
		double somme=0;
		for(Parametrage p : contenu) {
			somme+= p.getPrix()*p.getVendu();
		}
		return somme;
	}

	public void annulerCommande() {
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
		
	}

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
