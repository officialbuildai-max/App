package androidx.compose.runtime.saveable;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class SaverKt {

    /* renamed from: a, reason: collision with root package name */
    private static final d f3982a = a(new Function2<e, Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(e eVar, Object obj) {
            return obj;
        }
    }, new Function1<Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    });

    /* loaded from: classes.dex */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f3983a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f3984b;

        a(Function2 function2, Function1 function1) {
            this.f3983a = function2;
            this.f3984b = function1;
        }

        @Override // androidx.compose.runtime.saveable.d
        public Object a(e eVar, Object obj) {
            return this.f3983a.invoke(eVar, obj);
        }

        @Override // androidx.compose.runtime.saveable.d
        public Object b(Object obj) {
            return this.f3984b.invoke(obj);
        }
    }

    public static final d a(Function2 function2, Function1 function1) {
        return new a(function2, function1);
    }

    public static final d b() {
        d dVar = f3982a;
        Intrinsics.f(dVar, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return dVar;
    }
}
