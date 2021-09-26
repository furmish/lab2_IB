public interface Password {
    String SET_PASSWORD = "Задайте пароль";
    String ENTER_PASSWORD = "Введите пароль";
    String INCORRECT_PASSWORD_WITH_ATTEMPTS = "Пароль неверный! Осталось %d попыток.\n";
    String INCORRECT_PASSWORD_SUPPORT = "Пароль неверный! Попыток больше нет, но вы держитесь!";
    String WELCOME_WITH_PASSWORD = "Добро пожаловать, @username, содержимое файла:\n----------------------------------------------";
    String CONTENT = "Содержимое файла:\n";
    int NUMBER_OF_ATTEMPTS = 3;
    void setNewPassword();
    boolean isCorrectPassword();
}