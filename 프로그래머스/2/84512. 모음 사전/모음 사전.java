public class Solution {
   
    public int solution(String word) {
        
        String tmp = "A";
        int cnt = 1;
        
        while(tmp != null){
            // System.out.println(tmp);
            if(tmp.equals(word)) return cnt;
            tmp = next_word(tmp); cnt++;
        }

        
        int answer = 0;


        return answer;
    }

    private String next_word(String tmp) {
        if(tmp.length() <= 4) return tmp+"A";
        if(tmp.length() == 5 && tmp.charAt(4) != 'U') return tmp.substring(0, 4)+next_char(tmp.charAt(4));
        if(tmp.length() == 5 && tmp.equals("UUUUU") )return null;
        if(tmp.length() == 5 && tmp.substring(1,5).equals("UUUU")) return ""+next_char(tmp.charAt(0));
        if(tmp.length() == 5 && tmp.substring(2,5).equals("UUU")) return tmp.substring(0,1)+next_char(tmp.charAt(1));
        if(tmp.length() == 5 && tmp.substring(3,5).equals("UU")) return tmp.substring(0,2)+next_char(tmp.charAt(2));
        if(tmp.length() == 5 && tmp.charAt(4) == 'U') return tmp.substring(0,3)+next_char(tmp.charAt(3));
        return null;
    }

    private char next_char(char ch) {
        if(ch == 'A') return 'E';
        else if(ch == 'E') return 'I';
        else if(ch == 'I') return 'O';
        else if(ch == 'O') return 'U';
        else return 'A';
    }

}
