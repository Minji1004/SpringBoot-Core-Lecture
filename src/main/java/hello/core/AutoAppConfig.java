package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//AppConfig는 제외했따. AppConfig에 @Configuration에 @Component가 있어 @componentScan에 잡히니, Filter로 빼줘야 한다.
//실무에서 일반적으로 제외하지 않는다. 기존 예제 코드들 남기기 위해서 필터를 사용해 제외헀다.
@ComponentScan(
        //basePackages = "hello.core.member", //탐색 시작 위치 지정.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
