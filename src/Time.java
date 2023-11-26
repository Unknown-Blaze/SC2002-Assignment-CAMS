public class Time {
    public static void pause(int s){
        try
        {
            Thread.sleep(1000*s); // convert ms to s
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
