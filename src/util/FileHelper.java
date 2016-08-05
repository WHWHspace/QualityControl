package util;

import java.io.*;

/**
 * Created by 31344 on 2016/8/2.
 */
public class FileHelper {

    /**
     * 复制文件
     * @param src
     * @param des
     * @return
     */
    public static boolean CopyFile(String src,String des){
        try {
            FileInputStream in = new FileInputStream(new File(src));
            FileOutputStream out = new FileOutputStream(new File(des));
            byte b[] = new byte[1024];
            while(in.read(b) != -1){
                out.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
