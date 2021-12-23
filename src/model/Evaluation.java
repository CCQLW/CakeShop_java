package model;

import java.util.Date;

public class Evaluation {
    private int id;//评价id
    private int gid;//商品id
    private int uid;//用户id
    private String eval;//评价内容
    private String uname;//用户姓名
    private Date date;//评论时间

    public int getId() {return id;}
    public void setId(int id) {this.id=id;}
    public int getGid() {return gid;}
    public void setGid(int gid) {this.gid=gid;}
    public int getUid() {return uid;}
    public void setUid(int uid) {this.uid=uid;}
    public String getEval() {return eval;}
    public void setEval(String eval) {this.eval=eval;}
    public String getUname(){return uname;}
    public void setUname(String name){this.uname=name;}
    public Date getDate(){return date;}
    public void setDate(Date date){this.date=date;}
    public Evaluation(int id,int gid,int uid,String eval,String uname,Date date){
        super();
        this.id=id;
        this.uid=uid;
        this.gid=gid;
        this.eval=eval;
        this.uname=uname;
        this.date=date;
    }
    public Evaluation(int gid,int uid,String eval,String uname,Date date){
        this.gid=gid;
        this.uid=uid;
        this.eval=eval;
        this.uname=uname;
        this.date=date;
    }
    public Evaluation(){super();}
}
