package br;

import com.tencent.mmkv.MMKV;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16996a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f16997b = LazyKt.b(new Function0() { // from class: br.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = b.c();
            return c11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static List f16998c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return b.f16998c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("search_mmKv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }
}
