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
					<h2 class="box-title">Thêm mới slider</h2>
					<div class="table-responsive">
						<form:form action="/invee/admin/slider/add" method="POST"
							 modelAttribute="slide"
							class="form-horizontal form-material">
							<div class="col-md-6" style="float: left;">

								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Tiêu đề:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:input type="text" class="form-control p-0 border-0"
											path="caption" />
									</div>
								</div>
								<div class="form-group mb-4">
									</br> </br> <label class="col-md-12 p-0">Nội dung:&nbsp;</label>
									<div class="col-md-12 border-bottom p-0">
										<form:textarea type="text" class="form-control p-0 border-0"
											path="content" />
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
									<form:input type="file" name ="file" id="inputFile" path="photo" />

								</div>

							</div>

							<div class="col-md-12" style="float: left;">
								<button type="submit" class="btn btn-dark">OK</button>
								<a href="/invee/admin/slider" class="btn btn-dark">Hủy</a>

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