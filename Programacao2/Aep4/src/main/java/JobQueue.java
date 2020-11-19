import java.util.LinkedList;

public class JobQueue {
    private LinkedList<Job> jobs = new LinkedList<>();
    private JobQueueListener listener;

    public synchronized void queueJob(Job job) {
        synchronized (this) {
            this.jobs.add(job);
            updateListener();
        }
    }

    public synchronized Job getNextJob() {
        synchronized (this) {
            if (this.jobs.isEmpty()) {
                return null;
            }

            Job job = this.jobs.removeFirst();
            System.out.println("Getting job!");
            updateListener();

            return job;
        }
    }

    public void addJobQueueListener(JobQueueListener listener) {
        this.listener = listener;
    }

    private void updateListener() {
        if (this.listener != null) {
            this.listener.jobQueueChanged(this.jobs.size());
        }
    }

    public interface JobQueueListener {
        void jobQueueChanged(int newSize);
    }
}
