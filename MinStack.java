class MinStack {
	class MinElement {
		public int height;
		public int value;

		public MinElement(int height, int value) {
			this.height = height;
			this.value = value;
		}
	}

	Stack<Integer> stack = new Stack<Integer>();
	Stack<MinElement> minStack = new Stack<MinElement>();

	public void push(int x) {
		stack.push(new Integer(x));
		// if the new one is smaller, add new element to minStack
		if (minStack.size() == 0 || x < minStack.peek().value)
			minStack.push(new MinElement(stack.size(), x));
	}

	public void pop() {
		stack.pop();
		if (stack.size() < minStack.peek().height)
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek().value;
	}
}

