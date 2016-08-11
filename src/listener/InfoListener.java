package listener;

import ui.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 31344 on 2016/8/11.
 */
public class InfoListener implements ActionListener{

    public MainWindow window;

    public InfoListener(MainWindow window){
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.showMessage("开始导出......");
    }
}
