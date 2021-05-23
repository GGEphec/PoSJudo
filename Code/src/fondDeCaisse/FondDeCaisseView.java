/**Cette classe va créer la vue fondDeCaisse avec les éléments qui permettent d'interragir avec celui-ci.
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package fondDeCaisse;

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
import miseEnSecurite.MiseEnSecuriteView;
import parametrage.ParametrageView;
import rapports.RapportsView;
import vente.VenteView;

public class FondDeCaisseView {
//Variables d'instance
	JFrame vueFondDeCaisse;
	private JTable resumeFondDeCaisse;
	DefaultTableModel modelTable = new DefaultTableModel(0,4);


	/**
	 * Creation de la vue fond de caisse
	 */
	public FondDeCaisseView() {
		//Création modèle
		FondDeCaisse fondCaisse = new FondDeCaisse();
		
		//Création graphique
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(105, 105, 105), 5);
		new CompoundBorder(noir1px, transparent9px);
		
		vueFondDeCaisse = new JFrame();
		vueFondDeCaisse.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		TitreVue.setEditable(false);
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setName("TitreAcceuil");
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Fond de caisse						Somme en caisse : " + DBHelper.getTotal() + "€");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		TitreVue.setFont(font);
		TitreVue.setHorizontalAlignment(JTextField.CENTER);
		vueFondDeCaisse.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalFondDeCaisse = new JPanel();
		vueFondDeCaisse.getContentPane().add(AffichagePrincipalFondDeCaisse, BorderLayout.CENTER);
		AffichagePrincipalFondDeCaisse.setLayout(new BoxLayout(AffichagePrincipalFondDeCaisse, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalFondDeCaisse.add(MenuLateral);
				MenuLateral.setSize(new Dimension(90, 617));
				MenuLateral.setBackground(new Color(119, 136, 153));
				MenuLateral.setBorder(transparent9px);
				MenuLateral.setLayout(new GridLayout(7, 1, 4, 4));
				
				//Boutons d'accès du menu latéral
					JButton btnAcceuil = new JButton("<html><p style=\"font-size:20px\">Accueil</p></html>");
					btnAcceuil.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueFondDeCaisse.dispose();
							new AcceuilView();
						}
					});
					MenuLateral.add(btnAcceuil);
					
					JButton btnVente = new JButton("<html><p style=\"font-size:20px\">Vente</p></html>");
					btnVente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueFondDeCaisse.dispose();
							new VenteView();
						}
					});
					MenuLateral.add(btnVente);
					
					JButton btnProduits = new JButton("<html><p style=\"font-size:20px\">Paramétrage</p></html>");
					btnProduits.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueFondDeCaisse.dispose();
							new ParametrageView();							
						}
					});
					MenuLateral.add(btnProduits);
					
					JButton btnCaisse = new JButton("<html><p style=\"font-size:20px\">Fond de caisse</p></html>");
					btnCaisse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueFondDeCaisse.dispose();
							new FondDeCaisseView();	
						}
					});
					MenuLateral.add(btnCaisse);
					
					JButton btnSecurite = new JButton("<html><p style=\"font-size:20px\">Mise en sécurité</p></html>");
					btnSecurite.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueFondDeCaisse.dispose();
							new MiseEnSecuriteView();	
						}
					});
					MenuLateral.add(btnSecurite);
					
					JButton btnRapports = new JButton("<html><p style=\"font-size:20px\">Rapports</p></html>");
					btnRapports.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueFondDeCaisse.dispose();
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
							vueFondDeCaisse.dispose();
						}
					});
					MenuLateral.add(btnClose);
					
					//Panneau des boutons pour introduire
					JPanel Boutons = new JPanel();
					AffichagePrincipalFondDeCaisse.add(Boutons);
					Boutons.setPreferredSize(new Dimension(550, 617));
					Boutons.setSize(new Dimension(550, 617));
					Boutons.setBackground(new Color(61, 72, 73));
					Boutons.setBorder(transparent9px);
					Boutons.setLayout(new GridLayout(6, 6, 4, 4));
					JButton btn00 = new JButton("");
					setInvisible(btn00);
					Boutons.add(btn00);

					
					JButton btn01 = new JButton("<html><p style=\"font-size:20px\">200€</p></html>");
					btn01.setName("argent20000");
					Boutons.add(btn01);
					btn01.addActionListener(new FondDeCaisseController(btn01, fondCaisse, modelTable));
					
					JButton btn02 = new JButton("<html><p style=\"font-size:20px\">100€</p></html>");
					btn02.setName("argent10000");
					Boutons.add(btn02);
					btn02.addActionListener(new FondDeCaisseController(btn02, fondCaisse, modelTable));
					
					JButton btn03 = new JButton("<html><p style=\"font-size:20px\">50€</p></html>");
					btn03.setName("argent5000");
					Boutons.add(btn03);
					btn03.addActionListener(new FondDeCaisseController(btn03, fondCaisse, modelTable));
					
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
					
					JButton btn11 = new JButton("<html><p style=\"font-size:20px\">20€</p></html>");
					btn11.setName("argent2000");
					Boutons.add(btn11);
					btn11.addActionListener(new FondDeCaisseController(btn11, fondCaisse, modelTable));
					
					JButton btn12 = new JButton("<html><p style=\"font-size:20px\">10€</p></html>");
					btn12.setName("argent1000");
					Boutons.add(btn12);
					btn12.addActionListener(new FondDeCaisseController(btn12, fondCaisse, modelTable));
					
					JButton btn13 = new JButton("<html><p style=\"font-size:20px\">5€</p></html>");
					btn13.setName("argent500");
					Boutons.add(btn13);
					btn13.addActionListener(new FondDeCaisseController(btn13, fondCaisse, modelTable));
					
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
					
					JButton btn31 = new JButton("<html><p style=\"font-size:20px\">2€</p></html>");
					btn31.setName("argent200");
					Boutons.add(btn31);
					btn31.addActionListener(new FondDeCaisseController(btn31, fondCaisse, modelTable));
					
					JButton btn32 = new JButton("<html><p style=\"font-size:20px\">1€</p></html>");
					btn32.setName("argent100");
					Boutons.add(btn32);
					btn32.addActionListener(new FondDeCaisseController(btn32, fondCaisse, modelTable));
					
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
					
					JButton btn41 = new JButton("<html><p style=\"font-size:20px\">0,50€</p></html>");
					btn41.setName("argent50");
					Boutons.add(btn41);
					btn41.addActionListener(new FondDeCaisseController(btn41, fondCaisse, modelTable));
					
					JButton btn42 = new JButton("<html><p style=\"font-size:20px\">0,20€</p></html>");
					btn42.setName("argent20");
					Boutons.add(btn42);
					btn42.addActionListener(new FondDeCaisseController(btn42, fondCaisse, modelTable));
					
					JButton btn43 = new JButton("<html><p style=\"font-size:20px\">0,10€</p></html>");
					btn43.setName("argent10");
					Boutons.add(btn43);
					btn43.addActionListener(new FondDeCaisseController(btn43, fondCaisse, modelTable));
					
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
					
					JButton btn51 = new JButton("<html><p style=\"font-size:20px\">0,05€</p></html>");
					btn51.setName("argent5");
					Boutons.add(btn51);
					btn51.addActionListener(new FondDeCaisseController(btn51, fondCaisse, modelTable));
					
					JButton btn52 = new JButton("<html><p style=\"font-size:20px\">0,02€</p></html>");
					btn52.setName("argent2");
					Boutons.add(btn52);
					btn52.addActionListener(new FondDeCaisseController(btn52, fondCaisse, modelTable));
					
					JButton btn53 = new JButton("<html><p style=\"font-size:20px\">0,01€</p></html>");
					btn53.setName("argent1");
					Boutons.add(btn53);
					btn53.addActionListener(new FondDeCaisseController(btn53, fondCaisse, modelTable));
					
					JButton btn54 = new JButton("");
					setInvisible(btn54);
					Boutons.add(btn54);
					
					JButton btn55 = new JButton("");
					setInvisible(btn55);
					Boutons.add(btn55);
	
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalFondDeCaisse.add(Resume);
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
				
				//Affichage du résumé de la commande
					resumeFondDeCaisse = new JTable(modelTable);
					Resume.add(resumeFondDeCaisse);
				
				//Panneau du bas pour introduire les chiffres et valider
					JPanel encodageArgent = new JPanel();
					Resume.add(encodageArgent);
					encodageArgent.setLayout(new GridLayout(1, 2, 0, 0));
					
					//Panneau du pavé numérique
						JPanel paveNumerique = new JPanel();
						encodageArgent.add(paveNumerique);
						paveNumerique.setLayout(new GridLayout(4, 3, 0, 0));
						
						JButton pave7 = new JButton("<html><p style=\"font-size:20px\">7</p></html>");
						pave7.setName("pave7");
						paveNumerique.add(pave7);
						pave7.addActionListener(new FondDeCaisseController(pave7, fondCaisse, modelTable));
						
						JButton pave8 = new JButton("<html><p style=\"font-size:20px\">8</p></html>");
						pave8.setName("pave8");
						paveNumerique.add(pave8);
						pave8.addActionListener(new FondDeCaisseController(pave8, fondCaisse, modelTable));
						
						JButton pave9 = new JButton("<html><p style=\"font-size:20px\">9</p></html>");
						pave9.setName("pave9");
						paveNumerique.add(pave9);
						pave9.addActionListener(new FondDeCaisseController(pave9, fondCaisse, modelTable));
						
						JButton pave4 = new JButton("<html><p style=\"font-size:20px\">4</p></html>");
						pave4.setName("pave4");
						paveNumerique.add(pave4);
						pave4.addActionListener(new FondDeCaisseController(pave4, fondCaisse, modelTable));
						
						JButton pave5 = new JButton("<html><p style=\"font-size:20px\">5</p></html>");
						pave5.setName("pave5");
						paveNumerique.add(pave5);
						pave5.addActionListener(new FondDeCaisseController(pave5, fondCaisse, modelTable));
						
						JButton pave6 = new JButton("<html><p style=\"font-size:20px\">6</p></html>");
						pave6.setName("pave6");
						paveNumerique.add(pave6);
						pave6.addActionListener(new FondDeCaisseController(pave6, fondCaisse, modelTable));
						
						JButton pave1 = new JButton("<html><p style=\"font-size:20px\">1</p></html>");
						pave1.setName("pave1");
						paveNumerique.add(pave1);
						pave1.addActionListener(new FondDeCaisseController(pave1, fondCaisse, modelTable));
						
						JButton pave2 = new JButton("<html><p style=\"font-size:20px\">2</p></html>");
						pave2.setName("pave2");
						paveNumerique.add(pave2);
						pave2.addActionListener(new FondDeCaisseController(pave2, fondCaisse, modelTable));
						
						JButton pave3 = new JButton("<html><p style=\"font-size:20px\">3</p></html>");
						pave3.setName("pave3");
						paveNumerique.add(pave3);
						pave3.addActionListener(new FondDeCaisseController(pave3, fondCaisse, modelTable));
						
						JButton paveVide = new JButton("");
						setInvisible(paveVide);
						paveNumerique.add(paveVide);
						
						JButton pave0 = new JButton("<html><p style=\"font-size:20px\">0</p></html>");
						pave0.setName("pave0");
						paveNumerique.add(pave0);
						pave0.addActionListener(new FondDeCaisseController(pave0, fondCaisse, modelTable));
						
						JButton pavePoint = new JButton(".");
						setInvisible(pavePoint);
						paveNumerique.add(pavePoint);
					
					//Panneau de validation
						JPanel validation = new JPanel();
						encodageArgent.add(validation);
						validation.setLayout(new GridLayout(2, 1, 0, 0));
						
						JButton validationVrai = new JButton("<html><p style=\"font-size:20px\">Valider</p></html>");
						validationVrai.setName("validationVrai");
						validation.add(validationVrai);
						validationVrai.addActionListener(new FondDeCaisseController(validationVrai, fondCaisse, modelTable));
						
						JButton validationFaux = new JButton("<html><p style=\"font-size:20px\">Annuler</p></html>");
						validationFaux.setName("validationFaux");
						validation.add(validationFaux);
						validationFaux.addActionListener(new FondDeCaisseController(validationFaux, fondCaisse, modelTable));
	}
					
	/**
	 * Cette fonction regroupe la modification de plusieurs attributs d'un objet JButton pour le rendre invisible	
	 * 
	 * @param btn Le boutton qu'il faut rendre invisible
	 */
	private void setInvisible(JButton btn) {
		btn.setOpaque(false);
		btn.setVisible(false);
		btn.setBorderPainted(false);
	}

}
