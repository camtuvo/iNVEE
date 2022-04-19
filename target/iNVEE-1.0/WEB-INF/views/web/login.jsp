<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<br>
<br>
<br>
<br>
<div class="contact_area">
	<div class="container">
		<div class="row">
			<div class="col-12  col-lg-6">
				<div class="cart-page-heading">
					<h2>ĐĂNG NHẬP</h2>
					<p>${ Statuslogin }</p>
				</div>
			</div>
			<div class="col-12 col-lg-6">
				<div class="checkout_details_area">
					<form:form action="/invee/account/login" method="POST"
						modelAttribute="user">
						<div class="row">
							<div class="col-12 mb-4">
								<label for="uername">Tên đăng nhập<span>*</span></label>
								<form:input type="text" class="form-control" id="username"
									path="username" pattern="^[a-z0-9_-]{3,50}$" />
							</div>
							<div class="col-12 mb-4">
								<label for="password">Mật khẩu<span>*</span></label>
								<form:input type="password" class="form-control" id="psw"
									path="password" />
							</div>
							<div class="col-12 mb-4">

								<input type="submit" class="btn karl-checkout-btn"
									value="Đăng nhập" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>
<br>
<br>