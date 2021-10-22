import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class MainTest {

    String INDIA_CENSUS_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.csv";
    String STATE_DATA_PATH="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndiaStateCode.csv";

    CensusAnalyzer censusAnalyzer;
    @Before
    public void MainTest(){
        censusAnalyzer=new CensusAnalyzer();
    }



    @Test
    public void checkFile_returnTrue_whenCountEqual(){
        try {
            CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
            int numofrecords=censusAnalyzer.censusData(INDIA_CENSUS_PATH,"");
            Assert.assertEquals(29,numofrecords);

        }catch (CensusAnalyzerException e){
            e.printStackTrace();
        }
    }
    @Test
    public void ifIncorrectFileType_returnException()  {

        try {
            CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
            ExpectedException exception=ExpectedException.none();
            exception.expect(CensusAnalyzerException.class);
            censusAnalyzer.censusData(INDIA_CENSUS_PATH,"");
        }catch (CensusAnalyzerException e){
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void checkFileReturnException_whenTypeIncorrect() throws CensusAnalyzerException {
        String path1="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.txt";
        try {
            if (!path1.contains("csv")) {
                CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
                censusAnalyzer.censusData(path1,"");
            }
        }catch (CensusAnalyzerException e){
            throw new CensusAnalyzerException(e.type,"File Extension");
            //Assert.assertEquals(CensusAnalyzerException.ExceptionType.File_EXTENSION_INCORRECT,e.type);
        }
    }

    @Test
    public void checkFileStateCode_returnTrue_whenEqualData(){
        try {
            CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
            int num = censusAnalyzer.stateCodeData(STATE_DATA_PATH);
            Assert.assertEquals(37, num);
        }catch (CensusAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void checkFilePath_whenIncorrect_returnException() throws CensusAnalyzerException{
        try {
            Assert.assertEquals(37,censusAnalyzer.stateCodeData("C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndiaStateCode.txt"));
        }catch (CensusAnalyzerException e){
            System.out.println(e.type);
            //System.out.println(e.getMessage());
            //Assert.assertEquals(e.type,CensusAnalyzerException.ExceptionType.File_EXTENSION_INCORRECT);
        }
    }

    @Test
    public void whenEnterCorrectFile_returnException_ifExtensionNotMatch() throws CensusAnalyzerException {
        String path="C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndiaStateCode.txt";
        try{
            if(!path.contains("csv")){
                CensusAnalyzer censusAnalyzer=new CensusAnalyzer();
                censusAnalyzer.censusData(path,"");
            }
        }catch (CensusAnalyzerException e){
            throw new CensusAnalyzerException("please check Extension", CensusAnalyzerException.ExceptionType.File_EXTENSION_INCORRECT);
        }
    }

    @Test
    public void when_CorrectStateCensusCSVFile_But_Header_Incorrect_Should_Return_False() throws IOException {

        try {
            Assert.assertEquals(29, censusAnalyzer.censusData("C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\Census.csv","com.example"));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void when_CorrectStateCodeCSVFile_But_Header_Incorrect_Should_Return_False() throws IOException {

        try {
            Assert.assertEquals(37, censusAnalyzer.stateCodeData("C:\\Users\\Arti\\IdeaProjects\\IndianCensus\\src\\main\\resources\\IndiaStateCode.csv"));
        } catch (CensusAnalyzerException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.HEADER_PROBLEM, e.type);
        }
    }
}


