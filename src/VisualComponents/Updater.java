package VisualComponents;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33.*;

public class Updater extends TheWindow{
    public static void resizeContent(int width, int height) {
        glViewport(0, 0, width, height);
        System.out.println("Window resized to: " + width + "x" + height);
        float aspectRatio = (float) width / height;
        System.out.println("New Aspect Ratio: " + aspectRatio);
    }

}
