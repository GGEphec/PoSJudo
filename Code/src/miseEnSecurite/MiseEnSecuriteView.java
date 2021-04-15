package miseEnSecurite;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import acceuil.AcceuilView;
import fondDeCaisse.FondDeCaisseView;
import parametrage.ParametrageView;
import rapports.RapportsView;
import vente.VenteView;

public class MiseEnSecuriteView {

	private JFrame vueMiseEnSecurite;
	private JTable resumeMiseEnSecurite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiseEnSecuriteView window = new MiseEnSecuriteView();
					window.vueMiseEnSecurite.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiseEnSecuriteView() {
		initialize();
	}
	
	
	private void setInvisible(JButton btn) {
		btn.setOpaque(false);
		btn.setVisible(false);
		btn.setBorderPainted(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		CompoundBorder bordure = new CompoundBorder(noir1px, transparent9px);
		
		vueMiseEnSecurite = new JFrame();
		vueMiseEnSecurite.setSize(new Dimension(1850, 950));
		vueMiseEnSecurite.setVisible(true);
		vueMiseEnSecurite.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueMiseEnSecurite.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueMiseEnSecurite.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueMiseEnSecurite.getContentPane().setSize(new Dimension(1280, 720));
		vueMiseEnSecurite.getContentPane().setName("Mise en sécurité");
		vueMiseEnSecurite.getContentPane().setBackground(new Color(64, 64, 64));

		//Titre de la vue
		JTextField TitreVue = new JTextField();
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Mise en sécurité");
		vueMiseEnSecurite.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalMiseEnSecurite = new JPanel();
		vueMiseEnSecurite.getContentPane().add(AffichagePrincipalMiseEnSecurite, BorderLayout.CENTER);
		AffichagePrincipalMiseEnSecurite.setLayout(new BoxLayout(AffichagePrincipalMiseEnSecurite, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalMiseEnSecurite.add(MenuLateral);
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
						vueMiseEnSecurite.dispose();
						AcceuilView av = new AcceuilView();
					}
				});
				MenuLateral.add(btnAcceuil);
				
				JButton btnVente = new JButton("Vente");
				btnVente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de vente
						vueMiseEnSecurite.dispose();
						VenteView vv = new VenteView();
					}
				});
				MenuLateral.add(btnVente);
				
				JButton btnProduits = new JButton("Produits");
				btnProduits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de paramétrage
						vueMiseEnSecurite.dispose();
						ParametrageView pv = new ParametrageView();							
					}
				});
				MenuLateral.add(btnProduits);
				
				JButton btnCaisse = new JButton("Caisse");
				btnCaisse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de fond de caisse
						vueMiseEnSecurite.dispose();
						FondDeCaisseView cv = new FondDeCaisseView();	
					}
				});
				MenuLateral.add(btnCaisse);
				
				JButton btnSecurite = new JButton("Sécurité");
				btnSecurite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de mise en securite
						vueMiseEnSecurite.dispose();
						MiseEnSecuriteView pv = new MiseEnSecuriteView();	
					}
				});
				MenuLateral.add(btnSecurite);
				
				JButton btnRapports = new JButton("Rapports");
				btnRapports.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de rapports
						vueMiseEnSecurite.dispose();
						RapportsView rv = new RapportsView();	
					}
				});
				MenuLateral.add(btnRapports);
				
			//Panneau des boutons pour introduire
				JPanel Boutons = new JPanel();
				AffichagePrincipalMiseEnSecurite.add(Boutons);
				//Boutons.setMinimumSize(new Dimension(53, 94));
				//Boutons.setMaximumSize(new Dimension(94, 562));
				Boutons.setPreferredSize(new Dimension(550, 617));
				Boutons.setSize(new Dimension(550, 617));
				Boutons.setBackground(new Color(150, 0, 150));
				Boutons.setBorder(transparent9px);
				Boutons.setLayout(new GridLayout(6, 6, 0, 0));
				//Première ligne
					JButton btn00 = new JButton("");
					setInvisible(btn00);
					Boutons.add(btn00);

					
					JButton btn01 = new JButton("200€");
					Boutons.add(btn01);
					
					JButton btn02 = new JButton("100€");
					Boutons.add(btn02);
					
					JButton btn03 = new JButton("50€");
					Boutons.add(btn03);
					
					JButton btn04 = new JButton("");
					setInvisible(btn04);
					Boutons.add(btn04);

					
					JButton btn05 = new JButton("");
					setInvisible(btn05);
					Boutons.add(btn05);

				
				//Deuxième ligne
					JButton btn10 = new JButton("");
					setInvisible(btn10);
					Boutons.add(btn10);
					
					JButton btn11 = new JButton("20€");
					Boutons.add(btn11);
					
					JButton btn12 = new JButton("10€");
					Boutons.add(btn12);
					
					JButton btn13 = new JButton("5€");
					Boutons.add(btn13);
					
					JButton btn14 = new JButton("");
					setInvisible(btn14);
					Boutons.add(btn14);
					
					JButton btn15 = new JButton("");
					setInvisible(btn15);
					Boutons.add(btn15);
					
				//Troisième ligne
					JButton btn20 = new JButton("");
					setInvisible(btn20);
					Boutons.add(btn20);
					
					JButton btn21 = new JButton("");
					setInvisible(btn21);
					Boutons.add(btn21);
					
					JButton btn22 = new JButton("");
					setInvisible(btn22);
					Boutons.add(btn22);
					
					JButton btn23 = new JButton("");
					setInvisible(btn23);
					Boutons.add(btn23);
					
					JButton btn24 = new JButton("");
					setInvisible(btn24);
					Boutons.add(btn24);
					
					JButton btn25 = new JButton("");
					setInvisible(btn25);
					Boutons.add(btn25);
					
				//Quatrième ligne
					JButton btn30 = new JButton("");
					setInvisible(btn30);
					Boutons.add(btn30);
					
					JButton btn31 = new JButton("2€");
					Boutons.add(btn31);
					
					JButton btn32 = new JButton("1€");
					Boutons.add(btn32);
					
					JButton btn33 = new JButton("");
					setInvisible(btn33);
					Boutons.add(btn33);
					
					JButton btn34 = new JButton("");
					setInvisible(btn34);
					Boutons.add(btn34);
					
					JButton btn35 = new JButton("");
					setInvisible(btn35);
					Boutons.add(btn35);
					
				//Cinquième ligne
					JButton btn40 = new JButton("");
					setInvisible(btn40);
					Boutons.add(btn40);
					
					JButton btn41 = new JButton("0,50€");
					Boutons.add(btn41);
					
					JButton btn42 = new JButton("0,20€");
					Boutons.add(btn42);
					
					JButton btn43 = new JButton("0,10€");
					Boutons.add(btn43);
					
					JButton btn44 = new JButton("");
					setInvisible(btn44);
					Boutons.add(btn44);
					
					JButton btn45 = new JButton("");
					setInvisible(btn45);
					Boutons.add(btn45);
					
				//Sixième ligne
					JButton btn50 = new JButton("");
					setInvisible(btn50);
					Boutons.add(btn50);
					
					JButton btn51 = new JButton("0,05€");
					Boutons.add(btn51);
					
					JButton btn52 = new JButton("0,02€");
					Boutons.add(btn52);
					
					JButton btn53 = new JButton("0,01€");
					Boutons.add(btn53);
					
					JButton btn54 = new JButton("");
					setInvisible(btn54);
					Boutons.add(btn54);
					
					JButton btn55 = new JButton("");
					setInvisible(btn55);
					Boutons.add(btn55);
	
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalMiseEnSecurite.add(Resume);
				//Resume.setMinimumSize(new Dimension(53, 94));
				//Resume.setMaximumSize(new Dimension(112, 562));
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
				
				//Affichage du résumé de la commande
					resumeMiseEnSecurite = new JTable();
					Resume.add(resumeMiseEnSecurite);
				
				//Panneau du bas pour introduire les chiffres et valider
					JPanel encodageArgent = new JPanel();
					Resume.add(encodageArgent);
					encodageArgent.setLayout(new GridLayout(1, 2, 0, 0));
					
					//Panneau du pavé numérique
						JPanel paveNumerique = new JPanel();
						encodageArgent.add(paveNumerique);
						paveNumerique.setLayout(new GridLayout(4, 3, 0, 0));
						
						JButton pave7 = new JButton("7");
						paveNumerique.add(pave7);
						
						JButton pave8 = new JButton("8");
						paveNumerique.add(pave8);
						
						JButton pave9 = new JButton("9");
						paveNumerique.add(pave9);
						
						JButton pave4 = new JButton("4");
						paveNumerique.add(pave4);
						
						JButton pave5 = new JButton("5");
						paveNumerique.add(pave5);
						
						JButton pave6 = new JButton("6");
						paveNumerique.add(pave6);
						
						JButton pave1 = new JButton("1");
						paveNumerique.add(pave1);
						
						JButton pave2 = new JButton("2");
						paveNumerique.add(pave2);
						
						JButton pave3 = new JButton("3");
						paveNumerique.add(pave3);
						
						JButton paveVide = new JButton("");
						setInvisible(paveVide);
						paveNumerique.add(paveVide);
						
						JButton pave0 = new JButton("0");
						paveNumerique.add(pave0);
						
						JButton pavePoint = new JButton(".");
						paveNumerique.add(pavePoint);
					
					//Panneau de validation
						JPanel validation = new JPanel();
						encodageArgent.add(validation);
						validation.setLayout(new GridLayout(2, 1, 0, 0));
						
						JButton validationVrai = new JButton("Valider");
						validation.add(validationVrai);
						
						JButton validationFaux = new JButton("Annuler");
						validation.add(validationFaux);
					
		

	}

}