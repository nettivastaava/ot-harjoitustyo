## Käyttöohje

Lataa tiedosto [exerciseapplication.jar](https://github.com/nettivastaava/ot-harjoitustyo/releases/tag/loppupalautus)

### Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto config.properties, joka määrittelee käyttäjät, tehtäväsarjat ja kysymykset tallettavien tiedostojen nimet. Tiedoston sisältö on seuraava
  userFile=users.txt
  exerciseFile=exercises.txt
  questionFile=questions.txt
  
### Ohjelman käynnistäminen

Ohjelma käynnistyy komennolla
  java -jar ./target/exercisegenerator.jar
  
### Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään:

![login](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/login.jpg)

Kirjautumaan pääsee kirjoittamalla järjestelmään tallennettu käyttäjätunnus ja sille kuuluva salasana näkymän kenttiin ja painamalla login-painiketta.

### Rekisteröityminen

Uuden käyttäjän luominen onnistuu rekisteröitymisnäkymässä, johon pääsee kirjautumisnäkymän painikkeella "create a new user". Rekisteröitymisen peruuttaminen tapahtuu cancel-painikkeella, joka vie takaisin kirjautumisnäkymään.

![register](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/register.jpg)

Mikäli rekisteröityminen onnistuu, palataan kirjautumisnäkymään.

### Tehtäväsarjan luominen ja ratkominen

Onnistuneen kirjautumisen myötä siirrytään järjestelmään tallennetut tehtäväsarjat listaavaan näkymään, joka myös toimii sovelluksen päänäkymänä. Näkymästä on mahdollisuus siirtyä ratkomaan tehtäväsarjoja painikkeella solve sekä luomaan uutta tehtäväsarjaa painikkeella create new. Uloskirjautuminen tapahtuu päänäkymästä painikkeella log out.

![main](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/main.jpg)

Uuden tehtäväsarjan luomisessa käytettävä lomake kuvattu alla. Tehtäväsarjaan lisätään kysymys täyttämällä lomakkeen kenttiin kysymys ja vastaus minkä jälkeen klikataan add-painiketta. Vihjeen lisääminen kysymykselle ei ole välttämätöntä. Tehtäväsarjaan on lisättävä vähintään 4 ja enintään 8 kysymystä, jonka jälkeen sarjalle annetaan nimi ja painetaan create-painiketta. Mikäli käyttäjä ei haluakaan luoda uutta tehtäväsarjaa, pääsee cancel-painikkeella palaamaan päänäkymään, jolloin tehtäväsarjan luominen keskeytetään.

![createEx](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/createEx.jpg)

Sarjan luomisen jälkeen siirrytään takaisin päänäkymään. Kun nyt painetaan solve-painiketta luodun tehtäväsarjan kohdalla, avautuu vastauslomake, joka näyttää sarjan kysymykset luettelona. Kysymykseen mahdollisesti liittyvä vihje voidaan pyytää näytettäväksi painamalla Hint-painiketta.

![solvingEx1](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/solving1.jpg)

Kysymykseen vastataan kirjoittamalla vastaus kysymyksen alla olevaan syötekenttään ja painamalla answer-painiketta. Vastauksen palaute ilmestyy näkyville syötekentän yläpuolelle. Kun käyttäjä on valmis sarjan ratkomisessa, painetaan kysymysluettelon lopusta löytyvää painiketta finished.

![solvingEx2](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/solving2.jpg)

Tämän jälkeen avautuu pistenäkymä, josta käyttäjä näkee oikeiden vastaustensa lukumäärän. Mikäli käyttäjä jätti vastaamatta osaan kysymyksistä tai vastasi väärin, on mahdollista pyytää näytettäväksi oikeat vastaukset näihin kysymyksiin painikkeella show correct answers. Painike return to main menu vie käyttäjän takaisin päänäkymään.

![finished](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/finished1.jpg)


