---
layout: page
title: User Guide
---
#User Guide - NUScheduler
NUScheduler is a desktop app for Year 1 Computing students to assist with more efficient management of tasks and contacts,
optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, NUScheduler can schedule your tasks faster than traditional GUI apps.

- Quick Start
- Features
    - Task Management
        - Add task
        - Delete task
        - Update task
        - Find task
        - View all tasks and their deadlines
    - Contact Management
        - Add contact
        - Delete contact
        - Edit contact
        - List all contacts
        - Clear all contacts
    - Exit the app
- FAQ
- CLI Summary

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have `Java 11` or above installed in your Computer.

2. Download the latest `NUScheduler.jar` from [here](https://github.com/AY2122S2-CS2103-F11-4/tp/releases/tag/v1.3).

3. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:
   1. `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named John Doe to the Address Book.
   2. `addt d/Buy groceries t/01/01/2022` : Adds an `assignment/task` to NUScheduler.
   3. `delele 3` : Deletes the 3rd contact shown in the current list.
   4. `delt 3` : Deletes the 3rd task shown in the current task list.
   5. `findt assignment 1` : Finds any tasks in the current task list that contains the keyword(s).
   6. `updt 3 d/Buy groceries` : Updates the specified task in the current list.
   7. `viewt` : Lists all tasks.
   8. `list` : Lists all contacts.
   9. `clear` : Deletes all contacts.
   10. `exit` : Exits the app.

7. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

**Notes about the command format:**

- Words in **UPPER_CASE** are the parameters to be supplied by the user.e.g. in `add n/NAME`, **NAME** is a parameter.
- which can be used as `add n/John Doe`.
- Items in **square brackets** are optional.e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.
- Parameters cannot be in any order and must follow the order given in the command format.e.g. if the command format.
- specifies `addt d/DESCRIPTION [t/DEADLINE]`, the details must be entered as `d/DESCRIPTION [t/DEADLINE]`.
- All `<integer>` fields must be > 0.

</div>

### Feature - Add a task: `addt`

Adds a task to the task list.

Format: `addt d/DESCRIPTION t/DEADLINE (dd/mm/yyyy)`

Example: `addt d/Buy groceries t/01/01/2022`

### Feature - Delete a task: `delt <integer>`

Deletes a task from the task list, where `<integer>` is the ID of the task.

Format: `delt <integer>`

Example: `delt 3`

### Feature - Update a task description and/or deadline: `updt`

Updates a task in the task list, where `<integer>` is the ID of the task.

Format: `updt <integer> [d/DESCRIPTION] [t/DEADLINE]`

Example: `updt 3 d/Buy groceries t/01/02/2022`

Example: `updt 3 d/Buy groceries`

Example: `updt 3 t/01/02/2022`

### Feature - Find tasks: `findt`

Locating tasks which match any of given keywords.

Format: `findt KEYWORD [MORE_KEYWORDS]`

- The search is case-insensitive. e.g. `lessons` will match `Lessons`.
- The order of the keywords matters. e.g. `drink water` will not match `water drink`
- Only full keyword(s) will be accepted. e.g. `drink` will match `drink`; `ink` will not match `drink`
- All keyword(s) have to be matched for task to be returned.

Example: `findt lessons` returns `Swimming lessons 03/05/2022`.

### Feature - List all tasks: `viewt`

View all the tasks currently in the task list.

Format: `viewt`

### Feature - Adding a contact: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Feature - Deleting a contact : `delete`

Deletes the specified person from the address book.

Format: `delete <Integer>`

* Deletes the person at the specified `<Integer>`.
* The integer refers to the index number shown in the displayed contact list.
* The integer **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete 2` deletes the 2nd contact in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st contact in the results of the `find` command.

### Feature: Editing a contact : `edit`

Edits an existing contact in the address book.

Format: `edit INTEGER [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INTEGER`. The integer refers to the index number shown in the displayed person list. The integer **must be a positive integer** 1, 2, 3, …
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
  specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st contact to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd contact to be `Betsy Crower` and clears all existing tags.

### Listing all contacts : `list`

Shows a list of all contacts in the address book.

Format: `list`

### Clearing all contact entries : `clear`

Clears all entries from the address book.

Format: `clear`
### Feature - Exit the app: `exit`

Exits the app.

Format: `exit`

### Feature - Saving the data

NUScheduler data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Feature - Editing the data file

NUScheduler data are saved as a JSON file `[JAR file location]/data/addressbook.json` for address book and `[JAR file location]/data/tasklist.json`. 
Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the
data of your previous NUScheduler home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                   | Format, Examples                                                                                                                                                      |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **addt**                 | `addt d/DESCRIPTION [t/DEADLINE]` <br> e.g., `addt d/Buy groceries [t/2022 02 22 5pm]`                                                                                |
| **delt**       | `delt <integer>` <br> e.g., `del t 3`                                                                                                                                 |
| **updt**     | `updt <integer> [d/DESCRIPTION] [t/DEADLINE]`<br> e.g., `updt 3 d/Buy groceries t/01/01/2022`                                              |
| **findt**   | `findt <KEYWORD>` <br> e.g., `findt lessons`, `findt swimming lessons`                                                                                                |
| **viewt**                | `viewt`                                                                                                                                                               |
| **add**                  | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` |
| **del**        | `del <integer>` <br> e.g., `del 3`                                                                                                                                    |
| **edit**       | `edit <integer> [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br>  e.g., `edit 1 p/91234567 e/johndoe@example.com`                                    |
| **exit**                 | `exit`                                                                                                                                                                |
