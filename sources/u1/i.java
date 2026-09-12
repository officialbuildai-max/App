package u1;

import android.os.Bundle;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private static final String f76735b = a1.C0(0);

    /* renamed from: a, reason: collision with root package name */
    public final String f76736a;

    public i(String str) {
        this.f76736a = str;
    }

    public static i a(Bundle bundle) {
        return new i((String) androidx.media3.common.util.a.e(bundle.getString(f76735b)));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f76735b, this.f76736a);
        return bundle;
    }
}
