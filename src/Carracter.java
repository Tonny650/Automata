import java.util.ArrayList;

public class Carracter{
    public ArrayList<String>Caracter;

    public void caracter(String tranciciones){
        Caracter = new ArrayList<String>();
        String character, cadena = "";
        for (int i = 0; i < tranciciones.length(); i++) {
            character = String.valueOf(tranciciones.charAt(i));

            if (character.equals("|")){
                Caracter.add(cadena);
                cadena = "";
            }else {
                cadena += character;
            }
        }
        Caracter.add(cadena);
        cadena = "";

    }
}
