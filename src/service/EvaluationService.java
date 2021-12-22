package service;

import dao.EvaluationDao;
import model.Page;
import model.Evaluation;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class EvaluationService {
    private EvaluationDao eDao=new EvaluationDao();
    public boolean addEval(Evaluation eval){
        try{
            eDao.addEvaluation(eval);
            return true;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public Evaluation selectById(int id){
        Evaluation ee=null;
        try {
            ee = eDao.selectById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ee;
    }
    public Evaluation selectByGid(int gid){
        Evaluation ee=null;
        try {
            ee = eDao.selectByGid(gid);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ee;
    }
    public Evaluation selectByUid(int uid){
        Evaluation ee=null;
        try {
            ee = eDao.selectByUid(uid);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ee;
    }
}
