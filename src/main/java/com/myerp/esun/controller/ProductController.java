package com.myerp.esun.controller;

import com.myerp.esun.Service.ProductService;
import com.myerp.esun.dto.ProductDto;
import com.myerp.esun.entity.ProductEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService ProductService;

    //顯示新增商品畫面
    @GetMapping("/add")
    public String addpd(Model model) {
        model.addAttribute("product", new ProductDto());
        return "AddProduct";
    }

    //新增商品
    @PostMapping("/add")
    public String addpdform(@Valid @ModelAttribute("product")ProductDto ProductDto,
                            BindingResult result,
                            Model model,
                            RedirectAttributes redirectAttributes){
        System.out.println("已進入addpdform");
        System.out.println("pdID = " + ProductDto.getProductID());

        if(ProductService.ProductExists(ProductDto.getProductID())){
            model.addAttribute("errorMessage","商品 ID 已存在，請使用其他編號！");
            return "AddProduct";
        }

        //新增商品
        try{
            ProductEntity addproduct =ProductService.addProduct(ProductDto);
            redirectAttributes.addFlashAttribute("successMessage",
                    "新增商品成功" );
            return "redirect:/api/product/add";
        } catch (Exception e) {
            model.addAttribute("errorMessage","新增商品失敗");
            return "AddProduct";
        }


    }
}
