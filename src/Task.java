import java.util.HashMap;
import java.util.List;

public class Task implements Runnable
{

    private Conto_corrente conto;
    private HashMap<String,Integer> hashMap;

    public Task(Conto_corrente conto, HashMap<String,Integer> hashMap)
    {
        this.conto = conto;
        this.hashMap = hashMap;
    }

    @Override
    public void run()
    {

        List<Record> record = conto.getRecords();

        for(int i=0; i<record.size(); i++)
            hashMap.replace( record.get(i).getReason(), hashMap.get( record.get(i).getReason()) + 1);

    }
}
