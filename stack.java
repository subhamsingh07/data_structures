class stack<T>
{
	private class List
	{
		List prev;
		T ele;
		List next;
		List(T ele)
		{
			prev=null;
			this.ele=ele;
			next=null;
		}
	}
	private List head;
	private List tail;
	private int length;
	stack()
	{
		head=tail=null;
		length=0;
	}
	stack(T ele)
	{
		head=tail=new List(ele);
		length=1;
	}
	void push(T ele)
	{
		if(head==null)
			head=tail=new List(ele);
		else
		{
			tail.next=new List(ele);
			tail.next.prev=tail;
			tail=tail.next;
		}
		length++;
	}
	void pop()
	{
		if(head==null)
			throw new NullPointerException("Nothing to pop out");
		else if(head==tail)
			head=tail=null;
		else
		{
			tail.prev.next=null;
			tail=tail.prev;
		}
		length--;
	}
	T peek()
	{
		return tail.ele;
	}
	int length()
	{
		return length();
	}
	boolean isEmpty()
	{
		return length==0?true:false;
	}
	public String toString()
	{
		if(head==null)
			return "[]";
		StringBuffer sb=new StringBuffer("[");
		List trav=head;
		for(int i=0;i<length-1;i++)
		{
			sb.append(trav.ele+", ");
			trav=trav.next;
		}
		sb.append(trav.ele+"]");
		return sb.toString();
	}
}