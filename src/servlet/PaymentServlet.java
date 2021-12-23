package servlet;

import model.Money;
import model.Order;
import model.User;
import service.MoneyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/payment")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getSession().getAttribute("user");
//        Order order = (Order) request.getSession().getAttribute("order");
//        MoneyService moneyService = new MoneyService();
//        Money money = moneyService.getMoneyByUserId(user.getId());
//        if (money.getBalance() >= order.getTotal()) {
////            request.setAttribute("msg", "订单支付成功！");
//            money.setBalance(money.getBalance() - order.getTotal());
//            moneyService.update(money);
//            request.getRequestDispatcher("/order_confirm").forward(request, response);
//        } else {
//            request.setAttribute("msg", "余额不足！");
//            //跳转到付款失败
//            request.getRequestDispatcher("/fail").forward(request, response);
//            //购物车
////            request.getRequestDispatcher("/goods_cart.jsp").forward(request, response);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
