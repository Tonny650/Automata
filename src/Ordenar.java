import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Ordenar {

    public void ordenar(ArrayList<String> sig,ArrayList<String> state, HashMap<String,String> t){
        Carracter carracter = new Carracter();
        try {
            File Automata = new File("src/Automata.txt");
            FileWriter rescribir = new FileWriter(Automata);
            int n = t.size();
            for (int i = 0; i < n; i++) {
                carracter.caracter(t.get(state.get(i)));

                for (int j = 0; j < sig.size(); j++) {
                    rescribir.write(state.get(i));
                    rescribir.write("");
                    rescribir.write(sig.get(j));
                    rescribir.write("");
                    rescribir.write(carracter.Caracter.get(j));
                    rescribir.write("\n");
                }
            }
            rescribir.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }

    public void ordenar2(ArrayList<String> sig,ArrayList<String> state, HashMap<String,String> t){
        Carracter carracter = new Carracter();
        try {
            File Automata = new File("src/Automata.txt");
            FileWriter rescribir = new FileWriter(Automata);
            int n = t.size();
            for (int i = 0; i < n; i++) {
                carracter.caracter(t.get(state.get(i)));

                for (int j = 0; j < sig.size(); j++) {
                    rescribir.write(state.get(i));
                    rescribir.write("");
                    rescribir.write(sig.get(j));
                    rescribir.write("");
                    rescribir.write(carracter.Caracter.get(j));
                    rescribir.write("\n");
                }
            }
            rescribir.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }



}
