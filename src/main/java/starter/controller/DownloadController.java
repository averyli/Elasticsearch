package starter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import starter.common.GlobalConfig;
import starter.domain.Book;
import starter.service.BookService;

@Controller
@RequestMapping("/download")
public class DownloadController {
    
    @Autowired
    private BookService bookService;
    
    @RequestMapping("/samplePdf")
    public ModelAndView bookPdf()
    {
        Map<String,Object> globalModel = new HashMap<>();
        globalModel.put("mobile", GlobalConfig.readProperty("form.mobile"));
        globalModel.put("email", GlobalConfig.readProperty("form.email"));
        globalModel.put("name", GlobalConfig.readProperty("form.name"));
        globalModel.put("model", "pdf");
        ModelAndView modelAndView=new ModelAndView("simpleFormPDF",globalModel);
        return modelAndView;
    }
    
    @RequestMapping("/bookPdf")
    public ModelAndView truckerPdf()
    {
        Map<String,Object> globalModel = new HashMap<>();
        List<Book> bookList=bookService.findLikeName("li");
        globalModel.put("bookList", bookList);
        ModelAndView modelAndView=new ModelAndView("bookPdf",globalModel);
        return modelAndView;
    }
}
