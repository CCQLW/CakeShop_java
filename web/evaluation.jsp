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


        <h2>商品评价</h2>
        <c:if test="${!empty failMsg }">
            <div class="alert alert-danger">${failMsg }</div>
        </c:if>
        <form class="form-horizontal" action="/evaluation_add?uid=${user.id}" method="post">
            <div class="form-group">
                <label for="input_name" class="col-sm-1 control-label">商品编号</label>
                <div class="col-sm-6">
                    <input  type="text" class="form-control" id="input_name" name="gid" value="${good.id}" readonly />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">商品名称</label>
                <div class="col-sm-6">
                    <input disabled="disabled" type="text" class="form-control" value="${good.name}" readonly />
                </div>
            </div>
            <div class="form-group">
                <label for="input_name" class="col-sm-1 control-label">评价内容</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="input_name" name="eval" value="${e.eval }"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit">提交保存</button>
                </div>
            </div>
        </form>

    </div>
</div>
<!--//cart-items-->


<!--footer-->
<jsp:include page="footer.jsp"></jsp:include>
<!--//footer-->


</body>
</html>