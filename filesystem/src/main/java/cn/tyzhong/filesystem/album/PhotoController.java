package cn.tyzhong.filesystem.album;

import cn.tyzhong.filesystem.album.service.PhotoService;
import cn.tyzhong.filesystem.utils.qiniu.QiNiuUtils;
import cn.tyzhong.filesystem.utils.result.MyResult;
import cn.tyzhong.filesystem.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/photo/")
public class PhotoController {
    @Autowired
    private PhotoService service;

    @PostMapping("upload")
    public Result upload(@RequestParam("photos") MultipartFile[] photos, @RequestParam("albumId") Integer albumId) {
        service.uploadPhotos(photos, albumId);
        return MyResult.success();
    }

    @PostMapping("listByAlbumId")
    public Result listByAlbumId(@NotNull(message = "相册id不能为空") Integer albumId,
            @NotNull(message = "页码不能为空") Integer pageNum,
            @NotNull(message = "每页条数不能为空") Integer pageSize) {
        return MyResult.success(service.listByAlbumId(albumId, pageNum, pageSize));
    }

    @PostMapping("getQiNiuToken")
    public Result getQiNiuToken() {
        return MyResult.success(QiNiuUtils.getToken());
    }
}
