# Android Chat Application

This project is an Android chat application that allows users to send and receive messages in real time. The application is likely integrated with Firebase, given the presence of a `google-services.json` file.



https://user-images.githubusercontent.com/84729141/175020276-af190679-d6c4-45a3-b1e3-e0c0254a25d9.mp4



## Project Structure

- **app/src**: Contains the source code for the application, including activities, fragments, and other components.
- **build.gradle**: The Gradle build file for the app module, which includes dependencies and build configurations.
- **google-services.json**: A configuration file for Firebase, which is required for integrating Firebase services such as authentication, database, and cloud messaging.
- **gradle.properties**: Contains project-specific properties used by Gradle.
- **settings.gradle**: Specifies the settings for the Gradle build, including the modules to be included.

## Prerequisites

- **Android Studio**: Make sure Android Studio is installed on your machine.
- **Firebase Account**: Ensure you have a Firebase account and the project is set up in Firebase if you plan to use Firebase services.

## Setup and Running the Application

1. **Clone or Download the Project**:
   - If you haven't already, clone or download the project to your local machine.

2. **Open the Project in Android Studio**:
   - Launch Android Studio and select "Open an existing Android Studio project."
   - Navigate to the project directory (`Android_Chat-master`) and open it.

3. **Sync the Project with Gradle Files**:
   - Once the project is open, Android Studio will prompt you to sync the project with the Gradle files. Click "Sync Now."

4. **Configure Firebase (Optional)**:
   - If you plan to use Firebase, ensure that the `google-services.json` file is correctly configured. You may need to download a new `google-services.json` from the Firebase console if you are setting up a new Firebase project.

5. **Build the Project**:
   - After syncing, you can build the project by selecting "Build > Make Project" from the menu.

6. **Run the Application**:
   - Connect an Android device or start an emulator.
   - Click the "Run" button in Android Studio to install and launch the app on your device.

## Features

- **Real-time Messaging**: Send and receive messages instantly.
- **Firebase Integration**: Leverage Firebase services for authentication, real-time database, and cloud messaging.

