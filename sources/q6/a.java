package q6;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: q6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C0919a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f73235a;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            try {
                iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadMoreStatus.End.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f73235a = iArr;
        }
    }

    private final void a(View view, boolean z10) {
        view.setVisibility(z10 ? 0 : 8);
    }

    public void convert(BaseViewHolder holder, int i11, LoadMoreStatus loadMoreStatus) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(loadMoreStatus, "loadMoreStatus");
        int i12 = C0919a.f73235a[loadMoreStatus.ordinal()];
        if (i12 == 1) {
            a(getLoadingView(holder), false);
            a(getLoadComplete(holder), true);
            a(getLoadFailView(holder), false);
            a(getLoadEndView(holder), false);
            return;
        }
        if (i12 == 2) {
            a(getLoadingView(holder), true);
            a(getLoadComplete(holder), false);
            a(getLoadFailView(holder), false);
            a(getLoadEndView(holder), false);
            return;
        }
        if (i12 == 3) {
            a(getLoadingView(holder), false);
            a(getLoadComplete(holder), false);
            a(getLoadFailView(holder), true);
            a(getLoadEndView(holder), false);
            return;
        }
        if (i12 != 4) {
            return;
        }
        a(getLoadingView(holder), false);
        a(getLoadComplete(holder), false);
        a(getLoadFailView(holder), false);
        a(getLoadEndView(holder), true);
    }

    public abstract View getLoadComplete(BaseViewHolder baseViewHolder);

    public abstract View getLoadEndView(BaseViewHolder baseViewHolder);

    public abstract View getLoadFailView(BaseViewHolder baseViewHolder);

    public abstract View getLoadingView(BaseViewHolder baseViewHolder);

    public abstract View getRootView(ViewGroup viewGroup);
}
