<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- ****** Header Area Start ****** -->
<header class="header_area">
    <!-- Top Header Area Start -->
    <div class="top_header_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center justify-content-end">
                <div class="col-4 col-lg-7">
                    <div class="top_single_area d-flex align-items-center">

                        <!-- Cart & Menu Area -->
                        <div class="header-cart-menu d-flex align-items-center ml-auto">
                            <!-- Cart Area -->
                            <div class="cart">
                                <a href="#" id="header-cart-btn" target="_blank">
                                    <span class="cart_quantity">
                                        <c:if test="${ not empty TotalQuantityCart}">${TotalQuantityCart}</c:if>
                                        <c:if test="${ empty TotalQuantityCart}">0</c:if> 
                                        </span> 
                                        <i class="ti-bag"></i> 
                                    </a>
                                    <!-- Cart List Area Start -->
                                    <ul class="cart-list">
                                    <c:forEach var="item" items="${ShoppingCart}">
                                        <li><a href="#" class="image">
                                                <img src="<c:url value='/template/web/img/product-img/${item.value.product.photo}'/>"
                                                     class="cart-thumb" alt="">
                                            </a>
                                            <div class="cart-item-desc">
                                                <h6>
                                                    <a href="<c:url value="/product-details/${item.value.product.ID}" />">
                                                        ${item.value.product.name} x ${item.value.quantity}${item.value.product.size}
                                                    </a>
                                                </h6>
                                                <p> <span class="price"><fmt:formatNumber type="number"
                                                                                          maxFractionDigits="3" value="${item.value.totalPrice}"/> ₫</span>
                                                </p>
                                            </div> 
                                            <span class="dropdown-product-remove">
                                                <i class="icon-cross"></i>
                                            </span>
                                        </li>
                                    </c:forEach>
                                    <li class="total">
                                        <span class="pull-right"> 
                                            <c:if test="${ not empty TotalPriceCart}">
                                                <fmt:formatNumber type="number" maxFractionDigits="3"
                                                                  value="${TotalPriceCart}" /> ₫ 
                                            </c:if>
                                            <c:if test="${ empty TotalPriceCart}">0 ₫</c:if>
                                        </span> 
                                        <a href="/invee/cart" class="btn btn-sm btn-cart">Cart</a>
                                        <a href="/invee/checkout" class="btn btn-sm btn-checkout">Checkout</a>
                                    </li>
                                    </ul>
                                </div>

                            <div class="header-right-side-text ml-15" id="">
                                <c:if test="${not empty LoginInfor }">
                                    <a href="#" id="login">${ LoginInfor.name }</a>
                                    <a>|</a>
                                    <a href="/invee/account/logout" id="login">Đăng xuất</a>
                                </c:if>
                                <c:if test="${ empty LoginInfor }">
                                    <a href="/invee/account/login" id="login">Đăng nhập</a>
                                    <a>|</a>
                                    <a href="/invee/account/register" id="login">Đăng Ký</a>
                                </c:if>
                            </div>
                                        
                        </div>
                                        
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- Top Header Area End -->
    <div class="main_header_area">
        <div class="container h-100">
            <div class="row h-100">
                <div class="col-12 d-md-flex justify-content-between">
                    <!-- Logo Area -->
                    <div class="top_logo">
                        <a href="/invee/homepage">
                            <img src="<c:url value='/template/web/img/logo-iNVEE.png'/>" alt="">
                        </a>
                    </div>
                    <!-- Header Social Area -->
                    <div class="header-social-area">
                    </div>
                    <!-- Menu Area -->
                    <div class="main-menu-area">
                        <nav class="navbar navbar-expand-lg align-items-start">

                            <button class="navbar-toggler" type="button"
                                    data-toggle="collapse" data-target="#karl-navbar"
                                    aria-controls="karl-navbar" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"><i class="ti-menu"></i></span>
                            </button>

                            <div class="collapse navbar-collapse align-items-start collapse"
                                 id="karl-navbar">
                                <ul class="navbar-nav animated" id="nav">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="/invee/homepage"">Trang chủ</a></li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/invee/product">Sản phẩm</a></li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/invee/about-us">Giới thiệu</a></li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="/invee/contact">Liên hệ</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>

                </div>
            </div>
        </div>
    </div>

</header>
<!-- ****** Header Area End ****** -->