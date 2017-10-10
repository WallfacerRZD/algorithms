package chapter1_Fundamentals.implement;

public class Evaluate {
	public static void main(String[] args) {
		String expre = "( ( ( 234235 + 5.28 ) * ( 12423 - 8974 ) ) / ( 123 - 235232 ) )";
		System.out.println(getValue(expre));
	}

	private static double getValue(String expression) {
		MyStack<String> ops = new MyStack();
		MyStack<Double> vals = new MyStack();
		String[] str_array = expression.split(" ");
		for (int i = 0; i < str_array.length; ++i) {
			String c = str_array[i];
			if (c.equals("(")) {
			} else if (c.equals(")")) {
				double v = vals.pop();
				String op = ops.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else {
					v = vals.pop() / v;
				}
				vals.push(v);
			} else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
				ops.push(c);
			} else {
				vals.push(Double.parseDouble(c));
			}

		}
		assert vals.size() == 1;
		return vals.pop();
	}
}
