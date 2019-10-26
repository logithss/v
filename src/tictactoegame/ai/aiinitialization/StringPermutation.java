package tictactoegame.ai.aiinitialization;

public class StringPermutation {
    private int pos = 0;
    private int sizeOfStr;
    private String toPermutate = "";
    private String[] allStringPermutations;
    
    public StringPermutation(String toPermutate) {
        this.toPermutate = toPermutate;
        sizeOfStr = this.toPermutate.length();
        
        this.allStringPermutations = new String[nFactorial(sizeOfStr)];
        this.stringPermutation(toPermutate, "");
    }

////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    public int getPos() {
        return this.pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getSizeOfStr() {
        return this.sizeOfStr;
    }

    public void setSizeOfStr(int sizeOfStr) {
        this.sizeOfStr = sizeOfStr;
    }

    public String getToPermutate() {
        return this.toPermutate;
    }

    public void setToPermutate(String toPermutate) {
        this.toPermutate = toPermutate;
    }

    public String[] getAllStringPermutations() {
        return this.allStringPermutations;
    }

    public void setAllStringPermutations(String[] allStringPermutations) {
        this.allStringPermutations = allStringPermutations;
    }

////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    private void stringPermutation(String str, String beginning) {
        if(str.length() == 0){
            this.allStringPermutations[pos] = beginning;
            pos++;
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            String result = 
                    str.substring(0, i) + str.substring(i + 1, str.length());
            stringPermutation(result, beginning + c);
        }
    }
    
    public static int nFactorial(int n){
        int res = 1;
        for(int i=n; i>0; i--){
            res *= i;
        }
        
        return res;
    }
    
    public static void printAllStrPerm(String[] strArr){
        for (String string : strArr) {
            System.out.println(string);
        }
    }
}