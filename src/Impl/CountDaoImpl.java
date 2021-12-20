package Impl;

import dao.CountDao;
import model.Count;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountDaoImpl implements CountDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

    public List<Count> selectAll() {
        String sql = "select * from count ";
        List<Count> list = null;
        try {

            //查询所有的集合
            list = queryRunner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Count>(Count.class));
//            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i).getCount());
//            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insert(int counts) {
        String sql="insert into count (counts) values (?)";
        try {
            int result = queryRunner.update(sql,counts);
            return result;
//            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
//        CountDaoImpl countDao=new CountDaoImpl();
//        countDao.insert(1000);
//    }
}