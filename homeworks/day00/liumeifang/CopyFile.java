/**
 * 文件复制
 * 给一个源路径，一个目标路径，实现从源路径将文件复制一份到目标路径
 * --已完成，参考了别人写的代码
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {

    public static void main(String[] args){
        String rootPath = "G:\\aaaaaaaaaaaaaaa";
        String destPath = "G:\\bbbbbbbbbbbbbbbbbbbbb";

        String rootFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"a.txt";
        String destFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"copyTest";

        File file = new File(rootFilePath);
        File toFile = new File(destFilePath);

        try {
            copy(file,toFile);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void copy(File rootFile, File destFile) throws Exception{
        byte[] b = new byte[1024];
        int a;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        if (rootFile.isDirectory()){
            String destFilePath = getDestFilePath(rootFile,destFile);
            File copy = new File(destFilePath);

            //复制文件夹
            if (!copy.exists()){
                copy.mkdir();
            } else {
                copy.delete();
            }
            //遍历文件夹
            for (File f:rootFile.listFiles()){
                copy(f,copy);
            }
        } else {
            if (destFile.isDirectory()){
                String destFilePath = getDestFilePath(rootFile,destFile);

                //写文件
                File newFile = new File(destFilePath);
                fileInputStream = new FileInputStream(rootFile);
                fileOutputStream = new FileOutputStream(newFile);

                while ((a = fileInputStream.read(b)) != -1){
                    fileOutputStream.write(b,0,a);
                }
            } else {
                //写文件
                fileInputStream = new FileInputStream(rootFile);
                fileOutputStream = new FileOutputStream(destFile);

                while ((a = fileInputStream.read(b)) != -1){
                    fileOutputStream.write(b,0,a);
                }
            }
        }
    }

    private static String getDestFilePath(File rootFile,File destFile){
        String rootFilePath = rootFile.getAbsolutePath();
        rootFilePath = rootFilePath.replaceAll("\\\\","/");

        String destFilePath = destFile.getAbsolutePath();
        destFilePath = destFilePath.replace("\\\\","/");

        int lastIndexOf = rootFilePath.lastIndexOf("/");
        destFilePath = destFilePath+rootFilePath.substring(lastIndexOf,rootFilePath.length());
        return destFilePath;
    }
}
