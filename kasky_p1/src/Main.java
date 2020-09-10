public class Main {

    public static void main(String[] args) {

        Encrypter encrypt_test = new Encrypter();
        Decrypter decrypt_test = new Decrypter();
        String encrypted;
        String decrypted;

        encrypted = encrypt_test.encrypt("6798");
        decrypted = decrypt_test.decrypt("6534");
        System.out.println(encrypted);
        System.out.println(decrypted);




    }

}
