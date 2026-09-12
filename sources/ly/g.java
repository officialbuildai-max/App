package ly;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.s;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.ugcvideodetail.api.UGCVideoTypeKt;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.DownloadedHolderKt;
import com.transsnet.downloader.adapter.LayoutType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nh.m;

/* loaded from: classes7.dex */
public final class g extends BaseItemProvider {

    /* renamed from: l, reason: collision with root package name */
    public static final a f69191l = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final int f69192e = R$string.downloading_time_left;

    /* renamed from: f, reason: collision with root package name */
    private final int f69193f = R$string.download_status_waiting;

    /* renamed from: g, reason: collision with root package name */
    private final int f69194g = R$string.download_status_paused;

    /* renamed from: h, reason: collision with root package name */
    private final int f69195h = R$string.download_status_failed;

    /* renamed from: i, reason: collision with root package name */
    private final int f69196i = R$string.download_status_no_net;

    /* renamed from: j, reason: collision with root package name */
    private final oy.c f69197j = new oy.c();

    /* renamed from: k, reason: collision with root package name */
    private final Map f69198k = new LinkedHashMap();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f69199a;

        /* renamed from: b, reason: collision with root package name */
        private final long f69200b;

        public b(long j11, long j12) {
            this.f69199a = j11;
            this.f69200b = j12;
        }

        public final long a() {
            return this.f69199a;
        }

        public final long b() {
            return this.f69200b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f69199a == bVar.f69199a && this.f69200b == bVar.f69200b;
        }

        public int hashCode() {
            return (s.a(this.f69199a) * 31) + s.a(this.f69200b);
        }

