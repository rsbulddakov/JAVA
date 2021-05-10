package GU.Java.chat.server;

public class AuthenticationService {
    private final UserRepository repository;

    public AuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    public User findEntryByCredentials(String login, String password) {
        return repository.getAuth(login, password)
                .orElseThrow(
                        () -> new RuntimeException("Invalid login or password for " + login)
                );
    }

    public static class Entry {
        private int id;
        private String name;
        private String login;
        private String password;

        public Entry(int id, String name, String login, String password) {
            this.id = id;
            this.name = name;
            this.login = login;
            this.password = password;
        }

        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getLogin() {
            return login;
        }
        public String getPassword() {
            return password;
        }
    }
}
