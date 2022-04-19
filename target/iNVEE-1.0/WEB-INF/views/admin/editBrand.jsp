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
					<h2 class="box-title">Cập nhật thương hiệu</h2>
					<div class="">
						<form:form action="/saturdayhigh/admin/brand/edit/${currentBrand.ID}" method="POST"
							modelAttribute="brand" class="form-horizontal form-material">
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Tên</label>
								<div class="col-md-12 border-bottom p-0">
									<form:input type="text" class="form-control p-0 border-0"
										path="name" value="${currentBrand.name}" />
								</div>
							</div>


							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Trạng thái</label>
								<div class="col-md-12 border-bottom p-0">
									<%-- <form:input type="radio" class="form-control p-0 border-0"
										path="status"  value="1"/>
									<label>Hiển thị</label>
									<br>
									<form:input  class="form-control p-0 border-0"
										path="status" type="radio" value="0"/>
										<label>Ẩn</label> --%>
									<form:select class="form-control p-0 border-0" path="status">
										
										<form:option id="show" value="0" label="Ẩn" />
										<form:option id="hide" value="1" label="Hiển thị" />


									</form:select>
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-dark">OK</button>
									<a href="/saturdayhigh/admin/brand" class="btn btn-dark">Hủy</a>

								</div>
							</div>
						</form:form>


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