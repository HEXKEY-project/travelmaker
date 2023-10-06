package com.hexkey.travelmaker.product.regist.controller;

import com.hexkey.travelmaker.product.regist.dto.FileDTO;
import com.hexkey.travelmaker.product.regist.dto.ProductDTO;
import com.hexkey.travelmaker.product.regist.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    private final ProductService productService;
    //private final

    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping("/regist")
    public String getRegistPage() {
        return "admin/product/regist";
    }

    @PostMapping("/regist")
    public String registProduct(ProductDTO product, String serialNo1, String serialNo2, String serialNo3,
                                @RequestParam(value = "product_content", required = false) List<MultipartFile> productContent,
                                @RequestParam(value = "product_img", required = false) List<MultipartFile> productImage
                                ) {

        /* 시리얼 넘버 가공해서 넣기 */
        String serialNo = serialNo1 + "-" + serialNo2 + "-" + serialNo3;
        product.setSerialNo(serialNo);

        /* 옵션 넣기 */


        log.info("product regist : {}", product);
        log.info("product Content: {}", productContent);
        log.info("product image : {}", productImage);

        String productContentDir = IMAGE_DIR + "productcontent";
        String productImageDir = IMAGE_DIR + "productimage";

        File dir1 = new File(productContentDir);
        File dir2 = new File(productImageDir);

         //디렉토리가 없을 경우 생성
        if (!dir1.exists() || !dir2.exists()) {
            dir1.mkdirs();
            dir2.mkdirs();

        }

         //업로드 파일에 대한 정보를 담을 리스트
        List<FileDTO> fileList = new ArrayList<>();

        try {

            for (int i = 0; i < productContent.size(); i++) {
                 //첨부파일이 실제로 존재하는 경우에만 로직 수행
                if (productContent.get(i).getSize() > 0) {

                     //파일명 변경 처리
                    String originalFileName = productContent.get(i).getOriginalFilename();
                    log.info("originalFileName : {}", originalFileName);

                    String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;
                    log.info("savedFileName : {}", savedFileName);

                     //서버의 설정 디렉토리에 파일 저장하기
                    productContent.get(i).transferTo(new File(productContentDir + "/" + savedFileName));

                     //DB에 저장할 파일의 정보 처리
                    FileDTO fileInfo = new FileDTO();
                    fileInfo.setOriginalName(originalFileName);
                    fileInfo.setSavedName(savedFileName);
                    fileInfo.setFilePath("/static/admin/images/productcontent/");
                    fileInfo.setFileType("productContent");

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {

            for (int i = 0; i < productImage.size(); i++) {
                 //첨부파일이 실제로 존재하는 경우에만 로직 수행
                if (productImage.get(i).getSize() > 0) {

                     //파일명 변경 처리
                    String originalFileName = productImage.get(i).getOriginalFilename();
                    log.info("originalFileName : {}", originalFileName);

                    String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;
                    log.info("savedFileName : {}", savedFileName);

                     //서버의 설정 디렉토리에 파일 저장하기
                    productImage.get(i).transferTo(new File(productImageDir + "/" + savedFileName));

                     //DB에 저장할 파일의 정보 처리
                    FileDTO fileInfo = new FileDTO();
                    fileInfo.setOriginalName(originalFileName);
                    fileInfo.setSavedName(savedFileName);
                    fileInfo.setFilePath("/static/admin/images/productimage/");
                    fileInfo.setFileType("productImage");

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("productImage : {}", fileList);
        product.setFileList(fileList);
        productService.registProduct(product);



        return "redirect:/";
    }


}
