# Match Patients
A program that allows a patient to make various selections (their demographics, therapy preferences) to use in matching them with potential therapists.

## Dependencies
jdk v21
gradle v8.12
node v22.12.0 (optional unless you want to run the fe separately as the main build will install this)

## Steps to run
Once the dependencies are installed you can run `./gradlew bootRun` from the root directory of the project which will build the front end and place it where the backend will pick it up and use for the pages that get served.

## Alternate method
You can run each separately, if say you want to develop the front end without having to re-build the backend, to do this run the backend as above and for the front end open a new terminal window and run `npm i` and then `npm run start` from the 'match-patients-ui' directory. This will run the front end at http://localhost:4200/ which will automatically proxy to the backend which is running at http://localhost:8080/.

## Description
The project is a multi-module Spring Boot setup which allows for the backend and frontend to be developed and worked on separately.

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
3. Information for origin groups found here: https://api-gbv.org/wp-content/uploads/2019/06/API-demographics-identities-May-2019.pdf
