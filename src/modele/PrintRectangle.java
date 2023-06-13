package modele;

import java.awt.Color;
import java.awt.Graphics;
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
            graphics.drawString(facture, (int) xLeft, (int) yTop+10);
            // La page est valide
            retValue = Printable.PAGE_EXISTS;
            break;
         }
         case 1 : {
            // Dessin de la seconde page
            // Récupère la dimension de la zone imprimable
            double xLeft  = pageFormat.getImageableX();
            double yTop   = pageFormat.getImageableY();
            double width  = pageFormat.getImageableWidth();
            double height = pageFormat.getImageableHeight();
            
            // Dessine l'ellipse
            graphics.setColor(Color.BLACK);
            graphics.drawOval((int)xLeft,
                              (int)yTop,
                              (int)width,
                              (int)height);
            // La page est valide
            retValue = Printable.PAGE_EXISTS;
            break;
         }
      }
      return retValue;
   }
   
}
