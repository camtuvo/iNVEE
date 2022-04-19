<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp"%>


	<!-- ****** Checkout Area Start ****** -->
	<div class="checkout_area section_padding_100">
		<div class="container">
			<div class="row">

				<div class="col-12 col-md-6">
					<div class="checkout_details_area mt-50 clearfix">

						<div class="cart-page-heading">
							<h5>Thông tin của bạn</h5>

						</div>

						<form:form action="/invee/checkout" method="POST"
							modelAttribute="bill">
							<div class="row">
								<div class="col-12 mb-3" style="display:none;">
									<label>ID khách hàng:</label><form:input type="text"
										class="form-control mb-3" 
										value="${bill.customerid}" path="customerid" />
										<form:input type="text"
										class="form-control mb-3" 
										value="${bill.totalprice+30000}" path="totalprice" />

								</div>
								<div class="col-12 mb-3">
									<label>Họ và tên:</label><input type="text"
										class="form-control mb-3" 
										value="${nameCustomer}" />
										

								</div>
								<div class="col-12 mb-3">
									<label for="phone_number">Số điện thoại:</label> <form:input
										type="text" class="form-control mb-3" path="phone"
										value="${bill.phone}" />
								</div>
								<div class="col-12 mb-4">
									<label for="email_address">Email: </label><form:input type="text"
										class="form-control mb-3" path="email" value="${bill.email}" />

								</div>
								<div class="col-12 mb-3">
									<label for="street_address">Địa chỉ: </label> <form:input
										type="text" class="form-control mb-3" path="deliverto"
										value="${bill.deliverto}" />

								</div>
								<div class="col-12 mb-3">
									<label>Ghi chú: </label> <form:input type="text"
										class="form-control mb-3" path="note" />

								</div>
								<div class="col-12 mb-3">
									<input type="submit" class="btn karl-checkout-btn"
										value="Đặt hàng"/>
								</div>

							</div>

						</form:form>
					</div>
				</div>

				<div class="col-12 col-md-6 ">
					<div class="order-details-confirmation">

						<div class="cart-page-heading">
							<h5>Đơn hàng của bạn</h5>

						</div>

						<ul class="order-details-form mb-4">
							<li><span>Sản phẩm</span> <span>Thành tiền</span></li>
							<c:forEach var="item" items="${ShoppingCart}">
							<li><span>${item.value.product.name}</span> <span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${item.value.product.price}" /> ₫</span></li>
							</c:forEach>
							<li><span>Tổng:</span> <span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${TotalPriceCart}" /> ₫</span></li>
							<li><span>Shipping</span> <span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="30000" /> ₫</span></li>
							<li><span>Tổng cộng:</span> <span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${TotalPriceCart+30000}" /> ₫</span></li>
						</ul>





					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- ****** Checkout Area End ****** -->
