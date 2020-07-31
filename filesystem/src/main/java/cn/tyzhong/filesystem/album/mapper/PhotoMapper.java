package cn.tyzhong.filesystem.album.mapper;

import cn.tyzhong.filesystem.album.entity.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhotoMapper {
    int insert(Photo photo);

    List<Photo> listByAlbumId(@Param("albumId") Integer albumId);
}
