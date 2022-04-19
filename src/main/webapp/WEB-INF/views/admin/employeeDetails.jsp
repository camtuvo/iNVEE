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
			<div class="col-sm-12">
				<div class="white-box">

					<div class="table-responsive">
						<div class="col-md-6" style="float: left;">
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">#&nbsp;${employee.ID}</label>

								<div class="col-md-12 border-bottom p-0"></div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Tên:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.name}</div>
							</div>
							<div class="form-group mb-4" >
								<label class="col-md-6 p-0" ">Email:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0" ">${employee.email}</div>
							</div>
							<div class="form-group mb-4" >
								<label class="col-md-6 p-0">Số điện thoại:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.phone}</div>
							</div>
							
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Địa chỉ:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.address}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Ngày sinh:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.birthday}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Giới tính:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0"><c:if test="${employee.gender == 0 }">Nam</c:if>
								<c:if test="${employee.gender == 1 }">Nữ</c:if>
								<c:if test="${employee.gender == 2 }">Khác</c:if>
								</div>
							</div>
							
						</div>
						<div class="col-md-6" style="float: right;">
							<div class="form-group mb-4" style="text-align: center;">
								<img src="<c:url value='/template/web/img/core-img/person.png'/>" height=400 with=300 alt="${employee.photo }" >
							</div>
						</div>
						
						<div class="form-group mb-4">
								<label class="col-md-12 p-0">Ngày tạo:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.createddate}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Tạo bởi:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.createdby}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Ngày thay đổi:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.modifieddate}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Thay đổi bởi:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${employee.modifiedby}</div>
							</div>
					</div>
				</div>
			</div>
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