package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class SyncTask implements Runnable {
    private final FirebaseMessaging firebaseMessaging;
    private final long nextDelaySeconds;

    @SuppressLint({"ThreadPoolCreation"})
    ExecutorService processorExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
    private final PowerManager.WakeLock syncWakeLock;

    /* loaded from: classes4.dex */
    static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private SyncTask f32066a;

        /* renamed from: b, reason: collision with root package name */
        private Context f32067b;

        public a(SyncTask syncTask) {
            this.f32066a = syncTask;
        }

        public void a() {
            SyncTask.isDebugLogEnabled();
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            SyncTask syncTask = this.f32066a;
            if (syncTask != null) {
                Context context = syncTask.getContext();
                this.f32067b = context;
                context.registerReceiver(this, intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f32066a;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                SyncTask.isDebugLogEnabled();
                this.f32066a.firebaseMessaging.n(this.f32066a, 0L);
                Context context2 = this.f32067b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f32066a = null;
            }
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public SyncTask(FirebaseMessaging firebaseMessaging, long j11) {
        this.firebaseMessaging = firebaseMessaging;
        this.nextDelaySeconds = j11;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean isDebugLogEnabled() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    Context getContext() {
        return this.firebaseMessaging.o();
    }

    boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    boolean maybeRefreshToken() throws IOException {
        try {
            if (this.firebaseMessaging.m() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            Log.isLoggable("FirebaseMessaging", 3);
            return true;
        } catch (IOException e11) {
            if (!e0.h(e11.getMessage())) {
                if (e11.getMessage() != null) {
                    throw e11;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e11.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (v0.b().e(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            try {
                this.firebaseMessaging.K(true);
            } catch (IOException e11) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e11.getMessage() + ". Won't retry the operation.");
                this.firebaseMessaging.K(false);
                if (!v0.b().e(getContext())) {
                    return;
                }
            }
            if (!this.firebaseMessaging.z()) {
                this.firebaseMessaging.K(false);
                if (v0.b().e(getContext())) {
                    this.syncWakeLock.release();
                    return;
                }
                return;
            }
            if (v0.b().d(getContext()) && !isDeviceConnected()) {
                new a(this).a();
                if (v0.b().e(getContext())) {
                    this.syncWakeLock.release();
                    return;
                }
                return;
            }
            if (maybeRefreshToken()) {
                this.firebaseMessaging.K(false);
            } else {
                this.firebaseMessaging.P(this.nextDelaySeconds);
            }
            if (!v0.b().e(getContext())) {
                return;
            }
            this.syncWakeLock.release();
        } catch (Throwable th2) {
            if (v0.b().e(getContext())) {
                this.syncWakeLock.release();
            }
            throw th2;
        }
    }
}
