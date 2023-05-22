package com.TodoListManager.TodoListManager.Service;

import com.TodoListManager.TodoListManager.DTO.JasperReportsToTodoListManagerDTO;
import com.TodoListManager.TodoListManager.Model.Todo;
import com.TodoListManager.TodoListManager.Repository.TodoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {


    @Autowired
    TodoRepository todoRepository;
//    @Autowired
//    UserRegistrationRepositories userRegistrationRepositories;

    public static final String pathToReports = "C:\\Users\\User007\\Documents\\TodoListManager\\TodoListManager\\Todo List Report";

    public String generateJasperReportsToTodoListManager() throws JRException {
        List<Todo> leaderBoards = todoRepository.findAll();
        List<JasperReportsToTodoListManagerDTO> jasperReportsToTodoListManagerDTOS = new ArrayList<>();
        for (Todo t : leaderBoards) {
            Integer todoListId = t.getId();
            String todoListTitle = t.getTitle();
            String todoListDescription = t.getDescription();
            Boolean Completed = t.getCompleted();

            JasperReportsToTodoListManagerDTO jasperReportsToDisplayTheLeaderboardStandingDTOList = new
                    JasperReportsToTodoListManagerDTO(todoListId, todoListTitle, todoListDescription, Completed);

            jasperReportsToTodoListManagerDTOS.add(jasperReportsToDisplayTheLeaderboardStandingDTOList);

        }




    File file = new File( "C:\\Users\\User007\\Documents\\TodoListManager\\TodoListManager\\src\\main\\resources\\TodoListManager.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(jasperReportsToTodoListManagerDTOS);
    Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "Sumaiya");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\generateJasperReportsToTodoListManager.pdf");
            return "Report generated : " + pathToReports+"\\generateJasperReportsToTodoListManager.pdf";
}

}
