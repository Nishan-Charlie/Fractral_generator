import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class Mandelbrot extends Default{


  /*******************Set the frame and print the image****************************/
    public void imagePrint(){

      int count;
      realRange=Math.abs(realMax - realMin);          //Calculating the Range
      imgRange =Math.abs(imgMax  - imgMin) ;

      for(int x = 0; x < width; x++){
          for(int y = 0; y < height; y++){
              realC = (double)x*(realRange)/width + realMin;				//real c
              imgC = (double)y*(imgRange)/height  + imgMin ;	     //img c
              count = counter(realC, imgC);
              setColour(x,y,count);
          }
      }
      setFrame("Mandelbrot Set");
  }//End of imagePrint


  /*********************This will count the number of iterations until Zn>2****************************/
    public int counter(double realC,double imgC){
      //Z0=0;----> realZ=0 & imaginaryZ=0
          double realZ = 0;
          double imgZ  = 0;
          int i;                      //iterations
          //double squreValue;

          for(i = 1; i <= iteration ; i++){
              double realTemp   = realZ;
              if(realZ*realZ +imgZ*imgZ>4){
                return i;
              }
              else{
              //Zn+1=Zn^2 + C
              realZ = realZ*realZ - imgZ*imgZ + realC;		      //real(Zn+1)=real(zn^2) +real(c)
              imgZ  = 2*realTemp*imgZ + imgC;                  //imaginary(Zn+1)=imaginary(zn^2) +imaginary(c)
            }


          }// for ends
          return iteration;                 //returns the number of iteration where ABS(Zn)>2
      }//Counter end


      //Color.getHSBColor((value*5.0f)/max, 1.0f, 1.0f);
      /***************Set colour method to Set the color accordingly****************/
        public void setColour(int x, int y, int count){
              if(count < iteration){ //If it not in the mandelbrot set
                  image.setRGB(x, y, Color.HSBtoRGB((count*5.0f)/iteration, 1.0f, 1.0f));  //Printing the colour w.r.t count
              }
          }

          @Override
        public void paint(Graphics g){
                  g.drawImage(image,0,0,null);
              }

/*******************Color seter******************
      private static Color convertToColor(int count, int iteration){    //n in the Zn

          if(count > iteration){
          return Color.getHSBColor((count*5.0f)/iteration, 1.0f, 1.0f);
        }else{
        return Color.BLACK;
      }
      }

      private void printPoint(Graphics2D frame, Color c, int x, int y) {

          frame.setColor(c);
          frame.draw(new Line2D.Double(x, y, x, y));

      }

/*/


/****************************************Constructors**********************************************/
public Mandelbrot(){                //Only one argument
        super();                    //Evrerithing remains default
    }

public Mandelbrot(int iteration){   // only 2 arguments
            super();
            this.iteration=iteration;

        }

    public Mandelbrot(double realMin, double realMax, double imgMin, double imgMax){    //5 arguments
        super();
        this.realMin = realMin;
        this.realMax = realMax;
        this.imgMin = imgMin;
        this.imgMax = imgMax;
    }

    public Mandelbrot(double realMin, double realMax, double imgMin, double imgMax, int iteration){ // all arguments (6)
        super();
        this.realMin = realMin;
        this.realMax = realMax;
        this.imgMin = imgMin;
        this.imgMax = imgMax;
        this.iteration = iteration;
    }



  }//End of Mandelbrot
