package rapports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import acceuil.AcceuilView;
import fondDeCaisse.FondDeCaisseView;
import miseEnSecurite.MiseEnSecuriteView;
import parametrage.ParametrageView;
import vente.VenteView;

public class RapportsView {

	private JFrame vueRapports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RapportsView window = new RapportsView();
					window.vueRapports.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RapportsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		CompoundBorder bordure = new CompoundBorder(noir1px, transparent9px);
		
		vueRapports = new JFrame();
		vueRapports.setSize(new Dimension(1850, 950));
		vueRapports.setVisible(true);
		vueRapports.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueRapports.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueRapports.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueRapports.getContentPane().setSize(new Dimension(1280, 720));
		vueRapports.getContentPane().setName("Rapports");
		vueRapports.getContentPane().setBackground(new Color(64, 64, 64));

		//Titre de la vue
		JTextField TitreVue = new JTextField();
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setName("TitreAcceuil");
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Rapports");
		vueRapports.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalRapports = new JPanel();
		vueRapports.getContentPane().add(AffichagePrincipalRapports, BorderLayout.CENTER);
		AffichagePrincipalRapports.setLayout(new BoxLayout(AffichagePrincipalRapports, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalRapports.add(MenuLateral);
				//MenuLateral.setMinimumSize(new Dimension(53, 94));
				//MenuLateral.setMaximumSize(new Dimension(94, 562));
				//MenuLateral.setPreferredSize(new Dimension(112, 617));
				MenuLateral.setSize(new Dimension(90, 617));
				MenuLateral.setBackground(new Color(0, 150, 150));
				MenuLateral.setBorder(transparent9px);
				MenuLateral.setLayout(new GridLayout(6, 1, 0, 0));
				
				//Boutons d'accès du menu latéral
					JButton btnAcceuil = new JButton("Acceuil");
					btnAcceuil.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue d'acceuil
							vueRapports.dispose();
							AcceuilView av = new AcceuilView();
						}
					});
					MenuLateral.add(btnAcceuil);
					
					JButton btnVente = new JButton("Vente");
					btnVente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de vente
							vueRapports.dispose();
							VenteView vv = new VenteView();
						}
					});
					MenuLateral.add(btnVente);
					
					JButton btnProduits = new JButton("Produits");
					btnProduits.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de paramétrage
							vueRapports.dispose();
							ParametrageView pv = new ParametrageView();							
						}
					});
					MenuLateral.add(btnProduits);
					
					JButton btnCaisse = new JButton("Caisse");
					btnCaisse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de fond de caisse
							vueRapports.dispose();
							FondDeCaisseView cv = new FondDeCaisseView();	
						}
					});
					MenuLateral.add(btnCaisse);
					
					JButton btnSecurite = new JButton("Sécurité");
					btnSecurite.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de mise en securite
							vueRapports.dispose();
							MiseEnSecuriteView pv = new MiseEnSecuriteView();	
						}
					});
					MenuLateral.add(btnSecurite);
					
					JButton btnRapports = new JButton("Rapports");
					btnRapports.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de rapports
							vueRapports.dispose();
							RapportsView rv = new RapportsView();	
						}
					});
					MenuLateral.add(btnRapports);
					
			//Panneau principal qui va changer en fonction de la vue
				JPanel info = new JPanel();
				AffichagePrincipalRapports.add(info);
				


	}

}
