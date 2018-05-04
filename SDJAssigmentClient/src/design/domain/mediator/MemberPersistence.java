package design.domain.mediator;

import design.domain.model.Member;

public interface MemberPersistence
{
   public Member[] load(String loadWhat);
}
