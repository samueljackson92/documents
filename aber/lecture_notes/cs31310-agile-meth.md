# CS31310: Agile Methodologies

## 2014-09-29

### Course examination

 - 3 worksheets worth 10% in total
 - 1 exam worth the remaining 90%

### Problems with software development

 - lack of a coherent process
    - who is in charge?
    - what is the process?

 - Too prescriptive and a heavyweight process
    - unreasonable amounts of documentation

 - Inappropriate up-front detailed requirement specification, design and rigid planning

 - Lack of involvement with the customer

### Glossary of terms

 - PRD: Product Requirement Document
 - MRD: Marketing Requirement Document

### Suggested reading

 - *No silver bullet for software systems* - Fred Brooks

## 2014-10-03 - The Agile Manifesto

### Agile Alliance Principles
 - Satisfy the customer early through continuous delivery of valuable and useful software.
 - Welcome changing requirements, event late in development. Harness change for the customer's competitive benefit.
 - Deliver software frequently, from a couple of weeks to a few months.
 - Business people and developers must work together daily.
 - Build project around motivated individuals.
 - The most effective method for conveying information within a team is face-to-face communication.
 - Working software is the primary measure of progress.
 - Agile processes promote sustainable development.
 - Continuous attention to technical excellence and good design enhances agility.
 - Simplicity: Th art of maximising the amount of unnecessary work not done.
 - The best architectures, requirements, and designs originate from self-organising teams.
 - At regular intervals the team reflects on how to become more effective.


## 2014-10-06 - Extreme Programming

### Motivation Behind XP
 - Project success seems to be "just luck"
 - Integration nightmares
 - Low sponsor expectations
 - Smelly software: Bad code smells!, brittle, fragile, wrong features, missing features, bug prone...
 - XP aims to flatten the "cost of change" curve
    - Not quite linear, but closer!

### XP Values
 - Simplicity: do what is needed and no more! (KISS)
 - Communication: XP demands communication to be effective
 - Feedback: continual feedback loop with stakeholders
    - This helps with being reactive to change
 - Courage: Courage to be open about progress. Courage to be honest. Courage to change.
 - Respect: Between developers and between developers and stakeholders

### The 12 Practices of XP
 - The Planning Game
    - Getting user stories
    - Estimating effort for each story
    - Customer determines scope of project

 - Test Driven Development
    - Unit testing
    - Acceptance testing
    - Automate the process where possible. Make it streamlined!

 - Pair Programming
    - Design and development in pairs
    - Extra set of eyes on the code
    - Automatic code review/feedback
    - Constant discussion of potential solutions
    - Shared responsibility gives confidence
    - Potential for training/shadowing

 - Merciless Refactoring
    - Improve code quality without changing its functionality

 - Simple Design
    - Incremental design
    - Find the simplest design that will solve the problem
    - Don't build things the user doesn't need or want
    - YAGNI "You aren't going to need it!" principle

 - Collective Code Ownership
    - Everybody owns the code
    - But: You break it then you fix it
    - If you need to change something do it!
        - But keep the team in the loop (communication)

 - Continuous Integration
    - Integrate the code in an integration platform several times a day
    - Build servers (Jenkins etc.)

 - On-site Customer
    - Customer works as part of the team
    - This is a difficult one. Often hard to get companies to dedicate a person to this

 - Small Releases
    - Providing business value as soon as possible
    - Gives the customer an early checkpoint
    - Opportunities for feedback

 - Apply "Coding" Standards
    - Common look and feel to the project
    - In the code, documentation, GUI etc.

 - System Metaphor:
    - Loosely relates to idea of architecture

 - Common Additional Practices
    - Daily stand-up meetings
    - Retrospectives
        - "What should we have done?"
        - "What can we do next time?"

## 2014-10-10 - Scrum

### History
 - Roots in paper *"The new new product development game"* - Observations of companies, inc. Honda and NEC
 - Developed in the early 90s

### Scrum Overview
 - "￼Scum (n): A framework within which people can address complex adaptive problems, while productively and creatively delivering products of the highest possible value."
        - Not software focussed!

### Scrum Theory: Three Pillars
 - Transparency: Everyone involved in the project should understand what is expected and how the process works.
 - Inspection: Review the outputs at regular intervals
 - Adaption: Change the process if it is not working or not delivering sensible results

### Scrum Team Roles
 - Product Owner
    - Responsible for maximising the value of the product and work of the development team
    - One person, not a committee

 - Development Team
    - Has the necessary skills to sucessfully deliver the product
    - Self-organising
    - Cross-functional

 - Scrum Master
    - Support for the product owner, development team, and organisation
    - *This is not about management*

### Scrum Events
 - The Sprint
    - A fixed time in which the team produces and "done" product increment
 - Meetings
    - Sprint planning
        - "What can be done in the sprint?"
        - "How will it get done?"
        - Setting a sprint goal
    - Daily Scrum
    - Sprint Reviews
    - Sprint Retrospectives

### Scrum Atrifacts
 - Backlog
    - Everything that is needed in the project (e.g. features and fixes)
    - An ordered list of requirements
    - Different aspects:
        - Product backlog
        - Sprint backlog

### Where is the detail?
 - Scrum says nothing about practices
    - Do we use TDD?
    - Pair programming?
    - How do we decide to schedule the work?
 - What is "Done"?
 - There are certain rules
    - No one but the product owner can cancel a sprint
 - Do we need the detail?
    - How do we ensure we deliver useful, "done", value for the customer?
