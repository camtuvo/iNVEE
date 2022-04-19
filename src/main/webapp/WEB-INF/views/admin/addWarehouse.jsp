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
			<div class="col-lg-8 col-xlg-9 col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <form:form action="/saturdayhigh/admin/warehouse/add/${id}" method="POST"
				modelAttribute="product" class="form-horizontal form-material">
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Size</label>
                                        <div class="col-md-12 border-bottom p-0">
                                             <form:select class="form-control p-0 border-0" path="size">
											
											<c:forEach var="item" items="${size}">
												<form:option value="${item.ID}" label="${item.name}" />
											</c:forEach>

										</form:select>
                                            </div>
                                    </div>
                                   
                                <div class="form-group mb-4">
									<label class="col-md-12 p-0">Số lượng:</label>
									<div class="col-md-12 border-bottom p-0">
										<form:input type="text" class="form-control p-0 border-0"
											path="quantity" />
									</div>
								</div>
                                  
                                    <div class="form-group mb-4">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-dark">OK</button>
                                            <a href="/saturdayhigh/admin/warehouse" class="btn btn-dark">Hủy</a>
                                            
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