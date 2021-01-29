
package calendario;
import java.util.Scanner;


public class Calendario {

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Capture una fecha:");
        System.out.println("capture Dia");
       int dia = sc.nextInt();
       
       System.out.println("Capture mes");
       int mes = sc.nextInt();
       
       System.out.println("Capture año");
       int año = sc.nextInt();
       
        System.out.println("capure un numero de dias");
        int ndias = sc.nextInt();
       
       Fecha f = new Fecha(dia,mes,año);
       
       f.bisiesto(mes,año);
       int bi = f.bisiesto(mes, año);
       if(bi==1){
           System.out.println("el año "+año+" es bisiesto");
       }
       if(bi==0){
           System.out.println("el año "+año+" no es bisiesto");
       }
       
       int d = f.diasMes();
       System.out.println("El mes de la fecha tiene: " + d + "  dias" );
       
       f.corta();
       f.diasTranscurridos(dia, mes,año);
       f.diaSemana(dia, mes, año);
       f.larga();
       f.fechaTras(ndias);
       f.siguiente(dia, mes, año);
       f.anterior(dia, mes, año);
       
       

               
       
       
       
    }
    
    
}