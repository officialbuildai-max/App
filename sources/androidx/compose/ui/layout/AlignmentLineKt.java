package androidx.compose.ui.layout;

/* loaded from: classes.dex */
public abstract class AlignmentLineKt {

    /* renamed from: a, reason: collision with root package name */
    private static final h f5169a = new h(AlignmentLineKt$FirstBaseline$1.INSTANCE);

    /* renamed from: b, reason: collision with root package name */
    private static final h f5170b = new h(AlignmentLineKt$LastBaseline$1.INSTANCE);

    public static final h a() {
        return f5169a;
    }

    public static final h b() {
        return f5170b;
    }

    public static final int c(a aVar, int i11, int i12) {
        return ((Number) aVar.a().invoke(Integer.valueOf(i11), Integer.valueOf(i12))).intValue();
    }
}
