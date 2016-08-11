package ui;

import listener.ExportListener;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 31344 on 2016/6/16.
 */
public class MainWindow extends JFrame{

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;


    public JLabel startDateLabel;
    public JLabel stopDateLabel;
    public JLabel startYearLabel;
    public JLabel startMonthLabel;
    public JLabel startDayLabel;
    public JLabel stopYearLabel;
    public JLabel stopMonthLabel;
    public JLabel stopDayLabel;

    public JComboBox startYearBox;
    public JComboBox startMonthBox;
    public JComboBox startDayBox;
    public JComboBox stopYearBox;
    public JComboBox stopMonthBox;
    public JComboBox stopDayBox;

    public JButton exportButton;

    public JScrollPane infoPane;
    public JTextArea infoArea;

    public MainWindow(){
        initComponents();

        this.setTitle("质控上传");
        this.setResizable(false);
        this.setSize(WIDTH,HEIGHT);
        this.setLocation(50, 50);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void initComponents() {
        startDateLabel = new JLabel("开始日期：");
        startDateLabel.setSize(WIDTH / 5, 30);
        startDateLabel.setLocation(WIDTH / 100, HEIGHT / 100);
        this.add(startDateLabel);

        startYearBox = new JComboBox();
        int year = Integer.parseInt(new SimpleDateFormat("YYYY").format(new Date()));
        for (int i = year - 5; i <= year; i++){
            startYearBox.addItem(i);
        }
        startYearBox.setSelectedItem(year);
        startYearBox.setSize(WIDTH / 5, 30);
        startYearBox.setLocation(WIDTH / 100 + WIDTH / 5, HEIGHT / 100);
        this.add(startYearBox);


        startYearLabel = new JLabel("年");
        startYearLabel.setSize(WIDTH / 10, 30);
        startYearLabel.setLocation(WIDTH / 100 + 2 * WIDTH / 5, HEIGHT / 100);
        this.add(startYearLabel);

        startMonthBox = new JComboBox();
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
        for (int i = 1; i <= 12; i++){
            startMonthBox.addItem(i);
        }
        startMonthBox.setSelectedItem(1);
        startMonthBox.setSize(WIDTH / 10, 30);
        startMonthBox.setLocation(WIDTH / 100 + WIDTH / 5 * 2 + WIDTH / 10, HEIGHT / 100);
        this.add(startMonthBox);

        startMonthLabel = new JLabel("月");
        startMonthLabel.setSize(WIDTH / 10, 30);
        startMonthLabel.setLocation(WIDTH / 100 + 3 * WIDTH/5, HEIGHT / 100);
        this.add(startMonthLabel);

        startDayBox = new JComboBox();
        int day = Integer.parseInt(new SimpleDateFormat("dd").format(new Date()));
        for (int i = 1; i <= 31; i++){
            startDayBox.addItem(i);
        }
        startDayBox.setSelectedItem(1);
        startDayBox.setSize(WIDTH / 10, 30);
        startDayBox.setLocation(WIDTH / 100 + WIDTH / 5 * 3 + WIDTH / 10, HEIGHT / 100);
        this.add(startDayBox);

        startDayLabel = new JLabel("日");
        startDayLabel.setSize(WIDTH / 10, 30);
        startDayLabel.setLocation(WIDTH / 100 + 4 * WIDTH / 5, HEIGHT / 100);
        this.add(startDayLabel);


        stopDateLabel = new JLabel("结束日期：");
        stopDateLabel.setSize(WIDTH / 5, 30);
        stopDateLabel.setLocation(WIDTH / 100, HEIGHT / 100 + 30);
        this.add(stopDateLabel);

        stopYearBox = new JComboBox();
        for (int i = year - 5; i <= year; i++){
            stopYearBox.addItem(i);
        }
        stopYearBox.setSelectedItem(year);
        stopYearBox.setSize(WIDTH / 5, 30);
        stopYearBox.setLocation(WIDTH / 100 + WIDTH / 5, HEIGHT / 100 + 30);
        this.add(stopYearBox);

        stopYearLabel = new JLabel("年");
        stopYearLabel.setSize(WIDTH / 10, 30);
        stopYearLabel.setLocation(WIDTH / 100 + 2 * WIDTH / 5, HEIGHT / 100 + 30);
        this.add(stopYearLabel);

        stopMonthBox = new JComboBox();
        for (int i = 1; i <= 12; i++){
            stopMonthBox.addItem(i);
        }
        stopMonthBox.setSelectedItem(month);
        stopMonthBox.setSize(WIDTH / 10, 30);
        stopMonthBox.setLocation(WIDTH / 100 + WIDTH / 5 * 2 + WIDTH / 10, HEIGHT / 100 + 30);
        this.add(stopMonthBox);

        stopMonthLabel = new JLabel("月");
        stopMonthLabel.setSize(WIDTH / 10, 30);
        stopMonthLabel.setLocation(WIDTH / 100 + 3 * WIDTH / 5, HEIGHT / 100 + 30);
        this.add(stopMonthLabel);

        stopDayBox = new JComboBox();
        for (int i = 1; i <= 31; i++){
            stopDayBox.addItem(i);
        }
        stopDayBox.setSelectedItem(day);
        stopDayBox.setSize(WIDTH / 10, 30);
        stopDayBox.setLocation(WIDTH / 100 + WIDTH / 5 * 3 + WIDTH / 10, HEIGHT / 100 + 30);
        this.add(stopDayBox);

        stopDayLabel = new JLabel("日");
        stopDayLabel.setSize(WIDTH / 10, 30);
        stopDayLabel.setLocation(WIDTH / 100 + 4 * WIDTH / 5, HEIGHT / 100 + 30);
        this.add(stopDayLabel);


        exportButton = new JButton("导出");
        exportButton.setSize(WIDTH / 5 - 40, 30 * 2);
        exportButton.setLocation(WIDTH / 100 + WIDTH / 5 * 4 + 20, HEIGHT / 100);
        exportButton.addActionListener(new ExportListener(this));

        this.add(exportButton);

        infoArea = new JTextArea();

        infoPane = new JScrollPane(infoArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        infoPane.setSize(480,350);
        infoPane.setLocation(10,100);
        this.add(infoPane);
    }

    /**
     * 显示导出过程信息
     * @param s
     */
    public void showMessage(String s) {
        infoArea.append(s + "\n");
        infoPane.repaint();
    }

    /**
     * 清空消息
     */
    public void clearMessage() {
        infoArea.setText("");
    }
}
