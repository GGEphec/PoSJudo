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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilView window = new AcceuilView();
					window.vueAcceuil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcceuilView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border noir1px = new LineBorder(new Color(0,0,0));
		Border transparent9px = new LineBorder(new Color(250, 250, 10), 9);
		CompoundBorder bordure = new CompoundBorder(noir1px, transparent9px);
		
		vueAcceuil = new JFrame();
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
		//TitreVue.setMinimumSize(new Dimension(718, 50));
		//TitreVue.setMaximumSize(new Dimension(1918, 98));
		TitreVue.setPreferredSize(new Dimension(1258, 70));
		TitreVue.setSize(new Dimension(1258, 70));
		TitreVue.setName("TitreAcceuil");
		TitreVue.setBackground(new Color(250, 250, 250));
		TitreVue.setBorder(transparent9px);
		TitreVue.setText("Acceuil");
		vueAcceuil.getContentPane().add(TitreVue, BorderLayout.NORTH);
		
		//Affichage principal
		JPanel AffichagePrincipalAcceuil = new JPanel();
		vueAcceuil.getContentPane().add(AffichagePrincipalAcceuil, BorderLayout.CENTER);
		AffichagePrincipalAcceuil.setLayout(new BoxLayout(AffichagePrincipalAcceuil, BoxLayout.X_AXIS));
			
			//Panneau du menu latéral commun à toutes les vues
				JPanel MenuLateral = new JPanel();
				AffichagePrincipalAcceuil.add(MenuLateral);
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
							vueAcceuil.dispose();
							AcceuilView av = new AcceuilView();
						}
					});
					MenuLateral.add(btnAcceuil);
					
					JButton btnVente = new JButton("Vente");
					btnVente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de vente
							vueAcceuil.dispose();
							VenteView vv = new VenteView();
						}
					});
					MenuLateral.add(btnVente);
					
					JButton btnProduits = new JButton("Produits");
					btnProduits.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de paramétrage
							vueAcceuil.dispose();
							ParametrageView pv = new ParametrageView();							
						}
					});
					MenuLateral.add(btnProduits);
					
					JButton btnCaisse = new JButton("Caisse");
					btnCaisse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de fond de caisse
							vueAcceuil.dispose();
							FondDeCaisseView cv = new FondDeCaisseView();	
						}
					});
					MenuLateral.add(btnCaisse);
					
					JButton btnSecurite = new JButton("Sécurité");
					btnSecurite.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de mise en securite
							vueAcceuil.dispose();
							MiseEnSecuriteView pv = new MiseEnSecuriteView();	
						}
					});
					MenuLateral.add(btnSecurite);
					
					JButton btnRapports = new JButton("Rapports");
					btnRapports.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//TODO va sur la vue de rapports
							vueAcceuil.dispose();
							RapportsView rv = new RapportsView();	
						}
					});
					MenuLateral.add(btnRapports);
					
			//Panneau principal qui va changer en fonction de la vue
				JPanel info = new JPanel();
				AffichagePrincipalAcceuil.add(info);
				

	}

}
