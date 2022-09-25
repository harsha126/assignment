package com.test.assignment.controller;

import com.test.assignment.helper.Message;
import com.test.assignment.helper.csvhelper;
import com.test.assignment.services.FileService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/api/v1/upload/")
public class IngestController {

//    private final  csvhelper csvhelper = new csvhelper();
    @Autowired
    private final FileService fileService;
    @Autowired
    private  JobLauncher jobLauncher;
    @Autowired
    private Job job;

    public IngestController(FileService fileService) {
        this.fileService = fileService;
    }


    @PostMapping
    public ResponseEntity<Message> getFile( @RequestParam("file.csv") MultipartFile file){
        String message = "please upload a CSV file";
        if(csvhelper.hasCSVFormat(file)){
            try{
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
            }catch (Exception e){
                message = "Uploaded the file unSuccefully: " + file.getOriginalFilename();
            }
        }
        return new ResponseEntity<Message>(new Message(message),HttpStatus.OK);
    }

    @GetMapping("new")
    public BatchStatus upload() throws JobParametersInvalidException, JobExecutionException  {
        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job,parameters);

        System.out.println("JobExecution:"+jobExecution.getStatus());

        System.out.println("Batch is Running ...");
        while(jobExecution.isRunning()){
            System.out.println("...");
        }
        return jobExecution.getStatus();
    }
}
