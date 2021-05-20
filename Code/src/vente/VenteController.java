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
			v.ajoutUnAchat(boutton.getName(), v.getNbre());
			v.setNbre(0);
		}
		else if(boutton.getName().contains("pave")) {
			v.setNbre(v.getNbre()*10 + Integer.parseInt(boutton.getName().substring(4, 5)));
			System.out.println(v.getNbre());
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
