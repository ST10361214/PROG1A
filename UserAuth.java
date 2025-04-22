/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registeration;
import java.util.HashMap;
import java.util.regex.Pattern;
        
/**
 *
 * @author Karabo Leboho
 */
public class UserAuth {

    private HashMap<String, String> userDatabase = new HashMap<>();
    private HashMap<String, String> phoneDatabase = new HashMap<>();

    public boolean checkUserName(String username) { //https://www.w3schools.com/java/java_variables.asp
        return username != null && username.length() >= 4 && !userDatabase.containsKey(username);
    }

    public boolean checkPasswordCompatibility(String password) {
        if (password == null || password.length() < 6) return false;
        return password.matches(".*\\d.*");
    }

    public boolean checkCellPhoneNumber(String phone) {
        return Pattern.matches("\\d{10}", phone);
    }

    public String registerUser(String username, String password, String phone) { //https://www.w3schools.com/java/java_variables.asp
        if (!checkUserName(username)) {
            return "Username is invalid or already taken.";
        }
        if (!checkPasswordCompatibility(password)) {
            return "Password must be at least 6 characters and contain a number.";
        }
        if (!checkCellPhoneNumber(phone)) {
            return "Phone number must be a 10-digit number.";
        }

        userDatabase.put(username, password);
        phoneDatabase.put(username, phone);
        return "Registration successful.";
    }

    public boolean loginUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    public String returnLoginStatus(String username, String password) { //https://www.w3schools.com/java/java_variables.asp
        if (loginUser(username, password)) {
            return "Login successful. Welcome, " + username + "!";
        } else {
            return "Login failed. Check username or password.";
        }
    }
}