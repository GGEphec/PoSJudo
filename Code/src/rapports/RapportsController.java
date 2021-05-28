/**
 * 
 */
package rapports;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author gaeta_2b6psqs
 *
 * @version 23 mai 2021
 */
public class RapportsController implements ActionListener{
	DefaultTableModel modeleRapport;
	JButton boutton;
	JTextField choixVente;
	JTextField choixMeS;
	JTextField choixFdC;
	JTextField choixTicket;
	
	/**
	 * Construit le controlleur de la vue Rapport, il prend en paramètre le bouton appuyer, la table dans laquelle il faut écrire le rapport et les quatres champs dans lesquel on peut spécifier le rapport souhaité
	 * @param rapport le bouton qui est appuyé
	 * @param modelRapport le tableau ou il faut mettre le rapport
	 * @param choixVente le TextField qui contient la date dont on veut le rapport de vente
	 * @param choixMeS le TextField qui contient l'id de la mise en sécurité voulue
	 * @param choixFdC le TextField qui contient l'id du fond de caisse voulu
	 * @param choixTicket le TextField qui contient l'id du ticket voulu
	 */
	public RapportsController(JButton rapport, DefaultTableModel modelRapport, JTextField choixVente, JTextField choixMeS, JTextField choixFdC, JTextField choixTicket) {
		super();
		this.boutton = rapport;
		this.modeleRapport=modelRapport;
		this.choixVente = choixVente;
		this.choixMeS = choixMeS;
		this.choixFdC = choixFdC;
		this.choixTicket = choixTicket;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(boutton.getName().contains("Vente")) {
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageVente(choixVente.getText()), test);
			//Print.print(RapportsView.info);
		}
		else if(boutton.getName().contains("MiseEnSecu")) {
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageMeS(Integer.parseInt(choixMeS.getText())), test);
		}
		else if(boutton.getName().contains("FondDeCaisse")){
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageFdC(Integer.parseInt(choixFdC.getText())), test);
			
		}
		else if(boutton.getName().contains("ticket")){
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageTicket(Integer.parseInt(choixTicket.getText())), test);
		}
		
	}
	
	
	
	
}
