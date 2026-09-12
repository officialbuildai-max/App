package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    f f1508a;

    /* renamed from: b, reason: collision with root package name */
    private int f1509b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1510c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f1511d;

    /* renamed from: e, reason: collision with root package name */
    private final LayoutInflater f1512e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1513f;

    public e(f fVar, LayoutInflater layoutInflater, boolean z10, int i11) {
        this.f1511d = z10;
        this.f1512e = layoutInflater;
        this.f1508a = fVar;
        this.f1513f = i11;
        a();
    }

    void a() {
        h x10 = this.f1508a.x();
        if (x10 != null) {
            ArrayList B = this.f1508a.B();
            int size = B.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (((h) B.get(i11)) == x10) {
                    this.f1509b = i11;
                    return;
                }
            }
        }
        this.f1509b = -1;
    }

    public f b() {
        return this.f1508a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h getItem(int i11) {
        ArrayList B = this.f1511d ? this.f1508a.B() : this.f1508a.G();
        int i12 = this.f1509b;
        if (i12 >= 0 && i11 >= i12) {
            i11++;
        }
        return (h) B.get(i11);
    }

    public void d(boolean z10) {
        this.f1510c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1509b < 0 ? (this.f1511d ? this.f1508a.B() : this.f1508a.G()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return i11;
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1512e.inflate(this.f1513f, viewGroup, false);
        }
        int groupId = getItem(i11).getGroupId();
        int i12 = i11 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1508a.I() && groupId != (i12 >= 0 ? getItem(i12).getGroupId() : groupId));
        m.a aVar = (m.a) view;
        if (this.f1510c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i11), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
