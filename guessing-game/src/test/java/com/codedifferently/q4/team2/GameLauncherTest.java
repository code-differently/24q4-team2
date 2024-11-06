package com.codedifferently.q4.team2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.WHEN_AVAILABLE)
class GameLauncherTest {

    @Test
    void testMain() {
        assertThat(new GameLauncherTest()).isNotNull();
    }
}
