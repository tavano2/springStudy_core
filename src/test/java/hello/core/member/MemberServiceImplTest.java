package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService ms;

    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        ms = config.memberService();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        ms.join(member);
        Member findMember = ms.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void 회원조회() {



    }
}