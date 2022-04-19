<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
    <meta name="description"
        content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>iNVEE | Admin</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/template/admin/plugins/images/favicon.png' />">
    <!-- Custom CSS -->
    <link href="<c:url value='/template/admin/plugins/bower_components/chartist/dist/chartist.min.css' />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/template/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css' />">
    <!-- Custom CSS -->
    <link href="<c:url value='/template/admin/css/style.min.css' />" rel="stylesheet">
</head>

<body>
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<dec:body />
	<!-- footer -->
	<%@ include file="/common/admin/footer.jsp"%>
	
	
	<script src="<c:url value='/template/admin/plugins/bower_components/jquery/dist/jquery.min.js' />"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script href="<c:url value='/template/admin/bootstrap/dist/js/bootstrap.bundle.min.js' />"></script>
    <script href="<c:url value='/template/admin/js/app-style-switcher.js' />"></script>
    <script href="<c:url value='/template/admin/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js' />"></script>
    <!--Wave Effects -->
    <script href="<c:url value='/template/admin/js/waves.js' />"></script>
    <!--Menu sidebar -->
    <script href="<c:url value='/template/admin/js/sidebarmenu.js' />"></script>
    <!--Custom JavaScript -->
    <script href="<c:url value='/template/admin/js/custom.js' />"></script>
    <!--This page JavaScript -->
    <!--chartis chart-->
    <script href="<c:url value='/template/admin/plugins/bower_components/chartist/dist/chartist.min.js' />"></script>
    <script href="<c:url value='/template/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js' />"></script>
    <script href="<c:url value='/template/admin/js/pages/dashboards/dashboard1.js' />"></script>
    <dec:getProperty property="page.script"></dec:getProperty>
</body>


</html>