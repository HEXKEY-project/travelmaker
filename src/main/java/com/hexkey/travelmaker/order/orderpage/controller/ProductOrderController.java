package com.hexkey.travelmaker.order.orderpage.controller;

import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductOptionDTO;
import com.hexkey.travelmaker.order.orderpage.service.ProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }


    @PostMapping("/order/page")
    public String orderPage(@RequestParam int optionCode,
                            @RequestParam int count,
                            Model model) {

        List<Object> selectProducts = productOrderService.selectProducts(optionCode);

        ProductOptionDTO selectProductOption = (ProductOptionDTO) selectProducts.get(0);
        ProductDTO selectProduct = (ProductDTO) selectProducts.get(1);

        String productName = selectProduct.getProductName();
        String optionName = selectProductOption.getOptionName();
        int price = selectProduct.getPrice();

        int productPrice = price * count;
        int shipPrice = (productPrice >= 50000) ? 0 : 3000;
        int totalPrice = productPrice + shipPrice;

        model.addAttribute("productName", productName);
        model.addAttribute("optionName", optionName);
        model.addAttribute("count", count);
        model.addAttribute("price", price);

        model.addAttribute("productPrice", productPrice);
        model.addAttribute("shipPrice", shipPrice);
        model.addAttribute("totalPrice", totalPrice);

        return "user/order/page";

    }

}
