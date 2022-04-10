---
layout: page
title: Ivor's Project Portfolio Page
---

### Project: NUScheduler

NUScheduler is a desktop app for Year 1 Computing students to assist with more efficient management of tasks and contacts, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, NUScheduler can schedule your tasks faster than traditional GUI apps.

Given below are my contributions to the project.

* **New Feature**: Implemented `DeleteTask` command.
    * What it does: Allow the user to delete a particular task based on its ID in the Tasklist
    * Justification: Our target audience is year 1 computing students. It helps them to remove tasks that are not relevant anymore.
    * **Classes created**:
    * `DeleteTaskCommand`
    * `DeleteTaskCommandParser`
    * **Tests Written**:
        * `DeleteTaskCommandTest`
        * `DeleteTaskCommandParserTest`
    * **Additional info**:
        * Updated ParserUtil method of parseNumber to work with DeleteTaskCommand
        * Added relevant activity and sequence diagrams into Developer Guide

* **New Feature**: Implemented `UpdateTask` command.
    * What it does: Allow the user to update a particular task attributes based on its ID in the Tasklist
    * Justification: Our target audience is year 1 computing students. It helps them to update task that details have changed.
    * **Classes created**:
    * `UpdateTaskCommand`
    * `UpdateTaskCommandParser`
    * **Tests Written**:
        * `UpdateTaskCommandTest`
        * `UpdateTaskCommandParserTest`
    * **Additional info**:
        * Added additional class `UpdateTaskDescriptor` in `UpdateTaskCommand` to assist functionality
        * Added relevant activity and sequence diagrams into Developer Guide

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=Ivor&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18)

* **Project management**:
    * Managed release `v1.1`, `v1.2`, `v1.3`, `v1.4`.
    * Participated in weekly project meetings and set up weekly milestones with the team.
    * Reviewed pull requests.

* **Enhancements to existing features**:
    * Wrote additional tests to increase coverage for `DeleteTask`

* **Documentation**:
    * User Guide:
        * Added documentation for the feature `DeleteTask`.
        * Added documentation for the feature `UpdateTask`.
        * Added visuals in UG to enhance readability and understandability.
        * Fixed User Guide Bugs
    * Developer Guide:
        * Contribute to glossary in the developer guide.
        * Added user story for Delete task feature.
        * Added MSS for `DeleteTask`.
        * Add sequence diagram for delete task
        * Add activity diagram for delete task
        * Added user story for Update task feature.
        * Added MSS for `UpdateTask`.
        * Add sequence diagram for update task
        * Add activity diagram for update task

* **Community**:
    * PRs reviewed with comments to submitted PRs
    * Reported 9 bugs during [PE-D](https://github.com/ivorcmx/ped/issues)
    * Submitted forum post [#240](https://github.com/nus-cs2103-AY2122S2/forum/issues/240).

* **Statistics**:
    * Reviewed PRs: [16](https://github.com/AY2122S2-CS2103-F11-4/tp/pulls?q=type%3Apr+reviewed-by%3Aivorcmx)
    * Raised PRs: [17](https://github.com/AY2122S2-CS2103-F11-4/tp/pulls/@me)
    * Issues Taken: [44](https://github.com/AY2122S2-CS2103-F11-4/tp/issues?q=assignee%3A%40me+is%3Aclosed)
