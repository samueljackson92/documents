# CS32310: Advanced Computer Graphics

## 2014-10-03

### Course examination

 - WebGL assignment worth 50%
 - Exam worth 50%

### Introduction to 3D Graphics

 - Positioning and viewing
    - matrix transformations
    - perspective, rotation, translation, scaling
 - Hidden surface removal
    - z-buffers
 - Lighting
    - Surface normals, Gourand, Phong models
 - Texture mapping

### 3D Surface Data

 - Most surfaces are approximated using triangular faces
 - Vertex for each corner is a 3D point *(x,y,z)*
 - We need to perform several different types of operations
     - move them in 3D space
     - project them onto a 2D screen (perspective)
     - Add lighting, colour, and texture.

### Transforming 3D Objects

 - There are several different types of transforms that can be applied to 3D objects. See mathematics reference document for further detail.
    - Scaling: multiply the vertex by a vector or scalar
    - Translation: moving the object in 3D space. Addition of a translation vector to the point vector
    - Rotation: this is done about a single axis.
    - Perspective transforms: positioning vertices in the correct position relative the viewers perspective
- Combining multiple transforms
    - All of the transforms for a 3D vertex can be specified using a single 4 dimensional matrix.

### Shading

 - How we decide what colour to draw the rendered pixels
 - Need to account for:
    - Lighting
    - Reflective properties of the surface
    - Direction the surface is facing in
    - (Possibly) the location of the viewer
    - (Advanced) other surfaces in the scene

### Shading Models

 - Lambertian shading
    - Uses the angle between the surface normal and the direction of the light source
    - Calculates the fraction of light reflected
        - This follows a cosine relationship (see maths notes)
    - Can also include an ambient light term

 - Phong shading
    - Add as shiny reflection term
    - This additionally depends on the viewpoint

### Texture Mapping

 - Each vertex is assigned a 2D texture coordinate.
    - The texture coordinates map onto the texture image
 - Then interpolates the texture across the triangle
 - Sample the colours from the texture image
 - Bilinear interpolation
    - smooth the sampled textures to reduce pixellated effect

### Aliasing in Texture Mapping

 - Sampling a texture at large intervals causes:
    - Many pixels not to be sampled
    - Ones that are may not be representative of the texture
    - This is known as under-sampling

 - Solution: MIP-mapped textures
    - Create multiple resolution copies of the textures
    - Use lower resolution for more distant textures

### Scanline Shading

 - For reasons of efficiency, triangles are filled using 2D screen coordinates rather than 3D
    - Calculate values of vertices (intensity, texture, surface normals)
    - Project vertices onto 2D screen
    - Linearly interpolate vertex values across triangle in 2D
        - Use the Scanline algorithm

### Texture Shading

 - Flat shading: calculate intensity using face normal and shade all pixels in triangle the same
 - Gourand shading: calculate intensities at vertices and interpolate intensities (smoother).
 - Phong shading: interpolate vertex normals across triangle and calculate shading at each point

### Perspective Texture Distortion

 - Interpolation of the coordinates across triangular faces in 2D doesn't account for perspective
    - Faces appear to have bands and kinks when they shouldn't
 - Need to perform perspective division while interpolating in 2D to correct for the effect.
