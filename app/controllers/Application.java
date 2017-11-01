package controllers;

import job.MyJob;
import play.*;
import play.data.binding.As;
import play.data.validation.Required;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void hello(@Required String name, @Required String pwd) {
        if(validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }
        //  render(myName);
        List<JPABase> bids = Account.findAll();

        renderArgs.put("name",name);
        renderArgs.put("pwd",pwd);
        renderArgs.put("bids",bids);
        render();
        //renderJSON( Arrays.asList(new String[]{"3","2"}));
    }

    public static void save(@Required String name,@Required String pwd) {
        if(validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }

        Account acc=new Account();
        Long id=new Long(123);
        acc.name=name;
        acc.pwd=pwd;
        JPABase save = acc.save();
        List<Object> fetch = Account.find("name=? and pwd=? order by id desc", name, pwd).fetch();
        List<JPABase> all = Account.findAll();
        renderJSON(fetch);
    }

    /**
     * As  格式化
     * Required  唯一性校验
     * @param list
     */
    public static void asList(@As(",")@Required List list) {
        if(validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }
        renderJSON(list);
    }

    public static void asDate(@As(format = "dd/MM/yyyy") Date from) {
        if(validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }
        renderJSON(from);
    }

    public static void exeJob() {
        new MyJob().now();
    }
    public static void session()
    {
        Account acc=new Account();
        List<JPABase> all = acc.findAll();
        renderArgs.put("acc",all);
       // session.put("acc",all);
        render();ss
    }

}