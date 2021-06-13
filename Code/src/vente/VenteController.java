/**Cette classe va permettre de controller la vue venteView et interragir avec le modèle vente
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package vente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import rapports.Print;

public class VenteController implements ActionListener {
//Variables d'instance
	private Vente v;
	private JButton boutton;
	private DefaultTableModel resume;
	private JTextField invalue;
	private JTextField outvalue;

//Constructeur
	/**
	 * Le constructeur du controlleur de la vue sur base des éléments à écouter/modifier
	 * 
	 * @param btn Le boutton qui vient d'être pressé
	 * @param venteActuelle Le modèle qui subit les modifications
	 * @param resume Le modèle du tableau qui contient le résumé de la vente
	 * @param invalue L'argent donné par le consommateur
	 * @param outvalue L'argent a rendre au consommateur
	 */
	public VenteController(JButton btn, Vente venteActuelle, DefaultTableModel resume, JTextField invalue, JTextField outvalue) {
		super();
		this.boutton = btn;
		this.v = venteActuelle;
		this.resume=resume;
		this.invalue=invalue;
		this.outvalue = outvalue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("btn")) { //Si c'est un boutton d'encodage de produit
			if(v.isMoins()) {
				System.out.println("moins");
				v.retireUnAchat(boutton.getName());
				v.setMoins(false);
			}
			else {
				v.ajoutUnAchat(boutton.getName(), (v.getNbre()==0 ? 1 : v.getNbre()));
				v.setNbre(0);
			}
		}
		else if(boutton.getName().contains("pave")) { //Si c'est un boutton du pavé numérique
			v.setNbre(v.getNbre()*10 + Integer.parseInt(boutton.getName().substring(4, 5)));
		}
		else if(boutton.getName().contains("validation")) { //Si c'est un boutton pour valider ou annuler
			if(boutton.getName().contains("Vrai")) {
				v.finaliserCommande();
			}
			else if(boutton.getName().contains("Faux")) {
				v.annulerCommande();
			}
			
		}
		else if(boutton.getName().contains("rapport")) {
			Print.print(v.affichage(), "Commande"+v.getIdCommande());
		}
		else if(boutton.getName().contains("moins")) {
			v.setMoins(true);
		}
		else if(boutton.getName().contains("rendu")) {
			outvalue.setText(Double.toString(Integer.parseInt(invalue.getText())-v.sommeCommande()));
		}
		
		
		String[] item = {"a", "a", "a", "contreoller"};
		resume.setDataVector(v.affichage(), item);
	}

}
