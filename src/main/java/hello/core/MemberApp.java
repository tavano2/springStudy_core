package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig();
        // MemberService ms = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService ms = applicationContext.getBean("memberService", MemberService.class);

        MemberService ms2 = new MemberServiceImpl(new MemoryMemberRepository());

        Member member = new Member(1L, "memberA", Grade.VIP);
        ms.join(member);

        Member findeMember = ms.findMember(1L);
        System.out.println("findMember = " + member.getName());
        System.out.println("find Member = " + findeMember.getName());
    }
}
