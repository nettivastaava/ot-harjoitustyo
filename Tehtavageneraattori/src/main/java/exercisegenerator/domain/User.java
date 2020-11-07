/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.domain;

import java.util.Objects;

/**
 *
 * @author vaxandst
 */
public class User {
    private String username;

    
    public User(String username) {
        this.username=username;

    }

    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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

        return true;
    }
    
    
    
}
