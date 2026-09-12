package androidx.activity;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class w {

    /* loaded from: classes.dex */
    public static final class a extends u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f1017a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z10, Function1 function1) {
            super(z10);
            this.f1017a = function1;
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            this.f1017a.invoke(this);
        }
    }

    public static final u a(OnBackPressedDispatcher onBackPressedDispatcher, androidx.view.u uVar, boolean z10, Function1 onBackPressed) {
        Intrinsics.h(onBackPressedDispatcher, "<this>");
        Intrinsics.h(onBackPressed, "onBackPressed");
        a aVar = new a(z10, onBackPressed);
        if (uVar != null) {
            onBackPressedDispatcher.i(uVar, aVar);
        } else {
            onBackPressedDispatcher.h(aVar);
        }
        return aVar;
    }

    public static /* synthetic */ u b(OnBackPressedDispatcher onBackPressedDispatcher, androidx.view.u uVar, boolean z10, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            uVar = null;
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return a(onBackPressedDispatcher, uVar, z10, function1);
    }
}
