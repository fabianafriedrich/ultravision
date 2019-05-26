package com.example.mvc;

import com.example.enums.CustomerEnum;
import com.example.enums.MediaEnum;
import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class FrameController implements MouseListener, ActionListener {

    /*Dependence Injection*/
    @Autowired
    private View view;
    @Autowired(required = true)
    private MusicService musicService;
    @Autowired(required = true)
    private MovieService movieService;
    @Autowired(required = true)
    private LiveConsertService liveConsertService;
    @Autowired(required = true)
    private BoxSetService boxSetService;
    @Autowired(required = true)
    private CustomerService customerService;
    @Autowired(required = true)
    private RentService rentService;

    /*
     * The constructor
     */

    public FrameController() {
    }

//    public Rent rented(Rent rent){
//
//    }
    //saving the elements on the obj Rent
    public Rent rent(Customer customer){
        Rent rent = new Rent();
        Date currentDate = new Date();
        rent.setDateRented(currentDate);
        rent.setRented(true);
        rent.setCustomer(customer);

        return rent;
    }
    public Rent returned(List returned){
        Rent rent = new Rent();
        Date currentReturned = new Date();
        rent.setDateReturnedRent(currentReturned);
        rent.setRented(false);
        return rent;
    }

    //checking if its available to rent
    public boolean countRent(Customer id){
        boolean isAvailable;
        int countRented = 0;
        List<Rent> rentList = rentService.find(id);
        if(!rentList.isEmpty()){
            for(Rent r : rentList){
                if(r.isRented()){
                    countRented++;
                }
            }
            if(countRented < 4){

                isAvailable = true;
            }else {
                isAvailable =false;
            }
        }else {
            isAvailable = true;
        }

        return isAvailable;
    }

    //adding points to the customer after rent
    public Customer addPoints(Customer customer){
        int extraPoints = 10;
        int currentPoints = customer.getPoints();
        int result = currentPoints + extraPoints;
        customer.setPoints(result);

        return customer;
    }
    /*ActinPerfored the event when a button is clicked*/
    @Override
    public void actionPerformed(ActionEvent e) {

        /*Menu action*/
        if (e.getActionCommand().equals("Add Title")) {
            System.out.println("Add Title");
            view.addTitle();
        } else if (e.getActionCommand().equals("Add Customer")) {
            System.out.println("Add Customer");
            view.addNewCustomer();

        } else if (e.getActionCommand().equals("Rent Item")) {
            System.out.println("Rent Item");
            view.rent();
        } else if (e.getActionCommand().equals("Returned Item")) {
            System.out.println("Returned Item");
            view.returnItem();
        }

        /*When adding a new title will first  select category (type of title)*/
        if (e.getActionCommand().equals("search for category")) {
            view.addingTitle();

        }

        /*when searching for a customer*/
        if (e.getActionCommand().equals("Search Title")) {
            String title = view.getTitleV().getText();
            System.out.println(title);
            if (!title.equals("Search Title")) {
                //Code search in Database and show;
                List<Movie> movieList = movieService.findByName(title);
                List<Music> musicList = musicService.findByName(title);
                List<BoxSet> boxSetList = boxSetService.findByName(title);
                List<LiveConsert> liveConserts = liveConsertService.findByName(title);
                if (!movieList.isEmpty()){
                    view.searchMovie(movieList);

                }else if(!musicList.isEmpty()){
                    view.searchMusic(musicList);
                }else if(!boxSetList.isEmpty()){
                    view.searchBoxSet(boxSetList);
                }else if(!liveConserts.isEmpty()){
                    view.searchLiveConsert(liveConserts);
                }
                view.getTitleV().setText("Search Title");

            }  else {

                view.error("Sorry Title not found ");
                view.cancel();
            }
        }
        if (e.getActionCommand().equals("Find")) {
            String getCus = view.getCustomer().getText();
            System.out.println(getCus);
            if (!getCus.equals("Search Customer")) {
                //Code search in Database and show and also will be sent to a method that will be able to edit the customer;
                String customerName = view.getCustomer().getText();
                List<Customer> customerList = customerService.findByName(customerName);
                if(!customerList.isEmpty()){
                    view.updateMembership(customerList);
                    view.getCustomer().setText("Search Customer");
                }else{
                    view.error("Sorry Customer not found");
                    view.cancel();
                }

            }

        }

        /*Adding a new Title*/
        if (e.getActionCommand().equals("Add Titles")) {
            String categoryList = String.valueOf(view.categoryList.getSelectedItem());
            //Adding a new title Music and saving on DB
            if (categoryList.equals("Music")) {
                Music music = new Music();
                MediaEnum media = (MediaEnum) view.getMedia().getSelectedItem();
                music.setMedia(media);
                String titleOp = view.getTitleOp().getText();
                music.setTitle(titleOp);
                String yearOfReleaseTitle = view.getYearOfReleaseTitle().getText();
                music.setYearOfRelease(yearOfReleaseTitle);
                String bandTitle = view.getBandTitle().getText();
                music.setBand(bandTitle);
                String genreMusicTitle = view.getGenreMusicTitle().getText();
                music.setGenreMusic(genreMusicTitle);
                System.out.println(titleOp + yearOfReleaseTitle + bandTitle + genreMusicTitle);
                if (!titleOp.equals("Title") && !yearOfReleaseTitle.equals("Year Of Release") && !bandTitle.equals("Band") && !genreMusicTitle.equals("Genre Music")) {
                    //save in db
                    musicService.save(music);

                    view.getTitleOp().setText("Title");
                    view.getYearOfReleaseTitle().setText("Year Of Release");
                    view.getBandTitle().setText("Band");
                    view.getGenreMusicTitle().setText("Genre Music");
                }
                //Adding a new titlle Live concert Videos and saving on DB
            } else if (categoryList.equals("Live Concert Videos")) {
                LiveConsert liveConsert = new LiveConsert();
                MediaEnum media2 = (MediaEnum) view.getMedia().getSelectedItem();
                liveConsert.setMedia(media2);
                String titleOp2 = view.getTitleOp().getText();
                liveConsert.setTitle(titleOp2);
                String yearOfReleaseTitle2 = view.getYearOfReleaseTitle().getText();
                liveConsert.setYearOfRelease(yearOfReleaseTitle2);
                String bandTitle2 = view.getBandTitle().getText();
                liveConsert.setBandLiveConsert(bandTitle2);
                String genreLiveC = view.getGenreMusicTitle().getText();
                liveConsert.setGenreLiveConsert(genreLiveC);
                System.out.println(titleOp2 + yearOfReleaseTitle2 + bandTitle2 + genreLiveC);
                if (!titleOp2.equals("Title") && !yearOfReleaseTitle2.equals("Year Of Release") && !bandTitle2.equals("Band") && !genreLiveC.equals("Genre Music")) {
                    //save in db
                    liveConsertService.save(liveConsert);

                    view.getTitleOp().setText("Title");
                    view.getYearOfReleaseTitle().setText("Year Of Release");
                    view.getBandTitle().setText("Band");
                    view.getGenreMusicTitle().setText("Genre Music");
                }
                //Adding a new title Movie and saving on DB
            } else if (categoryList.equals("Movie")) {
                Movie movie = new Movie();
                MediaEnum media3 = (MediaEnum) view.getMedia().getSelectedItem();
                movie.setMedia(media3);
                String titleM = view.getTitleM().getText();
                movie.setTitle(titleM);
                String yearOfReleaseMovie = view.getYearOfReleaseMovie().getText();
                movie.setYearOfRelease(yearOfReleaseMovie);
                String director = view.getDirector().getText();
                movie.setDirector(director);
                String genreMovie = view.getGenreMovieTitle().getText();
                movie.setGenreMovie(genreMovie);
                System.out.println(titleM + yearOfReleaseMovie + director + genreMovie);
                if (!titleM.equals("Title") && !yearOfReleaseMovie.equals("Year Of Release") && !director.equals("Director") && !genreMovie.equals("Genre Movie")) {
                    //save in db
                    movieService.save(movie);

                    view.getTitleM().setText("Title");
                    view.getYearOfReleaseMovie().setText("Year Of Release");
                    view.getDirector().setText("Director");
                    view.getGenreMovieTitle().setText("Genre Movie");
                }
                /*Adding a new title Box Set and saving on DB*/
            } else if (categoryList.equals("Box Set")) {
                BoxSet boxSet = new BoxSet();
                MediaEnum media4 = (MediaEnum) view.getMedia().getSelectedItem();
                boxSet.setMedia(media4);
                String titleB = view.getTitleM().getText();
                boxSet.setTitle(titleB);
                String yearOfReleaseB = view.getYearOfReleaseMovie().getText();
                boxSet.setYearOfRelease(yearOfReleaseB);
                String directorB = view.getDirector().getText();
                boxSet.setDirectorBoxSet(directorB);
                String genreB = view.getGenreMovieTitle().getText();
                boxSet.setGenreBoxSet(genreB);
                System.out.println(titleB + yearOfReleaseB + directorB + genreB);
                if (!titleB.equals("Title") && !yearOfReleaseB.equals("Year Of Release") && !directorB.equals("Director") && !genreB.equals("Genre Movie")) {
                    //save in db
                    boxSetService.save(boxSet);

                    view.getTitleM().setText("Title");
                    view.getYearOfReleaseMovie().setText("Year Of Release");
                    view.getDirector().setText("Director");
                    view.getGenreMovieTitle().setText("Genre Movie");
                }
            } else {

                view.error("Sorry something went wrong");
                view.cancel();

            }

        }

        //Adding a new Customer and saving on DB
        if(e.getActionCommand().equals("Adding Customer")) {
            Customer newCustomer = new Customer();
            CustomerEnum membershipList = (CustomerEnum) view.getMembershipList().getSelectedItem();
            newCustomer.setSubscriptionPlan(membershipList);
            Integer point = 0;
            newCustomer.setPoints(point);
            String customerName = view.getCustomerName().getText();
            newCustomer.setCustomerName(customerName);
            Integer cardNo = Integer.valueOf(view.getCardNo().getText());
            newCustomer.setCardNo(cardNo);

            if (!customerName.equals("Type your full name") && !cardNo.equals("Card Number") ) {

                customerService.save(newCustomer);

                view.getCustomerName().setText("Type your full name");
                view.getCardNo().setText("Card Number");
            } else {
                view.error("Type your name and card number");
                view.cancel();
            }
        }

        if(e.getActionCommand().equals("Rent")){
            String title = view.getTitleVerify().getText();
            System.out.println(title);
            Boolean movie = false;
            Boolean music = false;
            Boolean boxSet = false;
            Boolean liveConsert = false;
            if (!title.equals("Search Title")) {
                //Code search in Database and show;
                List<Movie> movieList = movieService.findByName(title);
                List<Music> musicList = musicService.findByName(title);
                List<BoxSet> boxSetList = boxSetService.findByName(title);
                List<LiveConsert> liveConserts = liveConsertService.findByName(title);
                if (!movieList.isEmpty()){
                    movie = true;
                }else if(!musicList.isEmpty()){
                    music = true;
                }else if(!boxSetList.isEmpty()){
                    boxSet = true;
                }else if(!liveConserts.isEmpty()){
                    liveConsert = true;
                }
            }
            String getCus = view.getCustomerVerify().getText();
            System.out.println(getCus);
            if (!getCus.equals("Customer Name")) {
                //Code search in Database and show and also will be sent to a method that will be able to edit the customer;
                List<Customer> customerList = customerService.findByName(getCus);
                if(!customerList.isEmpty()){
                    for(Customer c : customerList){
                        if ((c.getSubscriptionPlan().toString().equals("MUSIC LOVERS")) && (music == true || liveConsert == true)){
                            boolean isAvailable = countRent(c);
                            if(isAvailable){

                                Rent rent = rent(c);
                                rent.setTitleName(title);
                                rentService.save(rent);
                                Customer points = addPoints(c);
                                update(points);
                                view.payment(points);


                            }else{view.error("Sorry customer has alredy rented 4 titles");}
                        }else if(c.getSubscriptionPlan().toString().equals("VIDEO_LOVERS") && movie == true){
                            boolean isAvailable = countRent(c);
                            if(isAvailable){
                                Rent rent = rent(c);
                                rent.setTitleName(title);
                                rentService.save(rent);
                                Customer points = addPoints(c);
                                update(points);
                                view.payment(points);

                            }else{view.error("Sorry customer has alredy rented 4 titles");}

                        }else if(c.getSubscriptionPlan().toString().equals("TV_LOVERS") && boxSet == true){
                            boolean isAvailable = countRent(c);
                            if(isAvailable){
                                Rent rent = rent(c);
                                rent.setTitleName(title);
                                rentService.save(rent);
                                Customer points = addPoints(c);
                                update(points);
                                view.payment(points);

                            }else{view.error("Sorry customer has alredy rented 4 titles");}

                        }else if(c.getSubscriptionPlan().toString().equals("PREMIUM")){
                            boolean isAvailable = countRent(c);
                            if(isAvailable){
                                Rent rent = rent(c);
                                rent.setTitleName(title);
                                rentService.save(rent);
                                Customer points = addPoints(c);
                                update(points);
                                view.payment(points);


                            }else{view.error("Sorry customer has alredy rented 4 titles");}
                        }else{
                            view.error("Sorry but the customer Plan is not ");
                        }
                    }
                }else{
                    view.error("Sorry Customer not found ");
                    view.cancel();
                }
                view.getCustomerVerify().setText("Customer Name");
                view.getTitleVerify().setText("Title");
            }
        } else if (e.getActionCommand().equals("Return Item")) {
                String title = view.getTitleReturn().getText();
                String customerName = view.getCustomerReturn().getText();
                List<Customer> customers = customerService.findByName(customerName);
                Customer customer = customers.get(0);
                if (!title.equals("Customer Name") && !customerName.equals("Title Return")) {

                    List<Rent> rentList2 = rentService.findBy(title, customer);
                    Rent rent = rentList2.get(0);
                    Date currentReturned = new Date();
                    rent.setDateReturnedRent(currentReturned);
                    rent.setRented(false);
                    rentList2.add(rent);
                    updateRent(rent);

                }
        }


        if (e.getActionCommand().equals("Cancel")){
            view.cancel();
        }

    }

    /*MouseListener for when cick in a TF it will make it blank the field*/

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(view.getCustomer())) {
            view.getCustomer().setText("");
        } else if (e.getSource().equals(view.getTitleV())) {
            view.getTitleV().setText("");
        } else if (e.getSource().equals(view.getTitleOp())) {
            view.getTitleOp().setText("");
        } else if (e.getSource().equals(view.getYearOfReleaseTitle())) {
            view.getYearOfReleaseTitle().setText("");
        } else if (e.getSource().equals(view.getBandTitle())) {
            view.getBandTitle().setText("");
        } else if (e.getSource().equals(view.getGenreMusicTitle())) {
            view.getGenreMusicTitle().setText("");
        } else if (e.getSource().equals(view.getTitleM())) {
            view.getTitleM().setText("");
        } else if (e.getSource().equals(view.getYearOfReleaseMovie())) {
            view.getYearOfReleaseMovie().setText("");
        } else if (e.getSource().equals(view.getDirector())) {
            view.getDirector().setText("");
        } else if (e.getSource().equals(view.getGenreMovieTitle())) {
            view.getGenreMovieTitle().setText("");
        }else if (e.getSource().equals(view.getCustomerName())) {
            view.getCustomerName().setText("");
        }else if (e.getSource().equals(view.getCardNo())) {
            view.getCardNo().setText("");
        }else if(e.getSource().equals(view.getCustomerVerify())){
            view.getCustomerVerify().setText("");
        }else if(e.getSource().equals(view.getTitleVerify())){
            view.getTitleVerify().setText("");
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

    /*method to delete a customer in db*/
    public void delete(Customer customer){
        customerService.delete(customer);
    }
    /*method to update a customer in db*/
    public void update(Customer customer){
        customerService.updateCustomer(customer);
    }
    /*method to update a rent in db*/
    public void updateRent(Rent rent){
        rentService.update(rent);
    }
}
