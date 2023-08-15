package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    MemberService ms;
    OrderService os;

    @BeforeEach
    public void beforeEach() {
        AppConfig app = new AppConfig();
        ms = app.memberService();
        os = app.orderService();
    }

    @Test
    void 주문생성() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        ms.join(member);
        Order order = os.crateOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}