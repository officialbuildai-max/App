package j2;

import java.util.List;

/* loaded from: classes2.dex */
public final class a0 extends c {

    /* renamed from: i, reason: collision with root package name */
    private final int f65856i;

    /* renamed from: j, reason: collision with root package name */
    private final Object f65857j;

    public a0(androidx.media3.common.f0 f0Var, int i11, int i12) {
        this(f0Var, i11, i12, 0, null);
    }

    public a0(androidx.media3.common.f0 f0Var, int i11, int i12, int i13, Object obj) {
        super(f0Var, new int[]{i11}, i12);
        this.f65856i = i13;
        this.f65857j = obj;
    }

    @Override // j2.z
    public void e(long j11, long j12, long j13, List list, h2.n[] nVarArr) {
    }

    @Override // j2.z
    public int getSelectedIndex() {
        return 0;
    }

    @Override // j2.z
    public Object getSelectionData() {
        return this.f65857j;
    }

    @Override // j2.z
    public int getSelectionReason() {
        return this.f65856i;
    }
}
