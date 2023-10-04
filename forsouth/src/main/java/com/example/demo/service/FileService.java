package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public String saveFileToSystem(MultipartFile multipartFile) throws IOException;
}
