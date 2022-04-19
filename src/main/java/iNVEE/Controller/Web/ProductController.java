package iNVEE.Controller.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Dto.PaginatesDto;
import iNVEE.Service.User.BrandServiceImpl;
import iNVEE.Service.User.CategoryServiceImpl;
import iNVEE.Service.User.HomeServiceImpl;
import iNVEE.Service.User.PaginatesServiceImpl;
import iNVEE.Service.User.ProductDetailsServiceImpl;
import iNVEE.Service.User.ProductServiceImpl;

@Controller

public class ProductController extends BaseController {
	@Autowired
	private HomeServiceImpl HomeService;
	@Autowired
	private CategoryServiceImpl CategoryService;
	@Autowired
	private PaginatesServiceImpl PaginatesService;
	@Autowired
	private ProductServiceImpl ProductService;
	@Autowired
	private ProductDetailsServiceImpl ProductDetailsService;
	@Autowired
	private BrandServiceImpl BrandService;

	int totalProductsOfPage = 9;

	// show list of all products
	@RequestMapping(value = "/product")
	public ModelAndView Product() {
		_mvShare.setViewName("web/shop");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		_mvShare.addObject("brands",BrandService.GetDataBrand());
		int totalData = HomeService.GetDataProduct().size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				CategoryService.GetDataProductsPaginate(paginateInfo.getStart(), totalProductsOfPage));
		return _mvShare;
	}
	// sort by price
	@RequestMapping(value = "/product/sort-by=price_descending")
	public ModelAndView FilterLowToHigh() {
		_mvShare.setViewName("web/productOfFilterByDescPrice");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		_mvShare.addObject("brands",BrandService.GetDataBrand());
		int totalData = HomeService.GetDataProduct().size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				ProductService.GetDataProductsPaginateByDescPrice(paginateInfo.getStart(), totalProductsOfPage));
		return _mvShare;
	}
	@RequestMapping(value = "/product/sort-by=price_ascending")
	public ModelAndView FilterHighToLow() {
		_mvShare.setViewName("web/productOfFilterByAscePrice");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		_mvShare.addObject("brands",BrandService.GetDataBrand());
		int totalData = HomeService.GetDataProduct().size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				ProductService.GetDataProductsPaginateByAscePrice(paginateInfo.getStart(), totalProductsOfPage));
		return _mvShare;
	}
	@RequestMapping(value = "/product/sort-by=price_descending/page={currentPage}")
	public ModelAndView ProductByDescPriceInEachPage(@PathVariable int currentPage) {
		_mvShare.setViewName("web/productOfFilterByDescPrice");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		int totalData = HomeService.GetDataProduct().size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				ProductService.GetDataProductsPaginateByDescPrice(paginateInfo.getStart(), totalProductsOfPage));

		return _mvShare;

	}
	@RequestMapping(value = "/product/sort-by=price_ascending/page={currentPage}")
	public ModelAndView ProductByAscePriceInEachPage(@PathVariable int currentPage) {
		_mvShare.setViewName("web/productOfFilterByAscePrice");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		int totalData = HomeService.GetDataProduct().size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				ProductService.GetDataProductsPaginateByAscePrice(paginateInfo.getStart(), totalProductsOfPage));

		return _mvShare;

	}
	
	//show products detail by id
			@RequestMapping(value = "/product-details/{id}")
			public ModelAndView ProductDetails(@PathVariable String id){
				_mvShare.setViewName("web/productDetails");
				_mvShare.addObject("product", ProductService.GetDataProductsByProductId(id));
				_mvShare.addObject("productDetails", ProductDetailsService.GetDataProductsByProductId(id));
				return _mvShare;
			}
	// show products in each page
	@RequestMapping(value = "/product/page={currentPage}")
	public ModelAndView ProductInEachPage(@PathVariable int currentPage) {
		_mvShare.setViewName("web/shop");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		int totalData = HomeService.GetDataProduct().size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				CategoryService.GetDataProductsPaginate(paginateInfo.getStart(), totalProductsOfPage));

		return _mvShare;

	}

}
