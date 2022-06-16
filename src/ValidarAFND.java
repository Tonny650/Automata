import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ValidarAFND extends ReadFile{
    private ArrayList<String> sig;
    private ArrayList<String> f;
    private ArrayList<String> state;
    private HashMap<String, String> t;
    private ArrayList<String> key,newKey,transicion;


    public ValidarAFND(ArrayList<String> sig, ArrayList<String> f, ArrayList<String> state, HashMap<String, String> t) {
        super(sig, f, state, t);
        this.sig = sig;
        this.f = f;
        this.state = state;
        this.t = t;
        key = new ArrayList<>();newKey = new ArrayList<>();transicion = new ArrayList<>();
    }

    @Override
    public void Leer() {
        String cadena = "";
        try {
            FileReader file = new FileReader("src/Automata.txt");
            BufferedReader bufferedReader = new BufferedReader(file);

            while ((cadena = bufferedReader.readLine()) != null){
                String character = String.valueOf(cadena.charAt(0));
                String character2 = String.valueOf(cadena.charAt(1));
                for (int i = 0; i < cadena.length(); i++) {
                    String character3 = String.valueOf(cadena.charAt(2));
                    newKey.add(character3);
                }


                key.add(character);
                transicion.add(character2);
            }
            System.out.println(key);
            System.out.println(transicion);
            System.out.println(newKey);
            Input(key.get(0));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    private void Input(String posicion){
        String  character,pos = posicion;
        boolean val = false;
        String input = JOptionPane.showInputDialog("Cadena a validar: ");
        System.out.println("Cadena a evaluar "+input);
        for (int i = 0; i < input.length(); i++) {
            character = String.valueOf(input.charAt(i));
            for (int j = 0; j <= key.size() ; j++) {
                if (key.get(j).equals(pos) && transicion.get(j).equals(character)){
                    System.out.println(newKey.get(j));
                    pos = newKey.get(j);
                    break;
                }
            }
        }
        for (int i = 0; i < f.size(); i++) {
            if (pos.equals(f.get(i))){
                val = true;
                break;
            }else {
                val = false;
            }
        }
        System.out.println("cadena valida: "+val);
    }
}