public class Main {
private static final int allowedLoginLength = 20;
private static final int allowedPasswordLength = 19;
private static final String allowedSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_";
    public static Boolean userCredentialsValidation(String login, String password, String confirmPassword)
    throws WrongPasswordException, WrongLoginException
    {
        if (login.length() > allowedLoginLength) {
            throw new WrongLoginException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException ();
        }
        if (password.length() > allowedPasswordLength){
            System.out.println("Maximum length of password is " + allowedPasswordLength + " symbols.");
            System.out.println("Length of your password is " + password.length() + " symbols.");
            return false;
        }
            for (int i = 0; i < login.length(); i++) {
               // for (int j = 0; j <= allowedSymbols.length();j++){//(allowedSymbols.charAt(j) == (login.charAt(i)))
                    if (!allowedSymbols.contains(login.substring(i,i+1))) {
                        System.out.println("Login should contain latin letters, numbers and underline symbols.");
                        return false;
                    }
                }

            return true;
    }

    public static void main(String[] args) {
        String login = "LoginToMyProgram_98";
        String password = "PasswordToMyProgram";
        String confirmPassword = "PasswordToMyProgram";
    try{
       if (userCredentialsValidation(login, password, confirmPassword)) {
           System.out.println("User credentials validation successful.");
       }

    } catch (WrongLoginException e){
        System.out.println("Maximum length of login is " + allowedLoginLength + " symbols.");
        System.out.println("Length of your login is " + login.length() + " symbols.");

    } catch (WrongPasswordException e) {
        System.out.println("Passwords are not equal!");
    }
    finally {
        System.out.println("User credentials validation complete.");
    }
    }
}