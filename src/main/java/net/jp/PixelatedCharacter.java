package net.jp;

import java.util.ResourceBundle;

/**
 * Pixelated representation of a character.
 * @author Stuart James
 *
 */
public class PixelatedCharacter {

  /**
   * The character.
   */
  final String character;

  /**
   * The resource bundle to use to get the matching pixelated form.
   */
  private static ResourceBundle bundle =  ResourceBundle.getBundle("net.jp.characterset");

  /**
   * Create an instance of the pixelated character.
   * @param pCharacter
   *        The input character.
   */
  public PixelatedCharacter(final char pCharacter) {
    if (pCharacter == '!') {
      character = "exc";
    } else if (pCharacter == '#') {
      character = "#";
    } else {
      character = String.valueOf(pCharacter).toLowerCase();
    }
  }

  /**
   * @return the pixel notation for the character.
   */
  public String[] getPixels() {
    final String[] pixels = new String[8];
    for (int i=0; i < pixels.length; i++) {
      final String line = bundle.getString((character + "-" + i).trim());
      if (line == null) {
        pixels[i] = "00000000";
      } else {
        pixels[i] = line;
      }
    }
    return pixels;
  }
}
