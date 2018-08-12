package com.lei.movie.service;

import com.lei.pojo.Movie;

import java.util.Map;
public interface MovieService {
    public Map saveOrUpdateMovie(Movie movie) throws  Exception;
    public Map selectMovieForPaging(int pageNum,int pageSize)throws  Exception;
}
