package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPollicy discountPollicy = new FixDiscountPollicy();
//    private final DiscountPollicy discountPollicy = new FixDiscountPollicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPollicy;

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
}
