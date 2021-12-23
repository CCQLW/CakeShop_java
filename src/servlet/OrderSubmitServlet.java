package servlet;

import model.Money;
import model.User;
import service.MoneyService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order_submit", urlPatterns = "/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");

            MoneyService moneyService = new MoneyService();
            Money money = moneyService.getMoneyByUserId(user.getId());
            //更新余额
            request.getSession().setAttribute("money", money);
            //跳转到确认支付界面
            request.getRequestDispatcher("/order_submit.jsp").forward(request, response);
        } else {
            request.setAttribute("failMsg", "请登录后，再提交订单！");
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }
    }
}
