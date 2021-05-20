/**
 * 
 */
package acceuil;

import javax.swing.JFrame;

import java.awt.EventQueue;
import java.sql.*;

/**
 * @author gaeta_2b6psqs
 *
 */
public class Acceuil {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DBHelper.setTotal(0);
		AcceuilView window = new AcceuilView();
		window.vueAcceuil.setVisible(true);
	}

}
