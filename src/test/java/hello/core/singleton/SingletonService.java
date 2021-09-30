package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 내부의 private static 으로 가지고 있으면 클래스 레벨에 올라가기 때문에 딱 하나만 가지고 있음. (자바 기초)
    // 자기 자신을 생성해서 참조 값을 가지고 있는 것.

    public static SingletonService getInstance() {
        // public으로 열어서 이 객체의 인스턴스가 필요하면 오직 이 메소드를 통해서만 조회할 수 있음.
        // 호출될 시 항상 같은 인스턴스(참조값)가 반환됨.
        return instance;
    }

    private SingletonService() {
        // private 으로 생성자를 만들어 줌.
        // 다른 곳에서 new 가 불가능해짐.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
