
public class single_linked_list<T>
{
	private class List
	{
		T element;
		List next;
		List(T element)
		{
			this.element=element;
		}
	}
	private List head;
	private List tail;
	private int length;
	single_linked_list()
	{
		head=tail=null;
		length=0;
	}
	single_linked_list(T element)
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
			tail=tail.next;
		}
		length++;
	}
	void insert(int ind,T ele)
	{
		if(ind<0||ind>=length)
			throw new NullPointerException("Index Out Of Bounds");
		if(ind==0)
		{
			List temp=new List(ele);
			temp.next=head;
			head=temp;
			length++;
			return;
		}
		List trav=head;
		for(int i=0;i<ind-1;i++)
			trav=trav.next;
		List temp=new List(ele);
		temp.next=trav.next;
		trav.next=temp;
		length++;
	}
	void set(int ind,T ele)
	{
		if(ind<0||ind>=length)
			throw new NullPointerException("Index Out Of Bounds");
		List trav=head;
		for(int i=0;i<ind;i++)
			trav=trav.next;
		trav.element=ele;
	}
	T get(int ind)
	{
		if(ind<0||ind>=length)
			throw new NullPointerException("Index Out Of Bounds");
		List trav=head;
		for(int i=0;i<ind;i++)
			trav=trav.next;
		return trav.element;
	}
	void remove(T ele)
	{
		if(head.element.equals(ele))
		{
			head=head.next;
			length--;
		}
		else
		{
			List trav=head;
			for(int i=0;i<length-1;i++)
			{
				if(trav.next.element.equals(ele))
				{
					trav.next=trav.next.next;
					length--;
					return;
				}
				trav=trav.next;
			}
		}
	}
	void removeAt(int ind)
	{
		if(ind<0||ind>=length)
			throw new NullPointerException("Index Out Of Bounds");
		List trav=head;
		if(ind ==0)
			head=head.next;
		else
		{
			for(int i=0;i<ind-1;i++)
				trav=trav.next;
			trav.next=trav.next.next;
		}
		length--;
	}
	int length()
	{
		return length;
	}
	boolean isEmpty()
	{
		return length==0;
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