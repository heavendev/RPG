package connection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

public class PasswordCrypter {
	
	private static PasswordCrypter pc;
	
	private PasswordCrypter() {}
	
	public static PasswordCrypter getPasswordCrypter() {
		if (pc == null) {
			pc = new PasswordCrypter();
		}
		return pc;
	}
	
	public HashMap encryptNewPassword(String pw) throws NoSuchAlgorithmException {
		byte[] salt = getSalt();
		String password = get_SHA_512_SecurePassword(pw, salt);
		HashMap hm = new HashMap();
		hm.put("password", password);
		hm.put("salt", salt);
		return hm;
	}
	
	public String updatePassword(String pw, byte[] salt) {
		return (get_SHA_512_SecurePassword(pw,salt));
	}
	
	public  boolean checkPassword(String pw, byte[] salt, String cryptedPW) {
		pw = get_SHA_512_SecurePassword(pw, salt);
		return (pw.equals(cryptedPW));
	}
	
	private  String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
	
}