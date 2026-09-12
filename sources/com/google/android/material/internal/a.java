package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map f29191a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set f29192b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private b f29193c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f29194d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29195e;

    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0398a implements l.a {
        C0398a() {
        }

        @Override // com.google.android.material.internal.l.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l lVar, boolean z10) {
            if (!z10) {
                a aVar = a.this;
                if (!aVar.s(lVar, aVar.f29195e)) {
                    return;
                }
            } else if (!a.this.g(lVar)) {
                return;
            }
            a.this.n();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(Set set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(l lVar) {
        int id2 = lVar.getId();
        if (this.f29192b.contains(Integer.valueOf(id2))) {
            return false;
        }
        l lVar2 = (l) this.f29191a.get(Integer.valueOf(k()));
        if (lVar2 != null) {
            s(lVar2, false);
        }
        boolean add = this.f29192b.add(Integer.valueOf(id2));
        if (!lVar.isChecked()) {
            lVar.setChecked(true);
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        b bVar = this.f29193c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(l lVar, boolean z10) {
        int id2 = lVar.getId();
        if (!this.f29192b.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (z10 && this.f29192b.size() == 1 && this.f29192b.contains(Integer.valueOf(id2))) {
            lVar.setChecked(true);
            return false;
        }
        boolean remove = this.f29192b.remove(Integer.valueOf(id2));
        if (lVar.isChecked()) {
            lVar.setChecked(false);
        }
        return remove;
    }

    public void e(l lVar) {
        this.f29191a.put(Integer.valueOf(lVar.getId()), lVar);
        if (lVar.isChecked()) {
            g(lVar);
        }
        lVar.setInternalOnCheckedChangeListener(new C0398a());
    }

    public void f(int i11) {
        l lVar = (l) this.f29191a.get(Integer.valueOf(i11));
        if (lVar != null && g(lVar)) {
            n();
        }
    }

    public void h() {
        boolean isEmpty = this.f29192b.isEmpty();
        Iterator it = this.f29191a.values().iterator();
        while (it.hasNext()) {
            s((l) it.next(), false);
        }
        if (isEmpty) {
            return;
        }
        n();
    }

    public Set i() {
        return new HashSet(this.f29192b);
    }

    public List j(ViewGroup viewGroup) {
        Set i11 = i();
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
            View childAt = viewGroup.getChildAt(i12);
            if ((childAt instanceof l) && i11.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (!this.f29194d || this.f29192b.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f29192b.iterator().next()).intValue();
    }

    public boolean l() {
        return this.f29195e;
    }

    public boolean m() {
        return this.f29194d;
    }

    public void o(l lVar) {
        lVar.setInternalOnCheckedChangeListener(null);
        this.f29191a.remove(Integer.valueOf(lVar.getId()));
        this.f29192b.remove(Integer.valueOf(lVar.getId()));
    }

    public void p(b bVar) {
        this.f29193c = bVar;
    }

    public void q(boolean z10) {
        this.f29195e = z10;
    }

    public void r(boolean z10) {
        if (this.f29194d != z10) {
            this.f29194d = z10;
            h();
        }
    }
}
