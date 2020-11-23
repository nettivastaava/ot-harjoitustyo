## Tehtävägeneraattori

Sovelluksen avulla käyttäjien on mahdollista luoda omia sekä ratkoa muiden tekemiä tehtäväsarjoja.


### Dokumentaatio

[Vaatimusmäärittely](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/arkkitehtuuri.md)

### Komentorivitoiminnot

#### Käynnistys
- Sovellus käynnistetään komennolla: mvn compile exec:java -Dexec.mainClass=exercisegenerator.ui.ExerciseGeneratorUi

#### Testaus
- Testit suoritetaan komennolla: mvn test
- Testikattavuusraportti luodaan komennolla: mvn test jacoco:report
  
#### Checkstyle
- Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla: mvn jxr:jxr checkstyle:checkstyle


