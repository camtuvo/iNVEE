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
<h2 class="box-title">Kho</h2>
					<div class="table-responsive">
						
						<table class="table text-nowrap">
							<thead>
								<tr>
									<th class="border-top-0">#</th>
									<th class="border-top-0">Thương hiệu</th>
									<th class="border-top-0">Danh mục</th>
									<th class="border-top-0">Tên</th>
									

									
									<th class="border-top-0">Trạng thái</th>
								
									<th class="border-top-0"></th>
									<th class="border-top-0"></th>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${ products }">
									<tr>
										<td>${ item.ID }</td>
										<td>${ item.brand }</td>
										<td>${ item.category }</td>
										<td>${ item.name }</td>
										<td><c:if test="${item.status == 1 }">Hiển thị</c:if> <c:if
												test="${item.status == 0 }">Ẩn</c:if></td>
										<td><a class=""
											href="<c:url value="warehouse/add/${item.ID}" />"><i
												class="fas fa-plus-circle" aria-hidden="true"></i> </a>
										<td><a href="/saturdayhigh/admin/product-detail/${item.ID}">Xem chi tiết</a></td>
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