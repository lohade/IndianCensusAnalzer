import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MainTest {
    CensusAnalyzer censusAnalyzer;
    @Before
    public void Census() {
          censusAnalyzer = new CensusAnalyzer();
    }

    String INDIA_CENSUS_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.csv";
    String STATE_DATA_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndiaStateCode.txt";


    @Test
    public void whenReadFile_count_returnTrue() throws CensusAnalyzerException {
        try {
            int numOfRecords=censusAnalyzer.censusData(INDIA_CENSUS_PATH,"");
            Assert.assertEquals(29,numOfRecords);
        }catch (CensusAnalyzerException e){
            e.printStackTrace();
            throw new CensusAnalyzerException(e.type);

        }
    }

    @Test
    public void whenIncorrectFile_returnException()  {
        try {
            Assert.assertEquals(29,censusAnalyzer.censusData(INDIA_CENSUS_PATH,""));

        }catch (CensusAnalyzerException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void checkFileReturnException_whenTypeIncorrect() throws CensusAnalyzerException {
        String path = "C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.txt";
        try {
            if (!path.contains("csv")) {
                CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
                censusAnalyzer.censusData(path, "");
            }
        } catch (CensusAnalyzerException e) {
            throw new CensusAnalyzerException("give proper file Extension");
            //Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);

        }
    }
}





