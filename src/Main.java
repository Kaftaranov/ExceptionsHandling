public class Main {
    private static final int allowedLoginLength = 20;
    private static final int allowedPasswordLength = 19;
    private static final String allowedSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_";
    private static final String login = "LoginToMyProgram_987";
    private static final String password = "PasswordToMyProgram";
    private static final String confirmPassword = "PasswordToMyProgram";

    public static boolean validationSuccessful() {
        try {
            userCredentialsValidation(login, password, confirmPassword);
        }catch (WrongLoginException loginException){
            System.out.println(loginException.getMessage());
            return  false;
        }catch (WrongPasswordException passwordException){
            System.out.println(passwordException.getMessage());
            return false;
        }
    return true;
    }

    private static void userCredentialsValidation(String login, String password, String confirmPassword)
            throws WrongPasswordException, WrongLoginException {
        if (login.length() > allowedLoginLength) {
            throw new WrongLoginException("Maximum length of login is " + allowedLoginLength + " symbols. " +
                    "Length of your login is " + login.length() + " symbols.");
        }
        for (int i = 0; i < login.length(); i++) {
            if (!allowedSymbols.contains(String.valueOf(login.charAt(i)))) {
                throw new WrongLoginException("Login should contain latin letters, numbers and underline symbols.");
            }
        }
        if (password.length() > allowedPasswordLength) {
            throw new WrongPasswordException("Maximum length of password is " + allowedPasswordLength + " symbols. " +
                    "Length of your login is " + password.length() + " symbols.");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!allowedSymbols.contains(String.valueOf(password.charAt(i)))) {
                throw new WrongPasswordException("Password should contain latin letters, numbers and underline symbols.");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords are not equal!");
        }
    }

    public static void main(String[] args) {
        if (validationSuccessful()) {
            System.out.println("Validation complete.");
        }else {
            System.out.println("Validation failed. Please check your credentials.");
        }
    }

}