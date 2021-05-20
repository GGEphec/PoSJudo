package fondDeCaisse;

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
import miseEnSecurite.MiseEnSecuriteController;
import miseEnSecurite.MiseEnSecuriteView;
import parametrage.ParametrageView;
import rapports.RapportsView;
import vente.VenteView;

public class FondDeCaisseView {

	JFrame vueFondDeCaisse;
	private JTable resumeFondDeCaisse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FondDeCaisseView window = new FondDeCaisseView();
					window.vueFondDeCaisse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FondDeCaisseView() {
		//Creation modele
		FondDeCaisse fondCaisse = new FondDeCaisse();
		
		//Creation graphique
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		CompoundBorder bordure = new CompoundBorder(noir1px, transparent9px);
		
		vueFondDeCaisse = new JFrame();
		vueFondDeCaisse.setSize(new Dimension(1850, 950));
		vueFondDeCaisse.setVisible(true);
		vueFondDeCaisse.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueFondDeCaisse.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueFondDeCaisse.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueFondDeCaisse.getContentPane().setSize(new Dimension(1280, 720));
		vueFondDeCaisse.getContentPane().setName("Fond de caisse");
		vueFondDeCaisse.getContentPane().setBackground(new Color(64, 64, 64));

		//Titre de la vue
		JTextField TitreVue = new JTextField();
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setName("TitreAcceuil");
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Fond de caisse");
		vueFondDeCaisse.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalFondDeCaisse = new JPanel();
		vueFondDeCaisse.getContentPane().add(AffichagePrincipalFondDeCaisse, BorderLayout.CENTER);
		AffichagePrincipalFondDeCaisse.setLayout(new BoxLayout(AffichagePrincipalFondDeCaisse, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalFondDeCaisse.add(MenuLateral);
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
							vueFondDeCaisse.dispose();
							AcceuilView av = new AcceuilView();
						}
					});
					MenuLateral.add(btnAcceuil);
					
