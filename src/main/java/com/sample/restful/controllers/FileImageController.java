package com.sample.restful.controllers;

import com.sample.restful.models.responses.ResponseObject;
import com.sample.restful.services.IStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("v1/fileimage")
public class FileImageController {
    @Autowired
    private IStorageService iStorageService;
    @PostMapping("")
    ResponseEntity<ResponseObject> uploadfile(@RequestParam("file")MultipartFile file)
    {

        try {
            String generatedFileName = iStorageService.storefile(file);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Status",generatedFileName)
            );

        } catch (Exception exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("ok",exception.getMessage(),"")
            );

        }
    }

    @GetMapping("/file/{fileName:.+}")
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String fileName)
    {
       try {
           byte[] bytes = iStorageService.readFileContent(fileName);
           return ResponseEntity
                   .ok()
                   .contentType(MediaType.IMAGE_JPEG)
                   .body(bytes);
       } catch (Exception exception){
            return ResponseEntity.noContent().build();
       }
    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> getuploadedFiles()
    {
        try {
            List<String> urls = iStorageService.loadAll()
                    .map(path -> {
                        String urlPath = MvcUriComponentsBuilder.fromMethodName(FileImageController.class,"readDetailFile"
                        ,path.getFileName().toString()).build().toUri().toString();
                        return urlPath;
                    }).collect(Collectors.toList());
            return ResponseEntity.ok(new ResponseObject("Ok", "Tao list thanh cong",urls));
        } catch (Exception exception)
        {
            return ResponseEntity.ok(
                    new ResponseObject("failed", "List files failed", new String[]{})
            );

        }

    }



}
