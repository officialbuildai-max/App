package androidx.media3.common;

import android.media.AudioAttributes;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static final c f9989g = new e().a();

    /* renamed from: h, reason: collision with root package name */
    private static final String f9990h = a1.C0(0);

    /* renamed from: i, reason: collision with root package name */
    private static final String f9991i = a1.C0(1);

    /* renamed from: j, reason: collision with root package name */
    private static final String f9992j = a1.C0(2);

    /* renamed from: k, reason: collision with root package name */
    private static final String f9993k = a1.C0(3);

    /* renamed from: l, reason: collision with root package name */
    private static final String f9994l = a1.C0(4);

    /* renamed from: a, reason: collision with root package name */
    public final int f9995a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9996b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9997c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9998d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9999e;

    /* renamed from: f, reason: collision with root package name */
    private d f10000f;

    /* loaded from: classes2.dex */
    private static final class b {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setAllowedCapturePolicy(i11);
        }
    }

    /* renamed from: androidx.media3.common.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0096c {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setSpatializationBehavior(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes f10001a;

        private d(c cVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(cVar.f9995a).setFlags(cVar.f9996b).setUsage(cVar.f9997c);
            int i11 = a1.f10432a;
            if (i11 >= 29) {
                b.a(usage, cVar.f9998d);
            }
            if (i11 >= 32) {
                C0096c.a(usage, cVar.f9999e);
            }
            this.f10001a = usage.build();
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private int f10002a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f10003b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f10004c = 1;

        /* renamed from: d, reason: collision with root package name */
        private int f10005d = 1;

        /* renamed from: e, reason: collision with root package name */
        private int f10006e = 0;

        public c a() {
            return new c(this.f10002a, this.f10003b, this.f10004c, this.f10005d, this.f10006e);
        }
    }

    private c(int i11, int i12, int i13, int i14, int i15) {
        this.f9995a = i11;
        this.f9996b = i12;
        this.f9997c = i13;
        this.f9998d = i14;
        this.f9999e = i15;
    }

    public d a() {
        if (this.f10000f == null) {
            this.f10000f = new d();
        }
        return this.f10000f;
    }

    public int b() {
        if ((this.f9996b & 1) == 1) {
            return 1;
        }
        switch (this.f9997c) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 12:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9995a == cVar.f9995a && this.f9996b == cVar.f9996b && this.f9997c == cVar.f9997c && this.f9998d == cVar.f9998d && this.f9999e == cVar.f9999e;
    }

    public int hashCode() {
        return ((((((((527 + this.f9995a) * 31) + this.f9996b) * 31) + this.f9997c) * 31) + this.f9998d) * 31) + this.f9999e;
    }
}
