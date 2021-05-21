/**Cette classe va permettre de représenter un objet de type Argent. L'objet de type Argent dispose d'un id, d'une valeur et d'un nombre de fois qu'il est échangé.
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package argent;

public class Argent {
//Variable d'instance
	private int idArgent;  //L'id de l'argent, il correspond à la valeur en centimes
	private double valeurArgent; //La valeur de l'argent, il correspond à la valeur en euros
	private int sorti; //Le nombre de fois que l'argent a été échangé
	
//Constructeur
	/**
	 * Constructeur de l'objet Argent
	 * 
	 * @param id L'id de l'argent à construire
	 * @param valeur La valeur de l'argent à construire
	 */
	public Argent(int id, double valeur) {
		this.idArgent = id;
		this.valeurArgent = valeur;
		this.sorti = 0;
	}

	
//Getters&Setters
	/**
	 * @return the idArgent
	 */
	public int getIdArgent() {
		return idArgent;
	}

	/**
	 * @param idArgent the idArgent to set
	 */
	public void setIdArgent(int idArgent) {
		this.idArgent = idArgent;
	}

	/**
	 * @return the valeurArgent
	 */
	public double getValeurArgent() {
		return valeurArgent;
	}

	/**
	 * @param valeurArgent the valeurArgent to set
	 */
	public void setValeurArgent(double valeurArgent) {
		this.valeurArgent = valeurArgent;
	}
	
	/**
	 * @return the sorti
	 */
	public int getSorti() {
		return sorti;
	}

	/**
	 * @param sorti the sorti to set
	 */
	public void setSorti(int sorti) {
		this.sorti = sorti;
	}

//toString
	/**
	 * Cette fonction va retourner un objet Argent sous une forme lisible
	 * 
	 * @return L'id de l'argent : le nombre de fois qu'il a été échangé
	 */
	@Override
	public String toString() {
		return this.getIdArgent() + " : " + this.getSorti();
	}

}
