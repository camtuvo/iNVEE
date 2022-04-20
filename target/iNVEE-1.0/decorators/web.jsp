<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Invee</title>

<!-- Favicon  -->
<link rel="icon"
	href="<c:url value='/template/web/img/core-img/favicon.ico'/>">

<!-- Core Style CSS -->
<link rel="stylesheet"
	href="<c:url value='/template/web/css/core-style.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/style.css'/>">

<!-- Responsive CSS -->
<link href="<c:url value='/template/web/css/responsive.css'/>"
	rel="stylesheet">

</head>
<body>
	<div id="wrapper">
		<!-- ****** Header Area Start ****** -->
		<%@ include file="/common/web/header.jsp"%>
<!-- ****** Header Area End ****** -->
		<dec:body />


		<!-- ****** Footer Area Start ****** -->
		<%@ include file="/common/web/footer.jsp"%>
		<!-- ****** Footer Area End ****** -->

	</div>
	<!-- /.wrapper end -->
	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="<c:url value='/template/web/js/jquery/jquery-2.2.4.min.js'/>"></script>
	<!-- Popper js -->
	<script src="<c:url value='/template/web/js/popper.min.js'/>"></script>
	<!-- Bootstrap js -->
	<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
	<!-- Plugins js -->
	<script src="<c:url value='/template/web/js/plugins.js'/>"></script>
	<!-- Active js -->
	<script src="<c:url value='/template/web/js/active.js'/>"></script>
	<dec:getProperty property="page.script"></dec:getProperty>
</body>
</html>