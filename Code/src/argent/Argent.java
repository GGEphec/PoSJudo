/**
 * 
 */
package argent;

/**
 * @author gaeta_2b6psqs
 *
 */
public class Argent {
	private int idArgent;
	private double valeurArgent;
	private int sorti;
	
	public Argent(int id, double valeur) {
		this.idArgent = id;
		this.valeurArgent = valeur;
		this.sorti = 0;
	}

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return this.getIdArgent() + " : " + this.getSorti();
	}

}
