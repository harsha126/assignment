package com.test.assignment.services;

import com.test.assignment.helper.Input;
import com.test.assignment.helper.csvhelper;
import com.test.assignment.repositories.BatchRepository;
import com.test.assignment.repositories.ProductRepository;
import com.test.assignment.repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.newOutputStream;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public void save(MultipartFile file) throws IOException {
//        File csvFile = new File("C:\\Users\\ennea\\OneDrive\\Desktop\\assign\\assignment\\src\\main\\resources\\sampleinvenrory.csv");
        Path path = Paths.get("C:\\Users\\ennea\\OneDrive\\Desktop\\assign\\assignment\\src\\main\\resources\\sampleinvenrory.csv");
        try{
            OutputStream os = Files.newOutputStream(path);
            os.write(file.getBytes());
        }
        catch(Exception e){
            throw new RuntimeException("Error While File Transfering");
        }
    }

    @Override
    public List<Input> getAllInputs() {
        return null;
    }
}
