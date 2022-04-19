<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


	<!-- ****** Cart Area Start ****** -->
	<div class="cart_area section_padding_100 clearfix">
		<div class="container">
			<div class="row">
			<c:if test="${not empty status }">
			<div class="col-12" style="color:#ff084e;">*${status}</div></c:if>
				<div class="col-12">
					<div class="cart-table clearfix">
						<table class="table table-responsive">
							<thead>
								<tr>
									<th>Product</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="cart_product_img d-flex align-items-center"></td>
									<td class="price"></td>
									<td class="qty"></td>
									<td class="total_price"></span></td>
									<td class="update_and_delete"></td>
								</tr>


								<c:forEach var="item" items="${ShoppingCart}">
									<tr>
										<td class="cart_product_img d-flex align-items-center"><a
											href="#"><img
												src="<c:url value='/template/web/img/product-img/${item.value.product.photo}'/>"
												alt="Product"></a>
											<h6>${item.value.product.name}x
												${item.value.product.size}</h6></td>
										<td class="price"><span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${item.value.product.price}" /> ₫</span></td>
										<td class="qty">
											<span>${item.value.quantity}</span>
										</td>
										<td class="total_price"><span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${item.value.totalPrice}" /> ₫</span></td>
										<td class="delete_product"><a
											href="<c:url value="/cart/delete-cart/id=${item.key}" />">
												Xóa </a></td>
									</tr>
								</c:forEach>




							</tbody>
						</table>
					</div>

					<div class="cart-footer d-flex mt-30">
						<div class="back-to-shop w-50">
							<a href="/invee/product">Tiếp tục mua sắm</a>
						</div>
						<div class="update-checkout w-50 text-right">
							<a href="#">Xóa hết</a>
						</div>
					</div>

				</div>
			</div>

			<div class="row">
				
				<div class="col-12 col-md-6 col-lg-6">
					
				</div>
				<div class="col-12 col-lg-6">
					<div class="cart-total-area mt-70">
						<div class="cart-page-heading">
							<h5>Giỏ hàng của bạn</h5>
							<p>Thông tin</p>
						</div>

						<ul class="cart-total-chart">
							<li><span>Tổng</span> <span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${TotalPriceCart}" /> ₫</span></li>
							<li><span>Shipping</span> <span><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="30000" /> ₫</span></li>
							<li><span><strong>Tổng cộng</strong></span> <span><strong><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${TotalPriceCart+30000}" /> ₫</strong></span></li>
						</ul>
						<a href="/invee/checkout" class="btn karl-checkout-btn">Tiến hành thanh toán</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ****** Cart Area End ****** -->

