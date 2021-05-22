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
	private JFrame vueParametrage;


	/**
	 * Création de la vue paramétrage
	 */
	public ParametrageView() {
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
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
				MenuLateral.setBackground(new Color(0, 150, 150));
				MenuLateral.setBorder(transparent9px);
				MenuLateral.setLayout(new GridLayout(7, 1, 0, 0));
				
				//Boutons d'accès du menu latéral
				JButton btnAcceuil = new JButton("Acceuil");
				btnAcceuil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new AcceuilView();
					}
				});
				MenuLateral.add(btnAcceuil);
				
				JButton btnVente = new JButton("Vente");
				btnVente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new VenteView();
					}
				});
				MenuLateral.add(btnVente);
				
				JButton btnProduits = new JButton("Produits");
				btnProduits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new ParametrageView();							
					}
				});
				MenuLateral.add(btnProduits);
				
				JButton btnCaisse = new JButton("Caisse");
				btnCaisse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new FondDeCaisseView();	
					}
				});
				MenuLateral.add(btnCaisse);
				
				JButton btnSecurite = new JButton("Sécurité");
				btnSecurite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new MiseEnSecuriteView();	
					}
				});
				MenuLateral.add(btnSecurite);
				
				JButton btnRapports = new JButton("Rapports");
				btnRapports.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vueParametrage.dispose();
						new RapportsView();	
					}
				});
				MenuLateral.add(btnRapports);
				
				JButton btnClose = new JButton("Quitter");
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
				Boutons.setBackground(new Color(150, 0, 150));
				Boutons.setBorder(transparent9px);
				Boutons.setLayout(new GridLayout(6, 6, 0, 0));
				//Première ligne
				JButton btn00 = new JButton("<html><center>Ticket rouge <br> 1,50€ </center></html>");
				btn00.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn00);
				
				JButton btn01 = new JButton("<html><center>Eau plate <br> 1,50€ </center></html>");
				btn01.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn01);
				
				JButton btn02 = new JButton("<html><center> Eau pétillante <br> 1,50€ </hmtl>");
				btn02.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn02);
				
				JButton btn03 = new JButton("<html><center> Coca cola <br> 1,50€ </center></html>");
				btn03.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn03);
				
				JButton btn04 = new JButton("<html><center> Coca light <br> 1,50€ </center></html>");
				btn04.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn04);
				
				JButton btn05 = new JButton("<html><center> Limonade <br> 1,50€ </center></html>");
				btn05.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn05);
			
			//Deuxième ligne
				JButton btn10 = new JButton("New button");
				setInvisible(btn10);
				Boutons.add(btn10);
				
				JButton btn11 = new JButton("<html><center> Ice Tea <br> 2,00€ </center></html>");
				btn11.setBackground(new Color(8, 96, 168));
				Boutons.add(btn11);
				
				JButton btn12 = new JButton("New button");
				setInvisible(btn12);
				Boutons.add(btn12);
				
				JButton btn13 = new JButton("New button");
				setInvisible(btn13);
				Boutons.add(btn13);
				
				JButton btn14 = new JButton("New button");
				setInvisible(btn14);
				Boutons.add(btn14);
				
				JButton btn15 = new JButton("<html><center> Jus de fruit <br> 1,50€ </center></html>");
				btn15.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn15);
				
			//Troisième ligne
				JButton btn20 = new JButton("<html><center> Ticket bleu <br> 2,00€ </center></html>");
				btn20.setBackground(new Color(8, 96, 168));
				Boutons.add(btn20);
				
				JButton btn21 = new JButton("<html><center> Kriek <br> 2,00€ </center></html>");
				btn21.setBackground(new Color(8, 96, 168));
				Boutons.add(btn21);
				
				JButton btn22 = new JButton("<html><center> Blanche <br> 2,00€ </center></html>");
				btn22.setBackground(new Color(8, 96, 168));
				Boutons.add(btn22);
				
				JButton btn23 = new JButton("<html><center> Verre de vin <br> 2,00€ </center></html>");
				btn23.setBackground(new Color(8, 96, 168));
				Boutons.add(btn23);
				
				JButton btn24 = new JButton("<html><center> Pils <br> 1,50€ </center></html>");
				btn24.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn24);
				
				JButton btn25 = new JButton("<html><center> Gouyasse <br> 2,50€ </center></html>");
				btn25.setBackground(new Color(255, 255 ,0));
				Boutons.add(btn25);
				
			//Quatrième ligne
				JButton btn30 = new JButton("<html><center> Ticket orange <br> 3,00€ </center></html>");
				btn30.setBackground(new Color(255, 131 ,0));
				Boutons.add(btn30);
				
				JButton btn31 = new JButton("<html><center> Chimay bleue <br> 3,00€ </center></html>");
				btn31.setBackground(new Color(255, 131 ,0));
				Boutons.add(btn31);
				
				JButton btn32 = new JButton("New button");
				setInvisible(btn32);
				Boutons.add(btn32);
				
				JButton btn33 = new JButton("New button");
				setInvisible(btn33);
				Boutons.add(btn33);
				
				JButton btn34 = new JButton("New button");
				setInvisible(btn34);
				Boutons.add(btn34);
				
				JButton btn35 = new JButton("New button");
				setInvisible(btn35);
				Boutons.add(btn35);
				
			//Cinquième ligne
				JButton btn40 = new JButton("<html><center> Ticket jaune <br> 2,50€ </center></html>");
				btn40.setBackground(new Color(255, 255 ,0));
				Boutons.add(btn40);
				
				JButton btn41 = new JButton("<html><center> Petit déjeuner <br> 2,50€ </center></html>");
				btn41.setBackground(new Color(255, 255 ,0));
				Boutons.add(btn41);
				
				JButton btn42 = new JButton("<html><center> Sandwich <br> 2,50€ </center></html>");
				btn42.setBackground(new Color(255, 255 ,0));
				Boutons.add(btn42);
				
				JButton btn43 = new JButton("<html><center> Hot Dog <br> 2,50€ </center></html>");
				btn43.setBackground(new Color(255, 255 ,0));
				Boutons.add(btn43);
				
				JButton btn44 = new JButton("New button");
				setInvisible(btn44);
				Boutons.add(btn44);
				
				JButton btn45 = new JButton("New button");
				setInvisible(btn45);
				Boutons.add(btn45);
				
			//Sixième ligne
				JButton btn50 = new JButton("New button");
				setInvisible(btn50);
				Boutons.add(btn50);
				
				JButton btn51 = new JButton("<html><center> Café <br> 1,50€ </center></html>");
				btn51.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn51);
				
				JButton btn52 = new JButton("<html><center> Chocolat chaud <br> 1,50€ </center></html>");
				btn52.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn52);
				
				JButton btn53 = new JButton("<html><center> Couque <br> 1,50€ </center></html>");
				btn53.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn53);
				
				JButton btn54 = new JButton("<html><center> Chips <br> 1,50€ </center></html>");
				btn54.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn54);
				
				JButton btn55 = new JButton("<html><center> Bonbon <br> 1,50€ </center></html>");
				btn55.setBackground(new Color(255, 0 ,0));
				Boutons.add(btn55);
		
			//Panneau de résumé de ce qui a été introduit
				JPanel Resume = new JPanel();
				AffichagePrincipalParametrage.add(Resume);
				Resume.setPreferredSize(new Dimension(550, 617));
				Resume.setSize(new Dimension(550, 617));
				Resume.setBackground(new Color(150, 150, 0));
				Resume.setBorder(transparent9px);
				Resume.setLayout(new GridLayout(2, 1, 0, 0));
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
