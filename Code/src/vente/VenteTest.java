/**Cette classe permet de faire des tests unitaires sur la fonction de somme de la vente
 * @author gaeta_2b6psqs
 *
 * @version 27 mai 2021
 */
package vente;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import parametrage.Parametrage;



class VenteTest {
	private static List<Parametrage> contenu1 = new ArrayList<Parametrage>();
	private static Vente atester1 = null;
	private static List<Parametrage> contenu2 = new ArrayList<Parametrage>();
	private static Vente atester2 = null;
	private static List<Parametrage> contenu3 = new ArrayList<Parametrage>();
	private static Vente atester3 = null;
	

	@Test
	void test() {
		//1er cas, tout est nul => total = 0
			//Initialisation liste Argent
				contenu1.add(new Parametrage(11, true, 2.0, 0, 0, 0, "TicketTest1", 0));
				contenu1.add(new Parametrage(12, true, 3.5, 0, 0, 0, "TicketTest2", 0));
				contenu1.add(new Parametrage(13, true, 2.5, 0, 0, 0, "TicketTest3", 0));
			//Création du fonds de caisse
				atester1 = new Vente(1, "2021-05-27", contenu1);
			//Test
				assertEquals(0 ,atester1.sommeCommande());
				assertEquals(0, atester1.getTotalTicket());
				assertEquals(0, atester1.getRow(contenu1));
			
		//2eme cas, des valeurs quelconques
				//Initialisation liste Argent
				contenu2.add(new Parametrage(11, true, 2.0, 0, 0, 0, "TicketTest1", 1));
				contenu2.add(new Parametrage(12, true, 3.5, 0, 0, 0, "TicketTest2", 2));
				contenu2.add(new Parametrage(13, true, 2.5, 0, 0, 0, "TicketTest3", 3));
			//Création du fonds de caisse
				atester2 = new Vente(1, "2021-05-27", contenu2);
			//Test
				assertEquals(16.5 ,atester2.sommeCommande());
				assertEquals(6, atester2.getTotalTicket());
				assertEquals(3, atester2.getRow(contenu2));
			
		//3eme cas, des valeurs quelconques et valeurs égales à 0
				//Initialisation liste Argent
				contenu3.add(new Parametrage(11, true, 2.0, 0, 0, 0, "TicketTest1", 1));
				contenu3.add(new Parametrage(12, true, 3.5, 0, 0, 0, "TicketTest2", 0));
				contenu3.add(new Parametrage(13, true, 2.5, 0, 0, 0, "TicketTest3", 5));
				//Création du fonds de caisse
					atester3 = new Vente(1, "2021-05-27", contenu3);
				//Test
					assertEquals(14.5 ,atester3.sommeCommande());
					assertEquals(6, atester3.getTotalTicket());
					assertEquals(2, atester3.getRow(contenu3));
					
	}
}
