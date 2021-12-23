package servlet;

import model.Evaluation;
import model.Goods;
import service.EvaluationService;
import service.GoodsService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "goods_detail",urlPatterns = "/goods_detail")
public class GoodsDetailServlet extends HttpServlet {

    private GoodsService gService = new GoodsService();
    private EvaluationService eService =new EvaluationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods g = gService.getGoodsById(id);
        List<Evaluation> eval=eService.selectEvaluationList(id);
        System.out.println(id);
        request.setAttribute("g", g);
        request.setAttribute("elist",eval);
        request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
    }
}
