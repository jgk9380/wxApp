package test;

public interface Interface1 {
    static String hello(){
        return "hello";
    }
    default String getHello(String name){
        return "hello"+":"+name;
    }
}
