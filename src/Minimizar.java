import java.util.ArrayList;
import java.util.HashMap;

public class Minimizar extends ReadFile{
    private ArrayList<String> sig;
    private ArrayList<String> f;
    private ArrayList<String> state;
    private HashMap<String, String> t;
    private String ruta = "sec/Automata.txt";
    private ArrayList<String> finalStates, noFinalStates;

    public Minimizar(ArrayList<String> sig, ArrayList<String> f, ArrayList<String> state, HashMap<String, String> t) {
        super(sig, f, state, t);
        this.sig = sig;
        this.f = f;
        this.state = state;
        this.t = t;
        finalStates = new ArrayList<>();
        noFinalStates = new ArrayList<>();
    }

    @Override
    public void Leer() {
        String cadena;int n;
        System.out.println(state);
        for (int i = 0; i < f.size(); i++) {
            for (int j = 0; j < state.size(); j++) {
                if (f.get(i).equals(state.get(j))){
                    System.out.println(state.get(j));
                    finalStates.add(state.get(j));
                    break;
                }
                if (!f.get(i).equals(state.get(j))){
                    noFinalStates.add(state.get(j));
                }
            }
        }
        dealete();
        Finale();



        /*try {
            FileReader file = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(file);

            while ((cadena = bufferedReader.readLine()) != null){

            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }*/
    }
    private void dealete(){
        for (int i = 0; i < finalStates.size(); i++) {
            for (int j = 0; j < noFinalStates.size(); j++) {
                if (finalStates.get(i).equals(noFinalStates.get(j))){
                    noFinalStates.remove(j);
                }
            }
        }
        System.out.println("Estados Finales: "+finalStates);
        System.out.println("Estados No Finales: "+noFinalStates);
    }
    private void Finale(){
        for (int i = 0; i < finalStates.size(); i++) {
            for (int j = 1; j < finalStates.size(); j++) {
                if (t.get(finalStates.get(i)).equals(t.get(finalStates.get(j)))){
                    if (!finalStates.get(i).equals(finalStates.get(j))){
                        System.out.println(t.get(finalStates.get(i))+","+t.get(finalStates.get(j)));
                        System.out.println(finalStates.get(i));
                        System.out.println(finalStates.get(j));
                    }

                }else{
                    System.out.println("No son iguales");
                }
            }
        }
    }


}
