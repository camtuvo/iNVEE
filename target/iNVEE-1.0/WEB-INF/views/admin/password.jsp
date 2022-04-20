<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title> Admin - mật khẩu</title>
<link href="<c:url value='template/admin/css/styles.css' />"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>

</head>
<body class="bg-yellow">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Ghi lại mật khẩu 
										</h3>
								</div>
								<div class="card-body">
									<div class="small mb-3 text-muted">
Nhập email của bạn địa chỉ và chúng tôi sẽ gửi cho bạn một liên kết để đặt lại mật khẩu của bạn.</div>
									<form>
										<div class="form-group">
											<label class="small mb-1" for="inputEmailAddress">Email</label>
											<input class="form-control py-4" id="inputEmailAddress"
												type="email" aria-describedby="emailHelp"
												placeholder="Enter email address" />
										</div>
										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											<a class="small" href="login.html"> Về trang đăng nhập</a> <a
												class="btn btn-primary" href="login.html">Đặt lại mật khẩu</a>
										</div>
									</form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="register.html">Cần một tài khoản? Đăng ký!</a>
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
	<script src="js/scripts.js"></script>
</body>
</html>