package service;


import dao.CartDao;
import model.Cart;

import java.sql.SQLException;
import java.util.List;

public class CartService {
    private CartDao cartDao = new CartDao();
    public Cart findCartByGoodID(int goodid) {
        List<Cart> list = null;
        try {
            list = cartDao.getCartsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cart cart=null;
        for (Cart data: list){
            if(data.getGoodId()==goodid){
                cart=data;
                break;
            }
        }
        return cart;
    }
    public List<Cart> selectCartsList() {
        List<Cart> list = null;
        try {
            list = cartDao.getCartsList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Cart cart) {
        try {
            cartDao.insert(cart);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void update(Cart cart) {
        try {
            cartDao.update(cart);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            cartDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAll(int goodid) {
        try {
            cartDao.deleteAll(goodid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUserId(int useId) {
        try {
            cartDao.deleteUserId(useId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public Cart getCartsById(int id) {
//        Cart cart = null;
//        try {
//            cart = cartDao.get
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return g;
//    }
}
