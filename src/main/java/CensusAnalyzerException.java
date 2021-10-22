public class CensusAnalyzerException extends Exception{
    public enum ExceptionType{
        CENSUS_FILE_PROBLEM,
        File_EXTENSION_INCORRECT,
        DELIMITER_PROBLEM,
        HEADER_PROBLEM
    }
    public ExceptionType type;

    public CensusAnalyzerException(String message,ExceptionType type){
        super(message);
        this.type=type;
    }
    public CensusAnalyzerException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }

    public CensusAnalyzerException(ExceptionType type){
        this.type=type;
    }
    public CensusAnalyzerException(String message){
        super(message);
    }
}
