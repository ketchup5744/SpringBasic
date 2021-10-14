package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 기존 예제 코드를 살리기 위해 ComponentScan을 통해 기존 코드들을 무효화 시켜줌
@ComponentScan(
        // defalt 값은 @ComponentScan이 붙은 위치의 하위를 모두 탐색함
        // basePackages = "hello.core.member",
        // basePackageClasses = AutoAppConfig.class;
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
