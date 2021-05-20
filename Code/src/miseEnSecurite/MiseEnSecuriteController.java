package miseEnSecurite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MiseEnSecuriteController implements ActionListener {
	private MiseEnSecurite mes;
	private JButton boutton;
	private String nombre="0";
	private int nbre;

	public MiseEnSecuriteController(JButton btn, MiseEnSecurite miseEnSecurite) {
		super();
		this.boutton = btn;
		this.mes = miseEnSecurite;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("argent")) {
			System.out.println(nombre);
			nbre=(nombre=="0" ? 1 : Integer.parseInt(nombre));
			System.out.println("actionperf " + nbre + " " + boutton.getName());
			nombre="0";
			mes.ajoutSortie(boutton.getName(), nbre);
		}
		else if(boutton.getName().contains("pave")) {
			nombre+=boutton.getName().substring(4, 5);
			System.out.println(nombre);
		}
		else if(boutton.getName().contains("validation")) {
			if(boutton.getName().contains("Vrai")) {
				mes.finaliserMiseEnSecurite();
			}
			else if(boutton.getName().contains("Faux")) {
				mes.annulerMiseEnSecurite();
			}
			
		}
		
	}
}
