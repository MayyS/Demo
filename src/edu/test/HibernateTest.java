package edu.test;

import edu.business.movieticket.entity.embed.Auditorium;
import edu.business.movieticket.entity.Cinema;
import edu.business.movieticket.entity.embed.Hall;
import edu.business.movieticket.entity.embed.Screen;
import edu.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void testDaoimpl(){
        Auditorium auditorium=new Auditorium();
        Screen screen=new Screen();
        screen.setPrice(100);
        screen.setScreen_name("okok");
        Hall hall=new Hall();
        hall.setAuditorium(auditorium);
        hall.setScreen(screen);
        Cinema cinema=new Cinema();
        cinema.setAddress("zhongsd");
        cinema.setHall(hall);
        Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.save(cinema);
        tx.commit();
        session.close();

    }


/*

    @Test
    public void TestSave(){
        Session session= HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        Movie movie1=new Movie();
        movie1.setName("SEcTry");
        Celeberity celeberity=new Celeberity();
        celeberity.setGender(false);
        celeberity.setHomePlace("sdfsdfsddfasdfasdfs");
        movie1.getCelebrity().add(celeberity);
        session.save(movie1);
        tx.commit();
        session.close();
    }
    @Test
    public void TestDelete(){
        Session session= HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        Movie mov=(Movie) session.get(Movie.class,3);
        session.delete(mov);
        tx.commit();
        session.close();
    }
    @Test
    public void TestS(){
        Celeberity c1=new Celeberity();
        c1.setId(4);
        c1.setGender(true);
        c1.setName("nod");
        Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.update(c1);
        tx.commit();
        session.close();
    }
*/
/*
@Test
    public void TestUserInsert(){
        User user=new User();
        user.setAccount("admin");
        user.setUsername("test");
        user.setPassword("1234");
        UserService userService=new UserSeriveImpl();
        if (userService.checkIn(user)!=null){
            System.out.println("ok");
        }
        else{
            System.out.println("NO");
        }

    }*/
/*
    @Test
    public void TestMoive(){
        MovieService movieService=new MovieServiceImpl();
        for (Movie movie1:movieService.findObject("from Movie")){
            System.out.println(movie1.toString());
        }
        for (Movie movie:movieService.searchObject("name","my")){
            System.out.println(movie.toString());
        }
    }*/
   /*
    @Test
    public void TestMM(){
        User user=new User();
        user.setId(3);
        user.setAccount("testmm");
        user.setPassword("12345");
        user.setUsername("testm");
        UserService userService=new UserSeriveImpl();
        userService.save(user);
        MovieService movieService=new MovieServiceImpl();
        List list=movieService.searchObject("name","7",1,1).getItems();
        for (Object item:list) {
            user.getMovies().add((Movie)item);
        }
        userService.update(user);
    }*/
/*   @Test
    public void ttt(){
       Movie movie=new Movie();
       movie.setName("test2");
       MovieService movieService=new MovieServiceImpl();
       movieService.save(movie);
   }*/




}
