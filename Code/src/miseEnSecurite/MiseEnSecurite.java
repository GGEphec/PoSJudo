/**
 * 
 */
package miseEnSecurite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import acceuil.DBHelper;
import argent.Argent;

/**
 * @author gaeta_2b6psqs
 *
 */
public class MiseEnSecurite {
	private int idMiseEnSecurite;
	private String heureMiseEnSecurite;
	private String responsables;
	private List<Argent> contenuMiseEnSecurite;
	private int nbre;
	
	
	public MiseEnSecurite() {
		this.idMiseEnSecurite = DBHelper.getnextMiseEnSecurite()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureMiseEnSecurite = dtf.format(now);
		this.responsables = "JCG";
		this.contenuMiseEnSecurite = DBHelper.getArgent();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialise();

	}
	
	public static void initialise() {
		MiseEnSecuriteView window = new MiseEnSecuriteView();
		window.vueMiseEnSecurite.setVisible(true);
	}

	public void ajoutSortie(String idBouton, int nbre) {
		int idBtn = Integer.parseInt(idBouton.substring(6, idBouton.length()));
		for(Argent c : contenuMiseEnSecurite) {
			if(c.getIdArgent() == idBtn) {
				c.setSorti(c.getSorti()+nbre);
			}
		}
	}
	
	
	public void finaliserMiseEnSecurite() {
		DBHelper.enregistrerMiseEnSecurite(this.idMiseEnSecurite, this.heureMiseEnSecurite, this.responsables, this.contenuMiseEnSecurite);
		DBHelper.setTotal(DBHelper.getTotal()-sommeMiseEnSecurite());
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}

	public void annulerMiseEnSecurite() {
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
	
	public double sommeMiseEnSecurite() {
		double somme=0;
		for(Argent i : contenuMiseEnSecurite) {
			somme += (i.getValeurArgent()*i.getSorti());
		}
		return somme;
	}
	
}
