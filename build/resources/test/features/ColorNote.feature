@ColorNote
  Feature: Automating ColorNote App

    Scenario: User opens the app and performs tasks
      Given User opens the app
      When User adds five notes
      When User changes the color of notes
      Then Printing the time of each note
      When User opens the settings and changes the day to Monday
      Then Verifying that the day is changed
      When User searches the third note
      Then Verifying the searched result
      When User deletes second and fourth note
      Then Verifying that deleted notes are present in trash bin
      When User archives the first note
      Then Verifying that archived note is present in archive