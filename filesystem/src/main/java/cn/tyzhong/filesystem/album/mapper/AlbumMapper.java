package cn.tyzhong.filesystem.album.mapper;

import cn.tyzhong.filesystem.album.entity.Album;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlbumMapper {
    int insert(Album album);
}
