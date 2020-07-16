package cn.tyzhong.filesystem.album;

import cn.tyzhong.filesystem.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/album/")
public class AlbumController {
    @Autowired
    private AlbumService service;

    @PostMapping("upload")
    public Object upload(@RequestParam("photos") MultipartFile[] photos) {
        service.uploadPhotos(photos);
        return "success";
    }
    @PostMapping("test")
    public Object test() {
        return "test";
    }
}
