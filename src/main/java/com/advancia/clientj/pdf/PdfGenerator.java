package com.advancia.clientj.pdf;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.advancia.clientj.dao.UserDAO;
import com.advancia.clientj.model.User;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

public class PdfGenerator {
	public static Document generatePdf() {
		try {
			String userDirectory = System.getProperty("user.home") + File.separator + "Downloads";
			PdfWriter writer = new PdfWriter(userDirectory + File.separator + "table.pdf");
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String format = formatter.format(date);
			List<User> users = UserDAO.getUserList();
			float col = 280f;
			float[] pointColumnWidths = { col, col };
			Table header = new Table(pointColumnWidths);
			header.setBackgroundColor(new DeviceRgb(63, 169, 219));
			header.setFontColor(new DeviceRgb(255, 255, 255));
			header.addCell(new Cell().add(new Paragraph("Users")).setTextAlignment(TextAlignment.LEFT)
					.setVerticalAlignment(VerticalAlignment.TOP).setPaddingTop(30f).setPaddingBottom(30f)
					.setPaddingLeft(20f).setFontSize(25f).setBorder(Border.NO_BORDER));
			header.addCell(new Cell().add(new Paragraph("Generated\n" + format)).setTextAlignment(TextAlignment.RIGHT)
					.setPaddingTop(30f).setPaddingBottom(30f).setPaddingRight(20f).setBorder(Border.NO_BORDER));
			float[] tablecol = { 185, 185, 185 };

			Table table = new Table(tablecol);
			
			table.setMarginTop(30f);

			table.addCell(new Cell().add(new Paragraph("Name")).setBackgroundColor(new DeviceRgb(63, 169, 219))
					.setFontColor(new DeviceRgb(255, 255, 255)));
			table.addCell(new Cell().add(new Paragraph("Surname")).setBackgroundColor(new DeviceRgb(63, 169, 219))
					.setFontColor(new DeviceRgb(255, 255, 255)));
			table.addCell(new Cell().add(new Paragraph("Age")).setBackgroundColor(new DeviceRgb(63, 169, 219))
					.setFontColor(new DeviceRgb(255, 255, 255)));
			for (User user : users) {
				table.addCell(new Cell().add(new Paragraph(user.getName())));
				table.addCell(new Cell().add(new Paragraph(user.getSurname())));
				table.addCell(new Cell().add(new Paragraph("" + user.getAge())));
			}
			document.add(header);
			document.add(table);
			document.close();
			return document;
		} catch (Exception e) {
			return null;
		}
	}
}
