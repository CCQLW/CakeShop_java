package servlet;

import model.*;
import service.CartService;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/historical")
public class HistoricalShoppingCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = new CartService();
        List<Cart> cartList = cartService.selectCartsList();
        User user =(User) request.getSession().getAttribute("user");
        int userId= user.getId();
        Goods goods=null;
        Order order = new Order();
        List<OrderItem> itemList=new ArrayList<>();

        GoodsService goodsService=new GoodsService();
        for (int i = 0; i < cartList.size(); i++) {
//            System.out.println(cartList.get(i).getUserId());
//            System.out.println(cartList.get(i));
            Cart carts=cartList.get(i);
            int goodId=carts.getGoodId();
            if(userId==carts.getUserId()){
                goods=goodsService.getGoodsById(goodId);
                order.addGoods(goods);
            }
        }
        request.getSession().setAttribute("order", order);
        //原本跳转到个人中心
        request.getRequestDispatcher("/user_center.jsp").forward(request, response);
        //为测试方便改成跳转到购物车
//        request.getRequestDispatcher("/goods_cart.jsp").forward(request, response);
//        request.getRequestDispatcher("/index").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
