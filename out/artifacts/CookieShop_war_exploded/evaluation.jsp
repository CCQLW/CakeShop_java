<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>我的订单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
</head>
<body>


<!--header-->
<jsp:include page="header.jsp">
    <jsp:param name="flag" value="5"></jsp:param>
</jsp:include>
<!--//header-->


<!--cart-items-->
<div class="cart-items">
    <div class="container">


        <h2>我的订单</h2>

        <table>

            <%--            <c:forEach items="${orderList }" var="order">--%>
            <tr>
                <td>要评价的商品</td>
                <td>
                    <div>
                        <select class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    输入评价
                </td>
                <td>
                    <div>
<%--                        <input type="text" class="form-control" placeholder="Text input">--%>
                        <textarea class="form-control" rows="3"></textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="register-but text-center">
                        <input type="submit" value="提交">
                        <div class="clearfix"></div>
                    </div>
                </td>
            </tr>
            <%--            </c:forEach>--%>

        </table>

    </div>
</div>
<!--//cart-items-->


<!--footer-->
<jsp:include page="footer.jsp"></jsp:include>
<!--//footer-->


</body>
</html>