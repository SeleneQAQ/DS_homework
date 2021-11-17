package sha2;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class PasswordStorage {
    /*手动创建用户注册信息*/
    public static void main(String[] args)  {
        String userName = "Tom";
        String passWord = "Tomas";
        String filePath = "./RMI_Printer_Server/login.txt";
        Password_SHA2 sha2 = new Password_SHA2();
        System.out.println("SHA-2 Cryptography\n" + "plaintext of password：" + passWord);
        sha2.SHA2WithoutSalt(passWord);
        inputToFile(userName, sha2.SHA2WithSalt(passWord, false, null), filePath);
    }


    public static void inputToFile(String userName, String sha2WithSalt, String filePath){
        File file = new File(filePath);
        //如果文件不存在，则自动生成文件；
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            file.setWritable(true);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(userName + " " + sha2WithSalt + "\n");
            bw.close();
            fw.close();
            file.setWritable(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
