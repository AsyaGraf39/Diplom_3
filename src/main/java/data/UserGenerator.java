package data;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public String getName(){
        return "Ася";
    }
    public String getRandomEmail() {
        String email = RandomStringUtils.randomAlphanumeric(8) + "@mail.ru";
        return email;
    }

    public String getDefaultEmail(){
        return "krosh111@inbox.ru";
    }

    public String getPassword() {
        return "111888";
    }

    public String getWrongPassword() {
        return "111";
    }


}
