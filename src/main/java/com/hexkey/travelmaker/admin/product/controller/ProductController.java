package com.hexkey.travelmaker.admin.product.controller;

import com.hexkey.travelmaker.admin.product.dto.FileDTO;
import com.hexkey.travelmaker.admin.product.dto.ProductDTO;
import com.hexkey.travelmaker.admin.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping("/regist")
    public String getRegistPage() {
        return "admin/product/regist";
    }

    @PostMapping("/regist")
    public void registProduct(ProductDTO product, List<MultipartFile> productImage) {

        log.info("product regist : {}", product);
        log.info("product image : {}", productImage);

        String originalDir = IMAGE_DIR + "original";
        String productContentDir = IMAGE_DIR + "productcontent";
        String productImageDir = IMAGE_DIR + "productimage";

        File dir1 = new File(originalDir);
        File dir2 = new File(productContentDir);
        File dir3 = new File(productImageDir);

        /* 디렉토리가 없을 경우 생성 */
        if (!dir1.exists() || !dir2.exists() || !dir3.exists()) {
            dir1.mkdirs();
            dir2.mkdirs();
            dir3.mkdirs();
        }

        /* 업로드 파일에 대한 정보를 담을 리스트 */
        List<FileDTO> fileList = new ArrayList<>();

        try {

            for (int i = 0; i < productImage.size(); i++) {
                /* 첨부파일이 실제로 존재하는 경우에만 로직 수행 */
                if (productImage.get(i).getSize() > 0) {

                    /* 파일명 변경 처리 */
                    String originalFileName = productImage.get(i).getOriginalFilename();
                    log.info("originalFileName : {}", originalFileName);

                    String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;
                    log.info("savedFileName : {}", savedFileName);

                    /* 서버의 설정 디렉토리에 파일 저장하기 */
                    productImage.get(i).transferTo(new File(originalDir + "/" + savedFileName));

                    /* DB에 저장할 파일의 정보 처리*/
                    FileDTO fileInfo = new FileDTO();
                    fileInfo.setOriginalName(originalFileName);
                    fileInfo.setSavedName(savedFileName);
                    fileInfo.setFilePath("/static/admin/images/original/");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("productImage : {}", fileList);
        product.setFileList(fileList);

        productService.registProduct(product);

    }


}
