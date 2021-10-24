class queue<T>
{
	private class List
	{
		T ele;
		List next;
		List()
		{
			ele=null;
			next=null;
		}
		List(T ele)
		{
			this.ele=ele;
			next=null;
		}
	}
	private int length;
	private List front;
	private List rear;
	queue()
	{
		front=rear=new List();
		length=0;
	}
	queue(T obj)
	{
		front=rear=new List(obj);
		length=1;
	}
	void push(T ele)
	{
		if(front==null)
			front=rear=new List(ele);
		else
		{
			rear.next=new List(ele);
			rear=rear.next;
		}
		length++;
	}
	void pop()
	{
		if(front==null)
			throw new NullPointerException("Nothing to Pop Out");
		else if(front==rear)
			front=rear=null;
		else
			front=front.next;
		length--;
	}
	T peek()
	{
		if(front==null)
			throw new NullPointerException();
		return front.ele;
	}
	int length()
	{
		return length;
	}
	boolean isEmpty()
	{
		return length==0?true:false;
	}
	public String toString()
	{
		if(front==null)
			return "[]";
		StringBuffer sb=new StringBuffer("[");
		List trav=front;
		for(int i=0;i<length-1;i++)
		{
			sb.append(trav.ele+", ");
			trav=trav.next;
		}
		sb.append(trav.ele+"]");
		return sb.toString();
	}
}