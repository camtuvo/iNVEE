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
								<label class="col-md-12 p-0">#&nbsp;${product.ID}</label>

								<div class="col-md-12 border-bottom p-0"></div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Tên:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.name}</div>
							</div>
							<div class="form-group mb-4" >
								<label class="col-md-6 p-0" ">Thương
									hiệu:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0" ">${product.brand}</div>
							</div>
							<div class="form-group mb-4" >
								<label class="col-md-6 p-0">Danh
									mục:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.category}</div>
							</div>
							<c:if test="${LoginInforOfAdmin.isadmin == '2'}">
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Giá nhập:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0"><fmt:formatNumber type="number" maxFractionDigits="3"
													value="${product.importprice}" />
												₫</div>
							</div>
							</c:if>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Giá bán:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0"><fmt:formatNumber type="number" maxFractionDigits="3"
													value="${product.price}" />
												₫</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Mô tả:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.description}</div>
							</div>
							
						</div>
						<div class="col-md-6" style="float: right;">
							<div class="form-group mb-4" style="text-align: center;">
								<img src="<c:url value='/template/web/img/product-img/${ product.photo }'/>" style="height:400px;width:350px;"  alt="${product.photo }" >
							</div>
						</div>
						<table class="table text-nowrap">
							<thead>
								<tr>
									<th class="border-top-0">Size</th>
									<th class="border-top-0">Số lượng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${ productdetails }">
									<tr>
										<td>${ item.size }</td>
										<td>${ item.quantity }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="form-group mb-4">
								<label class="col-md-12 p-0">Ngày tạo:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.createddate}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Tạo bởi:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.createdby}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Ngày thay đổi:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.modifieddate}</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0">Thay đổi bởi:&nbsp;</label>
								<div class="col-md-12 border-bottom p-0">${product.modifiedby}</div>
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