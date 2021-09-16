package hello.core.order;

import hello.core.discount.DiscountPollicy;
import hello.core.discount.FixDiscountPollicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPollicy discountPollicy = new FixDiscountPollicy();
    private final DiscountPollicy discountPollicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int ItemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPollicy.discount(member, ItemPrice);
        return new Order(memberId, itemName, ItemPrice, discountPrice);
    }
}
