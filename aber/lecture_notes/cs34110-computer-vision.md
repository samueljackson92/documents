# CS31410: Computer Vision

## 2014-10-02

### Course examination

 - Assignment worth 30% of the marks
 - Exam worth 70%, semi-open. Can take in 5 pages of notes.
    - Based on the scenario used in the assignment

### Books
 - *Computer Vision, Algorithms and Applications* - Richard Szeliski
 - *Computer Vision: Models, Learning and Inference* - Simon Prince
 - *Image Processing, Analysis and Machine Vision* - Milan Sonka, Vaclav Hlavac, and Roger Boyle
 - *Vision: a computational investigation into the human representation and processing of visual information* - David Marr

### Topics in Computer Vision

 - Paradigms
    - understanding that images can have different meanings
 - Image formation
    - Minimise and mitigate the errors and noise introduced during the image capturing process
 - Edge/Feature detection
    - Edges: pixels in which there is a distinct change
        - Finding discontinuations of the colour content of the image
    - Features: Corners and corner-like pixels in an image
 - Object Recognition
    - Reconstruction of more complex objects from an image using features and edges.
 - Motion
    - Optical flow. Three dimensional; how features in a 2D image change and evolve as time progresses
 - Shape from *x*
    - Shapes from shading, textures, structure in an image etc.
 - 3D Vision

## 2014-10-03 - Paradigms of Vision

 - The only evidence that vision is a solvable problem is our own visual system.
 - Deciding how we go about converting a raw image to understanding what is going on in the image.
    - How do we achieve this?
        - We use stereo vision
        - *Note:* We don't **need** stereo for depth, although it helps. Focussing can be used instead.
        - Adaption: Cells in the eye are constantly adapting to the changing scene.
    - How do we create a process so that a computer can solve this?

### Biological Vision

 - The eyes and the brain are very tightly coupled
    - 60% of the brain processes visual data in some form or another
        - But obviously some parts play a larger role than others
    - Interaction with the environment is key to the development of vision.
        - We know this from unethical early experiments and evidence from damaged brains etc.
            - Carousel cats
            - Perceptual illusions: Duck-rabbit

 - The visual pathway (Massive oversimplification version)
    - Eye picks up visual signals and passes them through the optical cortex
        - Colour signals are processed along a different pathway to motion
        - Simple geometric shapes are built up to more complex concepts

 - Two hypothesis streams (Another oversimplification)
    - Visual signals reach occipital lobes at the back of the head
    - Visual information begins to feed into other areas of the brain
    - In particular:
        - Ventral stream: The "What" pathway (upwards). This deals with object recognition
        - Dorsal stream: The "Where" pathway (downwards). This deals with spatial relationships
    - Things become much more complex and become coloured by what we expect to see and what we have seen before
        - We being to generalise.
        - This is where optical illusions start to fool us.

### Psychological Vision

 - Visual shortcuts
    - Our visual system is based on some general assumptions
        - Light comes from above
        - Objects have largely convex borders
        - Lines are expected to be continuous
        - Objects are normally not viewed from above
        - Faces are generally upright
            - Babies are hardwired to look for faces.

 - Gesalt Principles of Vision
    - Proximity: Our perception of depth
    - Similarity: Works on orientation and colour
    - Closure: Lines are continuous. We tend to "fill in" missing parts
    - Common Fate: Objects moving in a dissimilar way is particularly easy to spot

 - But if we take two of these properties our intuition brakes down.
    - It becomes harder for us to process the information
    - But we can still managed it if we concentrate. This suggests higher level processing

## 2014-10-09 - Four Paradigms for Computer Vision

