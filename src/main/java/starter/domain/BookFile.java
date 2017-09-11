package starter.domain;

import java.io.File;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "elastic_starter",type = "book_file",shards = 1, replicas = 0)
public class BookFile {
    @Id
    private Long id;
    
    private File file;
    
}
