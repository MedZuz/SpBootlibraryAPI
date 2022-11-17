package tn.esb.bis.demo.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.bis.demo.Domains.Book;
import tn.esb.bis.demo.Services.S_Book;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/book")
public class C_Book {
    @Autowired
    private S_Book service ;

    //select => se fait via la methode GET de http

    @GetMapping("/all")
    public ResponseEntity<?> getBooks(){

        return service.getBooks();
    }

    @GetMapping("book/isbncode")
    public ResponseEntity<?> getBook(@PathVariable String isbncode){
        return service.getOneBook(isbncode);
    }

    @PostMapping("/post/newbook")
    public ResponseEntity<?> creatnewbook(@Valid @RequestBody Book b1){
        return service.addBook(b1);
    }




    @DeleteMapping("/delete")
    public ResponseEntity<?> deletebook(@PathVariable String isbncode){

        return service.deleteBook(isbncode);
    }

    @PutMapping("/update/{isbncode}")
    public ResponseEntity<?> update(@PathVariable String isbncode , @Valid @RequestBody Book newBook){

        return  service.updatebook(isbncode ,newBook);
    }

}
