package xe;

/* loaded from: classes5.dex */
public class q implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f78357a;

    /* renamed from: b, reason: collision with root package name */
    public final int f78358b;

    public q(int i11, int i12) {
        this.f78357a = i11;
        this.f78358b = i12;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        int i11 = this.f78358b * this.f78357a;
        int i12 = qVar.f78358b * qVar.f78357a;
        if (i12 < i11) {
            return 1;
        }
        return i12 > i11 ? -1 : 0;
    }

    public boolean b(q qVar) {
        return this.f78357a <= qVar.f78357a && this.f78358b <= qVar.f78358b;
    }

    public q d() {
        return new q(this.f78358b, this.f78357a);
    }

    public q e(int i11, int i12) {
        return new q((this.f78357a * i11) / i12, (this.f78358b * i11) / i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.f78357a == qVar.f78357a && this.f78358b == qVar.f78358b;
    }

    public q f(q qVar) {
        int i11 = this.f78357a;
        int i12 = qVar.f78358b;
        int i13 = i11 * i12;
        int i14 = qVar.f78357a;
        int i15 = this.f78358b;
        return i13 <= i14 * i15 ? new q(i14, (i15 * i14) / i11) : new q((i11 * i12) / i15, i12);
    }

    public q g(q qVar) {
        int i11 = this.f78357a;
        int i12 = qVar.f78358b;
        int i13 = i11 * i12;
        int i14 = qVar.f78357a;
        int i15 = this.f78358b;
        return i13 >= i14 * i15 ? new q(i14, (i15 * i14) / i11) : new q((i11 * i12) / i15, i12);
    }

    public int hashCode() {
        return (this.f78357a * 31) + this.f78358b;
    }

    public String toString() {
        return this.f78357a + "x" + this.f78358b;
    }
}
