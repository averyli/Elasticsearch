package starter;

import java.util.List;
import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @RequestMapping(value="/save",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> save()
    {
        Book book=new Book();
        book.setName("lolong");
        book.setRating(50.0);
    
        bookService.addMovie(book);
        
        return bookService.getByName("lilong");
        
    }
    
    @RequestMapping(value="/saveBook",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> saveBook(@RequestParam("name")String name,@RequestParam("rate")double rate)
    {
        Book book=new Book();
        book.setName(name);
        book.setRating(rate);
        
        bookService.addMovie(book);
        
        return bookService.getByName(name);
        
    }
}
