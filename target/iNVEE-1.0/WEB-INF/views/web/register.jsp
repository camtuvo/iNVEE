<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

	<div class="checkout_details_area mt-50 clearfix">


		<div class="order-details-confirmation">
			<div class="cart-page-heading">
				<h5>Đăng ký</h5>
				<p>Vui lòng nhập đầy đủ thông tin của bạn!</p>
			</div>


			<form:form action="/invee/account/register" method="POST"
				modelAttribute="user">
				<div class="row">
					<div class="col-12 col-lg-6">
						<div class="col-12 mb-4">
							<label for="name">Họ và tên</label>
							<form:input type="text" class="form-control" id="name"
								path="name"
								pattern="^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$" />
						</div>

						<div class="col-12 mb-4">
							<label for="birthday">Ngày sinh<span>*</span></label>
							<form:input type="date" class="form-control" id="birthday"
								path="birthday" />
						</div>

						<div class="col-12 mb-4">
							<label for="gender">Giới tính <span>*</span></label>

							<form:select class="custom-select d-block w-100" id="gender"
								path="gender">

								<form:option value="0" label="Nam" />
								<form:option value="1" label="Nữ" />
								<form:option value="2" label="Khác" />
							</form:select>
						</div>
						<div class="col-12 mb-4">
							<label for="address">Địa chỉ</label>

							<form:input type="text" class="form-control" id="adress"
								path="address" />
						</div>

						<div class="col-12 mb-4">
							<label for="phone">Số điện thoại</label>

							<form:input type="text" class="form-control" id="phone"
								path="phone" pattern="^[0-9]{10}$" />
						</div>

						<div class="col-12 mb-4">
							<label for="email">Email<span>*</span></label>

							<form:input type="email" class="form-control" id="email_address"
								path="email"
								pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" />
						</div>
					</div>

					<div class="col-12 col-lg-6">
						<div class="col-12 mb-4">
							<label for="uername">tên Đăng nhập<span>*</span></label>

							<form:input type="text" class="form-control" id="username"
								path="username" pattern="^[a-z0-9_-]{3,50}$" />
						</div>

						<div class="col-12 mb-4">
							<label for="password">Mật khẩu<span>*</span></label>

							<form:input type="password" class="form-control" id="psw"
								path="password"
								 />
						</div>

						<div class="col-12 mb-4">
							<input type="submit" class="btn karl-checkout-btn"
								value="Đăng ký" />

						</div>
					</div>

				</div>
			</form:form>
		</div>
	</div>
	<br>
	<br>