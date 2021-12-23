package servlet;

import model.Evaluation;
import model.Order;
import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.EvaluationService;
import service.OrderService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "evaluation_add",urlPatterns = "/evaluation_add")
public class EvaluationAddServlet extends HttpServlet{
    private EvaluationService EService=new EvaluationService();
    private OrderService oService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Evaluation eval = new Evaluation();
        User u = (User) request.getSession().getAttribute("user");
        if(u==null)
        {
            response.sendRedirect("/index");
            return;
        }
        try {
            BeanUtils.copyProperties(eval, request.getParameterMap());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Order> list = oService.selectAll(u.getId());
        eval.setUid(Integer.parseInt(request.getParameter("uid")));
        if(EService.addEval(eval)) {
            request.setAttribute("msg", "评价成功！");
            request.setAttribute("orderList", list);
            request.getRequestDispatcher("/order_list.jsp").forward(request, response);
        }else {
            request.setAttribute("failMsg", "评价失败！");
            request.setAttribute("u",eval);
            request.setAttribute("orderList", list);
            request.getRequestDispatcher("/order_list.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
