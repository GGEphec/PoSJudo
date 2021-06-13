/**Cette classe va créer la vue venteView avec les éléments qui permettent d'interragir avec celle-ci.
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package vente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import parametrage.Parametrage;
import parametrage.ParametrageView;
import rapports.RapportsView;

public class VenteView {
//Varaibles d'instance
	JFrame vueVente;
	static JTable resumeCommande;
	DefaultTableModel modelTable = new DefaultTableModel(0,4);
	private List<Parametrage> liste;
	JTextField invalue, outvalue;


	/**
	 * Création de la vue vente
	 */
	public VenteView() {
	//Création modele
		Vente venteActuelle = new Vente();
		liste=DBHelper.getProduits();
		
		
	//Création graphique
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(105, 105, 105), 5);
		new CompoundBorder(noir1px, transparent9px);
		
		vueVente = new JFrame();
		vueVente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		vueVente.setSize(new Dimension(1850, 950));
		vueVente.setVisible(true);
		vueVente.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueVente.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueVente.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueVente.getContentPane().setSize(new Dimension(1280, 720));
		vueVente.getContentPane().setName("Vente");
		vueVente.getContentPane().setBackground(new Color(64, 64, 64));

		//Titre de la vue
		JTextField TitreVue = new JTextField();
		TitreVue.setEditable(false);
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Vente							Somme en caisse : " + DBHelper.getTotal() + "€");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		TitreVue.setFont(font);
		TitreVue.setHorizontalAlignment(JTextField.CENTER);
		vueVente.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalVente = new JPanel();
		vueVente.getContentPane().add(AffichagePrincipalVente, BorderLayout.CENTER);
		AffichagePrincipalVente.setLayout(new BoxLayout(AffichagePrincipalVente, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalVente.add(MenuLateral);
				MenuLateral.setSize(new Dimension(90, 617));
				MenuLateral.setBackground(new Color(119, 136, 153));
				MenuLateral.setBorder(transparent9px);
				MenuLateral.setLayout(new GridLayout(7, 1, 2, 2));
				
				//Boutons d'accès du menu latéral
				JButton btnAcceuil = new JButton("<html><p style=\"font-size:20px\">Accueil</p></html>");
				btnAcceuil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueVente.dispose();
						new AcceuilView();
					}
				});
				MenuLateral.add(btnAcceuil);
				
				JButton btnVente = new JButton("<html><p style=\"font-size:20px\">Vente</p></html>");
				btnVente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueVente.dispose();
						new VenteView();
					}
				});
				MenuLateral.add(btnVente);
				
				JButton btnProduits = new JButton("<html><p style=\"font-size:20px\">Paramétrage produits</p></html>");
				btnProduits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueVente.dispose();
						new ParametrageView();							
					}
				});
				MenuLateral.add(btnProduits);
				
				JButton btnCaisse = new JButton("<html><p style=\"font-size:20px\">Fonds de caisse</p></html>");
				btnCaisse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueVente.dispose();
						new FondDeCaisseView();	
					}
				});
				MenuLateral.add(btnCaisse);
				
				JButton btnSecurite = new JButton("<html><p style=\"font-size:20px\">Mise en sécurité</p></html>");
				btnSecurite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueVente.dispose();
						new MiseEnSecuriteView();	
					}
				});
				MenuLateral.add(btnSecurite);
				
				JButton btnRapports = new JButton("<html><p style=\"font-size:20px\">Rapports</p></html>");
				btnRapports.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueVente.dispose();
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
						vueVente.dispose();
					}
				});
				MenuLateral.add(btnClose);
				
			//Panneau des boutons pour introduire
				JPanel Boutons = new JPanel();
				AffichagePrincipalVente.add(Boutons);
				Boutons.setPreferredSize(new Dimension(550, 617));
				Boutons.setSize(new Dimension(550, 617));
				Boutons.setBackground(new Color(61, 72, 73));
				Boutons.setBorder(transparent9px);
				Boutons.setLayout(new GridLayout(6, 6, 4, 4));
				//Première ligne 
				JButton btn11 = new JButton();
				btn11.setName("btn11");
				setParametre(btn11);
				Boutons.add(btn11);
				btn11.addActionListener(new VenteController(btn11, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn12 = new JButton();
				btn12.setName("btn12");
				setParametre(btn12);
				Boutons.add(btn12);
				btn12.addActionListener(new VenteController(btn12, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn13 = new JButton();
				btn13.setName("btn13");
				setParametre(btn13);
				Boutons.add(btn13);
				btn13.addActionListener(new VenteController(btn13, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn14 = new JButton();
				btn14.setName("btn14");
				setParametre(btn14);
				Boutons.add(btn14);
				btn14.addActionListener(new VenteController(btn14, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn15 = new JButton();
				btn15.setName("btn15");
				setParametre(btn15);
				Boutons.add(btn15);
				btn15.addActionListener(new VenteController(btn15, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn16 = new JButton();
				btn16.setName("btn16");
				setParametre(btn16);
				Boutons.add(btn16);
				btn16.addActionListener(new VenteController(btn16, venteActuelle, modelTable, invalue, outvalue));
			
			//Deuxième ligne
				JButton btn21 = new JButton();
				btn21.setName("btn21");
				setParametre(btn21);
				Boutons.add(btn21);
				btn21.addActionListener(new VenteController(btn21, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn22 = new JButton();
				btn22.setName("btn22");
				setParametre(btn22);
				Boutons.add(btn22);
				btn22.addActionListener(new VenteController(btn22, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn23 = new JButton();
				btn23.setName("btn23");
				setParametre(btn23);
				Boutons.add(btn23);
				btn23.addActionListener(new VenteController(btn23, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn24 = new JButton();
				btn24.setName("btn24");
				setParametre(btn24);
				Boutons.add(btn24);
				btn24.addActionListener(new VenteController(btn24, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn25 = new JButton();
				btn25.setName("btn25");
				setParametre(btn25);
				Boutons.add(btn25);
				btn25.addActionListener(new VenteController(btn25, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn26 = new JButton();
				btn26.setName("btn26");
				setParametre(btn26);
				Boutons.add(btn26);
				btn26.addActionListener(new VenteController(btn26, venteActuelle, modelTable, invalue, outvalue));
				
			//Troisième ligne
				JButton btn31 = new JButton();
				btn31.setName("btn31");
				setParametre(btn31);
				Boutons.add(btn31);
				btn31.addActionListener(new VenteController(btn31, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn32 = new JButton();
				btn32.setName("btn32");
				setParametre(btn32);
				Boutons.add(btn32);
				btn32.addActionListener(new VenteController(btn32, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn33 = new JButton();
				btn33.setName("btn33");
				setParametre(btn33);
				Boutons.add(btn33);
				btn33.addActionListener(new VenteController(btn33, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn34 = new JButton();
				btn34.setName("btn34");
				setParametre(btn34);
				Boutons.add(btn34);
				btn34.addActionListener(new VenteController(btn34, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn35 = new JButton();
				btn35.setName("btn35");
				setParametre(btn35);
				Boutons.add(btn35);
				btn35.addActionListener(new VenteController(btn35, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn36 = new JButton();
				btn36.setName("btn36");
				setParametre(btn36);
				Boutons.add(btn36);
				btn36.addActionListener(new VenteController(btn36, venteActuelle, modelTable, invalue, outvalue));
				
			//Quatrième ligne
				JButton btn41 = new JButton();
				btn41.setName("btn41");
				setParametre(btn41);
				Boutons.add(btn41);
				btn41.addActionListener(new VenteController(btn41, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn42 = new JButton();
				btn42.setName("btn42");
				setParametre(btn42);
				Boutons.add(btn42);
				btn42.addActionListener(new VenteController(btn42, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn43 = new JButton();
				btn43.setName("btn43");
				setParametre(btn43);
				Boutons.add(btn43);
				btn43.addActionListener(new VenteController(btn43, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn44 = new JButton();
				btn44.setName("btn44");
				setParametre(btn44);
				Boutons.add(btn44);
				btn44.addActionListener(new VenteController(btn44, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn45 = new JButton();
				btn45.setName("btn45");
				setParametre(btn45);
				Boutons.add(btn45);
				btn45.addActionListener(new VenteController(btn45, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn46 = new JButton();
				btn46.setName("btn46");
				setParametre(btn46);
				Boutons.add(btn46);
				btn46.addActionListener(new VenteController(btn46, venteActuelle, modelTable, invalue, outvalue));
				
			//Cinquième ligne
				JButton btn51 = new JButton();
				btn51.setName("btn51");
				setParametre(btn51);
				Boutons.add(btn51);
				btn51.addActionListener(new VenteController(btn51, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn52 = new JButton();
				btn52.setName("btn52");
				setParametre(btn52);
				Boutons.add(btn52);
				btn52.addActionListener(new VenteController(btn52, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn53 = new JButton();
				btn53.setName("btn53");
				setParametre(btn53);
				Boutons.add(btn53);
				btn53.addActionListener(new VenteController(btn53, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn54 = new JButton();
				btn54.setName("btn54");
				setParametre(btn54);
				Boutons.add(btn54);
				btn54.addActionListener(new VenteController(btn54, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn55 = new JButton();
				btn55.setName("btn55");
				setParametre(btn55);
				Boutons.add(btn55);
				btn55.addActionListener(new VenteController(btn55, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn56 = new JButton();
				btn56.setName("btn56");
				setParametre(btn56);
				Boutons.add(btn56);
				btn56.addActionListener(new VenteController(btn56, venteActuelle, modelTable, invalue, outvalue));
				
			//Sixième ligne
				JButton btn61 = new JButton();
				btn61.setName("btn61");
				setParametre(btn61);
				Boutons.add(btn61);
				btn61.addActionListener(new VenteController(btn61, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn62 = new JButton();
				btn62.setName("btn62");
				setParametre(btn62);
				Boutons.add(btn62);
				btn62.addActionListener(new VenteController(btn62, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn63 = new JButton();
				btn63.setName("btn63");
				setParametre(btn63);
				Boutons.add(btn63);
				btn63.addActionListener(new VenteController(btn63, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn64 = new JButton();
				btn64.setName("btn64");
				setParametre(btn64);
				Boutons.add(btn64);
				btn64.addActionListener(new VenteController(btn64, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn65 = new JButton();
				btn65.setName("btn65");
				setParametre(btn65);
				Boutons.add(btn65);
				btn65.addActionListener(new VenteController(btn65, venteActuelle, modelTable, invalue, outvalue));
				
				JButton btn66 = new JButton();
				btn66.setName("btn66");
				setParametre(btn66);
				Boutons.add(btn66);
				btn66.addActionListener(new VenteController(btn66, venteActuelle, modelTable, invalue, outvalue));

	
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalVente.add(Resume);
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
				
				//Affichage du résumé de la commande
					resumeCommande = new JTable(modelTable);
					resumeCommande.setRowHeight(18);
					resumeCommande.setFont(new Font("Verdana", Font.PLAIN, 17));
					Resume.add(resumeCommande);
				
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
						pave7.addActionListener(new VenteController(pave7, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave8 = new JButton("<html><p style=\"font-size:20px\">8</p></html>");
						pave8.setName("pave8");
						paveNumerique.add(pave8);
						pave8.addActionListener(new VenteController(pave8, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave9 = new JButton("<html><p style=\"font-size:20px\">9</p></html>");
						pave9.setName("pave9");
						paveNumerique.add(pave9);
						pave9.addActionListener(new VenteController(pave9, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave4 = new JButton("<html><p style=\"font-size:20px\">4</p></html>");
						pave4.setName("pave4");
						paveNumerique.add(pave4);
						pave4.addActionListener(new VenteController(pave4, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave5 = new JButton("<html><p style=\"font-size:20px\">5</p></html>");
						pave5.setName("pave5");
						paveNumerique.add(pave5);
						pave5.addActionListener(new VenteController(pave5, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave6 = new JButton("<html><p style=\"font-size:20px\">6</p></html>");
						pave6.setName("pave6");
						paveNumerique.add(pave6);
						pave6.addActionListener(new VenteController(pave6, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave1 = new JButton("<html><p style=\"font-size:20px\">1</p></html>");
						pave1.setName("pave1");
						paveNumerique.add(pave1);
						pave1.addActionListener(new VenteController(pave1, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave2 = new JButton("<html><p style=\"font-size:20px\">2</p></html>");
						pave2.setName("pave2");
						paveNumerique.add(pave2);
						pave2.addActionListener(new VenteController(pave2, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave3 = new JButton("<html><p style=\"font-size:20px\">3</p></html>");
						pave3.setName("pave3");
						paveNumerique.add(pave3);
						pave3.addActionListener(new VenteController(pave3, venteActuelle, modelTable, invalue, outvalue));
						
						JButton paveVide = new JButton("<html><p style=\"font-size:20px\">-1</p></html>");
						paveVide.setName("moins");
						paveNumerique.add(paveVide);
						paveVide.addActionListener(new VenteController(paveVide, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave0 = new JButton("<html><p style=\"font-size:20px\">0</p></html>");
						pave0.setName("pave0");
						paveNumerique.add(pave0);
						pave0.addActionListener(new VenteController(pave0, venteActuelle, modelTable, invalue, outvalue));
						
						JButton pave = new JButton();
						pave.setName("rendu");
						
						JPanel rendu = new JPanel();
						paveNumerique.add(rendu);
						rendu.setLayout(new GridLayout(4, 1, 0, 0));
							JTextField in = new JTextField("IN");
							in.setHorizontalAlignment(JTextField.CENTER);
							in.setEditable(false);
							in.setFont(new Font("Verdana", Font.PLAIN, 17));
							rendu.add(in);
							invalue = new JTextField();
							invalue.setHorizontalAlignment(JTextField.CENTER);
							invalue.setFont(new Font("Verdana", Font.PLAIN, 17));
							rendu.add(invalue);
							JTextField out = new JTextField("OUT");
							out.setHorizontalAlignment(JTextField.CENTER);
							out.setFont(new Font("Verdana", Font.PLAIN, 17));
							out.setEditable(false);
							rendu.add(out);
							outvalue = new JTextField("");
							outvalue.setHorizontalAlignment(JTextField.CENTER);
							outvalue.setEditable(false);
							outvalue.setFont(new Font("Verdana", Font.PLAIN, 17));
							rendu.add(outvalue);
							invalue.addActionListener(new VenteController(pave, venteActuelle, modelTable, invalue, outvalue));
					
					//Panneau de validation
						JPanel validation = new JPanel();
						encodageArgent.add(validation);
						validation.setLayout(new GridLayout(3, 1, 0, 0));
						
						JButton validationVrai = new JButton("<html><p style=\"font-size:20px\">Valider</p></html>");
						validationVrai.setName("validationVrai");
						validation.add(validationVrai);
						validationVrai.addActionListener(new VenteController(validationVrai, venteActuelle, modelTable, invalue, outvalue));
						
						JButton validationFaux = new JButton("<html><p style=\"font-size:20px\">Annuler</p></html>");
						validationFaux.setName("validationFaux");
						validation.add(validationFaux);
						validationFaux.addActionListener(new VenteController(validationFaux, venteActuelle, modelTable, invalue, outvalue));
						
						JButton rapport = new JButton("<html><p style=\"font-size:20px\">Export PDF</p></html>");
						rapport.setName("rapport");
						validation.add(rapport);
						rapport.addActionListener(new VenteController(rapport, venteActuelle, modelTable, invalue, outvalue));
	}
	
	/**
	 * Cette fonction va attribuer les paramètres stockés en mémoire aux bouttons correspondants
	 * @param btn Le boutton a parametrer
	 */
	private void setParametre(JButton btn) {
		int id = Integer.parseInt(btn.getName().substring(3, 5));
		for(Parametrage p : liste) {
			if(p.getNumeroBoutton()==id) {
				btn.setText("<html><center><p style=\"font-size:13px\">" + p.getDescription() + "<br>" + p.getPrix() + "0€</p></center></html>");
				btn.setBackground(new Color(p.getCouleurR(), p.getCouleurG(), p.getCouleurB()));
				if(!p.isVisible()) {
					setInvisible(btn);
				}
			}
		}
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
