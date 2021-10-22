import com.opencsv.bean.CsvBindByName;

public class StateCode {

    @CsvBindByName(column = "State Name")
    public String state_name;

    @CsvBindByName(column = "Tin")
    public String state_tin;

    @CsvBindByName(column = "StateCode")
    public String state_code;

    @Override
    public String toString(){
        return "State{" +
                "State Name='" + state_name + '\'' +
                ", Tin='" + state_tin + '\'' +
                ", StateCode='" + state_code + '\'' +
                '}' + "\n";
    }
}
