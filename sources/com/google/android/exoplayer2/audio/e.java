package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes3.dex */
public final class e implements com.google.android.exoplayer2.k {

    /* renamed from: g, reason: collision with root package name */
    public static final e f24688g = new C0366e().a();

    /* renamed from: h, reason: collision with root package name */
    public static final k.a f24689h = new k.a() { // from class: com.google.android.exoplayer2.audio.d
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            e d11;
            d11 = e.d(bundle);
            return d11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f24690a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24691b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24692c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24693d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24694e;

    /* renamed from: f, reason: collision with root package name */
    private d f24695f;

    /* loaded from: classes3.dex */
    private static final class b {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setAllowedCapturePolicy(i11);
        }
    }

    /* loaded from: classes3.dex */
    private static final class c {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setSpatializationBehavior(i11);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes f24696a;

        private d(e eVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(eVar.f24690a).setFlags(eVar.f24691b).setUsage(eVar.f24692c);
            int i11 = p0.f27680a;
            if (i11 >= 29) {
                b.a(usage, eVar.f24693d);
            }
            if (i11 >= 32) {
                c.a(usage, eVar.f24694e);
            }
            this.f24696a = usage.build();
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.e$e, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0366e {

        /* renamed from: a, reason: collision with root package name */
        private int f24697a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f24698b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f24699c = 1;

        /* renamed from: d, reason: collision with root package name */
        private int f24700d = 1;

        /* renamed from: e, reason: collision with root package name */
        private int f24701e = 0;

        public e a() {
            return new e(this.f24697a, this.f24698b, this.f24699c, this.f24700d, this.f24701e);
        }

        public C0366e b(int i11) {
            this.f24700d = i11;
            return this;
        }

        public C0366e c(int i11) {
            this.f24697a = i11;
            return this;
        }

        public C0366e d(int i11) {
            this.f24698b = i11;
            return this;
        }

        public C0366e e(int i11) {
            this.f24701e = i11;
            return this;
        }

        public C0366e f(int i11) {
            this.f24699c = i11;
            return this;
        }
    }

    private e(int i11, int i12, int i13, int i14, int i15) {
        this.f24690a = i11;
        this.f24691b = i12;
        this.f24692c = i13;
        this.f24693d = i14;
        this.f24694e = i15;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e d(Bundle bundle) {
        C0366e c0366e = new C0366e();
        if (bundle.containsKey(c(0))) {
            c0366e.c(bundle.getInt(c(0)));
        }
        if (bundle.containsKey(c(1))) {
            c0366e.d(bundle.getInt(c(1)));
        }
        if (bundle.containsKey(c(2))) {
            c0366e.f(bundle.getInt(c(2)));
        }
        if (bundle.containsKey(c(3))) {
            c0366e.b(bundle.getInt(c(3)));
        }
        if (bundle.containsKey(c(4))) {
            c0366e.e(bundle.getInt(c(4)));
        }
        return c0366e.a();
    }

    public d b() {
        if (this.f24695f == null) {
            this.f24695f = new d();
        }
        return this.f24695f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f24690a == eVar.f24690a && this.f24691b == eVar.f24691b && this.f24692c == eVar.f24692c && this.f24693d == eVar.f24693d && this.f24694e == eVar.f24694e;
    }

    public int hashCode() {
        return ((((((((527 + this.f24690a) * 31) + this.f24691b) * 31) + this.f24692c) * 31) + this.f24693d) * 31) + this.f24694e;
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), this.f24690a);
        bundle.putInt(c(1), this.f24691b);
        bundle.putInt(c(2), this.f24692c);
        bundle.putInt(c(3), this.f24693d);
        bundle.putInt(c(4), this.f24694e);
        return bundle;
    }
}
