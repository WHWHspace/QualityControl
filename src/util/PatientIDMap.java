package util;

import java.io.*;
import java.util.HashMap;

/**
 * Created by 31344 on 2016/8/4.
 */
public class PatientIDMap {

    private static final String PATH = System.getProperty("user.dir") + "/config/idmap.txt";
    private static HashMap<Integer,Integer> idMap = new HashMap<>();

    /**
     * 读取id对应
     */
    public static void ReadMap(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(PATH)));
            String line = reader.readLine();
            while(line != null){
                String[] map = line.split(" ");
                idMap.put(Integer.parseInt(map[1]),Integer.parseInt(map[0]));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取病人在原系统对应的id
     * @param id
     * @return
     */
    public static int getMappedID(int id){
        Integer result = idMap.get(id);
        if(result == null){
            return -1;
        }
        return result;
    }

}
