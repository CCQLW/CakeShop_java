package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/showcount")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ServletContext servletContext=req.getServletContext();
        Integer count= (Integer) servletContext.getAttribute("counts");
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='utf-8'>");
        printWriter.println("<title>总访问次数</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1 align=\"center\"> 总共访问次数"+count+"</h1>");
        printWriter.println("</body>");
        printWriter.println("</html>");
//        System.out.println("show"+count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
