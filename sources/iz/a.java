package iz;

import androidx.collection.s;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f65787a;

    /* renamed from: b, reason: collision with root package name */
    private final String f65788b;

    /* renamed from: c, reason: collision with root package name */
    private final String f65789c;

    /* renamed from: d, reason: collision with root package name */
    private final String f65790d;

    /* renamed from: e, reason: collision with root package name */
    private final int f65791e;

    /* renamed from: f, reason: collision with root package name */
    private final long f65792f;

    /* renamed from: g, reason: collision with root package name */
    private final String f65793g;

    /* renamed from: h, reason: collision with root package name */
    private final int f65794h;

    /* renamed from: i, reason: collision with root package name */
    private final int f65795i;

    /* renamed from: j, reason: collision with root package name */
    private final String f65796j;

    public a(int i11, String str, String codecName, String str2, int i12, long j11, String str3, int i13, int i14, String str4) {
        Intrinsics.h(codecName, "codecName");
        this.f65787a = i11;
        this.f65788b = str;
        this.f65789c = codecName;
        this.f65790d = str2;
        this.f65791e = i12;
        this.f65792f = j11;
        this.f65793g = str3;
        this.f65794h = i13;
        this.f65795i = i14;
        this.f65796j = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f65787a == aVar.f65787a && Intrinsics.c(this.f65788b, aVar.f65788b) && Intrinsics.c(this.f65789c, aVar.f65789c) && Intrinsics.c(this.f65790d, aVar.f65790d) && this.f65791e == aVar.f65791e && this.f65792f == aVar.f65792f && Intrinsics.c(this.f65793g, aVar.f65793g) && this.f65794h == aVar.f65794h && this.f65795i == aVar.f65795i && Intrinsics.c(this.f65796j, aVar.f65796j);
    }

    public int hashCode() {
        int i11 = this.f65787a * 31;
        String str = this.f65788b;
        int hashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f65789c.hashCode()) * 31;
        String str2 = this.f65790d;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f65791e) * 31) + s.a(this.f65792f)) * 31;
        String str3 = this.f65793g;
        int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f65794h) * 31) + this.f65795i) * 31;
        String str4 = this.f65796j;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "AudioStream(index=" + this.f65787a + ", title=" + this.f65788b + ", codecName=" + this.f65789c + ", language=" + this.f65790d + ", disposition=" + this.f65791e + ", bitRate=" + this.f65792f + ", sampleFormat=" + this.f65793g + ", sampleRate=" + this.f65794h + ", channels=" + this.f65795i + ", channelLayout=" + this.f65796j + ")";
    }
}
