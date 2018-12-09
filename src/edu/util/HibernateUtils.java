package edu.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final Configuration cfg;
    private static final SessionFactory sf;
    static {
        cfg=new Configuration().configure();
        sf=cfg.buildSessionFactory();
    }
    public static Session getSession(){
        return sf.openSession();
    }
/*
   private static final SessionFactory sf;
   static {
       try{
           Configuration cfg=new Configuration().configure();
           sf=cfg.buildSessionFactory();
       }catch (Throwable ex){
           System.err.println("sf initial error"+ex);
           throw  new ExceptionInInitializerError(ex);
       }
   }
   private static final ThreadLocal<Session>sessions=new ThreadLocal<Session>();

   public static Session getSession() throws HibernateException{
       Session session=sessions.get();
       if(null == session){
           session=sf.openSession();
           sessions.set(session);
       }
       return session;
   }
   public static void closeSession()throws HibernateException{
       Session s=sessions.get();
       if(s!=null){
           s.close();
       }
       sessions.set(null);
   }*/
}
