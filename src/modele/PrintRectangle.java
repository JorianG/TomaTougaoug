package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintRectangle implements Printable {
   private String facture;
   /** Constructeur par défaut de PrintRectangle */
   public PrintRectangle(String facture) {
	   this.facture = facture;
   }


   public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
      // Par défaut, retourne NO_SUCH_PAGE => la page n'existe pas
      int retValue = Printable.NO_SUCH_PAGE;
      switch(pageIndex){
         case 0 : {
            // Dessin de la première page
            // Récupère la dimension de la zone imprimable
            double xLeft  = pageFormat.getImageableX();
            double yTop   = pageFormat.getImageableY();
            double width  = pageFormat.getImageableWidth();
            double height = pageFormat.getImageableHeight();
            
            // Dessine le rectangle
            graphics.setColor(Color.BLACK);
            int yOffset = 40;
            String line = "";
            for (int i = 0; i < facture.length(); i++) {
            	if (facture.charAt(i) != '\n') {
            		line = line + facture.charAt(i); 
            	} else {
            		graphics.drawString(line, (int) xLeft+25, yOffset);
            		line = "";
            		yOffset += 10;
            	}
            }
            // La page est valide
            retValue = Printable.PAGE_EXISTS;
            break;
         }
      }
      return retValue;
      
   }
   
}
