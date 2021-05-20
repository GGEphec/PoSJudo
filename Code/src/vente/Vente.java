package vente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
