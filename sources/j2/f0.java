package j2;

import androidx.media3.common.i0;
import androidx.media3.exoplayer.z3;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f65877a;

    /* renamed from: b, reason: collision with root package name */
    public final z3[] f65878b;

    /* renamed from: c, reason: collision with root package name */
    public final z[] f65879c;

    /* renamed from: d, reason: collision with root package name */
    public final i0 f65880d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f65881e;

    public f0(z3[] z3VarArr, z[] zVarArr, i0 i0Var, Object obj) {
        androidx.media3.common.util.a.a(z3VarArr.length == zVarArr.length);
        this.f65878b = z3VarArr;
        this.f65879c = (z[]) zVarArr.clone();
        this.f65880d = i0Var;
        this.f65881e = obj;
        this.f65877a = z3VarArr.length;
    }

    public boolean a(f0 f0Var) {
        if (f0Var == null || f0Var.f65879c.length != this.f65879c.length) {
            return false;
        }
        for (int i11 = 0; i11 < this.f65879c.length; i11++) {
            if (!b(f0Var, i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(f0 f0Var, int i11) {
        return f0Var != null && Objects.equals(this.f65878b[i11], f0Var.f65878b[i11]) && Objects.equals(this.f65879c[i11], f0Var.f65879c[i11]);
    }

    public boolean c(int i11) {
        return this.f65878b[i11] != null;
    }
}
