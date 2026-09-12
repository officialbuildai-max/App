package a9;

import android.content.Context;

/* loaded from: classes3.dex */
public final class w0 implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f533a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f534b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f535c;

    public w0(uz.a aVar, uz.a aVar2, uz.a aVar3) {
        this.f533a = aVar;
        this.f534b = aVar2;
        this.f535c = aVar3;
    }

    public static w0 a(uz.a aVar, uz.a aVar2, uz.a aVar3) {
        return new w0(aVar, aVar2, aVar3);
    }

    public static v0 c(Context context, String str, int i11) {
        return new v0(context, str, i11);
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v0 get() {
        return c((Context) this.f533a.get(), (String) this.f534b.get(), ((Integer) this.f535c.get()).intValue());
    }
}
