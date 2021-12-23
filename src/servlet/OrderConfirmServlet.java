package servlet;

import model.*;
import org.apache.commons.beanutils.BeanUtils;
import service.CartService;
import service.MoneyService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

//付款成功之后的界面
@WebServlet(name = "order_confirm", urlPatterns = "/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
    private OrderService oService = new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("order");
        User user = (User) request.getSession().getAttribute("user");
        MoneyService moneyService = new MoneyService();
        Money money = moneyService.getMoneyByUserId(user.getId());
        try {
            BeanUtils.copyProperties(order, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        order.setDatetime(new Date());
//        boolean isfail = false;
        if (money.getBalance() >= order.getTotal()) {
            //显示已付款
            request.setAttribute("msg", "订单支付成功！");
            //user扣款
            money.setBalance(money.getBalance() - order.getTotal());
            moneyService.update(money);
            //admin收入
            Money admin=moneyService.getMoneyByUserId(1);
            admin.setBalance(admin.getBalance()+order.getTotal());
            moneyService.update(admin);

            order.setStatus(2);
        }else{
//            isfail=true;
            //显示未付款
//            request.setAttribute("msg", "余额不足！");
            request.setAttribute("msg", "余额不足！  "+"订单支付失败！");
            order.setStatus(1);
        }
        //删除购物车的物品
        CartService cartService=new CartService();
        cartService.deleteUserId(user.getId());

        order.setUser(user);
        oService.addOrder(order);
        //移除在 Session 中的order
        request.getSession().removeAttribute("order");

//        request.setAttribute("msg", "订单支付成功！");

        //更新在 Session 中的money
        request.getSession().setAttribute("money",money);

        request.getRequestDispatcher("/order_success.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
