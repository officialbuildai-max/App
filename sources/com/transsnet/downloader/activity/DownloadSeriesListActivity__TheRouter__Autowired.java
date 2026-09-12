package com.transsnet.downloader.activity;

import androidx.annotation.Keep;
import com.therouter.TheRouter;
import java.util.Iterator;

@Keep
/* loaded from: classes7.dex */
public class DownloadSeriesListActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof DownloadSeriesListActivity) {
            DownloadSeriesListActivity downloadSeriesListActivity = (DownloadSeriesListActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                bg.a aVar = (bg.a) it.next();
                try {
                    Integer num = (Integer) aVar.a("int", downloadSeriesListActivity, new com.therouter.router.b("int", "extra_parent_position", 0, "", "com.transsnet.downloader.activity.DownloadSeriesListActivity", "parentPosition", false, "No desc."));
                    if (num != null) {
                        downloadSeriesListActivity.parentPosition = num.intValue();
                    }
                } catch (Exception e11) {
                    if (TheRouter.m()) {
                        e11.printStackTrace();
                    }
                }
                try {
                    String str = (String) aVar.a("java.lang.String", downloadSeriesListActivity, new com.therouter.router.b("java.lang.String", "extra_name", 0, "", "com.transsnet.downloader.activity.DownloadSeriesListActivity", "name", false, "No desc."));
                    if (str != null) {
                        downloadSeriesListActivity.name = str;
                    }
                } catch (Exception e12) {
                    if (TheRouter.m()) {
                        e12.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", downloadSeriesListActivity, new com.therouter.router.b("java.lang.String", "extra_subject_id", 0, "", "com.transsnet.downloader.activity.DownloadSeriesListActivity", "subjectId", false, "No desc."));
                    if (str2 != null) {
                        downloadSeriesListActivity.subjectId = str2;
                    }
                } catch (Exception e13) {
                    if (TheRouter.m()) {
                        e13.printStackTrace();
                    }
                }
            }
        }
    }
}
