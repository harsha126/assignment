package com.test.assignment.controller;

import com.test.assignment.services.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/api/v1/upload")
public class UploadController {
    private final FileService fileService;

    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public String Upload(@RequestParam("file.csv") MultipartFile file) throws IOException {
        fileService.save(file);
        log.info("Saved the file : "+file.getName());
        return "redirect:/api/v1/upload/new";
    }
}
