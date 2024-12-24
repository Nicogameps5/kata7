package software.ulpgc.kata7;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class JFreeBarChartDisplay extends JPanel implements BarChartDisplay {

    public JFreeBarChartDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void shows(BarChart barChartData) {
        add(new ChartPanel(chart(dataset(barChartData))));
    }

    private JFreeChart chart(XYSeriesCollection dataset) {
        return ChartFactory.createXYBarChart(
                "Frequency of Titles by Year",
                "Year",
                false,
                "Count",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
    }

    private XYSeriesCollection dataset(BarChart barChartData) {
        XYSeries series = new XYSeries("Titles Frequency");
        double[] years = barChartData.years();
        double[] frequencies = barChartData.frequencies();
        for (int i = 0; i < years.length; i++) {
            series.add(years[i], frequencies[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }
}