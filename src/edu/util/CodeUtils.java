package edu.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class CodeUtils {
    static Random random=new Random();
    public static String  getCode(OutputStream out) throws IOException {
        int width=120;
        int height=50;

        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        String number="";
        Graphics graphics=bufferedImage.getGraphics();
        graphics.setColor(Color.gray);
        graphics.fillRect(0,0,width,height);
        for(int i=0; i<4; i++){
            number+=random.nextInt(10);
        }

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("黑体",Font.ITALIC,35));
        graphics.drawString(number,20,40);

        for(int i=0; i<30; i++){
            int x1=random.nextInt(width);
            int y1=random.nextInt(height);
            int x2=random.nextInt(width);
            int y2=random.nextInt(height);
            graphics.setColor(getRandomColor());
            graphics.drawLine(x1,y1,x2,y2);
        }
        ImageIO.write(bufferedImage,"png",out);
        return number;
    }

    private static Color getRandomColor(){
        return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }
}
