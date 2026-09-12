package androidx.fragment.app;

import androidx.view.ViewModelLazy;
import androidx.view.v0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
public abstract class FragmentViewModelLazyKt {
    public static final Lazy a(final Fragment fragment, KClass viewModelClass, Function0 storeProducer, Function0 function0) {
        Intrinsics.h(fragment, "<this>");
        Intrinsics.h(viewModelClass, "viewModelClass");
        Intrinsics.h(storeProducer, "storeProducer");
        if (function0 == null) {
            function0 = new Function0<v0.c>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final v0.c invoke() {
                    v0.c defaultViewModelProviderFactory = Fragment.this.getDefaultViewModelProviderFactory();
                    Intrinsics.g(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, function0);
    }
}
