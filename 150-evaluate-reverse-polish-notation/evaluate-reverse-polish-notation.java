class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<String> stack = new Stack<>();

        for(int i=0;i<n;i++){
            String str = tokens[i];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int sec = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                if(str.equals("+")) stack.push(String.valueOf(first + sec));
                else if(str.equals("-")) stack.push(String.valueOf(first - sec));
                else if(str.equals("*")) stack.push(String.valueOf(first * sec));
                else if(str.equals("/")) stack.push(String.valueOf(first / sec));
            }
            else stack.push(str);
        }
        return Integer.parseInt(stack.pop());
    }
}