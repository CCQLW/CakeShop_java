package dao;

import model.Evaluation;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class EvaluationDao {
    public void addEvaluation(Evaluation eval) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into evaluation(gid,uid,eval,uname,date) values(?,?,?,?,?)";
        r.update(sql,eval.getGid(),eval.getUid(),eval.getEval(),eval.getUname(),eval.getDate());
    }
    public Evaluation selectByUid(int uid) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where uid=?";
        return r.query(sql, new BeanHandler<Evaluation>(Evaluation.class),uid);
    }
    public Evaluation selectByGid(int gid) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where gid=?";
        return r.query(sql, new BeanHandler<Evaluation>(Evaluation.class),gid);
    }
    public Evaluation selectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from evaluation where id=?";
        return r.query(sql, new BeanHandler<Evaluation>(Evaluation.class),id);
    }
    public List selectEvaluationList(int gid) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from evaluation where gid=?";
        return r.query(sql, new BeanListHandler<Evaluation>(Evaluation.class), gid );
    }
}
