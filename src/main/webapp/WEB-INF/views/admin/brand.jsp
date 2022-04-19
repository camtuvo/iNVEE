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
					<h2 class="box-title">Thương hiệu</h2>
					<p>${Status}</p>
					<div class="table-responsive">
						<a href="<c:url value="brand/add"/>">
							<button class="btn btn-cyan">
								<i class="fas fa-plus" aria-hidden="true"></i> <span
									class="hide-menu">Thêm mới</span>
							</button>
						</a>
						<table class="table text-nowrap">
							<thead>
								<tr>
									<th class="border-top-0">#</th>
									<th class="border-top-0">Tên</th>
									<th class="border-top-0">Trạng thái</th>
									<th class="border-top-0">Ngày tạo</th>
									<th class="border-top-0">Tạo bởi</th>
									<th class="border-top-0">Ngày thay đổi</th>
									<th class="border-top-0">Thay đổi bởi</th>
									<th class="border-top-0"></th>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${ brands }">
									<tr>
										<td>${ item.ID }</td>
										<td>${ item.name }</td>
										<td><c:if test="${item.status == 1 }">Hiển thị</c:if> <c:if
												test="${item.status == 0 }">Ẩn</c:if></td>
										<td>${ item.createddate }</td>
										<td>${ item.createdby }</td>
										<td>${ item.modifieddate }</td>
										<td>${ item.modifiedby }</td>
										<td><a class=""
											href="<c:url value="brand/edit/${item.ID}" />"><i
												class=" far fa-edit" aria-hidden="true"></i> </a> <a class=""
											href="<c:url value="brand/delete/${item.ID}" />"><i
												class="fas fa-trash-alt" aria-hidden="true"></i> </a></td>
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