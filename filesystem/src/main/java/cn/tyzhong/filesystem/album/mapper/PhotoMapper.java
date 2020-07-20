package cn.tyzhong.filesystem.album.mapper;

import cn.tyzhong.filesystem.album.entity.Photo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotoMapper {
    int insert(Photo photo);
}
