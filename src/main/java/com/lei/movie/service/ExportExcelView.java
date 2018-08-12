package com.lei.movie.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExportExcelView extends AbstractXlsView {
    private  ExportService  exportService = null;
    private  String fileName="";

    public ExportExcelView(ExportService exportService, String fileName) {
        this.exportService = exportService;
        this.fileName = fileName;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-disposition","attachment;filename="+fileName);
        exportService.exportAllMovie(workbook,model);
    }
}
