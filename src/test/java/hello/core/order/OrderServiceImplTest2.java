package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest2 {

    @Test
    void createOrder() {

        MemoryMemberRepository me = new MemoryMemberRepository();
        me.save(new Member(1L, "itemA", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(me, new RateDiscountPolicy());
        Order order = orderService.crateOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}