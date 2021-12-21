package filter;


import model.Count;
import model.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import service.CountService;
import utils.DataSourceUtils;

//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@WebFilter(value = "/*")
//public class CountFilter implements Filter {
//    private ServletContext servletContext;
//    public void destroy() {
//        CountService countService=new CountService();
//        Integer counts= (Integer) servletContext.getAttribute("counts");
//        if(counts!=null) {
////            countService.insert(counts);
////            System.out.println(counts);
//        }
//    }
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        servletContext = request.getServletContext();
//        Integer counts= (Integer) servletContext.getAttribute("counts");
//        if(counts == null){
//            CountService countService=new CountService();
//            counts = (Integer) countService.getCountsByList();
//        }else{
//            counts++;
//        }
//        servletContext.setAttribute("counts",counts);
////        System.out.println("计数"+count);
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//}
