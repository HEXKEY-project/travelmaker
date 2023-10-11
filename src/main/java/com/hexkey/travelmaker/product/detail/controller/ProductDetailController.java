package com.hexkey.travelmaker.product.detail.controller;

import com.hexkey.travelmaker.product.detail.service.ProductDetailService;
import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) { this.productDetailService = productDetailService; }

    @GetMapping("/detail")
    public String selectProductDetail(Long productSeq, Model model){

        ProductDTO productDetail = productDetailService.selectProductDetail(productSeq);
        List<ProductOptionDTO> optionList = productDetailService.selectProductOption(productSeq);
        List<FileDTO> fileList = productDetailService.selectProductFile(productSeq);

        log.info("productDetail : {}", productDetail);
        log.info("optionList : {}", optionList);
        log.info("fileList : {}", fileList);

        model.addAttribute("product", productDetail);
        model.addAttribute("option", optionList);
        model.addAttribute("file", fileList);

        return "/user/product/detail";
    }
}
