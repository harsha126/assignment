package com.test.assignment.services;

import com.test.assignment.helper.Input;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void save(MultipartFile file) throws IOException;
    List<Input> getAllInputs();
}
