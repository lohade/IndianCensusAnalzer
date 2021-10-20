import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;


public class CensusAnalyzer{

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
            }
            return numOfEntry;

        }catch (IOException e){
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }

    }
}
