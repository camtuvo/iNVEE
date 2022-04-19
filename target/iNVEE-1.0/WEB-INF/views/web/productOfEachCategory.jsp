<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


	<section class="shop_grid_area section_padding_100">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-4 col-lg-3">
					<div class="shop_sidebar_area">

						<div class="widget catagory mb-50">
							<!--  Side Nav  -->
							<div class="nav-side-menu">
								<h6 class="widget-title mb-30">Categories</h6>
								<div class="menu-list">
									<ul id="menu-content" class="">
										<!-- Single Item -->
										<li data-toggle="collapse"><a
												href='<c:url value="/product"/> '>All</a></li>
										<c:forEach var="item" items="${ categories }">
											<li data-toggle="collapse"><a
												href='<c:url value="/category/${item.ID}"/> '>${ item.name }</a></li>
										</c:forEach>


									</ul>
								</div>
							</div>
						</div>

						<div class="widget price mb-50">
							<div class="nav-side-menu">
								<h6 class="widget-title mb-30">Filter by Price</h6>
								<div class="menu-list">
									<ul id="menu-content2" class="">
										<li><a href="<c:url value="/product/sort-by=price_ascending" />">Low to high</a></li>
										<li><a href="<c:url value="/product/sort-by=price_descending" />">High to low</a></li>
									</ul>
								</div>
							</div>

						</div>
						<div class="widget brand mb-50">
							<div class="nav-side-menu">
								<h6 class="widget-title mb-30">Brands</h6>
								<div class="menu-list">
									<ul id="menu-content2" class="">
										<c:forEach var="item" items="${ brands }">
											<li data-toggle="collapse"><a
												href='<c:url value="/brand/${item.ID}"/> '>${ item.name }</a></li>
										</c:forEach>

									</ul>
								</div>
							</div>

						</div>
					
                                                                        

					</div>
				</div>

				<div class="col-12 col-md-8 col-lg-9">
					<div class="shop_grid_product_area">
						<div class="row">
							<!-- Single gallery Item -->
							<c:if test="${ ProductsPaginate.size() > 0 }">
								<c:forEach var="item" items="${ ProductsPaginate }">

									<div
										class="col-12 col-sm-6 col-lg-4 single_gallery_item wow fadeInUpBig"
										data-wow-delay="0.1s">
										<!-- Product Image -->
										<div class="product-img" style="with:255px;height:319px;">
											<img
												src="<c:url value='/template/web/img/product-img/${ item.photo }'/>"
												alt="">
											<div class="product-quicview">
												<a href="/invee/product-details/${item.ID}" ><i
													class="ti-plus"></i></a>
											</div>
										</div>
										<!-- Product Description -->
										<div class="product-description">
											<h4 class="product-price">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${item.price}" />
												₫

											</h4>
											<p>${ item.name }</p>
											
										</div>
									</div>

								</c:forEach>
							</c:if>
						</div>
						<div class="shop_pagination_area wow fadeInUp"
							data-wow-delay="0.5s">
							<nav aria-label="Page navigation">
									<c:if test="${ProductsPaginate != null }">
								<ul class="pagination pagination-sm">
								
									<li class="page-item"><a class="page-link" href="<c:url value='/category/${ categoryId }/page=1'/>">&laquo;</a>
										<c:forEach var="item" begin="1"
											end="${ paginateInfo.totalPage }" varStatus="loop">
											<c:if test="${ (loop.index) == paginateInfo.currentPage }">
												<li class="page-item active"><a class="page-link"
													href="<c:url value='/category/${ categoryId }/page=${ loop.index }'/>">${ loop.index }</a></li>
											</c:if>
											<c:if test="${ (loop.index) != paginateInfo.currentPage }">
												<li class="page-item"><a class="page-link"
													href="<c:url value='/category/${ categoryId }/page=${ loop.index }'/>">${ loop.index }</a></li>
											</c:if>
										</c:forEach>
									<li class="page-item"><a class="page-link" href="<c:url value='/category/${ categoryId }/page=${ paginateInfo.totalPage }'/>">&raquo;</a></li>
								</ul>
								</c:if>
							</nav>
						</div>
					</div>
				</div>



			</div>
		</div>
		
	</section>
