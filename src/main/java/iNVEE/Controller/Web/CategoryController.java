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

@Controller

public class CategoryController extends BaseController {
	@Autowired
	private HomeServiceImpl HomeService;
	@Autowired
	private CategoryServiceImpl CategoryService;
	@Autowired
	private PaginatesServiceImpl PaginatesService;
	@Autowired
	private BrandServiceImpl BrandService;
	
	int totalProductsOfPage = 9;

	
	// view products of category user want to show
	@RequestMapping(value = "/category/{id}")
	public ModelAndView productOfEachCategory(@PathVariable String id) {
		_mvShare.setViewName("web/productOfEachCategory");
		// show list category in nav-side-menu
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		_mvShare.addObject("brands",BrandService.GetDataBrand());
		int totalData = CategoryService.GetDataProductByCategoryId(id).size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				CategoryService.GetDataProductsOfCategoryPaginate(id, paginateInfo.getStart(), totalProductsOfPage));
		_mvShare.addObject("categoryId", id);
		return _mvShare;

	}

	// view products of category user want to show and show 9 products in each page.
	@RequestMapping(value = "/category/{id}/page={currentPage}")
	public ModelAndView productOfEachCategoryAndEachPage(@PathVariable String id, @PathVariable int currentPage) {
		_mvShare.setViewName("web/productOfEachCategory");
		_mvShare.addObject("categories", HomeService.GetDataCategory());
		_mvShare.addObject("brands", BrandService.GetDataBrand());
		int totalData = CategoryService.GetDataProductByCategoryId(id).size();
		PaginatesDto paginateInfo = PaginatesService.GetInfoPaginates(totalData, totalProductsOfPage, currentPage);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("ProductsPaginate",
				CategoryService.GetDataProductsOfCategoryPaginate(id, paginateInfo.getStart(), totalProductsOfPage));
		_mvShare.addObject("categoryId", id);
		return _mvShare;

	}

	
}
