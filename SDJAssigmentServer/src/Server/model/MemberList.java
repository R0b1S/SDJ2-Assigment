package Server.model;


import java.util.ArrayList;

public class MemberList {
	
	private ArrayList<Member> memberList;
	
	
	public MemberList()
	{
		memberList = new ArrayList<Member>();
	}

	public int getNumberOfMembers()
	{
		return memberList.size();
	}
	
	public void removeMember(Member member)
	{
	   if(member != null)
	      memberList.remove(member);
	}
	
	public void removeMemberbyindex(int index)
	{
		if(index < 0 && index > getNumberOfMembers())
		   throw new RuntimeException("Invalid index");
		memberList.remove(index);
	}
	
	public void addMember(Member member)
	{
		if(member != null)
		   memberList.add(member);
	}
	
	public Member[] getAllMembers()
	{
		return memberList.toArray(new Member[getNumberOfMembers()]);
	}
	
	public String toString()
	{
		String returnString ="Member list \n " + 
		                     "-----------------------------------------------------------\n" + 
		                     "Name | Address | Email | Phone | Date of birth | Mem.From | Paid fee\n";
		
		
		for(int i = 0; i < getNumberOfMembers(); i++){
			returnString += getAllMembers()[i].toString() + "\n";
			}

			return returnString;
	}
}
