package iNVEE.Controller.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iNVEE.Entity.ProductDetails;
import iNVEE.Entity.Products;
import iNVEE.Entity.Users;
import iNVEE.Service.Admin.BrandServiceOfAdminImpl;
import iNVEE.Service.Admin.CategoryServiceOfAdminImpl;
import iNVEE.Service.Admin.ProductServiceOfAdminImpl;

@Controller(value = "productOfAdminController")
public class ProductController extends BaseController {

    @Autowired
    private ProductServiceOfAdminImpl productServiceOfAdmin;
    @Autowired
    private CategoryServiceOfAdminImpl CategoryServiceOfAdmin;
    @Autowired
    private BrandServiceOfAdminImpl BrandServiceOfAdminImpl;

    @RequestMapping(value = {"/admin/product"})
    public ModelAndView Product(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/product");
            _mvShare.addObject("products", productServiceOfAdmin.GetDataProduct());
            return _mvShare;

        } else {

            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }
    }

    @RequestMapping(value = {"/admin/warehouse"})
    public ModelAndView Warehouse(HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("LoginInforOfAdmin");
        if (loginInfo != null) {
            _mvShare.setViewName("admin/warehouse");
        _mvShare.addObject("products", productServiceOfAdmin.GetDataProduct());
        return _mvShare;
        } else {
            _mvShare.setViewName("redirect:/admin/login");
            return _mvShare;
        }
    }

    @RequestMapping(value = {"/admin/warehouse/add/{id}"}, method = RequestMethod.GET)
    public ModelAndView AddWarehouse(@PathVariable String id) {
        _mvShare.setViewName("admin/addWarehouse");
        _mvShare.addObject("size", productServiceOfAdmin.GetDataSize());
        _mvShare.addObject("product", new ProductDetails());

        return _mvShare;
    }

    @RequestMapping(value = {"/admin/warehouse/add/{id}"}, method = RequestMethod.POST)
    public String RAddWarehouse(@ModelAttribute("product") ProductDetails product, @PathVariable String id) {
        _mvShare.setViewName("admin/addWarehouse");
        int check = productServiceOfAdmin.AddProductInWarehouse(product, id);
        if (check > 0) {
            _mvShare.addObject("Status", "Thêm thành công!");
            return "redirect:/admin/warehouse";
        } else {
            _mvShare.addObject("Status", "Thêm không thành công!");
            return "redirect:/admin/warehouse";
        }

    }

    @RequestMapping(value = {"/admin/product-detail/{id}"})
    public ModelAndView ProductDetail(@PathVariable String id) {
        _mvShare.setViewName("admin/productDetails");
        _mvShare.addObject("productdetails", productServiceOfAdmin.GetDataProductDetail(id));
        _mvShare.addObject("product", productServiceOfAdmin.FindDataProductByProductId(id));
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/product/add"}, method = RequestMethod.GET)
    public ModelAndView AddProduct() {
        _mvShare.setViewName("admin/addNewProduct");
        _mvShare.addObject("category", CategoryServiceOfAdmin.GetDataCategory());
        _mvShare.addObject("brand", BrandServiceOfAdminImpl.GetDataBrand());
        _mvShare.addObject("product", new Products());
        return _mvShare;
    }

    @RequestMapping(value = {"/admin/product/add"}, method = RequestMethod.POST)
    public String RAddProduct(@ModelAttribute("product") Products product, HttpSession session) {
        _mvShare.setViewName("admin/addNewProduct");
        int check = productServiceOfAdmin.AddNewProduct(product, session);
        if (check > 0) {
            _mvShare.addObject("Status", "Thêm thành công!");
            return "redirect:/admin/product";
        } else {
            _mvShare.addObject("Status", "Thêm không thành công!");
            return "redirect:/admin/product";
        }

    }

    @RequestMapping(value = {"/admin/product/delete/{id}"}, method = RequestMethod.GET)
    public String DeleteProduct(@PathVariable String id) {
        int check = productServiceOfAdmin.DeleteProduct(id);
        if (check > 0) {
            _mvShare.addObject("Status", "Xóa thành công!");
            return "redirect:/admin/product";
        } else {
            _mvShare.addObject("Status", "Xóa không thành công!");
            return "redirect:/admin/product";
        }

    }

    @RequestMapping(value = {"/admin/product/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView EditCat(@PathVariable String id) {
        _mvShare.setViewName("admin/editProduct");
        _mvShare.addObject("currentProduct", productServiceOfAdmin.FindDataProductByProductId(id));
        _mvShare.addObject("category", CategoryServiceOfAdmin.GetDataCategory());
        _mvShare.addObject("brand", BrandServiceOfAdminImpl.GetDataBrand());
        _mvShare.addObject("product", new Products());
        return _mvShare;

    }

    @RequestMapping(value = {"/admin/product/edit/{id}"}, method = RequestMethod.POST)
    public String ReEditCat(@PathVariable String id, @ModelAttribute("product") Products product, HttpSession session) {
        _mvShare.setViewName("admin/editProduct");
        _mvShare.addObject("ProductId", id);
        int check = productServiceOfAdmin.UpdateProduct(product, id, session);
        if (check > 0) {
            _mvShare.addObject("Status", "Cập nhật thành công!");
            return "redirect:/admin/product";
        } else {
            _mvShare.addObject("Status", "Cập nhật không thành công!");
            return "redirect:/admin/product";
        }

    }

}
