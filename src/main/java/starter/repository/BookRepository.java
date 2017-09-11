package starter.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import starter.domain.Book;

/**
 * Created by Nasir on 12-09-2015.
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long> {
    
    public List<Book> findByName(String name);
    
    public List<Book> findByRatingBetween(Double start, Double end);
    
    public List<Book> findByNameLike(String name);
    
    public void deleteByNameLike(String name);
}
