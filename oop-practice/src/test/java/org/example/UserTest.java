package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("비밀번호 초기화")
    @Test
    void passwordTest() {
        // given
        User user = new User();

        // when
        //user.initPassword(new CorrectFixedPasswordGenerator());
        user.initPassword(() -> "abcdeggh");

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("비밀번호가 요구사항에 부합하지 않아 초기화되지 않음")
    @Test
    void passwordTest2() {
        // given
        User user = new User();

        // when
        //user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(() -> "abcd");

        //then
        assertThat(user.getPassword()).isNull();
    }
}