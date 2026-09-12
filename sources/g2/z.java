package g2;

import androidx.media3.common.f0;
import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class z {

    /* renamed from: d, reason: collision with root package name */
    public static final z f63387d = new z(new f0[0]);

    /* renamed from: e, reason: collision with root package name */
    private static final String f63388e = a1.C0(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f63389a;

    /* renamed from: b, reason: collision with root package name */
    private final ImmutableList f63390b;

    /* renamed from: c, reason: collision with root package name */
    private int f63391c;

    public z(f0... f0VarArr) {
        this.f63390b = ImmutableList.copyOf(f0VarArr);
        this.f63389a = f0VarArr.length;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer e(f0 f0Var) {
        return Integer.valueOf(f0Var.f10055c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        int i11 = 0;
        while (i11 < this.f63390b.size()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.f63390b.size(); i13++) {
                if (((f0) this.f63390b.get(i11)).equals(this.f63390b.get(i13))) {
                    androidx.media3.common.util.u.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0 b(int i11) {
        return (f0) this.f63390b.get(i11);
    }

    public ImmutableList c() {
        return ImmutableList.copyOf((Collection) Lists.o(this.f63390b, new com.google.common.base.f() { // from class: g2.y
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                Integer e11;
                e11 = z.e((f0) obj);
                return e11;
            }
        }));
    }

    public int d(f0 f0Var) {
        int indexOf = this.f63390b.indexOf(f0Var);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f63389a == zVar.f63389a && this.f63390b.equals(zVar.f63390b);
    }

    public int hashCode() {
        if (this.f63391c == 0) {
            this.f63391c = this.f63390b.hashCode();
        }
        return this.f63391c;
    }

    public String toString() {
        return this.f63390b.toString();
    }
}
