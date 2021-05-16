package com.sql.pdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sql.pdf.domain.SqlPdf;

@Repository
public interface SqliTextRepository extends JpaRepository<SqlPdf, Long> {

}
