package com.sql.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sql.pdf.domain.SqlPdf;
import com.sql.pdf.repository.SqliTextRepository;

@Service
public class SqliTextService {
	
	@Autowired
	private SqliTextRepository repo;
	
	
	public List<SqlPdf> listAll(){
		return repo.findAll();
	}
	
	public void save(SqlPdf sp) {
		repo.save(sp);
	}
	public SqlPdf get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public int count() {
		return (int) repo.count();
	}

}
