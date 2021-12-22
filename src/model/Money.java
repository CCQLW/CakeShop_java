package model;

public class Money {
    int userid;     //user外键
    float balance;  //所剩余额

    @Override
    public String toString() {
        return "Money{" +
                "userid=" + userid +
                ", balance=" + balance +
                '}';
    }

    public Money() {
        balance=0;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Money(int userid, float balance) {
        this.userid = userid;
        this.balance = balance;
    }
}
