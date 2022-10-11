
/********* Default class contain s defaultvalues and functions*********/

public class Julia extends Mandelbrot{

  /*******************Set the frame and print the image****************************/
    public void imagePrint(){
      int count;
      realRange=Math.abs(realMax - realMin);          //Calculating the Range
      imgRange =Math.abs(imgMax  - imgMin) ;

      for(int x = 0; x < width; x++){
          for(int y = 0; y < height; y++){
              realZ = (double)x*(realRange)/width + realMin;				//real c
              imgZ = -(double)y*(imgRange)/height  + imgMax ;	     //img c
              count = counter(realZ, imgZ);
              setColour(x,y,count);
          }
      }
      setFrame("Julia Set");
  }//End of imagePrint

  /*********************This will count the number of iterations until Zn>2****************************/
    public int counter(double realZ,double imgZ){

          int i;                      //iterations

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
          return i;                 //returns the number of iteration where ABS(Zn)>2
      }


/**********Constructors****************/
  public Julia(){				//Default constructor
        super();
        this.realC = -0.4;
        this.imgC = 0.6;
    }

    public Julia(int iteration){				//Default constructor
          super();
          this.realC = -0.4;
          this.imgC = 0.6;
          this.iteration=iteration;
      }

    public Julia(double realC, double imaginaryC){
        super();
        this.realC = realC;
        this.imgC = imaginaryC;
    }

    public Julia(double realC, double imaginaryC, int iteration){
        super();
        this.realC = realC;
        this.imgC = imaginaryC;
        this.iteration = iteration;
    }


}
