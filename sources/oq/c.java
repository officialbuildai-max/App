package oq;

import android.content.Context;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.moviedetailapi.g;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import ej.f;
import jn.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends BaseItemProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_works_layout_room;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, VideoDetailPlayBean item) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Context context = helper.itemView.getContext();
        ImageView imageView = (ImageView) helper.itemView.findViewById(R$id.ivCover);
        String coverUrl = item.getCoverUrl();
        if (coverUrl != null) {
            f.a aVar = f.f62005a;
            Intrinsics.e(context);
            f.b g11 = aVar.m(context).g(coverUrl);
            String thumbnail = item.getThumbnail();
            if (thumbnail == null) {
                thumbnail = "";
            }
            f.b l11 = g11.l(thumbnail);
            Intrinsics.e(imageView);
            l11.d(imageView);
        }
        helper.setText(R$id.tvSubject, item.getTitle());
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvTag);
        if (appCompatTextView != null) {
            appCompatTextView.setText(" " + e.f66368a.g(item.getSubjectType()));
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(g.a(item.getSubjectType()), 0, 0, 0);
        }
    }
}
