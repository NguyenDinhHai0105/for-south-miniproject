package com.example.demo.service.impl;

import com.example.demo.collections.FileData;
import com.example.demo.repositories.FileRepository;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final String FOLDER_PATH = "";

    @Autowired
    FileRepository fileRepository;

    @Override
    public String saveFileToSystem(MultipartFile multipartFile) throws IOException {
        String filePath = FOLDER_PATH + multipartFile.getOriginalFilename();
        FileData fileData = fileRepository.save(FileData.builder()
                .id(UUID.randomUUID().toString().split("-")[0])
                .name(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .filePath(filePath).build());

        multipartFile.transferTo(new File(filePath));
        if(fileRepository.existsById(fileData.getId())) {
            return "File upload successfully: " + filePath;
        }
        return "File upload failed: " + filePath;
    }
}
