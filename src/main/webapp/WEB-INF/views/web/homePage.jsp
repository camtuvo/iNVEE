<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


	<!-- ****** Welcome Slides Area Start ****** -->

	<section class="welcome_area">
		<div class="welcome_slides owl-carousel">
			<!-- Single Slide Start -->
			<c:forEach var="item" items="${ slides }">
				<div class="single_slide height-800 bg-img background-overlay"
					style="background-image: url(<c:url value='/template/web/img/bg-img/${ item.photo }'/>);">

					<div class="container h-100">
						<div class="row h-100 align-items-center">
							<div class="col-12">
								<div class="welcome_slide_text">
									<h6 data-animation="bounceInDown" data-delay="0"
										data-duration="500ms">${ item.content }</h6>
									<h2 data-animation="fadeInUp" data-delay="500ms"
										data-duration="500ms">${ item.caption }</h2>
									<a href="/invee/product" class="btn karl-btn" data-animation="fadeInUp"
										data-delay="1s" data-duration="500ms">Shop Now</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<!-- ****** Welcome Slides Area End ****** -->

