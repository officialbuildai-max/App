package com.apm.insight.k;

import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<c> f19687a = new ConcurrentLinkedQueue<>();

    /* renamed from: com.apm.insight.k.c$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19688a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f19688a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19688a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19688a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f19689a;

        /* renamed from: b, reason: collision with root package name */
        private JSONObject f19690b;

        /* renamed from: c, reason: collision with root package name */
        private CrashType f19691c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject, CrashType crashType) {
            this.f19691c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f19689a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f19689a = jSONObject;
            }
            this.f19690b = jSONObject.optJSONObject("header");
        }

        @Nullable
        public final String a() {
            return this.f19689a.optString("crash_thread_name", null);
        }

        public final long b() {
            return this.f19689a.optInt("app_start_time", -1);
        }

        @Nullable
        public final String c() {
            int i11 = AnonymousClass1.f19688a[this.f19691c.ordinal()];
            if (i11 == 1) {
                return this.f19689a.optString("data", null);
            }
            if (i11 == 2) {
                return this.f19689a.optString("stack", null);
            }
            if (i11 != 3) {
                return null;
            }
            return this.f19689a.optString("data", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = f19687a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        new a(jSONObject, crashType);
        while (!f19687a.isEmpty()) {
            f19687a.poll();
        }
        f19687a = null;
    }
}
