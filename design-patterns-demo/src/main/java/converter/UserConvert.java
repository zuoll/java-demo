package converter;

import converter.model.User;
import converter.model.UserDto;

public class UserConvert extends Converter<UserDto, User> {

    public UserConvert() {
        super(UserConvert::convertToUser, UserConvert::convertToDto);
    }

    public static UserDto convertToDto(User user) {
        return UserDto.builder().id(user.getId()).name(user.getName()).age(user.getAge()).build();
    }

    public static User convertToUser(UserDto userDto) {
        return User.builder().id(userDto.getId()).name(userDto.getName()).age(userDto.getAge()).build();
    }
}
