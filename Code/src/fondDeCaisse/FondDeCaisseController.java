/**Cette classe va permettre de controller la vue fondDeCaisseView et interragir avec le modèle fondDeCaisse
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package fondDeCaisse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class FondDeCaisseController implements ActionListener {
//Variable d'instance
	private FondDeCaisse fondCaisse;
	private JButton boutton;
	private DefaultTableModel resumeFondCaisse;
	
//Constructeur
	/**
	 * Le constructeur du controlleur de la vue sur base des éléments à écouter/modifier
	 * 
	 * @param btn Le boutton qui vient d'être pressé
	 * @param fondCaisse Le modèle qui subit les modifications
	 * @param resumeFondCaisse Le modele du tableau qui contient le résumé du fond de caisse
	 */
	public FondDeCaisseController(JButton btn, FondDeCaisse fondCaisse, DefaultTableModel resumeFondCaisse) {
		super();
		this.fondCaisse = fondCaisse;
		this.boutton = btn;
		this.resumeFondCaisse = resumeFondCaisse;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("argent")) { //Si c'est un bouton d'encodage d'argent
			if(fondCaisse.getNbre()==0) {
				fondCaisse.setNbre(1);
			}
			fondCaisse.ajoutEntree(boutton.getName(), fondCaisse.getNbre());
			fondCaisse.setNbre(0);
		}
		else if(boutton.getName().contains("pave")) { //Si c'est un bouton du pavé numérique
			fondCaisse.setNbre(fondCaisse.getNbre()*10 + Integer.parseInt(boutton.getName().substring(4, 5)));
			//System.out.println(fondCaisse.getNbre());
		}
		else if(boutton.getName().contains("validation")) { //Si c'est un boutton pour valider ou annuler
			if(boutton.getName().contains("Vrai")) {
				fondCaisse.finaliserFondDeCaisse();
			}
			else if(boutton.getName().contains("Faux")) {
				fondCaisse.annulerFondDeCaisse();
			}
		}
		String[] item = {"test", "test", "test", "test"};
		resumeFondCaisse.setDataVector(fondCaisse.affichage(), item);
	}

}
