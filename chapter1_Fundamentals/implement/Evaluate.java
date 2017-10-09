package chapter1_Fundamentals.implement;

public class Evaluate {
	public static void main(String[] args) {
		String expre = "((1 + 2) * 3)";
		System.out.println(getValue(expre));
	}
	
	private static int getValue(String expression){
		MyStack<Character> ops = new MyStack(); 
		MyStack<Integer> vals = new MyStack();
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			if (c != ' '){
				if (c == '(')             {               }
				else if (c == ')'){
					int v = vals.pop();
					char op = ops.pop();
					if (op == '+')       {v += vals.pop();}
					else if(op == '-')   {v -= vals.pop();}
					else if(op == '*')   {v *= vals.pop();}
					else                 {v /= vals.pop();}
					vals.push(v);
				}
				else if(c == '+'||
						c == '-'||
						c == '*'||
						c == '/'){
					ops.push(c);
				}
				else{
					vals.push(c - '0');
				}
				
			}
			else{
				
			}
		}
		assert(vals.size() == 1);
		return vals.pop();
	}
}
