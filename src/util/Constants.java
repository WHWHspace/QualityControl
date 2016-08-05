package util;

/**
 * Created by 31344 on 2016/8/2.
 */
public class Constants {
    //接口源文件目录
    public static final String SOURCE = System.getProperty("user.dir") + "/dbTemplate/empty.mdb";

    //导出文件目录
    public static final String DESTINATION = System.getProperty("user.dir") + "/upload/upload.mdb";

    //id位移，防止id和原有系统冲突
    public static final int OFFSET = 1000000;
}
