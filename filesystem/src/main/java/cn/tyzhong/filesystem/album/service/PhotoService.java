package cn.tyzhong.filesystem.album.service;

import cn.tyzhong.filesystem.album.entity.Photo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {
    Object save(Photo photo);

    void uploadPhotos(MultipartFile[] photos, Integer albumId);

    PageInfo<List<Photo>> listByAlbumId(Integer albumId, Integer pageNum, Integer pageSize);
}
