package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.R$id;
import androidx.view.C1013c;
import androidx.view.InterfaceC1015e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class DisposableSaveableStateRegistry_androidKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Class[] f5707a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final u0 b(View view, InterfaceC1015e interfaceC1015e) {
        Object parent = view.getParent();
        Intrinsics.f(parent, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) parent;
        Object tag = view2.getTag(R$id.compose_view_saveable_id_tag);
        String str = tag instanceof String ? (String) tag : null;
        if (str == null) {
            str = String.valueOf(view2.getId());
        }
        return c(str, interfaceC1015e);
    }

    public static final u0 c(String str, InterfaceC1015e interfaceC1015e) {
        final boolean z10;
        final String str2 = androidx.compose.runtime.saveable.b.class.getSimpleName() + ':' + str;
        final C1013c savedStateRegistry = interfaceC1015e.getSavedStateRegistry();
        Bundle b11 = savedStateRegistry.b(str2);
        final androidx.compose.runtime.saveable.b a11 = SaveableStateRegistryKt.a(b11 != null ? h(b11) : null, new Function1<Object, Boolean>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                boolean f11;
                f11 = DisposableSaveableStateRegistry_androidKt.f(obj);
                return Boolean.valueOf(f11);
            }
        });
        try {
            savedStateRegistry.h(str2, new C1013c.InterfaceC0130c() { // from class: androidx.compose.ui.platform.v0
                @Override // androidx.view.C1013c.InterfaceC0130c
                public final Bundle saveState() {
                    Bundle d11;
                    d11 = DisposableSaveableStateRegistry_androidKt.d(androidx.compose.runtime.saveable.b.this);
                    return d11;
                }
            });
            z10 = true;
        } catch (IllegalArgumentException unused) {
            z10 = false;
        }
        return new u0(a11, new Function0<Unit>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m160invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m160invoke() {
                if (z10) {
                    savedStateRegistry.j(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(androidx.compose.runtime.saveable.b bVar) {
        return g(bVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Object obj) {
        if (obj instanceof androidx.compose.runtime.snapshots.r) {
            androidx.compose.runtime.snapshots.r rVar = (androidx.compose.runtime.snapshots.r) obj;
            if (rVar.getPolicy() != androidx.compose.runtime.r2.g() && rVar.getPolicy() != androidx.compose.runtime.r2.j() && rVar.getPolicy() != androidx.compose.runtime.r2.h()) {
                return false;
            }
            Object value = rVar.getValue();
            if (value == null) {
                return true;
            }
            return f(value);
        }
        if ((obj instanceof Function) && (obj instanceof Serializable)) {
            return false;
        }
        for (Class cls : f5707a) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    private static final Bundle g(Map map) {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            bundle.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
        }
        return bundle;
    }

    private static final Map h(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(str);
            Intrinsics.f(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            linkedHashMap.put(str, parcelableArrayList);
        }
        return linkedHashMap;
    }
}
