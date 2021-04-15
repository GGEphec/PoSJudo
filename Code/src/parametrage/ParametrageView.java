package parametrage;

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
import rapports.RapportsView;
import vente.VenteView;

public class ParametrageView {

	private JFrame vueParametrage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParametrageView window = new ParametrageView();
					window.vueParametrage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParametrageView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		CompoundBorder bordure = new CompoundBorder(noir1px, transparent9px);
		
		vueParametrage = new JFrame();
		vueParametrage.setSize(new Dimension(1850, 950));
		vueParametrage.setVisible(true);
		vueParametrage.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueParametrage.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueParametrage.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueParametrage.getContentPane().setSize(new Dimension(1280, 720));
		vueParametrage.getContentPane().setName("Paramétrage");
		vueParametrage.getContentPane().setBackground(new Color(64, 64, 64));

		//Titre de la vue
		JTextField TitreVue = new JTextField();
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Paramétrage");
		vueParametrage.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalParametrage = new JPanel();
		vueParametrage.getContentPane().add(AffichagePrincipalParametrage, BorderLayout.CENTER);
		AffichagePrincipalParametrage.setLayout(new BoxLayout(AffichagePrincipalParametrage, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalParametrage.add(MenuLateral);
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
						vueParametrage.dispose();
						AcceuilView av = new AcceuilView();
					}
				});
				MenuLateral.add(btnAcceuil);
				
				JButton btnVente = new JButton("Vente");
				btnVente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de vente
						vueParametrage.dispose();
						VenteView vv = new VenteView();
					}
				});
				MenuLateral.add(btnVente);
				
				JButton btnProduits = new JButton("Produits");
				btnProduits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de paramétrage
						vueParametrage.dispose();
						ParametrageView pv = new ParametrageView();							
					}
				});
				MenuLateral.add(btnProduits);
				
				JButton btnCaisse = new JButton("Caisse");
				btnCaisse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de fond de caisse
						vueParametrage.dispose();
						FondDeCaisseView cv = new FondDeCaisseView();	
					}
				});
				MenuLateral.add(btnCaisse);
				
				JButton btnSecurite = new JButton("Sécurité");
				btnSecurite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de mise en securite
						vueParametrage.dispose();
						MiseEnSecuriteView pv = new MiseEnSecuriteView();	
					}
				});
				MenuLateral.add(btnSecurite);
				
				JButton btnRapports = new JButton("Rapports");
				btnRapports.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de rapports
						vueParametrage.dispose();
						RapportsView rv = new RapportsView();	
					}
				});
				MenuLateral.add(btnRapports);
				
			//Panneau des boutons pour introduire
				JPanel Boutons = new JPanel();
				AffichagePrincipalParametrage.add(Boutons);
				//Boutons.setMinimumSize(new Dimension(53, 94));
				//Boutons.setMaximumSize(new Dimension(94, 562));
				Boutons.setPreferredSize(new Dimension(550, 617));
				Boutons.setSize(new Dimension(550, 617));
				Boutons.setBackground(new Color(150, 0, 150));
				Boutons.setBorder(transparent9px);
				Boutons.setLayout(new GridLayout(6, 6, 0, 0));
				//Première ligne
					JButton btn00 = new JButton("New button");
					Boutons.add(btn00);
					
					JButton btn01 = new JButton("New button");
					Boutons.add(btn01);
					
					JButton btn02 = new JButton("New button");
					Boutons.add(btn02);
					
					JButton btn03 = new JButton("New button");
					Boutons.add(btn03);
					
					JButton btn04 = new JButton("New button");
					Boutons.add(btn04);
					
					JButton btn05 = new JButton("New button");
					Boutons.add(btn05);
				
				//Deuxième ligne
					JButton btn10 = new JButton("New button");
					Boutons.add(btn10);
					
					JButton btn11 = new JButton("New button");
					Boutons.add(btn11);
					
					JButton btn12 = new JButton("New button");
					Boutons.add(btn12);
					
					JButton btn13 = new JButton("New button");
					Boutons.add(btn13);
					
					JButton btn14 = new JButton("New button");
					Boutons.add(btn14);
					
					JButton btn15 = new JButton("New button");
					Boutons.add(btn15);
					
				//Troisième ligne
					JButton btn20 = new JButton("New button");
					Boutons.add(btn20);
					
					JButton btn21 = new JButton("New button");
					Boutons.add(btn21);
					
					JButton btn22 = new JButton("New button");
					Boutons.add(btn22);
					
					JButton btn23 = new JButton("New button");
					Boutons.add(btn23);
					
					JButton btn24 = new JButton("New button");
					Boutons.add(btn24);
					
					JButton btn25 = new JButton("New button");
					Boutons.add(btn25);
					
				//Quatrième ligne
					JButton btn30 = new JButton("New button");
					Boutons.add(btn30);
					
					JButton btn31 = new JButton("New button");
					Boutons.add(btn31);
					
					JButton btn32 = new JButton("New button");
					Boutons.add(btn32);
					
					JButton btn33 = new JButton("New button");
					Boutons.add(btn33);
					
					JButton btn34 = new JButton("New button");
					Boutons.add(btn34);
					
					JButton btn35 = new JButton("New button");
					Boutons.add(btn35);
					
				//Cinquième ligne
					JButton btn40 = new JButton("New button");
					Boutons.add(btn40);
					
					JButton btn41 = new JButton("New button");
					Boutons.add(btn41);
					
					JButton btn42 = new JButton("New button");
					Boutons.add(btn42);
					
					JButton btn43 = new JButton("New button");
					Boutons.add(btn43);
					
					JButton btn44 = new JButton("New button");
					Boutons.add(btn44);
					
					JButton btn45 = new JButton("New button");
					Boutons.add(btn45);
					
				//Sixième ligne
					JButton btn50 = new JButton("New button");
					Boutons.add(btn50);
					
					JButton btn51 = new JButton("New button");
					Boutons.add(btn51);
					
					JButton btn52 = new JButton("New button");
					Boutons.add(btn52);
					
					JButton btn53 = new JButton("New button");
					Boutons.add(btn53);
					
					JButton btn54 = new JButton("New button");
					Boutons.add(btn54);
					
					JButton btn55 = new JButton("New button");
					Boutons.add(btn55);
	
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalParametrage.add(Resume);
				//Resume.setMinimumSize(new Dimension(53, 94));
				//Resume.setMaximumSize(new Dimension(112, 562));
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
	}

}