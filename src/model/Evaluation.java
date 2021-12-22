package model;

public class Evaluation {
    private int id;//评价id
    private int gid;//商品id
    private int uid;//用户id
    private String eval;//评价内容

    public int getId() {return id;}
    public void setId(int id) {this.id=id;}
    public int getGid() {return gid;}
    public void setGid(int gid) {this.gid=gid;}
    public int getUid() {return uid;}
    public void setUid(int uid) {this.uid=uid;}
    public String getEval() {return eval;}
    public void setEval(String eval) {this.eval=eval;}
    public Evaluation(int id,int gid,int uid,String eval){
        super();
        this.id=id;
        this.uid=uid;
        this.gid=gid;
        this.eval=eval;
    }
    public Evaluation(int gid,int uid,String eval){
        this.gid=gid;
        this.uid=uid;
        this.eval=eval;
    }
    public Evaluation(){super();}
}
