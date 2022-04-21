<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="page-wrapper">
    
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <div class="white-box">
                    <h2 class="box-title">Cập nhật slider</h2>
                    <div class="table-responsive">
                        <form:form
                            action="/invee/admin/slide/edit/${currentSlider.ID}"
                            method="POST" modelAttribute="slider"
                            class="form-horizontal form-material">
                            <div class="col-md-6" style="float: left;">

                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0">Tiêu đề:&nbsp;</label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <form:input type="text" class="form-control p-0 border-0"
                                                    path="caption" value="${currentSlider.caption}" />
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    </br> </br> <label class="col-md-12 p-0">Nội dung:&nbsp;</label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <form:textarea type="text" class="form-control p-0 border-0"
                                                       path="content" />
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0">Trạng thái</label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <form:select class="form-control p-0 border-0" path="status">

                                            <form:option id="show" value="0" label="Hiển thị" />
                                            <form:option id="hide" value="1" label="Ẩn" />


                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6" style="float: right;">
                                <div class="form-group mb-4 image-preview" id="imagePreview"
                                     style="text-align: center;">
                                    <img
                                        src="<c:url value='/template/web/img/bg-img/${currentSlider.photo}'/>"
                                        height=400 with=300 alt="" class="image-preview__image">
                                </div>
                                <div class="form-group mb-4" style="text-align: center;">
                                    <form:input type="file" name="file" id="inputFile" path="photo"
                                                value="${currentSlider.photo}" />

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

        </div>
    </div>
</div>