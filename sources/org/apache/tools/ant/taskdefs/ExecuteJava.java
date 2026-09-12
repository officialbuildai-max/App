package org.apache.tools.ant.taskdefs;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.q;
import org.apache.tools.ant.types.d;
import org.apache.tools.ant.types.o;
import org.apache.tools.ant.util.Watchdog;
import org.apache.tools.ant.util.r;

/* loaded from: classes7.dex */
public class ExecuteJava implements Runnable, r {
    static /* synthetic */ Class array$Ljava$lang$String;
    private org.apache.tools.ant.types.c javaCommand = null;
    private org.apache.tools.ant.types.m classpath = null;
    private d.a sysProperties = null;
    private o perm = null;
    private Method main = null;
    private Long timeout = null;
    private volatile Throwable caught = null;
    private volatile boolean timedOut = false;
    private Thread thread = null;

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static void setupCommandLineForVMS(g gVar, String[] strArr) {
        gVar.t(true);
        try {
            String[] strArr2 = new String[strArr.length - 1];
            System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            File c11 = org.apache.tools.ant.util.f.c(strArr2);
            c11.deleteOnExit();
            gVar.p(new String[]{strArr[0], "-V", c11.getPath()});
        } catch (IOException unused) {
            throw new BuildException("Failed to create a temporary file for \"-V\" switch");
        }
    }

