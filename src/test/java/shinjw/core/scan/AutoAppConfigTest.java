package shinjw.core.scan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shinjw.core.AutoAppConfig;
import shinjw.core.member.Grade;
import shinjw.core.member.Member;
import shinjw.core.member.MemberService;
import shinjw.core.order.Order;
import shinjw.core.order.OrderService;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {


    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);


    }

    @Test
    void myTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object=" + bean);
            }
        }

        Member userA = new Member(1L, "userA", Grade.VIP);
        memberService.join(userA);
        Order itemA = orderService.createOrder(userA.getId(), "itemA", 20000);

        // DiscountPolicy의 구현체 2개(Fix, Rate)중 Rate만 @Component 등록. OrderServiceImpl에는 Autowired설정 X
        assertThat(itemA.getDiscountPrice()).isEqualTo(2000);
    }
}
