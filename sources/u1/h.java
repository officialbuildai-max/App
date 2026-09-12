package u1;

import android.os.Bundle;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class h implements e {

    /* renamed from: d, reason: collision with root package name */
    private static final String f76729d = a1.C0(0);

    /* renamed from: e, reason: collision with root package name */
    private static final String f76730e = a1.C0(1);

    /* renamed from: f, reason: collision with root package name */
    private static final String f76731f = a1.C0(2);

    /* renamed from: a, reason: collision with root package name */
    public int f76732a;

    /* renamed from: b, reason: collision with root package name */
    public int f76733b;

    /* renamed from: c, reason: collision with root package name */
    public final int f76734c;

    public h(int i11, int i12, int i13) {
        this.f76732a = i11;
        this.f76733b = i12;
        this.f76734c = i13;
    }

    public static h a(Bundle bundle) {
        return new h(bundle.getInt(f76729d), bundle.getInt(f76730e), bundle.getInt(f76731f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f76729d, this.f76732a);
        bundle.putInt(f76730e, this.f76733b);
        bundle.putInt(f76731f, this.f76734c);
        return bundle;
    }
}
