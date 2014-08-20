
const int  buttonPin2 = 2;// the pin that the pushbutton is attached to
const int  buttonPin3 = 3;
const int  buttonPin4 = 4;
const int  buttonPin5 = 5;
const int  buttonPin6 = 6;
const int  buttonPin7 = 7;
const int  buttonPin8 = 8;
const int  buttonPin9 = 9;
const int ledPin = 13;       // the pin that the LED is attached to

// Variables will change:
int buttonState = 0;         // current state of the button
int lastButtonState = 0;     // previous state of the button
int buttonState2 = 0;         
int lastButtonState2 =0;
int buttonState3 = 0;         
int lastButtonState3 =0; 
int buttonState4 = 0;         
int lastButtonState4 =0; 
int buttonState5 = 0;         
int lastButtonState5 =0; 
int buttonState6 = 0;         
int lastButtonState6 =0; 
int buttonState7 = 0;         
int lastButtonState7 =0; 
int buttonState8 = 0;         
int lastButtonState8 =0; 
void setup() {
  // initialize the button pin as a input:
  pinMode(buttonPin2, INPUT);
  pinMode(buttonPin3, INPUT);
  pinMode(buttonPin4, INPUT);
  pinMode(buttonPin5, INPUT);
  pinMode(buttonPin6, INPUT);
  pinMode(buttonPin7, INPUT);
  pinMode(buttonPin8, INPUT);
  pinMode(buttonPin9, INPUT);
  // initialize the LED as an output:
  pinMode(ledPin, OUTPUT);
  // initialize serial communication:
  Serial.begin(9600);
}


void loop() {
  // read the pushbutton input pin:
  buttonState = digitalRead(buttonPin2);
  buttonState2 = digitalRead(buttonPin3);
  buttonState3 = digitalRead(buttonPin4);
  buttonState4 = digitalRead(buttonPin5);
  buttonState5 = digitalRead(buttonPin6);
  buttonState6 = digitalRead(buttonPin7);
  buttonState7 = digitalRead(buttonPin8);
  buttonState8 = digitalRead(buttonPin9);

  // compare the buttonState to its previous state
  if (buttonState != lastButtonState) {
    // if the state has changed, increment the counter
    if (buttonState == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("1");
      
    } 
   
  } // compare the buttonState to its previous state
  else if (buttonState2 != lastButtonState2) {
    // if the state has changed, increment the counter
    if (buttonState2 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("2");
      
    } 
   
  }
   else if (buttonState3 != lastButtonState3) {
    // if the state has changed, increment the counter
    if (buttonState3 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("3");
      
    } 
   
  }
   else if (buttonState4 != lastButtonState4) {
    // if the state has changed, increment the counter
    if (buttonState4 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("4");
      
    } 
   
  }
   else if (buttonState5 != lastButtonState5) {
    // if the state has changed, increment the counter
    if (buttonState5 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("5");
      
    } 
   
  }
   else if (buttonState6 != lastButtonState6) {
    // if the state has changed, increment the counter
    if (buttonState6 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("6");
      
    } 
   
  }
   else if (buttonState7 != lastButtonState7) {
    // if the state has changed, increment the counter
    if (buttonState7 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("7");
      
    } 
   
  }
   else if (buttonState8 != lastButtonState8) {
    // if the state has changed, increment the counter
    if (buttonState8 == HIGH) {
      // if the current state is HIGH then the button
      // wend from off to on:
      
      Serial.println("8");
      
    } 
   
  }
 

  

  // save the current state as the last state, 
  //for next time through the loop
  
  lastButtonState = buttonState;
  lastButtonState2 = buttonState2;
  lastButtonState3 = buttonState3;
  lastButtonState4 = buttonState4;
  lastButtonState5 = buttonState5;
  lastButtonState6 = buttonState6;
  lastButtonState7 = buttonState7;
  lastButtonState8 = buttonState8;

  
}









