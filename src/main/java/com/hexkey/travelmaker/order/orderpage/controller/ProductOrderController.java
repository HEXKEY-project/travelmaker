package com.hexkey.travelmaker.order.orderpage.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexkey.travelmaker.order.orderpage.dto.ProductDTO;
import com.hexkey.travelmaker.order.orderpage.dto.ProductOptionDTO;
import com.hexkey.travelmaker.order.orderpage.dto.CodeAndCountDTO;
import com.hexkey.travelmaker.order.orderpage.service.ProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }


    @PostMapping("/order/page")
    public String orderPage(@RequestParam("selectedOptionsData") String selectedOptionsData,
                            Model model) {

        List<CodeAndCountDTO> codeAndCountList = new ArrayList<>();
        try {
            // JSON 데이터를 ObjectMapper를 사용하여 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(selectedOptionsData);

            // JSON 데이터를 List<CodeAndCountDTO>로 변환

            for (JsonNode node : rootNode) {
                CodeAndCountDTO dto = new CodeAndCountDTO();
                dto.setOptionCode(node.get("optionCode").asInt());
                dto.setCount(node.get("count").asInt());
                codeAndCountList.add(dto);
            }

            // 변환된 데이터 사용
            for (CodeAndCountDTO dto : codeAndCountList) {
                System.out.println("Option Code: " + dto.getOptionCode());
                System.out.println("Count: " + dto.getCount());
                System.out.println("codeAndCountList: " + codeAndCountList);
            }


            // 다른 작업 수행 또는 리다이렉트
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 처리
        }

        log .info("시작 {}" + selectedOptionsData);

        log.info("@@@codeAndCountList {}" + selectedOptionsData);

        log.info("끝 {}" + selectedOptionsData);

        CodeAndCountDTO codeAndCountDTO = new CodeAndCountDTO();
        codeAndCountDTO.setCodeAndCountList(codeAndCountList);
//        (@ModelAttribute CodeAndCountDTO codeAndCountDTO,
//                Model model)
        System.out.println("codeAndCountDTO는 뭐냐 : " + codeAndCountDTO);

///////////////////////////////

        int[] optionCodes = new int[codeAndCountList.size()];
        int[] counts = new int[codeAndCountList.size()];

        for (int i = 0; i < codeAndCountList.size(); i++) {
            CodeAndCountDTO codeAndCount = codeAndCountList.get(i);
            optionCodes[i] = codeAndCount.getOptionCode();
            counts[i] = codeAndCount.getCount();

            System.out.println(optionCodes[i] +" : " + counts[i]);
        }
///////////////////////////////////////
        List<Object> OptionsAndProducts = productOrderService.selectProducts(optionCodes);

        List<ProductOptionDTO> optionsList = (List<ProductOptionDTO>)OptionsAndProducts.get(0);
        List<ProductDTO> productsList = (List<ProductDTO>)OptionsAndProducts.get(1);

        List<Map<String, Object>> productDatas = new ArrayList<>();
        int productPrices = 0;
        int shipPrices = 0;
        int totalPrices = 0;
        int optionCode = 0;

        for (int i = 0; i < counts.length; i++) {
            Map<String, Object> productData = new HashMap<>();

            productData.put("productName", productsList.get(i).getProductName());
            productData.put("optionName", optionsList.get(i).getOptionName());
            productData.put("count", counts[i]);
            productData.put("optionCode", optionsList.get(i).getOptionCode());
            productData.put("productPrice",  productsList.get(i).getPrice() * counts[i]);
            productDatas.add(productData);
            productPrices += productsList.get(i).getPrice() * counts[i];
        }

        shipPrices = productPrices > 100000 ? 0 : 3000;
        totalPrices = productPrices + shipPrices;

        System.out.println("@@@@확인productDatas : " + productDatas);

        System.out.println(productDatas.get(0));

        model.addAttribute("productDatas", productDatas);
        model.addAttribute("productPrices", productPrices);
        model.addAttribute("shipPrices", shipPrices);
        model.addAttribute("totalPrices", totalPrices);

        return "user/order/page";

    }

}
