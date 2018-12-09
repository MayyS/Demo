package edu.util.Security;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class SecurityImage {
    private static Random random=new Random();
    public static BufferedImage createImage(String securityCode){
        int codeLength=securityCode.length();
        int frontSize=25;
        int frontWidth=frontSize+1;
        int imageWidth=codeLength*frontWidth+6;
        int imageHeigth= (int) (frontSize*1.5+5);

        BufferedImage bufferedImage=new BufferedImage(imageWidth,imageHeigth,BufferedImage.TYPE_INT_BGR);
        Graphics graphics=bufferedImage.getGraphics();

        graphics.setColor(Color.white);
        graphics.fillRect(0,0,imageWidth,imageHeigth);

        graphics.setColor(Color.LIGHT_GRAY);

        graphics.setFont(new Font("Arial", Font.BOLD, imageHeigth-2));
        graphics.drawRect(0,0,imageWidth-1,imageHeigth-1);

        graphics.setColor(Color.LIGHT_GRAY);

        for (int i=0; i<codeLength*6; i++){
            int x=random.nextInt(imageWidth);
            int y=random.nextInt(imageHeigth);
            graphics.drawRect(x,y,1,1);
        }

        graphics.setFont(new Font("Georgia", Font.BOLD, frontSize));
        for(int i=0; i<codeLength; i++){
            graphics.setColor(getRandomColor());
            graphics.drawString(String.valueOf(securityCode.charAt(i)),i*16+5,imageHeigth-10);
        }

        graphics.dispose();
        return bufferedImage;

    }

    public static ByteArrayInputStream getImageAsInputStream(String securityCode){
        BufferedImage bufferedImage=createImage(securityCode);
        return convertImageToStream(bufferedImage);
    }

    private static ByteArrayInputStream convertImageToStream(BufferedImage bufferedImage){
        ByteArrayInputStream inputStream=null;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        JPEGImageEncoder jpegImageEncoder= JPEGCodec.createJPEGEncoder(bos);

        try {
            jpegImageEncoder.encode(bufferedImage);
            byte[] bts=bos.toByteArray();
            inputStream=new ByteArrayInputStream(bts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    private static Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
}
