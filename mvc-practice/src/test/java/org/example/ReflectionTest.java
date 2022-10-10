package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        logger.debug("beans : [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> userClass = User.class;

        logger.debug(userClass.getName());
        logger.debug("User all declared fields : [{}]",
                Arrays.stream(userClass.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors : [{}]",
                Arrays.stream(userClass.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods : [{}]",
                Arrays.stream(userClass.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void load() throws ClassNotFoundException {
        // 힙 영역에 로드돼있는 클래스 타입의 객체를 가지고 오는 방법 3가지

        // 1.
        Class<User> userClass1 = User.class;

        // 2.
        User user = new User("dlawnsdh", "임준오");
        Class<? extends User> userClass2 = user.getClass();

        // 3.
        Class<?> userClass3 = Class.forName("org.example.model.User");

        logger.debug("userClass1 : [{}]", userClass1);
        logger.debug("userClass2 : [{}]", userClass2);
        logger.debug("userClass3 : [{}]", userClass3);

        assertThat(userClass1 == userClass2).isTrue();
        assertThat(userClass2 == userClass3).isTrue();
        assertThat(userClass1 == userClass3).isTrue();
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");
        // org.example 의 하위 폴더에 있는 모든 클래스들을 reflections 에 담는다. (접근 제어자 상관 X)

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        // 클래스 셋에 해당 어노테이션이 붙은 클래스만을 셋에 넣는다. (매개변수에 따라 달라짐)

        return beans;
    }
}
