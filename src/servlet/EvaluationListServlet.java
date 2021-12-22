package servlet;

import model.Evaluation;
import model.Page;
import model.Type;
import org.apache.commons.beanutils.BeanUtils;
import service.EvaluationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "evaluation_add",urlPatterns = "/evaluation/add")
public class EvaluationListServlet extends HttpServlet{
    private EvaluationService EService=new EvaluationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = 0;
//        if (request.getParameter("typeid") != null) {
//            id = Integer.parseInt(request.getParameter("typeid"));
//        }
//        int pageNumber = 1;
//        if (request.getParameter("pageNumber") != null) {
//            try {
//                pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
//            } catch (Exception e) {
//
//            }
//
//        }
//        Evaluation t = null;
//        if (id != 0) {
//            t = EService.selectById(id);
//        }
//        request.setAttribute("t", t);
//        //List<Goods> list=gService.selectGoodsByTypeID(id,1,8);
//        //request.setAttribute("goodsList",list);
//        if (pageNumber <= 0)
//            pageNumber = 1;
//        Page p = EService.selectPageByTypeID(id, pageNumber);
//
//        if (p.getTotalPage() == 0) {
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        } else {
//            if (pageNumber >= p.getTotalPage() + 1) {
//                p = gService.selectPageByTypeID(id, p.getTotalPage());
//            }
//        }
//
//        request.setAttribute("p", p);
//        request.setAttribute("id", String.valueOf(id));
//        request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
    }
}
