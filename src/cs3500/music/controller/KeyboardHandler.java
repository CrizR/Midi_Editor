package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles the keyboard commands. For each command set by the the methods:
 * setKeyTypes, pressed, and released, the Keyboard handler dispatches to the Runnable
 * saved in the three different maps when the appropriate key is pressed.
 */
public class KeyboardHandler implements KeyListener {
  private Map<Character, Runnable> keyTypedMap = new HashMap<>();
  private Map<Integer, Runnable> keyPressedMap = new HashMap<>();
  private Map<Integer, Runnable> keyReleasedMap = new HashMap<>();

  /**
   * Set the map for key typed events. Key typed events in Java Swing are characters
   */
  public void setKeyTypedMap(Map<Character, Runnable> map) {
    keyTypedMap = map;
  }

  /**
   * Set the map for key pressed events. Key pressed events in Java Swing are integer codes
   */

  public void setKeyPressedMap(Map<Integer, Runnable> map) {
    keyPressedMap = map;
  }

  /**
   * Set the map for key released events. Key released events in Java Swing are integer codes
   */

  public void setKeyReleasedMap(Map<Integer, Runnable> map) {
    keyReleasedMap = map;
  }


  /**
   * This is called when the view detects that a key has been typed.
   * Find if anything has been mapped to this key character and if so, execute it
   */

  @Override
  public void keyTyped(KeyEvent e) {
    if (keyTypedMap.containsKey(e.getKeyChar())) {
      keyTypedMap.get(e.getKeyChar()).run();
    }
  }

  /**
   * This is called when the view detects that a key has been pressed.
   * Find if anything has been mapped to this key code and if so, execute it
   */

  @Override
  public void keyPressed(KeyEvent e) {
    if (keyPressedMap.containsKey(e.getKeyCode())) {
      keyPressedMap.get(e.getKeyCode()).run();
    }
  }

  /**
   * This is called when the view detects that a key has been released.
   * Find if anything has been mapped to this key code and if so, execute it
   */

  @Override
  public void keyReleased(KeyEvent e) {
    if (keyReleasedMap.containsKey(e.getKeyCode())) {
      keyReleasedMap.get(e.getKeyCode()).run();
    }
  }

  public void addCommand(HashMap<Integer, Runnable> x) {
    for (Map.Entry<Integer, Runnable> entry : x.entrySet()) {
      keyPressedMap.put(entry.getKey(), entry.getValue());
    }
  }
}
