package com.da.common;

import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class FileUploadURL {
    private static final List<String> FILE_EXT_ACCEPT_IMAGE = Arrays.asList("jpg", "JPG", "png", "PNG",
            "doc", "DOC", "docx", "DOCX",
            "xls", "XLS", "xlsx", "XLSX");

    private static String UPLOAD_FOLDER = "./src/main/resources/image/";


    public static boolean validImageFile(String ext) {
        return FILE_EXT_ACCEPT_IMAGE.contains(ext);
    }
    public static String saveFileAndGetUrl(MultipartFile file) throws Exception {
        String fileName = UPLOAD_FOLDER + file.getOriginalFilename();
        if (!file.isEmpty()){
            try {
                // read and write the file to the selected location-
                byte[] bytes = file.getBytes();
                Path path = Paths.get(fileName);
                Files.write(path,bytes);
            }catch (IOException e){
                throw new ResultException(ErrorCode.FILE_UPLOAD_FAILED);
            }
        }
        String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!FileUploadURL.validImageFile(fileExt)) {
            return "";
        }
        return fileName;


//        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
//        String fileName = date + file.getOriginalFilename();
//        // folderPath here is /sismed/temp/exames
//        String filePath = storage + "/" + fileName;
//        // Copies Spring's multipartfile inputStream to /sismed/temp/exames (absolute path)
//        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
//
//        byte[] bytesEncoded = Base64.encodeBase64(filePath.getBytes());
//        String enCode = new String(bytesEncoded);
//
//        return storage + enCode;
    }

}
