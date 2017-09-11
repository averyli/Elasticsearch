package starter.quartz;

import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import starter.service.BookService;

@Configuration
@EnableAutoConfiguration
public class ScheduleInitExcutor implements InitializingBean ,ServletContextAware {

    public static final Logger log= LoggerFactory.getLogger(ScheduleInitExcutor.class);

    @Autowired
    private BookService bookService;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet() start...");
        bookService.autoAddMovie();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
    }
}
