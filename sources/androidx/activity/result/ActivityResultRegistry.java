package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.view.Lifecycle;
import androidx.view.r;
import androidx.view.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: h, reason: collision with root package name */
    private static final b f970h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final Map f971a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f972b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f973c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final List f974d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final transient Map f975e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map f976f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f977g = new Bundle();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.activity.result.a f978a;

        /* renamed from: b, reason: collision with root package name */
        private final f.a f979b;

        public a(androidx.activity.result.a callback, f.a contract) {
            Intrinsics.h(callback, "callback");
            Intrinsics.h(contract, "contract");
            this.f978a = callback;
            this.f979b = contract;
        }

        public final androidx.activity.result.a a() {
            return this.f978a;
        }

        public final f.a b() {
            return this.f979b;
        }
    }

    /* loaded from: classes.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Lifecycle f980a;

        /* renamed from: b, reason: collision with root package name */
        private final List f981b;

        public c(Lifecycle lifecycle) {
            Intrinsics.h(lifecycle, "lifecycle");
            this.f980a = lifecycle;
            this.f981b = new ArrayList();
        }

        public final void a(r observer) {
            Intrinsics.h(observer, "observer");
            this.f980a.a(observer);
            this.f981b.add(observer);
        }

        public final void b() {
            Iterator it = this.f981b.iterator();
            while (it.hasNext()) {
                this.f980a.d((r) it.next());
            }
            this.f981b.clear();
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends androidx.activity.result.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f983b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f.a f984c;

        d(String str, f.a aVar) {
            this.f983b = str;
            this.f984c = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(Object obj, androidx.core.app.c cVar) {
            Object obj2 = ActivityResultRegistry.this.f972b.get(this.f983b);
            f.a aVar = this.f984c;
            if (obj2 != null) {
                int intValue = ((Number) obj2).intValue();
                ActivityResultRegistry.this.f974d.add(this.f983b);
                try {
                    ActivityResultRegistry.this.i(intValue, this.f984c, obj, cVar);
                    return;
                } catch (Exception e11) {
                    ActivityResultRegistry.this.f974d.remove(this.f983b);
                    throw e11;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.p(this.f983b);
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends androidx.activity.result.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f986b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f.a f987c;

        e(String str, f.a aVar) {
            this.f986b = str;
            this.f987c = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(Object obj, androidx.core.app.c cVar) {
            Object obj2 = ActivityResultRegistry.this.f972b.get(this.f986b);
            f.a aVar = this.f987c;
            if (obj2 != null) {
                int intValue = ((Number) obj2).intValue();
                ActivityResultRegistry.this.f974d.add(this.f986b);
                try {
                    ActivityResultRegistry.this.i(intValue, this.f987c, obj, cVar);
                    return;
                } catch (Exception e11) {
                    ActivityResultRegistry.this.f974d.remove(this.f986b);
                    throw e11;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.p(this.f986b);
        }
    }

    private final void d(int i11, String str) {
        this.f971a.put(Integer.valueOf(i11), str);
        this.f972b.put(str, Integer.valueOf(i11));
    }

    private final void g(String str, int i11, Intent intent, a aVar) {
        if ((aVar != null ? aVar.a() : null) == null || !this.f974d.contains(str)) {
            this.f976f.remove(str);
            this.f977g.putParcelable(str, new ActivityResult(i11, intent));
        } else {
            aVar.a().a(aVar.b().c(i11, intent));
            this.f974d.remove(str);
        }
    }

    private final int h() {
        for (Number number : SequencesKt.i(new Function0<Integer>() { // from class: androidx.activity.result.ActivityResultRegistry$generateRandomNumber$1
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(Random.INSTANCE.nextInt(2147418112) + 65536);
            }
        })) {
            if (!this.f971a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ActivityResultRegistry activityResultRegistry, String str, androidx.activity.result.a aVar, f.a aVar2, u uVar, Lifecycle.Event event) {
        Intrinsics.h(uVar, "<anonymous parameter 0>");
        Intrinsics.h(event, "event");
        if (Lifecycle.Event.ON_START != event) {
            if (Lifecycle.Event.ON_STOP == event) {
                activityResultRegistry.f975e.remove(str);
                return;
            } else {
                if (Lifecycle.Event.ON_DESTROY == event) {
                    activityResultRegistry.p(str);
                    return;
                }
                return;
            }
        }
        activityResultRegistry.f975e.put(str, new a(aVar, aVar2));
        if (activityResultRegistry.f976f.containsKey(str)) {
            Object obj = activityResultRegistry.f976f.get(str);
            activityResultRegistry.f976f.remove(str);
            aVar.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) androidx.core.os.c.a(activityResultRegistry.f977g, str, ActivityResult.class);
        if (activityResult != null) {
            activityResultRegistry.f977g.remove(str);
            aVar.a(aVar2.c(activityResult.getResultCode(), activityResult.getData()));
        }
    }

    private final void o(String str) {
        if (((Integer) this.f972b.get(str)) != null) {
            return;
        }
        d(h(), str);
    }

    public final boolean e(int i11, int i12, Intent intent) {
        String str = (String) this.f971a.get(Integer.valueOf(i11));
        if (str == null) {
            return false;
        }
        g(str, i12, intent, (a) this.f975e.get(str));
        return true;
    }

    public final boolean f(int i11, Object obj) {
        String str = (String) this.f971a.get(Integer.valueOf(i11));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.f975e.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.f977g.remove(str);
            this.f976f.put(str, obj);
            return true;
        }
        androidx.activity.result.a a11 = aVar.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.f974d.remove(str)) {
            return true;
        }
        a11.a(obj);
        return true;
    }

    public abstract void i(int i11, f.a aVar, Object obj, androidx.core.app.c cVar);

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.f974d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.f977g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            String str = stringArrayList.get(i11);
            if (this.f972b.containsKey(str)) {
                Integer num = (Integer) this.f972b.remove(str);
                if (!this.f977g.containsKey(str)) {
                    TypeIntrinsics.d(this.f971a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i11);
            Intrinsics.g(num2, "rcs[i]");
            int intValue = num2.intValue();
            String str2 = stringArrayList.get(i11);
            Intrinsics.g(str2, "keys[i]");
            d(intValue, str2);
        }
    }

    public final void k(Bundle outState) {
        Intrinsics.h(outState, "outState");
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f972b.values()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f972b.keySet()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f974d));
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.f977g));
    }

    public final androidx.activity.result.b l(final String key, u lifecycleOwner, final f.a contract, final androidx.activity.result.a callback) {
        Intrinsics.h(key, "key");
        Intrinsics.h(lifecycleOwner, "lifecycleOwner");
        Intrinsics.h(contract, "contract");
        Intrinsics.h(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        o(key);
        c cVar = (c) this.f973c.get(key);
        if (cVar == null) {
            cVar = new c(lifecycle);
        }
        cVar.a(new r() { // from class: androidx.activity.result.c
            @Override // androidx.view.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                ActivityResultRegistry.n(ActivityResultRegistry.this, key, callback, contract, uVar, event);
            }
        });
        this.f973c.put(key, cVar);
        return new d(key, contract);
    }

    public final androidx.activity.result.b m(String key, f.a contract, androidx.activity.result.a callback) {
        Intrinsics.h(key, "key");
        Intrinsics.h(contract, "contract");
        Intrinsics.h(callback, "callback");
        o(key);
        this.f975e.put(key, new a(callback, contract));
        if (this.f976f.containsKey(key)) {
            Object obj = this.f976f.get(key);
            this.f976f.remove(key);
            callback.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) androidx.core.os.c.a(this.f977g, key, ActivityResult.class);
        if (activityResult != null) {
            this.f977g.remove(key);
            callback.a(contract.c(activityResult.getResultCode(), activityResult.getData()));
        }
        return new e(key, contract);
    }

    public final void p(String key) {
        Integer num;
        Intrinsics.h(key, "key");
        if (!this.f974d.contains(key) && (num = (Integer) this.f972b.remove(key)) != null) {
            this.f971a.remove(num);
        }
        this.f975e.remove(key);
        if (this.f976f.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.f976f.get(key));
            this.f976f.remove(key);
        }
        if (this.f977g.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) androidx.core.os.c.a(this.f977g, key, ActivityResult.class)));
            this.f977g.remove(key);
        }
        c cVar = (c) this.f973c.get(key);
        if (cVar != null) {
            cVar.b();
            this.f973c.remove(key);
        }
    }
}
