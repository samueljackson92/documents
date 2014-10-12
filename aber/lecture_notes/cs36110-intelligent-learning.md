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

### Learning as Regression

 - A target function should best fit the experience
 - We need to optimise an objective function
    - e.g. least squares
 - In practice we do not necessarily know the error so we need prior knowledge to define the correct target function

### Performance Measurement

 - Error rate = No. of Errors / No. of Examples
 - Apparent error rate
    - Based on the training examples
    - These are the examples which are used to learn and test
 - Test sample error rate
    - Based on testing examples
    - These are examples that have specifically been held back for testing purposes
 - True error rate
    - Based on new, unknown, practical examples
 - Generally about 2/3 of examples are used for training and 1/3 for testing
 - Apparent error rate will be overly optimistic
    - It is not a good indicator of performance
    - True/Test error rate will be more pessimistic

### Issues with Machine Learning

 - What algorithms exist to learn general target functions?
 - How do learning design factors influence accuracy?
    - No. of training examples
    - Complexity of hypothesis representation
 - How do learning characteristics influence accuracy?
    - Noisy data
    - Multiple data sources
 - Theoretical limits of learning
 - What prior knowledge can help the learner?
 - Clues from biological systems?
 - How can systems alter their own representation?
    - This is a major challenge, but very desirable.

### 2014-10-08 Concept Learning

 - Learning a concept from positive and negative examples
 - Concept: a category used to group similar ideas or things
    - A way to organise knowledge
    - Learning concepts may involve either recall or application
    - Humans can generalise from a small number of positive examples

 - Formalising a concept
    - Formulate defining features of a concept
    - Use these to form a test to apply to both positive and negative examples
    - Examples that violate the test are not counted as part of the concept

### Notation and Basic Terms
    - Instance space *x*: the set of constraints over which the concept is defined
    - Target concept *c*: concept as a function that needs to be learned
    - Training examples *<x, C(x)>*: the set of available training examples denoted as *D*
    - Hypothesis space *H*: the set of all possible hypotheses considered by the learning algorithm to identify the concept

 - Learning goal: To find a hypothesis such that *h(x)* = *c(x)* for all *x* in *D*

 - A hypothesis is a conjunction of constraints on attributes. Each attribute can be
    - A specific value (discrete or continuous)
    - Don't care. (It doesn't matter what the value is)
    - No value allowed. (If we have a value for this attribute then it is not satisfied)

 - Concept learning as a search
    - How to search out hypotheses in the hypothesis space that describe your opinions.
    - Any combination of *h* in the hypothesis space could be learned.
    - Assume each is a conjunction of all potential hypotheses
        - Potential list can be cut down by considering which are syntactically and semantically different/similar

### Generality Ordering of Hypotheses
 - Definition: *x* satisfies *h* if and only if *h(x) = 1*
 - Definition:
    - Let *h_i*, *h_j* be boolean functions defined over *X*.
    - *h_i* is more general or equal (*h_i* > *h_j*) <=> for all *x* in *X*, *h_i(x) = 1*  => *h_j(x) = 1*

 - If this is the case we can say:
    - *h_i* is more general than *h_j*
    - *h_j* is more specific than *h_i*

 - The two operators for learning
    - Generalisation (make the problem less specific)
        - Remove some constraints
        - Introduce new variables
        - Introduce a disjunction
    - Specialisation
        - Add more constraints
        - Instantiate variable with different values
        - Introduce conjunctions

### The Inductive Hypothesis
 - The Inductive Learning Hypothesis
    - Any hypothesis found to approximate a target function well over a sufficiently large set of training examples will also approximate the target function well over other unobserved examples
