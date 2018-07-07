package com.hbck.txt;

import java.io.Serializable;

/**
 * txt类
 *
 * @Date 2018-07-07.
 */
public class TxtBean implements Serializable{
    private String fileName;//文件名
    private String filePath;//文件路径
    private String fileSize;//文件大小

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
