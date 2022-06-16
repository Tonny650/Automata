import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ruta {
    private String[] archivos = {"Aut1.txt","Aut2.txt","Aut3.txt","Aut4.txt","Aut5.txt","Aut6.txt"};

    public Ruta(){
        int Numero;
        while (true){
            Numero = Integer.parseInt(JOptionPane.showInputDialog("Numero de Automata:"));
            if (Numero <= 6 && Numero > 0){
                break;
            }else {
                JOptionPane.showConfirmDialog(null,"No existe ese automata. Favor de verificar...");
            }
        }
        int posicion = Numero-1;
        try {
            FileReader file = new FileReader("src/automatas/"+archivos[posicion]);
            BufferedReader bufferedReader = new BufferedReader(file);
            String cadena, Gcadena="",Gcadena2=""; int n1=0, n2=0;

            while ((cadena = bufferedReader.readLine()) != null){
                cadena = cadena.replace(" ","");
                if (cadena.equals("")){

                }else {
                    if (cadena.matches(".*[,]$") || cadena.matches(".*[ ]$")){
                        n1=1;
                    }else{
                        n1 = 2;
                    }

                    if (n1 == 1){
                        Gcadena2 += cadena;
                        n2 = 1;
                    }else if(n1 == 2) {

                        if (n2 == 1){
                            Gcadena += Gcadena2 + cadena;
                            Gcadena2 = "";
                            n2 = 0;
                        }else {
                            Gcadena += cadena + "\n";
                        }
                    }
                }
            }
            int lug = Gcadena.length();String txt = " ";
            for (int i = 0; i < Gcadena.length(); i++) {
                if (i == lug-1){

                }

            }

            System.out.println();
            File Automata = new File("src/Aut.txt");
            FileWriter rescribir = new FileWriter(Automata);
            rescribir.write(Gcadena);
            rescribir.close();

        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
