package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface c {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19302a;

        /* renamed from: b, reason: collision with root package name */
        public String f19303b;

        /* renamed from: c, reason: collision with root package name */
        public long f19304c;

        /* renamed from: d, reason: collision with root package name */
        public long f19305d;

        /* renamed from: e, reason: collision with root package name */
        public long f19306e;

        /* renamed from: f, reason: collision with root package name */
        public long f19307f;

        /* renamed from: g, reason: collision with root package name */
        public Map f19308g = Collections.emptyMap();

        /* renamed from: h, reason: collision with root package name */
        public List f19309h;

        public boolean a() {
            return b(System.currentTimeMillis());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(long j11) {
            return this.f19306e < j11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(long j11) {
            return this.f19307f < j11;
        }
    }

    a a(String str);

    void b(String str, boolean z10);

    void c(String str, a aVar);

    void initialize();
}
