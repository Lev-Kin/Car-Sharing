import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly
    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();
        String encryptPassword = String.valueOf(encrypt(password));
        oos.writeObject(encryptPassword);
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        password = String.valueOf(decrypt((String) ois.readObject()));
    }

    private StringBuilder encrypt(String password) {
        char[] charPassword = password.toCharArray();
        StringBuilder passwordCrypt = new StringBuilder();
        for (int i = 0; i < charPassword.length; i++) {
            charPassword[i] = (char) (charPassword[i] + 1);
            passwordCrypt.append(charPassword[i]);
        }
        return passwordCrypt;
    }

    private StringBuilder decrypt(String password) {
        char[] charPassword = password.toCharArray();
        StringBuilder passwordDecrypted = new StringBuilder();
        for (int i = 0; i < charPassword.length; i++) {
            charPassword[i] = (char) (charPassword[i] - 1);
            passwordDecrypted.append(charPassword[i]);
        }
        return passwordDecrypted;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}