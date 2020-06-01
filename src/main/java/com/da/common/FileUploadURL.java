package com.da.common;

import com.da.exception.ResultException;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
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

    @Value("${storage.location}")
    private String storage;


    public static boolean validImageFile(String ext) {
        return FILE_EXT_ACCEPT_IMAGE.contains(ext);
    }
    public static String saveFileAndGetUrl(MultipartFile file) throws Exception {
//        String fileName = storage + file.getOriginalFilename();
//        File tempFile  = new File(fileName);
//        if (!file.isEmpty()){
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream steam = new BufferedOutputStream(new FileOutputStream(tempFile));
//                steam.write(bytes);
//                steam.close();
//            }catch (IOException e){
//                throw new ResultException(ErrorCode.FILE_UPLOAD_FAILED);
//            }
//        }
//        return fileName;
        String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!FileUploadURL.validImageFile(fileExt)) {
            return "";
        }

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String fileName = date + file.getOriginalFilename();
        // folderPath here is /sismed/temp/exames
        String filePath = storage + "/" + fileName;
        // Copies Spring's multipartfile inputStream to /sismed/temp/exames (absolute path)
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        byte[] bytesEncoded = Base64.encodeBase64(filePath.getBytes());
        String enCode = new String(bytesEncoded);

        return storage + enCode;
    }
}
