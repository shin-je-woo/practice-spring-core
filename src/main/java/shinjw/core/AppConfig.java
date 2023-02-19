package shinjw.core;


import shinjw.core.discount.RateDiscountPolicy;
import shinjw.core.member.MemberService;
import shinjw.core.member.MemberServiceImpl;
import shinjw.core.member.MemoryMemberRepository;
import shinjw.core.order.OrderService;
import shinjw.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
