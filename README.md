# NYTimes - NY Times Most Popular Articles

 This sample showcase use of

   LiveData
   ViewModels

   Features--

   This sample two screens.A list of recent news article and a detail view.

   Presentation Layer

   The presentation layer consists of the following components:

   A main activity that handles navigation.Displays list of news

   A activity to display details of acrticle

   A fragment to display a news detail for multipane mode for Tablet etc.

   The app uses a Model-View-ViewModel (MVVM) architecture for the presentation layer.
   Each of the fragments corresponds to a MVVM View.
   The View and ViewModel communicate using LiveData and the following design principles:

   ViewModel objects don't have references to activities, fragments, or Android views.
   That would cause leaks on configuration changes, such as a screen rotation,
   because the system retains a ViewModel across the entire lifecycle of the corresponding view.


   Building
   You can open the project in Android studio and press run.

   you can build for comand line using --
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

   Libraries
   Android Support Library
   Android Architecture Components
   Android Data Binding
   Dagger 2 for dependency injection
   Retrofit for REST api communication
   Picasso for image loading
   espresso for UI tests
   mockito for mocking in tests

