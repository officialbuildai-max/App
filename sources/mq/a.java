package mq;

import android.content.Context;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f69806a = "room_recommend.json";

    /* renamed from: b, reason: collision with root package name */
    private final String f69807b = "post_list.json";

    public final String a(Context context) {
        Intrinsics.h(context, "context");
        try {
            InputStream open = context.getAssets().open(this.f69806a);
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }
}
