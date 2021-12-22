package dao;

import model.Money;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class MoneyDao {
    public Money getMoneyByUserId(int userid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from money where userid=?";
        return queryRunner.query(sql, new BeanHandler<Money>(Money.class), userid);
    }

    public void insert(Money money) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into money(userid,balance) values(?,?)";
        r.update(sql, money.getUserid(), money.getBalance());
    }

    public void update(Money money) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update money set balance=? where userid=?";
        r.update(sql, money.getBalance(), money.getUserid());
    }

    public void delete(int userid) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from money where userid = ?";
        r.update(sql, userid);
    }

}
