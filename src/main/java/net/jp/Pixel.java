package net.jp;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

/**
 * Java class representing a pixel on the Display Matrix
 * @author Stuart James
 */
public class Pixel extends JButton {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -7687889614061210476L;

  /**
   * The default pixel colour to represent pixel on state.
   */
  private Color colorOn = Color.GREEN;

  /**
   * The default pixel colout to represent pixel off state.
   */
  private Color colorOff = Color.BLACK;

  /**
   * Constructs an instance of a pixel using the defaults
   */
  public Pixel() {
    setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.gray));
    setFocusable(false);
    this.setColor(colorOff);
    this.setSize(2, 2);
  }

  /**
   * Change the colour representing the pixel on state.
   */
  public void setColorOn (final Color pColorOn) {
      colorOn = pColorOn;
  }

  /**
   * Change the colour representing the pixel off state.
   */
  public void setColorOff (final Color pColorOff) {
      colorOff = pColorOff;
  }

  /**
   * Change the colour of the pixel based on the supplied red green and blue values.
   * @param pRed
   *        The value for red.
   * @param pGreen
   *        The value for green.
   * @param pBlue
   *        The value for blue.
   */
  public void setColor(final int pRed, final int pGreen, final int pBlue) {
    setColor(new Color(pRed, pGreen, pBlue));
  }

  /**
   * Change the colour of the pixel.
   * @param pColor
   *        the supplied colour.
   */
  public void setColor(final Color pColor) {
     this.setBackground(pColor);
  }

  /**
   * Turn the pixel off.
   */
  public void turnOff() {
    this.setColor(colorOff);
  }

  /**
   * Turn the pixel on using the pixel default colour.
   */
  public void turnOn() {
    this.setColor(colorOn);
  }
}

