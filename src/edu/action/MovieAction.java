package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import edu.base.action.BaseAction;
import edu.dao.MovieDao;
import edu.entity.Movie;
import edu.entity.PageResult;
import edu.entity.User;
import edu.service.MovieService;
import edu.service.impl.MovieServiceImpl;
import edu.util.DaoFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MovieAction extends BaseAction implements ModelDriven<Movie> {
    private String attr;
    private String val;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    private Movie movie=new Movie();

    @Override
    public Movie getModel() {
        return movie;
    }

    private List<Movie>movies;

    public List<Movie> getMovies() {
        return movies;
    }

    private MovieService movieService=new MovieServiceImpl();

    public String topUI(){
        String hql="from Movie as m where m.origin ='douban'";
        pageResult=movieService.findObject(hql,getPageNo(),getPageSize());
        handle();
        return "topUI";
    }

    public String myCommentUI(){
        String useraccount=((User)ActionContext.getContext().getSession().get("user")).getAccount();
        String hql="from Movie as m where m.origin ='"+useraccount+"'";
        System.out.println(hql);
        pageResult=movieService.findObject(hql,getPageNo(),getPageSize());
        return "myCommentUI";
    }

    public String goCommentUI(){
        return "goCommentUI";
    }

    public String iComment(){
        if (movieService.save(movie)==-1){
            return "fail";
        }
        return "list";
    }
    public String search(){
        System.out.println(attr+"="+getAttr());
        System.out.println(val+"="+getVal());
        if("".equals(movie.getName())){
            return topUI();
        }
        pageResult=movieService.searchObject(getAttr(),getVal(),1,getPageSize());
        handle();
        return "topUI";
    }

    public String detailPage(){
        movie=movieService.findById(new Integer(getVal()));
        System.out.println(movie.toString());
        return "detailPage";
    }



    public void handle(){
        ActionContext actionContext=ActionContext.getContext();
        User user=(User)actionContext.getSession().get("user");
        if(user!=null){
            System.out.println("checkin~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (Object movie: pageResult.getItems()){
                /*if(user.getMovies().contains(movie)){
                    System.out.println("contains");
                }*/
                for(Movie had:user.getMovies()){
                    if(((Movie)movie).getId().equals(had.getId())){
                        System.out.println("=mark_one=");
                        ((Movie) movie).setMark(true);
                    }
                }
            }
        }
        System.out.println("check++++++++++++++++++++++++++++++++++");
    }

    public String delete(){
        movie=movieService.findById(new Integer(attr));
        movieService.delete(movie);
        return "list";
    }

    public String edit(){
        movie=movieService.findById(new Integer(attr));
        return "edit";
    }

    public String netizeComment(){
        User user=(User)ActionContext.getContext().getSession().get("user");
        String useraccount="";
        String hql="";
        List<String>lists=new ArrayList<String>();
        lists.add("douban");
        if(user!=null) {
            lists.add(user.getAccount());
        }
        Criterion criterion= Restrictions.not(Restrictions.in("origin",lists));
        pageResult=movieService.findObject(criterion,getPageNo(),getPageSize());
        handle();
        return "netizeComment";
    }

    public String myLike(){
        User user=(User)ActionContext.getContext().getSession().get("user");
        List<Movie>movies=new ArrayList<>();
        for (Movie movie: user.getMovies()){
            movies.add(movie);
        }
        pageResult=new PageResult(movies.size(),getPageNo(),getPageSize(),movies);
        handle();
        return "myLike";
    }

}
