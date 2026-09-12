package com.google.firebase.perf.application;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.g;
import com.google.firebase.perf.util.e;
import com.google.firebase.perf.util.h;
import java.util.WeakHashMap;
import vc.k;

/* loaded from: classes4.dex */
public class c extends FragmentManager.k {

    /* renamed from: f, reason: collision with root package name */
    private static final sc.a f32268f = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap f32269a = new WeakHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.perf.util.a f32270b;

    /* renamed from: c, reason: collision with root package name */
    private final k f32271c;

    /* renamed from: d, reason: collision with root package name */
    private final a f32272d;

    /* renamed from: e, reason: collision with root package name */
    private final d f32273e;

    public c(com.google.firebase.perf.util.a aVar, k kVar, a aVar2, d dVar) {
        this.f32270b = aVar;
        this.f32271c = kVar;
        this.f32272d = aVar2;
        this.f32273e = dVar;
    }

    public String a(Fragment fragment) {
        return "_st_" + fragment.getClass().getSimpleName();
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        sc.a aVar = f32268f;
        aVar.b("FragmentMonitor %s.onFragmentPaused ", fragment.getClass().getSimpleName());
        if (!this.f32269a.containsKey(fragment)) {
            aVar.k("FragmentMonitor: missed a fragment trace from %s", fragment.getClass().getSimpleName());
            return;
        }
        Trace trace = (Trace) this.f32269a.get(fragment);
        this.f32269a.remove(fragment);
        e f11 = this.f32273e.f(fragment);
        if (!f11.d()) {
            aVar.k("onFragmentPaused: recorder failed to trace %s", fragment.getClass().getSimpleName());
        } else {
            h.a(trace, (g.a) f11.c());
            trace.stop();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        f32268f.b("FragmentMonitor %s.onFragmentResumed", fragment.getClass().getSimpleName());
        Trace trace = new Trace(a(fragment), this.f32271c, this.f32270b, this.f32272d);
        trace.start();
        trace.putAttribute("Parent_fragment", fragment.getParentFragment() == null ? "No parent" : fragment.getParentFragment().getClass().getSimpleName());
        if (fragment.getActivity() != null) {
            trace.putAttribute("Hosting_activity", fragment.getActivity().getClass().getSimpleName());
        }
        this.f32269a.put(fragment, trace);
        this.f32273e.d(fragment);
    }
}
