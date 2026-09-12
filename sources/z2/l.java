package z2;

import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l extends i {

    /* renamed from: b, reason: collision with root package name */
    public final int f79320b;

    /* renamed from: c, reason: collision with root package name */
    public final int f79321c;

    /* renamed from: d, reason: collision with root package name */
    public final int f79322d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f79323e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f79324f;

    public l(int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        super(MlltFrame.ID);
        this.f79320b = i11;
        this.f79321c = i12;
        this.f79322d = i13;
        this.f79323e = iArr;
        this.f79324f = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f79320b == lVar.f79320b && this.f79321c == lVar.f79321c && this.f79322d == lVar.f79322d && Arrays.equals(this.f79323e, lVar.f79323e) && Arrays.equals(this.f79324f, lVar.f79324f);
    }

    public int hashCode() {
        return ((((((((527 + this.f79320b) * 31) + this.f79321c) * 31) + this.f79322d) * 31) + Arrays.hashCode(this.f79323e)) * 31) + Arrays.hashCode(this.f79324f);
    }
}
