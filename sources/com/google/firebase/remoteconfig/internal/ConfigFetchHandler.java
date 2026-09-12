package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.n;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class ConfigFetchHandler {

    /* renamed from: j, reason: collision with root package name */
    public static final long f32495j = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: k, reason: collision with root package name */
    static final int[] f32496k = {2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: a, reason: collision with root package name */
    private final jc.e f32497a;

    /* renamed from: b, reason: collision with root package name */
    private final ic.b f32498b;

    /* renamed from: c, reason: collision with root package name */
    private final Executor f32499c;

    /* renamed from: d, reason: collision with root package name */
    private final Clock f32500d;

    /* renamed from: e, reason: collision with root package name */
    private final Random f32501e;

    /* renamed from: f, reason: collision with root package name */
    private final e f32502f;

    /* renamed from: g, reason: collision with root package name */
    private final ConfigFetchHttpClient f32503g;

    /* renamed from: h, reason: collision with root package name */
    private final n f32504h;

    /* renamed from: i, reason: collision with root package name */
    private final Map f32505i;

    /* loaded from: classes4.dex */
    public enum FetchType {
        BASE("BASE"),
        REALTIME("REALTIME");

        private final String value;

        FetchType(String str) {
            this.value = str;
        }

        String getValue() {
            return this.value;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Date f32506a;

        /* renamed from: b, reason: collision with root package name */
        private final int f32507b;

        /* renamed from: c, reason: collision with root package name */
        private final f f32508c;

        /* renamed from: d, reason: collision with root package name */
        private final String f32509d;

        private a(Date date, int i11, f fVar, String str) {
            this.f32506a = date;
            this.f32507b = i11;
            this.f32508c = fVar;
            this.f32509d = str;
        }

        public static a a(Date date, f fVar) {
            return new a(date, 1, fVar, null);
        }

        public static a b(f fVar, String str) {
            return new a(fVar.h(), 0, fVar, str);
        }

        public static a c(Date date) {
            return new a(date, 2, null, null);
        }

        public f d() {
            return this.f32508c;
        }

        String e() {
            return this.f32509d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            return this.f32507b;
        }
    }

    public ConfigFetchHandler(jc.e eVar, ic.b bVar, Executor executor, Clock clock, Random random, e eVar2, ConfigFetchHttpClient configFetchHttpClient, n nVar, Map map) {
        this.f32497a = eVar;
        this.f32498b = bVar;
        this.f32499c = executor;
        this.f32500d = clock;
        this.f32501e = random;
        this.f32502f = eVar2;
        this.f32503g = configFetchHttpClient;
        this.f32504h = nVar;
        this.f32505i = map;
    }

    private n.a A(int i11, Date date) {
        if (t(i11)) {
            B(date);
        }
        return this.f32504h.a();
    }

    private void B(Date date) {
        int b11 = this.f32504h.a().b() + 1;
        this.f32504h.k(b11, new Date(date.getTime() + q(b11)));
    }

    private void C(Task task, Date date) {
        if (task.isSuccessful()) {
            this.f32504h.q(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.f32504h.r();
        } else {
            this.f32504h.p();
        }
    }

    private boolean f(long j11, Date date) {
        Date e11 = this.f32504h.e();
        if (e11.equals(n.f32591e)) {
            return false;
        }
        return date.before(new Date(e11.getTime() + TimeUnit.SECONDS.toMillis(j11)));
    }

    private FirebaseRemoteConfigServerException g(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else {
            if (httpStatusCode == 429) {
                throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
            }
            if (httpStatusCode != 500) {
                switch (httpStatusCode) {
                    case 502:
                    case 503:
                    case 504:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        return new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.getHttpStatusCode(), "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String h(long j11) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j11)));
    }

    private a k(String str, String str2, Date date, Map map) {
        try {
            a fetch = this.f32503g.fetch(this.f32503g.d(), str, str2, s(), this.f32504h.d(), map, p(), date);
            if (fetch.d() != null) {
                this.f32504h.n(fetch.d().k());
            }
            if (fetch.e() != null) {
                this.f32504h.m(fetch.e());
            }
            this.f32504h.i();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e11) {
            n.a A = A(e11.getHttpStatusCode(), date);
            if (z(A, e11.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(A.a().getTime());
            }
            throw g(e11);
        }
    }

    private Task l(String str, String str2, Date date, Map map) {
        try {
            final a k11 = k(str, str2, date, map);
            return k11.f() != 0 ? Tasks.forResult(k11) : this.f32502f.k(k11.d()).onSuccessTask(this.f32499c, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.k
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Task forResult;
                    forResult = Tasks.forResult(ConfigFetchHandler.a.this);
                    return forResult;
                }
            });
        } catch (FirebaseRemoteConfigException e11) {
            return Tasks.forException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Task u(Task task, long j11, final Map map) {
        Task continueWithTask;
        final Date date = new Date(this.f32500d.currentTimeMillis());
        if (task.isSuccessful() && f(j11, date)) {
            return Tasks.forResult(a.c(date));
        }
        Date o11 = o(date);
        if (o11 != null) {
            continueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(h(o11.getTime() - date.getTime()), o11.getTime()));
        } else {
            final Task id2 = this.f32497a.getId();
            final Task a11 = this.f32497a.a(false);
            continueWithTask = Tasks.whenAllComplete((Task<?>[]) new Task[]{id2, a11}).continueWithTask(this.f32499c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.i
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    Task w11;
                    w11 = ConfigFetchHandler.this.w(id2, a11, date, map, task2);
                    return w11;
                }
            });
        }
        return continueWithTask.continueWithTask(this.f32499c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Task x10;
                x10 = ConfigFetchHandler.this.x(date, task2);
                return x10;
            }
        });
    }

    private Date o(Date date) {
        Date a11 = this.f32504h.a().a();
        if (date.before(a11)) {
            return a11;
        }
        return null;
    }

    private Long p() {
        kb.a aVar = (kb.a) this.f32498b.get();
        if (aVar == null) {
            return null;
        }
        return (Long) aVar.e(true).get("_fot");
    }

    private long q(int i11) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f32496k;
        return (timeUnit.toMillis(iArr[Math.min(i11, iArr.length) - 1]) / 2) + this.f32501e.nextInt((int) r0);
    }

    private Map s() {
        HashMap hashMap = new HashMap();
        kb.a aVar = (kb.a) this.f32498b.get();
        if (aVar == null) {
            return hashMap;
        }
        for (Map.Entry entry : aVar.e(false).entrySet()) {
            hashMap.put((String) entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean t(int i11) {
        return i11 == 429 || i11 == 502 || i11 == 503 || i11 == 504;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task w(Task task, Task task2, Date date, Map map, Task task3) {
        return !task.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException())) : !task2.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException())) : l((String) task.getResult(), ((com.google.firebase.installations.f) task2.getResult()).b(), date, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task x(Date date, Task task) {
        C(task, date);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task y(Map map, Task task) {
        return u(task, 0L, map);
    }

    private boolean z(n.a aVar, int i11) {
        return aVar.b() > 1 || i11 == 429;
    }

    public Task i() {
        return j(this.f32504h.g());
    }

    public Task j(final long j11) {
        final HashMap hashMap = new HashMap(this.f32505i);
        hashMap.put("X-Firebase-RC-Fetch-Type", FetchType.BASE.getValue() + "/1");
        return this.f32502f.e().continueWithTask(this.f32499c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task u11;
                u11 = ConfigFetchHandler.this.u(j11, hashMap, task);
                return u11;
            }
        });
    }

    public Task n(FetchType fetchType, int i11) {
        final HashMap hashMap = new HashMap(this.f32505i);
        hashMap.put("X-Firebase-RC-Fetch-Type", fetchType.getValue() + "/" + i11);
        return this.f32502f.e().continueWithTask(this.f32499c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task y10;
                y10 = ConfigFetchHandler.this.y(hashMap, task);
                return y10;
            }
        });
    }

    public long r() {
        return this.f32504h.f();
    }
}
