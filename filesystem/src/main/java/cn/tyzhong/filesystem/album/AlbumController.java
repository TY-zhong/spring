package cn.tyzhong.filesystem.album;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/album/")
public class AlbumController {
    @Value("${file.baseUrl}")
    private String baseUrl;
    @PostMapping("upload")
    public Object upload(@RequestParam("photos") MultipartFile[] photos) {
        BufferedOutputStream stream = null;
        for (MultipartFile photo : photos) {
            String fileName = photo.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
            String uploadPath = baseUrl + fileName;
            try {
                byte[] bytes = photo.getBytes();
                stream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                stream = null;
                e.printStackTrace();
                return "error";
            }
        }
        return "success";
    }
    @PostMapping("test")
    public Object test() {
        return "test";
    }
}
