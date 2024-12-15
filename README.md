# FaneLayDiar

FaneLayDiar est une solution innovante pour la gestion des transports urbains, combinant une architecture en microservices, une application web (Angular), une application mobile (Flutter) et l’intelligence artificielle via OpenAI.

---

## Architecture

### Microservices (Back-End)
- **Service Gateway** : Coordination des appels entre services.
- **Service de Gestion des Utilisateurs** : Authentification et gestion des profils.
- **Service de Gestion des Lignes** : Création, modification et optimisation des lignes de transport.
- **Service de traitement de la parole multilingue** : Reception des requetes vocales et detection de la destination qui est renvoyée a l'utilisateur requiert une clé OPENAI_KEY placée dans les variables d'environement


### Front-End
- **Application Web** : Développée avec Angular pour les gérants, moderateurs ...
- **Application Mobile** : Développée avec Flutter pour usagers avec optimisation des itinéraire en fonction des point de congestion et zones d'etranglement.

### Intelligence Artificielle
- Intégration des modèles OpenAI pour :
  - Optimisation des itinéraires.
  - Recommandations en temps réel.
- **Clé API OpenAI** : Stockée dans la variable d’environnement `OPENAI_KEY`.

---

## Prérequis

- **Java 17+**
- **Node.js & npm**
- **Angular CLI**
- **Flutter SDK**
- **PostgreSQL**
- **Clé API OpenAI**

---

## Installation

### Étape 1 : Cloner le projet
```bash
git clone https://github.com/mamadou99sene/FaneLayDiaarAPI
cd FaneLayDiaarAPI
OPENAI_KEY=your_openai_api_key
cd service-name( gateway-service, gestion-ligne, asr-service, gestion_utilissateur)
mvn spring-boot:run

Lancer l'application Web (Angular)
cd frontend
npm install
ng serve


Lancer l'application Mobile (Flutter)
cd mobile
flutter pub get
flutter run
