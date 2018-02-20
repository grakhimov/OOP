package Kurs;

import Kurs.Classes.Driver;
import Kurs.Methods.DriverMethods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.filechooser.FileSystemView.getFileSystemView;

public class BusPark {
    private JFrame busPark;
    private DefaultTableModel model;
    private JPanel panel;
    private JPanel cardPanel;
    private JButton openFile;
    private JButton saveFile;
    private JButton deleteRow;
    private JButton addRow;
    private JButton closeFile;

    private JToolBar menuBar;
    private JToolBar filterBar;
    private JScrollPane scroll;
    private JTable table;
    private JComboBox<String> driver;
    private JTextField searchField;
    private JButton filter;
    private ButtonGroup tableSelector;
    private JRadioButton driversTable;
    private JRadioButton busesTable;
    private JRadioButton routesTable;

    private JToolBar showDriversToolbar(){
        String[] comboBoxLines = {"name", "surname", "experience", "class"};
        filterBar = new JToolBar();
        filterBar.setLayout(new FlowLayout());
        driver = new JComboBox<>(comboBoxLines);
        filter = new JButton("Filter");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        filterBar.add(driver);
        filterBar.add(searchField);
        filterBar.add(filter);
        return filterBar;
    }

    private JToolBar showBusesToolbar(){
        String[] comboBoxLines = {"id", "number", "violations"};
        filterBar = new JToolBar();
        filterBar.setLayout(new FlowLayout());
        driver = new JComboBox<>(comboBoxLines);
        filter = new JButton("Filter");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        filterBar.add(driver);
        filterBar.add(searchField);
        filterBar.add(filter);
        return filterBar;
    }

    private JToolBar showRoutesToolbar(){
        String[] comboBoxLines = {"id", "startTime", "endTime"};
        filterBar = new JToolBar();
        filterBar.setLayout(new FlowLayout());
        driver = new JComboBox<>(comboBoxLines);
        filter = new JButton("Filter");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        filterBar.add(driver);
        filterBar.add(searchField);
        filterBar.add(filter);
        return filterBar;
    }

    private JTable showDriversTable(String[][] drivers){
        String[] columnNames = {"Name", "Surname", "Class", "Experience"};
        table = new JTable(drivers, columnNames);

        return table;
    }
    private void show() {
        Dimension buttonDimensions = new Dimension(40,40);
        busPark = new JFrame("Bus Park");
        busPark.setSize(800, 500);
        busPark.setLocation(400, 300);
        busPark.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());

        DriverMethods driverMethods = new DriverMethods();
        String[][] drivers = driverMethods.generateDriversPark(20);
        table = showDriversTable(drivers);
        JScrollPane tablePane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        panel.add(tablePane, BorderLayout.CENTER);
        JToolBar toolBar = showDriversToolbar();
        toolBar.setFloatable(false);
        panel.add(toolBar, BorderLayout.SOUTH);

        menuBar = new JToolBar();
        menuBar.setFloatable(false);

        menuBar.setPreferredSize(new Dimension(300, 50));
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));


        openFile = new JButton();
        openFile.setToolTipText("Open File");
        saveFile = new JButton();
        saveFile.setToolTipText("Save File");
        closeFile = new JButton();
        closeFile.setToolTipText("Close File");
        addRow = new JButton();
        addRow.setToolTipText("Add Row");
        deleteRow = new JButton();
        deleteRow.setToolTipText("Delete Row");

        openFile.setPreferredSize(buttonDimensions);
        saveFile.setPreferredSize(buttonDimensions);
        closeFile.setPreferredSize(buttonDimensions);
        addRow.setPreferredSize(buttonDimensions);
        deleteRow.setPreferredSize(buttonDimensions);

        openFile.setIcon(new ImageIcon(getClass().getResource("/icons/openFile.png")));
        saveFile.setIcon(new ImageIcon(getClass().getResource("/icons/saveFile.png")));
        closeFile.setIcon(new ImageIcon(getClass().getResource("/icons/closeFile.png")));
        addRow.setIcon(new ImageIcon(getClass().getResource("/icons/addRow.png")));
        deleteRow.setIcon(new ImageIcon(getClass().getResource("/icons/deleteRow.png")));
        openFile.setBorder(null);
        saveFile.setBorder(null);
        closeFile.setBorder(null);
        deleteRow.setBorder(null);
        addRow.setBorder(null);

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });


        menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        menuBar.add(openFile);
        menuBar.add(saveFile);
        menuBar.add(closeFile);
        menuBar.add(addRow);
        menuBar.add(deleteRow);

        tableSelector = new ButtonGroup();
        driversTable = new JRadioButton("Drivers");
        driversTable.setSelected(true);
        RadioButtonActionListener actionListener = new RadioButtonActionListener();
        driversTable.addActionListener(actionListener);
        busesTable = new JRadioButton("Buses");
        busesTable.addActionListener(actionListener);
        routesTable = new JRadioButton("Routes");
        routesTable.addActionListener(actionListener);
        tableSelector.add(driversTable);
        tableSelector.add(busesTable);
        tableSelector.add(routesTable);
        menuBar.add(driversTable);
        menuBar.add(busesTable);
        menuBar.add(routesTable);


        panel.add(menuBar, BorderLayout.NORTH);
        busPark.add(panel);
        busPark.setVisible(true);
    }

    private void openFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(getFileSystemView().getDefaultDirectory());

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            String filename = fileChooser.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "You selected " + filename);
        }
        else if (result == JFileChooser.CANCEL_OPTION)
        {
            JOptionPane.showMessageDialog(null, "You selected nothing.");
        }
        else if (result == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(null, "An error occurred.");
        }
    }

    class RadioButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == driversTable){
                System.out.println("drivers");
            }
            else if (event.getSource() == busesTable){
                System.out.println("buses");
                System.out.println(Arrays.toString(Driver.class.getFields()));
                /*panel.remove(table);
                panel.repaint();*/
            }
            else if (event.getSource() == routesTable){
                System.out.println("routes");
            }
        }
    }

    public static void main(String[] args) {

        DriverMethods driverMethods = new DriverMethods();
        String[][] drivers = driverMethods.generateDriversPark(20);
        System.out.println(Arrays.deepToString(drivers));
        /*for (Driver driver : drivers) {
            System.out.println(driver.getDriverId() + " " + driver.getDriverName() + " " + driver.getDriverSurname() + " " + driver.getExperience() + " " + driver.getDriverClass());
        }
        BusMethods busMethods = new BusMethods();
        ArrayList<Bus> buses = busMethods.generateBusPark(25);
        for (Bus bus: buses) {
            System.out.println(bus.getBusId() + " " + bus.getBusNumber());
        }
        busMethods.addBusVoilations(buses, 0, "idiot");
        System.out.println(buses.get(0).getBusId() + buses.get(0).getBusNumber() + buses.get(0).getBusViolations());
        RouteMethods routeMethods = new RouteMethods();
        ArrayList<Route> routes = routeMethods.generateRoutes(25);
        for (Route route : routes) {
            System.out.println(route.getId() + " " + route.getStartTime() + " " + route.getEndTime());
        }*/

        new BusPark().show();
    }
}
