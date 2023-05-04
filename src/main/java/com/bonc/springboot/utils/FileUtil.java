package com.bonc.springboot.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author qiush
 * @description
 * @create 2023-02-13 12:53
 */
public class FileUtil {

    //创建文件夹,可创建多级文件夹
    public static boolean makeDirOrFile(String dir){
        File file = new File(dir);
        boolean isMake = file.mkdirs();
        return isMake;
    }
    //创建文件,如果文件目录不在会创建文件夹再创建文件
    public static boolean makeDirOrFile(String dir, String fileName){
        try {
            File file = new File(dir);
            if(file.exists()){
                boolean is = new File(dir, fileName).createNewFile();
                return is;
            }else{
                file.mkdirs();
                boolean is = new File(dir, fileName).createNewFile();
                return is;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //修改文件或文件名,只能修改最后一级名字
    public static boolean renameDirOrFile(String beforeName, String newName){
        File file = new File(beforeName);
        boolean is =  file.renameTo(new File(newName));
        return is;
    }

    //递归删除,删除最后一级的文件或文件夹
    public static boolean deleteDirOrFile(String dirOrFile) {
        try {
            Path directory = Paths.get(dirOrFile);
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                    Files.delete(file); // 有效，因为它始终是一个文件
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir); //这将起作用，因为目录中的文件已被删除
                    return FileVisitResult.CONTINUE;
                }
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
