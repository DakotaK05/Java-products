package VisualComponents;


import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class TheWindow {
    private static long window;


    public static boolean createWindow() {
        // Window Hints
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

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

    public static void Fullscreen() {
        // Obtain the primary monitor
        long monitor = glfwGetPrimaryMonitor();

        // Get video mode of the monitor
        GLFWVidMode vidMode = glfwGetVideoMode(monitor);

        if (vidMode == null) {
            System.err.println("Failed to retrieve video mode for the monitor.");
            return;
        }

        // Configure fullscreen with the monitor's native resolution
        glfwSetWindowMonitor(
                window,                 // The window handle
                monitor,                // Set fullscreen on the primary monitor
                0, 0,                   // Fullscreen ignores position
                vidMode.width(),        // Use native resolution width
                vidMode.height(),       // Use native resolution height
                vidMode.refreshRate()   // Use the monitor's refresh rate
        );


        System.out.println("Fullscreen mode enabled, stretched to monitor");
    }

    public static void BorderlessWindowed() {
        // Obtain the primary monitor
        long monitor = glfwGetPrimaryMonitor();

        // Get the video mode of the monitor
        GLFWVidMode vidMode = glfwGetVideoMode(monitor);

        if (vidMode == null) {
            System.err.println("Failed to retrieve video mode for the monitor.");
            return;
        }

        // Remove window decorations (borders, title bars)
        glfwWindowHint(GLFW_DECORATED, GLFW_FALSE);

        // Configure window to match the monitor resolution
        glfwSetWindowMonitor(
                window,                 // The window handle
                NULL,                   // NULL means windowed mode
                0, 0,                   // Top-left corner position (0,0 on the monitor)
                vidMode.width(),        // Set window width to native resolution
                vidMode.height(),       // Set window height to native resolution
                60          // Refresh rate is ignored in windowed
        );

        System.out.println("Borderless windowed mode enabled, stretched to monitor");
    }

    public static void Windowed() {
        // Obtain the primary monitor
        long monitor = glfwGetPrimaryMonitor();

        // Get the video mode of the monitor
        GLFWVidMode vidMode = glfwGetVideoMode(monitor);

        if (vidMode == null) {
            System.err.println("Failed to retrieve video mode for the monitor.");
            return;
        }

        // Calculate positions to center the window
        int posX = (vidMode.width() - 900) / 2;
        int posY = (vidMode.height() - 900) / 2;

        // Stretch the window to the same size as the monitor
        glfwSetWindowMonitor(
                window,                 // The window handle
                NULL,                   // NULL indicates windowed mode
                posX,                   // X position of the top-left corner
                posY,                   // Y position of the top-left corner
                900,        // Set window width to match screen width
                900,       // Set window height to match screen height
                60          // Refresh rate is irrelevant in windowed mode
        );

        // Set decorations back for windowed mode
        glfwWindowHint(GLFW_DECORATED, GLFW_TRUE);

        System.out.println("Windowed mode enabled, stretched to monitor");
    }
}
