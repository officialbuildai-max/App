package org.apache.tools.ant.taskdefs;

import com.google.android.gms.location.DeviceOrientationRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes7.dex */
class ProcessDestroyer implements Runnable {
    private static final int TWENTY_SECONDS = 20000;
    static /* synthetic */ Class class$java$lang$IllegalStateException;
    static /* synthetic */ Class class$java$lang$Runtime;
    static /* synthetic */ Class class$java$lang$Thread;
    private Method addShutdownHookMethod;
    private Method removeShutdownHookMethod;
    private Vector processes = new Vector();
    private ProcessDestroyerImpl destroyProcessThread = null;
    private boolean added = false;
    private boolean running = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class ProcessDestroyerImpl extends Thread {
        private boolean shouldDestroy;
        private final /* synthetic */ ProcessDestroyer this$0;

        public ProcessDestroyerImpl(ProcessDestroyer processDestroyer) {
            super("ProcessDestroyer Shutdown Hook");
            this.this$0 = processDestroyer;
            this.shouldDestroy = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.shouldDestroy) {
                this.this$0.run();
            }
        }

        public void setShouldDestroy(boolean z10) {
            this.shouldDestroy = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessDestroyer() {
        try {
            Class<?> cls = class$java$lang$Thread;
            if (cls == null) {
                cls = class$("java.lang.Thread");
                class$java$lang$Thread = cls;
            }
            Class<?>[] clsArr = {cls};
            Class cls2 = class$java$lang$Runtime;
            if (cls2 == null) {
                cls2 = class$("java.lang.Runtime");
                class$java$lang$Runtime = cls2;
            }
            this.addShutdownHookMethod = cls2.getMethod("addShutdownHook", clsArr);
            Class cls3 = class$java$lang$Runtime;
            if (cls3 == null) {
                cls3 = class$("java.lang.Runtime");
                class$java$lang$Runtime = cls3;
            }
            this.removeShutdownHookMethod = cls3.getMethod("removeShutdownHook", clsArr);
        } catch (NoSuchMethodException unused) {
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void addShutdownHook() {
        if (this.addShutdownHookMethod == null || this.running) {
            return;
        }
        ProcessDestroyerImpl processDestroyerImpl = new ProcessDestroyerImpl(this);
        this.destroyProcessThread = processDestroyerImpl;
        try {
            this.addShutdownHookMethod.invoke(Runtime.getRuntime(), processDestroyerImpl);
            this.added = true;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            Throwable targetException = e12.getTargetException();
            if (targetException != null) {
                Class<?> cls = targetException.getClass();
                Class<?> cls2 = class$java$lang$IllegalStateException;
                if (cls2 == null) {
                    cls2 = class$("java.lang.IllegalStateException");
                    class$java$lang$IllegalStateException = cls2;
                }
                if (cls == cls2) {
                    this.running = true;
                    return;
                }
            }
            e12.printStackTrace();
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private void removeShutdownHook() {
        Method method = this.removeShutdownHookMethod;
        if (method == null || !this.added || this.running) {
            return;
        }
        try {
            if (!((Boolean) method.invoke(Runtime.getRuntime(), this.destroyProcessThread)).booleanValue()) {
                System.err.println("Could not remove shutdown hook");
            }
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            Throwable targetException = e12.getTargetException();
            if (targetException != null) {
                Class<?> cls = targetException.getClass();
                Class<?> cls2 = class$java$lang$IllegalStateException;
                if (cls2 == null) {
                    cls2 = class$("java.lang.IllegalStateException");
                    class$java$lang$IllegalStateException = cls2;
                }
                if (cls == cls2) {
                    this.running = true;
                }
            }
            e12.printStackTrace();
        }
        this.destroyProcessThread.setShouldDestroy(false);
        if (!this.destroyProcessThread.getThreadGroup().isDestroyed()) {
            this.destroyProcessThread.start();
        }
        try {
            this.destroyProcessThread.join(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT);
        } catch (InterruptedException unused) {
        }
        this.destroyProcessThread = null;
        this.added = false;
    }

    public boolean add(Process process) {
        boolean contains;
        synchronized (this.processes) {
            try {
                if (this.processes.size() == 0) {
                    addShutdownHook();
                }
                this.processes.addElement(process);
                contains = this.processes.contains(process);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return contains;
    }

    public boolean isAddedAsShutdownHook() {
        return this.added;
    }

    public boolean remove(Process process) {
        boolean removeElement;
        synchronized (this.processes) {
            try {
                removeElement = this.processes.removeElement(process);
                if (removeElement && this.processes.size() == 0) {
                    removeShutdownHook();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return removeElement;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.processes) {
            try {
                this.running = true;
                Enumeration elements = this.processes.elements();
                while (elements.hasMoreElements()) {
                    ((Process) elements.nextElement()).destroy();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
