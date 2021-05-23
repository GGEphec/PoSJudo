/**Cette classe va créer la vue rapport avec les éléments qui permettent d'interragir avec celui-ci.
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package rapports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import acceuil.AcceuilView;
import acceuil.DBHelper;
import fondDeCaisse.FondDeCaisseView;
import miseEnSecurite.MiseEnSecuriteView;
import parametrage.ParametrageView;
import vente.VenteView;

public class RapportsView {
//Variables d'instances
	private JFrame vueRapports;
	DefaultTableModel modelRapport  = new DefaultTableModel(0,4);

	/**
	 * Création de la vue rapport
	 */
	public RapportsView() {
		Border noir1px = new LineBorder(new Color(0, 0, 0));
		Border transparent9px = new LineBorder(new Color(105, 105, 105), 5);
		new CompoundBorder(noir1px, transparent9px);

		vueRapports = new JFrame();
		vueRapports.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		vueRapports.setSize(new Dimension(1850, 950));
		vueRapports.setVisible(true);
		vueRapports.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueRapports.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueRapports.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueRapports.getContentPane().setSize(new Dimension(1280, 720));
		vueRapports.getContentPane().setName("Rapports");
		vueRapports.getContentPane().setBackground(new Color(64, 64, 64));

		// Titre de la vue
		JTextField TitreVue = new JTextField();
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setName("TitreAcceuil");
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Rapports						Somme en caisse : " + DBHelper.getTotal() + "€");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		TitreVue.setFont(font);
		TitreVue.setHorizontalAlignment(JTextField.CENTER);
		vueRapports.getContentPane().add(TitreVue, BorderLayout.NORTH);

		// Affichage principal
		JPanel AffichagePrincipalRapports = new JPanel();
		vueRapports.getContentPane().add(AffichagePrincipalRapports, BorderLayout.CENTER);
		AffichagePrincipalRapports.setLayout(new BoxLayout(AffichagePrincipalRapports, BoxLayout.X_AXIS));

		// Panneau du menu latéral commun à toutes les vues
		JPanel MenuLateral = new JPanel();
		AffichagePrincipalRapports.add(MenuLateral);
		MenuLateral.setSize(new Dimension(90, 617));
		MenuLateral.setBackground(new Color(119, 136, 153));
		MenuLateral.setBorder(transparent9px);
		MenuLateral.setLayout(new GridLayout(7, 1, 4, 4));

		// Boutons d'accès du menu latéral
		JButton btnAcceuil = new JButton("<html><p style=\"font-size:20px\">Accueil</p></html>");
		btnAcceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new AcceuilView();
			}
		});
		MenuLateral.add(btnAcceuil);

		JButton btnVente = new JButton("<html><p style=\"font-size:20px\">Vente</p></html>");
		btnVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new VenteView();
			}
		});
		MenuLateral.add(btnVente);

		JButton btnProduits = new JButton("<html><p style=\"font-size:20px\">Paramétrage</p></html>");
		btnProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new ParametrageView();
			}
		});
		MenuLateral.add(btnProduits);

		JButton btnCaisse = new JButton("<html><p style=\"font-size:20px\">Fond de caisse</p></html>");
		btnCaisse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new FondDeCaisseView();
			}
		});
		MenuLateral.add(btnCaisse);

		JButton btnSecurite = new JButton("<html><p style=\"font-size:20px\">Mise en sécurité</p></html>");
		btnSecurite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new MiseEnSecuriteView();
			}
		});
		MenuLateral.add(btnSecurite);

		JButton btnRapports = new JButton("<html><p style=\"font-size:20px\">Rapports</p></html>");
		btnRapports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new RapportsView();
			}
		});
		MenuLateral.add(btnRapports);

		JButton btnClose = new JButton("<html><p style=\"font-size:20px\">Quitter</p></html>");
		btnClose.setBackground(new Color(178, 34, 34));
		btnClose.setForeground(Color.WHITE);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBHelper.shutdown();
				vueRapports.dispose();
			}
		});
		MenuLateral.add(btnClose);

		// Panneau principal qui va changer en fonction de la vue
		JPanel info = new JPanel();
		info.setPreferredSize(new Dimension(850, 617));
		info.setSize(new Dimension(850, 617));
		info.setBackground(new Color(61, 72, 73));
		info.setBorder(transparent9px);
		AffichagePrincipalRapports.add(info);
		info.setLayout(new GridLayout(1,2,0,0));

		JTable rapport = new JTable(modelRapport);
		info.add(rapport);
		
		JPanel choixRapport = new JPanel();
		choixRapport.setPreferredSize(new Dimension(250, 617));
		choixRapport.setSize(new Dimension(250, 617));
		choixRapport.setBackground(new Color(150, 150, 0));
		choixRapport.setBorder(transparent9px);
		AffichagePrincipalRapports.add(choixRapport);
		choixRapport.setLayout(new GridLayout(4,2));
		
			JButton rapportVente = new JButton("Rapport vente");
			rapportVente.setName("rapportVente");
			choixRapport.add(rapportVente);
			rapportVente.addActionListener(new RapportsController(rapportVente, modelRapport));
			JTextField rien = new JTextField();
			rien.setEditable(false);
			choixRapport.add(rien);
			
			JButton rapportMiseEnSecu = new JButton("Rapport mise en sécurité");
			rapportMiseEnSecu.setName("rapportMiseEnSecurite");
			choixRapport.add(rapportMiseEnSecu);
			rapportMiseEnSecu.addActionListener(new RapportsController(rapportMiseEnSecu, modelRapport));
			JTextField choixMeS = new JTextField();
			choixRapport.add(choixMeS);
			
			JButton rapportFondDeCaisse = new JButton("Rapport fond de caisse");
			rapportFondDeCaisse.setName("rapportFondDeCaisse");
			choixRapport.add(rapportFondDeCaisse);
			rapportFondDeCaisse.addActionListener(new RapportsController(rapportFondDeCaisse, modelRapport));
			JTextField choixFdC = new JTextField();
			choixRapport.add(choixFdC);
			
			JButton rapportTicket = new JButton("Ticket N° ");
			rapportTicket.setName("ticket");
			choixRapport.add(rapportTicket);
			rapportTicket.addActionListener(new RapportsController(rapportTicket, modelRapport));
			JTextField choixTicket = new JTextField();
			choixRapport.add(choixTicket);
			

	}

}
