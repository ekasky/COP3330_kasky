public class Encrypter {
    
    public String encrypt(String digits) {

        String encrypted = "";
        int digitArray[] = new int[4];
        int temp;

        for(int i = 0; i < 4; i++) {
            digitArray[i] = Character.getNumericValue(digits.charAt(i));
            digitArray[i] +=7;
            digitArray[i] = digitArray[i] % 10;
        }

        temp = digitArray[0];
        digitArray[0] = digitArray[2];
        digitArray[2] = temp;

        temp = digitArray[1];
        digitArray[1] = digitArray[3];
        digitArray[3] = temp;

        for(int i = 0; i < 4; i++) {
            encrypted = encrypted.concat(Integer.toString(digitArray[i]));
        }

        return encrypted;

    }

}
