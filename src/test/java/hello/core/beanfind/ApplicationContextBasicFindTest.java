package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

       // Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

           System.out.println("memberService = " + memberService);
           System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanType() {
        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        //   System.out.println("memberService = " + memberService);
        //   System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        //타입은 꼭 Interface가 아닌 구현체 타입으로 적어도 된다.
        //But 구현체로 적는 건 안좋다. 역할과 구현은 구분해야하고 역할에 의존해야 한다.
        //따라서 별로 좋은 코드는 아니다.
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        //   System.out.println("memberService = " + memberService);
        //   System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        //ac.getBean("XXXXX", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxx", MemberService.class));
    }
}
