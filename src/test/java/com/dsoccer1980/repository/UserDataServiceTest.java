package com.dsoccer1980.repository;

import com.dsoccer1980.domain.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static com.dsoccer1980.domain.UserData.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserDataServiceTest {

    public static final int USERDATA_ID = START_SEQ;

    @Autowired
    UserDataRepository repository;

    @Test
    void findAll() {
        UserData data1 = new UserData(USERDATA_ID, "data1", true, "1,4");
        UserData data2 = new UserData(USERDATA_ID + 1, "data2", true, "2,5");
        repository.save(data1);
        repository.save(data2);

        assertThat(repository.findAll()).isEqualTo(Arrays.asList(data1, data2));


    }
}
