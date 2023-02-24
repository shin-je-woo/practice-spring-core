package shinjw.core.discount;

import org.springframework.stereotype.Component;
import shinjw.core.annotation.MainDiscountPolicy;
import shinjw.core.member.Grade;
import shinjw.core.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return price * discountPercent / 100;
        return 0;
    }
}
