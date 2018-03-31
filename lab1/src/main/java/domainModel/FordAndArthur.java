package domainModel;

/**
 * Created by Andrey on 30.03.2018.
 */
public class FordAndArthur {
    private boolean inSpace = false;

    public boolean getInspace() {
        return inSpace;
    }

    public void goInSpace(){
        if (inSpace){
            throw new IllegalStateException();
        } else {
            System.out.print(" Форд и Артур вылетели в открытый космос, как конфетти из хлопушки.");
            inSpace = true;
        }
    }
}
