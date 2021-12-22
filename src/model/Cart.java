package model;

public class Cart {
    int id;         //序号
    int userId;    //user外键
    int goodId;    //order外键

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodId=" + goodId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Cart() {
//        id=0;
    }

    public Cart(int id, int userId, int goodId) {
        this.id = id;
        this.userId = userId;
        this.goodId = goodId;
    }
}
