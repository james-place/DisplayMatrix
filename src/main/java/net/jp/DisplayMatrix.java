package net.jp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class to construct a matrix style display using Java Swing.
 *
 * @author Stuart James
 *
 */
public class DisplayMatrix extends JPanel {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = -8072168508303112862L;

  /**
   * The width of the matrix.
   */
  private final int rows;

  /**
   * The height of the Matrix display
   */
  private final int columns;

  /**
   * The pixels that make up the matrix display.
   */
  private final Pixel pixels[][];

  /**
   * The frame dor displaying the LEDMatrix panel.
   */
  private final JFrame frame = new JFrame();

  /**
   * Construct a default display Matrix of size 8x8
   *
   * @throws InstantiationException
   *           If an error occurs while creating the Display Matrix.
   */
  public DisplayMatrix() throws InstantiationException {
    this(8, 8);
  }

  /**
   * Construct a display matrix.
   *
   * @param pRows
   *          the number of rows in the matrix.
   * @param pColumns
   *          the number of columns in the matrix.
   */
  public DisplayMatrix(int pRows, int pColumns) {
    super();
    if (pRows < 8) {
      System.out.println("Minumum rows supported is 8");
      rows = 8;
    } else {
      rows = pRows;
    }
    if (pColumns < 8) {
      System.out.println("Minumum columns supported is 8");
      columns = 8;
    } else {
      columns = pColumns;
    }

    pixels = new Pixel[rows][columns];
    initialise();
    setDefaults();
  }

  /**
   * @return
   *        the number of rows in the display.
   */
  public int getRows() {
    return rows;
  }

  /**
   * @return
   *        the number of columns in the display.
   */
  public int getColumns() {
    return columns;
  }

  private void initialisePixels() {
    this.setLayout(new GridLayout(rows, columns));
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        final Pixel pixel = new Pixel();
        pixels[row][col] = pixel;
        this.add(pixel);
      }
    }
  }

  /**
   * Run a sequence of colour tests.
   */
  public void test() {
    Color[] testColors = new Color[] {Color.GRAY, Color.BLACK, Color.YELLOW, Color.MAGENTA,
                                      Color.GREEN};
    for (Color color : testColors) {
      setColor(color);
      try {
        Thread.sleep(1000);
      } catch (final InterruptedException pEx) {
        Thread.currentThread().interrupt();
      }
    }
  }

  private void setDefaults() {
    this.setSize(850, 850);
    this.setVisible(true);
  }

  private void initialise() {
    frame.getContentPane().add(this);
    frame.setTitle("Matrix");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setMinimumSize(new Dimension(50 * rows, 50 * columns));
    initialisePixels();
    frame.setVisible(true);
    frame.pack();
  }

  /**
   * Show the pixels on the display.
   * @param pPixelData
   *        The pixel data supplied as boolean values.
   */
  public void draw(final boolean[][] pPixelData) {

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        try {
          Pixel pixel = pixels[row][col];
          if (pPixelData[row][col]) {
            pixel.turnOn();
          } else {
            pixel.turnOff();
          }
        } catch (ArrayIndexOutOfBoundsException pEx) {
          System.out.println("Pixel does not exist in (" + row + "," + col + ")");
        }
      }
    }
  }

  /**
   * Show the pixels on the display.
   * @param pPixelData
   *        The pixel data supplied as binary values.
   */
  public void draw(final String[] pPixelData) {
    final boolean[][] ledData = new boolean[rows][columns];
    for (int row = 0; row < rows; row++) {
      final char[] colData = pPixelData[row].toCharArray();
      final boolean[] colDataBoolean = new boolean[columns];
      for (int col = 0; col < columns; col++) {
        try {
          if (colData[col] == '1') {
            colDataBoolean[col] = true;
          } else {
            colDataBoolean[col] = false;
          }
        } catch (ArrayIndexOutOfBoundsException pEx) {
          colDataBoolean[col] = false;
        }
      }
      ledData[row] = colDataBoolean;
    }
    draw(ledData);
  }

  /**
   * Change the color of the entire Matrix.
   */
  public void setColor(final Color pColor) {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        final Pixel pixel = pixels[row][col];
        pixel.setColor(pColor);
        System.out.println("Setting pixel (" + row + "," + col + ") to Color " + pColor);
      }
    }
  }

  /**
   * Turn off the matrix display.
   */
  public void turnOff() {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        final Pixel pixel = pixels[row][col];
        pixel.turnOff();
      }
    }
  }
}
