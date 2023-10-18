package com.hexkey.travelmaker.review.controller;

import com.hexkey.travelmaker.review.dto.ReviewAttachDTO;
import com.hexkey.travelmaker.review.dto.ReviewDTO;
import com.hexkey.travelmaker.review.service.ReviewService;
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
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

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

        List<ReviewAttachDTO> reviewAttachImage =  new ArrayList<>();

        try {

            for (int i = 0; i < reviewImage.size(); i++) {
                if (reviewImage.get(i).getSize() > 0) {

                    String originalFileName = reviewImage.get(i).getOriginalFilename();
                    log.info("originalFileName : {}", originalFileName);

                    String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID() + ext;
                    log.info("savedFileName : {}", savedFileName);

                    reviewImage.get(i).transferTo(new File(reviewImageDir + "/" + savedFileName));

                    ReviewAttachDTO fileInfo = new ReviewAttachDTO();
                    fileInfo.setOriginalName(originalFileName);
                    fileInfo.setSavedName(savedFileName);
                    fileInfo.setSavePath("/user/images/reviewImages/");
                    fileInfo.setFileType("reviewImage");
                    fileInfo.setFilePath("/user/images/reviewImages/" + savedFileName);

                    reviewAttachImage.add(fileInfo);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("reviewAttachImage : {}", reviewAttachImage);

        review.setReviewAttachList(reviewAttachImage);

        reviewService.registerReview(review);

        return "redirect:/";
    }



}
