package converter;

import converter.model.User;
import converter.model.UserDto;

public class Main {
    public static void main(String[] args) {
        UserConvert userConvert = new UserConvert();

        UserDto userDto = new UserDto(1001,"zs",22,"1498742107@qq.com", true);

        User user = userConvert.convertFromDto(userDto);
        System.out.println(user);
    }
}