### Reconstructionist Vision

 - Reconstruct Everything (David Marr's approach)
    - A.k.a The recovery, reconstructionist or general vision paradigm
    - Marr was the first one to propose a complete theory of computer vision
    - Central idea: Reconstruct everything and from that anything is possible
    - Has a strong biological grounding (as far as we understand)

 - Stages in the recovery paradigm
    - Image
        - Collect light information from the field of view
        - This is every point of a 2D lattice
        - Colour is irrelevant
        - A single time frame: 1 monocular or binocular image
    - Raw primal sketch
        - Structure in world leads to sudden changes in image contents
        - Locations in the image change in intensity
    - Full primal sketch
        - Locations identified in the image are grouped into countors and boundaries
        - These don't also correspond to the real world.
        - This stage gives us a notion of scale
        - We can also integrate over several scales
    - 2 1/2 D Sketch
        - Moving from images to surfaces
        - This includes shape fro *x* (texture, shadows etc.)
        - Extraction of local (relative) depth and surface orientation
    - 3D Model of the World
        - Full, complete representation of the world formed from the scene
        - Using generalised cylinders, metrics and/or symbolic representations of the world
        - This gives us all we need for many tasks
            - Recognition, navigation, localisation etc.

 - Issues with Marr's Approach
    - It can't be done
    - No evidence that the high-level processing part works this way in biological systems
        - There is evidence to the contrary
    - Waste of resources: No need to store such detailed information when we don't need it all

### Qualitative Vision

    - Idea:
        - Quantities are sensitive to noise and difficult to measure/evaluate
        - Qualities are stable to noise, easier to characterise
            - But less easy to manipulate
    - Often not necessary to know where something is in metric space.
        - Just to know how the key objects relate.
        - e.g. robotic hand grasping a bottle.
    - RCC - Randall, Cui, and Cohn (1992)
    - All about transforming noisy sensor data to useful predicates about the world.
    - Potential to act as a bridge between the real world and AI system
        - "From pixels to predicates"

### Active Vision

    - Idea: Moving the camera to improve perception
    - Can identify occlusions
    - Can help to resolve singularities and ambiguous circumstances.
    - Inspired by the way babies see (grasing and manipulation)
    - Paradigm is very popular in robotics
        - SLAM: Simultaneous Localisation and Mapping

### Vision Through Learning

    - Idea: Applying machine learning to computer vision problems
    - Large datasets allow use to build methods that will work with images that contain a large amount of variation
    - This is mostly used in conjunction with the qualitative paradigm to provide a bridge between the real world and the learning system

## 2014-10-10 - Image Formation

 - Forming an image
    - Cameras are mostly based (in a very general sense) on the concept of a pinhole camera
    - You have an:
        - Image plate to capture the image
        - A focal length between the focal point at the front of the camera
    - Real cameras have more complex issues
        - Limited depth of field
            - This is the distance that the camera is focus for
        - Distortions: e.g. radial (fish eye?)
        - Acquisition speed: What happens if something in the image moves?
        - Saturation: Loss of information through saturation of colours and clipping
        - Various automatic controls
            - auto brightness, focus, and contrast
    - If we need a better idea of where things are in 3D space, we need to perform camera calibration

 - Radiosity
    - The brightness at any point depends on
        - The amount of light that hits a surface
        - The amount of light that leaves a surface
        - Relative positions of the light source, camera, and orientation of the surface
        - Nature of the surface itself

    - Types of Surface Lighting
        - Lambertian Surface
            - Brightness is independent of viewpoint
            - Only depends on the angle between the light and viewpoint
            - Questionable about whether a "true" Lambertian surface actually exists

        - Specular
            - Light varies according to the viewpoint and viewer

 - Digitising
    - Images are not continuous. They are digital!
    - Generally represented as 2D arrays projected from the world
    - Only limited resolution is available
    - All of these points increases the complexity of processing images
    - Grey levels
        - Pixel values are not continuous
        - Only a discrete number of choices are available
    - Colour
        - Most representations use 256 levels of RGB
            - OpenCV uses BGR representation
        - RGB cube
            - 3 components between 0-255
            - Black = (0,0,0), White = (255,255,255)
            - Not a good colour space for computer vision.
                - Colour and luminosity are tightly bound
        - HSV: Hue Saturation Value
            - An alternate representation
            - Hue represented as 0 to 360 (a disk of choices)
            - Saturation is the quality of the colour (0 to 255)
            - Value is a dark (0) to light (255) scale
            - RGB can be directly converted to this format
        - LAB
            - Requires a colour calibrated camera
            - But can be approximated from RGB space
            - Colour remains the same, but brightness changes.
            - Useful for shadow detection
    - Colour Calibration and Correction
        - We use things where we accurately know the value of the colour
        - This allows us to correct for the effects of the capture device
    - Parallel Projection
        - Pinhole cameras use perspective projection
        - Uses the same principle, but has a very long focal length
    - Omni-Directional Mirrors
        - Uses a hyperbolic mirror
        - Badly affected by distortions
        - Non-homogeneous resolution
        - Edges tend to have particularly low resolution
    - Correcting for Distortions
        - Works out the effect of the lens
        - Often uses a chessboard type image with a clear height/width
        - Correct so that the board has right angles in the image
