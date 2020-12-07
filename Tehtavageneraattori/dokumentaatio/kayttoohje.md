## Käyttöohje

Lataa tiedosto [exercisegenerator.app](https://github.com/nettivastaava/ot-harjoitustyo/releases/tag/viikko6)

### Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto config.properties, joka määrittelee käyttäjät, tehtäväsarjat ja kysymykset tallettavien tiedostojen nimet. Tiedoston sisältö on seuraava
  userFile=users.txt
  exerciseFile=exercises.txt
  questionFile=questions.txt
  
### Ohjelman käynnistäminen

Ohjelma käynnistyy komennolla
  java -jar exercisegenerator.jar
  
### Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään:

![login](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/login.jpg)

Kirjautumaan pääsee kirjoittamalla järjestelmään tallennettu käyttäjätunnus ja sille kuuluva salasana näkymän kenttiin ja painamalla login-painiketta.

### Rekisteröityminen

Uuden käyttäjän luominen onnistuu rekisteröitymisnäkymässä, johon pääsee kirjautumisnäkymän painikkeella "create a new user".

![register](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/register.jpg)

Mikäli rekisteröityminen onnistuu, palataan kirjautumisnäkymään.

### Tehtäväsarjan luominen

Onnistuneen kirjautumisen myötä siirrytään järjestelmään tallennetut tehtäväsarjat listaavaan näkymään, joka myös toimii sovelluksen päänäkymänä. Näkymästä on mahdollisuus siirtyä ratkomaan tehtäväsarjoja painikkeella done sekä luomaan uutta tehtäväsarjaa painikkeella create new.

![main](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/main.jpg)

Uuden tehtäväsarjan luomisessa käytettävä lomake kuvattu alla. Tehtäväsarjaan lisätään kysymys täyttämällä lomakkeen kenttiin kysymys ja vastaus minkä jälkeen klikataan add-painiketta. Vihjeen lisääminen kysymykselle ei ole välttämätöntä. Tehtäväsarjaan on lisättävä vähintään 4 ja enintään 8 kysymystä, jonka jälkeen sarjalle annetaan nimi ja painetaan create-painiketta.

![createEx](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/createEx.jpg)
