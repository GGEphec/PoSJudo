/**
 * 
 */
package vente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author gaeta_2b6psqs
 *
 */
public class VenteController implements ActionListener {
	private Vente v;
	private JButton boutton;

	public VenteController(JButton btn, Vente venteActuelle) {
		super();
		this.boutton = btn;
		this.v = venteActuelle;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("btn")) {
			v.ajoutUnAchat(boutton.getName());
		}
		else if(boutton.getName().contains("validation")) {
			if(boutton.getName().contains("Vrai")) {
				v.finaliserCommande();
			}
			else if(boutton.getName().contains("Faux")) {
				v.annulerCommande();
			}
			
		}
		
	}



}
