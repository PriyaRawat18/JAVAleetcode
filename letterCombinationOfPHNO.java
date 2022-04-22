/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 */


class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){ //if no digits is dialled then digits will be null or the length will be empty so, 
            return new ArrayList<>(); //a plain list with no elements has to be returned
        }
        ArrayList<String> ans = helper("", digits); //i have created a helper function which returns an ArrayList of strings
        return ans;
    }
    
    static ArrayList<String> helper(String p, String up){ //"up" is the unprocessed strng which is basically the original string taken as input and p is the processed string which undergoes changes after each recursion and is the answer we need
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();  //this is the ArrayList which will contain processed string and this list will be returned.
            list.add(p);
            return list;
        }
        int digit  = up.charAt(0) - '0'; //this will convert '2', a string character into 2 an integer digit
        ArrayList<String> list = new ArrayList<>(); 
        if(digit==7){ //if the digit pressed on the phone is  7 then its corresponding alphabets will be pqrs ascii codes for pqrs are 16,17,18,19 and since ascii characters are added from a which is 1, the i valeus become 15, 16, 17, 18 respectively.
        for (int i = 15; i<=18; i++){
            char ch = (char)('a'+i); //character to add
            list.addAll(helper(p+ch, up.substring(1))); //the processed string is appended with the latest characters and unprocsedd string is considered from the second index 
        }    
        }
        else if(digit==8){ 
        for (int i = 19; i<=21; i++){
            char ch = (char)('a'+i); //character to add
            list.addAll(helper(p+ch, up.substring(1)));
        }
        }
        else if(digit==9){
            for (int i = 22; i<=25; i++){
            char ch = (char)('a'+i); //character to add
            list.addAll(helper(p+ch, up.substring(1)));
        }
        }
        else{ //in case 1 to 6 or a 2 digit number is pressed this pattern is followed for guessing the ascii values 
        for (int i = ((digit-1)*3)-3; i<=((digit-1)*3)-1; i++){
            char ch = (char)('a'+i); //character to add
            list.addAll(helper(p+ch, up.substring(1))); 
        }
        }
        return list; //finally list appended so many times so far is returned
    }
}
