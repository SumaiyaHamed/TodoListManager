package com.TodoListManager.TodoListManager.Controllers;

import com.TodoListManager.TodoListManager.Service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value = "api/generateJasperReportsToTodoListManager", method = RequestMethod.GET)
    public String generateReport() throws Exception {
        return reportService.generateJasperReportsToTodoListManager();

    }



}
