## Luokka/pakkauskaavio

![Pakkauskaavio](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/pakkauskaavio.jpg)

### Ohjelman toiminnallisuutta sekvenssikaavioina

Seuraavassa kaaviossa kuvataan käyttäjän kirjautumisen toimintalogiikka. Kirjautumisnäkymässä käyttäjänimen syötekenttään on kirjoitettu "Heimo" ja salasanan kenttään "kissa". Kun klikataan painiketta loginButton, kutsuu painikkeelle rekisteröity tapahtumankäsittelijä sovelluslogiikan ExerciseService metodia login parametreilla "Heimo" ja "kissa". UserDaon metodi findByUsernameAndPassword tarkastaa, onko järjestelmässä käyttäjää "Heimo" ja onko annettu salasana oikea. Mikäli kirjautuminen onnistuu, vaihtaa käyttöliittymä näkymäksi sovelluksen päänäkymän, exercisesScenen.

![Sekvenssikaavio1](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/sekvenssikaavio1.jpg)

