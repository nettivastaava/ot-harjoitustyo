
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
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        
        User user2 = (User) obj;
        return this.username.equals(user2.getUsername());
    } 
    
}
