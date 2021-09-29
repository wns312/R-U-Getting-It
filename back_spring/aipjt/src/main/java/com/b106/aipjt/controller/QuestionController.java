package com.b106.aipjt.controller;

import com.b106.aipjt.domain.dto.question.QuestionDto;
import com.b106.aipjt.domain.jpaentity.Question;
import com.b106.aipjt.domain.repository.QuestionRepository;
import com.b106.aipjt.service.QuestionService;
import com.b106.aipjt.service.S3UploadService;
import lombok.AllArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
public class QuestionController {
    private final QuestionRepository questionRepository;

    private S3UploadService s3UploadService;
    private QuestionService questionService;

    // QuestionDto 조회
    @GetMapping("")
    public String getQuestion(Model model){
        List<QuestionDto> questionDtoList = questionService.getList();
        // 목록 가져오기
        model.addAttribute("questionList", questionDtoList);
        return questionDtoList.toString();
    }

    // 이미지 파일 upload
    @PostMapping("")
    public String upload(QuestionDto questionDto, MultipartFile file) throws IOException {
        String imgName = s3UploadService.upload(file); // key : file
        questionDto.setImgName(imgName);
        // Dto DB에 저장
        questionService.saveImage(questionDto);

        return "upload success";
    }

    // random 이미지
    @GetMapping("/exam")
    public List<Question> findOne() {
        return questionRepository.randomQuestion();
    }
}
