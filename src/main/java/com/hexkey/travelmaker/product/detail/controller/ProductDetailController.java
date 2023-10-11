package com.hexkey.travelmaker.product.detail.controller;

import com.hexkey.travelmaker.product.detail.service.ProductDetailService;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user/product")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) { this.productDetailService = productDetailService; }

    @GetMapping("/detail")
    public String selectProductDetail(Long productSeq, Model model){

        log.info("productSeq : {}", productSeq);

        ProductDTO productDetail = productDetailService.selectProductDetail(productSeq);

        model.addAttribute("product", productDetail);

        return "/user/product/detail";
    }
}
