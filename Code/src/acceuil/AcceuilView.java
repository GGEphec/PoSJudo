/**Cette classe va créé la vue Acceuil
 * 
 * @author gaeta_2b6psqs
 * @version 2021-05-21
 */
package acceuil;

import javax.swing.*;
import javax.swing.border.*;
import fondDeCaisse.FondDeCaisseView;
import miseEnSecurite.MiseEnSecuriteView;
import parametrage.ParametrageView;
import rapports.RapportsView;
import vente.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AcceuilView {
	protected JFrame vueAcceuil;

	/**
	 * Création de la vue Acceuil
	 */
	public AcceuilView() {
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		new CompoundBorder(noir1px, transparent9px);
		
		vueAcceuil = new JFrame();
		vueAcceuil.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		vueAcceuil.setSize(new Dimension(1850, 950));
		vueAcceuil.setVisible(true);
		vueAcceuil.getContentPane().setMinimumSize(new Dimension(720, 480));
		vueAcceuil.getContentPane().setMaximumSize(new Dimension(1920, 1080));
		vueAcceuil.getContentPane().setPreferredSize(new Dimension(1280, 720));
		vueAcceuil.getContentPane().setSize(new Dimension(1280, 720));
		vueAcceuil.getContentPane().setName("Acceuil");
		vueAcceuil.getContentPane().setBackground(new Color(64, 64, 64));

		//Titre de la vue
		JTextField TitreVue = new JTextField();
		TitreVue.setEditable(false);
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setName("TitreAcceuil");
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Acceuil						Somme en caisse : " + DBHelper.getTotal() + "€");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		TitreVue.setFont(font);
		TitreVue.setHorizontalAlignment(JTextField.CENTER);
		vueAcceuil.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalAcceuil = new JPanel();
		vueAcceuil.getContentPane().add(AffichagePrincipalAcceuil, BorderLayout.CENTER);
		AffichagePrincipalAcceuil.setLayout(new BoxLayout(AffichagePrincipalAcceuil, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalAcceuil.add(MenuLateral);
				MenuLateral.setSize(new Dimension(90, 617));
				MenuLateral.setBackground(new Color(0, 150, 150));
				MenuLateral.setBorder(transparent9px);
				MenuLateral.setLayout(new GridLayout(7, 1, 0, 0));
				
				//Boutons d'accès du menu latéral
					JButton btnAcceuil = new JButton("Acceuil");
					btnAcceuil.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueAcceuil.dispose();
							new AcceuilView();
						}
					});
					MenuLateral.add(btnAcceuil);
					
					JButton btnVente = new JButton("Vente");
					btnVente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueAcceuil.dispose();
							new VenteView();
						}
					});
					MenuLateral.add(btnVente);
					
					JButton btnProduits = new JButton("Produits");
					btnProduits.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueAcceuil.dispose();
							new ParametrageView();							
						}
					});
					MenuLateral.add(btnProduits);
					
					JButton btnCaisse = new JButton("Caisse");
					btnCaisse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueAcceuil.dispose();
							new FondDeCaisseView();	
						}
					});
					MenuLateral.add(btnCaisse);
					
					JButton btnSecurite = new JButton("Sécurité");
					btnSecurite.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueAcceuil.dispose();
							new MiseEnSecuriteView();	
						}
					});
					MenuLateral.add(btnSecurite);
					
					JButton btnRapports = new JButton("Rapports");
					btnRapports.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vueAcceuil.dispose();
							new RapportsView();	
						}
					});
					MenuLateral.add(btnRapports);
					
					JButton btnClose = new JButton("Quitter");
					btnClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DBHelper.shutdown();
							vueAcceuil.dispose();
						}
					});
					MenuLateral.add(btnClose);
					
			//Panneau principal qui va changer en fonction de la vue
				JPanel info = new JPanel();
				AffichagePrincipalAcceuil.add(info);
	}
}
