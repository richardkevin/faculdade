import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CountFollowers
{
    public static LinkedList<String> Read_Csv(){
        LinkedList<String> registros = new LinkedList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("twitter.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                registros.add(line);
            }
        } catch (IOException e){
            System.out.println("File I/O error!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return registros;
    }

    public static Map<String,Integer> Map_Reduce(LinkedList<String> registros){
        Map<String,Integer> qty_followers = new HashMap<String,Integer>();
        String current[] = new String[2];
        for (String registro : registros ){
            current = registro.split(" ");
            if ( qty_followers.containsKey(current[1]) ){
                qty_followers.put(current[1], qty_followers.get(current[1]) + 1);
            }
            else{
                qty_followers.put(current[1], 1);
            }
        }
        return qty_followers;
    }

    public static void Imprime_Qty_Followers(Map<String,Integer> qty_followers){
        for (String key : qty_followers.keySet()) {
            System.out.println(key + " -> " + qty_followers.get(key));
        }
    }

    public static void main(String[] args)
    {
        LinkedList<String> registros = new LinkedList<String>();
        Map<String,Integer> qty_followers = new HashMap<String,Integer>();
        registros = Read_Csv();
        qty_followers = Map_Reduce(registros);
        Imprime_Qty_Followers(qty_followers);
    }
}
