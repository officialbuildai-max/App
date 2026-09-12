package a9;

import android.content.Context;

/* loaded from: classes3.dex */
public final class h implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f480a;

    public h(uz.a aVar) {
        this.f480a = aVar;
    }

    public static h a(uz.a aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) u8.d.d(f.b(context));
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f480a.get());
    }
}
