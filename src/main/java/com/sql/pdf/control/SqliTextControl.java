package com.sql.pdf.control;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;


import com.sql.pdf.domain.SqlPdf;
import com.sql.pdf.generate.CreateFooter;
import com.sql.pdf.generate.CreateHeader;
import com.sql.pdf.generate.PDFGenerator;
import com.sql.pdf.generate.ReadXml;
import com.sql.pdf.repository.SqliTextRepository;
import com.sql.pdf.service.SqliTextService;

@Controller

public class SqliTextControl {
	
	@Autowired
	private SqliTextService service;
	
	@Autowired
	SqliTextRepository repo;
	
	
	public ReadXml readxml = new ReadXml();
	
	
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<SqlPdf> listtransaction = service.listAll();
		model.addAttribute("listtransaction", listtransaction);
		System.out.print("Get /");
		System.out.println(repo.count());
		return "index";
		
	}
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("transaction", new SqlPdf());
		return "new";
		
	}

	
	
	
	@GetMapping(value="/show", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity pdfReport() throws IOException, ParserConfigurationException, SAXException{
		List tr = (List) repo.findAll();
		
		readxml.readData();
		
		ByteArrayInputStream bis = PDFGenerator.sqlPDFReport(tr);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=SqlPdf.pdf");
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
		
		
		
	}

}
