package com.hexkey.travelmaker.order.orderpage.service;

import com.hexkey.travelmaker.order.orderpage.dao.ProductOrderMapper;
import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductOptionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductOrderService {

    private final ProductOrderMapper productOrderMapper;

    public ProductOrderService(ProductOrderMapper productOrderMapper) {
        this.productOrderMapper = productOrderMapper;
    }

    public List<Object> selectProducts(int optionCode) {
        ProductOptionDTO selectProductOption = productOrderMapper.selectProductOption(optionCode);
        System.out.println("selectProductOption = " + selectProductOption);

        int productSeq = selectProductOption.getProductSeq();

        ProductDTO selectProduct = productOrderMapper.selectProduct(productSeq);
        System.out.println("selectProduct = " + selectProduct);


        List<Object> selectProducts = new ArrayList<>();

        selectProducts.add(selectProductOption);
        selectProducts.add(selectProduct);

        return selectProducts;
    }
}
