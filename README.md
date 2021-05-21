# Clean Architecture Android Boilerplate with MVI architecture pattern in Android
Clean Architecture proposed and evangelised by Robert C. Martin, a.k.a. Uncle Bob produce systems that are:
1. Independent of Frameworks - The architecture does not depend on some library of feature-laden software. This permits you to use such frameworks as tools rather than cramming your system into their limited constraints.
2. Testable - The business rules can be tested without the UI, Database, Web Server, or any other external element.
3. Independent of UI - The UI can change easily without altering the rest of the system. A Web UI could be altered with a console UI, for example, without changing the business rules.
4. Independent of Database - You can swap out Oracle or SQL Server for Mongo, CouchDB, BigTable, or something else. Your business rules are not limited to the database.
5. Independent of any external agency - In fact, your business rules simply don't know anything at all about the outside world.

# How to adopt a Clean Architecture
One of the core aspects of Clean Architecture is the Separation of Concern design pattern that establishes a well-organized system. Each layer fulfils a meaningful and intuitive role while maximising changeability. In a nutshell, each layer of your application software addresses a particular concern (refer to S.O.L.I.D Principles), and each of these layers is separated by boundaries achieved via abstractions.
Another aspect behind the clean architecture is the Dependency Inversion principle. Based on this idea, Robert C. Martin's definition of the Dependency Inversion Principle consists of two parts:

1. High-level modules should not depend on low-level modules. Rather, they should depend on abstractions.
2. Abstractions should not depend on details. However, details should depend on abstractions.

# Introduction to MVI Architecture pattern
Model View Intent(MVI) is a reactive architecture pattern where the model is updated based on some interactions from user or the system and the view is updated based on states emitted from the model.

## MVI building blocks
Model holds single or multiple dynamic data structures and the business logic associated with it.
1. View, same as other architecture patterns, is the interface for displaying/rendering information to the end user by listening to the outputs of the model or state.
2. Intent (≠Android Intents) is an action or event from either the end user interacting with the user Interface or the system with a desired result.
3. And, Last but not the least, User; Either the actor interacting with the software system or the system itself.

## Why MVI?
Why another architecture pattern if we have already MVVM?
Well, one of the integral part of MVVM architecture is the ViewModel. Nevertheless, the concept of model defined in MVC pattern is not being followed religiously. The view is not driven by the model, directly. View can observe multiple observable properties from ViewModel for state changes which causes state overlapping issues (sometimes two different states are shown unexpectedly, both error and loader state).

MVI is Functional i.e MVI tries to consider everything as a function.
user(view(model(intent(user()))))

## MVI boilerplate
Now, since we all know about the benefits of MVI and its principles, it’s time to work on the boilerplate. The boilerplate code will help us setting up any MVI based Android project with LiveData and ViewModel.
Below we define some key components of the architecture.
1. ViewState : It represents the current state of the view at any given time and is a part of our model. All the dependent component of our view should be encapsulated in the ViewState. The code snippet below defines a generic ViewState as a data class.
2. ViewEffect : In most of the apps we develop, we use to have certain actions that are more like fire-and-forget or one time viz.- Showing a Toast Message. In those cases, we do not want to maintain the state of the toast in the viewState as it’s a kind of fire and forget thing rather than a state. We consider all such cases separately as effects, although they are also a part of our model.
3. ViewEvent : It is the action emitted by the UserInterface or the system interacting with the app. e.g LoadData, ButtonClicked, TrackEvent etc. etc.
