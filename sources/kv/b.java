package kv;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.transfer.impl.l;
import com.transsion.transfer.wifi.bean.ReportTransferAction;
import com.transsion.transfer.wifi.util.g;
import hj.i;
import java.util.LinkedHashMap;
import java.util.Map;
import jv.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f68518a = new b();

    private b() {
    }

    private final String a() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final Map b(ReportTransferAction reportTransferAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ReportTransferAction.REPORT_TRANSFER_ACTION.getAction(), reportTransferAction.getAction());
        return linkedHashMap;
    }

    private final void c(Map map) {
        i.f64628a.D("transfer_status", map);
    }

    public final void d(String error, String str) {
        Intrinsics.h(error, "error");
        Map b11 = b(ReportTransferAction.xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED);
        b11.put("error", error);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientConnectFailed() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void e(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS);
        g.f(g.f56093a, a() + " --> reportClientConnectSuccess() --> map = " + b11, false, 2, null);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        c(b11);
    }

    public final void f(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportServerReceiveDisconnectClick() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void g(String remoteFilePath, boolean z10, String str, long j11, long j12, String str2) {
        Object m1185constructorimpl;
        Intrinsics.h(remoteFilePath, "remoteFilePath");
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END);
        b11.put("task_id", d.b(remoteFilePath));
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(StringsKt.c1(jv.a.a(remoteFilePath), '.', ""));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = "";
        }
        b11.put("file_type", m1185constructorimpl);
        b11.put(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, String.valueOf(z10));
        if (str == null) {
            str = "";
        }
        b11.put("error", str);
        b11.put("file_size", String.valueOf(j11));
        b11.put("time_cost", String.valueOf(j12));
        if (str2 == null) {
            str2 = "";
        }
        b11.put("transfer_id", str2);
        g.f(g.f56093a, a() + " --> reportClientDownloadFileEnd() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void h(String path, long j11, String str) {
        Intrinsics.h(path, "path");
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START);
        b11.put("task_id", d.b(path));
        b11.put("file_size", String.valueOf(j11));
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientDownloadFileStart() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void i(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientFetchFilesStart() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void j(String str, String str2) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT);
        if (str == null) {
            str = "";
        }
        b11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, str);
        if (str2 == null) {
            str2 = "";
        }
        b11.put("transfer_id", str2);
        g.f(g.f56093a, a() + " --> reportClientReceiveDisconnect() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void k(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientReceiveServerUpdateFileList() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void l(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientSendFileNotify() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void m(int i11, String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH);
        b11.put("file_list_size", String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientServerFilesFinish() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void n(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        g.f(g.f56093a, a() + " --> reportClientStartConnect() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void o(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        b11.put("transfer_channel_info", l.f55892a.a());
        g.f(g.f56093a, a() + " --> reportServerConnectSuccess() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void p(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        b11.put("transfer_channel_info", l.f55892a.a());
        g.f(g.f56093a, a() + " --> reportServerReceiveDisconnectClick() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void q(int i11, String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE);
        b11.put("file_list_size", String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        b11.put("transfer_channel_info", l.f55892a.a());
        g.f(g.f56093a, a() + " --> reportServerHandleFetchFiles() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void r() {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_OPEN);
        g.f(g.f56093a, a() + " --> reportServerOpen() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void s(String str, String str2) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_DISCONNECT);
        if (str == null) {
            str = "";
        }
        b11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, str);
        if (str2 == null) {
            str2 = "";
        }
        b11.put("transfer_id", str2);
        b11.put("transfer_channel_info", l.f55892a.a());
        g.f(g.f56093a, a() + " --> reportServerReceiveDisconnect() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void t(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        b11.put("transfer_channel_info", l.f55892a.a());
        g.f(g.f56093a, a() + " --> reportServerReceiveFile() --> map = " + b11, false, 2, null);
        c(b11);
    }

    public final void u(String str) {
        Map b11 = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD);
        if (str == null) {
            str = "";
        }
        b11.put("transfer_id", str);
        b11.put("transfer_channel_info", l.f55892a.a());
        g.f(g.f56093a, a() + " --> reportServerSendFileClick() --> map = " + b11, false, 2, null);
        c(b11);
    }
}
