package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.j0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements f.b, m, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f1443c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    private f f1444a;

    /* renamed from: b, reason: collision with root package name */
    private int f1445b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        j0 v11 = j0.v(context, attributeSet, f1443c, i11, 0);
        if (v11.s(0)) {
            setBackgroundDrawable(v11.g(0));
        }
        if (v11.s(1)) {
            setDivider(v11.g(1));
        }
        v11.x();
    }

    public int getWindowAnimations() {
        return this.f1445b;
    }

    @Override // androidx.appcompat.view.menu.m
    public void initialize(f fVar) {
        this.f1444a = fVar;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public boolean invokeItem(h hVar) {
        return this.f1444a.O(hVar, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
        invokeItem((h) getAdapter().getItem(i11));
    }
}
