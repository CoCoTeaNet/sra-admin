package net.cocotea.admin.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 默认值配置项
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@Data
@Component
public class FileProp {
    
    /**
     * 默认文件保存的位置
     */
    @Value("${sra-admin.file.default-path}")
    private String defaultSavePath;

    /**
     * 头像保存位置
     */
    @Value("${sra-admin.file.avatar}")
    private String avatarPath;

    /**
     * 支持上传的文件格式
     */
    @Value("${sra-admin.file.support-filetype}")
    private String supportFiletype;

    /**
     * 媒体格式
     */
    @Value("${sra-admin.file.media-filetype}")
    private String mediaFileType;

}
