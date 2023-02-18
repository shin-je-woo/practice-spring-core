package shinjw.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 생성자를 private으로 선언하여 외부에서 생성자 호출을 못하게 함
    private SingletonService(){}

    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체입니다.");
    }

}
