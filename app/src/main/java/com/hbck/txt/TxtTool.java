package com.hbck.txt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ txt工具类
 * @Date 2018-07-07.
 */
public class TxtTool {

    public static List<TxtBean> listFileTxt(File file) {
        List<TxtBean> listTxt = new ArrayList<>();

        File[] files = file.listFiles();
        try {
            for (File f : files) {
                if (!f.isDirectory()) {
                    if (f.getName().endsWith(".txt")) {
                        //获取并计算文件大小
                        long size = f.length();
                        String t_size = "";
                        if (size <= 1024) {
                            t_size = size + "B";
                        } else if (size > 1024 && size <= 1024 * 1024) {
                            size /= 1024;
                            t_size = size + "KB";
                        } else {
                            size = size / (1024 * 1024);
                            t_size = size + "MB";
                        }
                        TxtBean txtBean = new TxtBean();
                        txtBean.setFileName(f.getName());//文件名称
                        txtBean.setFileSize(t_size);//文件大小
                        txtBean.setFilePath(f.getAbsolutePath());//文件路径
                        listTxt.add(txtBean);
                    }
                } else if (f.isDirectory()) {
                    //如果是目录，迭代进入该目录
                    listFileTxt(f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTxt;
    }

}
