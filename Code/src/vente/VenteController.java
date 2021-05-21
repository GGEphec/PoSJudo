/**
 * 
 */
package vente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author gaeta_2b6psqs
 *
 */
public class VenteController implements ActionListener {
	private Vente v;
	private JButton boutton;
	private DefaultTableModel resume;
	private JTable resumeCommande;

	public VenteController(JButton btn, Vente venteActuelle, DefaultTableModel resume, JTable resumeCommande) {
		super();
		this.boutton = btn;
		this.v = venteActuelle;
		this.resume=resume;
		this.resumeCommande = resumeCommande;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("btn")) {
			//System.out.println(boutton.getName());
			v.ajoutUnAchat(boutton.getName(), (v.getNbre()==0 ? 1 : v.getNbre()));
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
		
		
		String[] item = {"test", "controller", "test", "contreoller"};
		resume.setDataVector(v.affichage(), item);
		//resumeCommande.setModel(v.affichage(resumeCommande));
		//resume.fireTableDataChanged();		
		
	}



}
