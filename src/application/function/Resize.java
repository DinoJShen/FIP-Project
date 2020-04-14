package application.function;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Resize {
    String filename;
    int width,height;
    public Resize(String filename,int width,int height){
        this.filename=filename;
        this.width=width;
        this.height=height;
    }
    
    public ImageIcon Resize(){
        ImageIcon imageIcon = new ImageIcon(filename);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(width, height,java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }
}
