package com.hexkey.travelmaker.order.orderpage.service;

import com.hexkey.travelmaker.order.orderpage.dao.ProductOrderMapper;
import com.hexkey.travelmaker.order.orderpage.dto.CodeAndCountDTO;
import com.hexkey.travelmaker.order.orderpage.dto.OrderFormDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

            System.out.println("@@@@ 실행전 = " + productSeq);

            ProductDTO selectProduct = productOrderMapper.selectProduct(productSeq);
            System.out.println("@@@@ 실행후 = " + selectProduct);



            selectProducts.add(selectProduct);

        }



        List<Object> OptionsAndProducts = new ArrayList<>();

        OptionsAndProducts.add(selectProductOptions);
        OptionsAndProducts.add(selectProducts);
        System.out.println("@@@@확인 ProductsAndOptions@@@@ : " +  OptionsAndProducts );



        ///////////////////principal/////////////////////
        OrderFormDTO orderFormDTO = new OrderFormDTO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("$$$authentication : {}", authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("$$$userDetails : {}", userDetails);

        String memberName = userDetails.getUsername();
        log.info("$$$username : {}", memberName);

        orderFormDTO.setMemberName(memberName);

        log.info("$$$orderFormDTO : {}", orderFormDTO);

        ///////////////////principal/////////////////////


        return OptionsAndProducts;
    }
}
