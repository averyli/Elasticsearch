package starter.service;

import org.joda.time.DateTime;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import starter.repository.BookRepository;
import starter.Job.BookAddJob;
import starter.domain.Book;

/**
 * Created by Nasir on 12-09-2015.
 */
@Service
public class BookService {
    public static final Logger log= LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private Scheduler scheduler;

    public List<Book> getByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<Book> getByRatingInterval(Double start, Double end) {
        return bookRepository.findByRatingBetween(start, end);
    }

    public void addMovie(Book book) {
      bookRepository.save(book);
    }

    public void autoAddMovie() throws SchedulerException {
        log.debug("autoAddMovie() start...");
        // JobDataMap jobDataMap = new JobDataMap();
        // jobDataMap.put("tenderDraftId", tenderDraft.getId());
        // jobDataMap.put("user", user);
        // log.debug("[job] initTenderTimePlan : pushTenderToTruckers start :{}", tenderDraft.getId());
        JobDetail jobDetail = JobBuilder.newJob(BookAddJob.class)
            .withIdentity(new JobKey("add_book", "book")).build();
            // .usingJobData(jobDataMap).build();
        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail)
            .startAt(DateTime.now().plusMinutes(1).toDate())
            .endAt(DateTime.now().plusMinutes(10).toDate())
            .build();
        scheduler.scheduleJob(jobDetail,trigger);
        // bookRepository.save(book);
    }
    
    public List<Book> findLikeName(String name) {
        return bookRepository.findByNameLike(name);
    }
    
    public void deleteLike(String name) {
        bookRepository.deleteByNameLike(name);
    }
    
    public List<Book> findAll()
    {
        return (List<Book>) bookRepository.findAll();
    }
}
