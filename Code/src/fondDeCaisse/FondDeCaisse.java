/**
 * 
 */
package fondDeCaisse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import acceuil.DBHelper;
import argent.Argent;

/**
 * @author gaeta_2b6psqs
 *
 */
public class FondDeCaisse {
	private int idFondDeCaisse;
	private String heureFondDeCaisse;
	private String responsables;
	private List<Argent> contenuFondDeCaisse;
	private int nbre;
	
	public FondDeCaisse() {
		this.idFondDeCaisse = DBHelper.getnextMiseEnSecurite()+1;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.heureFondDeCaisse = dtf.format(now);
		this.responsables = "FondDeCaisse";
		this.contenuFondDeCaisse = DBHelper.getArgent();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialise();
	}

	public static void initialise() {
		FondDeCaisseView window = new FondDeCaisseView();
		window.vueFondDeCaisse.setVisible(true);
	}
	
	public void ajoutEntree(String idBouton, int nbre) {
		int idBtn = Integer.parseInt(idBouton.substring(6,  idBouton.length()));
		for(Argent f : contenuFondDeCaisse) {
			if(f.getIdArgent() == idBtn) {
				f.setSorti(f.getSorti() + nbre);
			}
		}
	}
	
	public void finaliserFondDeCaisse() {
		DBHelper.enregistrerFondDeCaisse(this.idFondDeCaisse, this.heureFondDeCaisse, this.responsables, this.contenuFondDeCaisse);
		DBHelper.setTotal(DBHelper.getTotal()+sommeFondDeCaisse());
		java.awt.Window win[] = java.awt.Window.getWindows();
		for(int i=0;i<win.length;i++){
			win[i].dispose();
		}
		initialise();
	}
	
	private double sommeFondDeCaisse() {
		double somme=0;
		for(Argent i : contenuFondDeCaisse) {
			somme += (i.getValeurArgent()*i.getSorti());
		}
		return somme;
	}

	public void annulerFondDeCaisse() {
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
