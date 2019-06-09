##### Week Two
* Decided to create an app that allows users to convert 
numbers between different number systems (Decimal -> Binary, Binary -> Decimal
etc.)
* The UI will be broken up into 2 main section:
    * Top section will feature the result of the conversion as well
    the input by the user
    * Bottom section will feature a keypad where the user can enter
    the number he/she wishes to convert, as well as choose which
    number system to convert into
   
* Subtasks required to complete the project:
    1. Design and Implement keypad for different number systems
    2. Switch keypads when user changes number sytems
    3. Display entered number by user in top section of the screen
    4. Convert number entered in real-time and display it in the center
    of the top section of the screen
    
Time spent: ~2hrs.

##### Week Three
* Added base classes for Activities and Fragments

* Added three Fragments: BinaryKeyboardFragment, DecimalKeyboardFragment and HexKeyboardFragments

* Updated the layout of the MainActivity to use a ViewPager and added layouts for each of the three Fragments

* Finished implementing the layout for the DecimalKeyboardFragment

Time spent: ~2hrs.

##### Week Four
* Finished implementing the layouts for the remaining keyboard fragments

* Attached click listeners in the Main Activity for keyboard clicks inside of the fragments (still need to be implemented)

* ViewPager can be used to switch between keyboards by swiping

* User can use arrows to choose input and output Number System

* Remaining TODOs:
    * Attach click listeners to TextViews (in keyboards)
    * Implement logic for number conversion
    * Select color palette for app
    
Time spent: ~2hrs.