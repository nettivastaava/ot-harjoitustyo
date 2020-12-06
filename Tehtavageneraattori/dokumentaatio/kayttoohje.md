## Käyttöohje

### Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto config.properties, joka määrittelee käyttäjät, tehtäväsarjat ja kysymykset tallettavien tiedostojen nimet. Tiedoston sisältö on seuraava
  userFile=users.txt
  exerciseFile=exercises.txt
  questionFile=questions.txt
  
### Ohjelman käynnistäminen

Ohjelma käynnistyy komennolla
  java -jar exerciseapp.jar
  
### Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään:

![login](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/login.jpg)

Kirjautumaan pääsee kirjoittamalla järjestelmään tallennettu käyttäjätunnus ja sille kuuluva salasana näkymän kenttiin ja painamalla login-nappulaa.

### Rekisteröityminen

Uuden käyttäjän luominen onnistuu rekisteröitymisnäkymässä, johon pääsee kirjautumisnäkymän painikkeella "create a new user".

![register](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/register.jpg)
