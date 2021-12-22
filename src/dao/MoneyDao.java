package dao;

import model.Money;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class MoneyDao {
    public void insert(Money money) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into money(userid,balance) values(?,?)";
        r.update(sql,money.getUserid(),money.getBalance());
    }
    public void update(Money money) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update money set balance=? where userid=?";
        r.update(sql,money.getBalance(),money.getUserid());
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from money where id = ?";
        r.update(sql,id);
    }

}
