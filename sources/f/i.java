package f;

import android.content.Context;
import android.content.Intent;
import f.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class i extends a {
    @Override // f.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String input) {
        Intrinsics.h(context, "context");
        Intrinsics.h(input, "input");
        return h.f62242a.a(new String[]{input});
    }

    @Override // f.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.C0777a b(Context context, String input) {
        Intrinsics.h(context, "context");
        Intrinsics.h(input, "input");
        if (androidx.core.content.b.checkSelfPermission(context, input) == 0) {
            return new a.C0777a(Boolean.TRUE);
        }
        return null;
    }

    @Override // f.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i11, Intent intent) {
        if (intent == null || i11 != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z10 = false;
        if (intArrayExtra != null) {
            int length = intArrayExtra.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (intArrayExtra[i12] == 0) {
                    z10 = true;
                    break;
                }
                i12++;
            }
        }
        return Boolean.valueOf(z10);
    }
}
