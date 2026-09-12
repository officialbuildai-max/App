package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class BaseItemProvider {

    /* renamed from: a, reason: collision with root package name */
    public Context f21286a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference f21287b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f21288c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f21289d;

    public BaseItemProvider() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f21288c = LazyKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$clickViewIds$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.f21289d = LazyKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$longClickViewIds$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
    }

    private final ArrayList j() {
        return (ArrayList) this.f21288c.getValue();
    }

    private final ArrayList n() {
        return (ArrayList) this.f21289d.getValue();
    }

    public abstract void b(BaseViewHolder baseViewHolder, Object obj);

    public void f(BaseViewHolder helper, Object obj, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(payloads, "payloads");
    }

    public BaseProviderMultiAdapter g() {
        WeakReference weakReference = this.f21287b;
        if (weakReference != null) {
            return (BaseProviderMultiAdapter) weakReference.get();
        }
        return null;
    }

    public final ArrayList h() {
        return j();
    }

    public final ArrayList i() {
        return n();
    }

    public final Context k() {
        Context context = this.f21286a;
        if (context != null) {
            return context;
        }
        Intrinsics.z("context");
        return null;
    }

    public abstract int l();

    public abstract int m();

    public void o(BaseViewHolder helper, View view, Object obj, int i11) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(view, "view");
    }

    public boolean p(BaseViewHolder helper, View view, Object obj, int i11) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(view, "view");
        return false;
    }

    public void q(BaseViewHolder helper, View view, Object obj, int i11) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(view, "view");
    }

    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        return new BaseViewHolder(s6.a.a(parent, m()));
    }

    public boolean s(BaseViewHolder helper, View view, Object obj, int i11) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(view, "view");
        return false;
    }

    public void t(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
    }

    public void u(BaseViewHolder holder) {
        Intrinsics.h(holder, "holder");
    }

    public void v(BaseViewHolder viewHolder, int i11) {
        Intrinsics.h(viewHolder, "viewHolder");
    }

    public final void w(BaseProviderMultiAdapter adapter) {
        Intrinsics.h(adapter, "adapter");
        this.f21287b = new WeakReference(adapter);
    }

    public final void x(Context context) {
        Intrinsics.h(context, "<set-?>");
        this.f21286a = context;
    }
}
