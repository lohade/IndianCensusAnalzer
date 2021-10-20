import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    String INDIA_CENSUS_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.csv";

    @Test
    public void checkfile_returntrue() throws CensusAnalyzerException {

        CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
        int numofrecords=censusAnalyzer.censusData(INDIA_CENSUS_PATH);
        Assert.assertEquals(29,numofrecords);
    }
}
