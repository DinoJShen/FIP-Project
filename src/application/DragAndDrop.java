package application;

import java.awt.dnd.*;
import java.awt.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.io.*;
class DragAndDrop extends JFrame{
    File file;
    public DragAndDrop(JLabel image,JTextField txt,JLabel lbldefaultFilePath,application.Application a){
        DropTarget target=new DropTarget(image,new DropTargetListener(){
            public void dragEnter(DropTargetDragEvent e){}
            public void dragExit(DropTargetEvent e){}
            public void dragOver(DropTargetDragEvent e){}
            public void dropActionChanged(DropTargetDragEvent e){}
            public void drop(DropTargetDropEvent e){
                try{
                    // Accept the drop first, important!
                    e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    
                    // Get the files that are dropped as java.util.List
                    java.util.List list=(java.util.List) e.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    
                    // Now get the first file from the list,
                    file=(File)list.get(0);
                    String fileType=file.getName().substring(file.getName().length()-3);
                    if(fileType.equals("png")||fileType.equals("jpg")){
                        image.setIcon(new application.function.Resize(file.toString(),(int)image.getWidth(),(int)(image.getHeight())).Resize());
                        txt.setText(file.getName());
                        lbldefaultFilePath.setText(file.getParent());
                    }else if(fileType.equals("tif")){
                        a.setVisible(false);
                        application.TifApplication form = new application.TifApplication(file);
                        form.setVisible(true);
                        form.setLocationRelativeTo(null);
                    }else if(fileType.equals("raw")){
                        a.setVisible(false);
                        application.RawApplication form = new application.RawApplication(file);
                        form.setVisible(true);
                        form.setLocationRelativeTo(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "The file format does not supported!","Error", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception ex){}
            }
        });
    }
    
//    public ImageIcon resizeImage(String filename){
//        ImageIcon imageIcon = new ImageIcon(filename);
//        Image image = imageIcon.getImage();
//        Image newimg = image.getScaledInstance(256, 256,  java.awt.Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newimg);
//        return imageIcon;
//    }
    
    public String getFilePath(){
        return file.getParent();
    }
}