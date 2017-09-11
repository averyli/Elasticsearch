package starter.Job;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import starter.domain.Book;
import starter.repository.BookRepository;

@Component
@Configurable
@EnableScheduling
public class SpringScheduleTask {
    
    public static Logger log= LoggerFactory.getLogger(SpringScheduleTask.class);
    @Autowired
    private BookRepository bookRepository;
    
    @Scheduled(cron =" 0/10 * *  * * *")
    public void reportCurrentTime(){
            Random random = new Random();
            Book savedBook=bookRepository.save(new Book("li" + "xxxxx"+random.nextInt()));
            log.debug("save book:{}",savedBook);
    }
}
