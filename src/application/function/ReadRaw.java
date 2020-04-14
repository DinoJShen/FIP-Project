package application.function;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ReadRaw {
    String file,format;
    int width,height;
    ArrayList<Integer> readRaw;
    public ReadRaw(String file,String format,int width,int height){
        this.file=file;
        this.format=format;
        this.width=width;
        this.height=height;
    }
    
    public ReadRaw(String file){
        this.file=file;
    }
    
    public ArrayList<Integer> readRaw(){
        readRaw=new ArrayList<Integer>();
        FileInputStream MyInputFile;
        try {
            MyInputFile = new FileInputStream(this.file);
            int value;
            while((value=MyInputFile.read())!=-1){
                readRaw.add(value);
            }
            MyInputFile.close();
        } catch (IOException ex) {
            System.out.println("Error extracting raw");
        }
        return readRaw;
    }
    
    public File generateImage(){
        File out=null;
        try{
            int[]data = new int[height*width];
            FileInputStream MyInputFile=new FileInputStream(file);
            int i=0;
            int value;
            while((value=MyInputFile.read())!=-1){
                  data[i]=value;
                  i++;
            }
            MyInputFile.close();
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_INDEXED);
            for ( int x = 0; x < width; x++ ) {
              for ( int y = 0; y < height; y++ ) {
                final int c = data[ y * width + x ];
                bi.setRGB(x,y,new Color(c,c,c).getRGB() );
              }
            }
            out = new File(file.substring(0,file.length()-4)+"."+format);
            ImageIO.write(bi, format, out);
        }catch(IOException ex){
            System.out.println("Error");
        }
        return out;
    }
    
}
