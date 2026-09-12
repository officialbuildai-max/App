package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class ConfigAutoFetch {

    /* renamed from: a, reason: collision with root package name */
    private final Set f32488a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpURLConnection f32489b;

    /* renamed from: c, reason: collision with root package name */
    private final ConfigFetchHandler f32490c;

    /* renamed from: d, reason: collision with root package name */
    private final e f32491d;

    /* renamed from: e, reason: collision with root package name */
    private final yc.c f32492e;

    /* renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f32493f;

    /* renamed from: g, reason: collision with root package name */
    private final Random f32494g = new Random();

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, e eVar, Set set, yc.c cVar, ScheduledExecutorService scheduledExecutorService) {
        this.f32489b = httpURLConnection;
        this.f32490c = configFetchHandler;
        this.f32491d = eVar;
        this.f32488a = set;
        this.f32492e = cVar;
        this.f32493f = scheduledExecutorService;
    }

    private void b(final int i11, final long j11) {
        if (i11 == 0) {
            k(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
        } else {
            this.f32493f.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigAutoFetch.this.d(i11, j11);
                }
            }, this.f32494g.nextInt(4), TimeUnit.SECONDS);
        }
    }

    private synchronized void c(yc.b bVar) {
        Iterator it = this.f32488a.iterator();
        while (it.hasNext()) {
            ((yc.c) it.next()).b(bVar);
        }
    }

    private static Boolean e(ConfigFetchHandler.a aVar, long j11) {
        if (aVar.d() != null) {
            return Boolean.valueOf(aVar.d().k() >= j11);
        }
        return Boolean.valueOf(aVar.f() == 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
    
        r5 = new org.json.JSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if (r5.has("featureDisabled") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r5.getBoolean("featureDisabled") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        r9.f32492e.a(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (g() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (r5.has("latestTemplateVersionNumber") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        r6 = r9.f32490c.r();
        r4 = r5.getLong("latestTemplateVersionNumber");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        if (r4 <= r6) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        b(3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f(java.io.InputStream r10) {
        /*
            r9 = this;
            java.lang.String r0 = "latestTemplateVersionNumber"
            java.lang.String r1 = "featureDisabled"
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.lang.String r4 = "utf-8"
            r3.<init>(r10, r4)
            r2.<init>(r3)
            java.lang.String r3 = ""
        L12:
            r4 = r3
        L13:
            java.lang.String r5 = r2.readLine()
            if (r5 == 0) goto L96
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = "}"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L13
            java.lang.String r4 = r9.j(r4)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L3b
            goto L13
        L3b:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L5b
            r5.<init>(r4)     // Catch: org.json.JSONException -> L5b
            boolean r4 = r5.has(r1)     // Catch: org.json.JSONException -> L5b
            if (r4 == 0) goto L5d
            boolean r4 = r5.getBoolean(r1)     // Catch: org.json.JSONException -> L5b
            if (r4 == 0) goto L5d
            yc.c r4 = r9.f32492e     // Catch: org.json.JSONException -> L5b
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch: org.json.JSONException -> L5b
            java.lang.String r6 = "The server is temporarily unavailable. Try again in a few minutes."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE     // Catch: org.json.JSONException -> L5b
            r5.<init>(r6, r7)     // Catch: org.json.JSONException -> L5b
            r4.a(r5)     // Catch: org.json.JSONException -> L5b
            goto L96
        L5b:
            r4 = move-exception
            goto L7d
        L5d:
            boolean r4 = r9.g()     // Catch: org.json.JSONException -> L5b
            if (r4 == 0) goto L64
            goto L96
        L64:
            boolean r4 = r5.has(r0)     // Catch: org.json.JSONException -> L5b
            if (r4 == 0) goto L12
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r4 = r9.f32490c     // Catch: org.json.JSONException -> L5b
            long r6 = r4.r()     // Catch: org.json.JSONException -> L5b
            long r4 = r5.getLong(r0)     // Catch: org.json.JSONException -> L5b
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L12
            r6 = 3
            r9.b(r6, r4)     // Catch: org.json.JSONException -> L5b
            goto L12
        L7d:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.Throwable r6 = r4.getCause()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r8 = "Unable to parse config update message."
            r5.<init>(r8, r6, r7)
            r9.k(r5)
            java.lang.String r5 = "FirebaseRemoteConfig"
            java.lang.String r6 = "Unable to parse latest config update message."
            android.util.Log.e(r5, r6, r4)
            goto L12
        L96:
            r2.close()
            r10.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.f(java.io.InputStream):void");
    }

    private synchronized boolean g() {
        return this.f32488a.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task h(Task task, Task task2, long j11, int i11, Task task3) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.a aVar = (ConfigFetchHandler.a) task.getResult();
        f fVar = (f) task2.getResult();
        if (!e(aVar, j11).booleanValue()) {
            b(i11, j11);
            return Tasks.forResult(null);
        }
        if (aVar.d() == null) {
            return Tasks.forResult(null);
        }
        if (fVar == null) {
            fVar = f.l().a();
        }
        Set f11 = fVar.f(aVar.d());
        if (f11.isEmpty()) {
            return Tasks.forResult(null);
        }
        c(yc.b.a(f11));
        return Tasks.forResult(null);
    }

    private String j(String str) {
        int indexOf = str.indexOf(Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        int lastIndexOf = str.lastIndexOf(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        return (indexOf < 0 || lastIndexOf < 0 || indexOf >= lastIndexOf) ? "" : str.substring(indexOf, lastIndexOf + 1);
    }

    private synchronized void k(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator it = this.f32488a.iterator();
        while (it.hasNext()) {
            ((yc.c) it.next()).a(firebaseRemoteConfigException);
        }
    }

    public synchronized Task d(int i11, final long j11) {
        final int i12;
        final Task n11;
        final Task e11;
        i12 = i11 - 1;
        n11 = this.f32490c.n(ConfigFetchHandler.FetchType.REALTIME, 3 - i12);
        e11 = this.f32491d.e();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{n11, e11}).continueWithTask(this.f32493f, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task h11;
                h11 = ConfigAutoFetch.this.h(n11, e11, j11, i12, task);
                return h11;
            }
        });
    }

    public void i() {
        HttpURLConnection httpURLConnection = this.f32489b;
        if (httpURLConnection == null) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            f(inputStream);
            inputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th2) {
            this.f32489b.disconnect();
            throw th2;
        }
        this.f32489b.disconnect();
    }
}
