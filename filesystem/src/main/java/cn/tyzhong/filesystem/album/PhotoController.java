package cn.tyzhong.filesystem.album;

import cn.tyzhong.filesystem.album.service.PhotoService;
import cn.tyzhong.filesystem.utils.result.MyResult;
import cn.tyzhong.filesystem.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/photo/")
public class PhotoController {
    @Autowired
    private PhotoService service;

    @PostMapping("upload")
    public Result upload(@RequestParam("photos") MultipartFile[] photos) {
        service.uploadPhotos(photos);
        return MyResult.success();
    }
    @PostMapping("test")
    public Result test() {
        return MyResult.success();
    }
}
