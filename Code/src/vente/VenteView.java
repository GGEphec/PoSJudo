package vente;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import fondDeCaisse.FondDeCaisseView;
import miseEnSecurite.MiseEnSecuriteController;
import miseEnSecurite.MiseEnSecuriteView;
import parametrage.ParametrageView;
import rapports.RapportsView;
import vente.Vente;

public class VenteView {

	JFrame vueVente;
	JTable resumeCommande;
	DefaultTableModel modelTable = new DefaultTableModel(0,4);


	private void setInvisible(JButton btn) {
		btn.setOpaque(false);
		btn.setVisible(false);
		btn.setBorderPainted(false);
	}

	/**
	 * Create the view of Vente
	 */
	public VenteView() {
	//Création modele
		Vente venteActuelle = new Vente();
		
	//Création graphique
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		CompoundBorder bordure = new CompoundBorder(noir1px, transparent9px);
		
		vueVente = new JFrame();
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
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Vente");
		vueVente.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalVente = new JPanel();
		vueVente.getContentPane().add(AffichagePrincipalVente, BorderLayout.CENTER);
		AffichagePrincipalVente.setLayout(new BoxLayout(AffichagePrincipalVente, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalVente.add(MenuLateral);
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
						vueVente.dispose();
						new AcceuilView();
					}
				});
				MenuLateral.add(btnAcceuil);
				
