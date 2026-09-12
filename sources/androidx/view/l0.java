package androidx.view;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.d;
import androidx.view.C1013c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: f, reason: collision with root package name */
    public static final a f9697f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Class[] f9698g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    private final Map f9699a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f9700b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f9701c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f9702d;

    /* renamed from: e, reason: collision with root package name */
    private final C1013c.InterfaceC0130c f9703e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l0 a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new l0();
                }
                HashMap hashMap = new HashMap();
                for (String key : bundle2.keySet()) {
                    Intrinsics.g(key, "key");
                    hashMap.put(key, bundle2.get(key));
                }
                return new l0(hashMap);
            }
            ClassLoader classLoader = l0.class.getClassLoader();
            Intrinsics.e(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj = parcelableArrayList.get(i11);
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i11));
            }
            return new l0(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : l0.f9698g) {
                Intrinsics.e(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public l0() {
        this.f9699a = new LinkedHashMap();
        this.f9700b = new LinkedHashMap();
        this.f9701c = new LinkedHashMap();
        this.f9702d = new LinkedHashMap();
        this.f9703e = new C1013c.InterfaceC0130c() { // from class: androidx.lifecycle.k0
            @Override // androidx.view.C1013c.InterfaceC0130c
            public final Bundle saveState() {
                Bundle d11;
                d11 = l0.d(l0.this);
                return d11;
            }
        };
    }

    public l0(Map initialState) {
        Intrinsics.h(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f9699a = linkedHashMap;
        this.f9700b = new LinkedHashMap();
        this.f9701c = new LinkedHashMap();
        this.f9702d = new LinkedHashMap();
        this.f9703e = new C1013c.InterfaceC0130c() { // from class: androidx.lifecycle.k0
            @Override // androidx.view.C1013c.InterfaceC0130c
            public final Bundle saveState() {
                Bundle d11;
                d11 = l0.d(l0.this);
                return d11;
            }
        };
        linkedHashMap.putAll(initialState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(l0 this$0) {
        Intrinsics.h(this$0, "this$0");
        for (Map.Entry entry : MapsKt.u(this$0.f9700b).entrySet()) {
            this$0.e((String) entry.getKey(), ((C1013c.InterfaceC0130c) entry.getValue()).saveState());
        }
        Set<String> keySet = this$0.f9699a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f9699a.get(str));
        }
        return d.b(TuplesKt.a("keys", arrayList), TuplesKt.a("values", arrayList2));
    }

    public final C1013c.InterfaceC0130c c() {
        return this.f9703e;
    }

    public final void e(String key, Object obj) {
        Intrinsics.h(key, "key");
        if (!f9697f.b(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            Intrinsics.e(obj);
            sb2.append(obj.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj2 = this.f9701c.get(key);
        b0 b0Var = obj2 instanceof b0 ? (b0) obj2 : null;
        if (b0Var != null) {
            b0Var.q(obj);
        } else {
            this.f9699a.put(key, obj);
        }
        y0 y0Var = (y0) this.f9702d.get(key);
        if (y0Var == null) {
            return;
        }
        y0Var.setValue(obj);
    }
}
