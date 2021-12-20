package dao;

import model.Count;
import model.Goods;

import java.util.List;

public interface CountDao {
        public List<Count> selectAll();
        public int insert(int counts);
}
