package VisualComponents;

import static org.lwjgl.glfw.GLFW.*;


public class WindowEvents {
    public static boolean startUp() {
        glfwInit();
        if (!glfwInit()) {
            System.out.println("Unable to initialize GLFW");
            System.exit(0);}
        System.out.println("GLFW initialized");
        return true;
    }


    public static void CutOff() {
        System.out.println("Ending Process");
        glfwTerminate();
        System.exit(0);

    }
}