import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class MainTest {

    String INDIA_CENSUS_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.csv";
    String STATE_DATA_PATH="..\\src\\main\\resources\\IndianState.csv";

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

    @Test
    public void checkFileReturnException_whenTypeIncorrect()  {
        String path1="..\\src\\main\\resources\\IndianState.txt";
        try {
            if (!path1.contains("csv")) {
                CensusAnalyzer censusAnalyzer=new CensusAnalyzer();

                censusAnalyzer.censusData(path1);
            }
        }catch (CensusAnalyzerException e){
            Assert.assertEquals(CensusAnalyzerException.ExceptionData.File_EXTENSION_INCORRECT,e.type);
        }
    }

    @Test
    public void returnTrue_whenfe() throws ExceptionFile {
        String path2="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndianState.txt";
        if(!path2.contains("csv")){
            throw new ExceptionFile("give proper file Extension");
        }
    }
}


