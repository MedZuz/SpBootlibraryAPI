package tn.esb.bis.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.demo.Domains.Book;

@Repository
public interface R_Return extends JpaRepository<Book,String> {
}
