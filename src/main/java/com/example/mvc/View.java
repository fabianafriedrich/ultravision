package com.example.mvc;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import com.example.enums.CustomerEnum;
import com.example.enums.MediaEnum;
import com.example.model.*;
import com.example.util.ButtonColumn;
import com.example.util.CustomerTableModel;
import org.springframework.stereotype.Component;

@Component
public class View extends JFrame {

    // Reference to the controller
    private FrameController controller;
    private MembershipCard membershipCard;


    //Global Variables
    private JTextField customer = new JTextField("Search Customer", 15);
    private JTextField titleV = new JTextField("Search Title", 15);

    private JTextField titleOp = new JTextField("Title", 15);
    private JTextField yearOfReleaseTitle = new JTextField("Year Of Release", 15);
    private JTextField bandTitle = new JTextField("Band", 15);
    private JTextField genreMusicTitle = new JTextField("Genre Music", 15);

    private JTextField titleM = new JTextField("Title", 15);
    private JTextField yearOfReleaseMovie = new JTextField("Year Of Release", 15);
    private JTextField director = new JTextField("Director", 15);
    private JTextField genreMovieTitle = new JTextField("Genre Movie", 15);

    private JTextField customerName = new JTextField("Type your full name", 15);
    private JTextField cardNo = new JTextField("Card Number", 15);
    private JTextField customerVerify = new JTextField("Customer Name", 15);
    private JTextField titleVerify = new JTextField("Title", 15);
    private JTextField customerReturn = new JTextField("Customer Name", 15);
    private JTextField titleReturn = new JTextField("Title Return", 15);

    List<String> category = Arrays.asList("Music", "Live Concert Videos", "Movie", "Box Set");
    JComboBox categoryList;

    private JComboBox<MediaEnum> media = new JComboBox<>();
    private JComboBox<CustomerEnum> membershipList = new JComboBox<>();


    private JPanel contentPanel = new JPanel();
    private JPanel contentPanelMenu = new JPanel();
    private JPanel contentPanelButtons = new JPanel();

    /*
     * The constructor needs to have get a the
     * controller from outside
     */
    public View(FrameController controllerFromOutside) {

        // Internal reference from controller
        this.controller = controllerFromOutside;


        // Calling methods to set windows
        this.settings();

        this.menu();

    }

    /*
     * Settings
     */
    private void settings() {
        this.setVisible(true);
        this.setSize(800, 550);
        /*Logo*/
        ImageIcon img = new ImageIcon("C:\\Users\\Fabiana\\Downloads\\ultravision\\ultravision\\images\\2.png");
        this.setIconImage(img.getImage());


    }

