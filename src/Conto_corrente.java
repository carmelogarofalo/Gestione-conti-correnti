import java.util.List;

public class Conto_corrente
{
    private String proprietario;
    private List<Record> records;

    public Conto_corrente(String proprietario, List<Record> records)
    {
        this.proprietario = proprietario;
        this.records = records;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
