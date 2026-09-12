package androidx.media3.datasource.cache;

import androidx.media3.common.util.u;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f10916a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10917b;

    /* renamed from: c, reason: collision with root package name */
    private final TreeSet f10918c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f10919d;

    /* renamed from: e, reason: collision with root package name */
    private o f10920e;

    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f10921a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10922b;

        public a(long j11, long j12) {
            this.f10921a = j11;
            this.f10922b = j12;
        }

        public boolean a(long j11, long j12) {
            long j13 = this.f10922b;
            if (j13 == -1) {
                return j11 >= this.f10921a;
            }
            if (j12 == -1) {
                return false;
            }
            long j14 = this.f10921a;
            return j14 <= j11 && j11 + j12 <= j14 + j13;
        }

        public boolean b(long j11, long j12) {
            long j13 = this.f10921a;
            if (j13 > j11) {
                return j12 == -1 || j11 + j12 > j13;
            }
            long j14 = this.f10922b;
            return j14 == -1 || j13 + j14 > j11;
        }
    }

    public j(int i11, String str) {
        this(i11, str, o.f10943c);
    }

    public j(int i11, String str, o oVar) {
        this.f10916a = i11;
        this.f10917b = str;
        this.f10920e = oVar;
        this.f10918c = new TreeSet();
        this.f10919d = new ArrayList();
    }

    public void a(s sVar) {
        this.f10918c.add(sVar);
    }

    public boolean b(n nVar) {
        this.f10920e = this.f10920e.c(nVar);
        return !r2.equals(r0);
    }

    public long c(long j11, long j12) {
        androidx.media3.common.util.a.a(j11 >= 0);
        androidx.media3.common.util.a.a(j12 >= 0);
        s e11 = e(j11, j12);
        if (e11.b()) {
            return -Math.min(e11.d() ? Long.MAX_VALUE : e11.f10902c, j12);
        }
        long j13 = j11 + j12;
        long j14 = j13 >= 0 ? j13 : Long.MAX_VALUE;
        long j15 = e11.f10901b + e11.f10902c;
        if (j15 < j14) {
            for (s sVar : this.f10918c.tailSet(e11, false)) {
                long j16 = sVar.f10901b;
                if (j16 > j15) {
                    break;
                }
                j15 = Math.max(j15, j16 + sVar.f10902c);
                if (j15 >= j14) {
                    break;
                }
            }
        }
        return Math.min(j15 - j11, j12);
    }

    public o d() {
        return this.f10920e;
    }

    public s e(long j11, long j12) {
        s i11 = s.i(this.f10917b, j11);
        s sVar = (s) this.f10918c.floor(i11);
        if (sVar != null && sVar.f10901b + sVar.f10902c > j11) {
            return sVar;
        }
        s sVar2 = (s) this.f10918c.ceiling(i11);
        if (sVar2 != null) {
            long j13 = sVar2.f10901b - j11;
            j12 = j12 == -1 ? j13 : Math.min(j13, j12);
        }
        return s.h(this.f10917b, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f10916a == jVar.f10916a && this.f10917b.equals(jVar.f10917b) && this.f10918c.equals(jVar.f10918c) && this.f10920e.equals(jVar.f10920e);
    }

    public TreeSet f() {
        return this.f10918c;
    }

    public boolean g() {
        return this.f10918c.isEmpty();
    }

    public boolean h(long j11, long j12) {
        for (int i11 = 0; i11 < this.f10919d.size(); i11++) {
            if (((a) this.f10919d.get(i11)).a(j11, j12)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f10916a * 31) + this.f10917b.hashCode()) * 31) + this.f10920e.hashCode();
    }

    public boolean i() {
        return this.f10919d.isEmpty();
    }

    public boolean j(long j11, long j12) {
        for (int i11 = 0; i11 < this.f10919d.size(); i11++) {
            if (((a) this.f10919d.get(i11)).b(j11, j12)) {
                return false;
            }
        }
        this.f10919d.add(new a(j11, j12));
        return true;
    }

    public boolean k(h hVar) {
        if (!this.f10918c.remove(hVar)) {
            return false;
        }
        File file = hVar.f10904e;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public s l(s sVar, long j11, boolean z10) {
        androidx.media3.common.util.a.g(this.f10918c.remove(sVar));
        File file = (File) androidx.media3.common.util.a.e(sVar.f10904e);
        if (z10) {
            File j12 = s.j((File) androidx.media3.common.util.a.e(file.getParentFile()), this.f10916a, sVar.f10901b, j11);
            if (file.renameTo(j12)) {
                file = j12;
            } else {
                u.h("CachedContent", "Failed to rename " + file + " to " + j12);
            }
        }
        s e11 = sVar.e(file, j11);
        this.f10918c.add(e11);
        return e11;
    }

    public void m(long j11) {
        for (int i11 = 0; i11 < this.f10919d.size(); i11++) {
            if (((a) this.f10919d.get(i11)).f10921a == j11) {
                this.f10919d.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
