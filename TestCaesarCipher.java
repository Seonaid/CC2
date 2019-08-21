import edu.duke.*;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    public void simpleTests(){
        CaesarCipher cc = new CaesarCipher(18);
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        String encrypted = cc.encrypt(message);
        System.out.println("Encyrypted message is: ");
        System.out.println(encrypted);
        
        System.out.println("Decrypted message is: ");
        System.out.println(cc.decrypt(encrypted));
    }
    
    public String breakCaesarCipher(String message){
        int dkey = 0;
        int[] freqs = countLetters(message);
        int maxDex = indexOfMax(freqs);
        if (maxDex < 4) { 
            dkey = 26 - (4 - maxDex);
        } else { 
            dkey = maxDex - 4; 
        }
        
        CaesarCipher cc = new CaesarCipher(dkey);
        String decrypted = cc.encrypt(message);
        return decrypted;
    }
  

    private int[] countLetters(String message){
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k< message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int idx = alphabet.indexOf(ch);
            if (idx !=-1){
                counts[idx]++;
            }
        } 
        
        return counts;
    }

    private int indexOfMax(int[] values){
        int maxValue = 0;
        int idx = 0;
        for (int i=0; i<values.length; i++){
            if (values[i] > maxValue) {
                maxValue = values[i];
                idx = i;
            }
        }
        return idx;
    }    

    private void resetCounts(int[] counts){
        for (int i=0; i<counts.length; i++){
            counts[i] = 0;
        }
    }
    
}
