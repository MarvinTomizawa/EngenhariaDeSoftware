public class Consumer extends Thread {
    private JobQueue jobs;
    private Job assignedJob = null;


    public Consumer(JobQueue currentJob) {
        this.jobs = currentJob;
    }

    @Override
    public void run() {
        while (true) {
            if (assignedJob == null || assignedJob.getSize() == 0) {
                fetchNextJob();
            } else {
                processJob();
            }

        }
    }

    private void processJob() {
        for (int i = assignedJob.getSize(); i >= 0; i--) {
            System.out.println("Working: Job size " + assignedJob.getSize() + ", " + i + " seconds left. " + System.currentTimeMillis());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assignedJob = null;
    }

    private void fetchNextJob() {
        try {
            assignedJob = jobs.getNextJob();
            if (assignedJob == null) {
                System.out.println("No job left" + System.currentTimeMillis());
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
