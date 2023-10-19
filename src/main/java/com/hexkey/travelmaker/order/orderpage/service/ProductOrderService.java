package com.hexkey.travelmaker.order.orderpage.service;

import com.hexkey.travelmaker.order.orderpage.dao.ProductOrderMapper;
import com.hexkey.travelmaker.order.orderpage.dto.CodeAndCountDTO;
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



    public List<Object> selectProducts(int[] optionCodes) {

        System.out.println("옵션코드s : " +  optionCodes );

        List<ProductOptionDTO> selectProductOptions = new ArrayList<>();
        int[] productSeqs = new int[optionCodes.length];

        for (int i = 0; i < optionCodes.length; i++) {
            int optionCode = optionCodes[i];

            ProductOptionDTO selectProductOption = productOrderMapper.selectProductOption(optionCode);
            System.out.println("셀렉트옵션 : " +  selectProductOption );

            int productSeq = selectProductOption.getProductSeq();
            System.out.println("상품번호 : " +  productSeq );

            selectProductOptions.add(selectProductOption);
            productSeqs[i] = productSeq;
        }

        System.out.println("셀렉트옵션s : " +  selectProductOptions );
        System.out.println("상품번호s : " +  productSeqs );



        List<ProductDTO> selectProducts = new ArrayList<>();

        for (int i = 0; i < productSeqs.length; i++) {
            int productSeq = productSeqs[i];

            System.out.println("@@@@productSeq확인 = " + productSeq);

            ProductDTO selectProduct = productOrderMapper.selectProduct(productSeq);
            System.out.println("selectProduct = " + selectProduct);

            selectProducts.add(selectProduct);

        }

        List<Object> OptionsAndProducts = new ArrayList<>();

        OptionsAndProducts.add(selectProductOptions);
        OptionsAndProducts.add(selectProducts);
        System.out.println("@@@@확인 ProductsAndOptions@@@@ : " +  OptionsAndProducts );


        return OptionsAndProducts;
    }
}
