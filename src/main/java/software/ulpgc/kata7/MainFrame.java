package software.ulpgc.kata7;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BarChartDisplay barChartDisplay;

    public MainFrame(){
        setTitle("Bar Chart Viewer");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createBarChartDisplay());
    }

    private Component createBarChartDisplay(){
        JFreeBarChartDisplay display = new JFreeBarChartDisplay();
        barChartDisplay = display;
        return display;
    }

    public BarChartDisplay barChartDisplay(){
        return barChartDisplay;
    }
}
