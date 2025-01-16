package VisualComponents;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class TheWindow {
    // Declare the window as a class-level static variable
    private static long window;

    // Method to create a window
    public static boolean createWindow() {
        // Window Hints

        // Create the GLFW window
        window = glfwCreateWindow(900, 900, "SIGMA", NULL, NULL);
        if (window == NULL) {
            System.err.println("Failed to create GLFW window");
            return false;
        }
        return true;
    }

    // Getter to retrieve the window handle
    public static long getWindow() {
        return window;
    }
}