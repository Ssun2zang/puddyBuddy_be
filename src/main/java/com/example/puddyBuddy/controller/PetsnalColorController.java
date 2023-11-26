package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.dto.PetsnalColor.*;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PetsnalColorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping( value = "/petsnalColors",  produces = "application/json;charset=utf8")
@Tag(name = "펫스널 컬러 API")
public class PetsnalColorController {
    private final PetsnalColorService petsnalColorService;


    public PetsnalColorController(PetsnalColorService petsnalColorService) {
        this.petsnalColorService = petsnalColorService;
    }

    @Operation(summary = "테스트 제작", description = "선호 조건과 사용할 사진을 주면 서버에서 테스트를 만들고 성공 여부를 알려줍니다.")
    @PostMapping("/start")
    public BaseResponse<PetsnalColorStartRes> makePetsnalTest(@RequestBody PetsnalColorStartReq petsnalColorStartReq){
        try {
            PetsnalColorStartRes res = petsnalColorService.makePetsnalTest(petsnalColorStartReq.getPreferId(), petsnalColorStartReq.getPhotoUrl());
            return new BaseResponse<>(res);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "테스트 스테이지 진행", description = "테스트의 각 스테이지를 진행합니다.")
    @PostMapping("/{stage}")
    public BaseResponse<PetsnalColorRes> doTest(@PathVariable int stage, @RequestBody PetsnalColorReq petsnalColorReq){
        try {
            PetsnalColorRes res = petsnalColorService.doTest(stage, petsnalColorReq.getPreferId(), petsnalColorReq.getResultList());
            return new BaseResponse<>(null);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }



}