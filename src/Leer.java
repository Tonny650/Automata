import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Leer {
    private ArrayList<String> sig,f,state,structure;
    private HashMap<String,String> t;
    private String route = "src/Aut.txt";
    private String tipo;

    public Leer() {
        new Ruta();
        sig = new ArrayList<>();
        f = new ArrayList<>();
        t = new HashMap<String,String>();
        state = new ArrayList<>();
        structure = new ArrayList<>();
        readFile();
    }

    private void readFile() {
        String cadena;

        try {
            FileReader file = new FileReader(route);
            BufferedReader bufferedReader = new BufferedReader(file);

            while ((cadena = bufferedReader.readLine()) != null){
                structure.add(cadena);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        Sigma(structure.get(3));
        finalStates(structure.get(4));
        transitions(structure.get(5));
    }

    private void Sigma(String sigma){
        String character;

        for (int i = 0; i < sigma.length(); i++) {
            if (i > 2){
                character = String.valueOf(sigma.charAt(i));
                if (!character.equals("{") && !character.equals("}") && !character.equals(",")){
                    sig.add(character);
                }
            }
        }
        System.out.println("Sigma: "+sig);
    }
    private void finalStates(String F){
        String character;

        for (int i = 0; i < F.length(); i++) {
            if (i > 0){
                character = String.valueOf(F.charAt(i));
                if (!character.equals("{") && !character.equals("}") && !character.equals(",")){
                    f.add(character);
                }
            }
        }
        System.out.println("Estados Finales: "+f);
    }

    private void transitions(String T){
        String character,key = "",transicion = "";
        int arreglo = 0,idicador = 0;

        for (int i = 0; i < T.length(); i++) {
            character = String.valueOf(T.charAt(i));

            if (!character.equals("{") && !character.equals("}")){

                if (character.equals(",")){
                    t.put(key,transicion);
                    state.add(key);
                    transicion = "";
                    arreglo = 0;
                    if (idicador >= 2){
                        tipo = "AFND";
                    }
                    idicador = 0;
                }else {
                    if (character.equals(">")){
                        key = String.valueOf(T.charAt(i-1));
                    }else {
                        if (arreglo > 0){
                            if (character.equals("|")){
                                transicion += character;
                                if (idicador >= 2){
                                    tipo = "AFND";
                                }
                                idicador = 0;
                            }else{
                                transicion += character;
                                idicador++;
                            }
                        }
                        arreglo++;
                    }
                }
            }
        }
        t.put(key,transicion);
        state.add(key);
        int dato = t.size();
        System.out.println(dato);
        for (int i = 0; i < t.size() ; i++) {
            System.out.println(t.get(state.get(i)));
        }
        if (tipo == null){
            System.out.println("AFD");
        }else{
            System.out.println(tipo);
        }
        new Ordenar().ordenar(sig,state,t);
        new Minimizar(sig,f,state,t).Leer();
        new Validar(sig,f,state,t).Leer();
    }








}
