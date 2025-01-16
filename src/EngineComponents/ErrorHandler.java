package EngineComponents;

import static org.lwjgl.glfw.GLFW.*;

public class ErrorHandler {
    public static void glfwCheck_for_error() {
        int glfwErrorCode = glfwGetError(null);
        if (glfwErrorCode != GLFW_NO_ERROR) {
            glfwDetermine_error(glfwErrorCode);
        }
    }

    public static void glfwDetermine_error(int errorCode) {
        String errorDescription = glfwGetErrorDescription(errorCode);
        System.out.println("GLFW Error Detected: Code " + errorCode + " - " + errorDescription);
    }

    private static String glfwGetErrorDescription(int errorCode) {
        return switch (errorCode) {
            case GLFW_NOT_INITIALIZED -> "GLFW has not been initialized.";
            case GLFW_NO_CURRENT_CONTEXT -> "No context is current for this thread.";
            case GLFW_INVALID_ENUM -> "One of the arguments to the function was invalid.";
            case GLFW_INVALID_VALUE -> "One of the arguments to the function was outside the acceptable range.";
            case GLFW_OUT_OF_MEMORY -> "A memory allocation failed.";
            case GLFW_API_UNAVAILABLE -> "GLFW could not find the requested API.";
            case GLFW_VERSION_UNAVAILABLE -> "The requested OpenGL or OpenGL ES version is not available.";
            case GLFW_PLATFORM_ERROR -> "A platform-specific error occurred.";
            case GLFW_FORMAT_UNAVAILABLE -> "The requested format is not supported or available.";
            case GLFW_NO_WINDOW_CONTEXT -> "The specified window does not have an OpenGL or OpenGL ES context.";
            default -> "Unknown error.";
        };
    }
}