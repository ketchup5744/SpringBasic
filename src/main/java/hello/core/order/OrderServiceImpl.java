package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPollicy discountPollicy = new FixDiscountPollicy();
//    private final DiscountPollicy discountPollicy = new FixDiscountPollicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPollicy;

    @Autowired // 자동으로 의존관계 주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPollicy) {
        this.memberRepository = memberRepository;
        this.discountPollicy = discountPollicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int ItemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPollicy.discount(member, ItemPrice);
        return new Order(memberId, itemName, ItemPrice, discountPrice);
    }

    // 싱글톤 테스트 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
