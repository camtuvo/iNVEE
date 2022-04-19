<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<title>Chi tiết sản phẩm</title>


	<div class="container">
		<div class="row">
			<div class="col-12" style="height: 50px;">
				<ol class="d-flex align-items-center">
					<li class="breadcrumb-item"><a href="/invee/homepage">Trang chủ</a></li>
					<li class="breadcrumb-item"><a href="/invee/product">Sản phẩm</a></li>
					<li class="breadcrumb-item active">${product.name}</li>
				</ol>
			</div>
		</div>
	</div>

<section class="single_product_details_area section_padding_0">
    <div class="container">
        <div class="row">
                            
            <div class="col-12 col-md-6">
                <div class="single_product_thumb">
                    <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active" style="height:655px;with:532px;">
                                <a class="gallery_img"
                                   href="<c:url value="/template/web/img/product-img/${product.photo}"  />">
                                    <img class="d-block w-100"
                                         src="<c:url value="/template/web/img/product-img/${product.photo}"  />"
                                         alt="First slide">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-6">
                <div class="single_product_desc">

                    <h4 class="title">
                        <a>${product.name}</a>
                        <p id="id-pro" style="display:none;">${product.ID}</p>
                    </h4>

                    <h4 class="price">
                        <fmt:formatNumber type="number" maxFractionDigits="3"
                                          value="${product.price}" /> ₫
                    </h4>

                    <p class="available">
                        <%-- Tình trạng: <span class="text-muted">
                        <c:if test="${product.quantity != product.totalsale}">
                        Còn hàng
                        </c:if> 
                        <c:if test="${product.quantity == product.totalsale}">
                        Hết hàng
                        </c:if>
                        </span> --%>
                    </p>

                    <div class="widget size mb-50">
                        <h6 class="widget-title">Size</h6>
                        <div class="widget-desc">
                            <ul id="size">
                                <c:forEach var="item" items="${productDetails}">
                                    <li><a id="size-active" value="${item.sizeid}">${item.size}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div class="cart clearfix mb-50 d-flex">
                        <div class="quantity">
                            <span class="qty-minus"
                                  onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty > 1 ) effect.value--;return false;"><i
                                    class="fa fa-minus" aria-hidden="true"></i>
                            </span> 
                            <input type="number" class="qty-text" id="qty" step="1" min="1" max="12" name="quantity" value="1"> 
                            <span class="qty-plus" onclick="var effect = document.getElementById('qty'); 
                                                                var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;">
                                <i lass="fa fa-plus" aria-hidden="true"></i>
                            </span>
                        </div>
                        <button  onclick="addToCart()" class="btn cart-submit d-block">Thêm giỏ hàng</button>
                    </div>

                    <div id="accordion" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="headingOne">
                                <h6 class="mb-0">
                                    <a data-toggle="collapse" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">Thông tin sản phẩm</a>
                                </h6>
                            </div>
                            <div id="collapseOne" class="collapse show" role="tabpanel"
                                 aria-labelledby="headingOne" data-parent="#accordion">
                                <div class="card-body">${product.description}</div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
                                                        
        </div>
    </div>
</section>


<content tag="script"> 
    <script>
	var id = document.getElementById('id-pro').innerHTML;
	var size= null;
	var sizeid= null;
	var item= document.querySelectorAll('#size li a'),
	tab =[];
	// add values size to the array
	for(var i=0;i<item.length; i++){
		tab.push(item[i].innerHTML,item[i].getAttribute('value'));	
	}
	//get selected size
	for(var i=0;i<item.length;i++){
            item[i].onclick = function(){
		//index = tab.indexOf(this.innerHTML); // show positon of value
		//console.log( this.innerHTML + " index = " + index);
		sizeid = this.getAttribute('value');
		size = this.innerHTML;
		// change color size selected
		this.style.color = 'white';
		this.style.background = '#ff084e';
		this.style.border = 'solid 2px #ff084e';
			
		};
	} 

	
	function addToCart(){
            var quantity = document.getElementById('qty').value;
            alert("Thêm thành công!");
                location.replace("/invee/cart/add-cart/id=" + id + "&quantity=" + quantity); 
	}	
    </script> 
</content>
