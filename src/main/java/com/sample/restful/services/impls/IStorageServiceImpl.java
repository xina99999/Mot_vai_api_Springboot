package com.sample.restful.services.impls;

import com.sample.restful.services.IStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class IStorageServiceImpl implements IStorageService {
    private final Path storageFolder = Paths.get("Media");
    public IStorageServiceImpl(){
        try {

            Files.createDirectories(storageFolder);
        } catch (IOException exception){
            throw new RuntimeException("Loi",exception);
        }
    }

    private boolean isImageFile(MultipartFile file)
    {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[]{"png","jpg","jpeg","bmp"})
                .contains(fileExtension.trim().toLowerCase());
    }
    @Override
    public String storefile(MultipartFile file) {
      try {
          System.out.println("haha");
          if(file.isEmpty()){
              throw new RuntimeException("Da ton tai");
          }
          if (!isImageFile(file)){
              throw new RuntimeException("ban co muon uploadfile");
          }
          float fileSizeInMegabutes  = file.getSize()/1_000_000.0f;
          if (fileSizeInMegabutes>5.0f)
          {
              throw new RuntimeException("file cna duoi 5MB");
          }
          Date date = new Date();
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
          String currentDate = simpleDateFormat.format(date);
          String  fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
          String generatedFileName = UUID.randomUUID().toString().replace("-","");
          generatedFileName = currentDate+generatedFileName+"."+fileExtension;
          Path destinationFilePath = this.storageFolder.resolve(
                  Paths.get(generatedFileName))
                  .normalize().toAbsolutePath();
          if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath()))
          {
              throw new RuntimeException(
                      "Khong the nhan file truc tiep"
              );
          }
          try(InputStream inputStream = file.getInputStream()){
              Files.copy(inputStream,destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
          }
          return generatedFileName;
      } catch (IOException exception){
          throw new RuntimeException("Loi phan mem ", exception);
      }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.storageFolder,1)
                    .filter(path -> !path.equals(this.storageFolder))
                    .map(this.storageFolder::relativize);
        }
        catch (IOException exception){
            throw new RuntimeException("khong load duoc",exception);
        }

    }

    @Override
    public byte[] readFileContent(String fileName) {
        return null;
    }

    @Override
    public void deleteAllFile() {

    }
}
