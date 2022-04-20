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
<title>Admin | Đăng kí</title>
<link href="<c:url value='/template/admin/dist/css/styles.css'/>"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>


</head>
<body class="bg-re">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Đăng ký tài
										khoản</h3>
								</div>
								<div class="card-body">
									<form:form action="/invee/admin/register" method="POST"
										modelAttribute="user">
										<div class="form-row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="small mb-1" for="inputFirstName">Họ
														và tên</label>
													<form:input type="text" class="form-control py-4"
														path="name"
														pattern="^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$" />
												</div>
											</div>

										</div>
										<div class="form-group">
											<label class="small mb-1" for="inputEmailAddress">Email</label>
											<form:input class="form-control py-4" id="inputEmailAddress"
												type="email" path="email"
												pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" />
										</div>
										<div class="form-row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputEmailAddress">Ngày
														sinh</label>
													<form:input type="date" class="form-control py-4"
														id="birthday" path="birthday" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputEmailAddress">Giới
														tính</label>
													<form:select class="custom-select d-block w-100"
														id="gender" path="gender" style="height:50px;">

														<form:option value="0" label="Nam" />
														<form:option value="1" label="Nữ" />
														<form:option value="2" label="Khác" />
													</form:select>
												</div>
											</div>
										</div>
										<div class="form-row">
											<div class="col-md-12">
												<div class="form-group">
													<label class="small mb-1" for="inputFirstName">Địa
														chỉ</label>
													<form:input type="text" class="form-control py-4"
														path="address" />
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="small mb-1" for="inputFirstName">Số
														điện thoại</label>
													<form:input type="number" class="form-control py-4"
														path="phone" pattern="^[0-9]{10}$" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputFirstName">Tên
														đăng nhập</label>
													<form:input type="text" class="form-control py-4"
														path="username" pattern="^[a-z0-9_-]{3,50}$" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputPassword">Mật Khẩu</label>
													<input class="form-control py-4" id="inputPassword"
														type="password" path="password" />
												</div>
											</div>

										</div>
										<div class="form-group mt-4 mb-0">
											<input class="btn btn-b btn-block" type="submit"
												value="Tạo Tài Khoản" />
										</div>
									</form:form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="/invee/admin/login">
Có một tài khoản? Đi đến đăng nhập</a>
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