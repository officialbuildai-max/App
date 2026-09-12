package com.transsion.push.service;

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
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h, reason: collision with root package name */
    static final Object f50929h = new Object();

    /* renamed from: i, reason: collision with root package name */
    static final HashMap f50930i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    b f50931a;

    /* renamed from: b, reason: collision with root package name */
    h f50932b;

    /* renamed from: c, reason: collision with root package name */
    a f50933c;

    /* renamed from: d, reason: collision with root package name */
    boolean f50934d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f50935e = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f50936f = false;

    /* renamed from: g, reason: collision with root package name */
    final ArrayList f50937g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
                try {
                    JobIntentService.this.e(a11.getIntent());
                    a11.a();
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.f();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b {
        IBinder a();

        e b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends h {

        /* renamed from: d, reason: collision with root package name */
        private final Context f50939d;

        /* renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f50940e;

        /* renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f50941f;

        /* renamed from: g, reason: collision with root package name */
        boolean f50942g;

        /* renamed from: h, reason: collision with root package name */
        boolean f50943h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f50939d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f50940e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f50941f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // com.transsion.push.service.JobIntentService.h
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f50954a);
            if (this.f50939d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f50942g) {
                            this.f50942g = true;
                            if (!this.f50943h) {
                                this.f50940e.acquire(60000L);
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void c() {
            synchronized (this) {
                try {
                    if (this.f50943h) {
                        if (this.f50942g) {
                            this.f50940e.acquire(60000L);
                        }
                        this.f50943h = false;
                        this.f50941f.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void d() {
            synchronized (this) {
                try {
                    if (!this.f50943h) {
                        this.f50943h = true;
                        this.f50941f.acquire(600000L);
                        this.f50940e.release();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.transsion.push.service.JobIntentService.h
        public void e() {
            synchronized (this) {
                this.f50942g = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    final class d implements e {

        /* renamed from: a, reason: collision with root package name */
        final Intent f50944a;

        /* renamed from: b, reason: collision with root package name */
        final int f50945b;

        d(Intent intent, int i11) {
            this.f50944a = intent;
            this.f50945b = i11;
        }

        @Override // com.transsion.push.service.JobIntentService.e
        public void a() {
            JobIntentService.this.stopSelf(this.f50945b);
        }

        @Override // com.transsion.push.service.JobIntentService.e
        public Intent getIntent() {
            return this.f50944a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* loaded from: classes6.dex */
    static final class f extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        final JobIntentService f50947a;

        /* renamed from: b, reason: collision with root package name */
        final Object f50948b;

        /* renamed from: c, reason: collision with root package name */
        JobParameters f50949c;

        /* loaded from: classes6.dex */
        final class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final JobWorkItem f50950a;

            a(JobWorkItem jobWorkItem) {
                this.f50950a = jobWorkItem;
            }

            @Override // com.transsion.push.service.JobIntentService.e
            public void a() {
                synchronized (f.this.f50948b) {
                    JobParameters jobParameters = f.this.f50949c;
                    if (jobParameters != null) {
                        try {
                            jobParameters.completeWork(this.f50950a);
                        } catch (IllegalArgumentException e11) {
                            Log.e("JobServiceEngineImpl", "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e11);
                        } catch (SecurityException e12) {
                            Log.e("JobServiceEngineImpl", "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e12);
                        }
                    }
                }
            }

            @Override // com.transsion.push.service.JobIntentService.e
            public Intent getIntent() {
                Intent intent;
                intent = this.f50950a.getIntent();
                return intent;
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f50948b = new Object();
            this.f50947a = jobIntentService;
        }

        @Override // com.transsion.push.service.JobIntentService.b
        public IBinder a() {
            IBinder binder;
            binder = getBinder();
            return binder;
        }

        @Override // com.transsion.push.service.JobIntentService.b
        public e b() {
            JobWorkItem dequeueWork;
            Intent intent;
            synchronized (this.f50948b) {
                JobParameters jobParameters = this.f50949c;
                if (jobParameters == null) {
                    return null;
                }
                try {
                    dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    intent = dequeueWork.getIntent();
                    intent.setExtrasClassLoader(this.f50947a.getClassLoader());
                    return new a(dequeueWork);
                } catch (SecurityException e11) {
                    Log.e("JobServiceEngineImpl", "Failed to run mParams.dequeueWork()!", e11);
                    return null;
                }
            }
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f50949c = jobParameters;
            this.f50947a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b11 = this.f50947a.b();
            synchronized (this.f50948b) {
                this.f50949c = null;
            }
            return b11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class g extends h {

        /* renamed from: d, reason: collision with root package name */
        private final JobInfo f50952d;

        /* renamed from: e, reason: collision with root package name */
        private final JobScheduler f50953e;

        g(Context context, ComponentName componentName, int i11) {
            super(componentName);
            b(i11);
            this.f50952d = new JobInfo.Builder(i11, this.f50954a).setOverrideDeadline(0L).build();
            this.f50953e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // com.transsion.push.service.JobIntentService.h
        void a(Intent intent) {
            this.f50953e.enqueue(this.f50952d, com.transsion.push.service.c.a(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f50954a;

        /* renamed from: b, reason: collision with root package name */
        boolean f50955b;

        /* renamed from: c, reason: collision with root package name */
        int f50956c;

        h(ComponentName componentName) {
            this.f50954a = componentName;
        }

        abstract void a(Intent intent);

        void b(int i11) {
            if (!this.f50955b) {
                this.f50955b = true;
                this.f50956c = i11;
            } else {
                if (this.f50956c == i11) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i11 + " is different than previous " + this.f50956c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f50937g = null;
        } else {
            this.f50937g = new ArrayList();
        }
    }

    static h d(Context context, ComponentName componentName, boolean z10, int i11) {
        h cVar;
        HashMap hashMap = f50930i;
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

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i11, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f50929h) {
            h d11 = d(context, componentName, true, i11);
            d11.b(i11);
            try {
                d11.a(intent);
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class cls, int i11, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, (Class<?>) cls), i11, intent);
    }

    e a() {
        b bVar = this.f50931a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f50937g) {
            try {
                if (this.f50937g.size() <= 0) {
                    return null;
                }
                return (e) this.f50937g.remove(0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    boolean b() {
        a aVar = this.f50933c;
        if (aVar != null) {
            aVar.cancel(this.f50934d);
        }
        this.f50935e = true;
        return onStopCurrentWork();
    }

    void c(boolean z10) {
        if (this.f50933c == null) {
            this.f50933c = new a();
            h hVar = this.f50932b;
            if (hVar != null && z10) {
                hVar.d();
            }
            try {
                this.f50933c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e11) {
                Log.e("JobIntentService", "RejectedExecutionException: rejected from java.util.concurrent.ThreadPoolExecutor", e11);
            }
        }
    }

    protected abstract void e(Intent intent);

    void f() {
        ArrayList arrayList = this.f50937g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f50933c = null;
                    ArrayList arrayList2 = this.f50937g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        c(false);
                    } else if (!this.f50936f) {
                        this.f50932b.c();
                    }
                } finally {
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f50935e;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.f50931a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f50931a = new f(this);
            this.f50932b = null;
        } else {
            this.f50931a = null;
            this.f50932b = d(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f50937g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f50936f = true;
                this.f50932b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        if (this.f50937g == null) {
            return 2;
        }
        this.f50932b.e();
        synchronized (this.f50937g) {
            ArrayList arrayList = this.f50937g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i12));
            c(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z10) {
        this.f50934d = z10;
    }
}
