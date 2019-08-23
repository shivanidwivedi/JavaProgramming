# Data Structure and Problem Solving 

This project is focused on DSA and Problem Solving in Java with Maven. Unit tests covering all positive, negative, exception use cases are written for each of the program. 

## Basic git commands
* `git status`:
Use this command to know status of your repository. This is the most used git command. 
* `git log`: 
check entire history of commits, `git log -N`: check last N commits history
* `git add`:
The command is run for each program file to add them for git commit. This is a pre-requisite for `git commit`.
* `git commit`:
Most common command that commit your code changes to git **local** repository. Note that you have to run `git add` to prepare your changes for commit. 
* `git push`:
Use this command after `git commit` and only when you have finalized your changes. This will upload your local commit to git server and irreversible unlike git commit. 
* `git pull`:
Pulls the latest code changes form git server. Always use this command before starting development to make sure that you have latest code changes. 
* `git stash`: 
Stash code changes if you do not want to commit them. 
* `git reabse`:
  * It can be used to rebase your local branch by master branch i.e. run this in your private branch `git rebase master`
  * It can be used to squash multiple commits into one. 
* `git reset`
  * `git reset --soft <commitId>` is used to uncommit all code files until `<commitId>`
  * `git reset --soft <commitId>` is used to remove all all previous commits until `<commitId>`
* `git checkout`
  * `git checkout -b <branchName>` will create and switch to a new branch
  * `git checkout <branchName>` will only switch to existing branch
  
## Code quality
* Use `Emma` Intellij code coverage tool to run code coverage from unit tests. 
* Make sure that 100% lines are covered.
* **Install `maven` CLI on your machine**. You can use Intellij Terminal to run commands. 
* Here is the list of maven commands: http://tutorials.jenkov.com/maven/maven-commands.html
* `mvn surefire-report:report` command to generate unit test report. It can be viewed in `your-project/target/site/surefire-report.html`.
* `mvn test` to run all unit tests.


## DS covered are:
### Arrays
### Strings
### Maps
### Tree
### Graphs

## Algorithms : 

### Searching
### Sorting
### Dynamic Programing 
### Misc 

## Testing
* High code quality standard is followed by applying unit test and mutation test coverage
* Run `mvn org.pitest:pitest-maven:mutationCoverage` for mutation test coverage