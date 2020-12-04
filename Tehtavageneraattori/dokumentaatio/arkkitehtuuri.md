## Luokka/pakkauskaavio

![Pakkauskaavio](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/pakkauskaavio.jpg)

### Ohjelman toiminnallisuutta sekvenssikaavioina

Alla olevassa kaaviossa kuvataan uuden käyttäjän luomiseen liittyvä toimintalogiikka. Kun rekisteröitymisnäkymässä on syötetty kenttiin uniikki ja vähintään 3 merkkiä pitkä käyttäjätunnus sekä vähintään 5 merkkiä pitkä salasana, klikataan painiketta registerButton. Sovelluslogiikka luo User-olion ja tarkistaa, ovatko olion nimimerkki ja salasana validit. Tämän jälkeen sovelluslogiikka selvittää userDao:n avulla onko käyttäjätunnus jo varattu. Koska vastaavaa nimimerkkiä ei löydy ja palautetaan null, tallettaa sovelluslogiikka User-olion kutsumalla UserDaon metodia create. Lopuksi vielä näkymä vaihdetaan kirjautumisnäkymään, loginSceneen.

![Sekvenssikaavio1](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/sekvenssikaavio1.jpg)

Seuraavassa kaaviossa kuvataan käyttäjän kirjautumisen toimintalogiikka. Kirjautumisnäkymässä käyttäjänimen syötekenttään on kirjoitettu "Heimo" ja salasanan kenttään "kissa". Kun klikataan painiketta loginButton, kutsuu painikkeelle rekisteröity tapahtumankäsittelijä sovelluslogiikan ExerciseService metodia login parametreilla "Heimo" ja "kissa". UserDaon metodi findByUsernameAndPassword tarkastaa, onko järjestelmässä käyttäjää "Heimo" ja onko annettu salasana oikea. Mikäli kirjautuminen onnistuu, vaihtaa käyttöliittymä näkymäksi sovelluksen päänäkymän, exercisesScenen.

![Sekvenssikaavio2](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/sekvenssikaavio2.jpg)

