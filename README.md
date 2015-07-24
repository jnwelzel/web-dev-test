#Web Dev Test Application
This app will let you fill out a form informing your skill level in seven different areas: HTML, CSS, Javascript, Django, Python, iOS Development and Android Development. Upon submitting the form to the server your data will be evaluated and afterwards you'll receive one to three different emails according to the areas you showed the most aptitude for.

##Dev mode install
The project is split in two different apps or parts: server and client. In order to get it running you must follow the instructions below:

###Server
* Depends on: Maven v3+, Java SDK v1.7+
* Make sure you have both these env vars declared: `WEB_DEV_TEST_EMAIL_ADDR` and `WEB_DEV_TEST_EMAIL_PWD`, which must contain a Gmail account name (ONLY the part before the @gmail.com) and the account password respectively
* Clone the repo, `cd` into the `server` dir (where the `pom.xml` file is), run `mvn package` (this will also run all the unit and integration tests)
* Finally start the server app by running `java -jar target/server-1.0.0-SNAPSHOT.jar server`
* The server should now be running at [http://localhost:8080](http://localhost:8080)

###Client
* Depends on: Nodejs v0.12.X, Npm v2.11.X
* `cd` into the `client` dir and install all Nodejs dependencies by running `npm install`
* Now run `grunt serve` and point your browser to [http://localhost:8000/#/](http://localhost:8000/#/)

That's it!
