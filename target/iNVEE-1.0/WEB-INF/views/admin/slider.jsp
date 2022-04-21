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
                    <h2 class="box-title">Danh sách slider</h2>
                    <p>${Status}</p>
                    <div class="table-responsive">
                        <a href="<c:url value="slider/add"/>">
                            <button class="btn btn-cyan">
                                <i class="fas fa-plus" aria-hidden="true"></i> <span
                                    class="hide-menu">Thêm mới</span>
                            </button>
                        </a>
                        <table class="table text-nowrap">
                            <thead>
                                <tr>
                                    <th class="border-top-0">#</th>
                                    <th class="border-top-0">Tiêu đề</th>
                                    <th class="border-top-0">Trạng thái</th>

                                    <th class="border-top-0"></th>

                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="item" items="${ Slides }">
                                    <tr>
                                        <td>${ item.ID }</td>
                                        <td>${ item.caption }</td>
                                        <td><c:if test="${item.status == 1 }">Ẩn</c:if> <c:if
                                                test="${item.status == 0 }">Hiển thị</c:if></td>
                                        <td><a class="" href="<c:url value="slide/edit/${item.ID}" />">
                                                <i class=" far fa-edit" aria-hidden="true"></i>Chỉnh sửa&emsp;</a> 
                                            <a class="" href="<c:url value="slide/delete/${item.ID}" />"><i
                                                    class="fas fa-trash-alt" aria-hidden="true"></i>Xóa</a>
                                        </td>

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