package com.lei.movie.service;

import com.lei.pojo.Movie;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

public class ExportServiceImpl implements ExportService {
    @Override
    public void exportAllMovie(Workbook workbook, Map<String, Object> modal) {
        List<Movie> movies = (List<Movie>) modal.get("movieList");
        Sheet sheet = workbook.createSheet("所有电影信息");
        Row title= sheet.createRow(0);
        title.createCell(0).setCellValue("电影名");
        title.createCell(1).setCellValue("电影主角");
        title.createCell(2).setCellValue("电影导演");
        for (int i=0;i<movies.size();i++){
            Movie movie = movies.get(i);
            Row data = sheet.createRow(i+1);
            data.createCell(0).setCellValue(movie.getMovieName());
            data.createCell(1).setCellValue(movie.getMovieMainrole());
            data.createCell(2).setCellValue(movie.getMovieDirector());
        }
    }
}
