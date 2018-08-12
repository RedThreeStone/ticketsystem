package com.lei.dao.mapper;

import com.lei.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer ssmUserId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer ssmUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByUsername(@Param("username") String username);

    User selectUserByUsernameAndPassword(User user);
}