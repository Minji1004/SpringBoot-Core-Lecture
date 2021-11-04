package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredOption {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        //@Autowired(required=false). 주입 대상 없으면 수정자 메서드 자체가 호출 안됨
        //@Nullable: 자동 주입할 대상 없음녀 null이 입력
        //Optional: Null처리할 때 쓰이는데, 대상 없으면 Optional.empty가 입력됨
        //Member는 스프링 빈이 아님.

        //nullable과 Optional는 생성자 주입의 특정 필드에서도 사용할 수 있다.


        //기본은 true. true일 떄 없으면 unsatisfiedDefinition 에러 남.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1); //이 메서드 자체가 호출이 아예 안됨.
        }

        //의존관계 주입 대상 없으면 null로
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2); //호출 되는 데 null
        }

        //의존관계 주입 대상 없으면 Optional.empty로.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);  //호출 되는 데 Optional.empty.
        }

    }


}
