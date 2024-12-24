package software.ulpgc.kata7;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/Descargas/title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        Map<Integer, Integer> stats = new HashMap<>();
        for (Title title : titles) {
            stats.put(title.getYear(), stats.getOrDefault(title.getYear(), 0) + 1);
        }

        for (int year : stats.keySet()) {
            System.out.println(year + "\t" + stats.get(year));
        }

        double[] years = stats.keySet().stream().mapToDouble(Integer::doubleValue).toArray();
        double[] frequencies = stats.values().stream().mapToDouble(Integer::doubleValue).toArray();

        BarChart barChartData = new BarChart(years, frequencies);
        MainFrame frame = new MainFrame();
        frame.barChartDisplay().shows(barChartData);
        frame.setVisible(true);
    }
}