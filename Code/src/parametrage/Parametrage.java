/**
 * 
 */
package parametrage;

/**
 * @author gaeta_2b6psqs
 *
 */
public class Parametrage {
	//Variable d'instances
	int numeroBoutton;
	String nom; //Concat btn+numero
	boolean visible;
	double prix;
	int couleurR;
	int couleurG;
	int couleurB;
	String description;
	int vendu;
	
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
	 * @return the object to a String
	 */
	public String toString() {
		return this.getDescription() + " " + this.getVendu();
		//todo compelter avec autres éléments
	}
	
	

}
