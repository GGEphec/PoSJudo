/**Cette classe permet d'imprimmer les rapports
 * 
 * Ce code n'est pas le fruit de mon travail mais de recherches effectuées sur internet
 * https://www.mesexemples.com/java-pdf-envoyer-le-contenu-dune-jtable-dans-un-document-pdf/
 * https://stackoverflow.com/questions/10479621/how-to-print-image-in-java
 * https://codes-sources.commentcamarche.net/forum/affich-1162743-convertion-d-un-jpanel-en-pdf
 * 
 * 
 * Cette classe n'est que temporaire afin de fournir des impressions des rapports dans les plus bref délais, elle sera modifiée par la suite afin de faire de meilleurs rapports
 */
package rapports;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.Document;


/**
 * @author gaeta_2b6psqs
 *
 * @version 28 mai 2021
 */
public class Print{
	
	public static void print(JPanel panneau) {
		BufferedImage image = new BufferedImage(panneau.getPreferredSize().width, panneau.getPreferredSize().height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graph = image.getGraphics();
		panneau.paint(graph);
		
		Image imageFinale = (Image)image;
		
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(new Printable() 	{
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		        if (pageIndex != 0) {
		            return NO_SUCH_PAGE;
		        }
		        graphics.drawImage(imageFinale, 75, 75, panneau.getPreferredSize().width, panneau.getPreferredSize().height, null);
		        return PAGE_EXISTS;
				}
			});
		

		try {
			printJob.print();
		} catch(PrinterException e) {
			e.printStackTrace();
		}
	}

//
//	  private void print2() {
//		    Document document = new Document(PageSize.A4.rotate());
//		    try {
//		      PdfWriter pdf_writer = PdfWriter.getInstance(document, 
//		      	new FileOutputStream("c:/jTable.pdf"));
//		 
//		      document.open();
//		      PdfContentByte cb = pdf_writer.getDirectContent();
//		 
//		      cb.saveState();
//		      Graphics2D g2 = cb.createGraphicsShapes(500, 500);
//		 
//		      Shape oldClip = g2.getClip();
//		      g2.clipRect(0, 0, 500, 500);
//		 
//		      table.print(g2);
//		      g2.setClip(oldClip);
//		 
//		      g2.dispose();
//		      cb.restoreState();
//		      JOptionPane.showMessageDialog(null, "JTable exprté vers PDF avec succès");
//		    } catch (Exception e) {
//		      System.err.println(e.getMessage());
//		    }
//		    document.close();
//		  }
	
	
}
