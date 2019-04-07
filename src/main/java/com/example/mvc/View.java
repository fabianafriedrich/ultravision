package com.example.mvc;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

import static java.awt.BorderLayout.PAGE_START;
@Component
public class View extends JFrame {

    // Reference to the controller
    private FrameController controller;


    //Global Variables
    JTextField customer = new JTextField("Search Customer", 15);
    JTextField titleV = new JTextField("Search Title", 15);
    JButton searchTitle = new JButton("Search");
    JButton searchCustomer = new JButton("Search");

    JTextField titleOp = new JTextField("Title", 15);
    JTextField yearOfReleaseTitle = new JTextField("Year Of Release", 15);
    JTextField bandTitle = new JTextField("Band", 15);
    JTextField genreMusicTitle = new JTextField("Genre Music", 15);

    JButton saveTitle = new JButton("Save");
    JButton cancelTitle = new JButton("Cancel");


    //List String
    List<String> category = Arrays.asList("Music", "Live Concert Videos", "Movie", "Box Set");
    JComboBox categoryList;

    List<String> media = Arrays.asList("DVD", "Blu-Ray", "CD");
    JComboBox mediaList;

    private JPanel contentPanel = new JPanel();
    private JPanel contentPanelMenu = new JPanel();

    /*
     * The constructor needs to have get a the
	 * controller from outside
	 */
    public View(FrameController controllerFromOutside) {

        // Internal reference from controller
        this.controller = controllerFromOutside;


        // Calling methods to set windows
        this.settings();

        this.painting();

    }

    /*
     * Settings
	 */
    private void settings() {
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         /*Logo*/
        ImageIcon img = new ImageIcon("C:\\Users\\Fabiana\\Downloads\\ultravision\\ultravision\\images\\2.png");
        this.setIconImage(img.getImage());


    }

    /*
	 * All elements of the frame
	 */
    public void painting() {
        JMenuBar myMenuBar = new JMenuBar();
        JMenu addMenu = new JMenu("Add Menu");
        JMenu updateMenu = new JMenu("Membership Card Update");
        JMenuItem update = new JMenuItem("Membership Card Update");
        JMenu register = new JMenu("Register");
        JMenuItem addTitle = new JMenuItem("Add Title");
        JMenuItem addCustomer = new JMenuItem("Add Customer");
        JMenuItem rent = new JMenuItem("Rent Item");
        JMenuItem returned = new JMenuItem("Returned Item");

        searchTitle.setActionCommand("Search Title");
        searchCustomer.setActionCommand("Search Customer");

        this.setJMenuBar(myMenuBar);
        myMenuBar.add(addMenu);
        myMenuBar.add(updateMenu);
        myMenuBar.add(register);
        updateMenu.add(update);
        addMenu.add(addTitle);
        addMenu.add(addCustomer);
        updateMenu.add(update);
        register.add(rent);
        register.add(returned);

        myMenuBar.add(customer);
        myMenuBar.add(searchCustomer);
        myMenuBar.add(titleV);
        myMenuBar.add(searchTitle);

        update.addActionListener(controller);

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

        // Never forget these two
        this.validate();
        this.repaint();
    }


    public void addTitle() {

        this.contentPanel.removeAll();

//      Cast from List to Array and use that array in JCobomBox
        String[] stockArr = new String[category.size()];
        stockArr = category.toArray(stockArr);

        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Choose the Title Category");

        //Adding to the panel
        panel.add(label1);

        //Create the combo box, select item at index 2.
        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        categoryList = new JComboBox(stockArr);
        //4 items on THE JComboBox
        categoryList.setSelectedItem(0);
        //Adding cb the panel
        panel.add(categoryList);
        //Printing the item selected


        JLabel label2 = new JLabel("Choose the Title Media");
        //      Cast from List to Array and use that array in JCobomBox
        String[] stockArr2 = new String[media.size()];
        stockArr2 = media.toArray(stockArr2);


        //Adding to the frame
        contentPanel.add(panel, BorderLayout.PAGE_START);
        //Adding to the pane2
        panel.add(label2);

        //Create the combo box, select item at index 2.
        //Indices start at 0, so 2 specifies the CD.
        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        mediaList = new JComboBox(stockArr2);
        //4 items on THE JComboBox
        mediaList.setSelectedIndex(2);
        //Adding cb the panel
        panel.add(mediaList);
        //Printing the item selected
        System.out.println(mediaList.getSelectedItem());

        JButton buttonSearch = new JButton("Search");
        buttonSearch.setActionCommand("search for category");
        buttonSearch.addActionListener(controller);
        panel.add(buttonSearch);


        // Never forget these two
        this.validate();
        this.repaint();
    }


