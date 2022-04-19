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
					<h2 class="box-title">Danh sách nhân viên</h2>
					
					<div class="table-responsive">
						
						<table class="table text-nowrap">
							<thead>
								<tr>
									<th class="border-top-0">#</th>
									<th class="border-top-0">Tên</th>
									<th class="border-top-0">Email</th>
									<th class="border-top-0">Số điện thoại</th>
							<th class="border-top-0">Trạng thái</th>
									<th class="border-top-0"></th>
									<th class="border-top-0"></th>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${ employee }">
									<tr>
										<td>${ item.ID }</td>
										<td>${ item.name }</td>
										<td>${item.email}</td>
										<td>${ item.phone }</td>
										<td><c:if test="${ item.status == 1 }">Kích hoạt</c:if>
										<c:if test="${ item.status == 0 }">Chưa kích hoạt</c:if>
										</td>
										<td><a href="/saturdayhigh/admin/employee-details/${item.ID}"><i class="fas fa-eye" aria-hidden="true"></i></a></td>
										<td><a href="/saturdayhigh/admin/active/${item.ID}"><c:if test="${ item.status == 0 }">Kích hoạt</c:if></a></td>
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