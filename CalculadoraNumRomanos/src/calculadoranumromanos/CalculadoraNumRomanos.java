package calculadoranumromanos;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CalculadoraNumRomanos {

    /**
     * @param args the command line arguments
     */
    public static Map<String, Integer> romanos = new HashMap<String, Integer>();
    public static void main(String[] args) {
        
        //Utilización de hashmap para conversión romano a arábico
        //Números del 1 al 9
        romanos.put("I", 1);romanos.put("II", 2);romanos.put("III", 3);
        romanos.put("IV", 4);romanos.put("V", 5);romanos.put("VI", 6);
        romanos.put("VII", 7);romanos.put("VIII", 8);romanos.put("IX", 9);
        //Números del 10 al 90
        romanos.put("X", 10);romanos.put("XX", 20);romanos.put("XXX", 30);
        romanos.put("XL", 40);romanos.put("L", 50);romanos.put("LX", 60);
        romanos.put("LXX", 70);romanos.put("LXXX", 80);romanos.put("XC", 90);
        //Números del 100 al 900
        romanos.put("C", 100);romanos.put("CC", 200);romanos.put("CCC", 300);
        romanos.put("CD", 400);romanos.put("D", 500);romanos.put("DC", 600);
        romanos.put("DCC", 700);romanos.put("DCCC", 800);romanos.put("CM", 900);
        //1000. Capacidad máxima de la calculadora MCMXCIX -> 1999 
        romanos.put("M", 1000);
        
        int numero = 0;
        Scanner lee = new Scanner(System.in);
        String numeroR = lee.nextLine();
        int nAnterior=0, L = numeroR.length()-1, j = L-2;
        for(int i = L; i >= 0;i--)
        {//si el numero anterior es mayor o igual, se le suma.
            //si el numero anterior es menor, se le resta.   XVX
            if(i > 0){
                
                int nActual = romanos.get(numeroR.substring(i-1,i));
                
                if(nAnterior >= nActual)
                    numero = numero + nActual;
                
                else if(nAnterior < nActual)
                    numero = nActual - numero;
                
                nAnterior = romanos.get(numeroR.substring(i-1,i));
            }
            else if (i==L){
                numero = romanos.get(numeroR.substring(i+1,i));
            }
            else
                numero = numero + romanos.get(numeroR.substring(i,i+1));
            
            System.out.println("Caracter " + (i+1) + ": " + numeroR.charAt(i) + " suma " + numero + " nAnterior " + nAnterior);
        }
        System.out.print(numero);
    }
    String nRomano = "";
    public static int romanoArabico(String cifra)
    {
        int numero = 0;
        for(int i = cifra.length()-1; i >= 0 ;i++)
        {
            numero = romanos.get(cifra.charAt(i));
        }
        return numero;
    }
    
    public String Suma(int a, int b)
    {
        return null;
    }
    
    public String Resta(int a, int b)
    {
        return null;
    }
    
    public String Multiplicacion(int a, int b)
    {
        return null;
    }
    
    public String Division(int a, int b)
    {
        return null;
    }
}
