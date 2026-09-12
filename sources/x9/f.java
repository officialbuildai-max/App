package x9;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final EventMessage[] f78214a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f78215b;

    /* renamed from: c, reason: collision with root package name */
    public final String f78216c;

    /* renamed from: d, reason: collision with root package name */
    public final String f78217d;

    /* renamed from: e, reason: collision with root package name */
    public final long f78218e;

    public f(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        this.f78216c = str;
        this.f78217d = str2;
        this.f78218e = j11;
        this.f78215b = jArr;
        this.f78214a = eventMessageArr;
    }

    public String a() {
        String str = this.f78216c;
        String str2 = this.f78217d;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(str2);
        return sb2.toString();
    }
}
