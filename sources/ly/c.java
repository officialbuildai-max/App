package ly;

import android.view.View;
import androidx.view.b0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.adapter.LayoutType;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nh.m;

/* loaded from: classes7.dex */
public final class c extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final DownloadViewModel f69181e;

    /* renamed from: f, reason: collision with root package name */
    private int f69182f = 1;

    public c(DownloadViewModel downloadViewModel) {
        this.f69181e = downloadViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(c cVar) {
        if (!m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return Unit.f67184a;
        }
        DownloadViewModel downloadViewModel = cVar.f69181e;
        if (downloadViewModel != null) {
            int i11 = cVar.f69182f + 1;
            cVar.f69182f = i11;
            downloadViewModel.S(i11, 6);
        }
        return Unit.f67184a;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return LayoutType.FOR_YOU.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.adapter_download_item_for_you;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, DownloadBean item) {
        b0 T;
        BaseDto baseDto;
        MovieRecBean movieRecBean;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        DownloadViewModel downloadViewModel = this.f69181e;
        List<Subject> items = (downloadViewModel == null || (T = downloadViewModel.T()) == null || (baseDto = (BaseDto) T.f()) == null || (movieRecBean = (MovieRecBean) baseDto.getData()) == null) ? null : movieRecBean.getItems();
        List<Subject> list = items;
        if (list == null || list.isEmpty()) {
            View itemView = helper.itemView;
            Intrinsics.g(itemView, "itemView");
            jg.c.g(itemView);
            return;
        }
        View itemView2 = helper.itemView;
        Intrinsics.g(itemView2, "itemView");
        jg.c.k(itemView2);
        DownloadPanelForYouFootView downloadPanelForYouFootView = (DownloadPanelForYouFootView) helper.getView(R$id.v_for_you);
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseProviderMultiAdapter g11 = g();
            downloadPanelForYouFootView.initBrowseReport(g11 != null ? g11.getRecyclerView() : null);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        downloadPanelForYouFootView.setRefreshClickCallback(new Function0() { // from class: ly.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit A;
                A = c.A(c.this);
                return A;
            }
        });
        downloadPanelForYouFootView.setData(items);
    }
}
