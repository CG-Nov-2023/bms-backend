package com.bms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.dao.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
