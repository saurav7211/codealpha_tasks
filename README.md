# codealpha_tasks
# AI Chatbot 

## Overview
This project is a simple AI Chatbot developed in Java using Swing for the graphical user interface. The chatbot uses a rule-based approach and a predefined FAQ database to respond to user queries. It demonstrates the basics of GUI development, event handling, and simple Natural Language Processing (NLP) concepts in Java.

## Features
* Interactive chat interface built with Java Swing
* FAQ-based response system using HashMap
* Keyword matching for generating responses
* Basic NLP through text normalization (lowercase conversion)
* Fallback responses for unknown questions
* Send messages using the Send button or Enter key
* User-friendly chat window

## Technologies Used
* Java
* Java Swing
* AWT
* HashMap Collection Framework

## How It Works
1. The chatbot loads predefined FAQs into a HashMap.
2. The user enters a message in the input field.
3. The chatbot converts the input to lowercase for easier matching.
4. It checks whether the input contains any predefined keywords.
5. If a match is found, the corresponding response is displayed.
6. Otherwise, a fallback response is generated.

## Installation and Execution

### Prerequisites
* Java JDK 8 or later
* Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or Command Prompt

### Run from Command Line
Compile the program:

```bash
javac AiChatBot.java
```

Run the program:

```bash
java AiChatBot
```

## Sample Conversation
```text
Bot: Hello! Type something to start chatting.

You: hello
Bot: Hi there! I am your AI assistant. How can I help you today?

You: what is java
Bot: Java is a versatile, object-oriented programming language. I love it!

You: bye
Bot: Goodbye! Have a wonderful day ahead!
```

## Future Enhancements
* Add more FAQ entries
* Integrate a database for storing conversations
* Implement advanced NLP techniques
* Connect with AI APIs such as OpenAI
* Add voice input and speech output
* Improve keyword matching using machine learning

## Learning Outcomes
This project helps in understanding:
* Java Swing GUI Development
* Event Handling
* Collections Framework (HashMap)
* Object-Oriented Programming (OOP)
* Basic Chatbot Design
* Rule-Based AI Systems

-------------------------------------------------------------------------------------------------------------------------------------------------------------------


# Student Grade Tracker

A simple Java Swing application for managing student grades and calculating performance statistics.

## Features
* Add student names and grades through a graphical user interface.
* Display a list of all students and their grades.
* Calculate and display:

  * Average score
  * Highest score
  * Lowest score
* User-friendly interface built with Java Swing.
* Input validation to prevent invalid grade entries.

## Technologies Used
* Java
* Swing (GUI Framework)
* ArrayList Collection Framework

## Project Structure

```
StudentGradeTracker.java
```

## How It Works
1. Enter the student's name.
2. Enter the student's grade.
3. Click the **Add Student** button.
4. The application will:

   * Store the student information.
   * Update the student list.
   * Recalculate average, highest, and lowest scores.
   * Display the updated statistics.

## Screenshots
Add screenshots of the application here after running it.

## Requirements
* Java JDK 8 or higher

## How to Run
### Compile
```bash
javac StudentGradeTracker.java
```

### Run
```bash
java StudentGradeTracker
```

## Learning Objectives

This project demonstrates:

* Java Swing GUI development
* Event Handling using ActionListener
* ArrayList data management
* Exception Handling
* Basic statistical calculations
* Object-Oriented Programming concepts

## Future Improvements

* Save student data to a file.
* Edit and delete student records.
* Add grade categories and subjects.
* Generate reports in PDF format.
* Display charts and graphs for grade analysis.


