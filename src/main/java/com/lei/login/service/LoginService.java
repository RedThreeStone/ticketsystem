package com.lei.login.service;

import com.lei.pojo.User;

import java.util.Map;

public interface LoginService {

     Map register(User user) throws Exception;

     Map login(User user) throws Exception;
}
