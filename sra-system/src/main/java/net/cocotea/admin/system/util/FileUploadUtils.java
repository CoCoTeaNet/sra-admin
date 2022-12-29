package net.cocotea.admin.system.util;

import net.cocotea.admin.common.constant.CharConstant;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

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
     * @param targetUrl     本地存放文件目录
     * @return 文件Map：filename文件名 fileType文件类型
     */
    public static FileInfo saveMultipartFile(MultipartFile multipartFile, String targetUrl) {
        // 文件流
        OutputStream os = null;
        InputStream inputStream = null;
        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        // 文件信息
        FileInfo fileInfo = new FileInfo();
        String[] split = originalFilename.split("\\.");
        fileInfo.setFileName(split[0])
                .setFileSuffix(split[split.length - 1])
                .setFileSize(multipartFile.getSize());
        fileInfo.setFileBasePath(createRealPath(fileInfo.getFileName(), fileInfo.getFileSuffix()));
        fileInfo.setFileDir(targetUrl + createBaseDir());
        fileInfo.setRealPath(targetUrl + fileInfo.getFileBasePath());
        existFile(fileInfo);

        try {
            inputStream = multipartFile.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File outputFile = new File(fileInfo.getFileDir());
            if (!outputFile.exists()) {
                boolean mkdirs = outputFile.mkdirs();
                System.out.println(mkdirs);
            }
            os = Files.newOutputStream(Paths.get(fileInfo.getRealPath()));
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

        return fileInfo;
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

    private static void existFile(FileInfo fileInfo) {
        if (new File(fileInfo.getRealPath()).exists()) {
            String newName = fileInfo.getFileName() + CharConstant.UNDERLINE;
            String newBasePath = createRealPath(newName, fileInfo.getFileSuffix());
            String newRealPath = fileInfo.getRealPath().replace(fileInfo.getFileBasePath(), newBasePath);
            fileInfo.setFileBasePath(newBasePath).setFileName(newName).setRealPath(newRealPath);
            // 递归判断是否存在同文件
            existFile(fileInfo);
        }
    }

    /**
     * 创建文件储存真实路径
     *
     * @param basePath 基础目录
     * @param fileName 文件名
     * @param suffix   文件后缀
     * @return 真实路径
     */
    public static String createRealPath(String basePath, String fileName, String suffix) {
        if (fileName == null || fileName.trim().length() == 0) {
            throw new RuntimeException("文件名为空");
        }
        String fullPath = basePath + createBaseDir() + fileName;
        if (suffix == null || suffix.trim().length() == 0) {
            return fullPath;
        } else {
            return fullPath + CharConstant.POINT + suffix;
        }
    }

    /**
     * 创建基础存放目录
     *
     * @return 基础存放目录
     */
    public static String createBaseDir() {
        LocalDateTime now = LocalDateTime.now();
        return now.getYear() + CharConstant.LEFT_LINE +
                now.getMonthValue() + CharConstant.LEFT_LINE +
                now.getDayOfMonth() + CharConstant.LEFT_LINE;
    }

    /**
     * 创建文件储存真实路径（不包含基础目录）
     *
     * @param fileName 文件名
     * @param suffix   文件后缀
     * @return 真实路径
     */
    public static String createRealPath(String fileName, String suffix) {
        return createRealPath(CharConstant.EMPTY_STRING, fileName, suffix);
    }
}
