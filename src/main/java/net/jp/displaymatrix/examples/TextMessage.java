package net.jp.displaymatrix.examples;

import net.jp.DisplayMatrix;
import net.jp.PixelatedCharacter;

/**
 * Class to display a Smiley Face on the Display Matrix.
 *
 * @author Stuart James
 *
 */
public class TextMessage extends DisplayMatrix {

  /**
   * serialVersionUID.
   */
  private static final long serialVersionUID = -6211237049311720850L;

  /**
   * Construct the display for the Smiley Face.
   * The Smiley face display uses an 8x8 matrix.
   */
  public TextMessage() {
    super(8, 8);
  }

  /**
   * Displays the smiley faces using binary data as input.
   */
  public void displayCharacter(final char pCharacter) {
    final PixelatedCharacter character = new PixelatedCharacter(pCharacter);
    super.draw(character.getPixels());
  }

  /**
   * Scroll a text message across the display.
   * @param pTextMessage
   *        The text message provided by the user.
   */
  public void scrollText(final String pTextMessage) {
    char[] messageCharacters = pTextMessage.toCharArray();
    final String[] messagePixels = new String[getRows()];
    for (char c : messageCharacters) {
      final PixelatedCharacter character = new PixelatedCharacter(c);
      final String[] characterPixels = character.getPixels();
      for (int row = 0; row < getRows(); row++) {
        if (messagePixels[row] == null) {
          messagePixels[row] = characterPixels[row];
        } else {
          messagePixels[row] = messagePixels[row] + characterPixels[row];
        }
      }
    }

    int currentIndex = 0;
    int lastIndex = 0;

    final String[] pixels = new String[getRows()];
    while (currentIndex <= lastIndex) {
      lastIndex = currentIndex + getColumns();
      for (int row = 0; row < getRows(); row++) {
        if (lastIndex > messagePixels[row].length()) {
          lastIndex = messagePixels[row].length();
        }
        pixels[row] = messagePixels[row].substring(currentIndex, lastIndex);
      }
      super.draw(pixels);
      try {
        Thread.sleep(100);
        currentIndex++;
      } catch (final InterruptedException pEx) {
        Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * Runs the Smiley Face program.
   * @param args
   */
  public static void main(final String args[]) {
    final TextMessage characters = new TextMessage();
//    characters.displayCharacter('A');
//    try {
//      Thread.sleep(2000);
//      characters.test();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    characters.displayCharacter('?');
    characters.scrollText("Hello World!!!");
  }

}
