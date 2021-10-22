import com.opencsv.bean.CsvBindByName;

public class IndiaCensusAnalyzer {

    @CsvBindByName(column = "State",required = true)
    public String state;

    @CsvBindByName(column = "Population",required = true)
    public String population;

    @CsvBindByName(column = "AreaInSqKm")
    public String areaKm;

    @CsvBindByName(column = "DensityPerSqKm",required = true)
    public String densityKm;

    @Override
    public String toString(){
        return "IndiaCensusCSV{" +
                "State='" + state + '\'' +
                ", Population='" + population + '\'' +
                ", AreaInSqKm='" + areaKm + '\'' +
                ", DensityPerSqKm='" + densityKm + '\'' +
                '}' + "\n" ;
    }

}
