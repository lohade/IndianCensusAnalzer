import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CensusAnalyzer{
    List<IndiaCensusAnalyzer> csvCensus=new ArrayList<>();

    List<StateCode> codeCsv=new ArrayList<>();


    public int censusData(String path,String methodName) throws CensusAnalyzerException {
        int numOfEntry=0;
        Reader reader;
        try {
            reader= Files.newBufferedReader(Paths.get(path));
            CsvToBeanBuilder<IndiaCensusAnalyzer> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusAnalyzer.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusAnalyzer> csvToBean= csvToBeanBuilder.build();
            Iterator<IndiaCensusAnalyzer> censusAnalyzerIterator=csvToBean.iterator();

            while (censusAnalyzerIterator.hasNext()){
                numOfEntry++;
                IndiaCensusAnalyzer censusData=censusAnalyzerIterator.next();
                csvCensus.add(censusData);
            }
            //System.out.println(csvCensus);

        }catch (IOException e){
            throw new CensusAnalyzerException(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,"File Not Found");
        }
        return numOfEntry;
    }

    public int stateData(String path) throws CensusAnalyzerException {
        int numOfState=0;
        Reader reader;
        try {
            reader= Files.newBufferedReader(Paths.get(path));
            CsvToBeanBuilder<StateCode> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCode.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<StateCode> csvToBean= csvToBeanBuilder.build();
            Iterator<StateCode> censusAnalyzerIterator1=csvToBean.iterator();

            while (censusAnalyzerIterator1.hasNext()){
                numOfState++;
                StateCode stateData=censusAnalyzerIterator1.next();
                codeCsv.add(stateData);
            }
            //System.out.println(codeCsv);

        }catch (IOException e){
            throw new CensusAnalyzerException(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,"File Not Found");
        }
        return numOfState;
    }
}
