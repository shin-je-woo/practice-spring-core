package shinjw.core;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shinjw.core.discount.DiscountPolicy;
import shinjw.core.discount.FixDiscountPolicy;
import shinjw.core.discount.RateDiscountPolicy;
import shinjw.core.member.MemberRepository;
import shinjw.core.member.MemberService;
import shinjw.core.member.MemberServiceImpl;
import shinjw.core.member.MemoryMemberRepository;
import shinjw.core.order.OrderService;
import shinjw.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }
}
