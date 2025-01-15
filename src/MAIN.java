import VisualComponents.WindowEvents;
import EngineComponents.ErrorHandler;

public class MAIN {

    public static void main(String[] args) {

        boolean running = WindowEvents.startUp();
        ErrorHandler.Check_for_error();
        int i = 0;
        while (running) {
            System.out.println(i);
            i += 1;
            if (i == 10) {
                running = false;
            }

        }


        WindowEvents.CutOff();



    }

}
