package calendario;




public class Fecha {
    private int dia;
    private int mes;
    private int año;
    private int aux=0;
    private int aux2=0;
    private int d=0;
   
    
    public Fecha(){
        dia = 1;
        mes = 1;
        año = 1900;
    }
    
    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        validar();
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAño(){
        return año;
    }
   
    public void setDia(int dia){
        this.dia = dia;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    
    public void setAño(int año){
        this.año = año;
    }
//-------------------------------------------------------------    
    public int bisiesto(int mes, int año){
        int m=mes,a=año;
        int regular[]={0,3,3,6,1,4,6,2,5,0,3,5};
        int bisiesto[]={0,3,4,0,2,5,0,3,6,1,4,6};
       
        if((a%4==0) && !(a%100==0)){
            aux=bisiesto[m-1];
            aux2=1;
        }else if (a%400==0){
            aux=bisiesto[m-1];
        }else{
            aux=regular[m-1];
            aux2=0;
        }
        return aux2;
    }
   
    public int diasMes(){
        int numeroDias = 0;
        
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
            break;
            
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
            break;
            
            case 2:
                if(aux2==1){
                    numeroDias = 29;
                }else{
                    numeroDias = 28;
                }
            break;
        }
        return numeroDias;
      
    }
    
    private void validar(){
        if(dia<1 || dia>31){
            dia = 1;
        }else{
            if(mes<1 || mes>12){
                mes=1;
            }else{
                if(año<1900 || año>2050){
                    año = 1900;
                }
            }
        }
        
    }
   
    public void corta(){
        System.out.println("Fecha corta: "+dia+"-"+mes+"-"+año);
    }
    
    public void siguiente(int dia, int mes, int año){
        int a=dia, b=mes, c=año;
        if(mes==2 && aux2==1){
            if(dia==29){
                a=1;
                b++;
            }else{
                a++;
            }
   
        }
        
        if(mes==2 && aux2==0){
            if(dia==28){
                a=1;
                b++;
            }else{
                a++;
            }
        }
        
        if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10){
            if(dia==31){
                a=1;
                b++; 
            }else{
                a++;
            }
        }
        
        if(mes==12){
            if(dia==31){
                a=1;
                b=1;
                c++;
            }else{
                a++;
            }
        }
        
        if(mes==4||mes==6||mes==9||mes==11){
            if(dia==30){
                a=1;
                b++;
            }else{
                a++;
            }
        }
        
