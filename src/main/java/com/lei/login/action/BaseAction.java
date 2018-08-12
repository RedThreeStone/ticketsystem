package com.lei.login.action;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseAction {
    @InitBinder
    public void  initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
       /* webDataBinder.registerCustomEditor(Date.class,
                new MulitFormatDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));*/
    }
}
