package simple;

public class 最长回文字串 {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int ansL = 0, ansR = 0, ansLen = 0;
        for(int i=0; i<s.length(); i++){
            // 奇回文
            int len = 1;
            while(i-len>=0 && i+len<s.length() && s.charAt(i-len)==s.charAt(i+len)){
                len++;
            }
            len--;
            if(2*len+1>ansLen){
                ansLen=2*len+1;
                ansL = i-len;
                ansR = i+len;
            }
            // 偶回文
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                int L = i, R = i+1;
                len = 1;
                while(L-len>=0 && R+len<s.length() && s.charAt(L-len)==s.charAt(R+len)){
                    len++;
                }
                len--;
                if(2*len+2>ansLen){
                    ansLen=2*len+2;
                    ansL = L-len;
                    ansR = R+len;
                }
            }
        }
        return s.substring(ansL,ansR+1);
    }

    public static void main(String [] args){
        String s = new 最长回文字串().longestPalindrome("");
        System.out.println(s);
    }
}