    /*
     * All elements of the frame menu
     */
    public void menu() {
        JMenuBar myMenuBar = new JMenuBar();
        JMenu addMenu = new JMenu("Add Menu");
        JMenu register = new JMenu("Register");
        JMenuItem addTitle = new JMenuItem("Add Title");
        JMenuItem addCustomer = new JMenuItem("Add Customer");
        JMenuItem rent = new JMenuItem("Rent Item");
        JMenuItem returned = new JMenuItem("Returned Item");

        JButton searchTitle = new JButton("Search");
        JButton searchCustomer = new JButton("Search");
        searchTitle.setActionCommand("Search Title");
        searchCustomer.setActionCommand("Find");

        this.setJMenuBar(myMenuBar);
        myMenuBar.add(addMenu);
        myMenuBar.add(register);
        addMenu.add(addTitle);
        addMenu.add(addCustomer);
        register.add(rent);
        register.add(returned);

        myMenuBar.add(customer);
        myMenuBar.add(searchCustomer);
        myMenuBar.add(titleV);
        myMenuBar.add(searchTitle);

        addTitle.addActionListener(controller);
        addCustomer.addActionListener(controller);
        rent.addActionListener(controller);
        returned.addActionListener(controller);
        searchTitle.addActionListener(controller);
        searchCustomer.addActionListener(controller);

        customer.addMouseListener(controller);
        titleV.addMouseListener(controller);

        setLayout(new BorderLayout());

        //Stop the program when we close the Frame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(this.contentPanel, BorderLayout.PAGE_START);
        this.add(this.contentPanelMenu, BorderLayout.CENTER);
        this.add(this.contentPanelButtons, BorderLayout.PAGE_END);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    /*this method will give you the options of the type of title you select*/
    public void addTitle() {
        //removing any other content of the panel
        cancel();

        //Cast from List to Array and use that array in JCobomBox
        String[] stockArr = new String[category.size()];
        stockArr = category.toArray(stockArr);

        //Panel and Label
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Choose the Title Category");

        //Adding to the panel
        panel.add(label1);

        //Create the combo box, select item at index 2.
        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        categoryList = new JComboBox(stockArr);
        //4 items on THE JComboBox
        categoryList.setSelectedItem(0);
        //Adding category list to the panel
        panel.add(categoryList);


        //label
        JLabel label2 = new JLabel("Choose the Title Media");

        //Adding to the frame
        contentPanel.add(panel, BorderLayout.PAGE_START);
        //Adding to the pane2
        panel.add(label2);

        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        media.setModel(new DefaultComboBoxModel<>(MediaEnum.values()));
        //4 items on THE JComboBox
        media.setSelectedItem(0);
        //Adding cb the panel
        panel.add(media);

        //Button, action command for that button and action listener
        JButton buttonSearch = new JButton("Add");
        buttonSearch.setActionCommand("search for category");
        buttonSearch.addActionListener(controller);
        //panel adding button
        panel.add(buttonSearch);


        // Never forget these two
        this.validate();
        this.repaint();
    }

    /*this ethod is adding the info of the title that you had selected*/
    public void addingTitle() {
        //remove other contents
        this.contentPanelMenu.removeAll();
        this.contentPanelButtons.removeAll();

        //veryfing type of title, that the user choosed on the method addTitle
        if (categoryList.getSelectedItem().equals("Music") || categoryList.getSelectedItem().equals("Live Concert Videos")) {
            JPanel panelInfoMusic = new JPanel();

            //TF mouse listener to set blank the field when clicked
            titleOp.addMouseListener(controller);
            yearOfReleaseTitle.addMouseListener(controller);
            bandTitle.addMouseListener(controller);
            genreMusicTitle.addMouseListener(controller);

            /*content adding panel
            a grid layout for the TF
             */
            contentPanelMenu.add(panelInfoMusic);
            GridLayout manager = new GridLayout(4, 1);
            panelInfoMusic.setLayout(manager);
            panelInfoMusic.add(titleOp);
            panelInfoMusic.add(yearOfReleaseTitle);
            panelInfoMusic.add(bandTitle);
            panelInfoMusic.add(genreMusicTitle);


        } else if (categoryList.getSelectedItem().equals("Movie") || categoryList.getSelectedItem().equals("Box Set")) {

            /*Panel Movie and Box Set*/
            JPanel panelInfoMovie = new JPanel();
            titleM.addMouseListener(controller);
            yearOfReleaseMovie.addMouseListener(controller);
            director.addMouseListener(controller);
            genreMovieTitle.addMouseListener(controller);

            contentPanelMenu.add(panelInfoMovie, BorderLayout.CENTER);
            GridLayout manager = new GridLayout(4, 1);

            panelInfoMovie.setLayout(manager);
            panelInfoMovie.add(titleM);
            panelInfoMovie.add(yearOfReleaseMovie);
            panelInfoMovie.add(director);
            panelInfoMovie.add(genreMovieTitle);

        }

        /*buttons*/
        JButton saveTitle = new JButton("Save");
        JButton cancelTitle = new JButton("Cancel");

        //panel
        JPanel panelButtons = new JPanel();
        contentPanelButtons.add(panelButtons);
        //buttons action command
        saveTitle.setActionCommand("Add Titles");
        cancelTitle.setActionCommand("Cancel");

        //buttons action listener
        saveTitle.addActionListener(controller);
        cancelTitle.addActionListener(controller);

        //pane adding buttons
        panelButtons.add(saveTitle);
        panelButtons.add(cancelTitle);


        //Never forgot this 2
        this.validate();
        this.repaint();
    }

    /*adding a new customer to db*/
    public void addNewCustomer() {
        //removing any contents
        cancel();
        // grid layout
        GridLayout manager = new GridLayout(2, 1);

        //mouse listener for TF
        customerName.addMouseListener(controller);
        cardNo.addMouseListener(controller);

        //panels
        JPanel panelCustomer = new JPanel();
        JPanel customerInfo = new JPanel();
        JPanel panelButtons = new JPanel();

        //label
        JLabel label = new JLabel("Add a new customer");
        JLabel label1 = new JLabel("Choose the Membership Card");

        //content adding the elements
        contentPanel.add(label);
        contentPanelMenu.add(panelCustomer);
        contentPanelMenu.add(customerInfo);
        contentPanelButtons.add(panelButtons);
        customerInfo.setLayout(manager);
        panelCustomer.add(label1);

        //Create the combo box, select item at index 2.
        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        membershipList.setModel(new DefaultComboBoxModel<>(CustomerEnum.values()));
        //4 items on THE JComboBox
        membershipList.setSelectedItem(0);
        //panel adding the elements
        panelCustomer.add(membershipList);
        customerInfo.add(customerName);
        customerInfo.add(cardNo);

        //buttons, and the action command for that button and the action listener
        JButton add_customer = new JButton("Add Customer");
        JButton cancel = new JButton("Cancel");
        add_customer.setActionCommand("Adding Customer");
        cancel.setActionCommand("Cancel");
        add_customer.addActionListener(controller);
        cancel.addActionListener(controller);
        panelButtons.add(add_customer);
        panelButtons.add(cancel);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    //This method will show a table with the customer list and it allow you to edit 2 cells in the table and you can update in the db
    public void updateMembership(List<Customer> listCustomer) {

        //contents remove
        cancel();

        //table head
        String[] columnNames = {"Membership number",
                "Customer Name",
                "Card Number",
                "Points",
                "Subscription Plan",
                "Edit",
                "Delete"};

        //defaut table
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        //variables
        Long idCustomer = 0L;
        String customerName = "";
        Integer cardNo = 0;
        String subscriptionPlan = "";
        Integer points = 0;
        Object[] data = {};

        //for to validate the list of customer
        for (Customer c : listCustomer) {
            //adding value to the variables
            idCustomer = c.getIdCustomer();
            customerName =  c.getCustomerName();
            cardNo = c.getCardNo();
            subscriptionPlan = c.getSubscriptionPlanDescription();
            points = c.getPoints();
            data = new Object[]{idCustomer, customerName, cardNo, points, subscriptionPlan, "Edit", "Delete"};
            tableModel.addRow(data);
        }


        //table with a method that allow to edit the cell
        JTable table = new JTable(tableModel) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return (column == 2 || column == 4 || column == 5 || column == 6);

            }
        };

        //table column
        TableColumn plan = table.getColumnModel().getColumn(4);
        //JCombo box for a column to put the enums
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel<>(CustomerEnum.values()));
        plan.setCellEditor(new DefaultCellEditor(comboBox));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        contentPanelMenu.add(scrollpane);

