package com.lei.movie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lei.dao.mapper.MovieMapper;
import com.lei.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public Map saveOrUpdateMovie(Movie movie) throws Exception {
       Map resultMap=new HashMap(16);
       try {
           Integer movieId=movie.getMovieId();
           if (movieId!=null){
               movieMapper.updateByPrimaryKeySelective(movie);
           }else {
               movieMapper.insertSelective(movie);
           }
           return  resultMap;
       }catch (Exception e){
           e.printStackTrace();
           if(e.getMessage().endsWith("#")){
               throw  new  Exception(e.getMessage().substring(0,e.getMessage().length()-1));
           }else {
               throw  new Exception("保存电影信息失败!!!");
           }
       }
    }

    @Override
    public Map selectMovieForPaging(int pageNum,int pageSize) throws Exception {
        Map resultMap=new HashMap(16);
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Movie> movieList = movieMapper.selectMoviesForPaging();
            resultMap.put("movieList",movieList);
            PageInfo pageInfo = new PageInfo<Movie>(movieList);
            long total = pageInfo.getTotal();
            resultMap.put("total",total);
            return  resultMap;
        }catch (Exception e){
            e.printStackTrace();
            if(e.getMessage().endsWith("#")){
                throw  new  Exception(e.getMessage().substring(0,e.getMessage().length()-1));
            }else {
                throw  new Exception("获取电影列表失败");
            }
        }

    }
}
