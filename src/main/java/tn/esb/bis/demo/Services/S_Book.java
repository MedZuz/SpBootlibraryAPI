package tn.esb.bis.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bis.demo.Domains.Book;
import tn.esb.bis.demo.Repositories.R_Book;

import java.util.List;
import java.util.Optional;


@Service

public class S_Book {

    @Autowired
    private R_Book repository;



        public ResponseEntity<?> getBooks() {

            List<Book> res = repository.findAll();
            if (res.isEmpty())
                  return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is no book available for now");
                return ResponseEntity.status(HttpStatus.OK).body(res);

        }

        public  ResponseEntity<?>  getOneBook (String code_isbn){
            Optional<?> res = repository.findById(code_isbn);
            if (res.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is no book available for now");
            return ResponseEntity.status(HttpStatus.OK).body(res.get());
            }

        public ResponseEntity<?> addBook (Book b1) {
                //verifier s'il existe un live ayant le meme isbn code et le meme titre qui a deja ete ajouté
                // sinon existe il un livre ayant le meme titre et le meme auteur

                List<Book> lstBooks = repository.findAll();
                int i = 0 ;
                boolean find=false;
                while(i<lstBooks.size()&&find){
                    if(lstBooks.get(i).getCode_isbn().equalsIgnoreCase(b1.getCode_isbn()))
                        find = true ;
                        i++;
                }

                if (find)
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is no book available for now");



                return ResponseEntity.status(HttpStatus.CREATED).body(  repository.save(b1)) ;
            }


                public  ResponseEntity<?> deleteBook(String isbncode){

                    Optional<?> res = repository.findById(isbncode);
                    if (res.isEmpty())
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is no book available for now");
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body("the book with code"+ isbncode + "has been succefully deleted  ");

                }


                public ResponseEntity<?> updatebook(String isbncode , Book bNEW){
                    Optional<Book> res = repository.findById(isbncode);
                    if (res.isEmpty())
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is no book available for now");

                    //recupere le livre from the optional collection

                    Book b1 = res.get();
                    b1.setCode_isbn(isbncode);
                    b1.setPrix(bNEW.getPrix());
                    b1.setSummary(bNEW.getSummary());
                    b1.setDate_de_sortie(bNEW.getDate_de_sortie());
                    b1.setNbExamplares(bNEW.getNbExamplares());

                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(b1));

                }

        }