        //updating on db
        Action update = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                //variable
                int modelRow = Integer.valueOf( e.getActionCommand() );
                Customer c = new Customer();
                Customer currentCustomer = listCustomer.get(modelRow);

                //setting c with the elements
                c.setIdCustomer(currentCustomer.getIdCustomer());
                c.setCustomerName(currentCustomer.getCustomerName());
                c.setPoints(currentCustomer.getPoints());

                //variables
                Integer cardNumber = Integer.parseInt( tableModel.getValueAt(modelRow, 2).toString() );
                String subscription = tableModel.getValueAt(modelRow, 4).toString();

                //object with the customer enum gettting value at row and column
                Object customerEnumObj = tableModel.getValueAt(modelRow, 4);
                //
                CustomerEnum customerEnum = customerEnumObj != null ? (CustomerEnum) customerEnumObj : null;

                //checking if the elements are different
                if(cardNumber != currentCustomer.getCardNo() || !subscription.equals(currentCustomer.getSubscriptionPlan().getDescription())){
                    c.setCardNo(cardNumber);
                    c.setSubscriptionPlan(customerEnum);
                    controller.update(c);
                }
            }
        };

        //creating a button that will be in a cell inside de table for updating
        ButtonColumn buttonColumnUpdate = new ButtonColumn(table, update, 5);
        buttonColumnUpdate.setMnemonic(KeyEvent.VK_D);

        //class that deleting on db
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                //variable
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand());

                for(int i = 0; i < listCustomer.size(); i++){
                    if(modelRow == i){
                        controller.delete(listCustomer.get(i));
                    }
                }
                ((DefaultTableModel)table.getModel()).removeRow(modelRow);
            }
        };
        //creating a button that will be in a cell inside de table for delete
        ButtonColumn buttonColumnDelete = new ButtonColumn(table, delete, 6);
        buttonColumnDelete.setMnemonic(KeyEvent.VK_D);

        //Never Forget this 2
        this.validate();
        this.repaint();
    }

    public void rent() {
        //remove all contents
        cancel();

        JButton verifyButton = new JButton("Rent");
        JButton cancel = new JButton("Cancel");

        customerVerify.addMouseListener(controller);
        titleVerify.addMouseListener(controller);
        verifyButton.setActionCommand("Rent");
        cancel.setActionCommand("Cancel");
        verifyButton.addActionListener(controller);
        cancel.addActionListener(controller);

        contentPanelMenu.add(customerVerify);
        contentPanelMenu.add(titleVerify);
        contentPanelMenu.add(verifyButton);
        contentPanelMenu.add(cancel);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    public void returnItem() {
        cancel();

        JButton returnButton = new JButton("Return Item");
        JButton cancel = new JButton("Cancel");

        customerReturn.addMouseListener(controller);
        titleReturn.addMouseListener(controller);
        returnButton.setActionCommand("Return Item");
        cancel.setActionCommand("Cancel");
        returnButton.addActionListener(controller);
        cancel.addActionListener(controller);

        contentPanelMenu.add(customerReturn);
        contentPanelMenu.add(titleReturn);
        contentPanelButtons.add(returnButton);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    public void cancel() {
        //remove all contents
        this.contentPanel.removeAll();
        this.contentPanelMenu.removeAll();
        this.contentPanelButtons.removeAll();
    }

    public void payment(Customer points){

        JOptionPane payment = new JOptionPane(
                "Would you like to pay by card or points?");
        Object[] options = new String[] { "Card", "Points" };
        payment.setOptions(options);
        JDialog dialog = payment.createDialog(this, "Dilaog");
        dialog.show();
        Object obj = payment.getValue();
        String result = "";
        for (int k = 0; k < options.length; k++)
            if (options[k].equals(obj))
                result = String.valueOf(k);

            if(obj.equals("Points")){
            }

        System.out.println("User's choice: " + result);
    }


    /*Error messages*/
    public void error(String message){

        JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                JOptionPane.ERROR_MESSAGE);

    }
    //method that will print in a table the titles of movie
    public void searchMovie(List<Movie> movie){
        cancel();

        String[] columnNames = {"ID",
                "Media",
                "Title",
                "Year Of Release",
                "Director",
                "Genre"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        Long id = 0L;
        String media = "";
        String title = "";
        String yearOfRelease = "";
        String director = "";
        String genre = "";
        Object[] data = {};

        for (Movie m : movie) {
            id = m.getIdMovie();
            media =  m.getMedia().toString();
            title = m.getTitle();
            yearOfRelease = m.getYearOfRelease();
            director = m.getDirector();
            genre = m.getGenreMovie();
            data = new Object[]{id, media, title, yearOfRelease, director, genre};

            tableModel.addRow(data);
        }
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        contentPanelMenu.add(scrollpane);

        this.validate();
        this.repaint();

    }
    //method that will print in a table the titles of BoxSet
    public void searchBoxSet(List<BoxSet> boxSet){
        cancel();

        String[] columnNames = {"ID",
                "Media",
                "Title",
                "Year Of Release",
                "Director",
                "Genre"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        Long id = 0L;
        String media = "";
        String title = "";
        String yearOfRelease = "";
        String director = "";
        String genre ="";
        Object[] data = {};

        for (BoxSet b : boxSet) {
            id = b.getIdBoxSet();
            media =  b.getMedia().toString();
            title = b.getTitle();
            yearOfRelease = b.getYearOfRelease();
            director = b.getDirectorBoxSet();
            genre = b.getGenreBoxSet();
            data = new Object[]{id, media, title, yearOfRelease, director, genre};

            tableModel.addRow(data);
        }
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        contentPanelMenu.add(scrollpane);

        this.validate();
        this.repaint();

    }
    //method that will print in a table the titles of Music
    public void searchMusic(List<Music> music){
        cancel();

        String[] columnNames = {"ID",
                "Media",
                "Title",
                "Year Of Release",
                "Band",
                "Genre"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        Long id = 0L;
        String media = "";
        String title = "";
        String yearOfRelease = "";
        String band = "";
        String genre ="";
        Object[] data = {};

        for (Music m : music) {
            id = m.getIdMusic();
            media =  m.getMedia().toString();
            title = m.getTitle();
            yearOfRelease = m.getYearOfRelease();
            band = m.getBand();
            genre = m.getGenreMusic();
            data = new Object[]{id, media, title, yearOfRelease, band, genre};

            tableModel.addRow(data);
        }
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        contentPanelMenu.add(scrollpane);

        this.validate();
        this.repaint();

    }
    //method that will print in a table the titles of Live Consert
    public void searchLiveConsert(List<LiveConsert> liveConsert){
        cancel();

        String[] columnNames = {"ID",
                "Media",
                "Title",
                "Year Of Release",
                "Band",
                "Genre"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        Long id = 0L;
        String media = "";
        String title = "";
        String yearOfRelease = "";
        String band = "";
        String genre ="";
        Object[] data = {};

        for (LiveConsert l : liveConsert) {
            id = l.getIdLiveConsert();
            media =  l.getMedia().toString();
            title = l.getTitle();
            yearOfRelease = l.getYearOfRelease();
            band = l.getBandLiveConsert();
            genre = l.getGenreLiveConsert();
            data = new Object[]{id, media, title, yearOfRelease, band, genre};

            tableModel.addRow(data);
        }
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        contentPanelMenu.add(scrollpane);

        this.validate();
        this.repaint();


    }

    /*Getter a nd Setters*/

    public JTextField getCustomer() {
        return customer;
    }

    public void setCustomer(JTextField customer) {
        this.customer = customer;
    }

    public JTextField getTitleV() {
        return titleV;
    }

    public void setTitleV(JTextField titleV) {
        this.titleV = titleV;
    }

    public JTextField getTitleOp() {
        return titleOp;
    }

    public void setTitleOp(JTextField titleOp) {
        this.titleOp = titleOp;
    }

    public JTextField getYearOfReleaseTitle() {
        return yearOfReleaseTitle;
    }

    public void setYearOfReleaseTitle(JTextField yearOfReleaseTitle) {
        this.yearOfReleaseTitle = yearOfReleaseTitle;
    }

    public JTextField getBandTitle() {
        return bandTitle;
    }

    public void setBandTitle(JTextField bandTitle) {
        this.bandTitle = bandTitle;
    }

    public JTextField getGenreMusicTitle() {
        return genreMusicTitle;
    }

    public void setGenreMusicTitle(JTextField genreMusicTitle) {
        this.genreMusicTitle = genreMusicTitle;
    }

    public JTextField getTitleM() {
        return titleM;
    }

    public void setTitleM(JTextField titleM) {
        this.titleM = titleM;
    }

    public JTextField getYearOfReleaseMovie() {
        return yearOfReleaseMovie;
    }

    public void setYearOfReleaseMovie(JTextField yearOfReleaseMovie) {
        this.yearOfReleaseMovie = yearOfReleaseMovie;
    }

    public JTextField getDirector() {
        return director;
    }

    public void setDirector(JTextField director) {
        this.director = director;
    }

    public JTextField getGenreMovieTitle() {
        return genreMovieTitle;
    }

    public void setGenreMovieTitle(JTextField genreMovieTitle) {
        this.genreMovieTitle = genreMovieTitle;
    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public void setCustomerName(JTextField customerName) {
        this.customerName = customerName;
    }

    public JTextField getCardNo() {
        return cardNo;
    }

    public void setCardNo(JTextField cardNo) {
        this.cardNo = cardNo;
    }

    public JComboBox<MediaEnum> getMedia() {
        return media;
    }

    public void setMedia(JComboBox<MediaEnum> media) {
        this.media = media;
    }

    public JComboBox<CustomerEnum> getMembershipList() {
        return membershipList;
    }

    public void setMembershipList(JComboBox<CustomerEnum> membershipList) {
        this.membershipList = membershipList;
    }

    public JTextField getCustomerVerify() {
        return customerVerify;
    }

    public void setCustomerVerify(JTextField customerVerify) {
        this.customerVerify = customerVerify;
    }

    public JTextField getTitleVerify() {
        return titleVerify;
    }

    public void setTitleVerify(JTextField titleVerify) {
        this.titleVerify = titleVerify;
    }

    public JTextField getTitleReturn() {
        return titleReturn;
    }

    public void setTitleReturn(JTextField titleReturn) {
        this.titleReturn = titleReturn;
    }

    public JTextField getCustomerReturn() {
        return customerReturn;
    }

    public void setCustomerReturn(JTextField customerReturn) {
        this.customerReturn = customerReturn;
    }
}
