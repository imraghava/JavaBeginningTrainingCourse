package com.tyshchenko.training.java.beginning.lesson5.jmx;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Alexander Tyshchenko.
 */
public class JMXExample {

    public static void main(String[] args)
                                            throws  NotCompliantMBeanException,
                                                    InstanceAlreadyExistsException,
                                                    MBeanRegistrationException,
                                                    InterruptedException,
                                                    MalformedObjectNameException {
        // Get the Platform MBean Server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // Construct the ObjectName for the MBean we will register
        ObjectName name = new ObjectName("com.tyshchenko.java.training.beginning.lesson5.jmx:type=Hello");

        // Create the Hello World MBean
        Hello mbean = new Hello();

        // Register the Hello World MBean
        mbs.registerMBean(mbean, name);

        // Wait forever
        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }

}
