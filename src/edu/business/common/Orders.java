package edu.business.common;

import javax.persistence.*;
import edu.business.common.embed.Detail;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customer_id;
    private String customer_name;
    private Date createdTime;
    private boolean status;
    private double total;
    @ElementCollection(targetClass = Detail.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "order_detail",
            joinColumns = @JoinColumn(name = "id", nullable = false)
    )
    @Column(name = "detail")
    @OrderColumn(name = "list_order")
    private List<Detail> details=new ArrayList<Detail>();
    public Orders(){
        /*
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hh= sdf.format(new Date());
        createTime=sdf.parse(hh);*/
        createdTime=new Date();
        System.out.println(createdTime);
        status=true;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", createdTime=" + createdTime +
                ", status=" + status +
                ", total=" + total +
                ", details=" + details +
                '}';
    }
}
