import java.util.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class sha128 {
    public sha128(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("SHA128 ENCRYPTION MODE");
        }

        public String takeInput(){
            System.out.printf("Enter a string: ");
            Scanner input = new Scanner(System.in);
            return input.nextLine();
        }

        public String encode(){
            String password = takeInput();
            final byte[] defaultBytes = password.getBytes();
            try {
                final MessageDigest sha128Digest = MessageDigest.getInstance("SHA-1");
                byte[] messageDigest = sha128Digest.digest(password.getBytes());
                BigInteger no = new BigInteger(1, messageDigest);
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }

                // return the HashText
                return hashtext;
            }
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        public void printHash(){
            System.out.println("SHA128: " + encode());
        }
    }

