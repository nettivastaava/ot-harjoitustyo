
package exercisegenerator.domain;

import java.util.Objects;

/**
* Järjestelmän käyttäjää edustava luokka
* 
*/
public class User {
    private String username;
    private String password;

    
    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
    
     /**
     * Metodi tarkastaa, että käyttäjän antamat käyttäjätunnus sekä salasana
     * ovat vaaditun pituiset ja palauttaa true, mikäli ovat ja false jos eivät
     * ole.
     * 
     * @return Vastauksen palaute.
     */
    public boolean isValid() {
        if (this.username.length() < 3 || this.password.length() < 5) {
            return false;
        } else {
            return true;
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
