import com.opencsv.bean.CsvBindByName;

public class StateCodeData {

    @CsvBindByName(column = "StateName")
    public String stateName;

    @CsvBindByName(column = "Tin")
    public String tin;

    @CsvBindByName(column = "StateCode")
    public String stateCode;

    @Override
    public String toString(){
        return "IndiaCensusCSV{" +
                "StateName='" + stateName + '\'' +
                ", Tin='" + tin + '\'' +
                ", StateCode='" + stateCode + '\'' +
                '}';
    }
}
