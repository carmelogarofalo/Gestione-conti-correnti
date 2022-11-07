# Gestione-conti-correnti

Viene dato un file JSON compresso (in formato GZIP) contenente i conti correnti di una banca.

Ogni conto corrente contiene il nome del correntista ed una lista di movimenti.
I movimenti registrati per un conto corrente possono essere molto numerosi.
Per ogni movimento vengono registrati la data e la causale del movimento.
L'insieme delle causali possibili è fissato: Bonifico, Accredito, Bollettino, F24, PagoBancomat.

Viene progettata un'applicazione che attiva un insieme di thread.
Uno di essi legge dal file gli oggetti "conto corrente" e li passa, uno per volta, ai thread presenti in un thread pool.
Si vuole trovare, per ogni possibile causale, quanti movimenti hanno quella causale.

Struttura file JSON:

[{
"owner": "mmpdhvjx",
"records": [
{
"date": "Dec 28, 2020, 4:23:34 PM",
"reason": "F24"
},
{
"date": "Jan 23, 2019, 4:47:51 AM",
"reason": "BOLLETTINO"
},
...
]
},
{
"owner": "eiebaheo",
"records": [
{
"date": "Oct 9, 2019, 12:11:51 PM",
"reason": "F24"
},
{
"date": "Jul 18, 2019, 9:16:08 PM",
"reason": "F24"
},
...
]
},
...
]

