package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h, reason: collision with root package name */
    static final Object f8021h = new Object();

    /* renamed from: i, reason: collision with root package name */
    static final HashMap f8022i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    b f8023a;

    /* renamed from: b, reason: collision with root package name */
    h f8024b;

    /* renamed from: c, reason: collision with root package name */
    a f8025c;

    /* renamed from: d, reason: collision with root package name */
    boolean f8026d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f8027e = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f8028f = false;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList f8029g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends AsyncTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a11 = JobIntentService.this.a();
                if (a11 == null) {
                    return null;
                }
                JobIntentService.this.e(a11.getIntent());
                a11.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        IBinder a();

        e b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        private final Context f8031d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f8032e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f8033f;

        /* renamed from: g, reason: collision with root package name */
        boolean f8034g;

        /* renamed from: h, reason: collision with root package name */
        boolean f8035h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f8031d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f8032e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f8033f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        public void b() {
            synchronized (this) {
                try {
                    if (this.f8035h) {
                        if (this.f8034g) {
                            this.f8032e.acquire(60000L);
                        }
                        this.f8035h = false;
                        this.f8033f.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                try {
                    if (!this.f8035h) {
                        this.f8035h = true;
                        this.f8033f.acquire(600000L);
                        this.f8032e.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                this.f8034g = false;
            }
        }
    }

    /* loaded from: classes.dex */
    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f8036a;

        /* renamed from: b, reason: collision with root package name */
        final int f8037b;

        d(Intent intent, int i11) {
            this.f8036a = intent;
            this.f8037b = i11;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f8037b);
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f8036a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* loaded from: classes.dex */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f8039a;

        /* renamed from: b, reason: collision with root package name */
        final Object f8040b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f8041c;

        /* loaded from: classes.dex */
        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f8042a;

            a(JobWorkItem jobWorkItem) {
                this.f8042a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public void a() {
                synchronized (f.this.f8040b) {
                    try {
                        JobParameters jobParameters = f.this.f8041c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f8042a);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                Intent intent;
                intent = this.f8042a.getIntent();
                return intent;
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f8040b = new Object();
            this.f8039a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            IBinder binder;
            binder = getBinder();
            return binder;
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            JobWorkItem dequeueWork;
            Intent intent;
            synchronized (this.f8040b) {
                try {
                    JobParameters jobParameters = this.f8041c;
                    if (jobParameters == null) {
                        return null;
                    }
                    dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    intent = dequeueWork.getIntent();
                    intent.setExtrasClassLoader(this.f8039a.getClassLoader());
                    return new a(dequeueWork);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f8041c = jobParameters;
            this.f8039a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b11 = this.f8039a.b();
            synchronized (this.f8040b) {
                this.f8041c = null;
            }
            return b11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f8044d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f8045e;

        g(Context context, ComponentName componentName, int i11) {
            super(componentName);
            a(i11);
            this.f8044d = new JobInfo.Builder(i11, this.f8046a).setOverrideDeadline(0L).build();
            this.f8045e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f8046a;

        /* renamed from: b, reason: collision with root package name */
        boolean f8047b;

        /* renamed from: c, reason: collision with root package name */
        int f8048c;

        h(ComponentName componentName) {
            this.f8046a = componentName;
        }

        void a(int i11) {
            if (!this.f8047b) {
                this.f8047b = true;
                this.f8048c = i11;
            } else {
                if (this.f8048c == i11) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i11 + " is different than previous " + this.f8048c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8029g = null;
        } else {
            this.f8029g = new ArrayList();
        }
    }

    static h d(Context context, ComponentName componentName, boolean z10, int i11) {
        h cVar;
        HashMap hashMap = f8022i;
        h hVar = (h) hashMap.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                cVar = new c(context, componentName);
            } else {
                if (!z10) {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
                cVar = new g(context, componentName, i11);
            }
            hVar = cVar;
            hashMap.put(componentName, hVar);
        }
        return hVar;
    }

    e a() {
        b bVar = this.f8023a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f8029g) {
            try {
                if (this.f8029g.size() <= 0) {
                    return null;
                }
                return (e) this.f8029g.remove(0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    boolean b() {
        a aVar = this.f8025c;
        if (aVar != null) {
            aVar.cancel(this.f8026d);
        }
        this.f8027e = true;
        return f();
    }

    void c(boolean z10) {
        if (this.f8025c == null) {
            this.f8025c = new a();
            h hVar = this.f8024b;
            if (hVar != null && z10) {
                hVar.c();
            }
            this.f8025c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    protected abstract void e(Intent intent);

    public boolean f() {
        return true;
    }

    void g() {
        ArrayList arrayList = this.f8029g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f8025c = null;
                    ArrayList arrayList2 = this.f8029g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f8028f) {
                        this.f8024b.b();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f8023a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8023a = new f(this);
            this.f8024b = null;
        } else {
            this.f8023a = null;
            this.f8024b = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f8029g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f8028f = true;
                this.f8024b.b();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        if (this.f8029g == null) {
            return 2;
        }
        this.f8024b.d();
        synchronized (this.f8029g) {
            ArrayList arrayList = this.f8029g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i12));
            c(true);
        }
        return 3;
    }
}
