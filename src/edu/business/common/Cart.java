package edu.business.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Set<String>goods_id;
    private Map<String,Integer>quantity;
    private Set<String>seleted;
    private double total;
    public Cart(){
        goods_id=new HashSet<String>();
        seleted=new HashSet<String>();
        quantity=new HashMap<String, Integer>();
        total=0;
    }

    public Set<String> getSeleted() {
        return seleted;
    }

    public void setSeleted(Set<String> seleted) {
        this.seleted = seleted;
    }

    public Set<String> getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Set<String> goods_id) {
        this.goods_id = goods_id;
    }

    public Map<String, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<String, Integer> quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addGoods(String gid){
        Integer num=1;
        goods_id.add(gid);
//        seleted.add(gid);
        if(quantity.containsKey(gid)){
            num=quantity.get(gid)+1;
        }
        quantity.put(gid,num);
    }
    public void rmGoods(String gid){
        goods_id.remove(gid);
//        seleted.remove(gid);
        quantity.remove(gid);
    }
    public void reduceGoods(String gid){
        Integer num=quantity.get(gid);
        quantity.put(gid,num-1);
    }

    public void setNum(String gid, Integer num){
        quantity.put(gid,num);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "goods_id=" + goods_id +
                ", quantity=" + quantity +
                '}';
    }
}
