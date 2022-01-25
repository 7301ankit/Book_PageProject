package com.Book_project.Book_Page.repo;

import com.Book_project.Book_Page.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page,Long> {
   Page findByNumber(Long number);
}
