package com.transsion.subtitle_download.task;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f55164a = new q();

    private q() {
    }

    private final String a() {
        String simpleName = q.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void b(String str, SubtitleDownloadTable subtitleDownloadTable) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("resource_id", subtitleDownloadTable.getResourceId());
        String taskId = subtitleDownloadTable.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        linkedHashMap.put("taskId", taskId);
        String subjectId = subtitleDownloadTable.getSubjectId();
        if (subjectId != null && subjectId.length() != 0) {
            String subjectId2 = subtitleDownloadTable.getSubjectId();
            if (subjectId2 == null) {
                subjectId2 = "";
            }
            linkedHashMap.put("subject_id", subjectId2);
        }
        String ops = subtitleDownloadTable.getOps();
        if (ops != null && ops.length() != 0) {
            String ops2 = subtitleDownloadTable.getOps();
            if (ops2 == null) {
                ops2 = "";
            }
            linkedHashMap.put("ops", ops2);
        }
        if (subtitleDownloadTable.getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(subtitleDownloadTable.getEp()));
        }
        if (subtitleDownloadTable.getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(subtitleDownloadTable.getSe()));
        }
        String lan = subtitleDownloadTable.getLan();
        if (lan == null) {
            lan = "";
        }
        linkedHashMap.put("lan", lan);
        String lanName = subtitleDownloadTable.getLanName();
        linkedHashMap.put("lan_name", lanName != null ? lanName : "");
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(subtitleDownloadTable.getType()));
        linkedHashMap.put(NotificationCompat.CATEGORY_STATUS, String.valueOf(subtitleDownloadTable.getStatus()));
        linkedHashMap.put(EventConstants.KEY_ACTION, str);
        hj.i.f64628a.s("st_download_v2", "subtitle_download", linkedHashMap);
    }

    public final void c(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        com.transsion.subtitle_download.utils.b.f55167a.c(a() + " --> reportDownloadSuccess() --> 字幕任务下载成功 --> taskId = " + stDownloadTable.getTaskId() + " ");
        b(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, stDownloadTable);
    }

    public final void d(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        if (TextUtils.isEmpty(stDownloadTable.getTaskId())) {
            String g11 = com.transsion.subtitle_download.utils.e.f55170a.g();
            stDownloadTable.setTaskId(g11);
            SubtitleDownloadDatabase.Companion companion = SubtitleDownloadDatabase.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            companion.b(a11).l0().f(stDownloadTable);
            com.transsion.subtitle_download.utils.b.f55167a.c(a() + " --> reportDownloadTrigger() --> 用户创建了字幕下载任务 --> taskId = " + g11);
            b("trigger", stDownloadTable);
        }
    }
}
