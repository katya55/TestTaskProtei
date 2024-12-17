public class User {
    public String login;
    public String password;
    public Boolean isCorrect;

    public User(String login, String password, Boolean isCorrect) {
        this.login = login;
        this.password = password;
        this.isCorrect = isCorrect;
    }
//Массив объектов, для того, чтобы проверить различные комбинации логина/пароля в форме авторизации, в классе TestOne
    public static User[] getUsers() {

        User[] users = new User[5];
        users[0] = new User("test@protei.ru", "test", true);
        users[1] = new User("t@protei.ru", "test", false);
        users[2] = new User("test@protei.ru", "t", false);
        users[3] = new User("t@protei.ru", "t", false);
        users[4] = new User("", "", false);
        return users;
    }
}
