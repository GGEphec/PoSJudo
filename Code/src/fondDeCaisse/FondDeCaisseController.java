/**
 * 
 */
package fondDeCaisse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author gaeta_2b6psqs
 *
 */
public class FondDeCaisseController implements ActionListener {
	private FondDeCaisse fondCaisse;
	private JButton boutton;
	
	
	public FondDeCaisseController(JButton btn, FondDeCaisse fondCaisse) {
		super();
		this.fondCaisse = fondCaisse;
		this.boutton = btn;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("argent")) {
			if(fondCaisse.getNbre()==0) {
				fondCaisse.setNbre(1);
			}
			fondCaisse.ajoutEntree(boutton.getName(), fondCaisse.getNbre());
			fondCaisse.setNbre(0);
		}
		else if(boutton.getName().contains("pave")) {
			fondCaisse.setNbre(fondCaisse.getNbre()*10 + Integer.parseInt(boutton.getName().substring(4, 5)));
			System.out.println(fondCaisse.getNbre());
		}
		else if(boutton.getName().contains("validation")) {
			if(boutton.getName().contains("Vrai")) {
				fondCaisse.finaliserFondDeCaisse();
			}
			else if(boutton.getName().contains("Faux")) {
				fondCaisse.annulerFondDeCaisse();
			}
			
		}
		
	}
		


}
