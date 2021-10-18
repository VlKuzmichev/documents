package com.test.documents.web;

import com.test.documents.dao.DocTypeRepo;
import com.test.documents.dao.DocUnitRepo;
import com.test.documents.dao.DocumentRepo;
import com.test.documents.dao.EmployeeRepo;
import com.test.documents.model.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Controller
public class DocumentController {

    public DocumentRepo documentRepo;
    public EmployeeRepo employeeRepo;
    public DocTypeRepo docTypeRepo;
    public DocUnitRepo docUnitRepo;


    public DocumentController(DocumentRepo documentRepo, EmployeeRepo employeeRepo, DocTypeRepo docTypeRepo,
                              DocUnitRepo docUnitRepo) {
        this.documentRepo = documentRepo;
        this.employeeRepo = employeeRepo;
        this.docTypeRepo = docTypeRepo;
        this.docUnitRepo = docUnitRepo;
    }

    @RequestMapping(value = "/documents/create", method = RequestMethod.GET)
    public String createUser(ModelMap modelMap) {
        modelMap.addAttribute("document", new Document());
        modelMap.addAttribute("employees", employeeRepo.getAll());
        modelMap.addAttribute("docTypes", docTypeRepo.getAll());
        modelMap.addAttribute("docUnits", docUnitRepo.getAll());
        return "add_document";
    }

    @RequestMapping(value = "/documents/update", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, ModelMap modelMap) {
        modelMap.addAttribute("document", documentRepo.get(getId(request)));
        modelMap.addAttribute("employees", employeeRepo.getAll());
        modelMap.addAttribute("docTypes", docTypeRepo.getAll());
        modelMap.addAttribute("docUnits", docUnitRepo.getAll());
        return "edit_document";
    }

    @RequestMapping(value = "/documents", method = RequestMethod.POST)
    public String updateOrCreate(HttpServletRequest request) {
        String date = addTChar(request.getParameter("date"));
        int typeId = Integer.parseInt(request.getParameter("doc-type"));
        int unitId = Integer.parseInt(request.getParameter("doc-unit"));
        int employeeId = Integer.parseInt(request.getParameter("employee"));
        Document document = new Document(null, LocalDateTime.parse(date), request.getParameter("value"),
                Integer.parseInt(request.getParameter("sum")), docTypeRepo.get(typeId), docUnitRepo.get(unitId), employeeRepo.get(employeeId));
        documentRepo.save(document);
        return "redirect:/documents";
    }

    @GetMapping(value = "/documents")
    public String showDocumentsList(Model model) {
        List<Document> list = documentRepo.getAll();
        model.addAttribute("documents", documentRepo.getAll());
        return "documents";
    }

    @GetMapping(value = "/documents/delete")
    public String delete(HttpServletRequest request) {
        int paramId = Integer.parseInt(Objects.requireNonNull(request.getParameter("id")));
        documentRepo.delete(paramId);
        return "redirect:/documents";
    }

    public String addTChar(String str) {
        return str.substring(0, 10) + 'T' + str.substring(11);
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
