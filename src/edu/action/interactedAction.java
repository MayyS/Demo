package edu.action;

import com.opensymphony.xwork2.ActionContext;
import edu.base.action.BaseAction;
import edu.business.bookstore.entity.Book;
import edu.business.bookstore.service.BookService;
import edu.business.bookstore.service.impl.BookServiceImpl;
import edu.business.common.Cart;
import edu.business.common.Orders;
import edu.business.common.embed.Detail;
import edu.entity.Movie;
import edu.entity.PageResult;
import edu.entity.User;
import edu.service.MovieService;
import edu.service.UserService;
import edu.service.impl.MovieServiceImpl;
import edu.service.impl.UserSeriveImpl;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class interactedAction extends BaseAction implements SessionAware {
    private Integer uid;
    private Integer mid;
    private String bid;
    private String uname;
    private int num;
    private List<String>selected=new ArrayList<String>();
    private Map<String,Object>session;
    private UserService userService=new UserSeriveImpl();
    private MovieService movieService=new MovieServiceImpl();
    private BookService bookService=new BookServiceImpl();

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }

    public void addMovie(){
        User user=userService.findById(getUid());
        Movie movie=movieService.findById(getMid());
        user.getMovies().add(movie);
        userService.update(user);
//        ActionContext.getContext().getSession().put("user",user);
        session.put("user",user);
    }
    public void rmMovie(){
        User user=userService.findById(getUid());
        Movie movie=movieService.findById(getMid());
        for(Movie tm:user.getMovies()){
            if(tm.getId().equals(movie.getId())){
                user.getMovies().remove(tm);
                break;
            }
        }
        userService.update(user);
        ActionContext.getContext().getSession().put("user",user);
    }
    public String cart(){
        Cart cart=(Cart)session.get("cart");
//        cart.setSeleted(cart.getGoods_id());
        dealBook(cart);
        session.put("cart",cart);
        return "cart";
    }

    public void add2Cart(){
//        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        Cart cart=(Cart)session.get("cart");
        if(null == cart){
            cart=new Cart();
        }
        cart.addGoods(bid);
        System.out.println(cart.toString());
//        ActionContext.getContext().getSession().put("cart",cart);
        session.put("cart",cart);
    }

    private void dealBook(Cart cart){
        double cost=0;
        List<Book>books=new ArrayList<Book>();
//        Cart cart=(Cart)session.get("cart");
        for (String id :cart.getGoods_id()){
            Book book=bookService.findById(id);
            books.add(book);
//            cost+=book.getPrice_n()*cart.getQuantity().get(id);
            if(cart.getSeleted().contains(id)){
                cost+=book.getPrice_n()*cart.getQuantity().get(id);
            }
        }

        DecimalFormat decimalFormat=new DecimalFormat("#.00");
        cost=Double.parseDouble(decimalFormat.format(cost));
        cart.setTotal(cost);
        pageResult=new PageResult(books.size(),getPageNo(),getPageSize(),books);
    }

    public void goods_minus() throws IOException {
        Cart cart=(Cart)session.get("cart");
        cart.reduceGoods(bid);
        dealBook(cart);
        session.put("cart",cart);
        System.out.println("goods_minus");
        getPrintWrite().print(cart.getTotal());

    }

    public void goods_plus() throws IOException {
        Cart cart=(Cart)session.get("cart");
        cart.addGoods(bid);
        dealBook(cart);
        session.put("cart",cart);
        System.out.println("goods_plus");
        getPrintWrite().print(cart.getTotal());
    }

    public void rmGoods() throws IOException {
        System.out.println(bid);
        Cart cart=(Cart)session.get("cart");
        cart.rmGoods(bid);
        dealBook(cart);
        session.put("cart",cart);
        getPrintWrite().print(cart.getTotal());

    }

    public void setGoodsNum() throws IOException {
        Cart cart=(Cart)session.get("cart");
        cart.setNum(bid,num);
        dealBook(cart);
        session.put("cart",cart);
        getPrintWrite().print(cart.getTotal());
    }

    public void delSelected() throws IOException {
        Cart cart=(Cart) session.get("cart");
        for (String id:selected){
            cart.rmGoods(id);
        }
        dealBook(cart);
        session.put("cart",cart);
        getPrintWrite().print(cart.getTotal());
    }

    public PrintWriter getPrintWrite() throws IOException {
        ActionContext actionContext=ActionContext.getContext();
        HttpServletResponse response=(HttpServletResponse)actionContext.get(ServletActionContext.HTTP_RESPONSE);
        response.setContentType("text/html;charset=utf-8");
        return response.getWriter();
    }

    public String paid(){
        System.out.println(uid+" "+uname);
        Cart cart=(Cart)ActionContext.getContext().getSession().get("cart");
        User user=(User)userService.findById(uid);
        Orders orders=new Orders();
        orders.setCustomer_id(uid);
        orders.setStatus(true);
        orders.setCustomer_name(uname);
        orders.setTotal(cart.getTotal());
        List<Detail>details=new ArrayList<>();
        /*
        for(String gid:cart.getGoods_id()){
            if(cart.getSeleted().contains(gid)){
                Detail detail=new Detail();
                Book book=bookService.findById(gid);
                detail.setName(book.getTitle());
                detail.setPrice(book.getPrice_n());
                detail.setQuantity(cart.getQuantity().get(gid));
                DecimalFormat decimalFormat=new DecimalFormat("#.00");
                detail.setTotal(Double.parseDouble(decimalFormat.format(detail.getPrice()*detail.getQuantity())));
                details.add(detail);
                cart.getSeleted().remove(gid);
                cart.getQuantity().remove(gid);
            }
        }*/

        for(String gid:cart.getSeleted()){
            Detail detail=new Detail();
            Book book=bookService.findById(gid);
            detail.setName(book.getTitle());
            detail.setPrice(book.getPrice_n());
            detail.setQuantity(cart.getQuantity().get(gid));
            DecimalFormat decimalFormat=new DecimalFormat("#.00");
            detail.setTotal(Double.parseDouble(decimalFormat.format(detail.getPrice()*detail.getQuantity())));
            details.add(detail);
            cart.getQuantity().remove(gid);
            cart.getGoods_id().remove(gid);
        }
//        cart.setSeleted(cart.getGoods_id());
        cart.getSeleted().clear();
        orders.setDetails(details);
        user.getOderss().add(orders);
        userService.update(user);
        ActionContext.getContext().getSession().put("user",user);
        System.out.println(user);
        ActionContext.getContext().getSession().put("cart",cart);
        session.put("orders",orders);
        dealBook(cart);
        return SUCCESS;

    }
    /*
    public double getSelectedTotal(){
        for (String id:selected){

        }
    }*/


    public void selectedChange() throws IOException {
        Cart cart=(Cart) session.get("cart");
        cart.setSeleted(new HashSet<String>(this.selected));
        dealBook(cart);
        session.put("cart",cart);
        getPrintWrite().print(cart.getTotal());

    }
}
