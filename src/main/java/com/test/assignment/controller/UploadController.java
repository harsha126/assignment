package com.test.assignment.controller;

import com.test.assignment.helper.Message;
import com.test.assignment.helper.csvhelper;
import com.test.assignment.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/v1/upload/")
public class UploadController {

    private final  csvhelper csvhelper = new csvhelper();
    private final FileService fileService;

    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }


    @PostMapping
    public ResponseEntity<Message> getFile(@RequestParam("file")MultipartFile file){
        String message = "please upload a CSV file";
        if(csvhelper.hasCSVFormat(file)){
            try{
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
            }catch (Exception e){
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
            }
        }
        return new ResponseEntity<Message>(new Message(message),HttpStatus.OK);
    }
}
