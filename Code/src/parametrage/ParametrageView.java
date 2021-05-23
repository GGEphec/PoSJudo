/**Cette classe va créer la vue parametrage avec les éléments qui permettent d'interragir avec celui-ci.
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package parametrage;

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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import acceuil.AcceuilView;
import acceuil.DBHelper;
import fondDeCaisse.FondDeCaisseView;
import miseEnSecurite.MiseEnSecuriteView;
import rapports.RapportsView;
import vente.VenteView;

public class ParametrageView {
//Variables d'instance
	JFrame vueParametrage;
	private JTextField[] param = new JTextField[14];
	private List<Parametrage> liste;

	/**
	 * Création de la vue paramétrage
	 */
	public ParametrageView() {
		liste=DBHelper.getProduits();
		
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(105, 105, 105), 5);
		new CompoundBorder(noir1px, transparent9px);
		
		vueParametrage = new JFrame();
		vueParametrage.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		TitreVue.setEditable(false);
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Paramétrages produits						Somme en caisse : " + DBHelper.getTotal() + "€");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		TitreVue.setFont(font);
		TitreVue.setHorizontalAlignment(JTextField.CENTER);
		vueParametrage.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalParametrage = new JPanel();
		vueParametrage.getContentPane().add(AffichagePrincipalParametrage, BorderLayout.CENTER);
		AffichagePrincipalParametrage.setLayout(new BoxLayout(AffichagePrincipalParametrage, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalParametrage.add(MenuLateral);
				MenuLateral.setSize(new Dimension(90, 617));
				MenuLateral.setBackground(new Color(119, 136, 153));
				MenuLateral.setBorder(transparent9px);
				MenuLateral.setLayout(new GridLayout(7, 1, 4, 4));
				
				//Boutons d'accès du menu latéral
				JButton btnAcceuil = new JButton("<html><p style=\"font-size:20px\">Accueil</p></html>");
				btnAcceuil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new AcceuilView();
					}
				});
				MenuLateral.add(btnAcceuil);
				
				JButton btnVente = new JButton("<html><p style=\"font-size:20px\">Vente</p></html>");
				btnVente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new VenteView();
					}
				});
				MenuLateral.add(btnVente);
				
				JButton btnProduits = new JButton("<html><p style=\"font-size:20px\">Paramétrage</p></html>");
				btnProduits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new ParametrageView();							
					}
				});
				MenuLateral.add(btnProduits);
				
				JButton btnCaisse = new JButton("<html><p style=\"font-size:20px\">Fond de caisse</p></html>");
				btnCaisse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new FondDeCaisseView();	
					}
				});
				MenuLateral.add(btnCaisse);
				
				JButton btnSecurite = new JButton("<html><p style=\"font-size:20px\">Mise en sécurité</p></html>");
				btnSecurite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new MiseEnSecuriteView();	
					}
				});
				MenuLateral.add(btnSecurite);
				
				JButton btnRapports = new JButton("<html><p style=\"font-size:20px\">Rapports</p></html>");
				btnRapports.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
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
						vueParametrage.dispose();
					}
				});
				MenuLateral.add(btnClose);
				
			//Panneau des boutons pour introduire
				JPanel Boutons = new JPanel();
				AffichagePrincipalParametrage.add(Boutons);
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
				btn11.addActionListener(new ParametrageController(btn11, param));
				
				JButton btn12 = new JButton();
				btn12.setName("btn12");
				setParametre(btn12);
				Boutons.add(btn12);
				btn12.addActionListener(new ParametrageController(btn12, param));
				
				JButton btn13 = new JButton();
				btn13.setName("btn13");
				setParametre(btn13);
				Boutons.add(btn13);
				btn13.addActionListener(new ParametrageController(btn13, param));
				
				JButton btn14 = new JButton();
				btn14.setName("btn14");
				setParametre(btn14);
				Boutons.add(btn14);
				btn14.addActionListener(new ParametrageController(btn14, param));
				
				JButton btn15 = new JButton();
				btn15.setName("btn15");
				setParametre(btn15);
				Boutons.add(btn15);
				btn15.addActionListener(new ParametrageController(btn15, param));
				
				JButton btn16 = new JButton();
				btn16.setName("btn16");
				setParametre(btn16);
				Boutons.add(btn16);
				btn16.addActionListener(new ParametrageController(btn16, param));
			
			//Deuxième ligne
				JButton btn21 = new JButton();
				btn21.setName("btn21");
				setParametre(btn21);
				Boutons.add(btn21);
				btn21.addActionListener(new ParametrageController(btn21, param));
				
				JButton btn22 = new JButton();
				btn22.setName("btn22");
				setParametre(btn22);
				Boutons.add(btn22);
				btn22.addActionListener(new ParametrageController(btn22, param));
				
				JButton btn23 = new JButton();
				btn23.setName("btn23");
				setParametre(btn23);
				Boutons.add(btn23);
				btn23.addActionListener(new ParametrageController(btn23, param));
				
				JButton btn24 = new JButton();
				btn24.setName("btn24");
				setParametre(btn24);
				Boutons.add(btn24);
				btn24.addActionListener(new ParametrageController(btn24, param));
				
				JButton btn25 = new JButton();
				btn25.setName("btn25");
				setParametre(btn25);
				Boutons.add(btn25);
				btn25.addActionListener(new ParametrageController(btn25, param));
				
				JButton btn26 = new JButton();
				btn26.setName("btn26");
				setParametre(btn26);
				Boutons.add(btn26);
				btn26.addActionListener(new ParametrageController(btn26, param));
				
			//Troisième ligne
				JButton btn31 = new JButton();
				btn31.setName("btn31");
				setParametre(btn31);
				Boutons.add(btn31);
				btn31.addActionListener(new ParametrageController(btn31, param));
				
				JButton btn32 = new JButton();
				btn32.setName("btn32");
				setParametre(btn32);
				Boutons.add(btn32);
				btn32.addActionListener(new ParametrageController(btn32, param));
				
				JButton btn33 = new JButton();
				btn33.setName("btn33");
				setParametre(btn33);
				Boutons.add(btn33);
				btn33.addActionListener(new ParametrageController(btn33, param));
				
				JButton btn34 = new JButton();
				btn34.setName("btn34");
				setParametre(btn34);
				Boutons.add(btn34);
				btn34.addActionListener(new ParametrageController(btn34, param));
				
				JButton btn35 = new JButton();
				btn35.setName("btn35");
				setParametre(btn35);
				Boutons.add(btn35);
				btn35.addActionListener(new ParametrageController(btn35, param));
				
				JButton btn36 = new JButton();
				btn36.setName("btn36");
				setParametre(btn36);
				Boutons.add(btn36);
				btn36.addActionListener(new ParametrageController(btn36, param));
				
			//Quatrième ligne
				JButton btn41 = new JButton();
				btn41.setName("btn41");
				setParametre(btn41);
				Boutons.add(btn41);
				btn41.addActionListener(new ParametrageController(btn41, param));
				
				JButton btn42 = new JButton();
				btn42.setName("btn42");
				setParametre(btn42);
				Boutons.add(btn42);
				btn42.addActionListener(new ParametrageController(btn42, param));
				
				JButton btn43 = new JButton();
				btn43.setName("btn43");
				setParametre(btn43);
				Boutons.add(btn43);
				btn43.addActionListener(new ParametrageController(btn43, param));
				
				JButton btn44 = new JButton();
				btn44.setName("btn44");
				setParametre(btn44);
				Boutons.add(btn44);
				btn44.addActionListener(new ParametrageController(btn44, param));
				
				JButton btn45 = new JButton();
				btn45.setName("btn45");
				setParametre(btn45);
				Boutons.add(btn45);
				btn45.addActionListener(new ParametrageController(btn45, param));
				
				JButton btn46 = new JButton();
				btn46.setName("btn46");
				setParametre(btn46);
				Boutons.add(btn46);
				btn46.addActionListener(new ParametrageController(btn46, param));
				
			//Cinquième ligne
				JButton btn51 = new JButton();
				btn51.setName("btn51");
				setParametre(btn51);
				Boutons.add(btn51);
				btn51.addActionListener(new ParametrageController(btn51, param));
				
				JButton btn52 = new JButton();
				btn52.setName("btn52");
				setParametre(btn52);
				Boutons.add(btn52);
				btn52.addActionListener(new ParametrageController(btn52, param));
				
				JButton btn53 = new JButton();
				btn53.setName("btn53");
				setParametre(btn53);
				Boutons.add(btn53);
				btn53.addActionListener(new ParametrageController(btn53, param));
				
				JButton btn54 = new JButton();
				btn54.setName("btn54");
				setParametre(btn54);
				Boutons.add(btn54);
				btn54.addActionListener(new ParametrageController(btn54, param));
				
				JButton btn55 = new JButton();
				btn55.setName("btn55");
				setParametre(btn55);
				Boutons.add(btn55);
				btn55.addActionListener(new ParametrageController(btn55, param));
				
				JButton btn56 = new JButton();
				btn56.setName("btn56");
				setParametre(btn56);
				Boutons.add(btn56);
				btn56.addActionListener(new ParametrageController(btn56, param));
				
			//Sixième ligne
				JButton btn61 = new JButton();
				btn61.setName("btn61");
				setParametre(btn61);
				Boutons.add(btn61);
				btn61.addActionListener(new ParametrageController(btn61, param));
				
				JButton btn62 = new JButton();
				btn62.setName("btn62");
				setParametre(btn62);
				Boutons.add(btn62);
				btn62.addActionListener(new ParametrageController(btn62, param));
				
				JButton btn63 = new JButton();
				btn63.setName("btn63");
				setParametre(btn63);
				Boutons.add(btn63);
				btn63.addActionListener(new ParametrageController(btn63, param));
				
				JButton btn64 = new JButton();
				btn64.setName("btn64");
				setParametre(btn64);
				Boutons.add(btn64);
				btn64.addActionListener(new ParametrageController(btn64, param));
				
				JButton btn65 = new JButton();
				btn65.setName("btn65");
				setParametre(btn65);
				Boutons.add(btn65);
				btn65.addActionListener(new ParametrageController(btn65, param));
				
				JButton btn66 = new JButton();
				btn66.setName("btn66");
				setParametre(btn66);
				Boutons.add(btn66);
				btn66.addActionListener(new ParametrageController(btn66, param));
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalParametrage.add(Resume);
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
				
				//JPanel modification parametre
				JPanel parametrage = new JPanel();
				Resume.add(parametrage);
				parametrage.setLayout(new GridLayout(7,2,0,0));
					//ID
					param[0] = new JTextField("  ID du boutton");
					param[0].setEditable(false);
					parametrage.add(param[0]);
					param[1] = new JTextField("");
					param[1].setEditable(false);
					parametrage.add(param[1]);
					//Nom
					param[2]= new JTextField("  Nom du produit");
					param[2].setEditable(false);
					parametrage.add(param[2]);
					param[3] = new JTextField("");
					parametrage.add(param[3]);
					//Prix
					param[4] = new JTextField("  Prix du produit");
					param[4].setEditable(false);
					parametrage.add(param[4]);
					param[5] = new JTextField("");
					parametrage.add(param[5]);
					//CouleurR 
					param[6]= new JTextField("  Composante R de la couleur du boutton");
					param[6].setEditable(false);
					parametrage.add(param[6]);
					param[7] = new JTextField("");
					parametrage.add(param[7]);
					//CouleurG
					param[8] = new JTextField("  Composante G de la couleur du boutton");
					param[8].setEditable(false);
					parametrage.add(param[8]);
					param[9] = new JTextField("");
					parametrage.add(param[9]);
					//CouleurB
					param[10] = new JTextField("  Composante B de la couleur du boutton");
					param[10].setEditable(false);
					parametrage.add(param[10]);
					param[11] = new JTextField("");
					parametrage.add(param[11]);
					//Visible
					param[12] = new JTextField("  Boutton visible ?");
					param[12].setEditable(false);
					parametrage.add(param[12]);
					param[13] = new JTextField("");
					parametrage.add(param[13]);
					Font font2 = new Font("SansSerif", 0, 15);
					for(JTextField a : param) {
						a.setFont(font2);
					}
					
				
				
				
				
				//JPanel valider/annuler
				JPanel validation = new JPanel();
				Resume.add(validation);
				validation.setLayout(new GridLayout(2, 1, 0, 0));
				
				JButton validationVrai = new JButton("<html><p style=\"font-size:20px\">Valider</p></html>");
				validationVrai.setName("validationVrai");
				validation.add(validationVrai);
				validationVrai.addActionListener(new ParametrageController(validationVrai, param));
				
				JButton validationFaux = new JButton("<html><p style=\"font-size:20px\">Annuler</p></html>");
				validationFaux.setName("validationFaux");
				validation.add(validationFaux);
				validationFaux.addActionListener(new ParametrageController(validationFaux, param));
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
		//btn.setVisible(false);
		btn.setBorderPainted(false);
	}

}
