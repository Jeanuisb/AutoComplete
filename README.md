Word Autocomplete (Java)
A Java-based autocomplete and autocorrect application that predicts and suggests words based on user input.The framework was written by Dr. Matt Superdock and implemented by Jean Bikorimana.
This project demonstrates practical use of data structures and algorithms, including hashtables and quicksort, to efficiently generate word suggestions.
🧠 Features

Autocomplete and autocorrect suggestions for input prefixes  
Custom HashtableMap for fast word storage and lookup  
Quicksort algorithm to rank suggestions by frequency or relevance  
Case-insensitive matching  
Console-based (no GUI)

🛠️ Technologies Used

Language: Java  
Algorithms: Hashtable, Quicksort  
Environment: JDK 17+

🚀 How to Run

Clone the repository:git clone https://github.com/jeanuisb/word-autocomplete-java.git


Navigate to the project directory:cd word-autocomplete-java


Compile all Java files:javac *.java


Run the demo:java AutocorrectDemo



📂 Project Structure
word-autocomplete-java/
│
├── AutocorrectDemo.class
├── Autocorrector.class
├── HashtableMap.class
├── IgnoreCaseComparator.class
├── Quicksort.class
├── small.txt              # Word dataset
└── README.md

📚 Example
Input: aut
Suggestions: auto, author, authority, automatic

🧩 Core Classes

AutocorrectDemo: Main program; handles input and output
Autocorrector: Core autocomplete and autocorrect logic
HashtableMap: Custom hash table for storing and accessing words
Quicksort: Sorts suggestions by frequency or relevance
IgnoreCaseComparator: Ensures case-insensitive word matching

👥 Credits

Framework Author: Dr. Matt Superdock  
Implementation: Jean Bikorimaa
