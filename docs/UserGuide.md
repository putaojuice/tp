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
        - View all tasks and their deadlines
    - Contact Management
        - Add contact
        - Delete contact
        - Update contact
        - View all contacts
    - Exit the app
- FAQ
- CLI Summary

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have `Java 11` or above installed in your Computer.

2. Download the latest `NUScheduler.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:
   1. `view c` : Lists all contacts.
   2. `add c` /John Doe /[johnd@example.com](mailto:johnd@example.com) /johntele: Adds a contact named John Doe to the Address Book.
   3. `add tn/Assignment 1 m/CS1101s` : Adds an `assignment/task` of the specified module to NUScheduler.
   4. `del c 3` : Deletes the 3rd contact shown in the current list.
   5. `delt 3` : Deletes the 3rd task shown in the current task list.
   6. `upd t 3 n/Assignment 2 m/CS1231s` : Updates the specified task in the current list.
   7. `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

**Notes about the command format:**

- Words in **UPPER_CASE** are the parameters to be supplied by the user.e.g. in `add t n /NAME`, **NAME** is a parameter.
- which can be used as `add t n /John Doe`.
- Items in **square brackets** are optional.e.g `/NAME [/TAG]` can be used as `/John Doe /friend` or as `/John Doe`.
- Parameters cannot be in any order and must follow the order given in the command format.e.g. if the command format.
- specifies `add t /DESCRIPTION /DEADLINE [/TAG]`, the details must be entered as `/DESCRIPTION /DEADLINE [/TAG]`.
- All `<integer>` fields must be > 0.

</div>

### Feature - Add a task: `addt`

Adds a task to the task list.

Format: `addt d/DESCRIPTION [t/DEADLINE (dd/mm/yyyy)]`

Example: `addt d/Buy groceries [t/01/01/2022]`

### Feature - Delete a task: `delt <integer>`

Deletes a task from the task list, where `<integer>` is the ID of the task.

Format: `delt <integer>`

Example: `delt 3`

### Feature - Update a task description: `upd t d <integer>`

Updates a task in the task list, where `<integer>` is the ID of the task.

Format: `upd t d <integer>  /DESCRIPTION`

Example: `upd t d 3 /Buy groceries`

### Feature - Update a task deadline: `upd t t <integer>`

Updates a task in the task list, where `<integer>` is the ID of the task.

Format: `upd t t <integer> /DEADLINE`

Example: `upd t t <integer> /2022 03 10 12pm`

### Feature - Find tasks: `findt KEYWORD`

Locating tasks which match any of given keywords.

Format:  `findt KEYWORD`

- The search is case-insensitive. e.g. `lessons` will match `Lessons`.
- The order of the keywords matters. e.g. `drink water` will not match `water drink`
- Only full keyword(s) will be accepted. e.g. `drink` will match `drink`; `ink` will not match `drink`

Example: `findt lessons` returns `Swimming lessons 03/05/2022`.

### Feature - List all tasks: `viewt`

View all the tasks currently in the task list.

Format: `viewt`

### Feature - Add contact: `add c`

Adds a person to address book.

Format: `add c /NAME /EMAIL /TELEGRAM [/TAG]`

The Telegram handle can be entered with or without an @ symbol in front.

Examples:

- `add c /John Doe /johnd@example.com /johndtele /Group Member`
- `add c /Betsy Crow /betsycrow@example.com /betsyc`

### Feature - Delete contact: `del c <integer>`

Deletes a contact from the contact list.

Format: `del c <integer>`

Example: `del c 3`

### Feature - Update contact: `upd c <integer>`

Updates a contact from the contact list.

Format:  `upd c /NAME /EMAIL /TELEGRAM [/TAG] <integer>`

Update a contact’s information, where `<integer>` is the contact’s unique identifier.

Example: `upd c /John Doe  /johndoe@example.com /johntele 23`

### Feature - View all contacts: `view c`

View all the contacts currently in the contact list.

Format: `view c [to] [t] [/TAG]`

The optional parameter `[to]` will return the contact list in tag order instead of the default alphabetical order.

The optional parameter `[t]` requires a tag input and will return contacts from that tag only.

Examples:

- `view c`
- `view c to`
- `view c t /Friends`

### Feature - Remind the user of upcoming tasks: `remind`

Reminds the user of all the tasks with upcoming deadlines (within 7 days by default).

Format: `remind [<integer>]`

The optional `[<integer>]` specifies the number of days to check tasks against and return.

Tasks are returned in ascending order of time to deadline (closest deadline first).

Example: `remind 10`

### Feature - Exit the app: `exit`

Exits the app.

Format: exit

### Feature - Saving the data

NUScheduler data is saved in the hard disk automatically after any command that changes the data. There is no manual save function.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?

**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the
data of your previous NUScheduler home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                | Format, Examples                                                                                                  |
|-----------------------|-------------------------------------------------------------------------------------------------------------------|
| **addt**              | `addt d/DESCRIPTION [t/DEADLINE]` <br> e.g., `addt d/Buy groceries [t/2022 02 22 5pm]`                            |
| **delt <integer>**    | `del t <integer>` <br> e.g., `del t 3`                                                                            |
| **upd t d <integer>** | `upd t d <integer>  /DESCRIPTION`<br> e.g., `upd t d 3 /Buy groceries`                                            |
| **upd t t <integer>** | `upd t t <integer> /DEADLINE`<br> e.g.,`upd t t <integer> /2022 03 10 12pm`                                       |
| **findt KEYWORD**     | `findt <KEYWORD>` <br> e.g., `findt lessons`                                                                      |
| **viewt**            | `view t`                                                                                                          |
| **add c**             | `add c /NAME /EMAIL /TELEGRAM [/TAG]` <br> e.g., `add c /Betsy Crow /betsycrow@example.com /betsyc /Group Member` |
| **del c <integer>**   | `del c <integer>` <br> e.g., `del c 3`                                                                            |
| **upd c <integer>**   | `upd c /NAME /EMAIL /TELEGRAM [/TAG] <integer>` <br> e.g., `upd c /John Doe  /johndoe@example.com /johntele 23`   |
| **view c**            | `view c [to] [t] [/TAG]` <br> e.g., `view c`                                                                      |
| **exit**              | `exit`                                                                                                            |
