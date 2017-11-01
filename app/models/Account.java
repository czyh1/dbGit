package models;


import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2017/10/30.
 */
@Entity
public class Account extends Model{
    public  String name;
    public  String pwd;



}
