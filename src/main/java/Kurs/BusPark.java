package Kurs;

import Kurs.Methods.BusMethods;
import Kurs.Methods.DriverMethods;
import Kurs.Methods.RouteMethods;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BusPark {
    private static String[][] driversList;
    private static String[][] busesList;
    private static String[][] routesList;
    private JFrame busPark;
    private JPanel tableCardPanel;
    private JPanel toolbarCardPanel;
    private JToolBar filterBar;
    private JTable driversTable;
    private JTable busesTable;
    private JTable routesTable;
    private JComboBox<String> filterDropdown;
    private JTextField searchField;
    private JButton filter;
    private ButtonGroup tableSelectorButtonGroup;
    private JRadioButton driversRadioButton;
    private JRadioButton busesRadioButton;
    private JRadioButton routesRadioButton;

    public static void main(String[] args) {
        DriverMethods driverMethods = new DriverMethods();
        driversList = new String[][]{};
        BusMethods busMethods = new BusMethods();
        busesList = busMethods.generateBusPark(20);
        RouteMethods routeMethods = new RouteMethods();
        routesList = routeMethods.generateRoutes(20);
        new BusPark().show();
    }

    private JToolBar showDriversToolbar() {
        String[] filterBy = {"name", "surname", "experience", "class"};
        filterBar = new JToolBar();
        filterBar.setLayout(new FlowLayout());
        filterDropdown = new JComboBox<>(filterBy);
        filter = new JButton("Filter");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        filterBar.add(filterDropdown);
        filterBar.add(searchField);
        filterBar.add(filter);
        return filterBar;
    }

    private JToolBar showBusesToolbar() {
        String[] filterBy = {"governmentNumber", "number"};
        filterBar = new JToolBar();
        filterBar.setLayout(new FlowLayout());
        filterDropdown = new JComboBox<>(filterBy);
        filter = new JButton("Filter");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        filterBar.add(filterDropdown);
        filterBar.add(searchField);
        filterBar.add(filter);
        return filterBar;
    }

    private JToolBar showRoutesToolbar() {
        String[] filterBy = {"number", "startTime", "endTime"};
        String[] expressions = {">", "<", "="};
        filterBar = new JToolBar();
        filterBar.setLayout(new FlowLayout());
        filterDropdown = new JComboBox<>(filterBy);
        filter = new JButton("Filter");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 20));
        JComboBox<String> filterExpressionDropdown = new JComboBox<>(expressions);
        filterBar.add(filterDropdown);
        filterBar.add(filterExpressionDropdown);
        filterBar.add(searchField);
        filterBar.add(filter);
        return filterBar;
    }

    private JTable getDriversTableFromArray(String[][] drivers) {
        String[] columnNames = {"Name", "Surname", "Class", "Experience"};
        driversTable = new JTable(drivers, columnNames);
        return driversTable;
    }

    private JTable showBusesTable(String[][] buses) {
        String[] columnNames = {"governmentNumber", "number"};
        busesTable = new JTable(buses, columnNames);

        return busesTable;
    }

    private JTable showRoutesTable(String[][] routes) {
        String[] columnNames = {"number", "startTime", "endTime"};
        routesTable = new JTable(routes, columnNames);

        return routesTable;
    }

    private void show() {
        Dimension buttonDimensions = new Dimension(40, 40);
        Dimension tableDimensions = new Dimension(785,343);
        busPark = new JFrame("Bus Park");
        busPark.setSize(800, 500);
        busPark.setLocation(400, 300);
        busPark.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());


        JToolBar menuBar = new JToolBar();
        menuBar.setFloatable(false);

        menuBar.setPreferredSize(new Dimension(300, 50));
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.LINE_AXIS));


        JButton openFile = new JButton();
        openFile.setToolTipText("Open File");
        JButton saveFile = new JButton();
        saveFile.setToolTipText("Save File");
        JButton closeFile = new JButton();
        closeFile.setToolTipText("Close File");
        JButton addRow = new JButton();
        addRow.setToolTipText("Add Row");
        JButton deleteRow = new JButton();
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
                FileDialog open = new FileDialog(busPark, "Open File", FileDialog.LOAD);
                open.setFile("*.xml");
                open.setVisible(true);
                File xmlFile = new File(open.getDirectory() + open.getFile());
                Document doc = null;
                try {
                    DocumentBuilder dBuilder =
                            DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    doc = dBuilder.parse(xmlFile);
                    doc.getDocumentElement().normalize();

                    NodeList items = doc.getElementsByTagName("items").item(0).getChildNodes();
                    NodeList driverNodeList = items.item(0).getChildNodes();
                    NodeList busesList = items.item(1).getChildNodes();
                    NodeList routesList = items.item(2).getChildNodes();

                    driversList = new String [driverNodeList.getLength()][];
                    for (int i = 0; i < driverNodeList.getLength(); i++) {
                        Node elem = driverNodeList.item(i);
                        NamedNodeMap attrs = elem.getAttributes();
                        String name = attrs.getNamedItem("name").getNodeValue();
                        String surname = attrs.getNamedItem("surname").getNodeValue();
                        String driverClass = attrs.getNamedItem("class").getNodeValue();
                        String experience = attrs.getNamedItem("experience").getNodeValue();
                        System.out.println(name + surname +driverClass + experience);
                        driversList[i] = new String[]{name, surname, driverClass, experience};

                    }
                    System.out.println(Arrays.deepToString(driversList));
                    driversTable = getDriversTableFromArray(driversList);
                    tableCardPanel.revalidate();
                    tableCardPanel.repaint();


                }
                catch (ParserConfigurationException | SAXException | IOException el) { el.printStackTrace(); }
            }
        });

        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tableSelectorButtonGroup.getSelection().getActionCommand());
                FileDialog save = new FileDialog(busPark, "Save to File", FileDialog.SAVE);
                save.setFile("*.xml");
                save.setVisible(true);
                String fileName = save.getDirectory() + save.getFile();
                try {
                    DocumentBuilder builder =
                            DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document doc = builder.newDocument();
                    Node itemsList = doc.createElement("items");
                    doc.appendChild(itemsList);
                    Node driversList = doc.createElement("drivers");
                    itemsList.appendChild(driversList);
                    for (int i = 0; i < driversTable.getRowCount(); i++) {
                        Element driver = doc.createElement("driver");
                        driversList.appendChild(driver);
                        driver.setAttribute("name", (String) driversTable.getValueAt(i, 0));
                        driver.setAttribute("surname", (String) driversTable.getValueAt(i, 1));
                        driver.setAttribute("class", (String) driversTable.getValueAt(i, 2));
                        driver.setAttribute("experience", (String) driversTable.getValueAt(i, 3));
                    }
                    Node busesList = doc.createElement("buses");
                    itemsList.appendChild(busesList);
                    for (int i = 0; i < busesTable.getRowCount(); i++) {
                        Element bus = doc.createElement("bus");
                        busesList.appendChild(bus);
                        bus.setAttribute("governmentNumber", (String) busesTable.getValueAt(i, 0));
                        bus.setAttribute("number", (String) busesTable.getValueAt(i, 1));
                    }
                    Node routesList = doc.createElement("routes");
                    itemsList.appendChild(routesList);
                    for (int i = 0; i < routesTable.getRowCount(); i++) {
                        Element route = doc.createElement("route");
                        routesList.appendChild(route);
                        route.setAttribute("number", (String) routesTable.getValueAt(i, 0));
                        route.setAttribute("startTime", (String) routesTable.getValueAt(i, 1));
                        route.setAttribute("endTime", (String) routesTable.getValueAt(i, 2));
                    }
                    try {
                        Transformer trans = TransformerFactory.newInstance().newTransformer();
                        java.io.FileWriter fw = new FileWriter(fileName);
                        trans.transform(new DOMSource(doc), new StreamResult(fw));
                        fw.close();

                    } catch (TransformerException | IOException eq) {
                        eq.printStackTrace();
                    }
                } catch (ParserConfigurationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        menuBar.add(openFile);
        menuBar.add(saveFile);
        menuBar.add(closeFile);
        menuBar.add(addRow);
        menuBar.add(deleteRow);

        tableSelectorButtonGroup = new ButtonGroup();
        driversRadioButton = new JRadioButton("drivers");
        RadioButtonActionListener listener = new RadioButtonActionListener();
        driversRadioButton.addItemListener(listener);
        busesRadioButton = new JRadioButton("buses");
        busesRadioButton.addItemListener(listener);
        routesRadioButton = new JRadioButton("routes");
        routesRadioButton.addItemListener(listener);
        tableSelectorButtonGroup.add(driversRadioButton);
        tableSelectorButtonGroup.add(busesRadioButton);
        tableSelectorButtonGroup.add(routesRadioButton);
        menuBar.add(driversRadioButton);
        menuBar.add(busesRadioButton);
        menuBar.add(routesRadioButton);

        driversTable = getDriversTableFromArray(driversList);
        driversTable.setFillsViewportHeight(true);
        busesTable = showBusesTable(busesList);
        busesTable.setFillsViewportHeight(true);
        routesTable = showRoutesTable(routesList);
        routesTable.setFillsViewportHeight(true);

        JScrollPane driversTablePane = new JScrollPane(driversTable);
        driversTablePane.setPreferredSize(tableDimensions);
        JScrollPane busesTablePane = new JScrollPane(busesTable);
        busesTablePane.setPreferredSize(tableDimensions);
        JScrollPane routesTablePane = new JScrollPane(routesTable);
        routesTablePane.setPreferredSize(tableDimensions);

        tableCardPanel = new JPanel(new CardLayout());

        JPanel driversPanel = new JPanel();
        driversPanel.add(driversTablePane);
        JPanel busesPanel = new JPanel();
        busesPanel.add(busesTablePane);
        JPanel routesPanel = new JPanel();
        routesPanel.add(routesTablePane);
        JScrollPane emptyPane = new JScrollPane();
        tableCardPanel.add(emptyPane);
        tableCardPanel.add(driversPanel, "drivers");
        tableCardPanel.add(busesPanel, "buses");
        tableCardPanel.add(routesPanel, "routes");
        mainPanel.add(tableCardPanel, BorderLayout.CENTER);

        mainPanel.add(menuBar, BorderLayout.NORTH);

        toolbarCardPanel = new JPanel(new CardLayout());
        JToolBar driversFilterBar = showDriversToolbar();
        driversFilterBar.setFloatable(false);
        JToolBar busesFilterBar = showBusesToolbar();
        busesFilterBar.setFloatable(false);
        JToolBar routesFilterBar = showRoutesToolbar();
        routesFilterBar.setFloatable(false);
        JToolBar emptyBar = new JToolBar();
        emptyBar.setFloatable(false);
        toolbarCardPanel.add(emptyBar);
        toolbarCardPanel.add(driversFilterBar, "drivers");
        toolbarCardPanel.add(busesFilterBar, "buses");
        toolbarCardPanel.add(routesFilterBar, "routes");
        mainPanel.add(toolbarCardPanel, BorderLayout.SOUTH);

        busPark.add(mainPanel);
        busPark.setVisible(true);
    }

    class RadioButtonActionListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getItemSelectable() == driversRadioButton) {
                System.out.println("drivers");
                CardLayout cl = (CardLayout)(tableCardPanel.getLayout());
                cl.show(tableCardPanel, "drivers");
                cl = (CardLayout)(toolbarCardPanel.getLayout());
                cl.show(toolbarCardPanel, "drivers");
            } else if (event.getItemSelectable() == busesRadioButton) {
                System.out.println("buses");
                CardLayout cl = (CardLayout)(tableCardPanel.getLayout());
                cl.show(tableCardPanel, "buses");
                cl = (CardLayout)(toolbarCardPanel.getLayout());
                cl.show(toolbarCardPanel, "buses");
            } else if (event.getItemSelectable() == routesRadioButton) {
                System.out.println("routes");
                CardLayout cl = (CardLayout)(tableCardPanel.getLayout());
                cl.show(tableCardPanel, "routes");
                cl = (CardLayout)(toolbarCardPanel.getLayout());
                cl.show(toolbarCardPanel, "routes");
            }
        }
    }

//    private void openFile(){
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(getFileSystemView().getDefaultDirectory());
//
//        int result = fileChooser.showOpenDialog(null);
//
//        if (result == JFileChooser.APPROVE_OPTION)
//        {
//            String filename = fileChooser.getSelectedFile().getPath();
//            JOptionPane.showMessageDialog(null, "You selected " + filename);
//        }
//        else if (result == JFileChooser.CANCEL_OPTION)
//        {
//            JOptionPane.showMessageDialog(null, "You selected nothing.");
//        }
//        else if (result == JFileChooser.ERROR_OPTION)
//        {
//            JOptionPane.showMessageDialog(null, "An error occurred.");
//        }
//    }

}
