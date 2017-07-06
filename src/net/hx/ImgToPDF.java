package net.hx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class ImgToPDF 
{

	public   static  void  main(String [] args)
	{
		try {
			String imagePath = "D:/11.png";
			String pdfPath = "D:/picc/test.pdf";
			File pdfFile=new File(pdfPath);
			if(!pdfFile.exists())
			{
				pdfFile.getParentFile().mkdirs(); 
				
			}
			BufferedImage img = ImageIO.read(new File(imagePath));
			FileOutputStream fos = new FileOutputStream(pdfFile);
			Document doc = new Document(null, 0, 0, 0, 0);
			doc.setPageSize(new Rectangle(img.getWidth(), img.getHeight()));
			Image image = Image.getInstance(imagePath);
			PdfWriter.getInstance(doc, fos);
			doc.open();
			doc.add(image);
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
