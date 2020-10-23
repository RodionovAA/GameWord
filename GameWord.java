import java.io.*;
import java.util.*;

class Bank{
  private List<String> word = new ArrayList<String>();
  
  public Bank() throws FileNotFoundException, IOException{
      
      File file = new File("bank.txt");
      FileReader reader = new FileReader(file);
      BufferedReader buff = new BufferedReader(reader);
      String in = null;
      while((in = buff.readLine())!= null){
          
          for(String val : in.split(" ")){
              word.add(val);
          }
      }
  }
  public String getWord(){
      String res = null;
      int idx = 0;
      
      if (word.isEmpty()){
          System.out.println("Bank is empty");
          return null;
      }
      idx = (int) (Math.random() * word.size());
      
      res = word.get(idx);
      return res;
  }
}

public class GameWord {

    public static void main(String[] args) throws IOException {

        Bank bank = new Bank();
        String word = bank.getWord();
        if (word == null){
            throw new IllegalArgumentException("Word not founded");
        }
        int counter = 0;
        String output = new String();
        char[] wordArr = word.toCharArray();
        char[] wordArr1 = new char[word.length()];
        for(int j=0;j<wordArr1.length;j++){
            wordArr1[j]='_';
        }
        
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        boolean fullword = false;
        boolean fail = false;
        while(flag){
        String res = scan.nextLine();
        System.out.println("Key in one character or your guess word: "+res);
        counter++;
        for(int i =0;i<wordArr.length;i++){
            if (wordArr[i] == res.charAt(0) && !(word.equals(res))&& res.length()== 1){
               wordArr1[i] =  wordArr[i];
            } else if ((word.equals(res))){
                fullword = true;
            } else if (res.length() > 1 && !(word.equals(res))) {  
                    fullword = true;
                    fail = true;
            } else {
                if (wordArr1[i] !=  wordArr[i]){
                    wordArr1[i] = '_'; 
                }
            }
        }
        if(fullword){
            break;
        }
        flag = false;
        for(int k =0;k<wordArr1.length;k++){
            if(wordArr1[k] == '_'){
                flag = true;
            }
        }
        output = String.copyValueOf(wordArr1);
        System.out.println("Trial "+ Integer.toString(counter)+":"+ output);
        }
        if (fail != true){
            System.out.println("Congratulation!");
            System.out.println("You got in "+Integer.toString(counter) +" trials"); 
        } else {
            System.out.println("Fail");
        }
    }
}
