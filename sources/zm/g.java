package zm;

import android.content.Context;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f79560a = "skulist.json";

    public final String a(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getResources().getAssets().open(this.f79560a);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }
}
