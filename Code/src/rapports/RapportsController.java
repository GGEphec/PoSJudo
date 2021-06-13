/**
 * 
 */
package rapports;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	
	private static String choix;
	private static String choixN;
	
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
			choix = "vente";
			choixN = choixVente.getText();
			RapportsView.choixImpression.setText("Vente du " + choixN);
		}
		else if(boutton.getName().contains("MiseEnSecu")) {
			String[] test = {"test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageMeS(Integer.parseInt(choixMeS.getText())), test);
			choix = "MeS";
			choixN = choixMeS.getText();
			RapportsView.choixImpression.setText("Mise en sécurité N°"+choixN);
		}
		else if(boutton.getName().contains("FondDeCaisse")){
			String[] test = {"test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageFdC(Integer.parseInt(choixFdC.getText())), test);
			choix = "FdC";
			choixN = choixFdC.getText();
			RapportsView.choixImpression.setText("Fonds de caisse N°" + choixN);
			
		}
		else if(boutton.getName().contains("ticket")){
			String[] test = {"test", "test", "test", "test"};
			modeleRapport.setDataVector(Rapports.affichageTicket(Integer.parseInt(choixTicket.getText())), test);
			choix = "ticket";
			choixN = choixTicket.getText();
			RapportsView.choixImpression.setText("Ticket N°" + choixN);
		}
		else if(boutton.getName().contains("PDF")) {
			if(choix.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Pas de valeur retenue");
			}
			else {
				if(choix.contains("vente")) {
					Print.print(Rapports.affichageVente(choixN), "vente"+choixN);
				}
				else if(choix.contains("MeS")) {
					Print.print(Rapports.affichageMeS(Integer.parseInt(choixN)), "MeS"+choixN);
				}
				else if(choix.contains("FdC")) {
					Print.print(Rapports.affichageFdC(Integer.parseInt(choixN)), "FdC"+choixN);
				}
				else if(choix.contains("ticket")) {
					Print.print(Rapports.affichageTicket(Integer.parseInt(choixN)), "ticket"+choixN);
				}
			}
			
		}
		
	}
	
	
	
	
}
