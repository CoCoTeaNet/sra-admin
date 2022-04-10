package com.jwss.sra.system.util;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 文件上传工具类
 *
 * @author jwss
 * @date 2022-4-9 23:34:04
 */
public class FileUploadUtils {

    /**
     * 保存上传文件
     *
     * @param multipartFile MultipartFile.class
     * @param targetUrl     本地存放文件
     * @return 文件名称
     */
    public static String saveMultipartFile(MultipartFile multipartFile, String targetUrl) {
        OutputStream os = null;
        InputStream inputStream = null;
        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        String[] split = originalFilename.split("\\.");
        String filename = DigestUtils.md5DigestAsHex((split[0] + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8)) + "." + split[1];
        try {
            inputStream = multipartFile.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(targetUrl);
            if (!tempFile.exists()) {
                boolean mkdirs = tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + filename);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                assert os != null;
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }

    /**
     * MultipartFile类转File
     *
     * @param multipartFile MultipartFile类
     * @return File
     */
    public static File multipartFileToFile(MultipartFile multipartFile) {
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            if (originalFilename != null) {
                String[] filename = originalFilename.split("\\.");
                file = File.createTempFile(filename[0], filename[1]);
                multipartFile.transferTo(file);
                file.deleteOnExit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
