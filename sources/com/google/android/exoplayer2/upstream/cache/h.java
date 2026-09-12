package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

/* loaded from: classes3.dex */
public abstract class h implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f27391a;

    /* renamed from: b, reason: collision with root package name */
    public final long f27392b;

    /* renamed from: c, reason: collision with root package name */
    public final long f27393c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f27394d;

    /* renamed from: e, reason: collision with root package name */
    public final File f27395e;

    /* renamed from: f, reason: collision with root package name */
    public final long f27396f;

    public h(String str, long j11, long j12, long j13, File file) {
        this.f27391a = str;
        this.f27392b = j11;
        this.f27393c = j12;
        this.f27394d = file != null;
        this.f27395e = file;
        this.f27396f = j13;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (!this.f27391a.equals(hVar.f27391a)) {
            return this.f27391a.compareTo(hVar.f27391a);
        }
        long j11 = this.f27392b - hVar.f27392b;
        if (j11 == 0) {
            return 0;
        }
        return j11 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f27394d;
    }

    public boolean d() {
        return this.f27393c == -1;
    }

    public String toString() {
        return "[" + this.f27392b + ", " + this.f27393c + "]";
    }
}
