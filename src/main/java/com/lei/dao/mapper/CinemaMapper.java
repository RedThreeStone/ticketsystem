package com.lei.dao.mapper;

import com.lei.pojo.Cinema;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaMapper {
    int deleteByPrimaryKey(Integer cinemaId);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    Cinema selectByPrimaryKey(Integer cinemaId);

    int updateByPrimaryKeySelective(Cinema record);

    int updateByPrimaryKey(Cinema record);
}