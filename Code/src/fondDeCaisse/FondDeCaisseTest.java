/**Cette classe permet de faire des tests unitaires sur la fonction de somme du fonds de caisse
 * @author gaeta_2b6psqs
 * @version 2021-05-27
 */
package fondDeCaisse;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import argent.Argent;

class FondDeCaisseTest {
	private static List<Argent> contenu1 = new ArrayList<Argent>();
	private static FondDeCaisse atester1 = null;
	private static List<Argent> contenu2 = new ArrayList<Argent>();
	private static FondDeCaisse atester2 = null;
	private static List<Argent> contenu3 = new ArrayList<Argent>();
	private static FondDeCaisse atester3 = null;
	

	@Test
	void test() {
		//1er cas, tout est nul => total = 0
			//Initialisation liste Argent
				contenu1.add(new Argent(1, 0.01, 0));
				contenu1.add(new Argent(2, 0.02, 0));
				contenu1.add(new Argent(5, 0.05, 0));
				contenu1.add(new Argent(10, 0.1, 0));
				contenu1.add(new Argent(20, 0.2, 0));
				contenu1.add(new Argent(50, 0.5, 0));
				contenu1.add(new Argent(100, 1, 0));
				contenu1.add(new Argent(200, 2, 0));
				contenu1.add(new Argent(500, 5, 0));
				contenu1.add(new Argent(1000, 10, 0));
				contenu1.add(new Argent(2000, 20, 0));
				contenu1.add(new Argent(5000, 50, 0));
				contenu1.add(new Argent(10000, 100, 0));
				contenu1.add(new Argent(20000, 200, 0));
			//Création du fonds de caisse
				atester1 = new FondDeCaisse(1, "2021-05-27", "Tests", contenu1);
			//Test
				assertEquals(0 ,atester1.sommeFondDeCaisse());
			
		//2eme cas, des valeurs quelconques
				//Initialisation liste Argent
				contenu2.add(new Argent(1, 0.01, 1));
				contenu2.add(new Argent(2, 0.02, 2));
				contenu2.add(new Argent(5, 0.05, 3));
				contenu2.add(new Argent(10, 0.1, 4));
				contenu2.add(new Argent(20, 0.2, 5));
				contenu2.add(new Argent(50, 0.5, 6));
				contenu2.add(new Argent(100, 1, 7));
				contenu2.add(new Argent(200, 2, 8));
				contenu2.add(new Argent(500, 5, 9));
				contenu2.add(new Argent(1000, 10, 10));
				contenu2.add(new Argent(2000, 20, 11));
				contenu2.add(new Argent(5000, 50, 12));
				contenu2.add(new Argent(10000, 100, 13));
				contenu2.add(new Argent(20000, 200, 14));
			//Création du fonds de caisse
				atester2 = new FondDeCaisse(1, "2021-05-27", "Tests", contenu2);
			//Test
				assertEquals(5092.6 ,atester2.sommeFondDeCaisse());
			
		//3eme cas, des valeurs quelconques et valeurs égales à 0
				//Initialisation liste Argent
					contenu3.add(new Argent(1, 0.01, 0));
					contenu3.add(new Argent(2, 0.02, 2));
					contenu3.add(new Argent(5, 0.05, 3));
					contenu3.add(new Argent(10, 0.1, 4));
					contenu3.add(new Argent(20, 0.2, 0));
					contenu3.add(new Argent(50, 0.5, 6));
					contenu3.add(new Argent(100, 1, 7));
					contenu3.add(new Argent(200, 2, 8));
					contenu3.add(new Argent(500, 5, 9));
					contenu3.add(new Argent(1000, 10, 0));
					contenu3.add(new Argent(2000, 20, 11));
					contenu3.add(new Argent(5000, 50, 12));
					contenu3.add(new Argent(10000, 100, 13));
					contenu3.add(new Argent(20000, 200, 14));
				//Création du fonds de caisse
					atester3 = new FondDeCaisse(1, "2021-05-27", "Tests", contenu3);
				//Test
					assertEquals(4991.59 ,atester3.sommeFondDeCaisse());
	}

}
