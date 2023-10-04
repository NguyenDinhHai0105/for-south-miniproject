package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping
    public ResponseEntity<?> saveFile(@RequestParam MultipartFile file) throws IOException {
        String uploadImage = fileService.saveFileToSystem(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
}
