package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
       /* AppConfig appConfig = new AppConfig();
        MemberService ms = appConfig.memberService();
        OrderService os = appConfig.orderService();*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService ms = applicationContext.getBean("memberService", MemberService.class);
        OrderService os = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        ms.join(member);

        Order order = os.crateOrder(memberId, "Apple", 4500);
        System.out.println("Order:: " + order.toString());
        System.out.println("CalPrice :: " + order.calPrice());

    }

}
