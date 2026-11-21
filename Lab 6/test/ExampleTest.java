import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class ExampleTest {

    @Cache
    static class EmptyCacheClass {}

    private boolean mockCacheEngine(Class<?> clazz) {
        Cache cache = clazz.getAnnotation(Cache.class);
        if (cache != null) {
            return cache.value().length > 0;
        }
        return false;
    }

    @Test
    void shouldContainAllowedFields() throws Exception {
        Example example = new Example(20, 123);
        String result = Main.task13(Example.class, example);

        Assertions.assertTrue(result.contains("age=20"), "Должно быть поле age");
        Assertions.assertTrue(result.contains("value="), "Должно быть поле value");
    }

    @Test
    void shouldNotContainForbiddenFields() throws Exception {
        Example example = new Example(20, 123);
        String result = Main.task13(Example.class, example);

        Assertions.assertFalse(result.contains("password"), "Не должно быть поля password");
        Assertions.assertFalse(result.contains("123"), "Не должно быть значения пароля");
    }

    @Test
    void shouldReadCacheValue() {
        Cache cache = Example.class.getAnnotation(Cache.class);

        Assertions.assertNotNull(cache, "Аннотация @Cache должна быть на классе Example");
        Assertions.assertTrue(cache.value().length > 0, "Массив не должен быть пустым");
    }

    @Test
    void shouldNotCacheWhenArrayIsEmpty() {
        boolean isCaching = mockCacheEngine(EmptyCacheClass.class);
        Assertions.assertFalse(isCaching, "Кеширование не должно работать, если массив пуст");
    }

    @Test
    void shouldCacheWhenMultipleAreasExist() {
        boolean isCaching = mockCacheEngine(Example.class);
        Assertions.assertTrue(isCaching, "Кеширование должно работать для Example");

        Cache cache = Example.class.getAnnotation(Cache.class);
        String[] areas = cache.value();

        Assertions.assertTrue(areas.length > 1, "Должно быть несколько областей");
        Assertions.assertTrue(Arrays.asList(areas).contains("a"), "Должна быть область 'a'");
    }
}
