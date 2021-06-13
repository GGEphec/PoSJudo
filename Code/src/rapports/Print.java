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
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.text.Document;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;


/**
 * @author gaeta_2b6psqs
 *
 * @version 28 mai 2021
 */
//public class Print{
//	
//	public static void print(JPanel panneau) {
//		BufferedImage image = new BufferedImage(panneau.getPreferredSize().width, panneau.getPreferredSize().height, BufferedImage.TYPE_3BYTE_BGR);
//		Graphics graph = image.getGraphics();
//		panneau.paint(graph);
//		
//		Image imageFinale = (Image)image;
//		
//		PrinterJob printJob = PrinterJob.getPrinterJob();
//		printJob.setPrintable(new Printable() 	{
//			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//		        if (pageIndex != 0) {
//		            return NO_SUCH_PAGE;
//		        }
//		        graphics.drawImage(imageFinale, 75, 75, 1100, 800, null);
//		        return PAGE_EXISTS;
//				}
//			});
//		
//
//		try {
//			printJob.print();
//		} catch(PrinterException e) {
//			e.printStackTrace();
//		}
//	}
//
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
//	
//	
//}











public class Print{
	
	public static final String locationPDF = "C:\\Users\\Public\\posjudo\\Rapport-";
	
	public static void print(Object[][] rapport, String nom) {
		try {
			System.out.println("print"+nom);
			//Crétion du document
			Document rapportPDF = new Document();
			PdfWriter writer = PdfWriter.getInstance(rapportPDF, new FileOutputStream(locationPDF+nom+".pdf"));
			PdfPTable tableau;
			if(nom.contains("Fonds") || nom.contains("Mise") || nom.contains("MeS") || nom.contains("FdC")) {
				tableau = new PdfPTable(3);
				tableau.setWidthPercentage(100);
				tableau.setWidths(new float[] {6.2f, 6.2f, 6.2f});
			}
			else {
				tableau = new PdfPTable(4);
				tableau.setWidthPercentage(100);
				tableau.setWidths(new float[] {6.2f, 6.2f, 6.2f, 6.2f});
			}
			PdfPCell cases = new PdfPCell();
			
			for(int i=0; i<rapport.length; i++) {
				for(int j = 0; j<rapport[0].length; j++) {
					cases.setPhrase( new Phrase(rapport[i][j].toString()));
					tableau.addCell(cases);
				}
			}
			rapportPDF.open();
			rapportPDF.add(tableau);
			rapportPDF.close();
			writer.close();
//			
//			//Impression du document
//		        PdfDocument pdf = new PdfDocument();
//		        pdf.loadFromFile(nom);
//	
//		        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
//		        PageFormat loPageFormat  = loPrinterJob.defaultPage();
//		        Paper loPaper = loPageFormat.getPaper();
//	
//		        //remove the default printing margins
//		        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
//	
//		        loPageFormat.setPaper(loPaper);
//		        loPrinterJob.setPrintable(pdf,loPageFormat);
//	
//		        //display the print dialog
//		        if (loPrinterJob.printDialog()) {
//		            try {
//		                loPrinterJob.print();
//		            } catch (PrinterException e) {
//		                e.printStackTrace();
//		            }
//		        }
//			
			
		}catch(DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}