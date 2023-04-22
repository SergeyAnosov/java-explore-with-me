package ru.practicum.model.user.service;

import ru.practicum.model.user.dto.UserDto;

import java.util.List;

public interface AdmUserService {

    UserDto createUser(UserDto userDto);

    void deleteUser(Long userId);

    List<UserDto> getUsersByIds(List<Long> ids, Integer from, Integer size);
}
