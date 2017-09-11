package starter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import starter.domain.Book;
import starter.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> save() {
        Book book = new Book();
        book.setName("lolong");
        book.setRating(50.0);
        bookService.addMovie(book);
        return bookService.getByName("lilong");
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> saveBook(@RequestParam("name") String name,@RequestParam("rating")double rating) {
        bookService.addMovie(new Book(name,rating));
        return bookService.getByName(name);
    }

    @RequestMapping(value = "/findLike", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findLike(@RequestParam("name") String name) {
        return bookService.findLikeName(name);
    }
    
    
    @RequestMapping(value = "/deleteLike", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLike(@RequestParam("name") String name) {
        bookService.deleteLike(name);
    }
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findAll() {
        return bookService.findAll();
    }
    
}
