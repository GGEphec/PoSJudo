/**Cette classe est la première classe qui est appellée quand on lance l'application
 * Elle va lancer la première vue et initialiser l'argent en caisse à 0
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package acceuil;


public class Acceuil {

	/**
	 * Lance la première vue
	 * Initialise l'argent en caisse à 0
	 * 
	 * @param args /
	 */
	public static void main(String[] args) {
		DBHelper.setTotal(0);
		AcceuilView window = new AcceuilView();
		window.vueAcceuil.setVisible(true);
	}
}
