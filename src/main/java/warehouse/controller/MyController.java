package warehouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import warehouse.entities.Product;
import warehouse.entities.Tenant;
import warehouse.service.ValidationService;
import warehouse.service.WarehouseService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private TransferForm transferForm;
    @Autowired
    private ValidationService validationService;
    @RequestMapping("/main")
    public String getAllTenants(Model model){
    List<Tenant> tenantList=warehouseService.getAllTenants();
    model.addAttribute("allTenants",tenantList);
        return "main-page";
    }
    @RequestMapping("/addNewTenant")
    public String addTenant(Model model){
        Tenant tenant=new Tenant();
        model.addAttribute("tenant",tenant);
        return "tenant-info";
    }
    @RequestMapping("/saveTenant")
    public String saveTenant(@Valid @ModelAttribute("tenant") Tenant tenant,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "tenant-info";
        }
        else {
            warehouseService.addTenant(tenant);
            return "redirect:/main";
        }
    }
    @RequestMapping(value = "/allProductsInfo")
    public String getAllProducts(@RequestParam("placeNumber") int placeNumber,Model model){
        Tenant tenant=warehouseService.getTenant(placeNumber);
        List<Product> productList=warehouseService.getAllProducts(tenant);
        transferForm.setPlaceNumber(placeNumber);
        model.addAttribute("productList",productList);
        return "products-info";
    }
    @RequestMapping("/addNewProduct")
    public String addProduct(Model model){
        Product product=new Product();
        model.addAttribute("addProduct",product);
        return "product-add";
    }
    @RequestMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("addProduct") Product product,BindingResult bindingResult,Model model){
        int placeNumber= transferForm.getPlaceNumber();
        if(bindingResult.hasErrors()){
            return "product-add";
        }
        else if(validationService.isFull(product,placeNumber)){
            return "is-full";
        }
        else {
            warehouseService.addProduct(product, placeNumber);
            model.addAttribute("placeNumber", placeNumber);
            return "redirect:/allProductsInfo";
        }
    }
    @RequestMapping("/deleteTenant")
    public String deleteTenant(@RequestParam("placeNumber")int placeNumber){
    warehouseService.deleteTenant(placeNumber);
    return "redirect:/main";
    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id")int id,Model model){
        int placeNumber= transferForm.getPlaceNumber();
        warehouseService.deleteProduct(id,placeNumber);
        model.addAttribute("placeNumber",placeNumber);
        return "redirect:/allProductsInfo";
    }
}
