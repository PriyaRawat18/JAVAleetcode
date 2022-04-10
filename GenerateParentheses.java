/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]*/


class Solution {
    class Element {
        String str;
        int opening;
        int closing;
        
        public Element(String str, int opening, int closing)
        {
            this.str = str;
            this.opening = opening;
            this.closing = closing;
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Queue<Element> q = new LinkedList<>();
        q.add(new Element("(", n-1, n));
        while(!q.isEmpty())
        {
            Element element = q.poll();
            if(element.opening == 0 && element.closing == 0)
            {
                res.add(element.str);
            } else {
                if(element.opening == element.closing)
                {
                    q.add(new Element(element.str + "(", element.opening-1, element.closing));
                } else {
                    if(element.opening > 0)
                    {
                        q.add(new Element(element.str + "(", element.opening-1, element.closing));
                    }
                    q.add(new Element(element.str + ")", element.opening, element.closing-1));                    
                }
            }
        }
        return res;
    }
}