				JButton btnVente = new JButton("Vente");
				btnVente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de vente
						vueVente.dispose();
						new VenteView();
					}
				});
				MenuLateral.add(btnVente);
				
				JButton btnProduits = new JButton("Produits");
				btnProduits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de paramétrage
						vueVente.dispose();
						new ParametrageView();							
					}
				});
				MenuLateral.add(btnProduits);
				
				JButton btnCaisse = new JButton("Caisse");
				btnCaisse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de fond de caisse
						vueVente.dispose();
						new FondDeCaisseView();	
					}
				});
				MenuLateral.add(btnCaisse);
				
				JButton btnSecurite = new JButton("Sécurité");
				btnSecurite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de mise en securite
						vueVente.dispose();
						new MiseEnSecuriteView();	
					}
				});
				MenuLateral.add(btnSecurite);
				
				JButton btnRapports = new JButton("Rapports");
				btnRapports.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO va sur la vue de rapports
						vueVente.dispose();
						new RapportsView();	
					}
				});
				MenuLateral.add(btnRapports);
				
			//Panneau des boutons pour introduire
				JPanel Boutons = new JPanel();
				AffichagePrincipalVente.add(Boutons);
				//Boutons.setMinimumSize(new Dimension(53, 94));
				//Boutons.setMaximumSize(new Dimension(94, 562));
				Boutons.setPreferredSize(new Dimension(550, 617));
				Boutons.setSize(new Dimension(550, 617));
				Boutons.setBackground(new Color(61, 72, 73));
				Boutons.setBorder(transparent9px);
				Boutons.setLayout(new GridLayout(6, 6, 0, 0));
			//Première ligne 
				JButton btn11 = new JButton("<html><center>Ticket rouge <br> 1,50€ </center></html>");
				btn11.setBackground(new Color(255, 0 ,0));
				btn11.setName("btn11");
				Boutons.add(btn11);
				btn11.addActionListener(new VenteController(btn11, venteActuelle, modelTable, resumeCommande));
				
				JButton btn12 = new JButton("<html><center>Eau plate <br> 1,50€ </center></html>");
				btn12.setBackground(new Color(255, 0 ,0));
				btn12.setName("btn12");
				Boutons.add(btn12);
				btn12.addActionListener(new VenteController(btn12, venteActuelle, modelTable, resumeCommande));
				
				JButton btn13 = new JButton("<html><center> Eau pétillante <br> 1,50€ </hmtl>");
				btn13.setBackground(new Color(255, 0 ,0));
				btn13.setName("btn13");
				Boutons.add(btn13);
				btn13.addActionListener(new VenteController(btn13, venteActuelle, modelTable, resumeCommande));
				
				JButton btn14 = new JButton("<html><center> Coca cola <br> 1,50€ </center></html>");
				btn14.setBackground(new Color(255, 0 ,0));
				btn14.setName("btn14");
				Boutons.add(btn14);
				btn14.addActionListener(new VenteController(btn14, venteActuelle, modelTable, resumeCommande));
				
				JButton btn15 = new JButton("<html><center> Coca light <br> 1,50€ </center></html>");
				btn15.setBackground(new Color(255, 0 ,0));
				btn15.setName("btn15");
				Boutons.add(btn15);
				btn15.addActionListener(new VenteController(btn15, venteActuelle, modelTable, resumeCommande));
				
				JButton btn16 = new JButton("<html><center> Limonade <br> 1,50€ </center></html>");
				btn16.setBackground(new Color(255, 0 ,0));
				btn16.setName("btn16");
				Boutons.add(btn16);
				btn16.addActionListener(new VenteController(btn16, venteActuelle, modelTable, resumeCommande));
			
			//Deuxième ligne
				JButton btn21 = new JButton("New button");
				setInvisible(btn21);
				btn21.setName("btn21");
				Boutons.add(btn21);
				btn21.addActionListener(new VenteController(btn21, venteActuelle, modelTable, resumeCommande));
				
				JButton btn22 = new JButton("<html><center> Ice Tea <br> 2,00€ </center></html>");
				btn22.setBackground(new Color(8, 96, 168));
				btn22.setName("btn22");
				Boutons.add(btn22);
				btn22.addActionListener(new VenteController(btn22, venteActuelle, modelTable, resumeCommande));
				
				JButton btn23 = new JButton("New button");
				setInvisible(btn23);
				btn23.setName("btn23");
				Boutons.add(btn23);
				btn23.addActionListener(new VenteController(btn23, venteActuelle, modelTable, resumeCommande));
				
				JButton btn24 = new JButton("New button");
				setInvisible(btn24);
				btn24.setName("btn24");
				Boutons.add(btn24);
				btn24.addActionListener(new VenteController(btn24, venteActuelle, modelTable, resumeCommande));
				
				JButton btn25 = new JButton("New button");
				setInvisible(btn25);
				btn25.setName("btn25");
				Boutons.add(btn25);
				btn25.addActionListener(new VenteController(btn25, venteActuelle, modelTable, resumeCommande));
				
				JButton btn26 = new JButton("<html><center> Jus de fruit <br> 1,50€ </center></html>");
				btn26.setBackground(new Color(255, 0 ,0));
				btn26.setName("btn26");
				Boutons.add(btn26);
				btn26.addActionListener(new VenteController(btn26, venteActuelle, modelTable, resumeCommande));
				
			//Troisième ligne
				JButton btn31 = new JButton("<html><center> Ticket bleu <br> 2,00€ </center></html>");
				btn31.setBackground(new Color(8, 96, 168));
				btn31.setName("btn31");
				Boutons.add(btn31);
				btn31.addActionListener(new VenteController(btn31, venteActuelle, modelTable, resumeCommande));
				
				JButton btn32 = new JButton("<html><center> Kriek <br> 2,00€ </center></html>");
				btn32.setBackground(new Color(8, 96, 168));
				btn32.setName("btn32");
				Boutons.add(btn32);
				btn32.addActionListener(new VenteController(btn32, venteActuelle, modelTable, resumeCommande));
				
				JButton btn33 = new JButton("<html><center> Blanche <br> 2,00€ </center></html>");
				btn33.setBackground(new Color(8, 96, 168));
				btn33.setName("btn33");
				Boutons.add(btn33);
				btn33.addActionListener(new VenteController(btn33, venteActuelle, modelTable, resumeCommande));
				
				JButton btn34 = new JButton("<html><center> Verre de vin <br> 2,00€ </center></html>");
				btn34.setBackground(new Color(8, 96, 168));
				btn34.setName("btn34");
				Boutons.add(btn34);
				btn34.addActionListener(new VenteController(btn34, venteActuelle, modelTable, resumeCommande));
				
				JButton btn35 = new JButton("<html><center> Pils <br> 1,50€ </center></html>");
				btn35.setBackground(new Color(255, 0 ,0));
				btn35.setName("btn35");
				Boutons.add(btn35);
				btn35.addActionListener(new VenteController(btn35, venteActuelle, modelTable, resumeCommande));
				
				JButton btn36 = new JButton("<html><center> Gouyasse <br> 2,50€ </center></html>");
				btn36.setBackground(new Color(255, 255 ,0));
				btn36.setName("btn36");
				Boutons.add(btn36);
				btn36.addActionListener(new VenteController(btn36, venteActuelle, modelTable, resumeCommande));
				
			//Quatrième ligne
				JButton btn41 = new JButton("<html><center> Ticket orange <br> 3,00€ </center></html>");
				btn41.setBackground(new Color(255, 131 ,0));
				btn41.setName("btn41");
				Boutons.add(btn41);
				btn41.addActionListener(new VenteController(btn41, venteActuelle, modelTable, resumeCommande));
				
				JButton btn42 = new JButton("<html><center> Chimay bleue <br> 3,00€ </center></html>");
				btn42.setBackground(new Color(255, 131 ,0));
				btn42.setName("btn42");
				Boutons.add(btn42);
				btn42.addActionListener(new VenteController(btn42, venteActuelle, modelTable, resumeCommande));
				
				JButton btn43 = new JButton("New button");
				setInvisible(btn43);
				btn43.setName("btn43");
				Boutons.add(btn43);
				btn43.addActionListener(new VenteController(btn43, venteActuelle, modelTable, resumeCommande));
				
				JButton btn44 = new JButton("New button");
				setInvisible(btn44);
				btn44.setName("btn44");
				Boutons.add(btn44);
				btn44.addActionListener(new VenteController(btn44, venteActuelle, modelTable, resumeCommande));
				
				JButton btn45 = new JButton("New button");
				setInvisible(btn45);
				btn45.setName("btn45");
				Boutons.add(btn45);
				btn45.addActionListener(new VenteController(btn45, venteActuelle, modelTable, resumeCommande));
				
				JButton btn46 = new JButton("New button");
				setInvisible(btn46);
				btn46.setName("btn46");
				Boutons.add(btn46);
				btn46.addActionListener(new VenteController(btn46, venteActuelle, modelTable, resumeCommande));
				
			//Cinquième ligne
				JButton btn51 = new JButton("<html><center> Ticket jaune <br> 2,50€ </center></html>");
				btn51.setBackground(new Color(255, 255 ,0));
				btn51.setName("btn51");
				Boutons.add(btn51);
				btn51.addActionListener(new VenteController(btn51, venteActuelle, modelTable, resumeCommande));
				
				JButton btn52 = new JButton("<html><center> Petit déjeuner <br> 2,50€ </center></html>");
				btn52.setBackground(new Color(255, 255 ,0));
				btn52.setName("btn52");
				Boutons.add(btn52);
				btn52.addActionListener(new VenteController(btn52, venteActuelle, modelTable, resumeCommande));
				
				JButton btn53 = new JButton("<html><center> Sandwich <br> 2,50€ </center></html>");
				btn53.setBackground(new Color(255, 255 ,0));
				btn53.setName("btn53");
				Boutons.add(btn53);
				btn53.addActionListener(new VenteController(btn53, venteActuelle, modelTable, resumeCommande));
				
				JButton btn54 = new JButton("<html><center> Hot Dog <br> 2,50€ </center></html>");
				btn54.setBackground(new Color(255, 255 ,0));
				btn54.setName("btn54");
				Boutons.add(btn54);
				btn54.addActionListener(new VenteController(btn54, venteActuelle, modelTable, resumeCommande));
				
				JButton btn55 = new JButton("New button");
				setInvisible(btn55);
				btn55.setName("btn55");
				Boutons.add(btn55);
				btn55.addActionListener(new VenteController(btn55, venteActuelle, modelTable, resumeCommande));
				
				JButton btn56 = new JButton("New button");
				setInvisible(btn56);
				btn56.setName("btn56");
				Boutons.add(btn56);
				btn56.addActionListener(new VenteController(btn56, venteActuelle, modelTable, resumeCommande));
				
			//Sixième ligne
				JButton btn61 = new JButton("New button");
				setInvisible(btn61);
				btn61.setName("btn61");
				Boutons.add(btn61);
				btn61.addActionListener(new VenteController(btn61, venteActuelle, modelTable, resumeCommande));
				
				JButton btn62 = new JButton("<html><center> Café <br> 1,50€ </center></html>");
				btn62.setBackground(new Color(255, 0 ,0));
				btn62.setName("btn62");
				Boutons.add(btn62);
				btn62.addActionListener(new VenteController(btn62, venteActuelle, modelTable, resumeCommande));
				
				JButton btn63 = new JButton("<html><center> Chocolat chaud <br> 1,50€ </center></html>");
				btn63.setBackground(new Color(255, 0 ,0));
				btn63.setName("btn63");
				Boutons.add(btn63);
				btn63.addActionListener(new VenteController(btn63, venteActuelle, modelTable, resumeCommande));
				
				JButton btn64 = new JButton("<html><center> Couque <br> 1,50€ </center></html>");
				btn64.setBackground(new Color(255, 0 ,0));
				btn64.setName("btn64");
				Boutons.add(btn64);
				btn64.addActionListener(new VenteController(btn64, venteActuelle, modelTable, resumeCommande));
				
				JButton btn65 = new JButton("<html><center> Chips <br> 1,50€ </center></html>");
				btn65.setBackground(new Color(255, 0 ,0));
				btn65.setName("btn65");
				Boutons.add(btn65);
				btn65.addActionListener(new VenteController(btn65, venteActuelle, modelTable, resumeCommande));
				
				JButton btn66 = new JButton("<html><center> Bonbon <br> 1,50€ </center></html>");
				btn66.setBackground(new Color(255, 0 ,0));
				btn66.setName("btn66");
				Boutons.add(btn66);
				btn66.addActionListener(new VenteController(btn66, venteActuelle, modelTable, resumeCommande));

	
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalVente.add(Resume);
				//Resume.setMinimumSize(new Dimension(53, 94));
				//Resume.setMaximumSize(new Dimension(112, 562));
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
				
				//Affichage du résumé de la commande
