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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	DefaultTableModel modelRapport  = new DefaultTableModel(0,3);
	static JPanel info;
	public static JTextField choixImpression;
	
	
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
		TitreVue.setEditable(false);
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
		MenuLateral.setSize(new Dimension(1, 617));
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

		JButton btnProduits = new JButton("<html><p style=\"font-size:20px\">Paramétrage produits</p></html>");
		btnProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vueRapports.dispose();
				new ParametrageView();
			}
		});
		MenuLateral.add(btnProduits);

		JButton btnCaisse = new JButton("<html><p style=\"font-size:20px\">Fonds de caisse</p></html>");
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
		info = new JPanel();
		info.setPreferredSize(new Dimension(1050, 617));
		info.setSize(new Dimension(1050, 617));
		info.setBackground(new Color(61, 72, 73));
		info.setBorder(transparent9px);
		AffichagePrincipalRapports.add(info);
		info.setLayout(new GridLayout(1,2,0,0));

		JTable rapport = new JTable(modelRapport);
		rapport.setRowHeight(18);
		rapport.setFont(new Font("Verdana", Font.PLAIN, 17));
		info.add(rapport);
		
		JPanel choixRapport = new JPanel();
		choixRapport.setPreferredSize(new Dimension(350, 617));
		choixRapport.setSize(new Dimension(350, 617));
		choixRapport.setBackground(new Color(150, 150, 0));
		choixRapport.setBorder(transparent9px);
		AffichagePrincipalRapports.add(choixRapport);
		choixRapport.setLayout(new GridLayout(5,2));
		
		
			JButton rapportVente = new JButton("<html><p style=\"font-size:16px\">Rapport vente</p></html>");
			rapportVente.setName("rapportVente");
			choixRapport.add(rapportVente);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			JTextField choixVente = new JTextField();
			choixVente.setFont(new Font("Verdana", Font.PLAIN, 17));
			choixVente.setText(dtf.format(now));
			choixRapport.add(choixVente);
			
			JButton rapportMiseEnSecu = new JButton("<html><p style=\"font-size:16px\">Rapport mise en sécurité</p></html>");
			rapportMiseEnSecu.setName("rapportMiseEnSecurite");
			choixRapport.add(rapportMiseEnSecu);
			JTextField choixMeS = new JTextField();
			choixMeS.setFont(new Font("Verdana", Font.PLAIN, 17));
			choixMeS.setText(Integer.toString(DBHelper.getMaxMeS()));
			choixRapport.add(choixMeS);
			
			JButton rapportFondDeCaisse = new JButton("<html><p style=\"font-size:16px\">Rapport fonds de caisse</p></html>");
			rapportFondDeCaisse.setName("rapportFondDeCaisse");
			choixRapport.add(rapportFondDeCaisse);
			JTextField choixFdC = new JTextField();
			choixFdC.setFont(new Font("Verdana", Font.PLAIN, 17));
			choixFdC.setText(Integer.toString(DBHelper.getMaxFdC()));
			choixRapport.add(choixFdC);
			
			JButton rapportTicket = new JButton("<html><p style=\"font-size:16px\">Ticket N°</p></html>");
			rapportTicket.setName("ticket");
			choixRapport.add(rapportTicket);
			JTextField choixTicket = new JTextField();
			choixTicket.setFont(new Font("Verdana", Font.PLAIN, 17));
			choixTicket.setText(Integer.toString(DBHelper.nextCommande()));
			choixRapport.add(choixTicket);
			
			JButton rapportImpression = new JButton("<html><p style=\"font-size:16px\">Export PDF</p></html>");
			rapportImpression.setName("PDF");
			choixRapport.add(rapportImpression);
			choixImpression = new JTextField();
			choixImpression.setFont(new Font("Verdana", Font.PLAIN, 16));
			choixImpression.setEditable(false);
			choixRapport.add(choixImpression);
			
			rapportVente.addActionListener(new RapportsController(rapportVente, modelRapport, choixVente, choixMeS, choixFdC, choixTicket));
			rapportMiseEnSecu.addActionListener(new RapportsController(rapportMiseEnSecu, modelRapport, choixVente, choixMeS, choixFdC, choixTicket));
			rapportFondDeCaisse.addActionListener(new RapportsController(rapportFondDeCaisse, modelRapport, choixVente, choixMeS, choixFdC, choixTicket));
			rapportTicket.addActionListener(new RapportsController(rapportTicket, modelRapport, choixVente, choixMeS, choixFdC, choixTicket));
			rapportImpression.addActionListener(new RapportsController(rapportImpression, modelRapport, choixVente, choixMeS, choixFdC, choixTicket));
	}

}
