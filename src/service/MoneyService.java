package service;


import dao.MoneyDao;
import model.Money;

import java.sql.SQLException;

public class MoneyService {
    MoneyDao moneyDao=new MoneyDao();

    public  Money  getMoneyByUserId(int userid){
        Money money =new Money();
        try {
            money =moneyDao.getMoneyByUserId(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }
    public void insert(Money money) {
        try {
            moneyDao.insert(money);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void update(Money money) {
        try {
            moneyDao.update(money);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
