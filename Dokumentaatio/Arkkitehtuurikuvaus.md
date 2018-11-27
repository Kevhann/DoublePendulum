# Arkkitehtuurikuvaus

## Rakenne
Ohjelma koostuu kahdesta osasta, käyttöliittymästä ja itse simulaatiosta.
Ohjelma on toteutettu kolmessa eri paketissa

Luokkakaavio:
%2F%2F Cool Class Diagram, [Ball|-xlocation:int;-ylocation:int;-mass:double;-length:double|setXY(int.int);calculateStartingAngle()]<-2[Logic|-gravity:double;-upperAngle:double;-upperAngleVel:double;-upperAngleAcc:double;-lowerAngle:double;-lowerAngleVel:double;-lowerAngleAcc:double | calculateAcceleration();setBalls(double.double)], [Drawing|-upperLine:Line;-lowerLine:Line]->[Logic],[UI]->[Drawing],[Main]->[UI]

## Käyttöliittymä
Käyttöliittymä on toteutettu paketissa Doublependulum.UI sijaitsevassa luokassa UI

Ohjelman käynnistäessä ensin ilmestyy käyttöliittymä. Siinä käyttäjä saa asettaa 
simulaatiolle haluamansa parametrit. Parametrit ovat:
 - Ylemmän pallon x,y koordinaatit sekä massa.
 - Alemman pallon x,y koordinaatit sekä massa. Alemman pallon koordinaatit ovat
   annettu suhteessa ylempään palloon.
 - Painovoima, joka vaikuttaa palloihin.

Käyttöliittymä hyväksyy vain oikeat arvot.
Itse ohjelma käynnistetään tästä näkymästä painamalla "Start" nappia.

## Sovelluslogiikka
Sovelluslogiikka sijaitsee Doublependulum.logic paketissa.
Sovelluslogiikan toteuttaa luokat Ball ja Logic. 
Luokka Ball kuvaa palloa. Pallo voidaan luoda joko yksin, tai toisen pallon suhteen.