//					String[] item = {"Nbre", "Produit", "prix", "total"};
//					modelTable.addRow(item);
					resumeCommande = new JTable(modelTable);
					//resumeCommande.repaint();
					Resume.add(resumeCommande);
				
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
						pave7.addActionListener(new VenteController(pave7, venteActuelle, modelTable, resumeCommande));
						
						JButton pave8 = new JButton("8");
						pave8.setName("pave8");
						paveNumerique.add(pave8);
						pave8.addActionListener(new VenteController(pave8, venteActuelle, modelTable, resumeCommande));
						
						JButton pave9 = new JButton("9");
						pave9.setName("pave9");
						paveNumerique.add(pave9);
						pave9.addActionListener(new VenteController(pave9, venteActuelle, modelTable, resumeCommande));
						
						JButton pave4 = new JButton("4");
						pave4.setName("pave4");
						paveNumerique.add(pave4);
						pave4.addActionListener(new VenteController(pave4, venteActuelle, modelTable, resumeCommande));
						
						JButton pave5 = new JButton("5");
						pave5.setName("pave5");
						paveNumerique.add(pave5);
						pave5.addActionListener(new VenteController(pave5, venteActuelle, modelTable, resumeCommande));
						
						JButton pave6 = new JButton("6");
						pave6.setName("pave6");
						paveNumerique.add(pave6);
						pave6.addActionListener(new VenteController(pave6, venteActuelle, modelTable, resumeCommande));
						
						JButton pave1 = new JButton("1");
						pave1.setName("pave1");
						paveNumerique.add(pave1);
						pave1.addActionListener(new VenteController(pave1, venteActuelle, modelTable, resumeCommande));
						
						JButton pave2 = new JButton("2");
						pave2.setName("pave2");
						paveNumerique.add(pave2);
						pave2.addActionListener(new VenteController(pave2, venteActuelle, modelTable, resumeCommande));
						
						JButton pave3 = new JButton("3");
						pave3.setName("pave3");
						paveNumerique.add(pave3);
						pave3.addActionListener(new VenteController(pave3, venteActuelle, modelTable, resumeCommande));
						
						JButton paveVide = new JButton("");
						setInvisible(paveVide);
						paveNumerique.add(paveVide);
						
						JButton pave0 = new JButton("0");
						pave0.setName("pave0");
						paveNumerique.add(pave0);
						pave0.addActionListener(new VenteController(pave0, venteActuelle, modelTable, resumeCommande));
						
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
						validationVrai.addActionListener(new VenteController(validationVrai, venteActuelle, modelTable, resumeCommande));
						
						JButton validationFaux = new JButton("Annuler");
						validationFaux.setName("validationFaux");
						validation.add(validationFaux);
						validationFaux.addActionListener(new VenteController(validationFaux, venteActuelle, modelTable, resumeCommande));
					
		
	}

}
