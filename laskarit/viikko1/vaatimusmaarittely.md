# **Vaatimusmäärittely**

### **Sovelluksen käyttötarkoitus**
Sovelluksen avulla käyttäjien on mahdollista luoda omia sekä ratkoa muiden tekemiä tehtäväsarjoja.

### **Käyttäjät**
Alustavasti sovelluksessa tulee olemaan vain yhdenlaisia, peruskäyttäjiä.

### **Käyttöliittymäluonnos**
Sovellus koostuu viidestä eri näkymästä.

![Käyttöliittymäkaavio](https://github.com/nettivastaava/ot-harjoitustyo/blob/master/laskarit/viikko1/kuvat/kayttoliittymakaavio.jpg)

### **Ennen kirjautumista**
    • Käyttäjä voi luoda järjestelmään uuden käyttäjätunnuksen
    • Käyttäjä voi kirjautua sisään luomillaan tunnuksilla

### **Kirjautumisen jälkeen**
    • Käyttäjä näkee järjestelmään lisätyt tehtäväsarjat
    • Käyttäjä voi luoda uuden tehtäväsarjan
        ◦ Tehtäväsarjassa on oltava vähintään 4 ja enintään 8 tehtävää
        ◦ Tehtävälle on mahdollista asettaa ratkaisuvihje
    • Käyttäjä voi poistaa itse luomansa tehtäväsarjan
    • Käyttäjä voi ratkoa muiden luomia tehtäväsarjoja
        ◦ Käyttäjä voi halutessaan pyytää vihjeen näytettäväksi, mikäli tehtävällä on sellainen
        ◦ Vastauksen jälkeen järjestelmä näyttää oikean vastauksen
        ◦ Kun jokaiseen sarjan tehtävään on vastattu, palataan tehtäväsarjat sisältävään näkymään
    • Käyttäjä voi kirjautua ulos järjestelmästä
      
### **Jatkokehitysideoita**
Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla:
    • Käyttäjä voi eritellä, ketkä voivat nähdä ja ratkoa hänen lisäämänsä tehtäväsarjan
    • Käyttäjä näkee jokaisesta tehtäväsarjasta saamansa pisteet
    • Jokaisesta tehtäväsarjasta näkee, paljonko pisteitä kukin käyttäjä on siitä saanut
