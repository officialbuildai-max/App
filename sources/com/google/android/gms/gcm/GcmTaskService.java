package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gcm.zzq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private ComponentName componentName;
    private final Object lock = new Object();
    private com.google.android.gms.internal.gcm.zzl zzg;
    private int zzu;
    private ExecutorService zzv;
    private Messenger zzw;
    private GcmNetworkManager zzx;

    @VisibleForTesting
    @TargetApi(21)
    /* loaded from: classes3.dex */
    class zzd extends com.google.android.gms.internal.gcm.zzj {
        zzd(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Messenger messenger;
            if (!UidVerifier.uidHasPackageName(GcmTaskService.this, message.sendingUid, "com.google.android.gms")) {
                Log.e("GcmTaskService", "unable to verify presence of Google Play Services");
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                Bundle data = message.getData();
                if (data.isEmpty() || (messenger = message.replyTo) == null) {
                    return;
                }
                String string = data.getString("tag");
                ArrayList parcelableArrayList = data.getParcelableArrayList("triggered_uris");
                long j11 = data.getLong("max_exec_duration", 180L);
                if (GcmTaskService.this.zzg(string)) {
                    return;
                }
                GcmTaskService.this.zzd(new zze(string, messenger, data.getBundle("extras"), j11, parcelableArrayList));
                return;
            }
            if (i11 == 2) {
                if (Log.isLoggable("GcmTaskService", 3)) {
                    String valueOf = String.valueOf(message);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 45);
                    sb2.append("ignoring unimplemented stop message for now: ");
                    sb2.append(valueOf);
                    return;
                }
                return;
            }
            if (i11 == 4) {
                GcmTaskService.this.onInitializeTasks();
                return;
            }
            String valueOf2 = String.valueOf(message);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 31);
            sb3.append("Unrecognized message received: ");
            sb3.append(valueOf2);
            Log.e("GcmTaskService", sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class zze implements Runnable {
        private final Bundle extras;
        private final String tag;
        private final List<Uri> zzaa;
        private final long zzab;

        @Nullable
        private final zzg zzac;

        @Nullable
        private final Messenger zzad;

        zze(String str, @NonNull IBinder iBinder, Bundle bundle, long j11, List<Uri> list) {
            zzg zzhVar;
            this.tag = str;
            if (iBinder == null) {
                zzhVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                zzhVar = queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zzh(iBinder);
            }
            this.zzac = zzhVar;
            this.extras = bundle;
            this.zzab = j11;
            this.zzaa = list;
            this.zzad = null;
        }

        zze(String str, @NonNull Messenger messenger, Bundle bundle, long j11, List<Uri> list) {
            this.tag = str;
            this.zzad = messenger;
            this.extras = bundle;
            this.zzab = j11;
            this.zzaa = list;
            this.zzac = null;
        }

        private static /* synthetic */ void zzd(Throwable th2, zzp zzpVar) {
            if (th2 == null) {
                zzpVar.close();
                return;
            }
            try {
                zzpVar.close();
            } catch (Throwable th3) {
                zzq.zzd(th2, th3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(int i11) {
            synchronized (GcmTaskService.this.lock) {
                try {
                    try {
                        try {
                        } catch (RemoteException unused) {
                            String valueOf = String.valueOf(this.tag);
                            Log.e("GcmTaskService", valueOf.length() != 0 ? "Error reporting result of operation to scheduler for ".concat(valueOf) : new String("Error reporting result of operation to scheduler for "));
                            GcmTaskService.this.zzx.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                            if (!zzg() && !GcmTaskService.this.zzx.zzf(GcmTaskService.this.componentName.getClassName())) {
                                GcmTaskService gcmTaskService = GcmTaskService.this;
                                gcmTaskService.stopSelf(gcmTaskService.zzu);
                            }
                        }
                        if (GcmTaskService.this.zzx.zzf(this.tag, GcmTaskService.this.componentName.getClassName())) {
                            GcmTaskService.this.zzx.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                            if (!zzg() && !GcmTaskService.this.zzx.zzf(GcmTaskService.this.componentName.getClassName())) {
                                GcmTaskService gcmTaskService2 = GcmTaskService.this;
                                gcmTaskService2.stopSelf(gcmTaskService2.zzu);
                            }
                            return;
                        }
                        if (zzg()) {
                            Messenger messenger = this.zzad;
                            Message obtain = Message.obtain();
                            obtain.what = 3;
                            obtain.arg1 = i11;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("component", GcmTaskService.this.componentName);
                            bundle.putString("tag", this.tag);
                            obtain.setData(bundle);
                            messenger.send(obtain);
                        } else {
                            this.zzac.zzf(i11);
                        }
                        GcmTaskService.this.zzx.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                        if (!zzg() && !GcmTaskService.this.zzx.zzf(GcmTaskService.this.componentName.getClassName())) {
                            GcmTaskService gcmTaskService3 = GcmTaskService.this;
                            gcmTaskService3.stopSelf(gcmTaskService3.zzu);
                        }
                    } catch (Throwable th2) {
                        GcmTaskService.this.zzx.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                        if (!zzg() && !GcmTaskService.this.zzx.zzf(GcmTaskService.this.componentName.getClassName())) {
                            GcmTaskService gcmTaskService4 = GcmTaskService.this;
                            gcmTaskService4.stopSelf(gcmTaskService4.zzu);
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }

        private final boolean zzg() {
            return this.zzad != null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String valueOf = String.valueOf(this.tag);
            zzp zzpVar = new zzp(valueOf.length() != 0 ? "nts:client:onRunTask:".concat(valueOf) : new String("nts:client:onRunTask:"));
            try {
                TaskParams taskParams = new TaskParams(this.tag, this.extras, this.zzab, this.zzaa);
                GcmTaskService.this.zzg.zzd("onRunTask", com.google.android.gms.internal.gcm.zzp.zzdo);
                try {
                    zze(GcmTaskService.this.onRunTask(taskParams));
                    zzd((Throwable) null, zzpVar);
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    zzd(th2, zzpVar);
                    throw th3;
                }
            }
        }
    }

    private final void zzd(int i11) {
        synchronized (this.lock) {
            try {
                this.zzu = i11;
                if (!this.zzx.zzf(this.componentName.getClassName())) {
                    stopSelf(this.zzu);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(zze zzeVar) {
        try {
            this.zzv.execute(zzeVar);
        } catch (RejectedExecutionException e11) {
            Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e11);
            zzeVar.zze(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzg(String str) {
        boolean z10;
        synchronized (this.lock) {
            try {
                boolean zzd2 = this.zzx.zzd(str, this.componentName.getClassName());
                z10 = !zzd2;
                if (!zzd2) {
                    String packageName = getPackageName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 44 + String.valueOf(str).length());
                    sb2.append(packageName);
                    sb2.append(" ");
                    sb2.append(str);
                    sb2.append(": Task already running, won't start another");
                    Log.w("GcmTaskService", sb2.toString());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastLollipop() && SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) {
            return this.zzw.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.zzx = GcmNetworkManager.getInstance(this);
        this.zzv = com.google.android.gms.internal.gcm.zzg.zzaa().zzd(10, new com.google.android.gms.gcm.zze(this), 10);
        this.zzw = new Messenger(new zzd(Looper.getMainLooper()));
        this.componentName = new ComponentName(this, getClass());
        com.google.android.gms.internal.gcm.zzm.zzab();
        this.zzg = com.google.android.gms.internal.gcm.zzm.zzdk;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        List<Runnable> shutdownNow = this.zzv.shutdownNow();
        if (shutdownNow.isEmpty()) {
            return;
        }
        int size = shutdownNow.size();
        StringBuilder sb2 = new StringBuilder(79);
        sb2.append("Shutting down, but not all tasks are finished executing. Remaining: ");
        sb2.append(size);
        Log.e("GcmTaskService", sb2.toString());
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        if (intent == null) {
            return 2;
        }
        try {
            intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
            String action = intent.getAction();
            if (SERVICE_ACTION_EXECUTE_TASK.equals(action)) {
                String stringExtra = intent.getStringExtra("tag");
                Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                Bundle bundleExtra = intent.getBundleExtra("extras");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                long longExtra = intent.getLongExtra("max_exec_duration", 180L);
                if (!(parcelableExtra instanceof PendingCallback)) {
                    String packageName = getPackageName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 47 + String.valueOf(stringExtra).length());
                    sb2.append(packageName);
                    sb2.append(" ");
                    sb2.append(stringExtra);
                    sb2.append(": Could not process request, invalid callback.");
                    Log.e("GcmTaskService", sb2.toString());
                    return 2;
                }
                if (zzg(stringExtra)) {
                    return 2;
                }
                zzd(new zze(stringExtra, ((PendingCallback) parcelableExtra).zzan, bundleExtra, longExtra, parcelableArrayListExtra));
            } else if (SERVICE_ACTION_INITIALIZE.equals(action)) {
                onInitializeTasks();
            } else {
                StringBuilder sb3 = new StringBuilder(String.valueOf(action).length() + 37);
                sb3.append("Unknown action received ");
                sb3.append(action);
                sb3.append(", terminating");
                Log.e("GcmTaskService", sb3.toString());
            }
            return 2;
        } finally {
            zzd(i12);
        }
    }
}
