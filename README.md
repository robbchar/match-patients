# Match Patients
A program that allows a patient to make various selections (their demographics, therapy preferences) to use in matching them with potential therapists.
## Setup
This application uses Java 21, and Gradle to build the application in general. The front end is an angular 19 application and was built using node v22.12.0 (there is an .nvmrc file in the match-patients-ui directory if nvm is used to manages node versions). Once node is installed running `npm i` in the match-patients-ui director should download all the dependencies for the fe to build. You do not have to install anything for the front end beyond node, and even that _should_ be installed by the build, running the main spring boot application will build and copy the angular app to where the spring boot application can serve the page. Once you pull the code locally and setup spring, node, and java 21 run `./gradlew bootRun` from the `match-patients/match-patients-api/` directory which will start everything, just navigate to http://localhost:8080 to use the application.
## Approach
### Matching
Once the patient makes selections and submits them the matching begins:
- first the patient's location is used to limit to the providers in that area
- the next stage is to see the requests from the patients to the attributes of the providers
  - areas of concern
  - preferred treatment modalities
  - preferred therapist sexual orientation
  - preferred therapist religious faith
  - preferred therapist origin group
- then that is limited to the top three (or more if there are ties)
- if there are no ties then that is what is returned if there are ties:
  - match against the patient's provided demographics as a tiebreaker:
    - patient's religious faith
    - patient's sexual orientation
    - patient's origin group
- after that regardless of whether there are ties three providers are sent to the patient
### Data
There are two concerns/thoughts I have with some of the data:
1. After discussing with Alice I added both categories and examples for the categories rather than one 'demographics' choice. That seemed reasonable.
   - the choices are duplicated between the front end and backend which could be ameliorated if there was some sort of datastore
2. There is preprocessing done when the app starts on the data to match up which choices go to which Providers to make the matching on invocation of the endpoint more efficient. 
