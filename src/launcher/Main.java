package launcher;

import ui.MainWindow;
import util.PatientIDMap;

/**
 * Created by 31344 on 2016/6/16.
 */
public class Main {

    public static void main(String args[]){
        new Main().run();
    }

    private void run() {
        PatientIDMap.ReadMap();

        MainWindow window = new MainWindow();
    }
}
