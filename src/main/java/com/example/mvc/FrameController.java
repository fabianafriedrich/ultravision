package com.example.mvc;
import com.example.model.Music;
import com.example.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Year;


@Component
public class FrameController implements MouseListener, ActionListener{

    @Autowired
    private View view;

    @Autowired(required=true)
    private MusicService musicService;

    // Internal reference to the object view
//    View view = null;

    /*
     * The constructor is in charge of creating the
     * new view
     */

    public FrameController(){
//        view = new View(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Add Title")) {
            System.out.println("Add Title");
            view.addTitle();
        }else if(e.getActionCommand().equals("Add Customer")) {
            System.out.println("Add Customer");
            view.addNewCustomer();

        }else if(e.getActionCommand().equals("Rent Item")) {
            System.out.println("Rent Item");
            view.rent();
        }else if(e.getActionCommand().equals("Returned Item")) {
            System.out.println("Returned Item");
            view.returnItem();
        }else if(e.getActionCommand().equals("Membership Card Update")) {
            System.out.println("Membership Card Update");
            view.updateMembership();
        }

        if(e.getActionCommand().equals("search for category")){
           view.addingTitle();

        }else if(e.getActionCommand().equals("Search Title")){
            String getTitle = view.titleV.getText();
            System.out.println(getTitle);
            if(!getTitle.equals("Search Title")){
                //Code search in Database and show;
                view.titleV.setText("Search Title");
            }else {

                //not found
            }

        }else if(e.getActionCommand().equals("Search Customer")){
            String getCustomer = view.customer.getText();
            System.out.println(getCustomer);
            if(!getCustomer.equals("Search Title")){
                //Code search in Database and show;
                view.customer.setText("Search Customer");
            }else {

                //not found
            }
        }else if(e.getActionCommand().equals("Save Title")){
           String categoryList = String.valueOf(view.categoryList.getSelectedItem());
            if(categoryList.equals("Music")){
                Music music = new Music();
                String media = String.valueOf(view.mediaList.getSelectedItem());
                music.setMedia(media);
                String titleOp = view.titleOp.getText();
                music.setTitle(titleOp);
                Year yearOfReleaseTitle = Year.parse(view.yearOfReleaseTitle.getText());
                music.setYearOfRelease(yearOfReleaseTitle);
                String bandTitle = view.bandTitle.getText();
                music.setBand(bandTitle);
                String genreMusicTitle = view.genreMusicTitle.getText();
                music.setGenreMusic(genreMusicTitle);
                System.out.println(titleOp + yearOfReleaseTitle + bandTitle + genreMusicTitle);
                if(!titleOp.equals("Title") && !yearOfReleaseTitle.equals("Year Of Release")&& !bandTitle.equals("Band")&& !genreMusicTitle.equals("Genre Music")){
                    //save in db
                    musicService.save(music);

                    view.titleOp.setText("Title");
                    view.yearOfReleaseTitle.setText("Year Of Release");
                    view.bandTitle.setText("Band");
                    view.genreMusicTitle.setText("Genre Music");
                }else {

                    //not found
                }

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource().equals(view.customer)){
            view.customer.setText("");
        }else if (e.getSource().equals(view.titleV)) {
            view.titleV.setText("");
        }else if (e.getSource().equals(view.titleOp)){
            view.titleOp.setText("");
        }else if (e.getSource().equals(view.yearOfReleaseTitle)){
            view.yearOfReleaseTitle.setText("");
        }else if (e.getSource().equals(view.bandTitle)){
            view.bandTitle.setText("");
        }else if (e.getSource().equals(view.genreMusicTitle)){
            view.genreMusicTitle.setText("");
        }
    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
