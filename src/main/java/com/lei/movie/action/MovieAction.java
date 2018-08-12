package com.lei.movie.action;

import com.alibaba.fastjson.JSONObject;
import com.lei.movie.service.ExportExcelView;
import com.lei.movie.service.ExportServiceImpl;
import com.lei.movie.service.MovieService;
import com.lei.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller()
@RequestMapping("/movieAction")
public class MovieAction  {
    @Autowired
    private MovieService movieService;
    @RequestMapping("/saveOrUpdateMovie")
    @ResponseBody
    public ModelAndView saveOrUpdateMovie(Movie movie){
        ModelAndView modelAndView = new ModelAndView();
        Map resultMap=new HashMap(16);
        try {
            resultMap=movieService.saveOrUpdateMovie(movie);
            resultMap.put("success",true);
        }catch (Exception e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }
        modelAndView.addAllObjects(resultMap);
        return  modelAndView;
    }
    @RequestMapping("/uploadMovieNotice")
    @ResponseBody
    public void uploadMovieNotice(MultipartFile file, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        String destName=file.getOriginalFilename();
        String contentType = file.getContentType();
        System.out.println(contentType);
        File destFile = new File(destName);
        file.transferTo(destFile);
        Map resultMap=new HashMap(16);
        resultMap.put("movieNoticeUrl",destName);
        modelAndView.addAllObjects(resultMap);
        response.getWriter().print(JSONObject.toJSONString(resultMap));
    }
    @RequestMapping("/selectMovieForPaging")
    @ResponseBody
    public ModelAndView selectMovieForPaging(){
        ModelAndView modelAndView = new ModelAndView();
        Map resultMap=new HashMap(16);
        try {
            resultMap=movieService.selectMovieForPaging(1,5);
            resultMap.put("success",true);
        }catch (Exception e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }
        modelAndView.addAllObjects(resultMap);
        return  modelAndView;
    }
    @RequestMapping("/downAllMovie")
    @ResponseBody
    public ModelAndView downAllMovie(){
        ModelAndView modelAndView = new ModelAndView();
        Map resultMap=new HashMap(16);
        try {
            resultMap=movieService.selectMovieForPaging(1,5);
            ExportExcelView exportExcelView = new ExportExcelView(new ExportServiceImpl(),"myText.xls");
            modelAndView.setView(exportExcelView);
        }catch (Exception e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }
        modelAndView.addAllObjects(resultMap);
        return  modelAndView;
    }
}
