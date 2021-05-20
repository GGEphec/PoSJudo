package miseEnSecurite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MiseEnSecuriteController implements ActionListener {
	private MiseEnSecurite mes;
	private JButton boutton;
	//private String nombre="0";

	public MiseEnSecuriteController(JButton btn, MiseEnSecurite miseEnSecurite) {
		super();
		this.boutton = btn;
		this.mes = miseEnSecurite;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("argent")) {
			if(mes.getNbre()==0) {
				mes.setNbre(1);
			}
			mes.ajoutSortie(boutton.getName(), mes.getNbre());
			mes.setNbre(0);
		}
		else if(boutton.getName().contains("pave")) {
			mes.setNbre(mes.getNbre()*10 + Integer.parseInt(boutton.getName().substring(4, 5)));
			System.out.println(mes.getNbre());
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
