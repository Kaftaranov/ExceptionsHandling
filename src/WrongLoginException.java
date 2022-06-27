import java.io.IOException;
public class WrongLoginException extends IOException {
    public WrongLoginException(){
        super();
    }
    public WrongLoginException(String s) {super(s);}
}
