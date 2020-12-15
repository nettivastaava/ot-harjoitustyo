# Testausdokumentti

### Yksikkö- ja integraatiotestaus

#### Sovelluslogiikka

Käyttöliittymän ExerciseService-olion toiminnallisuuksia testaavat integraatiotestit on toteuttu luokissa ExerciseServiceUserTest, jossa testataan kirjautumisesta ja rekisteröitymisestä huolehtivat toiminnallisuudet sekä ExerciseServiceExerciseTest, jossa taas testataan tehtäväsarjojen luomisesta huolehtivia toiminnallisuuksia.

Integraatiotesteissä käytetään tiedon pysyväistallennukseen DAO-rajapintojen keskusmuistitoteutuksia FakeUserDao, FakeExerciseSetDao ja FakeQuestionDao.

Sovelluslogiikan luokille User, ExerciseSet ja Question on tehty myös omia yksikkötestejä.

#### Dao-luokat

Kaikki DAO-luokat on testattu luomalla testeissä tilapäinen tiedosto JUnit-kirjaston TemporaryFolder-rulejen avulla.

Ohjelmaa varten on toteutettu automatisoituja yksikkö- ja integraatiotestejä JUnitilla. Tämän lisäksi ohjelmaa on testattu manuaalisesti järjestelmätasolla.

### Testauskattavuus
Sovelluksen testauksen rivi- ja haaraumakattavuudet ovat 91%. Käyttöliittymän rakentava koodi on jätetty pois tarkastelusta.

![jacoco_report](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/jacocoreport.jpg)

#### Toiminnallisuudet

Kaikki määrittelydokumentin ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Toiminnallisuuksia on myös testattu antamalla syötekentille virheellisiä arvoja, kuten tyhjiä tai puolipisteen sisältäviä merkkijonoja.

### Sovellukseen jääneet laatuongelmat

Käyttäjätunnuksen luominen ja kirjautumisen edellyttäminen ohjelman käyttämistä varten tuntuvat hieman turhilta, sillä kaikki käyttäjät voivat rajoituksitta ratkoa omia ja muiden luomia tehtäväsarjoja. Toiminnallisuus on kuitenkin todella hyödyllinen jatkokehityksen kannalta olettaen, että pyritään toteuttamaan määrittelydokumentissa esitetyt jatkokehitysideat.

