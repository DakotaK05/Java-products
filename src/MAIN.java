import VisualComponents.WindowEvents;
import EngineComponents.ErrorHandler;
import VisualComponents.TheWindow;
import static org.lwjgl.glfw.GLFW.*;

public class MAIN {

    public static void main(String[] args) {
        //Start up functions
        boolean running = WindowEvents.startUp();
        ErrorHandler.glfwCheck_for_error();


        if (!TheWindow.createWindow()) {
            ErrorHandler.glfwCheck_for_error();
            WindowEvents.CutOff();
        }
        long window = TheWindow.getWindow();

        //while loop
        while (running) {
            // Error checking area
            glfwPollEvents();
            if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) {
                TheWindow.Windowed();
                }

            else if (glfwGetKey(window, GLFW_KEY_F) == GLFW_PRESS) {
                TheWindow.Fullscreen();
                }

            else if (glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS) {
                TheWindow.BorderlessWindowed();
                }

            if (glfwWindowShouldClose(window)) {
                running = false;
                }

            }




        }

    }

