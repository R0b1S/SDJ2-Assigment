package design.domain.mediator;

import design.domain.model.Member;

public interface MemberModel
{
   public Member[] getListAllMembers();
   public Member[] getListUnpaidMembers();
}
