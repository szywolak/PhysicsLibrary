package SecondNewtonLaw;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class lml extends JDialog {
    private JPanel contentPane;
    private JButton convertionButton;
    private JButton buttonCancel;
    private JPanel Content;
    private JButton saveButton;
    private JPanel COMPOTFDFDS;
    private JTextField firstValueCB;
    private JTextField firstInputCB;
    private JTextField secondValueCB;
    private JTextField secondInputCB;
    private JComboBox comboBox1;
    private JTextField MessegaField;


    private final static Logger LOGGER = Logger.getLogger(lml.class.getName());
    SecondNewtonLaw secondNewtonLaw = new SecondNewtonLaw();
    UUID randomName = UUID.randomUUID();
    Font messageFont = new Font("Georgia", Font.PLAIN, 20);

    public lml() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(convertionButton);
        openPlot();
        MessegaField.setEnabled(false);
        MessegaField.setDisabledTextColor(Color.BLUE);
        MessegaField.setHorizontalAlignment(SwingConstants.CENTER);
        MessegaField.setFont(messageFont);


        convertionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedItem = comboBox1.getSelectedIndex();
                openPlot();
                if (selectedItem == 0) {
                    LOGGER.info("Choose another value!");
                }
                if (selectedItem == 1) {
                    selectedItemOne();
                }
                if (selectedItem == 2) {
                    selectedItemSecond();
                }
                if (selectedItem == 3) {
                    selectedItemThird();
                }
            }

            private void selectedItemThird() {
                double mass = Double.parseDouble(firstInputCB.getText());
                double acceleration = Double.parseDouble(secondInputCB.getText());
                try {
                    refreshChartForForce(mass, acceleration);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                double equalFromRB = secondNewtonLaw.forceWithGivenMassAndAcceleration(mass, acceleration);
                String equal = String.valueOf(equalFromRB);
                MessegaField.setText("Force is equal to: " + equal);
            }

            private void selectedItemSecond() {
                double acceleration = Double.parseDouble(firstInputCB.getText());
                double force = Double.parseDouble(secondInputCB.getText());
                try {
                    refreshChartForMass(force, acceleration);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                double equalFromRB = secondNewtonLaw.massWithGivenForceAndAcceleration(acceleration, force);
                String equal = String.valueOf(equalFromRB);
                MessegaField.setText("Mass is equal to: " + equal);
            }

            private void selectedItemOne() {
                double mass = Double.parseDouble(firstInputCB.getText());
                double Force = Double.parseDouble(secondInputCB.getText());
                try {
                    refreshChartForAcceleration(mass, Force);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                double equalFromRB = secondNewtonLaw.accelerationWithGivenMassAndForce(mass, Force);
                String equal = String.valueOf(equalFromRB);
                MessegaField.setSelectedTextColor(Color.RED);
                MessegaField.setText("Acceleration is equal to: " + equal);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedItem = comboBox1.getSelectedIndex();
                if (selectedItem == 1) {
                    firstValueCB.setText("Mass (DOUBLE)");
                    secondValueCB.setText("Force (double)");
                }
                if (selectedItem == 2) {
                    firstValueCB.setText("Acceleration (DOUBLE)");
                    secondValueCB.setText("Force (double)");
                }
                if (selectedItem == 3) {
                    firstValueCB.setText("Mass (DOUBLE)");
                    secondValueCB.setText("Acceleration (DOUBLE)");
                }
            }
        });
    }



    private void openPlot() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Wykres",
                "Force", "Acceleration",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        COMPOTFDFDS.add(chartPanel);
    }


    private void onCancel() {
        dispose();
    }

    private void onSave(JFreeChart lineChart) throws IOException {
        ChartUtilities.saveChartAsPNG(new File(randomName + ".png"), lineChart, 400, 300);
        LOGGER.info("Your chart is saved as" + randomName);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double mass = 2.0;
        double acceleration = 14.5;
        double force = acceleration * mass;
        double ystep = force / 10;
        String xstep = String.valueOf(ystep + " N");

        for (int i = 0; i < 10; i++) {
            dataset.addValue(ystep, "Step", xstep);
            xstep = String.valueOf(ystep + "f");
            ystep = ystep * mass;
        }
        return dataset;
    }

    private DefaultCategoryDataset dataForAcceleration(double mass, double force) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double acceleration = force / mass;
        double xStep = acceleration / 10;
        double xLine = 0;
        double yLinePlot = 0;
        String xLinePlot = String.valueOf(xLine);

        for (int i = 0; i < 11; i++) {
            dataset.addValue(yLinePlot, "Step", xLinePlot);
            xLinePlot = String.valueOf(xLine += xStep);
            yLinePlot = Double.parseDouble(xLinePlot) * mass;
        }
        return dataset;
    }

    private DefaultCategoryDataset dataForMass(double force, double acceleration) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double mass = force / acceleration;
        double xStep = mass / 10;
        double xLine = 0;
        double yLinePlot = 0;
        String xLinePlot = String.valueOf(xLine);

        for (int i = 0; i < 11; i++) {
            dataset.addValue(yLinePlot, "Step", xLinePlot);
            xLinePlot = String.valueOf(xLine += xStep);
            yLinePlot = Double.parseDouble(xLinePlot) * mass;
        }
        return dataset;
    }

    private DefaultCategoryDataset dataForForce(double mass, double acceleration) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //force = mass * acceleration
        double force = mass * acceleration;
        double xStep = force / 10;
        double xLine = 0;
        double yLinePlot = 0;
        String xLinePlot = String.valueOf(xLine);

        for (int i = 0; i < 11; i++) {
            dataset.addValue(yLinePlot, "Step", xLinePlot);
            xLinePlot = String.valueOf(xLine += xStep);
            yLinePlot = Double.parseDouble(xLinePlot) * mass;
        }
        return dataset;
    }


    public void refreshChartForAcceleration(double mass, double force) throws IOException {
        COMPOTFDFDS.removeAll();
        COMPOTFDFDS.revalidate();
        final String plotInfo = "Mass = " + mass;
        JFreeChart lineChart = ChartFactory.createLineChart(
                plotInfo,
                "Acceleration", "Force",
                dataForAcceleration(mass, force),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanela = new ChartPanel(lineChart);
        COMPOTFDFDS.add(chartPanela);
        COMPOTFDFDS.repaint();
        onSave(lineChart);
    }

    public void refreshChartForMass(double force, double acceleration) throws IOException {
        COMPOTFDFDS.removeAll();
        COMPOTFDFDS.revalidate();
        final String plotInfo = "Acceleration = " + acceleration;
        JFreeChart lineChart = ChartFactory.createLineChart(
                plotInfo,
                "Mass", "Force",
                dataForMass(force, acceleration),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanela = new ChartPanel(lineChart);
        COMPOTFDFDS.add(chartPanela);
        COMPOTFDFDS.repaint();
        onSave(lineChart);
    }

    public void refreshChartForForce(double mass, double acceleration) throws IOException {
        COMPOTFDFDS.removeAll();
        COMPOTFDFDS.revalidate();
        final String plotInfo = "Mass = " + mass;
        JFreeChart lineChart = ChartFactory.createLineChart(
                plotInfo,
                "Force", "Acceleration",
                dataForForce(mass, acceleration),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanela = new ChartPanel(lineChart);
        COMPOTFDFDS.add(chartPanela);
        COMPOTFDFDS.repaint();
        onSave(lineChart);
    }

    /**
     * This is the main method which converts mass and force to acceleration.
     */
    public static void main(String[] args) {
        lml dialog = new lml();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
