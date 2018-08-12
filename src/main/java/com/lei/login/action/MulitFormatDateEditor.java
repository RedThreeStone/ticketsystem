package com.lei.login.action;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class MulitFormatDateEditor extends PropertyEditorSupport {
    private final DateFormat dateFormat;
    //日期格式2
    private final DateFormat dateFormat2;
    //是否允许为空
    private final boolean allowEmpty;
    //日期长度
    private final int exactDateLength;


    public MulitFormatDateEditor(DateFormat dateFormat, DateFormat dateFormat2, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.dateFormat2 = dateFormat2;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = -1;
    }

    public MulitFormatDateEditor(DateFormat dateFormat, DateFormat dateFormat2, boolean allowEmpty, int exactDateLength) {
        this.dateFormat = dateFormat;
        this.dateFormat2 = dateFormat2;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = exactDateLength;
    }


    /**
     * 使用指定的日期格式,解析给定文本的日期。
     *
     * */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(this.allowEmpty && StringUtils.hasText(text)){
            setValue(null);
        }
        else if(text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength){
            throw new IllegalArgumentException("不能解析这个日期，长度为："+this.exactDateLength);
        }
        else{
            try {
                if(text != null){
                    setValue(this.dateFormat.parse(text));
                }
            }catch (ParseException ex){
                try {
                    if(text != null){
                        setValue(this.dateFormat2.parse(text));
                    }
                }catch (ParseException ex2){
                    throw new IllegalArgumentException("不能解析这个日期"+ex.getMessage(),ex);
                }
            }
        }
    }


    /**
     * 将日期格式化为字符串,使用指定的日期格式。
     */
    @Override
    public String getAsText() {
        Date value = (Date)getValue();
        return (value != null ? this.dateFormat2.format(value):"");
    }
}
