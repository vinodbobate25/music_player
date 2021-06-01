# Music Plate App
<img src="readme/player.gif" alt="player git" width="980" />

A demo project to share my learnings


This app demonstrate the use of mvvm architecure with Hilt depenedency injection and Room Database
## Features

- [x] kotlin AndroidX
- [x] MVVM architecture
- [x] Hilt dependency Injection
- [x] Room Database 
- [x] LiveData
- [x] Mockito Testing 

## Description
- Music player application has two Fragments
- Home screen show currently playing Songs list
- Recent Screen shows Recenlty played songs list
- Bottom navigation is used to swtich between these 2 screens

## Hilt Dependency
Why i used Hilt over Dagger
-Hilt is extension to the dagger library
-This library removes lot of boilerplate code that we need to write
-No worries to declare Components.those who have worked on dagger would know how components creation is filthy.
-Hilt automatically generates Components for every module

## Room
adding room library in mvvm architecture is very easy.
no need to write lot of of code like sqlite
annotations like @insert,@update, @delete, @select would do job of inserting ,updating,deleting ,selection 
entity can be easil mapped to model and vise versa


## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```





