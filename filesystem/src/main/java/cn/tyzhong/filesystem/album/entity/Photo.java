package cn.tyzhong.filesystem.album.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@Slf4j
@ToString
public class Photo {
    private Integer id;

    // 照片大小 K,M,G
    private String size;

    private String name;

    // 照片版本，用于同名文件的处理
    private Integer version;

    private String url;

    // 照片后缀 png等
    private String suffix;

    // 照片所在相册id
    private Integer albumId;

    private Date createDate;

    private Integer delFlag = 0;

    private String remarks;
}
