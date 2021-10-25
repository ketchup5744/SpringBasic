package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // Lombok 추가로 삭제
    @Autowired // 자동으로 의존관계 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy DiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = DiscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int ItemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, ItemPrice);
        return new Order(memberId, itemName, ItemPrice, discountPrice);
    }

    // 싱글톤 테스트 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
