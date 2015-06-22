package be.iminds.iot.things.api.camera;

import be.iminds.iot.things.api.Thing;

/**
 * Represents a camera device. Using this API the camera metadata can be
 * queried, and the camera device can be turned on.
 *
 * Frames can be fetched from the camera using the next() method and
 * getRGB/getGrayscale methods.
 *
 * One can also use a push method to process frames of the Camera, by
 * registering a CameraListener
 *
 * @author tverbele
 *
 */
public interface Camera extends Thing {

    public final static String STATE = "be.iminds.iot.thing.camera.state";

    public static enum State {
    	OFF, ON;
    }

    public static enum Format {
    	RGBA, GRAYSCALE;
    }

    /**
     * Get the supported frame formats for this camera
     *
     * @return supported image formats
     */
    public Format[] getSupportedFormats();

    /**
     * Get the state of the camera
     *
     * @return state of the camera
     */
    public State getState();

    /**
     * Get the width of the frames the camera is fetching
     *
     * @return frame width or -1 if not initialized
     */
    public int getWidth();

    /**
     * Get the height of the frames the camera is fetching
     *
     * @return frame height or -1 if not initialized
     */
    public int getHeight();

    /**
     * Turn the camera on
     */
    public void start();

    /**
     * Turn the camera on with preferred width,height capture ratio
     *
     * @param width
     * @param height
     */
    public void start(int width, int height);

    /**
     * Stop capturing
     */
    public void stop();

}