					JButton btnVente = new JButton("Vente");
					btnVente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de vente
							vueFondDeCaisse.dispose();
							VenteView vv = new VenteView();
						}
					});
					MenuLateral.add(btnVente);
					
					JButton btnProduits = new JButton("Produits");
					btnProduits.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de paramétrage
							vueFondDeCaisse.dispose();
							ParametrageView pv = new ParametrageView();							
						}
					});
					MenuLateral.add(btnProduits);
					
					JButton btnCaisse = new JButton("Caisse");
					btnCaisse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de fond de caisse
							vueFondDeCaisse.dispose();
							FondDeCaisseView cv = new FondDeCaisseView();	
						}
					});
					MenuLateral.add(btnCaisse);
					
					JButton btnSecurite = new JButton("Sécurité");
					btnSecurite.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de mise en securite
							vueFondDeCaisse.dispose();
							MiseEnSecuriteView pv = new MiseEnSecuriteView();	
						}
					});
					MenuLateral.add(btnSecurite);
					
					JButton btnRapports = new JButton("Rapports");
					btnRapports.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de rapports
							vueFondDeCaisse.dispose();
							RapportsView rv = new RapportsView();	
						}
					});
					MenuLateral.add(btnRapports);
					
					//Panneau des boutons pour introduire
					JPanel Boutons = new JPanel();
					AffichagePrincipalFondDeCaisse.add(Boutons);
					//Boutons.setMinimumSize(new Dimension(53, 94));
					//Boutons.setMaximumSize(new Dimension(94, 562));
					Boutons.setPreferredSize(new Dimension(550, 617));
					Boutons.setSize(new Dimension(550, 617));
					Boutons.setBackground(new Color(150, 0, 150));
					Boutons.setBorder(transparent9px);
					Boutons.setLayout(new GridLayout(6, 6, 0, 0));
					JButton btn00 = new JButton("");
					setInvisible(btn00);
					Boutons.add(btn00);

					
					JButton btn01 = new JButton("200€");
					btn01.setName("argent20000");
					Boutons.add(btn01);
					btn01.addActionListener(new FondDeCaisseController(btn01, fondCaisse));
					
					JButton btn02 = new JButton("100€");
					btn02.setName("argent10000");
					Boutons.add(btn02);
					btn02.addActionListener(new FondDeCaisseController(btn02, fondCaisse));
					
					JButton btn03 = new JButton("50€");
					btn03.setName("argent5000");
					Boutons.add(btn03);
					btn03.addActionListener(new FondDeCaisseController(btn03, fondCaisse));
					
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
					btn11.setName("argent2000");
					Boutons.add(btn11);
					btn11.addActionListener(new FondDeCaisseController(btn11, fondCaisse));
					
					JButton btn12 = new JButton("10€");
					btn12.setName("argent1000");
					Boutons.add(btn12);
					btn12.addActionListener(new FondDeCaisseController(btn12, fondCaisse));
					
					JButton btn13 = new JButton("5€");
					btn13.setName("argent500");
					Boutons.add(btn13);
					btn13.addActionListener(new FondDeCaisseController(btn13, fondCaisse));
					
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
					btn31.setName("argent200");
					Boutons.add(btn31);
					btn31.addActionListener(new FondDeCaisseController(btn31, fondCaisse));
					
					JButton btn32 = new JButton("1€");
					btn32.setName("argent100");
					Boutons.add(btn32);
					btn32.addActionListener(new FondDeCaisseController(btn32, fondCaisse));
					
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
					btn41.setName("argent50");
					Boutons.add(btn41);
					btn41.addActionListener(new FondDeCaisseController(btn41, fondCaisse));
					
					JButton btn42 = new JButton("0,20€");
					btn42.setName("argent20");
					Boutons.add(btn42);
					btn42.addActionListener(new FondDeCaisseController(btn42, fondCaisse));
					
					JButton btn43 = new JButton("0,10€");
					btn43.setName("argent10");
					Boutons.add(btn43);
					btn43.addActionListener(new FondDeCaisseController(btn43, fondCaisse));
					
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
					btn51.setName("argent5");
					Boutons.add(btn51);
					btn51.addActionListener(new FondDeCaisseController(btn51, fondCaisse));
					
					JButton btn52 = new JButton("0,02€");
					btn52.setName("argent2");
					Boutons.add(btn52);
					btn52.addActionListener(new FondDeCaisseController(btn52, fondCaisse));
					
					JButton btn53 = new JButton("0,01€");
					btn53.setName("argent1");
					Boutons.add(btn53);
					btn53.addActionListener(new FondDeCaisseController(btn53, fondCaisse));
					
					JButton btn54 = new JButton("");
					setInvisible(btn54);
					Boutons.add(btn54);
					
					JButton btn55 = new JButton("");
					setInvisible(btn55);
					Boutons.add(btn55);
	
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalFondDeCaisse.add(Resume);
				//Resume.setMinimumSize(new Dimension(53, 94));
				//Resume.setMaximumSize(new Dimension(112, 562));
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
				
				//Affichage du résumé de la commande
					resumeFondDeCaisse = new JTable();
					Resume.add(resumeFondDeCaisse);
				
				//Panneau du bas pour introduire les chiffres et valider
					JPanel encodageArgent = new JPanel();
					Resume.add(encodageArgent);
					encodageArgent.setLayout(new GridLayout(1, 2, 0, 0));
					
					//Panneau du pavé numérique
						JPanel paveNumerique = new JPanel();
						encodageArgent.add(paveNumerique);
						paveNumerique.setLayout(new GridLayout(4, 3, 0, 0));
						
						JButton pave7 = new JButton("7");
						pave7.setName("pave7");
						paveNumerique.add(pave7);
						pave7.addActionListener(new FondDeCaisseController(pave7, fondCaisse));
						
						JButton pave8 = new JButton("8");
						pave8.setName("pave8");
						paveNumerique.add(pave8);
						pave8.addActionListener(new FondDeCaisseController(pave8, fondCaisse));
						
						JButton pave9 = new JButton("9");
						pave9.setName("pave9");
						paveNumerique.add(pave9);
						pave9.addActionListener(new FondDeCaisseController(pave9, fondCaisse));
						
						JButton pave4 = new JButton("4");
						pave4.setName("pave4");
						paveNumerique.add(pave4);
						pave4.addActionListener(new FondDeCaisseController(pave4, fondCaisse));
						
						JButton pave5 = new JButton("5");
						pave5.setName("pave5");
						paveNumerique.add(pave5);
						pave5.addActionListener(new FondDeCaisseController(pave5, fondCaisse));
						
						JButton pave6 = new JButton("6");
						pave6.setName("pave6");
						paveNumerique.add(pave6);
						pave6.addActionListener(new FondDeCaisseController(pave6, fondCaisse));
						
						JButton pave1 = new JButton("1");
						pave1.setName("pave1");
						paveNumerique.add(pave1);
						pave1.addActionListener(new FondDeCaisseController(pave1, fondCaisse));
						
						JButton pave2 = new JButton("2");
						pave2.setName("pave2");
						paveNumerique.add(pave2);
						pave2.addActionListener(new FondDeCaisseController(pave2, fondCaisse));
						
						JButton pave3 = new JButton("3");
						pave3.setName("pave3");
						paveNumerique.add(pave3);
						pave3.addActionListener(new FondDeCaisseController(pave3, fondCaisse));
						
						JButton paveVide = new JButton("");
						setInvisible(paveVide);
						paveNumerique.add(paveVide);
						
						JButton pave0 = new JButton("0");
						pave0.setName("pave0");
						paveNumerique.add(pave0);
						pave0.addActionListener(new FondDeCaisseController(pave0, fondCaisse));
						
						JButton pavePoint = new JButton(".");
						setInvisible(pavePoint);
						paveNumerique.add(pavePoint);
					
					//Panneau de validation
						JPanel validation = new JPanel();
						encodageArgent.add(validation);
						validation.setLayout(new GridLayout(2, 1, 0, 0));
						
						JButton validationVrai = new JButton("Valider");
						validationVrai.setName("validationVrai");
						validation.add(validationVrai);
						validationVrai.addActionListener(new FondDeCaisseController(validationVrai, fondCaisse));
						
						JButton validationFaux = new JButton("Annuler");
						validationFaux.setName("validationFaux");
						validation.add(validationFaux);
						validationFaux.addActionListener(new FondDeCaisseController(validationFaux, fondCaisse));
	}
					
		
	private void setInvisible(JButton btn) {
		btn.setOpaque(false);
		btn.setVisible(false);
		btn.setBorderPainted(false);
	}


}
