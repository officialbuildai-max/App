package iz;

import androidx.collection.s;
import androidx.compose.animation.core.r;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f65806a;

    /* renamed from: b, reason: collision with root package name */
    private final String f65807b;

    /* renamed from: c, reason: collision with root package name */
    private final String f65808c;

    /* renamed from: d, reason: collision with root package name */
    private final String f65809d;

    /* renamed from: e, reason: collision with root package name */
    private final int f65810e;

    /* renamed from: f, reason: collision with root package name */
    private final long f65811f;

    /* renamed from: g, reason: collision with root package name */
    private final double f65812g;

    /* renamed from: h, reason: collision with root package name */
    private final int f65813h;

    /* renamed from: i, reason: collision with root package name */
    private final int f65814i;

    /* renamed from: j, reason: collision with root package name */
    private final int f65815j;

    public d(int i11, String str, String codecName, String str2, int i12, long j11, double d11, int i13, int i14, int i15) {
        Intrinsics.h(codecName, "codecName");
        this.f65806a = i11;
        this.f65807b = str;
        this.f65808c = codecName;
        this.f65809d = str2;
        this.f65810e = i12;
        this.f65811f = j11;
        this.f65812g = d11;
        this.f65813h = i13;
        this.f65814i = i14;
        this.f65815j = i15;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f65806a == dVar.f65806a && Intrinsics.c(this.f65807b, dVar.f65807b) && Intrinsics.c(this.f65808c, dVar.f65808c) && Intrinsics.c(this.f65809d, dVar.f65809d) && this.f65810e == dVar.f65810e && this.f65811f == dVar.f65811f && Double.compare(this.f65812g, dVar.f65812g) == 0 && this.f65813h == dVar.f65813h && this.f65814i == dVar.f65814i && this.f65815j == dVar.f65815j;
    }

    public int hashCode() {
        int i11 = this.f65806a * 31;
        String str = this.f65807b;
        int hashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f65808c.hashCode()) * 31;
        String str2 = this.f65809d;
        return ((((((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f65810e) * 31) + s.a(this.f65811f)) * 31) + r.a(this.f65812g)) * 31) + this.f65813h) * 31) + this.f65814i) * 31) + this.f65815j;
    }

    public String toString() {
        return "VideoStream(index=" + this.f65806a + ", title=" + this.f65807b + ", codecName=" + this.f65808c + ", language=" + this.f65809d + ", disposition=" + this.f65810e + ", bitRate=" + this.f65811f + ", frameRate=" + this.f65812g + ", frameWidth=" + this.f65813h + ", frameHeight=" + this.f65814i + ", rotation=" + this.f65815j + ")";
    }
}
