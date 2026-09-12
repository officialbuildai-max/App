package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class FocusRequester {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4298b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final FocusRequester f4299c = new FocusRequester();

    /* renamed from: d, reason: collision with root package name */
    private static final FocusRequester f4300d = new FocusRequester();

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f4301a = new androidx.compose.runtime.collection.b(new q[16], 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FocusRequester a() {
            return FocusRequester.f4300d;
        }

        public final FocusRequester b() {
            return FocusRequester.f4299c;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x005d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(kotlin.jvm.functions.Function1 r18) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequester.c(kotlin.jvm.functions.Function1):boolean");
    }

    public final boolean d() {
        return c(new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequester$focus$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(FocusTransactionsKt.j(focusTargetNode));
            }
        });
    }
}
