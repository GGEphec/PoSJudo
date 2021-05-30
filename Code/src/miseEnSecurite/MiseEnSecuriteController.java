/**Cette classe va permettre de controller la vue miseEnSecuriteView et interragir avec le modèle miseEnSecurite
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package miseEnSecurite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MiseEnSecuriteController implements ActionListener {
//Variables d'instance
	private MiseEnSecurite mes;
	private JButton boutton;
	private DefaultTableModel resumeMiseEnSecurite;
	private JTextField responsables;

//Constructeur
	/**
	 * Le constructeur du controlleur de la vue sur base des éléments à écouter/modifier
	 * 
	 * @param btn Le boutton qui vient d'être pressé
	 * @param miseEnSecurite Le modèle qui subit les modifications
	 * @param resumeMiseEnSecurite Le modèle du tableau qui contient le résumé de la mise en sécurité
	 * @param responsablesNom Le nom des responsables de la mise en sécurité
	 */
	public MiseEnSecuriteController(JButton btn, MiseEnSecurite miseEnSecurite, DefaultTableModel resumeMiseEnSecurite, JTextField responsablesNom) {
		super();
		this.boutton = btn;
		this.mes = miseEnSecurite;
		this.resumeMiseEnSecurite = resumeMiseEnSecurite;
		this.responsables = responsablesNom;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("argent")) { //Si c'est un boutton d'encodage d'argent
			if(mes.getNbre()==0) {
				mes.setNbre(1);
			}
			mes.ajoutSortie(boutton.getName(), mes.getNbre());
			mes.setNbre(0);
		}
		else if(boutton.getName().contains("pave")) { //Si c'est un boutton du pavé numérique
			mes.setNbre(mes.getNbre()*10 + Integer.parseInt(boutton.getName().substring(4, 5)));
		}
		else if(boutton.getName().contains("validation")) { //Si c'est un boutton pour valider ou annuler
			if(boutton.getName().contains("Vrai")) {
				mes.setResponsables(responsables.getText());
				mes.finaliserMiseEnSecurite();
			}
			else if(boutton.getName().contains("Faux")) {
				mes.annulerMiseEnSecurite();
			}
		}
		String[] item = {"test", "test", "test", "test"};
		resumeMiseEnSecurite.setDataVector(mes.affichage(), item);
	}
	
}
