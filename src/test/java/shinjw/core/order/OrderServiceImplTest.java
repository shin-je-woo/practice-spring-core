package shinjw.core.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shinjw.core.discount.RateDiscountPolicy;
import shinjw.core.member.Grade;
import shinjw.core.member.Member;
import shinjw.core.member.MemoryMemberRepository;

class OrderServiceImplTest {

    @Test
    @DisplayName("생성자주입을 사용하면 순수자바코드로 테스트를 작성할 수 있다.")
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "userA", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }

}