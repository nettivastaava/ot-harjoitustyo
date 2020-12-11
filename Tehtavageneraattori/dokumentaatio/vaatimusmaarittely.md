# **Vaatimusmäärittely**

### **Sovelluksen käyttötarkoitus**
Sovelluksen avulla käyttäjien on mahdollista luoda uusia sekä ratkoa aiemmin luotuja tehtäväsarjoja.

### **Käyttäjät**
Sovelluksessa tulee olemaan vain yhdenlaisia, peruskäyttäjiä.

### **Käyttöliittymäluonnos**
Sovellus koostuu kuudesta eri näkymästä.

![Käyttöliittymäkaavio](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/Tehtavageneraattori/dokumentaatio/kuvat/kayttoliittymakaavio.jpg)

### **Ennen kirjautumista**
   - [x] Käyttäjä voi luoda järjestelmään uuden käyttäjätunnuksen
      - [x] Käyttäjänimen oltava uniikki sekä vähintään 3 merkkiä ja salasanan 5 merkkiä pitkä
   - [x] Käyttäjä voi kirjautua sisään luomillaan tunnuksilla

### **Kirjautumisen jälkeen**
   - [x] Käyttäjä näkee järjestelmään lisätyt tehtäväsarjat
   - [x] Käyttäjä voi luoda uuden tehtäväsarjan
       - [x] Tehtäväsarjassa on oltava vähintään 4 ja enintään 8 tehtävää
       - [x] Tehtävälle on mahdollista asettaa ratkaisuvihje
   - [x] Käyttäjä voi ratkoa järjestelmään luotuja tehtäväsarjoja
       - [x] Käyttäjä voi halutessaan pyytää vihjeen näytettäväksi, mikäli tehtävällä on sellainen
       - [x] Vastausten jälkeen oikeita vastauksia voi pyytää näytettäviksi
       - [x] Kun jokaiseen sarjan tehtävään on vastattu, näytetään käyttäjälle sarjasta saatu pistemäärä
       - [x] Kun jokaiseen sarjan tehtävään on vastattu, palataan tehtäväsarjat sisältävään näkymään
   - [x] Käyttäjä voi kirjautua ulos järjestelmästä
      
### **Jatkokehitysideoita**
Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla:

    • Käyttäjä voi eritellä, ketkä voivat nähdä ja ratkoa hänen lisäämänsä tehtäväsarjan
    • Käyttäjä näkee jokaisesta tehtäväsarjasta saamansa pisteet
    • Jokaisesta tehtäväsarjasta näkee, paljonko pisteitä kukin käyttäjä on siitä saanut
    • Käyttäjä voi poistaa itse luomansa tehtäväsarjan