    public void addingTitle() {
        this.contentPanelMenu.removeAll();

        if (categoryList.getSelectedItem().equals("Music") || categoryList.getSelectedItem().equals("Live Concert Videos")) {
            JPanel panelInfoMusic = new JPanel();
            saveTitle.setActionCommand("Save Title");
            cancelTitle.setActionCommand("Cancel Title");

            saveTitle.addActionListener(controller);
            cancelTitle.addActionListener(controller);

            titleOp.addMouseListener(controller);
            yearOfReleaseTitle.addMouseListener(controller);
            bandTitle.addMouseListener(controller);
            genreMusicTitle.addMouseListener(controller);

            contentPanelMenu.add(panelInfoMusic, BorderLayout.CENTER);
            GridLayout manager = new GridLayout(4, 1);
            panelInfoMusic.setLayout(manager);
            panelInfoMusic.add(titleOp);
            panelInfoMusic.add(yearOfReleaseTitle);
            panelInfoMusic.add(bandTitle);
            panelInfoMusic.add(genreMusicTitle);


        } else if (categoryList.getSelectedItem().equals("Movie") || categoryList.getSelectedItem().equals("Box Set")) {

            /*Panel Movie and Box Set*/
            JTextField titleM = new JTextField("Title", 15);
            JTextField yearOfReleaseMovie = new JTextField("Year Of Release", 15);
            JTextField director = new JTextField("Director", 15);
            JTextField genreMovieTitle = new JTextField("Genre Movie", 15);

            JPanel panelInfoMovie = new JPanel();
            contentPanelMenu.add(panelInfoMovie, BorderLayout.CENTER);
            GridLayout manager = new GridLayout(4, 1);

            panelInfoMovie.setLayout(manager);
            panelInfoMovie.add(titleM);
            panelInfoMovie.add(yearOfReleaseMovie);
            panelInfoMovie.add(director);
            panelInfoMovie.add(genreMovieTitle);

        }

        JPanel panelButtons = new JPanel();
        contentPanelMenu.add(panelButtons, BorderLayout.PAGE_END);

        panelButtons.add(saveTitle);
        panelButtons.add(cancelTitle);


        this.validate();
        this.repaint();
    }


    public void addNewCustomer() {
        this.contentPanel.removeAll();
        this.contentPanelMenu.removeAll();
        GridLayout manager = new GridLayout(2, 1);
        List<String> membership = Arrays.asList("Music Lovers", "Video Lovers", " TV Lover", "Premium");
        //Cast from List to Array and use that array in JCobomBox
        String[] stockArr = new String[membership.size()];
        stockArr = membership.toArray(stockArr);

        JComboBox membershipList;

        JPanel panelCustomer = new JPanel();
        JPanel customerInfo = new JPanel();
        JPanel panelButtons = new JPanel();

        JLabel label1 = new JLabel("Choose the Membership Card");
        JTextField name = new JTextField("Type your full name", 15);
        JTextField cardNo = new JTextField("Card Number", 15);


        contentPanel.add(panelCustomer, BorderLayout.PAGE_START);
        contentPanel.add(customerInfo, BorderLayout.CENTER);
        contentPanel.add(panelButtons, BorderLayout.PAGE_END);
        customerInfo.setLayout(manager);
        //Adding to the panel
        panelCustomer.add(label1);

        //Create the combo box, select item at index 2.
        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        membershipList = new JComboBox(stockArr);
        //4 items on THE JComboBox
        membershipList.setSelectedItem(0);
        //Adding cb the panel
        panelCustomer.add(membershipList);
        customerInfo.add(name);
        customerInfo.add(cardNo);

        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");
        panelButtons.add(save);
        panelButtons.add(cancel);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    public void updateMembership(){
        this.contentPanel.removeAll();
        this.contentPanelMenu.removeAll();
        GridLayout manager = new GridLayout(2, 1);
        List<String> membership = Arrays.asList("Music Lovers", "Video Lovers", " TV Lover", "Premium");
        //Cast from List to Array and use that array in JCobomBox
        String[] stockArr = new String[membership.size()];
        stockArr = membership.toArray(stockArr);

        JComboBox membershipList;

        JPanel panelCustomer = new JPanel();
        JPanel customerInfo = new JPanel();
        JPanel panelButtons = new JPanel();

        JLabel labelInfo = new JLabel("Update Customer Informatin");
        JLabel label1 = new JLabel("Choose the Membership Card");
        JTextField name = new JTextField("Customer Name", 15);
        JTextField cardNo = new JTextField("Card Number", 15);


        contentPanel.add(labelInfo, BorderLayout.PAGE_START);
        contentPanel.add(panelCustomer, BorderLayout.PAGE_START);
        contentPanel.add(customerInfo, BorderLayout.CENTER);
        contentPanel.add(panelButtons, BorderLayout.PAGE_END);
        customerInfo.setLayout(manager);
        //Adding to the panel

        panelCustomer.add( label1);

        //Create the combo box, select item at index 2.
        // The JComboBox drop-down list of choices and lets the user selects one item from the list
        membershipList = new JComboBox(stockArr);
        //4 items on THE JComboBox
        membershipList.setSelectedItem(0);
        //Adding cb the panel
        panelCustomer.add(membershipList);
        customerInfo.add(name);
        customerInfo.add(cardNo);

        JButton save = new JButton("Update");
        JButton cancel = new JButton("Cancel");
        panelButtons.add(save);
        panelButtons.add(cancel);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    public void rent(){
        this.contentPanel.removeAll();
        this.contentPanelMenu.removeAll();

        JTextField customerVerify = new JTextField("Customer Name",15);
        JTextField titleVerify = new JTextField("Title", 15);
        JButton verifyButton = new JButton(" Verifying that they are entitled ");

        contentPanel.add(customerVerify);
        contentPanel.add(titleVerify);
        contentPanel.add(verifyButton);

        // Never forget these two
        this.validate();
        this.repaint();
    }

    public void returnItem(){
        this.contentPanel.removeAll();
        this.contentPanelMenu.removeAll();

        JTextField customerReturn = new JTextField("Customer Name",15);
        JTextField titleReturn = new JTextField("Title Return", 15);
        JButton returnButton = new JButton("Return Item");

        contentPanel.add(customerReturn);
        contentPanel.add(titleReturn);
        contentPanel.add(returnButton);

        // Never forget these two
        this.validate();
        this.repaint();
    }



}
