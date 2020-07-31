package cn.tyzhong.filesystem.album.service.Impl;

import cn.tyzhong.filesystem.album.entity.Photo;
import cn.tyzhong.filesystem.album.mapper.PhotoMapper;
import cn.tyzhong.filesystem.album.service.PhotoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Value("${file.saveBaseUrl}")
    private String saveBaseUrl;
    @Value("${file.visitBaseUrl}")
    private String visitBaseUrl;

    @Autowired
    private PhotoMapper mapper;

    @Override
    public Object save(Photo photo) {
        return null;
    }

    @Override
    @Transactional
    public void uploadPhotos(MultipartFile[] photos, Integer albumId) {
        System.out.println("beginTime" + System.currentTimeMillis());
        BufferedOutputStream stream = null;
        for (MultipartFile photo : photos) {
            String fileName = photo.getOriginalFilename();
            String uploadPath = saveBaseUrl + fileName;
            try {
                int offset = 0;
                int length = 1024;
                byte[] bytes = photo.getBytes();
                stream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath)));
                while (offset < bytes.length - 1) {
                    if (length > bytes.length - offset) length = bytes.length - offset;
                    stream.write(bytes, offset, length);
                    offset += length;
                }
                stream.close();
            } catch (Exception e) {
                stream = null;
                e.printStackTrace();
            }
            Photo album = new Photo();
            album.setSize(getSizeStr(photo.getSize()));
            album.setName(fileName);
            album.setVersion(1);
            album.setUrl(visitBaseUrl + fileName);
            album.setSuffix(fileName.substring(fileName.lastIndexOf(".") + 1));
            album.setAlbumId(albumId);
            album.setRemarks("上传照片");
            int id = mapper.insert(album);
        }
        System.out.println("endTime" + System.currentTimeMillis());
    }

    @Override
    public PageInfo<List<Photo>> listByAlbumId(Integer albumId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Photo> list = mapper.listByAlbumId(albumId);
        for (Photo photo : list) {
            photo.setUrl(visitBaseUrl + photo.getUrl());
        }
        return new PageInfo(list);
    }

    private String getSizeStr(long size) {
        double douSize = (double) size;
        String unit = "B";
        if (douSize > 1024) {
            douSize /= 1024;
            unit = "KB";
            if (douSize > 1024) {
                douSize /= 1024;
                unit = "MB";
                if (douSize > 1024) {
                    douSize /= 1024;
                    unit = "GB";
                }
            }
        }
        BigDecimal bigSize = new BigDecimal(douSize);
        return bigSize.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + unit;
    }
}
