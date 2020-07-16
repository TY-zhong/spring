package cn.tyzhong.filesystem.album.service;

import cn.tyzhong.filesystem.album.entity.Album;
import org.springframework.web.multipart.MultipartFile;

public interface AlbumService {
    Object save(Album album);

    void uploadPhotos(MultipartFile[] photos);
}
