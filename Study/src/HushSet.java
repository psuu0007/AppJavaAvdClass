

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class HushSet {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      HashSet<Integer> setS = new HashSet<Integer>();
      int m = Integer.parseInt(br.readLine());
      String[] inputStr = new String[2];
      
      String command = "";
      int inputNum = 0;
      
      for (int i = 0; i < m; i++) {
         inputStr = br.readLine().split(" ");
         command = inputStr[0];
         try {
            inputNum = Integer.parseInt(inputStr[1]);
         } catch (Exception e) {
            inputNum = 0;
         }
         
         switch (command) {
            case "add":
               setS.add(inputNum);
               break;
            case "remove":
               setS.remove(inputNum);
               break;
            case "check":
               bw.write((setS.contains(inputNum) ? 1 : 0) + "\n");
               break;
            case "toggle":
               if(setS.contains(inputNum)) {
                  setS.remove(inputNum);
               } else {
                  setS.add(inputNum);
               }
               break;
            case "all":
               for (int j = 1; j <= 20; j++) {
                  setS.add(j);
               }
               break;
            case "empty":
               setS.clear();
               break;
         }
      }
      
      bw.flush();
      bw.close();
      br.close();
   }
}