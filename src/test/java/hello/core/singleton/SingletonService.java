package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자를 통해 다른 곳에서 인스턴스화 시지키 않게 막는다.
    private SingletonService() {}
    
    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }
    
}
