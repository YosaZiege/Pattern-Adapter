# Pattern Adapter

Reprise de l'implémentation du pattern Adapter.

## Objectif

Le pattern Adapter (structure) **convertit l'interface d'une classe dans une autre
interface attendue par le client**, de façon à faire fonctionner ensemble des
classes qui n'ont pas d'interfaces compatibles.

Exemple : une unité centrale expose une interface `VGA` (`print(String)`), tandis
qu'un écran TV expose une interface `HDMI` (`view(byte[])`). On insère un
adaptateur pour les rendre compatibles — comme un adaptateur physique VGA/HDMI.

## Structure

- `computer.VGA` : interface standard du client (`print(String)`).
- `computer.HDMI` : interface « étrangère » (`view(byte[])`).
- `computer.UniteCentrale` : le client, lié à `VGA`.
- `computer.Ecran`, `VideoProjecteur` : implémentations standard de `VGA`.
- `computer.TV` : implémente `HDMI` (incompatible directement).
- `computer.SuperVideoProjecteur` : implémente les deux interfaces.
- `adaptateur.HdmiVgaAdapter` : adaptateur par **composition** (implémente `VGA`,
  dépend de `HDMI`, convertit `String` → `byte[]`).
- `adaptateur.HdmiVgaAdapterHeritage` : adaptateur par **héritage** (étend `TV`).
- `App` : démo des deux variantes.

## Composition vs Héritage

- **Composition** (privilégiée) : l'adaptateur dépend d'une interface (`HDMI`),
  donc il peut adapter *n'importe quelle* implémentation de cette interface.
- **Héritage** : l'adaptateur étend directement `TV` — plus simple mais couplage
  fort (lié à une classe concrète).

## Exécution

```bash
mvn test          # lance les tests JUnit
mvn compile       # compile

mvn exec:java -Dexec.mainClass="com.school.designpatterns.adapter.App"
```
