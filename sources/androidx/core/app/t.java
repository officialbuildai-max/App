package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import e.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: d, reason: collision with root package name */
    private static String f8166d;

    /* renamed from: g, reason: collision with root package name */
    private static d f8169g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f8170a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f8171b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f8165c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static Set f8167e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f8168f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final String f8172a;

        /* renamed from: b, reason: collision with root package name */
        final int f8173b;

        /* renamed from: c, reason: collision with root package name */
        final String f8174c;

        /* renamed from: d, reason: collision with root package name */
        final Notification f8175d;

        b(String str, int i11, String str2, Notification notification) {
            this.f8172a = str;
            this.f8173b = i11;
            this.f8174c = str2;
            this.f8175d = notification;
        }

        @Override // androidx.core.app.t.e
        public void a(e.a aVar) {
            aVar.T0(this.f8172a, this.f8173b, this.f8174c, this.f8175d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f8172a + ", id:" + this.f8173b + ", tag:" + this.f8174c + "]";
        }
    }

    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f8176a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f8177b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f8176a = componentName;
            this.f8177b = iBinder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8178a;

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f8179b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f8180c;

        /* renamed from: d, reason: collision with root package name */
        private final Map f8181d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private Set f8182e = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ComponentName f8183a;

            /* renamed from: c, reason: collision with root package name */
            e.a f8185c;

            /* renamed from: b, reason: collision with root package name */
            boolean f8184b = false;

            /* renamed from: d, reason: collision with root package name */
            ArrayDeque f8186d = new ArrayDeque();

            /* renamed from: e, reason: collision with root package name */
            int f8187e = 0;

            a(ComponentName componentName) {
                this.f8183a = componentName;
            }
        }

        d(Context context) {
            this.f8178a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f8179b = handlerThread;
            handlerThread.start();
            this.f8180c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f8184b) {
                return true;
            }
            boolean bindService = this.f8178a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f8183a), this, 33);
            aVar.f8184b = bindService;
            if (bindService) {
                aVar.f8187e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f8183a);
                this.f8178a.unbindService(this);
            }
            return aVar.f8184b;
        }

        private void b(a aVar) {
            if (aVar.f8184b) {
                this.f8178a.unbindService(this);
                aVar.f8184b = false;
            }
            aVar.f8185c = null;
        }

        private void c(e eVar) {
            j();
            for (a aVar : this.f8181d.values()) {
                aVar.f8186d.add(eVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = (a) this.f8181d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f8181d.get(componentName);
            if (aVar != null) {
                aVar.f8185c = a.AbstractBinderC0762a.Y0(iBinder);
                aVar.f8187e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = (a) this.f8181d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Processing component ");
                sb2.append(aVar.f8183a);
                sb2.append(", ");
                sb2.append(aVar.f8186d.size());
                sb2.append(" queued tasks");
            }
            if (aVar.f8186d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f8185c == null) {
                i(aVar);
                return;
            }
            while (true) {
                e eVar = (e) aVar.f8186d.peek();
                if (eVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Sending task ");
                        sb3.append(eVar);
                    }
                    eVar.a(aVar.f8185c);
                    aVar.f8186d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Remote service has died: ");
                        sb4.append(aVar.f8183a);
                    }
                } catch (RemoteException e11) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f8183a, e11);
                }
            }
            if (aVar.f8186d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f8180c.hasMessages(3, aVar.f8183a)) {
                return;
            }
            int i11 = aVar.f8187e;
            int i12 = i11 + 1;
            aVar.f8187e = i12;
            if (i12 <= 6) {
                int i13 = (1 << i11) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Scheduling retry for ");
                    sb2.append(i13);
                    sb2.append(" ms");
                }
                this.f8180c.sendMessageDelayed(this.f8180c.obtainMessage(3, aVar.f8183a), i13);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f8186d.size() + " tasks to " + aVar.f8183a + " after " + aVar.f8187e + " retries");
            aVar.f8186d.clear();
        }

        private void j() {
            Set e11 = t.e(this.f8178a);
            if (e11.equals(this.f8182e)) {
                return;
            }
            this.f8182e = e11;
            List<ResolveInfo> queryIntentServices = this.f8178a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (e11.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f8181d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding listener record for ");
                        sb2.append(componentName2);
                    }
                    this.f8181d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f8181d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Removing listener record for ");
                        sb3.append(entry.getKey());
                    }
                    b((a) entry.getValue());
                    it.remove();
                }
            }
        }

        public void h(e eVar) {
            this.f8180c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                c((e) message.obj);
                return true;
            }
            if (i11 == 1) {
                c cVar = (c) message.obj;
                e(cVar.f8176a, cVar.f8177b);
                return true;
            }
            if (i11 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i11 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Connected to service ");
                sb2.append(componentName);
            }
            this.f8180c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Disconnected from service ");
                sb2.append(componentName);
            }
            this.f8180c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        void a(e.a aVar);
    }

    private t(Context context) {
        this.f8170a = context;
        this.f8171b = (NotificationManager) context.getSystemService("notification");
    }

    public static t d(Context context) {
        return new t(context);
    }

    public static Set e(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f8165c) {
            if (string != null) {
                try {
                    if (!string.equals(f8166d)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet.add(unflattenFromString.getPackageName());
                            }
                        }
                        f8167e = hashSet;
                        f8166d = string;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            set = f8167e;
        }
        return set;
    }

    private void h(e eVar) {
        synchronized (f8168f) {
            try {
                if (f8169g == null) {
                    f8169g = new d(this.f8170a.getApplicationContext());
                }
                f8169g.h(eVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean i(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f8171b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f8170a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f8170a.getApplicationInfo();
        String packageName = this.f8170a.getApplicationContext().getPackageName();
        int i11 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i11), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i11) {
        c(null, i11);
    }

    public void c(String str, int i11) {
        this.f8171b.cancel(str, i11);
    }

    public void f(int i11, Notification notification) {
        g(null, i11, notification);
    }

    public void g(String str, int i11, Notification notification) {
        if (!i(notification)) {
            this.f8171b.notify(str, i11, notification);
        } else {
            h(new b(this.f8170a.getPackageName(), i11, str, notification));
            this.f8171b.cancel(str, i11);
        }
    }
}
