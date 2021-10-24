class doubly_linked_list<T>
{
	private class List
	{
		@SuppressWarnings("unused")
		List prev;
		T element;
		List next;
		List(T element)
		{
			this.element=element;
		}
	}
	private List head,tail;
	private int length;
	doubly_linked_list()
	{
		head=tail=null;
		length=0;
	}
	doubly_linked_list(T element)
	{
		head=tail=new List(element);
		length=1;
	}
	void add(T ele)
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
	void insert(int ind,T ele)
	{
		if(ind<0||ind>length)
			throw new NullPointerException("Index Out Of Bounds");
		//to be continued
	}
	public String toString()
	{
		if(head==null)
			return "[]";
		StringBuffer sb=new StringBuffer("[");
		List trav=head;
		for(int i=0;i<length-1;i++)
		{
			sb.append(trav.element+", ");
			trav=trav.next;
		}
		sb.append(trav.element+"]");
		return sb.toString();
	}
}