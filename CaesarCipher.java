
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        //if (key < 0) key = 26  + key;
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }
    
    public String encrypt(String message){
        StringBuilder sbIn = new StringBuilder(message);
        StringBuilder sbOut = new StringBuilder();        
        System.out.println(message);
        
        for (int i = 0; i < message.length(); i++){
            char ch = message.charAt(i);
            //System.out.println("Character: " + ch);
            //System.out.println("getting index of " + ch );
            //System.out.println("alphabet:  " + alphabet);
            int idx = alphabet.indexOf(Character.toUpperCase(ch));
            //System.out.println("Index = " + idx);
            if (idx != -1){
                if (Character.isLowerCase(ch)){
                    sbOut.append(Character.toLowerCase(shiftedAlphabet.charAt(idx)));
                } else {
                    sbOut.append(shiftedAlphabet.charAt(idx));
                }
            } else {
                sbOut.append(ch);                
            }
        }
        return sbOut.toString();        
    }
    
    public String decrypt(String encrypted){
        //System.out.println("Decrypting using: " + mainKey);
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(encrypted);
    }
}
