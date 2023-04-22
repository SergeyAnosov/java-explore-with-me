package ru.practicum.model.event;

public enum UserStatusEvent {

    SEND_TO_REVIEW, //отправить на повторную модерацию PENDING
    CANCEL_REVIEW //закрыт пользователем
}
