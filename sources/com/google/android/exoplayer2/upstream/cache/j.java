package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f27407a;

    /* renamed from: b, reason: collision with root package name */
    public final String f27408b;

    /* renamed from: c, reason: collision with root package name */
    private final TreeSet f27409c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f27410d;

    /* renamed from: e, reason: collision with root package name */
    private o f27411e;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f27412a;

        /* renamed from: b, reason: collision with root package name */
        public final long f27413b;

        public a(long j11, long j12) {
            this.f27412a = j11;
            this.f27413b = j12;
        }

        public boolean a(long j11, long j12) {
            long j13 = this.f27413b;
            if (j13 == -1) {
                return j11 >= this.f27412a;
            }
            if (j12 == -1) {
                return false;
            }
            long j14 = this.f27412a;
            return j14 <= j11 && j11 + j12 <= j14 + j13;
        }

        public boolean b(long j11, long j12) {
            long j13 = this.f27412a;
            if (j13 > j11) {
                return j12 == -1 || j11 + j12 > j13;
            }
            long j14 = this.f27413b;
            return j14 == -1 || j13 + j14 > j11;
        }
    }

    public j(int i11, String str) {
        this(i11, str, o.f27434c);
    }

    public j(int i11, String str, o oVar) {
        this.f27407a = i11;
        this.f27408b = str;
        this.f27411e = oVar;
        this.f27409c = new TreeSet();
        this.f27410d = new ArrayList();
    }

    public void a(s sVar) {
        this.f27409c.add(sVar);
    }

    public boolean b(n nVar) {
        this.f27411e = this.f27411e.c(nVar);
        return !r2.equals(r0);
    }

    public long c(long j11, long j12) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        com.google.android.exoplayer2.util.a.a(j12 >= 0);
        s e11 = e(j11, j12);
        if (e11.b()) {
            return -Math.min(e11.d() ? Long.MAX_VALUE : e11.f27393c, j12);
        }
        long j13 = j11 + j12;
        long j14 = j13 >= 0 ? j13 : Long.MAX_VALUE;
        long j15 = e11.f27392b + e11.f27393c;
        if (j15 < j14) {
            for (s sVar : this.f27409c.tailSet(e11, false)) {
                long j16 = sVar.f27392b;
                if (j16 > j15) {
                    break;
                }
                j15 = Math.max(j15, j16 + sVar.f27393c);
                if (j15 >= j14) {
                    break;
                }
            }
        }
        return Math.min(j15 - j11, j12);
    }

    public o d() {
        return this.f27411e;
    }

    public s e(long j11, long j12) {
        s i11 = s.i(this.f27408b, j11);
        s sVar = (s) this.f27409c.floor(i11);
        if (sVar != null && sVar.f27392b + sVar.f27393c > j11) {
            return sVar;
        }
        s sVar2 = (s) this.f27409c.ceiling(i11);
        if (sVar2 != null) {
            long j13 = sVar2.f27392b - j11;
            j12 = j12 == -1 ? j13 : Math.min(j13, j12);
        }
        return s.h(this.f27408b, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f27407a == jVar.f27407a && this.f27408b.equals(jVar.f27408b) && this.f27409c.equals(jVar.f27409c) && this.f27411e.equals(jVar.f27411e);
    }

    public TreeSet f() {
        return this.f27409c;
    }

    public boolean g() {
        return this.f27409c.isEmpty();
    }

    public boolean h(long j11, long j12) {
        for (int i11 = 0; i11 < this.f27410d.size(); i11++) {
            if (((a) this.f27410d.get(i11)).a(j11, j12)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f27407a * 31) + this.f27408b.hashCode()) * 31) + this.f27411e.hashCode();
    }

    public boolean i() {
        return this.f27410d.isEmpty();
    }

    public boolean j(long j11, long j12) {
        for (int i11 = 0; i11 < this.f27410d.size(); i11++) {
            if (((a) this.f27410d.get(i11)).b(j11, j12)) {
                return false;
            }
        }
        this.f27410d.add(new a(j11, j12));
        return true;
    }

    public boolean k(h hVar) {
        if (!this.f27409c.remove(hVar)) {
            return false;
        }
        File file = hVar.f27395e;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public s l(s sVar, long j11, boolean z10) {
        com.google.android.exoplayer2.util.a.g(this.f27409c.remove(sVar));
        File file = (File) com.google.android.exoplayer2.util.a.e(sVar.f27395e);
        if (z10) {
            File j12 = s.j((File) com.google.android.exoplayer2.util.a.e(file.getParentFile()), this.f27407a, sVar.f27392b, j11);
            if (file.renameTo(j12)) {
                file = j12;
            } else {
                com.google.android.exoplayer2.util.s.i("CachedContent", "Failed to rename " + file + " to " + j12);
            }
        }
        s e11 = sVar.e(file, j11);
        this.f27409c.add(e11);
        return e11;
    }

    public void m(long j11) {
        for (int i11 = 0; i11 < this.f27410d.size(); i11++) {
            if (((a) this.f27410d.get(i11)).f27412a == j11) {
                this.f27410d.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
