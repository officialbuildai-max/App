package bp;

import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f16758e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f16759f;

    /* renamed from: g, reason: collision with root package name */
    private final String f16760g;

    /* renamed from: h, reason: collision with root package name */
    private final String f16761h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f16762i;

    /* renamed from: j, reason: collision with root package name */
    private final String f16763j;

    /* renamed from: k, reason: collision with root package name */
    private final String f16764k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f16765l;

    /* renamed from: m, reason: collision with root package name */
    private final int f16766m;

    /* renamed from: n, reason: collision with root package name */
    private final int f16767n;

    public e(Fragment fragment, boolean z10, String str, String str2, boolean z11, String commentId, String pageFrom, boolean z12) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(commentId, "commentId");
        Intrinsics.h(pageFrom, "pageFrom");
        this.f16758e = fragment;
        this.f16759f = z10;
        this.f16760g = str;
        this.f16761h = str2;
        this.f16762i = z11;
        this.f16763j = commentId;
        this.f16764k = pageFrom;
        this.f16765l = z12;
        this.f16766m = 1;
        this.f16767n = R$layout.item_immersion_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return this.f16766m;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return this.f16767n;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder holder, PostSubjectItem item) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ((ImmVideoItemView) holder.getView(R$id.view_video_item)).setData(item, this.f16758e, Integer.valueOf(holder.getAdapterPosition()), this.f16759f, this.f16760g, this.f16761h, this.f16762i, this.f16763j, this.f16764k, this.f16765l);
    }
}
