import java.util.Random;

public class Producer extends Thread{
    private final JobQueue jobs;

    public Producer(JobQueue jobs) {
        this.jobs = jobs;
    }

    @Override
    public void run() {
        final Random r = new Random();
        while (true) {
            try {
                sleep(2000);
                Job newJob = getRandomNumber(r);
                System.out.println("Creating new job, job size:" + newJob.getSize() + " seconds. " + System.currentTimeMillis());
                this.jobs.queueJob(newJob);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Job getRandomNumber(Random r) {
        var number = (int) (60 * r.nextDouble());
        return new Job(number == 0 ? 5 : number);
    }

}
