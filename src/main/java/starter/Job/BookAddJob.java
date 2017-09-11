package starter.Job;

import java.util.Random;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import starter.domain.Book;
import starter.repository.BookRepository;

@Component
@EnableScheduling
public class BookAddJob implements Job{
    
    @Autowired
    private BookRepository bookRepository;
    
    public static final Logger log = LoggerFactory.getLogger(BookAddJob.class);
    
    public void addBook() {
        Random random = new Random();
        bookRepository.save(new Book("li" +"eeeeeeeyyyyyyyyyyy"+ random.nextInt()));
    }
    
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("addBookJob start...");
        addBook();
        log.debug("addBookJob end...");
    }
}