    public void execute(Project project) throws BuildException {
        org.apache.tools.ant.a aVar;
        Class<?> cls;
        String j11 = this.javaCommand.j();
        org.apache.tools.ant.a aVar2 = null;
        try {
            try {
                d.a aVar3 = this.sysProperties;
                if (aVar3 != null) {
                    aVar3.g();
                }
                try {
                    org.apache.tools.ant.types.m mVar = this.classpath;
                    if (mVar == null) {
                        cls = Class.forName(j11);
                        aVar = null;
                    } else {
                        org.apache.tools.ant.a g11 = project.g(mVar);
                        try {
                            g11.F(project.o());
                            g11.G(false);
                            g11.e();
                            g11.E(true);
                            g11.I();
                            g11.p(j11);
                            aVar = g11;
                            cls = Class.forName(j11, true, g11);
                        } catch (ClassNotFoundException unused) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Could not find ");
                            stringBuffer.append(j11);
                            stringBuffer.append(".");
                            stringBuffer.append(" Make sure you have it in your");
                            stringBuffer.append(" classpath");
                            throw new BuildException(stringBuffer.toString());
                        } catch (SecurityException e11) {
                            throw e11;
                        } catch (ThreadDeath e12) {
                            throw e12;
                        } catch (BuildException e13) {
                            throw e13;
                        } catch (Throwable th2) {
                            th = th2;
                            throw new BuildException(th);
                        }
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    aVar2.C();
                    aVar2.j();
                }
                d.a aVar4 = this.sysProperties;
                if (aVar4 != null) {
                    aVar4.f();
                }
                throw th3;
            }
        } catch (SecurityException e14) {
            throw e14;
        } catch (ThreadDeath e15) {
            throw e15;
        } catch (BuildException e16) {
            throw e16;
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            Class<?> cls2 = array$Ljava$lang$String;
            if (cls2 == null) {
                cls2 = class$("[Ljava.lang.String;");
                array$Ljava$lang$String = cls2;
            }
            Method method = cls.getMethod("main", cls2);
            this.main = method;
            if (method == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not find main() method in ");
                stringBuffer2.append(j11);
                throw new BuildException(stringBuffer2.toString());
            }
            if ((method.getModifiers() & 8) == 0) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("main() method in ");
                stringBuffer3.append(j11);
                stringBuffer3.append(" is not declared static");
                throw new BuildException(stringBuffer3.toString());
            }
            if (this.timeout == null) {
                run();
            } else {
                this.thread = new Thread(this, "ExecuteJava");
                project.A(this.thread, project.v(Thread.currentThread()));
                this.thread.setDaemon(true);
                Watchdog watchdog = new Watchdog(this.timeout.longValue());
                watchdog.addTimeoutObserver(this);
                synchronized (this) {
                    this.thread.start();
                    watchdog.start();
                    try {
                        wait();
                    } catch (InterruptedException unused3) {
                    }
                    if (this.timedOut) {
                        project.x("Timeout: sub-process interrupted", 1);
                    } else {
                        this.thread = null;
                        watchdog.stop();
                    }
                }
            }
            if (this.caught != null) {
                throw this.caught;
            }
            if (aVar != null) {
                aVar.C();
                aVar.j();
            }
            d.a aVar5 = this.sysProperties;
            if (aVar5 != null) {
                aVar5.f();
            }
        } catch (SecurityException e17) {
            throw e17;
        } catch (ThreadDeath e18) {
            throw e18;
        } catch (BuildException e19) {
            throw e19;
        } catch (Throwable th5) {
            th = th5;
            throw new BuildException(th);
        }
    }

    public int fork(q qVar) throws BuildException {
        org.apache.tools.ant.types.d dVar = new org.apache.tools.ant.types.d();
        dVar.m(this.javaCommand.j());
        for (String str : this.javaCommand.g()) {
            dVar.e().f(str);
        }
        if (this.classpath != null) {
            dVar.f(qVar.getProject()).i(this.classpath);
        }
        d.a aVar = this.sysProperties;
        if (aVar != null) {
            dVar.b(aVar);
        }
        m mVar = new m(qVar);
        h e11 = mVar.e();
        Long l11 = this.timeout;
        g gVar = new g(e11, l11 == null ? null : new i(l11.longValue()));
        gVar.o(qVar.getProject());
        if (x00.a.a("openvms")) {
            setupCommandLineForVMS(gVar, dVar.j());
        } else {
            gVar.p(dVar.j());
        }
        try {
            try {
                int f11 = gVar.f();
                mVar.d();
                return f11;
            } catch (IOException e12) {
                throw new BuildException(e12);
            }
        } finally {
            this.timedOut = gVar.l();
        }
    }

    public synchronized boolean killedProcess() {
        return this.timedOut;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object[] objArr = {this.javaCommand.g()};
        try {
            try {
                try {
                    o oVar = this.perm;
                    if (oVar != null) {
                        oVar.j();
                    }
                    this.main.invoke(null, objArr);
                    o oVar2 = this.perm;
                    if (oVar2 != null) {
                        oVar2.i();
                    }
                    synchronized (this) {
                        notifyAll();
                    }
                } catch (InvocationTargetException e11) {
                    Throwable targetException = e11.getTargetException();
                    if (!(targetException instanceof InterruptedException)) {
                        this.caught = targetException;
                    }
                    o oVar3 = this.perm;
                    if (oVar3 != null) {
                        oVar3.i();
                    }
                    synchronized (this) {
                        notifyAll();
                    }
                }
            } catch (Throwable th2) {
                this.caught = th2;
                o oVar4 = this.perm;
                if (oVar4 != null) {
                    oVar4.i();
                }
                synchronized (this) {
                    notifyAll();
                }
            }
        } catch (Throwable th3) {
            o oVar5 = this.perm;
            if (oVar5 != null) {
                oVar5.i();
            }
            synchronized (this) {
                notifyAll();
                throw th3;
            }
        }
    }

    public void setClasspath(org.apache.tools.ant.types.m mVar) {
        this.classpath = mVar;
    }

    public void setJavaCommand(org.apache.tools.ant.types.c cVar) {
        this.javaCommand = cVar;
    }

    public void setOutput(PrintStream printStream) {
    }

    public void setPermissions(o oVar) {
        this.perm = oVar;
    }

    public void setSystemProperties(d.a aVar) {
        this.sysProperties = aVar;
    }

    public void setTimeout(Long l11) {
        this.timeout = l11;
    }

    @Override // org.apache.tools.ant.util.r
    public synchronized void timeoutOccured(Watchdog watchdog) {
        try {
            if (this.thread != null) {
                this.timedOut = true;
                this.thread.interrupt();
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
