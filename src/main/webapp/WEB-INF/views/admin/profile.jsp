<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="page-wrapper">
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Container fluid  -->
	<!-- ============================================================== -->
	<div class="container-fluid">
		<!-- ============================================================== -->
		<!-- Start Page Content -->
		<!-- ============================================================== -->
		<div class="row">
			<!-- Column -->
			<div class="col-lg-4 col-xlg-3 col-md-12">
				<div class="white-box">
					<div class="user-bg" style="height: 400px;">
						<img width="100%" alt="user"
							src="<c:url value='/template/admin/plugins/images/default/person.png'/>">

					</div>

				</div>
			</div>
			<!-- Column -->
			<!-- Column -->
			<div class="col-lg-8 col-xlg-9 col-md-12">
				<div class="card">
				
					<div class="card-body">
					<p>${Status}</p>
						<form:form action="/saturdayhigh/admin/profile/edit" method="POST"
							modelAttribute="employee" class="form-horizontal form-material">
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Họ và tên</label>
								<div class="col-md-12 border-bottom p-0">
									<form:input type="text" path="name" value="${currentEmployee.name}" class="form-control p-0 border-0"/>
								</div>
							</div>
							<div class="form-group mb-4">
								<label for="example-email" class="col-md-12 p-0">Email</label>
								<div class="col-md-12 border-bottom p-0">
									<form:input type="email"
										class="form-control p-0 border-0" value="${currentEmployee.email}" path="email"/>
								</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Điện thoại</label>
								<div class="col-md-12 border-bottom p-0">
									<form:input type="phone" value="${currentEmployee.phone}"
										class="form-control p-0 border-0" path="phone"/>
								</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Địa chỉ</label>
								<div class="col-md-12 border-bottom p-0">
									<form:input type="text" value="${currentEmployee.address}"
										class="form-control p-0 border-0" path="address"/>
								</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-sm-12">Ngày sinh</label>
								<div class="col-md-12 border-bottom p-0">
									<form:input type="text" value="${currentEmployee.birthday}"
										class="form-control p-0 border-0" path="birthday"/>
								</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-sm-12">Giới tính</label>
								<div class="col-md-12 border-bottom p-0">
									<form:select class="form-control p-0 border-0" value="${currentEmployee.gender}" path="gender">

											
												<form:option value="0" label="Nam" />
												<form:option value="1" label="Nữ" />
												<form:option value="2" label="Khác" />
											

										</form:select>
								</div>
							</div>
					</div>



				</div>
				<div class="form-group mb-4">
					<div class="col-sm-12">
						<button class="btn btn-success">Update Profile</button>
					</div>
				</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- Column -->
</div>
<!-- ============================================================== -->
<!-- End PAge Content -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Right sidebar -->
<!-- ============================================================== -->
<!-- .right-sidebar -->
<!-- ============================================================== -->
<!-- End Right sidebar -->
<!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- End Container fluid  -->