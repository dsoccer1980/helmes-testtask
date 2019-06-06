package com.dsoccer1980.services;

import com.dsoccer1980.domain.UserData;
import com.dsoccer1980.service.UserDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static com.dsoccer1980.domain.UserData.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserDataServiceTest {

    public static final int USERDATA_ID = START_SEQ;

    @Autowired
    private UserDataService userDataService;

    @Test
    void findAll() {
        UserData data1 = new UserData(USERDATA_ID, "data1", true, "1,4");
        UserData data2 = new UserData(USERDATA_ID + 1, "data2", true, "2,5");
        userDataService.save(data1);
        userDataService.save(data2);

        assertThat(userDataService.getAll()).isEqualTo(Arrays.asList(data1, data2));

    }
}
