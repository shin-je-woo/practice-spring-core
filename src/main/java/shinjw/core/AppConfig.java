package shinjw.core;


import shinjw.core.discount.DiscountPolicy;
import shinjw.core.discount.FixDiscountPolicy;
import shinjw.core.discount.RateDiscountPolicy;
import shinjw.core.member.MemberRepository;
import shinjw.core.member.MemberService;
import shinjw.core.member.MemberServiceImpl;
import shinjw.core.member.MemoryMemberRepository;
import shinjw.core.order.OrderService;
import shinjw.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }
}
