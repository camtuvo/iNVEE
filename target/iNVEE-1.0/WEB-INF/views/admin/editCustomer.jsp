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
					<h2 class="box-title">Cập nhật khách hàng</h2>
					<div class="table-responsive">
						<form:form
							action="/invee/admin/customer/edit/${currentCustomer.ID}"
							method="POST" modelAttribute="currentCustomer"
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
									<label class="col-md-12 p-0"">Email:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0"">
										<form:input type="text" class="form-control p-0 border-0"
											path="email" />

									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0"">Số điện thoại:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0"">
										<form:input type="text" class="form-control p-0 border-0"
											path="phone" />

									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0"">Địa chỉ:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0"">
										<form:input type="text" class="form-control p-0 border-0"
											path="address" />

									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0"">Ngày sinh:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0"">
										<form:input type="text" class="form-control p-0 border-0"
											path="birthday" />

									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Giới tính:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:select class="form-control p-0 border-0" path="gender">
											<form:option value="0" label="Nam" />
											<form:option value="1" label="Nữ" />
											<form:option value="2" label="Khác" />
										</form:select>
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Trạng thái:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:select class="form-control p-0 border-0" path="status">
											<form:option value="0" label="Ẩn" />
											<form:option value="1" label="Hiện" />
										</form:select>
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
								<a href="/invee/admin/customer" class="btn btn-dark">Hủy</a>

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