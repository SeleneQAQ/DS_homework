package sha2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PasswordAuthentication {

    public boolean passwordAuthentication(String userName, String passWord, String filePath){
        BufferedReader reader;
        String []temp;
        Password_SHA2 sha2 = new Password_SHA2();
        boolean type = false;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                temp = line.split(" ");
                if(userName.equals(temp[0])&&sha2.SHA2WithSalt(passWord, true, temp[1]).equals(temp[1])){
                    type = true;
                    break;
                }
                line = reader.readLine();
            }
            if(!type){
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return type;
    }
}
