package androidx.view;

import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public abstract class Transformations {

    /* loaded from: classes.dex */
    static final class a implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f9649a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f9649a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f9649a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f9649a.invoke(obj);
        }
    }

    public static final LiveData a(LiveData liveData) {
        final z zVar;
        Intrinsics.h(liveData, "<this>");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.i()) {
            booleanRef.element = false;
            zVar = new z(liveData.f());
        } else {
            zVar = new z();
        }
        zVar.r(liveData, new a(new Function1<Object, Unit>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m472invoke(obj);
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m472invoke(Object obj) {
                Object f11 = z.this.f();
                if (booleanRef.element || ((f11 == null && obj != null) || !(f11 == null || Intrinsics.c(f11, obj)))) {
                    booleanRef.element = false;
                    z.this.q(obj);
                }
            }
        }));
        return zVar;
    }
}
