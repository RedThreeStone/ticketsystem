package com.lei.movie.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExportService {
    /**
     * 导出所有电影信息
     * @param workbook
     * @param modal
     */
    void exportAllMovie(Workbook workbook, Map<String,Object> modal);
}
