package hello.core;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter  //필드의 get 메서드 생성
@Setter  // 필드의 set 메서드 생성
@NoArgsConstructor //파라미터 없는 기본 생성자 완성
@ToString // 필드 정보를 보여주는 toString 메서드 완성
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfs");

        String name = helloLombok.getName();
        System.out.println("name = " + name );

        System.out.println("helloLombok = " + helloLombok);
    }

}
