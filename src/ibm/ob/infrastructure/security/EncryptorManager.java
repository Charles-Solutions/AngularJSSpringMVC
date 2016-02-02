package ibm.ob.infrastructure.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;


public class EncryptorManager {
	
	private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	private static StrongTextEncryptor textEncryptor =new StrongTextEncryptor();
	
	
	public static String encryptPassword(String password){
		
		if(password !=null && !password.equals("")){			
			
			return passwordEncryptor.encryptPassword(password);
		}
		
		return null;		
	}
	
     
	public static String encryptText(String message){
		
		if(message !=null && !message.equals("")){			
			
			return textEncryptor.encrypt(message);
		}
		
		return null;		
	}
	
	
	
	public static boolean checkPassword(String plainPassword, String encryptedPassword){
		
		return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
	}
	
	
    public static boolean equalsPassword(String oldPassword, String newPassword){
		
		return oldPassword.equals(newPassword);
	}
    
    public static void main(String[] args) {
		System.out.println(EncryptorManager.encryptPassword("alex"));
	}

}
