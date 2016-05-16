package HorizontalAndVerticalThrows;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Imlll extends JDialog {
    private JPanel contentPane;
    private JTextField heightTextF;
    private JTextField velocity1TextF;
    private JTextField velocity2TextF;
    private JButton calculateButton;
    private JPanel RANGECHART;
    private JButton closeButton;

    private final static Logger LOGGER = Logger.getLogger(Imlll.class.getName());
    HorizontalThrow horizontalThrow = new HorizontalThrow();

    public Imlll() {
        setModal(true);
        getRootPane().setDefaultButton(calculateButton);
        setContentPane(contentPane);
        drawEmptyChart();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double height = Double.parseDouble(heightTextF.getText());
                double velocity1 = Double.parseDouble(velocity1TextF.getText());
                double velocity2 = Double.parseDouble(velocity2TextF.getText());
                if (velocity1 < 0 || velocity2 <= 0 || height < 0) {
                    LOGGER.info("Values can't be less than 0!");
                }
                if (velocity1 > velocity2) {
                    LOGGER.info("Velocity V1 can't be bigger than velocity V2!");
                }
                refreshChart(height, velocity1, velocity2);

            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    private void drawEmptyChart() {

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Range",
                "Range", "Velocity",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        RANGECHART.add(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double ystep = 0;
        String xstep = String.valueOf(0);

        for (int i = 0; i < 10; i++) {
            dataset.addValue(ystep, "Step", xstep);
        }
        return dataset;
    }

    private void refreshChart(double height, double velocity1, double velocity2) {
        RANGECHART.removeAll();
        RANGECHART.revalidate();
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Range",
                "Range", "Velocity",
                dataForRange(height, velocity1, velocity2),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        RANGECHART.add(chartPanel);
        RANGECHART.repaint();
    }

    private DefaultCategoryDataset dataForRange(double height, double velocity1, double velocity2) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double xStep = (velocity2 - velocity1) / 20;
        double xLine = velocity1;
        double yLinePlot;
        String xLinePlot = String.valueOf(xLine);

        double[] velocities = new double[21];
        velocities[0] = velocity1;
        velocities[20] = velocity2;

        for (int i = 1; i < 20; i++) {
            velocities[i] = velocity1 + i * xStep;
        }

        for (int i = 0; i < 21; i++) {
            yLinePlot = horizontalThrow.range(velocities[i], height);
            dataset.addValue(yLinePlot, "Step", xLinePlot);
            xLinePlot = String.valueOf(xLine += xStep);
        }
        return dataset;
    }

    public static void main(String[] args) {
        Imlll dialog = new Imlll();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
