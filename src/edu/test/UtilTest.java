package edu.test;

import edu.business.common.Orders;
import edu.business.common.embed.Detail;
import edu.util.HibernateUtils;
import edu.util.Md5Utils;
import edu.util.Security.ValidateCode;
import edu.util.SendMsg;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilTest {
    /*
    @Test
    public void test1() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hh= sdf.format(new Date());
        Date createTime= null;
        try {
            System.out.println(hh);
            createTime = sdf.parse(hh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(createTime);
    }
    @Test
    public void testOder(){
        Orders order=new Orders();
        order.setCustomer_id(1);
        List<Detail> details=new ArrayList<>();
        Detail detail=new Detail();
        detail.setName("book");
        details.add(detail);
        order.setDetails(details);
        Session session= HibernateUtils.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }*/


    /*@Test
    public void TestMsg() throws IOException {
        SendMsg sendMsg=new SendMsg();
        String phone="15800043940";
        String text="this is a test";
        sendMsg.sentMsg(phone, ValidateCode.getValidateCode());
    }*/

    /*
    @Test
    public void Test(){
        String res= Md5Utils.md5("1234");
        System.out.println(res);
        String res2= Md5Utils.md5("1234");
        System.out.println(res2);

    }

*/
}
