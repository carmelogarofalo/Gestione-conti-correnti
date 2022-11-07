import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {

        try
        {
            HashMap<String,Integer> hashMap = new HashMap<>();
            JsonReader jsonReader = new JsonReader(new FileReader("accounts.json"));
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            Gson gson = new Gson();

            hashMap.put( "BONIFICO",0);
            hashMap.put( "ACCREDITO",0);
            hashMap.put( "BOLLETTINO",0);
            hashMap.put( "F24",0);
            hashMap.put( "PAGOBANCOMAT",0);

            long time1 = System.currentTimeMillis();
            long time2;

            jsonReader.beginArray();

            while (jsonReader.hasNext())
            {
                Type Conto_corrente_Type = new TypeToken< Conto_corrente >() {}.getType();
                Conto_corrente conto = gson.fromJson(jsonReader, Conto_corrente_Type);
                executorService.execute(new Task(conto,hashMap));

            }

            jsonReader.endArray();
            jsonReader.close();

            executorService.shutdown();
            executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

            hashMap.forEach((k,v) -> System.out.print("\n"+k+":"+" "+v));

            time2 = System.currentTimeMillis();
            System.out.print("\n\nTempo trascorso: "+(time2-time1) + " ms");

        } catch (IOException | InterruptedException e) {throw new RuntimeException(e);}
    }
}
