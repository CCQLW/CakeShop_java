package service;

import Impl.CountDaoImpl;
import dao.CountDao;
import dao.GoodsDao;
import model.Count;
import model.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CountService {
    private CountDao  countDao = new CountDaoImpl();

//    public List<Count> getCountsList() {
//        List<Count> list=null;
//        list= countDao.selectAll();
//        return list;
//    }

    public int getCountsByList() {
        List<Count> list=null;
        list= countDao.selectAll();
        int  counts= list.get(list.size()-1).getCounts();
//        System.out.println(list.get(list.size()-1));
        return counts;
    }

    public void insert(int counts) {
        countDao.insert(counts);
    }

//    public static void main(String[] args) {
//        CountService countService=new CountService();
//        int counts=10;
//        countService.insert(counts);
//    }
}
