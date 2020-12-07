## Tehtävägeneraattori

Sovelluksen avulla käyttäjien on mahdollista luoda omia sekä ratkoa muiden tekemiä tehtäväsarjoja.


### Dokumentaatio

[Käyttöohje](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/arkkitehtuuri.md)

### Releaset

[Viikko 5](https://github.com/nettivastaava/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/nettivastaava/ot-harjoitustyo/releases/tag/viikko6)

### Komentorivitoiminnot

#### Käynnistys
- Sovellus käynnistetään komennolla: mvn compile exec:java -Dexec.mainClass=exercisegenerator.ui.ExerciseGeneratorUi

#### Testaus
- Testit suoritetaan komennolla: mvn test
- Testikattavuusraportti luodaan komennolla: mvn test jacoco:report
  
#### Checkstyle
- Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla: mvn jxr:jxr checkstyle:checkstyle

#### Suoritettavan jarin generointi
- Hakemistoon target generoidaan suoritettava jar-tiedosto Tehtavageneraattori-1.0-SNAPSHOT.jar komennolla: mvn package


