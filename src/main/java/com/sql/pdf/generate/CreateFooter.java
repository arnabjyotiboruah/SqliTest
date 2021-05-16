package com.sql.pdf.generate;

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.sql.pdf.domain.Details;


public class CreateFooter implements IEventHandler{
		
		protected Document doc;
		public CreateFooter(Document doc) {
			this.doc=doc;
		}
		
		@Override
		public void handleEvent(Event event) {
			PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			PdfCanvas canvas = new PdfCanvas(docEvent.getPage());
			Rectangle rect = docEvent.getPage().getPageSize();
			canvas.beginText();
			try {
				canvas.setFontAndSize(PdfFontFactory.createFont(FontConstants.HELVETICA_OBLIQUE), 5);
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			float coordX = ((rect.getLeft() + doc.getLeftMargin()) + (rect.getRight() - doc.getRightMargin())) / 2;
			float footerY = doc.getBottomMargin();
//			canvas.moveText(coordX, footerY).showText(new Details().getTextFooter()).endText().release();
			Details info = new Details();
			try {
				info = ReadXml.readData();
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String footer = info.getFooter().toString();
			if( footer != null) {
				canvas.moveText(coordX, footerY).showText(info.getDate().toString()).showText(footer).endText().release();

			}
		
			
			
		}
	}

