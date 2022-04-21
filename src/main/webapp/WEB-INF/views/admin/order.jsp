<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="page-wrapper">

    <div class="container-fluid">
        <!-- ============================================================== -->
        <!-- Start Page Content -->
        <!-- ============================================================== -->
        <div class="row">
            <div class="col-sm-12">
                <div class="white-box">
                    <h2 class="box-title">Danh sách đơn hàng</h2>
                    <div class="table-responsive">

                        <table class="table text-nowrap">
                            <thead>
                                <tr>
                                    <th class="border-top-0">#</th>
                                    <th class="border-top-0">Mã vận đơn</th>
                                    <th class="border-top-0">Tổng tiền</th>
                                    <th class="border-top-0">Trạng thái</th>

                                    <th class="border-top-0"></th>
                                    <th class="border-top-0"></th>

                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="item" items="${ bills }">
                                    <tr>
                                        <td>${ item.ID }</td>
                                        <td>${ item.ordernumber }</td>
                                        <td><fmt:formatNumber type="number" maxFractionDigits="3"
                                                      value="${ item.totalprice }" /> ₫</td>
                                <td><c:if test="${item.status == 0}">Chưa xác nhận</c:if>
                                    <c:if test="${item.status == 1}">Đang vận chuyển</c:if> <c:if
                                        test="${item.status == 2}">Hủy</c:if></td>
                                    <td><a
                                            href="/invee/admin/order/order-detail/${item.ID}"><i class="fas fa-eye" aria-hidden="true"></i></a></td>
                                <td><c:if test="${item.status == 0}">
                                        <a href="/invee/admin/complete-bill/${item.ID}">Giao hàng</a>
                                    </c:if></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>


                    </div>
                </div>
            </div>
        </div>

    </div>
</div>