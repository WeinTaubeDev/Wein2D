package wein2d;

import java.awt.*;
import javax.swing.*;

class Canvas extends JPanel
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    protected RenderedObject[] renderedObjects = new RenderedObject[0];
    // Primitive
    protected int sizeX;
    protected int sizeY;
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Canvas(int givenSizeX, int givenSizeY)
    {
        sizeX = givenSizeX;
        sizeY = givenSizeY;
    }
    // Override: Get Preferred Size ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Dimension getPreferredSize()
    {
      return new Dimension(sizeX, sizeY);
    }
    // Override: paintComponent ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void paintComponent(Graphics givenG)
    {
        // get Graphics2D
        Graphics2D g = (Graphics2D) givenG;
        // loop through the list of rendered objects and draw it
        for (RenderedObject renderedObject: renderedObjects)
        {
            renderedObject.draw(g, sizeX, sizeY);
        }
        // clear list of rendered objects
        renderedObjects = new RenderedObject[0];
    }
}
