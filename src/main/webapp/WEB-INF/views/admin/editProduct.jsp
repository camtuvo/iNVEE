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
					<h2 class="box-title">Cập nhật sản phẩm</h2>
					<div class="table-responsive">
						<form:form action="/invee/admin/product/edit/${currentProduct.ID}" method="POST"
							modelAttribute="currentProduct"
							class="form-horizontal form-material">
							<div class="col-md-6" style="float: left;">

								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Tên:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:input type="text" class="form-control p-0 border-0"
											path="name" />
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0"">Thương hiệu:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0"">

										<form:select class="form-control p-0 border-0" path="brand">

											<c:forEach var="item" items="${brand}">
												<form:option value="${item.ID}" label="${item.name}" />
											</c:forEach>

										</form:select>
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Danh mục:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:select class="form-control p-0 border-0" path="category">

											<c:forEach var="item" items="${category}">
												<form:option value="${item.ID}" label="${item.name}" />
											</c:forEach>


										</form:select>
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Giá nhập:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0" style="float: left'">
										<form:input type="text" class="form-control p-0 border-0"
											path="importprice" value="${item.importprice}" />
									</div>

								</div>
								<div class="form-group mb-4">
									</br> </br> <label class="col-md-12 p-0">Giá bán:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0" style="float: left;'">
										<form:input type="text" class="form-control p-0 border-0"
											path="price" value="${item.price}" />
									</div>

								</div>

								<div class="form-group mb-4">
									</br> </br> <label class="col-md-12 p-0">Mô tả:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:textarea type="text" class="form-control p-0 border-0"
											path="description" />
									</div>
								</div>

							</div>
							<div class="col-md-6" style="float: right;">
								<div class="form-group mb-4 image-preview" id="imagePreview"
									style="text-align: center;">

									<img
										src="<c:url value='/template/admin/plugins/images/default/default-img.jpg'/>"
										height=400 with=300 alt="" class="image-preview__image">

								</div>
								<div class="form-group mb-4" style="text-align: center;">
									<form:input type="file" id="inputFile" path="photo" />

								</div>

							</div>

							<div class="col-md-12" style="float: left;">
								<button type="submit" class="btn btn-dark">OK</button>
								<a href="/invee/admin/product" class="btn btn-dark">Hủy</a>

							</div>

						</form:form>

					</div>
				</div>
			</div>
			<content tag="script"> <script>
				// get img to show when user click choose file
				const inputFilea = document.getElementById('inputFile');
				const previewContainer = document
						.getElementById('imagePreview');
				const previewImage = previewContainer
						.querySelector(".image-preview__image");

				inputFilea
						.addEventListener(
								"change",
								function() {
									const file = this.files[0];

									if (file) {

										const reader = new FileReader();
										const path = "<c:url value='/template/web/img/product-img/'/>";
										console.log(file);
										previewImage.setAttribute("src", path
												+ file.name);

										/*  reader.addEventListenter("load", function(){
											previewImage.setAttribute("src",path);
										}); 
										 */
										reader.readAsDataURL(file);
									}
								});
			</script> </content>
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