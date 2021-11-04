package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //추상화에도 의존하고, 구체화에도 의존. - DIP 위반
// Repository 구현체 변경하려면 클라이언트인 MemberServiceImpl 수정해야 함. - OCP 위반
//private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired //자동 의존관계 주입  ac.getBean(MemberRepository.class) 이 코드가 들어간다고 보면 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}


