package net.jp.displaymatrix.examples;

import net.jp.DisplayMatrix;

/**
 * Class to display a Smiley Face on the Display Matrix.
 *
 * @author Stuart James
 *
 */
public class SmileyFace extends DisplayMatrix {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = -6211237049311720850L;

  /**
   * Construct the display for the Smiley Face.
   * The Smiley face display uses an 8x8 matrix.
   */
  public SmileyFace()  {
    super(8, 8);
  }

  /**
   * Displays the smiley faces using binary data as input.
   */
  public void displaySmileyFace() {
    final String[] smileyFace = new String[] {
                                              "00000000",
                                              "01100110",
                                              "01100110",
                                              "00000000",
                                              "10011001",
                                              "01000010",
                                              "00100100",
                                              "00011000"
                                              };
    super.draw(smileyFace);
  }

  /**
   * Displays the smiley faces using boolean data as input.
   */
  public void displaySmileyFaceBoolean() {
    final boolean[][] smileyFace = new boolean[][] {
                                                    {false,false,false,false,false,false,false,false},
                                                    {false,true,true,false,false,true,true,false},
                                                    {false,true,true,false,false,true,true,false},
                                                    {false,false,false,false,false,false,false,false},
                                                    {true,false,false,true,true,false,false,true},
                                                    {false,true,false,false,false,false,true,false},
                                                    {false,false,true,false,false,true,false,false},
                                                    {false,false,false,true,true,false,false,false}
                                                    };
    super.draw(smileyFace);
  }

  /**
   * Runs the Smiley Face program.
   * @param args
   * @throws InstantiationException
   */
  public static void main(final String args[]) throws InstantiationException {
    final SmileyFace smileyFace = new SmileyFace();
    smileyFace.displaySmileyFace();
    try {
      Thread.sleep(2000);
      smileyFace.test();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    smileyFace.displaySmileyFaceBoolean();
  }

}
