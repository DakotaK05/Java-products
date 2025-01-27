import VisualComponents.WindowEvents;
import EngineComponents.ErrorHandler;
import VisualComponents.TheWindow;
import static org.lwjgl.glfw.GLFW.*;

public class MAIN {

    private static String currentMode = "WINDOWED"; // Initial mode

    public static void main(String[] args) {
        // Start up functions
        boolean running = WindowEvents.startUp();
        ErrorHandler.glfwCheck_for_error();

        if (!TheWindow.createWindow()) {
            ErrorHandler.glfwCheck_for_error();
            WindowEvents.CutOff();
        }
        long window = TheWindow.getWindow();

        // Main loop
        while (running) {
            glfwPollEvents();

            // Handle mode switching
            if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS && !currentMode.equals("WINDOWED")) {
                TheWindow.Windowed();
                currentMode = "WINDOWED"; // Update mode
                WindowEvents.triggerResize(window);
            } else if (glfwGetKey(window, GLFW_KEY_F) == GLFW_PRESS && !currentMode.equals("FULLSCREEN")) {
                TheWindow.Fullscreen();
                currentMode = "FULLSCREEN"; // Update mode
                WindowEvents.triggerResize(window);
            } else if (glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS && !currentMode.equals("BORDERLESS")) {
                TheWindow.BorderlessWindowed();
                currentMode = "BORDERLESS"; // Update mode
                WindowEvents.triggerResize(window);
            }

            if (glfwWindowShouldClose(window)) {
                running = false;
            }
        }
    }
}

