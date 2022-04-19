<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Admin | SaturdayHigh</title>
<link href="<c:url value='/template/admin/dist/css/styles.css'/>"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>


</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">SaturdayHigh</h3>
								</div>
								<div class="card-body">
									<form:form action="/saturdayhigh/admin/login" method="POST"
										modelAttribute="user">
										<div class="form-group">
											<label class="small mb-1">Tài khoản</label>

											<form:input type="text" class="form-control" id="username"
												path="username" pattern="^[a-z0-9_-]{3,50}$" />
										</div>
										<div class="form-group">
											<label class="small mb-1">Password</label>
											<form:input class="form-control" id="inputPassword"
												type="password" path="password"
												 />
										</div>

										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											<a class="small">Quên mật khẩu?</a> <input type="submit"
												class="btn btn-primary" value="Đăng nhập" />
										</div>
									</form:form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="/saturdayhigh/admin/register">Bạn cần tài khoản?
											Đăng ký!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin/js/scripts.js' />"></script>
</body>
</html>