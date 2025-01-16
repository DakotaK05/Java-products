import VisualComponents.WindowEvents;
import EngineComponents.ErrorHandler;
import VisualComponents.TheWindow;
import static org.lwjgl.glfw.GLFW.*;

public class MAIN {

    public static void main(String[] args) {
        //Start up functions
        boolean running = WindowEvents.startUp();
        ErrorHandler.glfwCheck_for_error();




        if (!TheWindow.createWindow()){
            ErrorHandler.glfwCheck_for_error();
            WindowEvents.CutOff();
        }
        long window = TheWindow.getWindow();

        //while loop
        while (running){
            // Error checking area
            ErrorHandler.glfwCheck_for_error();

            if (glfwWindowShouldClose(window)) {
                running = false;
            }

        }


        WindowEvents.CutOff();



    }

}
