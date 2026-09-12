package com.transsion.postdetail.util;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.push.api.IPushProvider;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public final class LocalFloatManager extends com.transsion.videofloat.manager.b {

    /* renamed from: b, reason: collision with root package name */
    public static final LocalFloatManager f50196b = new LocalFloatManager();

    private LocalFloatManager() {
    }

    private final DownloadBean c(px.a aVar) {
        Object obj;
        String p11;
        Iterator it = a().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.c(((DownloadBean) obj).getResourceId(), aVar != null ? aVar.p() : null)) {
                break;
            }
        }
        DownloadBean downloadBean = (DownloadBean) obj;
        if (downloadBean != null) {
            return downloadBean;
        }
        if (aVar == null || (p11 = aVar.p()) == null) {
            return null;
        }
        return DownloadEsHelper.f59542m.a().q(p11);
    }

    private final StringBuilder d(DownloadBean downloadBean) {
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/video/detail");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_resource_id");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(downloadBean.getResourceId());
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_local_path");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(downloadBean.getPath());
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_url");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(downloadBean.getUrl());
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("channel=video_float&");
        sb2.append("extra_page_from");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append("media_notification");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_completed");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(downloadBean.isCompleted());
        Intrinsics.g(sb2, "append(...)");
        return sb2;
    }

    private final MediaItem e(DownloadBean downloadBean) {
        String titleName = downloadBean.getTitleName();
        String subjectId = downloadBean.getSubjectId();
        return new MediaItem(titleName, "", downloadBean.getCover(), null, null, null, f(downloadBean), null, subjectId, downloadBean.getResourceId(), Boolean.FALSE, null, null, null, 14520, null);
    }

    private final PendingIntent f(DownloadBean downloadBean) {
        Intent intent;
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        StringBuilder d11 = d(downloadBean);
        if (iPushProvider != null) {
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            intent = iPushProvider.a(a11);
            if (intent != null) {
                intent.addFlags(603979776);
                intent.setData(Uri.parse(d11.toString()));
                return PendingIntent.getActivity(Utils.a(), 0, intent, g());
            }
        }
        intent = null;
        return PendingIntent.getActivity(Utils.a(), 0, intent, g());
    }

    private final int g() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(px.a aVar) {
        LocalFloatManager localFloatManager = f50196b;
        DownloadBean c11 = localFloatManager.c(aVar);
        if (c11 != null) {
            localFloatManager.i();
            StringBuilder d11 = localFloatManager.d(c11);
            lg.a.f68962a.i("VideoFloat", localFloatManager.getClass().getSimpleName() + " open page deeplink:" + ((Object) d11), true);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(d11.toString()));
            intent.setFlags(ASTNode.DEOP);
            Utils.a().startActivity(intent);
        } else {
            a.C0856a.l(lg.a.f68962a, "video_float", localFloatManager.getClass().getSimpleName() + " getCurPlayingBean null", false, 4, null);
        }
        return Unit.f67184a;
    }

    private final void n(px.a aVar, Function0 function0) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocalFloatManager$saveHistoryInner$1(aVar, function0, null), 3, null);
    }

    static /* synthetic */ void o(LocalFloatManager localFloatManager, px.a aVar, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        localFloatManager.n(aVar, function0);
    }

    public final String h(String tag) {
        Intrinsics.h(tag, "tag");
        return "LOCAL" + tag;
    }

    public void i() {
        a().clear();
    }

    public void j(final px.a aVar) {
        lg.a.f68962a.c("VideoFloat", LocalFloatManager.class.getSimpleName() + " --- openDetail", true);
        n(aVar, new Function0() { // from class: com.transsion.postdetail.util.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k11;
                k11 = LocalFloatManager.k(px.a.this);
                return k11;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l(px.a r15) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.util.LocalFloatManager.l(px.a):boolean");
    }

    public void m(px.a aVar) {
        o(this, aVar, null, 2, null);
    }

    public void p(List list) {
        Intrinsics.h(list, "list");
        a().clear();
        a().addAll(list);
    }
}
