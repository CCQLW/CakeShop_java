package dao;

import model.Cart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import utils.DataSourceUtils;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartDao {

    public List<Cart> getCartsList() throws SQLException{
        QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from cart";
        return queryRunner.query(sql,new BeanListHandler<Cart>(Cart.class));
    }
//    public Cart getCartsGoodsId(int goodid) throws SQLException {
//        QueryRunner r = new QueryRunner();
//        String sql = "select id from cart where goodid=?";
//        int id=r.query(sql,new BeanListHandler<Cart>(Cart.class),goodid);
//        return
//    }

    public void insert(Cart cart) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into cart(userid,goodid) values(?,?)";
        r.update(sql,cart.getUserId(),cart.getGoodId());
    }
    public void update(Cart cart) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update cart set userid=?,goodid=? where id=?";
        r.update(sql, cart.getUserId(),cart.getGoodId(),cart.getId());
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from cart where id = ?";
        r.update(sql,id);
    }
    public void deleteAll(int goodid) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from cart where goodid = ?";
        r.update(sql,goodid);
    }

}
