package sha2;

import java.security.MessageDigest;
import java.util.Random;

public class Password_SHA2 {
    private char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    //generate hash_without_salt
    public String SHA2WithoutSalt(String inputStr) {
        String sha2WithoutSalt;
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");//申明使用SHA2算法
            sha2WithoutSalt = byteToHexStr(sha.digest(inputStr.getBytes()));
            System.out.println("Use SHA2 to encrypt password without salt to generate hash：" + sha2WithoutSalt);
            return sha2WithoutSalt;//哈希计算二进制文件转换成16进制
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }

    }

    //there are two ways to get the salt; input plaintext with salt added; generate salt_mixed_hash
    public String SHA2WithSalt(String inputStr, boolean type, String sha2WithSalt){
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");//use SHA2
            String salt = null;
            if (!type) {//注册存hash值到库时，new salt
                salt = salt();
            } else if (type) {//登录验证时，使用从库中查找到的hash值提取出的salt
                salt = getSaltFromHash(sha2WithSalt);//从库中查找到的hash值
            }
            String inputWithSalt = inputStr + salt;//加盐，输入加盐
            System.out.println("Random salt：" + salt);
            System.out.println("Connect the plaintext of password and salt：" + inputWithSalt);
            String hashResult = byteToHexStr(sha.digest(inputWithSalt.getBytes()));//哈希计算,转换输出
            System.out.println("Use SHA2 to encrypt password with salt to generate hash："+ hashResult);
            char[] cStr = new char[128];//将salt存储到hash值中，用于登陆验证密码时使用相同的盐
            for (int i = 0; i < 128; i += 2) {
                cStr[i] = hashResult.charAt(i / 2);
                cStr[i + 1] = salt.charAt(i / 2);//输出带盐，字符交替存储盐到hash值中;
            }
            hashResult = new String(cStr);
            System.out.println("Mix the salt and hash one character by character："+ hashResult);
            return hashResult;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    //generate salt randomly, the salt is a random string of 64 hexadecimal characters.
    public String salt() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(64);
        for (int i = 0; i < sb.capacity(); i++) {
            sb.append(hex[random.nextInt(16)]);
        }
        return sb.toString();
    }

    //transfer the byte_array into hex_string
    private String byteToHexStr(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        for (byte b : bytes) {
            hexStr.append(hex[b >>> 4 & 0xf]);
            hexStr.append(hex[b & 0xf]);
        }
        return hexStr.toString();
    }

    //get salt from salt_mixed_hash
    public String getSaltFromHash(String hash) {
        StringBuilder sb = new StringBuilder();
        char[] h = hash.toCharArray();
        for (int i = 0; i < hash.length(); i += 2) {
            sb.append(h[i + 1]);
        }
        return sb.toString();
    }
}