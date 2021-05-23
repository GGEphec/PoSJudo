/**
 * 
 */
package rapports;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 * @author gaeta_2b6psqs
 *
 * @version 23 mai 2021
 */
public class RapportsController implements ActionListener{
	DefaultTableModel modeleRapport;
	JButton boutton;
	
	
	public RapportsController(JButton rapport, DefaultTableModel modelRapport) {
		super();
		this.boutton = rapport;
		this.modeleRapport=modelRapport;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("Vente")) {
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageVente(), test);
		}
		else if(boutton.getName().contains("miseEnSecu")) {
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageMeS(1), test);
		}
		else if(boutton.getName().contains("fondDeCaisse")){
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageFdC(1), test);
			
		}
		else if(boutton.getName().contains("ticket")){
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageTicket(1), test);
		}
		
	}
	
	
	
	
}
