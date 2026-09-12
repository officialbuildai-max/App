package com.transsion.search;

import ak.k;
import ak.t;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.style.ImageSpan;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.PlayUrl;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class f {
    public static final ImageSpan a(Context context, int i11) {
        Intrinsics.h(context, "context");
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i11, 2) : new ImageSpan(context, i11, 1);
    }

    public static final ImageSpan b(Context context) {
        Intrinsics.h(context, "context");
        int i11 = R$drawable.ic_search_result_split;
        return Build.VERSION.SDK_INT >= 29 ? new ImageSpan(context, i11, 2) : new ImageSpan(context, i11, 1);
    }

    public static final void c(Subject subject, String playModule) {
        String playUrl;
        String playUrl2;
        Intrinsics.h(playModule, "playModule");
        if (subject == null) {
            return;
        }
        if (subject.isJumpBrowser()) {
            PlayUrl playUrl3 = subject.getPlayUrl();
            if (playUrl3 == null || (playUrl2 = playUrl3.getPlayUrl()) == null) {
                return;
            }
            k.i(playUrl2);
            return;
        }
        if (!subject.isJumpWebview()) {
            Navigator c11 = TheRouter.c("/movie/detail");
            Integer subjectType = subject.getSubjectType();
            k.p(c11.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("module_name", playModule).F("season", subject.getSeason()).z("autoPlay", true).K("ops", subject.getOps()));
        } else {
            PlayUrl playUrl4 = subject.getPlayUrl();
            if (playUrl4 == null || (playUrl = playUrl4.getPlayUrl()) == null) {
                return;
            }
            k.h(playUrl, null, 1, null);
        }
    }

    public static final String d(Subject subject, String pageName, Context context, String playModule) {
        String str;
        ResourceDetectors resourceDetector;
        String subjectId;
        ResourceDetectors resourceDetector2;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(context, "context");
        Intrinsics.h(playModule, "playModule");
        if (subject != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi.f58521j.a().d0((FragmentActivity) context, pageName, (r22 & 4) != 0 ? "" : "", subject.getOps(), (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : true, (r22 & 64) != 0 ? null : subject, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
                return "download_subject";
            }
        }
        if (t.f727a.b()) {
            c(subject, playModule);
        } else {
            DownloadManagerApi.a aVar = DownloadManagerApi.f58521j;
            if (!DownloadManagerApi.x0(aVar.a(), subject != null ? subject.getSubjectId() : null, (subject == null || (resourceDetector2 = subject.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId(), subject != null && subject.isSeries(), false, 8, null)) {
                DownloadManagerApi a11 = aVar.a();
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String ops = subject != null ? subject.getOps() : null;
                if (subject == null || (resourceDetector = subject.getResourceDetector()) == null || (str = resourceDetector.getResourceLink()) == null) {
                    str = "";
                }
                a11.K(fragmentActivity, subject, pageName, (r25 & 8) != 0 ? "" : null, ops, str, (r25 & 64) != 0 ? "" : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? false : false);
                return "download_subject";
            }
            if (subject != null && (subjectId = subject.getSubjectId()) != null) {
                DownloadManagerApi.z0(aVar.a(), subjectId, context, pageName, null, 8, null);
            }
        }
        return "play_subject";
    }

    public static final boolean e(Resources resources) {
        Intrinsics.h(resources, "resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }
}
