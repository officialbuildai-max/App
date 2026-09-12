package androidx.media3.datasource.cache;

import java.io.File;

/* loaded from: classes2.dex */
public abstract class h implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f10900a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10901b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10902c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10903d;

    /* renamed from: e, reason: collision with root package name */
    public final File f10904e;

    /* renamed from: f, reason: collision with root package name */
    public final long f10905f;

    public h(String str, long j11, long j12, long j13, File file) {
        this.f10900a = str;
        this.f10901b = j11;
        this.f10902c = j12;
        this.f10903d = file != null;
        this.f10904e = file;
        this.f10905f = j13;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (!this.f10900a.equals(hVar.f10900a)) {
            return this.f10900a.compareTo(hVar.f10900a);
        }
        long j11 = this.f10901b - hVar.f10901b;
        if (j11 == 0) {
            return 0;
        }
        return j11 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f10903d;
    }

    public boolean d() {
        return this.f10902c == -1;
    }

    public String toString() {
        return "[" + this.f10901b + ", " + this.f10902c + "]";
    }
}
