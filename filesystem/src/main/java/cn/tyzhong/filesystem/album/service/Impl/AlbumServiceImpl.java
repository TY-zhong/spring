package cn.tyzhong.filesystem.album.service.Impl;

import cn.tyzhong.filesystem.album.entity.Album;
import cn.tyzhong.filesystem.album.mapper.AlbumMapper;
import cn.tyzhong.filesystem.album.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Value("${file.baseUrl}")
    private String baseUrl;

    @Autowired
    private AlbumMapper mapper;

    @Override
    public Object save(Album album) {
        return null;
    }

    @Override
    public void uploadPhotos(MultipartFile[] photos) {
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
            }
        }
    }
}
