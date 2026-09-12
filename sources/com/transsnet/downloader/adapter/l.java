package com.transsnet.downloader.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.fragment.DownloadMultiListFragment;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class l extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final ny.c f58630a;

    /* renamed from: b, reason: collision with root package name */
    private List f58631b;

    /* renamed from: c, reason: collision with root package name */
    private Subject f58632c;

    /* renamed from: d, reason: collision with root package name */
    private String f58633d;

    /* renamed from: e, reason: collision with root package name */
    private String f58634e;

    /* renamed from: f, reason: collision with root package name */
    private String f58635f;

    /* renamed from: g, reason: collision with root package name */
    private String f58636g;

    /* renamed from: h, reason: collision with root package name */
    private String f58637h;

    /* renamed from: i, reason: collision with root package name */
    private int f58638i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f58639j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f58640k;

    /* renamed from: l, reason: collision with root package name */
    private final Map f58641l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FragmentActivity activity, ny.c tabControl) {
        super(activity);
        Intrinsics.h(activity, "activity");
        Intrinsics.h(tabControl, "tabControl");
        this.f58630a = tabControl;
        this.f58641l = new LinkedHashMap();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        ResourcesSeason h11 = h(i11);
        DownloadMultiListFragment a11 = DownloadMultiListFragment.INSTANCE.a(this.f58634e, this.f58635f, this.f58632c, this.f58633d, this.f58636g, this.f58637h, 0, i11, this.f58640k, false, h11 != null ? h11.getSe() : 0, this.f58638i, i11);
        a11.p1(this.f58631b);
        a11.q1(this.f58630a);
        this.f58641l.put(Integer.valueOf(i11), new WeakReference(a11));
        return a11;
    }

    public final DownloadMultiListFragment g(int i11) {
        WeakReference weakReference = (WeakReference) this.f58641l.get(Integer.valueOf(i11));
        if (weakReference != null) {
            return (DownloadMultiListFragment) weakReference.get();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.f58631b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final ResourcesSeason h(int i11) {
        List list = this.f58631b;
        if (list != null) {
            return (ResourcesSeason) CollectionsKt.l0(list, i11);
        }
        return null;
    }

    public final void i(String str) {
        this.f58633d = str;
    }

    public final void j(String str) {
        this.f58635f = str;
    }

    public final void k(String str) {
        this.f58636g = str;
    }

    public final void l(String str) {
        this.f58634e = str;
    }

    public final void m(Integer num) {
        this.f58639j = num;
    }

    public final void n(boolean z10) {
        this.f58640k = z10;
    }

    public final void o(Subject subject) {
        this.f58632c = subject;
    }

    public final void p(String str) {
        this.f58637h = str;
    }

    public final void q(int i11) {
        this.f58638i = i11;
    }

    public final void setData(List list) {
        this.f58631b = list;
    }
}