        System.out.println("el dia siguente es: "+a+"-"+b+"-"+c);
    }
    
    public void anterior(int dia, int mes, int año){
        int a = dia, b = mes, c = año;
        
        if(mes==1){
            if( dia==1){
                a=31;
                b=12;
                c--;
            }else{
                a--;
            }
        }
        
        if((mes-1)==1||(mes-1)==3||(mes-1)==5||(mes-1)==7||(mes-1)==8||(mes-1)==10||(mes-1)==12){
            if(dia==1){
                a = 31;
                b=mes-1;
            }else{
                a--;
            }
        }
        
        if((mes-1)==4||(mes-1)==6||(mes-1)==9||(mes-1)==11){
            if(dia==1){
                a = 30;
                b = mes-1;
            }else{
                a--;
            }
        }
        
        if((mes-1)==2){
            if(dia==1){
                if(aux2==1){
                    a=29;
                    b=mes-1;
                }else{
                    a=28;
                    b=mes-1;
                }   
            }else{
            a--;
        }
                
        }
        System.out.println("el dia anterior es: "+a+"-"+b+"-"+c);
    }
    
    public void diaSemana(int dia, int mes, int año){
       
        int d=dia, m=mes,a=año,r1,r2,r3,r4,r5;
        bisiesto(m,a);
        r1=(a-1)%7;
        r2=(a-1)/4;
        r3=(3*(((a-1)/100)+1))/4;
        r4=(r2-r3)%7;
        r5=d%7;
        d=(r1+r4+aux+r5)%7;
        
        switch(d){
            case 0:
                System.out.println("el dia es: DOMINGO");
            break;
            case 1:
                System.out.println("el dia es: LUNES");
                break;
            case 2:
                System.out.println("el dia es: MARTES");
                break;
            case 3:
                System.out.println("el dia es: MIERCOLES");
                break;
            case 4:
                System.out.println("el dia es: JUEVES");
                break;
            case 5:
                System.out.println("el dia es: VIERNES");
                break;
            case 6:
                System.out.println("el dia es: SABADO");
                break;
        }
        this.d=d;
    }
    
    public void larga(){
            String regular[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        for(int i=1;i<13;i++){
            if(i==mes)
                switch(d){
                    case 0:
                        System.out.println("Fecha larga: Domingo "+dia+" de "+regular[i-1]+" del "+año);
                    break;
                    case 1:
                        System.out.println("Fecha larga: Lunes "+dia+" de "+regular[i-1]+" del "+año);
                        break;
                    case 2:
                        System.out.println("Fecha larga: Martes "+dia+" de "+regular[i-1]+" del "+año);
                        break;
                    case 3:
                        System.out.println("Fecha larga: Miercoles "+dia+" de "+regular[i-1]+" del "+año);
                        break;
                    case 4:
                        System.out.println("Fecha larga: Jueves "+dia+" de "+regular[i-1]+" del "+año);
                        break;
                    case 5:
                        System.out.println("Fecha larga: Viernes "+dia+" de "+regular[i-1]+" del "+año);
                        break;
                    case 6:
                        System.out.println("Fecha larga: Sabado "+dia+" de "+regular[i-1]+" del "+año);
                        break;
                }
        }
    }
       
    public void diasTranscurridos(int dia, int mes, int año){
        
       int a=año, m=mes,d=dia, contaño=1900,contmes=1,contdia=1,numeroDias=0;
       
       do{
            bisiesto(contmes, contaño);
            
            switch(contmes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias += 31;
            break;
            
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias += 30;
            break;
            
            case 2:
                if(aux2==1){
                    numeroDias += 29;
                }else{
                    numeroDias += 28;
                }
            break;
        }
            contmes++;
            
            if(contmes==13){
                contmes=1;
                contaño++;
            }
       }while(contaño<a);
       
        for(int i=1;i<13;i++){
            if(i<=m){
                if(i==m){
                    while(contdia<d){
                        contdia++;
                    }
                    numeroDias+=contdia;
                }else{
                    switch(i){
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            numeroDias += 31;
                        break;

                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            numeroDias += 30;
                        break;

                        case 2:
                            if(aux2==1){
                                numeroDias += 29;
                            }else{
                                numeroDias += 28;
                            }
                        break;
                    }
                }
            } 
        }
        System.out.println("han pasado "+numeroDias+" dias desde 1-1-1900");
    }
    
    public void fechaTras(int ndias){
        int contaño=1900,contmes=1,contdia=0;
       
        for(int i=0;i<ndias;i++){
                   
            bisiesto(contmes, contaño);
            
            switch(contmes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(contdia<31){
                        contdia++;
                    }else{
                        contmes++;
                        contdia=1;
                    }
                break;

                case 4:
                case 6:
                case 9:
                case 11:
                    if(contdia<30){
                        contdia++;
                    }else{

                        contmes++;
                        contdia=1;
                    }
                break;

                case 2:
                    if(aux2==1){
                        if(contdia<29){
                        contdia++;
                        }else{
                            contmes++;
                            contdia=1;
                        }
                    }else{
                        if(contdia<28){
                            contdia++;
                        }else{
                            contmes++;
                            contdia=1;
                        }
                    }
                break;
            }
            if(contmes==13){
                contmes=1;
                contaño++;
                contdia=1;
            }
               }
        System.out.println("1 - 1 - 1900 mas "+ndias+" dias = "+contdia+" - "+contmes+" - "+contaño);
    }
       
}