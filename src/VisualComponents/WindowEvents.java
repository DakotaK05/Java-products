package VisualComponents;

import static org.lwjgl.glfw.GLFW.*;

public class WindowEvents {

    public static boolean startUp() {
        int[] major = new int[1];
        int[] minor = new int[1];
        int[] revision = new int[1];
        glfwGetVersion(major, minor, revision);
        System.out.println("GLFW Version: " + major[0] + "." + minor[0] + "." + revision[0]);
        glfwInit();
        if (!glfwInit()) {
            System.out.println("Unable to initialize GLFW");
            System.exit(0);
        }
        System.out.println("GLFW initialized");
        return true;
    }

    public static void CutOff() {
        System.out.println("Ending Process");
        glfwTerminate();
        System.exit(0);
    }

    // Trigger resize function
    public static void triggerResize(long window) {
        int[] width = new int[1];
        int[] height = new int[1];

        // Get the current window size
        glfwGetWindowSize(window, width, height);
        VisualComponents.Updater.resizeContent(width[0], height[0]);
    }
}
