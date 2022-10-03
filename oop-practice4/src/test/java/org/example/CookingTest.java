package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CookingTest {
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking(); //요리사
        MenuItem menuItem = new MenuItem("피자", 15000);

        Cook cook = cooking.makeCook(menuItem); // 메뉴 --> 요리사 --> 요리

        assertThat(cook).isEqualTo(new Cook("피자", 15000));
    }
}
