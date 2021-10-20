import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MainTest {

    String INDIA_CENSUS_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.csv";
    String STATE_DATA_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndianState.csv";

    @Test
    public void checkfile_returntrue(){
        try {
            CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
            int numofrecords=censusAnalyzer.censusData(INDIA_CENSUS_PATH);
            Assert.assertEquals(29,numofrecords);

        }catch (CensusAnalyzerException e){ }
    }
    @Test
    public void ifIncorrectFile_returnException()  {
        try {
            CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
            ExpectedException exception=ExpectedException.none();
            exception.expect(CensusAnalyzerException.class);
            censusAnalyzer.censusData(STATE_DATA_PATH);
        }catch (CensusAnalyzerException e){
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}
