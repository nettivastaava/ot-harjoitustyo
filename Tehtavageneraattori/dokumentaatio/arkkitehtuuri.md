# Arkkitehtuurikuvaus

## Käyttöliittymä

Käyttöliittymässä on kuusi erillistä näkymää:
  - kirjautuminen
  - rekisteröityminen
  - lista tehtäväsarjoista
  - uuden tehtäväsarjan luominen
  - tehtäväsarjan ratkaiseminen
  - pistenäkymä
  
Jokainen näkymä on toteutettu omana Scene-oliona, joka tarvittaessa sijoitetaan näytettäväksi sovelluksen stagelle. Itse käyttöliittymän koodi on eristetty luokkaan exercisegenerator.ui.ExerciseGeneratorUi.

## Sovelluslogiikka

Sovelluksen looginen datamalli muodostuu luokista User, ExerciseSet ja Question, jotka kuvaavat käyttäjiä, tehtäväsarjoja ja tehtäväsarjoihin kuuluvia kysymyksiä.

Sovelluslogiikka on sijoitettu pakkauksen exercisegenerator.domain sisälle. Pakkauksesta löytyvät luokat User, ExerciseSet, Question sekä ExerciseService, jonka vastuulla on suuri osa käyttöliittymän toiminnallisuudesta.

ExerciseServicellä on pääsy käyttäjien, tehtäväsarjojen ja kysymysten tietoihin Dao-luokkien avulla. 

## Tietojen pysyväistalletus

Pakkaukseen exercisegenerator.dao sijoitetut luokat FileUserDao ja FileExerciseSetDao ja FileQuestionDao huolehtivat tietojen tallentamisesta tiedostoihin. Rajapintojen UserDao, ExerciseSetDao ja QuestionDao taakse piilotetut luokat noudattavat Data Access Object -suunnittelumallia (DAO).

### Tiedostot

Sovellus tallentaa käyttäjien, tehtäväsarjojen ja kysymysten tiedot erillisiin tiedostoihin. Tiedostojen nimet määritellään sovelluksen juuressa sijaitsevassa tiedostossa config.properties.

## Luokka/pakkauskaavio

![Pakkauskaavio](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/pakkauskaavio.jpg)

### Ohjelman toiminnallisuutta sekvenssikaavioina

Alla olevassa kaaviossa kuvataan uuden käyttäjän luomiseen liittyvä toimintalogiikka. Kun rekisteröitymisnäkymässä on syötetty kenttiin uniikki ja vähintään 3 merkkiä pitkä käyttäjätunnus sekä vähintään 5 merkkiä pitkä salasana, klikataan painiketta registerButton. Sovelluslogiikka luo User-olion ja tarkistaa, ovatko olion nimimerkki ja salasana validit. Tämän jälkeen sovelluslogiikka selvittää userDao:n avulla onko käyttäjätunnus jo varattu. Koska vastaavaa nimimerkkiä ei löydy ja palautetaan null, tallettaa sovelluslogiikka User-olion kutsumalla UserDaon metodia create. Lopuksi vielä näkymä vaihdetaan kirjautumisnäkymään, loginSceneen.

![Sekvenssikaavio1](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/sekvenssikaavio1.jpg)

Seuraavassa kaaviossa kuvataan käyttäjän kirjautumisen toimintalogiikka. Kirjautumisnäkymässä käyttäjänimen syötekenttään on kirjoitettu "Heimo" ja salasanan kenttään "kissa". Kun klikataan painiketta loginButton, kutsuu painikkeelle rekisteröity tapahtumankäsittelijä sovelluslogiikan ExerciseService metodia login parametreilla "Heimo" ja "kissa". UserDaon metodi findByUsernameAndPassword tarkastaa, onko järjestelmässä käyttäjää "Heimo" ja onko annettu salasana oikea. Mikäli kirjautuminen onnistuu, vaihtaa käyttöliittymä näkymäksi sovelluksen päänäkymän, exercisesScenen.

![Sekvenssikaavio2](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/sekvenssikaavio2.jpg)

### Ohjelman rakenteeseen jääneet heikkoudet

Sovelluksessa on kuusi näkymää, jotka kaikki rakennetaan samassa luokassa ExerciseGeneratorUi, mikä onkin paisunut useamman sadan rivin pituiseksi. Selkeyden ja jatkokehityksen kannalta olisi parempi, mikäli nämä näkymät olisi toteutettu omissa luokissaan.

FileDao-toteutuksissa tiedostosta lukeminen tapahtuu useammassa luokassa mikä on vastoin materiaalin suositusta. Itse tiedostoista lukeminen tapahtuu kussakin FileDao-luokassa kuitenkin melko yksilöllisesti, joten toiminnallisuudet vaatisivat joka tapauksessa useamman metodin.
