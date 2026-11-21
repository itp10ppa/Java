@Default(String.class)
@ToString
@Validate({String.class, Integer.class, Double.class})
@Two(first = "Hello!", second = 8)
@Cache({"a", "b", "c", "d"})
public class Example {

    @Default(Integer.class)
    public int value;
    public int age;
    @ToString(Mode.NO)
    public int password;

    public Example(int age, int password) {
        this.age = age;
        this.password = password;
    }

    @Invoke
    public void first() {
        System.out.println("Метод 1: с аннотацией Invoke");
    }

    public void second() {
        System.out.println("Метод 2: без аннотации");
    }

    @Invoke
    public void third() {
        System.out.println("Метод 3: с аннотацией Invoke");
    }
}
