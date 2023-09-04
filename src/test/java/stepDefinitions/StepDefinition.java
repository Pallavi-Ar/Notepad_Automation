package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static implementation.Implement.*;
import static notes.NoteData.*;

public class StepDefinition {
    @Given("User opens the app")
    public void userOpensTheApp() throws IOException {
        launchApp();
    }

    @When("User adds five notes")
    public void userAddsFiveNotes() throws IOException {
        createNotes(note1);
        createNotes(note2);
        createNotes(note3);
        createNotes(note4);
        createNotes(note5);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        screenshot("allNotes.jpg");
    }

    @When("User changes the color of notes")
    public void userChangesTheColorOfNotes() {
        changeColor();
    }

    @Then("Printing the time of each note")
    public void printingTheTimeOfEachNote() {
        time();
    }

    @When("User opens the settings and changes the day to Monday")
    public void userOpensTheSettingsAndChangesTheDayToMonday() {
        changeDay();
    }

    @Then("Verifying that the day is changed")
    public void verifyingThatTheDayIsChanged() {
        verifyDay();
    }

    @When("User searches the third note")
    public void userSearchesTheThirdNote() {
        searchNote();
    }

    @Then("Verifying the searched result")
    public void verifyingTheSearchedResult() {
        verifySearch();
    }

    @When("User deletes second and fourth note")
    public void userDeletesSecondAndFourthNote() {
        deleteNotes();
    }

    @Then("Verifying that deleted notes are present in trash bin")
    public void verifyingThatDeletedNotesArePresentInTrashBin() {
        verifyDelete();
    }

    @When("User archives the first note")
    public void userArchivesTheFirstNote() {
        archiveNote();
    }

    @Then("Verifying that archived note is present in archive")
    public void verifyingThatArchivedNoteIsPresentInArchive() {
        verifyArchive();
        driver.quit();
    }
}
