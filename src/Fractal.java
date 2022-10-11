/*
E/ 17/ 230 :- Nishankar.S
CO225: Software Consruction
Project01:- Fractal

*/

public class Fractal {

    public static void main(String[] args){
      int numberOfArguments=args.length;                   //number of arguments from commandline


/*****************IF Mandelbrot Set*****************************/
      if(args[0].equalsIgnoreCase("Mandelbrot")){         //if Mandelbrot set

        if( numberOfArguments == 1){                         //If the region of interest and Iterations not given
          Mandelbrot  mandelSet = new Mandelbrot();

          mandelSet.imagePrint();
        }//1

        else if ( numberOfArguments==2) {
          Mandelbrot  mandelSet = new Mandelbrot(Integer.parseInt(args[1]));

          mandelSet.imagePrint();
        }//2

        else if( numberOfArguments == 5){                        //If the itterator not given
          Mandelbrot mandelSet = new			Mandelbrot(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]));

            mandelSet.imagePrint();
        }//5

        else if( numberOfArguments == 6){
          Mandelbrot mandelSet = new Mandelbrot(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));
            mandelSet.imagePrint();
        }//6
        else{
          errorMessage();
        }
      }// End of Mandelbrot set



/******************IF Julia Set*****************************/
    else if(args[0].equalsIgnoreCase("Julia")){                     // If Julia set

      if( numberOfArguments == 1){
        Julia juliaSet = new Julia();
        juliaSet.imagePrint();
      }
      else if( numberOfArguments ==2){
          Julia juliaSet = new Julia(Integer.parseInt(args[1]));
          juliaSet.imagePrint();
      }
      else if(numberOfArguments == 3){
          Julia juliaSet = new  Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]));
          juliaSet.imagePrint();
      }
      else if(numberOfArguments == 4){
          Julia juliaSet = new  Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Integer.parseInt(args[3]));
          juliaSet.imagePrint();
      }
      else{
        errorMessage();
      }
    }else{
      errorMessage();
    }

    }//End of main function

    public static void errorMessage(){     //Print how the argument should be given
      System.out.println("Wrong argument format");
      System.out.println("*************************************************************");
      System.out.println("The first input argument must be Mandelbrot or Julia");
      System.out.println("Giving only one argument will use default values for other parameters");
      System.out.println("Giving only Two(<Type> <iteration>) argument will use default values for other parameters");
      System.out.println();
      System.out.println("*************************************************************");
      System.out.println("java Fractal Mandelbrot <Lower_bound_of_Real> <Upper_bound_of_Real> <Lower_bound_of_Imaginary> " +
              "<Upper_bound_of_Imaginary> <Number_of_iterations>");

      System.out.println("Example:");
      System.out.println(">java Fractal Mandelbrot -0.5 0.5 -0.1 0.1 500");
      System.out.println();
      System.out.println("*************************************************************");
      System.out.println("java Fractal Julia <Real_part_of_Constant> <Imaginary_part_of_Constant> <Number_of_iterations>");
      System.out.println("Example:");
      System.out.println(">java Fractal Julia 0.12 -0.5 600");
    }//errorMessage

    }//end of Fractal class
