package com.hexkey.travelmaker.review.controller;

import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/review")
public class ReviewController {

    @Value("src/main/resources/static/user/images/reviewImages")
    private String IMAGE_DIR;

    @GetMapping("/register")
    public String registerReview() {


        return "/user/review/register";
    }

    @PostMapping("/register")
    public String registerReview(ReviewDTO review, List<MultipartFile> reviewImage) {

        log.info("review : {}", review);
        log.info("review Image : {}", reviewImage);

        String reviewImageDir = IMAGE_DIR;

        File dir = new File(reviewImageDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        ReviewAttachDTO reviewAttachImage =  new ReviewAttachDTO();



        return null;
    }

}
