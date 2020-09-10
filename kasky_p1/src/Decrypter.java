public class Decrypter {

    public String decrypt(String digits) {

        String decrypted = "";

        int digitArray[] = new int[4];
        int temp;

        for(int i = 0; i < 4; i++) {
            digitArray[i] = Character.getNumericValue(digits.charAt(i));
        }

        temp = digitArray[2];
        digitArray[2] = digitArray[0];
        digitArray[0] = temp;

        temp = digitArray[3];
        digitArray[3] = digitArray[1];
        digitArray[1] = temp;

        for(int i = 0; i < 4; i++) {

            for (int j = 0; j < 9; j++) {
                if ((j + 7) % 10 == digitArray[i]) {
                    digitArray[i] = j;
                    break;
                }
            }

            decrypted = decrypted.concat(Integer.toString(digitArray[i]));
        }

        return decrypted;

    }

}
