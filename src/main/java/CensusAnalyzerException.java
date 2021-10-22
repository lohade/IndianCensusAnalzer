public class CensusAnalyzerException extends Exception{
    public enum ExceptionType {

        CENSUS_FILE_PROBLEM,
        File_EXTENSION_INCORRECT,
        DELIMITER_PROBLEM
    }
    public ExceptionType type;

    public CensusAnalyzerException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
    public CensusAnalyzerException(String message){
        super(message);
    }
    public CensusAnalyzerException(ExceptionType type){
        this.type=type;
    }
    public CensusAnalyzerException(String message, Throwable cause, ExceptionType type) {
        super(message, cause);
        this.type = type;
    }

}
