package u1;

import android.os.Bundle;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class f implements e {

    /* renamed from: c, reason: collision with root package name */
    private static final String f76725c = a1.C0(0);

    /* renamed from: d, reason: collision with root package name */
    private static final String f76726d = a1.C0(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f76727a;

    /* renamed from: b, reason: collision with root package name */
    public final int f76728b;

    public f(String str, int i11) {
        this.f76727a = str;
        this.f76728b = i11;
    }

    public static f a(Bundle bundle) {
        return new f((String) androidx.media3.common.util.a.e(bundle.getString(f76725c)), bundle.getInt(f76726d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f76725c, this.f76727a);
        bundle.putInt(f76726d, this.f76728b);
        return bundle;
    }
}
