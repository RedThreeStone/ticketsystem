package com.lei.login.service;

import com.lei.dao.mapper.UserMapper;
import com.lei.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public Map register(User user) throws Exception {
        Map resultMap=new HashMap(16);
        try {
            String username=user.getUsername();
            User findUser = userMapper.selectUserByUsername(username);
            if(findUser!=null){
                throw  new  Exception("用户名重复!!!#");
            }
            userMapper.insert(user);
            resultMap.put("success",true);
            return  resultMap;
        }catch (Exception e){
            e.printStackTrace();
            if(e.getMessage().endsWith("#")){
                throw  new  Exception(e.getMessage().substring(0,e.getMessage().length()-1));
            }else {
                throw  new  Exception("注册失败!!!");
            }
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public Map login(User user) throws Exception {
        Map resultMap=new HashMap(16);
        try {
            User findUser=userMapper.selectUserByUsernameAndPassword(user);
            if(findUser!=null){
                resultMap.put("account",findUser);
                resultMap.put("success",true);
            }else {
                throw  new  Exception("账号或者密码错误!!!#");
            }
            return  resultMap;
        }catch (Exception e){
            e.printStackTrace();
            if(e.getMessage().endsWith("#")){
                throw  new  Exception(e.getMessage().substring(0,e.getMessage().length()-1));
            }else {
                throw  new  Exception("登陆失败!!!");
            }
        }
    }
}
