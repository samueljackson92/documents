# CS36110: Intelligent Learning

## 2014-10-01

### Course examination

 - 2 hour written examination
 - Must answer 3 out of 4 questions

### Module Looks At

 - Tackling complex problems in the real world
    - Learning in humans is subconscious
    - We wish to make it explicit

### Topics

 - Introduction
 - Concept Learning
 - Decision Tree Learning
 - Artificial Neural Networks
 - Bayesian Learning
 - Support Vector Machines
 - Reinforcement Learning

### Introduction

 - Three core questions
    - Why develop intelligent learning?
    - How to define a learning problem?
    - How to measure the performance of an algorithm?

 - Experience is the key
     - Experience is an input-output pair
        - Input: environment in which you wish to solve problems
        - Output: the decision you wish to make.
     - We learn from experience
        - Experience gives us insight
     - Experience is input, knowledge is output

### When To Use Intelligent Learning

 - Human expertise doesn't exist
    - e.g. Mars rover
 - Humans are unable to easily explain their expertise
    - e.g. knowledge of the english language.
 - The solution changes over time
    - e.g. routing through a computer network
 - The solution needs to be adapted for specific cases
     - e.g. medical diagnosis, user biometrics

### Advantages and Disadvantages of Intelligent Learning

  - Advantages
     - often more accurate than human rules
        - Data driven
     - Humans are incapable of expressing what they know
         - e.g. English language
         - Can easily classify what they know
     - Automatic method to search for hypotheses given data
     - Cheap and flexible
        - Can apply to any learning task

 - Disadvantages
     - Need lots of labelled data in order for the program to learn
     - Very error prone
         - Impossible to get perfect accuracy
     - Often difficult to discern what has actually been learned
         - Many this may be learned from a single dataset

### Suggested reading

#### Books

 - *AI: A modern approach* - Russell & Norvig
 - *Machine Learning* - T. Mitchell

#### Journals

 - Machine Learning
 - Journal of Machine Learning Research
 - Artificial Intelligence

#### Conference Proceedings

 - International Conference on Machine Learning
 - International Joint Conference on Artificial Intelligence
 - Uncertainty in Artificial Intelligence

## 2014-10-02

### Common Learning Strategies

 - Data is cheap and abundant
 - knowledge is expensive and scarce
 - In increasing order of knowledge gradient
    - Rote learning  (just remembering it)
    - Learning by being told (taking advice)
        - This means just following advice, not asking or understanding why
    - Learning by analogy
        - using solution from another field
        - issues on what fields/problems are relevant
    - Learning from explanation
        - More abstract
        - Why is a concept a member of a category.
        - Choosing based on why without being told
 - Learning from example is the most widely used and studied

### Why Is Learning Necessary

 - Some applications cannot be programmed by hand
    - e.g. Autonomous driving
    - All aspects not known at the design stage
    - Amount of knowledge required might be too large to encode by hand

 - Self-customising programs
    - e.g. newsreader
    - world has constant stream of events
        - can be updated

### Possibility for Machine Learning
 - Recent progress in algorithms/theory
 - Growing flood of data
 - Better computational power
 - Growth of learning industry
    - market analysis, adaptive process control, decision support

 - A learning system is a program that makes decisions based on accumulated experience contained in successfully solved cases
    - Inferring general models from particular examples
    - Learning what happens naturally
    - Model should be a good, useful approximation of the data
    - Model should extract common characteristics

### Designing a Learning System
 - Choose from experience
 - Choose what is to be learned (the **target function**)
 - Choose how to represent the target function
 - Choose a learning algorithm to infer the target function based on experience
    - Infer some unknowns in the model
 - Evaluate performance
    - Feedback into the learning

### Representation
 - Training experience <input, output>
    - Input is a pattern (or **feature vector**)
        - each attribute can either be a discrete number, a real number, or a catagory (**class**)
    -  Output
        - either a real number of a categorical values
 - If the output of the example is omitted, then the learning is **unsupervised**. Otherwise it is **supervised**
 - Learning is about the mapping between examples and testing examples

### The Target Function
 - In practice we have no idea what the target function actually is
 - We make an assumption about how to represent it (choosing a model)
    - Called the hypotheses function *h*
 - *h* is learned from the many training examples
