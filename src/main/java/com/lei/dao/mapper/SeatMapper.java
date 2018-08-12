package com.lei.dao.mapper;

import com.lei.pojo.Seat;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatMapper {
    int deleteByPrimaryKey(Integer seatId);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer seatId);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);
}