        public String toString() {
            return "SpeedSnapshot(progress=" + this.f69199a + ", timeStamp=" + this.f69200b + ")";
        }
    }

    private final void B(BaseViewHolder baseViewHolder, DownloadBean downloadBean) {
        Object y10;
        long progress = downloadBean.getProgress();
        if (progress < 0) {
            progress = 0;
        }
        Long size = downloadBean.getSize();
        long longValue = size != null ? size.longValue() : 1L;
        if (longValue <= 0) {
            longValue = 1;
        }
        float f11 = 100;
        int i11 = (int) (((((float) progress) * 1.0f) / ((float) longValue)) * f11);
        boolean a11 = com.transsnet.downloader.util.h.f60061a.a();
        int status = downloadBean.getStatus();
        if (status == 1 || status == 2) {
            ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.pb_download);
            progressBar.setProgressDrawable(androidx.core.content.b.getDrawable(baseViewHolder.itemView.getContext(), a11 ? R$drawable.bg_progress_bar_svip : R$drawable.bg_progress_bar_pause));
            progressBar.setSecondaryProgress(downloadBean.getIsPreDownload() ? i11 : 0);
            if (downloadBean.getIsPreDownload()) {
                i11 = 0;
            }
            progressBar.setProgress(i11);
        } else {
            ProgressBar progressBar2 = (ProgressBar) baseViewHolder.getView(R$id.pb_download);
            progressBar2.setProgressDrawable(androidx.core.content.b.getDrawable(baseViewHolder.itemView.getContext(), R$drawable.bg_progress_bar_pause));
            progressBar2.setSecondaryProgress(i11);
            progressBar2.setProgress(0);
        }
        new StringBuilder(oh.b.a(progress, 1));
        oh.b.a(longValue, 1);
        ((TextView) baseViewHolder.getView(R$id.tv_state_progress)).setText(oh.b.a(longValue, 1));
        int i12 = R$color.white_80;
        int status2 = downloadBean.getStatus();
        if (status2 == 1 || status2 == 2) {
            if (downloadBean.getIsPreDownload()) {
                y10 = Integer.valueOf(this.f69193f);
            } else {
                i12 = R$color.white_80;
                y10 = y(downloadBean);
            }
        } else if (status2 == 3) {
            y10 = Integer.valueOf(this.f69193f);
        } else if (status2 == 4) {
            y10 = Integer.valueOf(this.f69194g);
            i12 = R$color.error_50;
        } else if (status2 != 6) {
            y10 = null;
        } else {
            y10 = (downloadBean.isNoNetError() || !m.f70597a.e()) ? Integer.valueOf(this.f69196i) : Integer.valueOf(this.f69195h);
            i12 = R$color.error_50;
        }
        TnTextView tnTextView = (TnTextView) baseViewHolder.getView(R$id.tv_time_or_status);
        if (y10 instanceof Integer) {
            tnTextView.setTextById(((Number) y10).intValue());
        } else if (y10 instanceof String) {
            tnTextView.setTextWithString((CharSequence) y10);
        }
        tnTextView.setTextColor(androidx.core.content.b.getColor(baseViewHolder.itemView.getContext(), i12));
        C(baseViewHolder, downloadBean, a11);
        int status3 = downloadBean.getStatus();
        if (status3 == 1 || status3 == 2 || status3 == 3) {
            ((AppCompatImageView) baseViewHolder.getView(R$id.iv_state_bg)).setImageResource(R$mipmap.ic_download_pause);
        } else if (status3 == 4 || status3 == 6) {
            ((AppCompatImageView) baseViewHolder.getView(R$id.iv_state_bg)).setImageResource(R$mipmap.ic_download_downloading);
        }
        long readProgress = downloadBean.getReadProgress();
        Long duration = downloadBean.getDuration();
        long longValue2 = duration != null ? duration.longValue() : 1L;
        ((ProgressBar) baseViewHolder.getView(R$id.progress_bar)).setProgress((int) (((((float) readProgress) * 1.0f) / ((float) (longValue2 <= 0 ? 1L : longValue2))) * f11));
    }

    private final void C(BaseViewHolder baseViewHolder, DownloadBean downloadBean, boolean z10) {
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R$id.speedLimitContainer);
        TextView textView = (TextView) baseViewHolder.getView(R$id.tvSpeedLimitSpeed);
        boolean z11 = downloadBean.getStatus() == 1 || downloadBean.getStatus() == 2;
        double k11 = RangesKt.k(this.f69197j.d(), 0.0d, 1.0d);
        long currentDownloadSpeed = (long) (downloadBean.getCurrentDownloadSpeed() * k11);
        if (!z10 || !z11 || downloadBean.getIsPreDownload() || k11 <= 0.0d || currentDownloadSpeed <= 0) {
            constraintLayout.setVisibility(8);
            textView.setText("");
            return;
        }
        constraintLayout.setVisibility(0);
        textView.setText("+" + oh.b.b(currentDownloadSpeed, 1, 0) + "/s");
    }

    private final String y(DownloadBean downloadBean) {
        long currentDownloadSpeed;
        long currentTimeMillis = System.currentTimeMillis();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        b bVar = (b) this.f69198k.get(resourceId);
        long b11 = bVar == null ? 0L : (currentTimeMillis - bVar.b()) / 1000;
        if (bVar != null && b11 < 2 && downloadBean.getCurrentDownloadSpeed() > 0) {
            return oh.b.b(downloadBean.getCurrentDownloadSpeed(), 1, 0) + "/s";
        }
        if (bVar == null || b11 <= 0) {
            currentDownloadSpeed = downloadBean.getCurrentDownloadSpeed();
        } else {
            long progress = downloadBean.getProgress() - bVar.a();
            currentDownloadSpeed = progress > 0 ? progress / b11 : downloadBean.getCurrentDownloadSpeed();
        }
        this.f69198k.put(resourceId, new b(downloadBean.getProgress(), currentTimeMillis));
        if (currentDownloadSpeed <= 0) {
            return "0KB/s";
        }
        downloadBean.setCurrentDownloadSpeed(currentDownloadSpeed);
        return oh.b.b(currentDownloadSpeed, 1, 0) + "/s";
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void f(BaseViewHolder helper, DownloadBean item, List payloads) {
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.f(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object v02 = CollectionsKt.v0(payloads);
        if (v02 instanceof DownloadBean) {
            DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
            DownloadBean downloadBean = (DownloadBean) v02;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = item.getUrl();
            }
            DownloadBean q11 = a11.q(resourceId);
            if (q11 != null) {
                downloadBean = q11;
            }
            B(helper, downloadBean);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return LayoutType.NO_DONE_LAYOUT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.adapter_downloading_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, DownloadBean item) {
        String ugcVideoType;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
        String resourceId = item.getResourceId();
        if (resourceId == null) {
            resourceId = item.getUrl();
        }
        DownloadBean q11 = a11.q(resourceId);
        if (q11 == null) {
            q11 = item;
        }
        View view = helper.getView(R$id.card_cover);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int position = helper.getPosition();
        BaseProviderMultiAdapter g11 = g();
        marginLayoutParams.bottomMargin = dk.a.b(position == (g11 != null ? g11.getItemCount() : 0) - 1 ? 16 : 12);
        view.setLayoutParams(marginLayoutParams);
        String cover = q11.getCover();
        if (cover != null) {
            Context context = helper.itemView.getContext();
            Intrinsics.g(context, "getContext(...)");
            DownloadedHolderKt.a(context, (ImageView) helper.getView(R$id.iv_cover), cover, item.getThumbnail());
        }
        boolean z10 = item.getType() == 9;
        helper.setGone(R$id.tv_shorts, !z10);
        if (z10) {
            helper.setGone(R$id.iv_type, true);
        } else {
            helper.setGone(R$id.iv_type, false);
            AppCompatImageView appCompatImageView = (AppCompatImageView) helper.getView(R$id.iv_type);
            if (!q11.isUGCVideo() || (ugcVideoType = q11.getUgcVideoType()) == null || ugcVideoType.length() == 0) {
                appCompatImageView.setImageResource(com.transsion.moviedetailapi.g.a(Integer.valueOf(q11.getSubjectType())));
            } else {
                UGCVideoTypeKt.j(appCompatImageView, q11.getUgcCateLev1Id(), q11.getUgcCateLev2Id(), q11.getUgcCateLev3Id(), q11.getUgcCateLev4Id(), q11.getUgcVideoType());
            }
        }
        TextView textView = (TextView) helper.getView(R$id.tv_name);
        textView.setText(q11.getTitleNameAppendResolution());
        textView.setTag(q11.getResourceId());
        TextView textView2 = (TextView) helper.getView(R$id.tv_ep);
        textView2.setVisibility(q11.getEpName().length() > 0 ? 0 : 8);
        textView2.setText(q11.getEpName());
        B(helper, q11);
    }
}
