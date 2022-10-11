import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Default extends JPanel{

  // Default Values
  //Always height and width are 800
  public   int  height = 800;
  public   int width   = 800;
  //Range of c in Mandelbrot
  public   double realMin  = -1;
  public   double realMax  =  1;
  public   double imgMin   = -1;
  public   double imgMax   =  1;
  //Number of iterations
  public   int iteration   =1000;

/***C values for julia*********/
  public  double realC ;
  public  double  imgC ;
  public double realZ,imgZ;

  public static  JFrame frame;
  BufferedImage image ;
public Default(){

  image= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

}

  String setName;                   // Set name
  public static double realRange,imgRange;

/**********Method to Set the Frame**************/
  public void setFrame(String setName){                 //Seting the image frame
    frame = new JFrame(setName);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width,height);
    frame.setResizable(false);
    //frame.pack();
    frame.setLocationRelativeTo(null);
    frame.add(this);
    frame.setVisible(true);
  }//End of image frame

  



}//End of default class
