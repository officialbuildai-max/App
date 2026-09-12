package m6;

import androidx.recyclerview.widget.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;
import r6.f;

/* loaded from: classes3.dex */
public final class e implements j {

    /* renamed from: a, reason: collision with root package name */
    private final BaseQuickAdapter f69467a;

    public e(BaseQuickAdapter mAdapter) {
        Intrinsics.h(mAdapter, "mAdapter");
        this.f69467a = mAdapter;
    }

    @Override // androidx.recyclerview.widget.j
    public void onChanged(int i11, int i12, Object obj) {
        BaseQuickAdapter baseQuickAdapter = this.f69467a;
        baseQuickAdapter.notifyItemRangeChanged(i11 + baseQuickAdapter.a0(), i12, obj);
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i11, int i12) {
        BaseQuickAdapter baseQuickAdapter = this.f69467a;
        baseQuickAdapter.notifyItemRangeInserted(i11 + baseQuickAdapter.a0(), i12);
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i11, int i12) {
        BaseQuickAdapter baseQuickAdapter = this.f69467a;
        baseQuickAdapter.notifyItemMoved(i11 + baseQuickAdapter.a0(), i12 + this.f69467a.a0());
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i11, int i12) {
        f i02 = this.f69467a.i0();
        if (i02 != null && i02.m() && this.f69467a.getItemCount() == 0) {
            BaseQuickAdapter baseQuickAdapter = this.f69467a;
            baseQuickAdapter.notifyItemRangeRemoved(i11 + baseQuickAdapter.a0(), i12 + 1);
        } else {
            BaseQuickAdapter baseQuickAdapter2 = this.f69467a;
            baseQuickAdapter2.notifyItemRangeRemoved(i11 + baseQuickAdapter2.a0(), i12);
        }
    }
}
