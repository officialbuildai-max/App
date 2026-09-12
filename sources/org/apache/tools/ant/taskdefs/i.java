package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.util.Watchdog;
import org.apache.tools.ant.util.r;

/* loaded from: classes7.dex */
public class i implements r {

    /* renamed from: a, reason: collision with root package name */
    private Process f71512a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f71513b = false;

    /* renamed from: c, reason: collision with root package name */
    private Exception f71514c = null;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f71515d = false;

    /* renamed from: e, reason: collision with root package name */
    private Watchdog f71516e;

    public i(long j11) {
        Watchdog watchdog = new Watchdog(j11);
        this.f71516e = watchdog;
        watchdog.addTimeoutObserver(this);
    }

    public synchronized void a() {
        if (this.f71514c != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception in ExecuteWatchdog.run: ");
            stringBuffer.append(this.f71514c.getMessage());
            throw new BuildException(stringBuffer.toString(), this.f71514c);
        }
    }

    protected synchronized void b() {
        this.f71513b = false;
        this.f71512a = null;
    }

    public boolean c() {
        return this.f71515d;
    }

    public synchronized void d(Process process) {
        if (process == null) {
            throw new NullPointerException("process is null.");
        }
        if (this.f71512a != null) {
            throw new IllegalStateException("Already running.");
        }
        this.f71514c = null;
        this.f71515d = false;
        this.f71513b = true;
        this.f71512a = process;
        this.f71516e.start();
    }

    public synchronized void e() {
        this.f71516e.stop();
        b();
    }

    @Override // org.apache.tools.ant.util.r
    public synchronized void timeoutOccured(Watchdog watchdog) {
        try {
            try {
                try {
                    this.f71512a.exitValue();
                } catch (IllegalThreadStateException unused) {
                    if (this.f71513b) {
                        this.f71515d = true;
                        this.f71512a.destroy();
                    }
                }
            } catch (Exception e11) {
                this.f71514c = e11;
            }
        } finally {
            b();
        }
    }
}
