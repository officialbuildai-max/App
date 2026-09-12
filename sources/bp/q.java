package bp;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.view.PostBaseItemView;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class q extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final String f16775e;

    /* renamed from: f, reason: collision with root package name */
    private final String f16776f;

    /* renamed from: g, reason: collision with root package name */
    private final RecyclerView.s f16777g;

    public q(String str, String str2, RecyclerView.s pool) {
        Intrinsics.h(pool, "pool");
        this.f16775e = str;
        this.f16776f = str2;
        this.f16777g = pool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(PostSubjectItem postSubjectItem, q qVar) {
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f48920a;
        String str = qVar.f16775e;
        if (str == null) {
            str = "";
        }
        aVar.l(postSubjectItem, str, qVar.f16776f);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(q qVar, PostSubjectItem postSubjectItem) {
        int indexOf;
        BaseProviderMultiAdapter g11 = qVar.g();
        if (g11 != null && (indexOf = g11.getData().indexOf(postSubjectItem)) >= 0) {
            g11.C0(indexOf);
        }
        return Unit.f67184a;
    }

    private final void E(PostBaseItemView postBaseItemView, PostSubjectItem postSubjectItem, boolean z10) {
        if (postBaseItemView != null) {
            postBaseItemView.refreshLike(z10, postSubjectItem);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final PostSubjectItem item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        View view = helper.itemView;
        PostBaseItemView postBaseItemView = view instanceof PostBaseItemView ? (PostBaseItemView) view : null;
        if (postBaseItemView != null) {
            postBaseItemView.setPage(this.f16775e, this.f16776f);
            postBaseItemView.setOnNegativeFeedbackClick(new Function0() { // from class: bp.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit C;
                    C = q.C(PostSubjectItem.this, this);
                    return C;
                }
            });
            postBaseItemView.setData(item);
            postBaseItemView.setRecycledViewPool(this.f16777g);
            postBaseItemView.setOnNegativeFeedbackSuccess(new Function0() { // from class: bp.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit D;
                    D = q.D(q.this, item);
                    return D;
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, PostSubjectItem item, List payloads) {
        List<Object> data;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object v02 = CollectionsKt.v0(payloads);
        if (v02 instanceof Boolean) {
            try {
                Result.Companion companion = Result.INSTANCE;
                BaseProviderMultiAdapter g11 = g();
                if (g11 != null && (data = g11.getData()) != null) {
                    int adapterPosition = helper.getAdapterPosition();
                    BaseProviderMultiAdapter g12 = g();
                    PostSubjectItem postSubjectItem = (PostSubjectItem) data.get(adapterPosition + (g12 != null ? g12.a0() : 0));
                    if (postSubjectItem != null) {
                        View view = helper.itemView;
                        E(view instanceof PostBaseItemView ? (PostBaseItemView) view : null, postSubjectItem, ((Boolean) v02).booleanValue());
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return MediaType.CONTENT_ALL.ordinal();
    }
}
