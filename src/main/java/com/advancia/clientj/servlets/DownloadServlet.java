package com.advancia.clientj.servlets;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancia.clientj.pdf.PdfGenerator;
import com.itextpdf.layout.Document;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document pdf = PdfGenerator.generatePdf();
		if (pdf != null) {
			response.setContentType("application/octet-stream");
	        response.setHeader( "Content-Disposition", "attachment; filename=\"table.pdf\"" );
	        try (OutputStream out = response.getOutputStream()){
	        	String userDirectory = System.getProperty("user.home") + File.separator + "Downloads";
	            File toBeCopied = new File(userDirectory + File.separator + "table.pdf");
	            Path path = toBeCopied.toPath();
	            Files.copy(path, out);
	            out.flush();
	            new File(userDirectory + File.separator + "table.pdf").delete();
	        }catch(IOException e){
	            e.printStackTrace();
	        }
		}
	}

}
