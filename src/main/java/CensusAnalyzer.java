import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CensusAnalyzer{
    List<IndiaCensusAnalyzer> censusAnalyzerList=new ArrayList<>();
    List<StateCodeData> codeDataList=new ArrayList<>();

    public int censusData(String path) throws CensusAnalyzerException {
        try {
            Reader reader= Files.newBufferedReader(Paths.get(path));
            CsvToBeanBuilder<IndiaCensusAnalyzer> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusAnalyzer.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusAnalyzer> csvToBean= csvToBeanBuilder.build();
            Iterator<IndiaCensusAnalyzer> censusAnalyzerIterator=csvToBean.iterator();
            int numOfEntry=0;
            while (censusAnalyzerIterator.hasNext()){
                numOfEntry++;
                IndiaCensusAnalyzer censusData=censusAnalyzerIterator.next();
                censusAnalyzerList.add(censusData);
            }
            return numOfEntry;

        }catch (IOException e){
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int stateCodeData(String path) throws CensusAnalyzerException {
        try {
            Reader reader= Files.newBufferedReader(Paths.get(path));
            CsvToBeanBuilder<StateCodeData> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCodeData.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<StateCodeData> csvToBean= csvToBeanBuilder.build();
            Iterator<StateCodeData> censusAnalyzerIterator=csvToBean.iterator();
            int numOfState=0;
            while (censusAnalyzerIterator.hasNext()){
                numOfState++;
                StateCodeData censusData=censusAnalyzerIterator.next();
                codeDataList.add(censusData);
            }
            return numOfState;

        }catch (IOException e){
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }


}
