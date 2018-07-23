# NYTimes - NY Times Most Popular Articles

  A sample app to hit the NY Times Most Popular Articles API and:
  Show a list of articles.
  Shows details when items on the list are tapped.

 # NyTimes - Api--

  We'll are using the most viewed section of this API.
  http://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?apikey= sample-key To test this API,
  For testAPI we used all-sections for the section path component in the URL

  This sample showcase use of
  LiveData
  ViewModels
  The app uses a Model-View-ViewModel (MVVM) architecture for the presentation layer.
  Each of the fragments corresponds to a MVVM View.

  The View and ViewModel communicate using LiveData and the following design principles:

  ViewModel objects don't have references to activities, fragments, or Android views.
  That would cause leaks on configuration changes, such as a screen rotation,
  because the system retains a ViewModel across the entire lifecycle of the corresponding view.

# App features
  This sample two screens.A list of recent news article and a detail view.

  The presentation layer consists of the following components:
  A main activity that handles navigation.Displays list of news
  A activity to display details of article
  A fragment to display a news detail for multipane mode for Tablet etc.
  
  
  ![device-2018-07-22-094729](https://user-images.githubusercontent.com/9075512/43042270-dd3ec2fe-8d96-11e8-9a1e-a26f212c6352.png)
  
  ![device-2018-07-22-094750](https://user-images.githubusercontent.com/9075512/43042272-df820d3c-8d96-11e8-872b-64ab56f78db0.png)
  
  ![device-2018-07-22-094814](https://user-images.githubusercontent.com/9075512/43042273-e153ab84-8d96-11e8-81e8-af3def266f89.png)


# Building

  Android studio version -- 3.1.3
  Java version - 1.8
  Gradle version - 3.1.3
  You can open the project in Android studio and press run.
  you can build for command line using --
  ./gradlew build

  To build and start your instrumented tests on your Android device use the following command.
  gradle connectedCheck

  Analyzing
  hit on analyze -> inspect code in Android studio for Lint

  Testing
  The project uses both instrumentation tests that run on the device and local unit tests that run on your computer.
  To run both of them and generate a coverage report, you can run:
  ./gradlew test -= to run tests
  ./gradlew fullCoverageReport (requires a connected device or an emulator)

   Device Tests
   UI Tests
   The projects uses Espresso for UI testing.


   Local Unit Tests
   ViewModel Tests
   Each ViewModel is tested using local unit tests with mock Repository implementations.

   Repository Tests
   Each Repository is tested using local unit tests with mock web service and mock database.

   Webservice Tests
   The project uses MockWebServer project to test REST api interactions.

# Libraries used
  Android Support Library
  Android Architecture Components
  Android Data Binding
  Dagger 2 for dependency injection
  Retrofit for REST api communication
  Picasso for image loading
  espresso for UI tests
  mockito for mocking in tests

# Improvements
  Local caching for fast loading -- Room Architecture / Realm database
  Auto refresh -- swipe pull down to refresh news
  Filters -- save , apply filters such as -- filter by , date, views, article by, popularity etc
          -- sort/ filter by options
  Localization -- news in opted language






