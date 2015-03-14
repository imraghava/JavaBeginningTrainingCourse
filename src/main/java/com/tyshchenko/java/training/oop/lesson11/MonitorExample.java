package com.tyshchenko.java.training.oop.lesson11;

import com.tyshchenko.java.training.oop.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexander Tyshchenko.
 */
public class MonitorExample {

    public static void main(String[] args) {
        Monitor monitor = new Monitor(Constants.FILE_PATH_LESSON_11);
        monitor.setTimeout(2000);
        monitor.setEvents(new MyEvents());
        monitor.start();

        Runtime.getRuntime().addShutdownHook(new MyStop(monitor));
    }


    public interface IFileEvents {
        void onFileChanged(String path);
        void onFileAdded(String path);
        void onFileDeleted(String path);
    }

    private static class MyEvents implements IFileEvents {
        public void onFileChanged(String path) {
            System.out.println("File changed: " + path);
        }

        public void onFileAdded(String path) {
            System.out.println("File added: " + path);
        }

        public void onFileDeleted(String path) {
            System.out.println("File deleted: " + path);
        }
    }

    private static class MyStop extends Thread {

        private Monitor s;

        public MyStop(Monitor s) {
            this.s = s;
        }
        public void run() {
            s.stop();
        }

    }

    public static  class Monitor {
        private class MonitorThread extends Thread {

            private String path;
            private int timeout;
            private Map<String, Long> prev = new HashMap<>();
            private Map<String, Long> curr = new HashMap<>();
            private IFileEvents events;

            public MonitorThread(String path) {
                this.path = path;
                createHashMap(prev);
            }

            public void run() {
                while (!isInterrupted()) {
                    createHashMap(curr);
                    compareMaps(prev, curr);
                    prev.clear();
                    prev.putAll(curr);
                    try {
                        Thread.sleep(timeout);
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }

            public int getTimeout() {
                return timeout;
            }

            public void setTimeout(int value) {
                timeout = value;
            }

            public IFileEvents getEvents() {
                return events;
            }

            public void setEvents(IFileEvents value) {
                events = value;
            }

            private void doFileChanged(String path) {
                if (events != null)
                    events.onFileChanged(path);
            }

            private void doFileAdded(String path) {
                if (events != null)
                    events.onFileAdded(path);
            }

            private void doFileDeleted(String path) {
                if (events != null)
                    events.onFileDeleted(path);
            }

            private void compareMaps(Map<String, Long> m1, Map<String, Long> m2) {
                Set<String> keys = m1.keySet();
                Iterator<String> it = keys.iterator();
                while (it.hasNext())
                {
                    String path = it.next();

                    if (m2.containsKey(path)) {
                        long date1 = m1.get(path);
                        long date2 = m2.get(path);

                        if (date2 > date1)
                            doFileChanged(path);
                    } else {
                        doFileDeleted(path);
                    }
                }

                keys = m2.keySet();
                it = keys.iterator();
                while (it.hasNext())
                {
                    String path = it.next();

                    if (!m1.containsKey(path))
                        doFileAdded(path);
                }
            }

            private void createHashMap(Map<String, Long> output) {
                try {
                    File file = new File(path);
                    File[] list = file.listFiles();

                    output.clear();
                    if (list != null) {
                        for (File f : list) {
                            output.put(f.getCanonicalPath(), new Long(f.lastModified()));
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        private String path;
        private MonitorThread thread;
        private IFileEvents events;
        private int timeout = 1000;

        public Monitor(String path) {
            this.path = path;
        }

        public void start() {
            thread = new MonitorThread(path);
            thread.setTimeout(timeout);
            thread.setEvents(events);
            thread.start();
        }

        public void stop() {
            thread.interrupt();
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int value) {
            timeout = value;
        }

        public IFileEvents getEvents() {
            return events;
        }

        public void setEvents(IFileEvents value) {
            events = value;
        }
    }


}
