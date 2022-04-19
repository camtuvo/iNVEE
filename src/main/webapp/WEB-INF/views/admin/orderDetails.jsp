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
						<div class="col-md-12">
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-12 p-0">#&nbsp;</label> ${bill.ID}
								</div>
							</div>
						</div>
						<div class="col-md-6" style="float: left;">

							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Mã vận đơn:&nbsp;</label>
									${bill.ordernumber}
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0"">
									<label class="col-md-2 p-0"">Khách hàng:&nbsp;</label>
									${infoCustomer.name}
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Số điện thoại:&nbsp;</label>
									${bill.phone}
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Email:&nbsp;</label> ${bill.email}
								</div>
							</div>

							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Địa chỉ giao:&nbsp;</label>
									${bill.deliverto}
								</div>
							</div>

						</div>
						<div class="col-md-6" style="float: right;">
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Tổng tiền:&nbsp; 
									</label><fmt:formatNumber
											type="number" maxFractionDigits="3"
											value="${bill.totalprice}" /> ₫
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Ngày tạo:&nbsp;</label>${bill.createddate}
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Ngày xác nhận:&nbsp;</label>
									${bill.modifieddate}
								</div>
							</div>
							<div class="form-group mb-4">
								<div class="col-md-12 border-bottom p-0">
									<label class="col-md-2 p-0">Xác nhận bởi:&nbsp;</label>
									${bill.modifiedby}
								</div>
							</div>
						</div>
						<table class="table text-nowrap">
							<thead>
								<tr>
									<th class="border-top-0">#</th>
									<th class="border-top-0">Tên sản phẩm</th>
									<th class="border-top-0">Size</th>
									<th class="border-top-0">Số lượng</th>
									<th class="border-top-0">Giá</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${ productDetais }">
									<tr>
										<td>${ item.ID }</td>
										<td>${ item.name }</td>
										<td>${ item.size }</td>
										<td>${ item.quantity }</td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${item.price}" /> ₫</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

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