import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * javaRefreshse
 * Created by davidkrystall on 3/14/18.
 * <p>
 * <p>
 * (c) ontometrics 2015, All Rights Reserved
 */

class Process_PCB {
    public String name;
    int startTime;
    int finishTime;
    int executeTime;
    int arriveTime;
    int turnaroundTime;

    public Process_PCB(String name, int startTime, int finishTime, int executeTime, int arriveTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.executeTime = executeTime;
        this.arriveTime = arriveTime;
    }

    public void executeProcess() {
        finishTime = startTime + executeTime;
        turnaroundTime = finishTime - arriveTime;
    }
    public void output(){
        System.out.println("Name: " + name + "  Start Time -->" + startTime);
    }
}
class ReadyQ{
    int timeline = 0;
    int currentTime = 0;
    ArrayList<Process_PCB> readyQArray;
    ReadyQ(){
        readyQArray = new ArrayList<Process_PCB>();
        readyQArray.add(new Process_PCB("P1",-1,-1,24,0));
        readyQArray.add(new Process_PCB("P2",-1,-1,3,0));
        readyQArray.add(new Process_PCB("P3",-1,-1,3,0));
    }
    public void scheduler(){
        while(!readyQArray.isEmpty()){
            Process_PCB p = readyQArray.get(0);
            p.startTime = currentTime;
            p.executeProcess();
            currentTime += p.finishTime;
            readyQArray.remove(0);
            p.output();
        }
    }
}

//first come first serve scheduler
public class Scheduler {
    public static void main(String[]args){
        new ReadyQ().scheduler();
    }
}
