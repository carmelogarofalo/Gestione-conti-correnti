public class Record
{
    private String data;
    private String reason;

    public Record(String data, String reason)
    {
        this.data = data;
        this.reason = reason;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
