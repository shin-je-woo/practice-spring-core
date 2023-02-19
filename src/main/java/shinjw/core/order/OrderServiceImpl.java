package shinjw.core.order;

import shinjw.core.discount.DiscountPolicy;
import shinjw.core.discount.FixDiscountPolicy;
import shinjw.core.member.Member;
import shinjw.core.member.MemberRepository;
import shinjw.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
