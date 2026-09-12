package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d implements l, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    Context f1496a;

    /* renamed from: b, reason: collision with root package name */
    LayoutInflater f1497b;

    /* renamed from: c, reason: collision with root package name */
    f f1498c;

    /* renamed from: d, reason: collision with root package name */
    ExpandedMenuView f1499d;

    /* renamed from: e, reason: collision with root package name */
    int f1500e;

    /* renamed from: f, reason: collision with root package name */
    int f1501f;

    /* renamed from: g, reason: collision with root package name */
    int f1502g;

    /* renamed from: h, reason: collision with root package name */
    private l.a f1503h;

    /* renamed from: i, reason: collision with root package name */
    a f1504i;

    /* renamed from: j, reason: collision with root package name */
    private int f1505j;

    /* loaded from: classes.dex */
    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f1506a = -1;

        public a() {
            a();
        }

        void a() {
            h x10 = d.this.f1498c.x();
            if (x10 != null) {
                ArrayList B = d.this.f1498c.B();
                int size = B.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (((h) B.get(i11)) == x10) {
                        this.f1506a = i11;
                        return;
                    }
                }
            }
            this.f1506a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public h getItem(int i11) {
            ArrayList B = d.this.f1498c.B();
            int i12 = i11 + d.this.f1500e;
            int i13 = this.f1506a;
            if (i13 >= 0 && i12 >= i13) {
                i12++;
            }
            return (h) B.get(i12);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = d.this.f1498c.B().size() - d.this.f1500e;
            return this.f1506a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                d dVar = d.this;
                view = dVar.f1497b.inflate(dVar.f1502g, viewGroup, false);
            }
            ((m.a) view).initialize(getItem(i11), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public d(int i11, int i12) {
        this.f1502g = i11;
        this.f1501f = i12;
    }

    public d(Context context, int i11) {
        this(i11, 0);
        this.f1496a = context;
        this.f1497b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f1504i == null) {
            this.f1504i = new a();
        }
        return this.f1504i;
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z10) {
        l.a aVar = this.f1503h;
        if (aVar != null) {
            aVar.b(fVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1503h = aVar;
    }

    @Override // androidx.appcompat.view.menu.l
    public void e(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        new g(qVar).d(null);
        l.a aVar = this.f1503h;
        if (aVar == null) {
            return true;
        }
        aVar.c(qVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        if (this.f1499d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f1505j;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        a aVar = this.f1504i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, f fVar) {
        if (this.f1501f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1501f);
            this.f1496a = contextThemeWrapper;
            this.f1497b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1496a != null) {
            this.f1496a = context;
            if (this.f1497b == null) {
                this.f1497b = LayoutInflater.from(context);
            }
        }
        this.f1498c = fVar;
        a aVar = this.f1504i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public m l(ViewGroup viewGroup) {
        if (this.f1499d == null) {
            this.f1499d = (ExpandedMenuView) this.f1497b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1504i == null) {
                this.f1504i = new a();
            }
            this.f1499d.setAdapter((ListAdapter) this.f1504i);
            this.f1499d.setOnItemClickListener(this);
        }
        return this.f1499d;
    }

    public void m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1499d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1499d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        this.f1498c.P(this.f1504i.getItem(i11), this, 0);
    }
}
