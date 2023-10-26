//package com.example.puddyBuddy.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@RestController
//@RequestMapping(produces = "application/json;charset=utf8")
//public class S3UploadController {
//    @Autowired
//    private S3Uploader s3Uploader;
//    @ResponseBody   // Long 타입을 리턴하고 싶은 경우 붙여야 함 (Long - 객체)
//    @PostMapping(value="/uploadNewImg",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<UserImgDTO> uploadImg(HttpServletRequest request, @RequestParam(value="file") MultipartFile image) throws IOException {
//        UserImgDTO userImgDTO = new UserImgDTO();
//        System.out.println("Upload Img");
//        System.out.println(image);
//        System.out.println("------------------------------------------------------");
//        if(!image.isEmpty()) {
//            String storedFileName = s3Uploader.upload(image,"images");
//            userImgDTO.setUploadImg(storedFileName);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(userImgDTO);
//    }
//
//}
