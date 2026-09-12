package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ConfigRealtimeHttpClient {

    /* renamed from: q, reason: collision with root package name */
    static final int[] f32518q = {2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f32519r = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* renamed from: a, reason: collision with root package name */
    private final Set f32520a;

    /* renamed from: c, reason: collision with root package name */
    private int f32522c;

    /* renamed from: g, reason: collision with root package name */
    private final ScheduledExecutorService f32526g;

    /* renamed from: h, reason: collision with root package name */
    private final ConfigFetchHandler f32527h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.firebase.f f32528i;

    /* renamed from: j, reason: collision with root package name */
    private final jc.e f32529j;

    /* renamed from: k, reason: collision with root package name */
    e f32530k;

    /* renamed from: l, reason: collision with root package name */
    private final Context f32531l;

    /* renamed from: m, reason: collision with root package name */
    private final String f32532m;

    /* renamed from: p, reason: collision with root package name */
    private final n f32535p;

    /* renamed from: f, reason: collision with root package name */
    private final int f32525f = 8;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32521b = false;

    /* renamed from: n, reason: collision with root package name */
    private final Random f32533n = new Random();

    /* renamed from: o, reason: collision with root package name */
    private final Clock f32534o = DefaultClock.getInstance();

    /* renamed from: d, reason: collision with root package name */
    private boolean f32523d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32524e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements yc.c {
        a() {
        }

        @Override // yc.c
        public void a(FirebaseRemoteConfigException firebaseRemoteConfigException) {
            ConfigRealtimeHttpClient.this.j();
            ConfigRealtimeHttpClient.this.u(firebaseRemoteConfigException);
        }

        @Override // yc.c
        public void b(yc.b bVar) {
        }
    }

    public ConfigRealtimeHttpClient(com.google.firebase.f fVar, jc.e eVar, ConfigFetchHandler configFetchHandler, e eVar2, Context context, String str, Set set, n nVar, ScheduledExecutorService scheduledExecutorService) {
        this.f32520a = set;
        this.f32526g = scheduledExecutorService;
        this.f32522c = Math.max(8 - nVar.h().b(), 1);
        this.f32528i = fVar;
        this.f32527h = configFetchHandler;
        this.f32529j = eVar;
        this.f32530k = eVar2;
        this.f32531l = context;
        this.f32532m = str;
        this.f32535p = nVar;
    }

    private void D(Date date) {
        int b11 = this.f32535p.h().b() + 1;
        this.f32535p.o(b11, new Date(date.getTime() + m(b11)));
    }

    private synchronized boolean f() {
        boolean z10;
        if (!this.f32520a.isEmpty() && !this.f32521b && !this.f32523d) {
            z10 = this.f32524e ? false : true;
        }
        return z10;
    }

    private JSONObject i(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("project", k(this.f32528i.n().c()));
        hashMap.put("namespace", this.f32532m);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.f32527h.r()));
        hashMap.put("appId", this.f32528i.n().c());
        hashMap.put("sdkVersion", "22.0.1");
        hashMap.put(TmcConstants.EXTRA_APP_INSTANCE_ID, str);
        return new JSONObject(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        this.f32523d = true;
    }

    private static String k(String str) {
        Matcher matcher = f32519r.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String l() {
        try {
            Context context = this.f32531l;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f32531l.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No such package: ");
            sb2.append(this.f32531l.getPackageName());
            return null;
        }
    }

    private long m(int i11) {
        int length = f32518q.length;
        if (i11 >= length) {
            i11 = length;
        }
        return (TimeUnit.MINUTES.toMillis(r0[i11 - 1]) / 2) + this.f32533n.nextInt((int) r0);
    }

    private String n(String str) {
        return String.format("https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/%s/namespaces/%s:streamFetchInvalidations", k(this.f32528i.n().c()), str);
    }

    private URL o() {
        try {
            return new URL(n(this.f32532m));
        } catch (MalformedURLException unused) {
            Log.e("FirebaseRemoteConfig", "URL is malformed");
            return null;
        }
    }

    private boolean p(int i11) {
        return i11 == 408 || i11 == 429 || i11 == 502 || i11 == 503 || i11 == 504;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task q(Task task, Task task2) {
        Integer num;
        Throwable th2;
        HttpURLConnection httpURLConnection;
        FirebaseRemoteConfigServerException firebaseRemoteConfigServerException;
        int responseCode;
        boolean p11;
        try {
        } catch (IOException unused) {
            httpURLConnection = null;
            num = null;
        } catch (Throwable th3) {
            num = null;
            th2 = th3;
            httpURLConnection = null;
        }
        if (!task.isSuccessful()) {
            throw new IOException(task.getException());
        }
        y(true);
        httpURLConnection = (HttpURLConnection) task.getResult();
        try {
            responseCode = httpURLConnection.getResponseCode();
            num = Integer.valueOf(responseCode);
            if (responseCode == 200) {
                try {
                    v();
                    this.f32535p.j();
                    B(httpURLConnection).i();
                } catch (IOException unused2) {
                    g(httpURLConnection);
                    y(false);
                    boolean z10 = num == null || p(num.intValue());
                    if (z10) {
                        D(new Date(this.f32534o.currentTimeMillis()));
                    }
                    if (!z10 && num.intValue() != 200) {
                        String format = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                        if (num.intValue() == 403) {
                            format = t(httpURLConnection.getErrorStream());
                        }
                        firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(num.intValue(), format, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                        u(firebaseRemoteConfigServerException);
                        return Tasks.forResult(null);
                    }
                    w();
                    return Tasks.forResult(null);
                } catch (Throwable th4) {
                    th2 = th4;
                    g(httpURLConnection);
                    y(false);
                    boolean z11 = num == null || p(num.intValue());
                    if (z11) {
                        D(new Date(this.f32534o.currentTimeMillis()));
                    }
                    if (z11 || num.intValue() == 200) {
                        w();
                    } else {
                        String format2 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                        if (num.intValue() == 403) {
                            format2 = t(httpURLConnection.getErrorStream());
                        }
                        u(new FirebaseRemoteConfigServerException(num.intValue(), format2, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                    }
                    throw th2;
                }
            }
            g(httpURLConnection);
            y(false);
            p11 = p(responseCode);
            if (p11) {
                D(new Date(this.f32534o.currentTimeMillis()));
            }
        } catch (IOException unused3) {
            num = null;
        } catch (Throwable th5) {
            num = null;
            th2 = th5;
        }
        if (!p11 && responseCode != 200) {
            String format3 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
            if (responseCode == 403) {
                format3 = t(httpURLConnection.getErrorStream());
            }
            firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(responseCode, format3, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
            u(firebaseRemoteConfigServerException);
            return Tasks.forResult(null);
        }
        w();
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task r(Task task, Task task2, Task task3) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) o().openConnection();
            A(httpURLConnection, (String) task2.getResult(), ((com.google.firebase.installations.f) task.getResult()).b());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e11) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", e11));
        }
    }

    private synchronized void s(long j11) {
        try {
            if (f()) {
                int i11 = this.f32522c;
                if (i11 > 0) {
                    this.f32522c = i11 - 1;
                    this.f32526g.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ConfigRealtimeHttpClient.this.e();
                        }
                    }, j11, TimeUnit.MILLISECONDS);
                } else if (!this.f32524e) {
                    u(new FirebaseRemoteConfigClientException("Unable to connect to the server. Check your connection and try again.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private String t(InputStream inputStream) {
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
        } catch (IOException unused) {
            if (sb2.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator it = this.f32520a.iterator();
        while (it.hasNext()) {
            ((yc.c) it.next()).a(firebaseRemoteConfigException);
        }
    }

    private synchronized void v() {
        this.f32522c = 8;
    }

    private void x(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str);
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f32528i.n().b());
        httpURLConnection.setRequestProperty("X-Android-Package", this.f32531l.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", l());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Accept-Response-Streaming", "true");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    private synchronized void y(boolean z10) {
        this.f32521b = z10;
    }

    public void A(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setRequestMethod("POST");
        x(httpURLConnection, str2);
        byte[] bytes = i(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public synchronized ConfigAutoFetch B(HttpURLConnection httpURLConnection) {
        return new ConfigAutoFetch(httpURLConnection, this.f32527h, this.f32530k, this.f32520a, new a(), this.f32526g);
    }

    public void C() {
        s(0L);
    }

    public void e() {
        if (f()) {
            if (new Date(this.f32534o.currentTimeMillis()).before(this.f32535p.h().a())) {
                w();
            } else {
                final Task h11 = h();
                Tasks.whenAllComplete((Task<?>[]) new Task[]{h11}).continueWith(this.f32526g, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.p
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        Task q11;
                        q11 = ConfigRealtimeHttpClient.this.q(h11, task);
                        return q11;
                    }
                });
            }
        }
    }

    public void g(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public Task h() {
        final Task a11 = this.f32529j.a(false);
        final Task id2 = this.f32529j.getId();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{a11, id2}).continueWithTask(this.f32526g, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.q
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task r11;
                r11 = ConfigRealtimeHttpClient.this.r(a11, id2, task);
                return r11;
            }
        });
    }

    public synchronized void w() {
        s(Math.max(0L, this.f32535p.h().a().getTime() - new Date(this.f32534o.currentTimeMillis()).getTime()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z10) {
        this.f32524e = z10;
    }
}
