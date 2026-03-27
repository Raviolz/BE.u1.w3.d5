Parto con il notare che libri e riviste hanno molti attributi comuni e pochi che differenziano gli uni dagli altri.
Per questo decido che sia giusto creare una classe astratta e due figlie. Oggetti che poi vengono caratterizzati.
Item astratta e poi books e magazine che lo estendono. In modo da evitare ripetizioni nel codice di entrambe le due
classi figlie e avere un
terreno comune. Inoltre la traccia parla di elementi che possono essere prestati in generale.
La relazione con il padre sara'di tipo 1:1 perche' un libro o una rivista puo'essere solo un elemento del catalogo. Ogni
item puo essere solo o libro o rivista.

Poi la traccia parla di utenti quindi mi immagino un altra'tabella per gestirli.

Infine il collegamento del "tutto" sara' con la tabella prestiti in cui vedo comparire sia l' utente che l elemento
prestato. Quindi immagino che quesata
tabella abbia due chiavi secondarie di collegamento.
Una per il prestito che puo' appartenere ad un solo utente ma NEL TEMPO un utente puo' fare piu' prestiti quindi 1:N.
Allo stesso modo un elemento puo' esser prestato piu volte (nel tempo) ma ogni prestito ha solo un elemento alla volta (
da traccia)

Concetto rinforzato mentalmente.

Ogni utente puo' apparire piu volte nella tabella loans (piu prestiti) MA ogni riga di loans puo' appartente ad UN SOLO
utente (un prestito--> un utente).
Ogni item puo' apparire piu volte in loans (prestato piu volte) MA ogni riga e' il prestito di UN SOLO elemento.

Rifletto ...

Per item books e magazines avrei potuto usare anche una single table visto che le differenza di attributi e' poca quindi
risulterebbero pochi null e query piu facili ma penso sia piu giusto usare una joined in quanto la traccia fa una
distinzione tra item generale e
sottocategorie inoltre mi risulta un sistema di archiviazione piu organizzato e pulito
