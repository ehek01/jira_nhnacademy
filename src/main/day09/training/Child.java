package day09.training;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Inherited
@Target(TYPE)
@Retention(CLASS)
@interface Legacy {
}

@Target(TYPE)
@Retention(RUNTIME)
@interface Hobby {
}

// @Legacy 존재하지 않지만 존재한다고 인식
public class Child extends Parent {
    public static void main(String[] args) {
        System.out.println("Parent has @Legacy?: " + hasLegacy(Parent.class));
        System.out.println("Child has @Legacy?: " + hasLegacy(Child.class));

        System.out.println("Parent has @Hobby?: " + hasHobby(Parent.class));
        System.out.println("Child has @Hobby?: " + hasHobby(Child.class));
    }

    private static boolean hasLegacy(Class<?> clazz) {
        return clazz.isAnnotationPresent(Legacy.class);
    }

    private static boolean hasHobby(Class<?> clazz) {
        return clazz.isAnnotationPresent(Hobby.class);
    }
}

@Hobby
@Legacy
class Parent {
}
