package com.zll.demo;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileCopier;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.resource.ClassPathResource;
import com.sun.istack.internal.localization.NullLocalizable;
import org.junit.Test;

import java.io.*;

public class IOUtilsTest {

    @Test
    public void test001() {
        try {
            BufferedInputStream inputStream = FileUtil.getInputStream("d:/book-share.txt");
            BufferedOutputStream outputStream = FileUtil.getOutputStream("d:/out.txt");
            long copySize  = IoUtil.copy(inputStream,outputStream, IoUtil.DEFAULT_BUFFER_SIZE);
            System.out.println(copySize);
        } catch (IORuntimeException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读取classpath 下的文件
     */
    @Test
    public void test002(){


        ClassPathResource resource = new ClassPathResource("aa.txt");

        String content = resource.readUtf8Str();
        System.out.println(content);
    }

    /**
     * 文件拷贝
     */
    @Test
    public void test003(){
        FileCopier fileCopier = FileCopier.create("c:/test", "d:/aa");
        File copy = fileCopier.copy();
        System.out.println(copy.canRead());
    }

    /**
     * 获取文件的类型
     */
    @Test
    public void test004(){
        File file = FileUtil.file("D:\\aa\\test\\polycode.png");
        String type = FileTypeUtil.getType(file);
        System.out.println(type);

        File file1 = FileUtil.file("d:/wn_setting.sql");
        String type1 = FileTypeUtil.getType(file1);
        System.out.println(type1);
    }

    @Test
    public void test005(){
        FileReader reader = new FileReader("d:/wn_setting.sql");
        BufferedReader reader1 = reader.getReader();
        try {
            String line = null;
            while((line = reader1.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IoUtil.close(reader1);
        }
    }

    @Test
    public void test006(){
        String absolutePath = FileUtil.getAbsolutePath("Main.java");
        System.out.println(absolutePath);
    }

    @Test
    public void test007(){
        File touch = FileUtil.touch("d://aaa.txt");
        System.out.println(touch.exists());
    }

    @Test
    public void test008(){
        boolean ret = FileUtil.del("d:/xx.txt");
        System.out.println(ret);
        boolean del = FileUtil.del("d:/aaa.txt");
        System.out.println(del);
    }

    /**
     * 获取文件的扩展名
     */
    @Test
    public void test009(){

        String path = "d:/Troll.png";
        String s = FileUtil.extName(path);
        System.out.println(s);
        path = "D:\\wn_fiction.sql";
        String ext2 = FileUtil.extName(path);
        System.out.println(ext2);
    }

    /**
     * 获取webROOT
     */
    @Test
    public void test010(){
        File webRoot = FileUtil.getWebRoot();
        System.out.println(webRoot.getAbsolutePath());
    }


    /**
     * 获取图片的MIME TYPE
     */
    @Test
    public void test011(){
        String mimeType = FileUtil.getMimeType("aa.png");
        System.out.println(mimeType);
    }

}
