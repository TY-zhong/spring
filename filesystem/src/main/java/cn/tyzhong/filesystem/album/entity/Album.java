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
public class Album {
    private String id;

    // 文件大小 K,M,G
    private String size;

    private String name;

    // 文件版本，用于同名文件的处理
    private Integer version;

    private String url;

    // 文件后缀 png等
    private String suffix;

    // 文件所处文件夹id
    private String folderId;

    private Date createDate;

    private Integer delFlag = 0;

    private String remarks;
}
