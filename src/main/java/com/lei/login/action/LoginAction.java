package com.lei.login.action;

import com.lei.login.service.LoginService;
import com.lei.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 */
@Controller
@RequestMapping("/loginAction")
@SessionAttributes(names = {"account"})
public class LoginAction {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public ModelAndView login(User user){
        ModelAndView modelAndView = new ModelAndView();
        Map resultMap = new HashMap();
        try {
            resultMap=loginService.login(user);
            resultMap.put("success",true);
        }catch (Exception e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }
        modelAndView.addAllObjects(resultMap);
        return  modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public  Map register(User user){
        Map resultMap=new HashMap(16);
        try {
            resultMap=loginService.register(user);
            resultMap.put("success",true);
        }catch (Exception e){
            resultMap.put("success",false);
            resultMap.put("message",e.getMessage());
        }
        return resultMap;
    }
}

