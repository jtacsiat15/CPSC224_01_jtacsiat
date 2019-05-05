/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouseandgraphics;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
   This applet demonstrates how mouse events and mouse
   motion events can be handled. It lets the user draw
   boxes by dragging the mouse.
*/

public class DrawBoxes extends JFrame
{
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private int width = 0;    // The rectangle's width
   private int height = 0;   // The rectangle's height
               
   /**
      init method
   */
   DrawBoxes()
   {
       setTitle("Box");
       setSize(500,500);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addMouseListener(new MyMouseListener());
       addMouseMotionListener(new MyMouseMotionListener());
       //init();
   }
   public void init()
   {
      // Add a mouse listener and a mouse motion listener.
      
   }
   
   /**
      paint method
      @param g The applet's Graphics object.
   */
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      
      // Draw a rectangle.
      g.drawRect(currentX, currentY, width, height);
   }
   
   /**
      Mouse listener class
   */

   private class MyMouseListener
                       implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         // Get the mouse cursor coordinates.
         currentX = e.getX();
         currentY = e.getY();
      }

      //
      // The following methods are unused, but still
      // required by the MouseListener interface.
      //

      public void mouseClicked(MouseEvent e)
      {
          currentX = e.getX();
          currentY = e.getY();
          repaint();
      }

      public void mouseReleased(MouseEvent e)
      {
          
      }

      public void mouseEntered(MouseEvent e)
      {
      }

      public void mouseExited(MouseEvent e)
      {
          
      }
   }
   
   /**
      Mouse Motion listener class
   */

   private class MyMouseMotionListener
                   implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
         // Calculate the size of the rectangle.
         width = e.getX() - currentX;
         height = e.getY() - currentY;
         
         // Repaint the window.
         repaint();
      }
      
      /**
         The mouseMoved method is unused, but still
         required by the MouseMotionListener interface.
      */
      
      public void mouseMoved(MouseEvent e)
      {
      }
   }
   public static void main(String[] args)
   {
       new DrawBoxes();
   }
}