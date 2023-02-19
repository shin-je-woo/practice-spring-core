package shinjw.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shinjw.core.member.Grade;
import shinjw.core.member.Member;
import shinjw.core.member.MemberService;
import shinjw.core.member.MemberServiceImpl;
import shinjw.core.order.Order;
import shinjw.core.order.OrderService;
import shinjw.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order orderA = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("orderA = " + orderA);
        System.out.println("orderA = " + orderA.calculatePrice());
    }

}
