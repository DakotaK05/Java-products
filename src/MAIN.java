import VisualComponents.WindowEvents;

public class MAIN {

    public static void main(String[] args) {

        boolean running = WindowEvents.startUp();
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
