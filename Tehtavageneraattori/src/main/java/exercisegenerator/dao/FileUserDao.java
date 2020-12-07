
package exercisegenerator.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import exercisegenerator.domain.User;

/**
* Käyttäjien pysyväistalletuksesta huolehtiva luokka
*/
public class FileUserDao implements UserDao {
    private List<User> users;
    private String file;

    /**
    * Lisää käyttäjän listalle  ja kutsuu save()-metodia
    */
    public FileUserDao(String file) throws Exception {
        users = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0], parts[1]);
                users.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
    }
    
    /**
    * Kirjoittaa luodun käyttäjän tunnuksen ja salasanan tiedostoon erotettuna ;-merkillä
    */
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (User user : users) {
                writer.write(user.getUsername() + ";" + user.getPassword() + "\n");
            }
        } 
    }
    
    /**
    * Palauttaa kaikki järjestelmään tallennetut käyttäjät
    */
    @Override
    public List<User> getAll() {
        return users;
    }
    
    /**
    * Etsii ja palauttaa järjestelmästä käyttäjän käyttäjänimen perusteella
    * 
    * @param username käyttäjän nimeä vastaava merkkijono
    * 
    * @return Löydetty käyttäjäolio tai null, mikäli käyttäjää ei löytynyt
    */
    @Override
    public User findByUsername(String username) {
        return users.stream()
            .filter(u->u.getUsername()
            .equals(username))
            .findFirst()
            .orElse(null);
    }
    
    /**
    * Lisää käyttäjän listalle  ja kutsuu save()-metodia
    * 
    * @param user listalle lisättävä käyttäjäolio
    * 
    * @return parametrina annettu käyttäjäolio
    */
    @Override
    public User create(User user) throws Exception {
        users.add(user);
        save();
        return user;
    }

    /**
    * Etsii ja palauttaa järjestelmästä käyttäjän käyttäjänimen ja salasanan perusteella
    */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        for (User u: users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
