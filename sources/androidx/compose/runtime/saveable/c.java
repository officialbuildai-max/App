package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f3985a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f3986b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f3987c;

    /* loaded from: classes.dex */
    public static final class a implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3989b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0 f3990c;

        a(String str, Function0 function0) {
            this.f3989b = str;
            this.f3990c = function0;
        }

        @Override // androidx.compose.runtime.saveable.b.a
        public void unregister() {
            List list = (List) c.this.f3987c.remove(this.f3989b);
            if (list != null) {
                list.remove(this.f3990c);
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            c.this.f3987c.put(this.f3989b, list);
        }
    }

    public c(Map map, Function1 function1) {
        Map w11;
        this.f3985a = function1;
        this.f3986b = (map == null || (w11 = MapsKt.w(map)) == null) ? new LinkedHashMap() : w11;
        this.f3987c = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.b
    public boolean a(Object obj) {
        return ((Boolean) this.f3985a.invoke(obj)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.b
    public b.a b(String str, Function0 function0) {
        boolean c11;
        c11 = SaveableStateRegistryKt.c(str);
        if (c11) {
            throw new IllegalArgumentException("Registered key is empty or blank");
        }
        Map map = this.f3987c;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new ArrayList();
            map.put(str, obj);
        }
        ((List) obj).add(function0);
        return new a(str, function0);
    }

    @Override // androidx.compose.runtime.saveable.b
    public Map e() {
        Map w11 = MapsKt.w(this.f3986b);
        for (Map.Entry entry : this.f3987c.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() == 1) {
                Object invoke = ((Function0) list.get(0)).invoke();
                if (invoke == null) {
                    continue;
                } else {
                    if (!a(invoke)) {
                        throw new IllegalStateException(RememberSaveableKt.b(invoke).toString());
                    }
                    w11.put(str, CollectionsKt.h(invoke));
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i11 = 0; i11 < size; i11++) {
                    Object invoke2 = ((Function0) list.get(i11)).invoke();
                    if (invoke2 != null && !a(invoke2)) {
                        throw new IllegalStateException(RememberSaveableKt.b(invoke2).toString());
                    }
                    arrayList.add(invoke2);
                }
                w11.put(str, arrayList);
            }
        }
        return w11;
    }

    @Override // androidx.compose.runtime.saveable.b
    public Object f(String str) {
        List list = (List) this.f3986b.remove(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            this.f3986b.put(str, list.subList(1, list.size()));
        }
        return list.get(0);
    }
}
