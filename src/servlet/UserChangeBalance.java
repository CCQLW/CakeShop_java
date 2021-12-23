package servlet;


import model.Money;
import model.User;
import service.MoneyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user_change_balance")
public class UserChangeBalance extends HttpServlet {

    MoneyService moneyService = new MoneyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        float balance= Float.parseFloat(request.getParameter("balance"));
        if(balance<0){
            request.setAttribute("msg", "余额信息更新失败！");
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }else{
            Money money=new Money(user.getId(),balance);
            moneyService.update(money);
            request.getSession().setAttribute("money",money);

            request.setAttribute("msg", "余额信息更新成功！");
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
