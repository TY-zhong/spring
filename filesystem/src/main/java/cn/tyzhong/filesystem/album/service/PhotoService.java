package cn.tyzhong.filesystem.album.service;

import cn.tyzhong.filesystem.album.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    Object save(Photo photo);

    void uploadPhotos(MultipartFile[] photos);
}
