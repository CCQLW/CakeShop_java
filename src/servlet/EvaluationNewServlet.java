package servlet;

import model.Evaluation;
import model.Goods;
import org.apache.commons.beanutils.BeanUtils;
import service.EvaluationService;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "evaluation_new",urlPatterns = "/evaluation_new")
public class EvaluationNewServlet extends HttpServlet{
    private GoodsService gService=new GoodsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        Goods good = gService.getGoodsByName(name);
        String id=good.getId()+"";
        request.setAttribute("good",good);
        request.getRequestDispatcher("/evaluation.jsp").forward(request, response);
    }
}
