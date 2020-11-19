
package exercisegenerator.domain;

import java.util.Objects;


public class User {
    private String username;
    private String password;

    
    public User(String username, String password) {
        if (username.length() < 3 || password.length() < 5) {
            this.username = null;
        } else {
            this.username = username;
            this.password = password;
        }

    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    } 
    
}
