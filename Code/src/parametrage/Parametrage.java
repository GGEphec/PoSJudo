/**Cette classe va permettre de créer le modèle d'un produit qui sera utilisé pour déterminer quels produits ont été vendus
 * L'objet représente un produit et les caractéristiques de la touche le comprenant
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package parametrage;

import vente.VenteView;

public class Parametrage {
//Variable d'instance
	int numeroBoutton; //Le numéro du boutton pour le repérer dans le cadre
	String nom; //Concaténation de "btn"+numero
	boolean visible; //Si le boutton du produit est visible ou non
	double prix; //Le prix unitaire du produit
	int couleurR; //La valeur Red de la couleur du boutton
	int couleurG; //La valeur Green de la couleur du boutton
	int couleurB; //La valeur Blue de la couleur du boutton
	String description; //La description du produit
	int vendu; //Le nombre de fois que le produit a été vendu pour cette transaction
	
	
//Constructeur
	/**
	 * Le constructeur d'un objet Parametrage
	 * 
	 * @param n le numéro du boutton
	 * @param v la visibilité du boutton
	 * @param p le prix unitaire
	 * @param R la valeur Red de la couleur du boutton
	 * @param G la valeur Green de la couleur du boutton
	 * @param B la valeur Blue de la couleur du boutton
	 * @param d la description du boutton
	 */
	public Parametrage(int n, boolean v, double p, int R, int G, int B, String d) {
		this.numeroBoutton = n;
		this.nom = "btn"+n;
		this.visible = v;
		this.prix = p;
		this.couleurR = R;
		this.couleurG = G;
		this.couleurB = B;
		this.description = d;
		this.vendu=0;
	}
	
	/**
	 * Permet d'initaliser la vue parametrage
	 */
	public static void initialise() {
		ParametrageView window = new ParametrageView();
		window.vueParametrage.setVisible(true);
	}


	//Getters and Setters	
	/**
	 * @return the numeroBoutton
	 */
	public int getNumeroBoutton() {
		return numeroBoutton;
	}

	/**
	 * @param numeroBoutton the numeroBoutton to set
	 */
	public void setNumeroBoutton(int numeroBoutton) {
		this.numeroBoutton = numeroBoutton;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the couleurR
	 */
	public int getCouleurR() {
		return couleurR;
	}

	/**
	 * @param couleurR the couleurR to set
	 */
	public void setCouleurR(int couleurR) {
		this.couleurR = couleurR;
	}

	/**
	 * @return the couleurG
	 */
	public int getCouleurG() {
		return couleurG;
	}

	/**
	 * @param couleurG the couleurG to set
	 */
	public void setCouleurG(int couleurG) {
		this.couleurG = couleurG;
	}

	/**
	 * @return the couleurB
	 */
	public int getCouleurB() {
		return couleurB;
	}

	/**
	 * @param couleurB the couleurB to set
	 */
	public void setCouleurB(int couleurB) {
		this.couleurB = couleurB;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the vendu
	 */
	public int getVendu() {
		return vendu;
	}

	/**
	 * @param vendu the vendu to set
	 */
	public void setVendu(int vendu) {
		this.vendu = vendu;
	}



//toString	
	/**
	 * Cette fonction va retourner un objet Parametrage sous une forme lisible
	 * 
	 * @return La description et le nombre de fois que le produit a été vendu
	 */
	public String toString() {
		return this.getDescription() + " " + this.getVendu();
		//TODO compléter avec les autres éléments
	}
	
	

}
