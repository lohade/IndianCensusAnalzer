
public class CensusAnalyzerException extends Exception{

    public enum ExceptionType{
        CENSUS_FILE_PROBLEM

    }
    public enum ExceptionData{
        File_EXTENSION_INCORRECT
    }
    public ExceptionType type;
    public ExceptionData data;

    public CensusAnalyzerException(String message,ExceptionType type){
        super(message);
        this.type=type;


    }
}
